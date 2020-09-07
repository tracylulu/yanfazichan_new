package com.h3c.platform.assetplan.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
import com.eos.common.constant.StatusCodeEnum;
import com.eos.common.util.Result;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.h3c.platform.annotation.UserLoginToken;
import com.h3c.platform.assetplan.dao.AssetPlanInfoMapper;
import com.h3c.platform.assetplan.dao.RequestsNumApproveRecordMapper;
import com.h3c.platform.assetplan.entity.AssetInfoSubmitEntity;
import com.h3c.platform.assetplan.entity.AssetInfoUpdateEntity;
import com.h3c.platform.assetplan.entity.AssetInfoUpdateEntityForDept3AndOther;
import com.h3c.platform.assetplan.entity.AssetPlanGlobalInfo;
import com.h3c.platform.assetplan.service.AssetPlanInfoService;
import com.h3c.platform.common.commonconst.DicConst;
import com.h3c.platform.common.commonconst.LogType;
import com.h3c.platform.common.service.MailInfoService;
import com.h3c.platform.common.service.SysDicInfoService;
import com.h3c.platform.response.ResponseResult;
import com.h3c.platform.sysmgr.entity.UserInfo;
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
	
	@Value("${spring.remindEmailForPlanner.url}")
    private  String remindEmailForPlanner ;
	
	@ApiOperation(value="展示二级主管审核列表信息")
   	@GetMapping("/getDept2InfoList")
   	@ResponseBody
   	@UserLoginToken
   	public ResponseResult getDept2InfoList(@RequestParam @ApiParam(name="dept2Manager",value="二级主管审核环节处理人",required=true)String dept2Manager,
   			@RequestParam @ApiParam(name="apstage",value="物品所处的二级主管审核阶段",required=true)String apstage,
   			@RequestParam @ApiParam(name="applymonth",value="申请月份",required=true)String applymonth) throws Exception{
		//封装返回数据的表头信息
		List<Map<String, Object>> columnList = sysDicInfoService.getColumn(DicConst.ASSETPLANINFODEPT2VIEW);
			
		Map<String, Object> param = new HashMap<>();
		JSONArray arrayData = new JSONArray();
		param.put("Dept2Manager",dept2Manager);
		param.put("APStage",apstage);
		param.put("ApplyMonth",applymonth);
		
		Map<String, Object> param1 = new HashMap<>();
		param1.put("Dept2Manager",dept2Manager);
		param1.put("Dept2Code",null);
		param1.put("APStage",apstage);
		param1.put("ApplyMonth",applymonth);
		
		if(StringUtils.isNotBlank(dept2Manager)){
			if(StringUtils.isNotBlank(apstage) && apstage.contains("4")) {
				List<AssetPlanInfoAll> dept2InfoList = assetPlanInfoService.listofDept2Detail(param);
				Optional<AssetPlanInfoAll> optional = dept2InfoList.stream().filter(o->StringUtils.isBlank(o.getExpensetype())).findAny();
   				if(optional.isPresent()) {
   					return ResponseResult.fail(false, "有条目的预算类型为空，请检查数据");
   				}
				Map<String, List<AssetPlanInfoAll>> collect = dept2InfoList.stream().collect(Collectors.groupingBy(AssetPlanInfoAll::getExpensetype));
				collect = collect.entrySet().stream().sorted(Map.Entry.<String, List<AssetPlanInfoAll>>comparingByKey().reversed()).collect(
   		                Collectors.toMap(
   		                     Map.Entry::getKey, 
   		                     Map.Entry::getValue,
   		                     (oldVal, newVal) -> oldVal,
   		                     LinkedHashMap::new
   		                 )
   		         );
				for(String key:collect.keySet()) {
					JSONObject json=new JSONObject();
					List<AssetPlanInfoAll> list = collect.get(key);
   	   				param.put("ExpenseType",key);
   	   				param1.put("ExpenseType",key);
					//申购金额合计  totalmoneySum
					String totalmoneySum = assetPlanInfoService.getSumTotalMoneyForDept2(param1);
   					//同意申购金额合计  ActualMoneySum
   					String actualMoneySum = assetPlanInfoService.getSumActualMoneySumForDept2(param);
   					if("2".equals(key)) {
	   					//groupName
   						json.put("GroupName", "CAPEX资产类计划");
	   				}else {
	   					//groupName
   						json.put("GroupName", "费用类计划");
	   				}
   					json.put("TotalmoneySum",new BigDecimal(totalmoneySum));
   					json.put("ActualMoneySum",new BigDecimal(actualMoneySum));
   					//数据集list
   					json.put("DataSet" , list);
   					arrayData.add(json);	
				}
				return ResponseResult.success(0, "查询成功", 0, dept2InfoList.size(), columnList, arrayData);
				/*if(dept2InfoList.size()>0) {
					//申购金额合计  totalmoneySum
					String totalmoneySum = assetPlanInfoService.getSumTotalMoneyForDept2(param1);
   					//同意申购金额合计  ActualMoneySum
   					String actualMoneySum = assetPlanInfoService.getSumActualMoneySumForDept2(param);
   					json.put("TotalmoneySum",new BigDecimal(totalmoneySum));
   					json.put("ActualMoneySum",new BigDecimal(actualMoneySum));
   					//数据集list
   					json.put("DataSet" ,  dept2InfoList);
   					arrayData.add(json);	
   					return ResponseResult.success(0, "查询成功", 0, dept2InfoList.size(), columnList, arrayData);
				}else {
					return ResponseResult.success(0, "查询成功", 0, dept2InfoList.size(), columnList, arrayData);
				}*/
			}else {
				return ResponseResult.fail(false, "查询失败，审核阶段不匹配");
			}
		}else {
			return ResponseResult.fail(false, "查询失败，人员不匹配");
		}
   	}
	
  
	@ApiOperation(value="二级部门审核页面提交至计划员审核")
   	@PostMapping("/submitInfoFromDept2ToPlanner")
   	@ResponseBody
   	@UserLoginToken(logType=LogType.MODIFY)
   	public ResponseResult submitInfoFromDept2ToPlanner(@RequestBody AssetInfoSubmitEntity submitEntity) throws Exception{
			String nextHandlePerson="";	
			String applymonth = submitEntity.getApplymonth();
   			String applyuser = submitEntity.getApplyuser();
   			List<String> sendToPlanner =new ArrayList<>();
   			//List<String> sendToPlannerForJHN =new ArrayList<>();
   			//List<String> sendToPlannerForJHW =new ArrayList<>();
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
   			List<AssetPlanInfo> newLstEndAssetPlanInfo = new ArrayList<>();
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
   					newLstEndAssetPlanInfo.add(ap);
   					/*List<String> sendTo =new ArrayList<>();
   					List<String> ccTo =new ArrayList<>();
   					String url="";
   					//若有申请人的统一申购数量修改成0，邮件主送申请人抄送申购人，告知信息和审批意见。
   					sendTo.add(ap.getApplyuser());
   					ccTo.add(ap.getRequireduser());
   					//mailInfoService.sendRemindMail(sendTo.toString(), ccTo.toString(), "二级部门主管审核", url);
   					mailInfoService.sendProcessEndMail(String.join(",", sendTo), String.join(",", ccTo), url);*/
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
   					UserInfo userByEmpCode = userService.getUserByEmpCode(planner);
	   				nextHandlePerson=userByEmpCode.getEmpName()+" "+userByEmpCode.getEmpCode();
   				}else {
   					return ResponseResult.fail(false, "无审批人信息，请联系系统管理员！");
   				}
   				
   				//计划外单子审批完就发邮件提醒下一环节审批，计划内的走定时邮件就行了。
   				if(ap.getAbnormalplanenum()==0) {
   					//数量改为0的不要给下一环节审批人发邮件了
   					if(ap.getRequiredsaudit()==0) {
   					}else {
   						sendToPlanner.add(planner);
   					}
   				//计划外
   				}else {
   					//数量改为0的不要给下一环节审批人发邮件了
   					if(ap.getRequiredsaudit()==0) {
   					}else {
   						sendToPlanner.add(planner);
   					}
   				}
   				
   				ap.setDept2checktime(new Date());
   				//设置计划员审批页面默认的评审意见为同意，前台展示使用（同意，不同意）
	   			ap.setPlannernote("同意");
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
			String url=remindEmailForPlanner+applymonth;
			//去重后的计划员code
			/*sendToPlannerForJHW = removeDuplicate(sendToPlannerForJHW);
			for (int j = 0; j < sendToPlannerForJHW.size(); j++) {
				mailInfoService.sendDeptMgnMail(String.join(",", sendToPlannerForJHW.get(j)), "", "计划员审核", false,4,url);
			}
			//计划员内的单子，邮件通知计划员审核
			sendToPlannerForJHN = removeDuplicate(sendToPlannerForJHN);
			for (int j = 0; j < sendToPlannerForJHN.size(); j++) {
				mailInfoService.sendDeptMgnMail(String.join(",", sendToPlannerForJHN.get(j)), "", "计划员审核", true,4,url);
			}*/
   			//二级提交发邮件给计划员，不需要加时间的模板的。
			sendToPlanner = removeDuplicate(sendToPlanner);
			for (int j = 0; j < sendToPlanner.size(); j++) {
				mailInfoService.sendRemindMail(String.join(",", sendToPlanner.get(j)), "", "计划员审核", url);
			}
			
			//数量改为0的按照申请人和申购人分组发送邮件（相同的申购人和申请人，发送一封邮件就可以了）
   			Map<String, List<AssetPlanInfo>> collect = newLstEndAssetPlanInfo.stream().collect(Collectors.groupingBy(e->fetchGroupKey(e)));
   			for(String key:collect.keySet()) {
   				List<AssetPlanInfo> lstTemp=collect.get(key);
   				List<String> sendToEnd =new ArrayList<>();
   				List<String> ccToEnd =new ArrayList<>();
   				sendToEnd.add(lstTemp.get(0).getApplyuser());
   				ccToEnd.add(lstTemp.get(0).getRequireduser());
   				mailInfoService.sendProcessEndMail(String.join(",", sendToEnd), String.join(",", ccToEnd), "");
   			}
			
   			if(flag) {
   				return ResponseResult.success(true, "存在审批超时记录，请联系管理员激活！");
   			}else {
   				return ResponseResult.success(true, "已成功提交至"+nextHandlePerson+"审批");
   			}
   	}
    
	private static String fetchGroupKey(AssetPlanInfo e) {
		return e.getApplyuser() +"#"+ e.getRequireduser();
	}
	
	@ApiOperation(value="二级部门页面修改同意申购数量和审核意见")
   	@PutMapping("/updateDept2InfoList")
   	@ResponseBody
   	@UserLoginToken(logType=LogType.MODIFY)
   	public ResponseResult updateDept2InfoList(@RequestBody AssetInfoUpdateEntityForDept3AndOther updateEntity) throws Exception{
			List<Integer> assetplanidList = updateEntity.getAssetplanid();
			for (int i = 0; i < assetplanidList.size(); i++) {
				AssetPlanInfo ap = assetPlanInfoMapper.selectByPrimaryKey(assetplanidList.get(i));
				//同意申购数量
				ap.setRequiredsaudit((updateEntity.getRequiredsaudit().get(i)));
				//评审后总金额
				ap.setActualmoney(updateEntity.getActualmoney().get(i));
				//审核意见
				ap.setDept2checknote(updateEntity.getDept2checknote().get(i));
				ap.setModifier(UserUtils.getCurrentUserId());
				ap.setModifitime(new Date());
			
				//数量修改完后对相关联的表RequestsNumApproveRecord进行Dept2managercount字段的更新
				RequestsNumApproveRecord numApproveRecord = recordMapper.selectByPrimaryKey(assetplanidList.get(i));
				Integer requiredsaudit = updateEntity.getRequiredsaudit().get(i);
				numApproveRecord.setDept2managercount(requiredsaudit);
				recordMapper.updateByPrimaryKey(numApproveRecord);
				
				this.assetPlanInfoService.editAssetPlanInfo(ap);
			}
			return ResponseResult.success(true,"修改成功");
	}
    
	//通过HashSet踢除重复元素
    public static List removeDuplicate(List list) {   
        HashSet h = new HashSet(list);   
        list.clear();   
        list.addAll(h);   
        return list;   
    } 
	
	
}
