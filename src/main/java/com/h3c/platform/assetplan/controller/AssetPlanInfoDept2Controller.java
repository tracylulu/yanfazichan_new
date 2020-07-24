package com.h3c.platform.assetplan.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.h3c.platform.assetplan.entity.AssetPlanInfo;
import com.h3c.platform.assetplan.entity.AssetPlanInfoAll;
import com.h3c.platform.assetplan.entity.AssetPlanInfoApplyView;
import com.h3c.platform.assetplan.entity.AssetPlanInfoDept2View;
import com.h3c.platform.assetplan.entity.AssetPlanInfoDept3View;
import com.h3c.platform.assetplan.entity.AssetPlanInfoHomePageView;
import com.h3c.platform.assetplan.entity.RequestsNumApproveRecord;
import com.eos.common.constant.AssetTableHeaderEnum;
import com.eos.common.constant.StatusCodeEnum;
import com.eos.common.util.Result;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.h3c.platform.annotation.UserLoginToken;
import com.h3c.platform.assetplan.dao.AssetPlanInfoMapper;
import com.h3c.platform.assetplan.dao.RequestsNumApproveRecordMapper;
import com.h3c.platform.assetplan.entity.AssetInfoSubmitEntity;
import com.h3c.platform.assetplan.entity.AssetInfoUpdateEntity;
import com.h3c.platform.assetplan.entity.AssetPlanGlobalInfo;
import com.h3c.platform.assetplan.service.AssetPlanInfoService;
import com.h3c.platform.common.commonconst.DicConst;
import com.h3c.platform.common.commonconst.LogType;
import com.h3c.platform.common.service.MailInfoService;
import com.h3c.platform.common.service.SysDicInfoService;
import com.h3c.platform.response.ResponseResult;
import com.h3c.platform.sysmgr.service.UserService;
import com.h3c.platform.util.UserUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

@Controller
@RequestMapping("/assetplan/dept2")
@Api(value = "二级主管审核页面相关接口",tags = {"二级主管审核页面相关接口"})
@CrossOrigin
public class AssetPlanInfoDept2Controller {

	@Autowired
	private AssetPlanInfoService assetPlanInfoService;
	@Autowired
	private RequestsNumApproveRecordMapper recordMapper;
	@Autowired
	private AssetPlanInfoMapper assetPlanInfoMapper;
	@Autowired
	private MailInfoService  mailInfoService;
	@Autowired
	private UserService userService;
	@Autowired
	private SysDicInfoService sysDicInfoService;
	
