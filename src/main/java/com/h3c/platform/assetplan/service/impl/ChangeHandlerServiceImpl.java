package com.h3c.platform.assetplan.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.h3c.platform.assetplan.dao.AssetPlanInfoMapper;
import com.h3c.platform.assetplan.dao.DeptInfoMapper;
import com.h3c.platform.assetplan.entity.AssetPlanInfo;
import com.h3c.platform.assetplan.entity.AssetPlanInfoAll;
import com.h3c.platform.assetplan.entity.AssetPlanInfoSearchView;
import com.h3c.platform.assetplan.entity.DeptInfo;
import com.h3c.platform.assetplan.entity.ProcessRecordInfo;
import com.h3c.platform.assetplan.entity.SearchAssetParamEntity;
import com.h3c.platform.assetplan.service.AssetPlanInfoSearchService;
import com.h3c.platform.assetplan.service.AssetPlanInfoService;
import com.h3c.platform.assetplan.service.ChangeHandlerService;
import com.h3c.platform.assetplan.service.DeptInfoService;
import com.h3c.platform.assetplan.service.ProcessRecordInfoService;
import com.h3c.platform.common.service.MailInfoService;
import com.h3c.platform.response.ResponseResult;
import com.h3c.platform.sysmgr.entity.UserInfo;
import com.h3c.platform.sysmgr.service.RoleService;
import com.h3c.platform.sysmgr.service.UserService;
import com.h3c.platform.util.UserUtils;

@Service
public class ChangeHandlerServiceImpl implements ChangeHandlerService {
	
	@Autowired
	private AssetPlanInfoService assetPlanInfoService;
	@Autowired
	private AssetPlanInfoMapper assetPlanInfoMapper;
	@Autowired
	private ProcessRecordInfoService  processRecordInfoService;
	@Autowired
	private UserService userService;
	@Autowired
	private MailInfoService  mailInfoService;
	
	@Value("${spring.remindEmailForReview.url}")
    private  String remindEmailForReview ;
	@Value("${spring.remindEmailForDept3.url}")
    private  String remindEmailForDept3 ;
	@Value("${spring.remindEmailForDept2.url}")
    private  String remindEmailForDept2 ;
	@Value("${spring.remindEmailForPlanner.url}")
    private  String remindEmailForPlanner ;
	@Value("${spring.remindEmailForOQ.url}")
    private  String remindEmailForOQ ;
	@Value("${spring.remindEmailForDept1.url}")
    private  String remindEmailForDept1 ;
	
