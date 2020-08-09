package com.h3c.platform.assetplan.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.h3c.platform.response.ResponseResult;
import com.h3c.platform.sysmgr.service.RoleService;
import com.h3c.platform.util.UserUtils;

@Service
public class ChangeHandlerServiceImpl implements ChangeHandlerService {
	
	@Autowired
	private AssetPlanInfoService assetPlanInfoService;
	@Autowired
	private AssetPlanInfoMapper assetPlanInfoMapper;
	@Autowired
	private ProcessRecordInfoService  processRecordInfoService;

	/**
	 * 转单
	 */
	@Override
	@Transactional
	public ResponseResult changeHandler(String handler,String apstage,String applymonth,String newHandler) throws Exception {
		List<ProcessRecordInfo> lstRecord=new ArrayList<ProcessRecordInfo>();
		Map<String, Object> param = new HashMap<>();
		param.put("APStage", apstage);
		if(StringUtils.isNotBlank(applymonth)) {
			param.put("ApplyMonth", applymonth);
		}
		
		param.put("value", newHandler);
		param.put("modifier", UserUtils.getCurrentUserId());
		switch (apstage) {
		case "2":
			param.put("Reviewer",handler);	
			param.put("column","Reviewer");	
			break;
		case "3":
			param.put("Dept3Manager",handler);	
			param.put("ReviewResult","1");
			param.put("column","Dept3Manager");	
			break;
		case "4":
			param.put("Dept2Manager",handler);		
			param.put("ReviewResult","1");
			param.put("column","Dept2Manager");	
			break;
		case "5":
			param.put("Planner",handler);	
			param.put("ReviewResult","1");
			param.put("column","Planner");	
			break;
		case "6":
			param.put("OQDeptReviewer",handler);
			param.put("ReviewResult","1");
			param.put("column","OQDeptReviewer");	
			break;
		case "7":
			param.put("Dept1Reviewer",handler);	
			param.put("ReviewResult","1");
			param.put("column","Dept1Reviewer");	
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
		}

		assetPlanInfoMapper.changeHandler(param);
		processRecordInfoService.saveRecord(lstRecord);
		
		return ResponseResult.success("转单成功！");
	}
	
	private String getHandler(String apstage,AssetPlanInfo info) {
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
		PageHelper.startPage(pageNum,pageSize);
		List<AssetPlanInfo>lst =assetPlanInfoMapper.getAdminChangeHandlerList(userCode);
		
		PageInfo<AssetPlanInfo> pageInfo=new PageInfo<AssetPlanInfo>(lst);
		
		return ResponseResult.success(0, "查询成功", pageNum, pageInfo.getTotal(), null, pageInfo.getList());
	}
}