	@ApiOperation(value="展示二级主管审核列表信息")
   	@GetMapping("/getDept2InfoList")
   	@ResponseBody
   	@UserLoginToken
   	public ResponseResult getDept2InfoList(@RequestParam @ApiParam(name="dept2Manager",value="二级主管审核环节处理人",required=true)String dept2Manager,
   			@RequestParam @ApiParam(name="apstage",value="物品所处的二级主管审核阶段",required=true)String apstage,
   			@RequestParam @ApiParam(name="applymonth",value="申请月份",required=true)String applymonth,
   			@RequestParam @ApiParam(name="pageSize",value="每页行数",required=true)int pageSize,
   			@RequestParam @ApiParam(name="pageNum",value="页码",required=true)int pageNum) throws Exception{
		//try {
		//封装返回数据的表头信息
		List<Map<String, Object>> columnList = sysDicInfoService.getColumn(DicConst.ASSETPLANINFODEPT2VIEW);
			
		Map<String, Object> param = new HashMap<>();
		JSONArray arrayData = new JSONArray();
		JSONObject json=new JSONObject();
		param.put("Dept2Manager",dept2Manager);
		param.put("APStage",apstage);
		param.put("ApplyMonth",applymonth);
		
		if(StringUtils.isNotBlank(dept2Manager)){
			if(StringUtils.isNotBlank(apstage) && apstage.contains("4")) {
				PageHelper.startPage(pageNum, pageSize);
				List<AssetPlanInfoAll> dept2InfoList = assetPlanInfoService.listofDept2Detail(param);
				PageInfo<AssetPlanInfoAll> pageInfo = new PageInfo<AssetPlanInfoAll>(dept2InfoList);
				if(dept2InfoList.size()>0) {
					//申购金额合计  totalmoneySum
					String totalmoneySum = assetPlanInfoService.getSumTotalMoneyForDept2(param);
   					//同意申购金额合计  ActualMoneySum
   					String actualMoneySum = assetPlanInfoService.getSumActualMoneySumForDept2(param);
   					json.put("TotalmoneySum",new BigDecimal(totalmoneySum));
   					json.put("ActualMoneySum",new BigDecimal(actualMoneySum));
   					//数据集list
   					json.put("DataSet" ,  pageInfo.getList());
   					arrayData.add(json);	
   					return ResponseResult.success(0, "查询成功", pageNum, pageInfo.getTotal(), columnList, arrayData);
				}else {
					return ResponseResult.success(0, "查询成功", pageNum, pageInfo.getTotal(), columnList, arrayData);
				}
			}else {
				return ResponseResult.fail(false, "查询失败，审核阶段不匹配");
			}
	}else {
		return ResponseResult.fail(false, "查询失败，人员不匹配");
	}
			
		/*} catch (Exception e) {
			e.printStackTrace();
			return ResponseResult.fail(false, "查询失败");
		}*/
		
   	}
	
  
	@ApiOperation(value="二级部门审核页面提交至计划员审核")
   	@PostMapping("/submitInfoFromDept2ToPlanner")
   	@ResponseBody
   	@UserLoginToken(logType=LogType.MODIFY)
   	public ResponseResult submitInfoFromDept2ToPlanner(@RequestBody AssetInfoSubmitEntity submitEntity) throws Exception{
   		//try {
   			String applymonth = submitEntity.getApplymonth();
   			String applyuser = submitEntity.getApplyuser();
   			
   			List<String> sendToPlannerForJHW =new ArrayList<>();
   			List<Integer> newLstsubmitID =new ArrayList<>();
   			Map<String,Object> param=new HashMap<>();
   			param.put("Dept2Manager",applyuser);
			param.put("APStage","4");
			param.put("ApplyMonth",applymonth);
			List<AssetPlanInfoAll> dept2InfoList = assetPlanInfoService.listofDept2Detail(param);
			//当前环节该登录人所有待提交的单子
   			for (int i = 0; i < dept2InfoList.size(); i++) {
   				newLstsubmitID.add(dept2InfoList.get(i).getAssetplanid());
			}
   			//把所有同意数量修改为0的单子的状态置为已结束，其他的状态为提交下一环节
   			List<AssetPlanInfo> lst=new ArrayList<>();
   			boolean flag=false;
   			for (int j = 0; j < newLstsubmitID.size(); j++) {
   				AssetPlanInfo ap = assetPlanInfoMapper.selectByPrimaryKey(newLstsubmitID.get(j));
   				//超时，做下记录
   				if(ap.getOuttimeplanenum()==4) {
   					flag=true;
   					continue;
   				}
   				
   				if(ap.getRequiredsaudit()==0) {
   					ap.setApstatus("04");
   					ap.setApstage("0");
   					
   					List<String> sendTo =new ArrayList<>();
   					List<String> ccTo =new ArrayList<>();
   					String url="";
   					//若有申请人的统一申购数量修改成0，邮件主送申请人抄送申购人，告知信息和审批意见。
   					sendTo.add(ap.getApplyuser());
   					ccTo.add(ap.getRequireduser());
   					//mailInfoService.sendRemindMail(sendTo.toString(), ccTo.toString(), "二级部门主管审核", url);
   					mailInfoService.sendProcessEndMail(sendTo.toString(), ccTo.toString(), url);
   				}else {
   					ap.setApstatus("50");
   					ap.setApstage("5");
	   			}
   				ap.setModifier(applyuser);
   				ap.setModifitime(new Date());
   				//下一环节审批人
   				String planner = sysDicInfoService.getPlanner();
   				if(StringUtils.isNotBlank(planner)) {
   					ap.setPlanner(planner);
   				}else {
   					return ResponseResult.fail(false, "无审批人信息，请联系系统管理员！");
   				}
   				
   				//计划外单子审批完就发邮件提醒下一环节审批，计划内的走定时邮件就行了
   				if(ap.getAbnormalplanenum()==0) {
   				//计划外
   				}else {
   					sendToPlannerForJHW.add(planner);
   				}
   				
   				ap.setDept2checktime(new Date());
   				lst.add(ap);
   			}
   			assetPlanInfoService.batchEditAssetPlanInfo(lst);
   			for (int k = 0; k < newLstsubmitID.size(); k++) {
					AssetPlanInfo ap = assetPlanInfoMapper.selectByPrimaryKey(newLstsubmitID.get(k));
					Integer requiredsaudit = ap.getRequiredsaudit();
					RequestsNumApproveRecord numApproveRecord = recordMapper.selectByPrimaryKey(newLstsubmitID.get(k));
					numApproveRecord.setDept2managercount(requiredsaudit);
					//默认下一环节同意申购数量和本环节一样
					numApproveRecord.setPlannercount(requiredsaudit);
					recordMapper.updateByPrimaryKey(numApproveRecord);
			}

			//计划员外的单子，邮件通知计划员审核
			String url="";
			//去重后的计划员code
			sendToPlannerForJHW = removeDuplicate(sendToPlannerForJHW);
			for (int j = 0; j < sendToPlannerForJHW.size(); j++) {
				mailInfoService.sendRemindMail(sendToPlannerForJHW.toString(), "", "计划员审核", url);
			}
   			
   			
   			if(flag) {
   				return ResponseResult.success(true, "存在审批超时记录，请联系管理员激活！");
   			}else {
   				return ResponseResult.success(true, "提交成功");
   			}
   		/*} catch (Exception e) {
   			e.printStackTrace();
   			return ResponseResult.fail(false, "提交失败");
   		}*/
   	}
    