	/**
	 * 转单  isAdmin：标记是否是管理员转单  true 是
	 * 规范性审核特殊chul
	 */ 
	@Override
	@Transactional
	public ResponseResult changeHandler(String handler,String apstage,String applymonth,String newHandler,boolean isAdmin) throws Exception {
		List<String> sendTo =new ArrayList<>();
		List<String> ccTo =new ArrayList<>();
		List<String> beforeHandler=new ArrayList<>();
		String url="";
		String process="";
		if(StringUtils.isBlank(newHandler)) {
			return ResponseResult.fail("转单人人不能为空！");
		}
		if(StringUtils.isBlank(handler)) {
			return ResponseResult.fail("处理人不能为空！");
		}
		List<ProcessRecordInfo> lstRecord=new ArrayList<>();
		Map<String, Object> param = new HashMap<>();
		param.put("APStage", apstage);
		if(!isAdmin) {
			param.put("ApplyMonth", applymonth);
		}
		
		param.put("value", newHandler);
		param.put("modifier", UserUtils.getCurrentUserId());
		switch (apstage) {
		case "2":
			param.put("Reviewer",handler);	
			param.put("column","ReviewPerson");	
			url=remindEmailForReview+applymonth;
			process="规范审核";
			break;
		case "3":
			param.put("Dept3Manager",handler);	
			param.put("ReviewResult","1");
			param.put("column","Dept3Manager");	
			url=remindEmailForDept3+applymonth;
			process="三级部门主管审核";
			break;
		case "4":
			param.put("Dept2Manager",handler);		
			param.put("ReviewResult","1");
			param.put("column","Dept2Manager");	
			url=remindEmailForDept2+applymonth;
			process="二级部门主管审核";
			break;
		case "5":
			param.put("Planner",handler);	
			param.put("ReviewResult","1");
			param.put("column","Planner");	
			url=remindEmailForPlanner+applymonth;
			process="计划员审核";
			break;
		case "6":
			param.put("OQDeptReviewer",handler);
			param.put("ReviewResult","1");
			param.put("column","OQDeptReviewer");	
			url=remindEmailForOQ+applymonth;
			process="专家团审核";
			break;
		case "7":
			param.put("Dept1Reviewer",handler);	
			param.put("ReviewResult","1");
			param.put("column","Dept1Reviewer");
			url=remindEmailForDept1+applymonth;
			process="一级部门主管审核";
			break;
		default:
			break;
		}
		List<AssetPlanInfo> lst= assetPlanInfoMapper.getToDoListByUser(param);
		
		for(AssetPlanInfo info : lst) {
			ProcessRecordInfo record= new ProcessRecordInfo();
			record.setAssetplanid(info.getAssetplanid());
			record.setApstage(apstage);
			record.setCurrentperson(getHandler(apstage,info));
			record.setNewperson(newHandler);
			record.setCreator(UserUtils.getCurrentUserId());
			record.setCreatetime(new Date());
			lstRecord.add(record);
			
			//新处理人
			sendTo.add(newHandler);
			//原处理人
			ccTo.add(getHandler(apstage,info));
			//当前操作人（管理员转单会存在，其他环节转单和原处理人一样）
			ccTo.add(UserUtils.getCurrentUserId());
			//原处理人
			beforeHandler.add(getHandler(apstage,info));
			
		}

		assetPlanInfoMapper.changeHandler(param);
		if(CollectionUtils.isNotEmpty(lstRecord)) {
			processRecordInfoService.saveRecord(lstRecord);
		}
		
		//发起工作委托后，请邮件通知被委托人，同时抄送原审批人和操作人（若为管理员操作即存在）
		//去重
		sendTo = removeDuplicate(sendTo);
		ccTo = removeDuplicate(ccTo);
		beforeHandler = removeDuplicate(beforeHandler);
		List<String> beforeHandlerName=new ArrayList<>();
		for (int i = 0; i < beforeHandler.size(); i++) {
			UserInfo user = userService.getUserByEmpCode(beforeHandler.get(i));
			beforeHandlerName.add(user.getEmpName());
		}
		for (int j = 0; j < sendTo.size(); j++) {
			if(isAdmin) {
				mailInfoService.sendRemindMailForWork(String.join(",", sendTo.get(j)), String.join(",", ccTo), String.join(",", beforeHandlerName), process, "");
			}else {
				mailInfoService.sendRemindMailForWork(String.join(",", sendTo.get(j)), String.join(",", ccTo), String.join(",", beforeHandlerName), process, url);
			}
		}
		
		return ResponseResult.success("转单成功！");
	}
	
	private static String getHandler(String apstage,AssetPlanInfo info) {
		String handler="";
		switch (apstage) {
		case "2":
			handler = info.getReviewer();
			break;
		case "3":
			handler = info.getDept3manager();
			break;
		case "4":
			handler = info.getDept2manager();
			break;
		case "5":
			handler = info.getPlanner();
			break;
		case "6":
			handler = info.getOqdeptreviewer();
			break;
		case "7":
			handler = info.getDept1reviewer();
			break;
		default:
			break;
		}
		
		return handler;
	}
	
	/**
	 * 获取分页数据
	 */
	public ResponseResult list(String userCode,int pageSize,int pageNum)throws Exception {
		//PageHelper.startPage(pageNum,pageSize);
		com.github.pagehelper.page.PageMethod.startPage(pageNum,pageSize);
		List<AssetPlanInfo>lst =assetPlanInfoMapper.getAdminChangeHandlerList(userCode);
		
		PageInfo<AssetPlanInfo> pageInfo=new PageInfo<>(lst);
		
		return ResponseResult.success(0, "查询成功", pageNum, pageInfo.getTotal(), null, pageInfo.getList());
	}
	
	//通过HashSet踢除重复元素
    public static List removeDuplicate(List list) {   
        HashSet h = new HashSet(list);   
        list.clear();   
        list.addAll(h);   
        return list;   
    }
}