	@ApiOperation(value="二级部门页面修改同意申购数量和审核意见")
   	@PutMapping("/updateDept2InfoList")
   	@ResponseBody
   	@UserLoginToken(logType=LogType.MODIFY)
   	public ResponseResult updateDept2InfoList(@RequestBody AssetInfoUpdateEntity updateEntity) throws Exception{
		//try {
			List<Integer> assetplanidList = updateEntity.getAssetplanid();
			for (int i = 0; i < assetplanidList.size(); i++) {
				AssetPlanInfo ap = assetPlanInfoMapper.selectByPrimaryKey(assetplanidList.get(i));
				//同意申购数量
				ap.setRequiredsaudit((updateEntity.getRequiredsaudit().get(i)));
				//评审后总金额
				ap.setActualmoney(updateEntity.getActualmoney().get(i));
				//审核意见不是必填
				ap.setDept2checknote(updateEntity.getDept2checknote());
				ap.setModifier(ap.getDept2manager());
				ap.setModifitime(new Date());
			
				//数量修改完后对相关联的表RequestsNumApproveRecord进行Dept2managercount字段的更新
				RequestsNumApproveRecord numApproveRecord = recordMapper.selectByPrimaryKey(assetplanidList.get(i));
				Integer requiredsaudit = updateEntity.getRequiredsaudit().get(i);
				numApproveRecord.setDept2managercount(requiredsaudit);
				recordMapper.updateByPrimaryKey(numApproveRecord);
				
				this.assetPlanInfoService.editAssetPlanInfo(ap);
				
			}
			return ResponseResult.success(true,"修改成功");
		/*} catch (Exception e) {
			e.printStackTrace();
			return ResponseResult.fail(false,"修改失败");
		}*/
	}
    
	//通过HashSet踢除重复元素
    public static List removeDuplicate(List list) {   
        HashSet h = new HashSet(list);   
        list.clear();   
        list.addAll(h);   
        return list;   
    } 
	
	
}
