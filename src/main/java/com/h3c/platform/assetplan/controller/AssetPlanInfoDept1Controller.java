package com.h3c.platform.assetplan.controller;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
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

import com.h3c.platform.annotation.UserLoginToken;
import com.h3c.platform.assetplan.dao.AssetPlanInfoMapper;
import com.h3c.platform.assetplan.dao.RequestsNumApproveRecordMapper;
import com.h3c.platform.assetplan.entity.AssetInfoSubmitEntity;
import com.h3c.platform.assetplan.entity.AssetInfoUpdateEntity;
import com.h3c.platform.assetplan.entity.AssetInfoUpdateEntityForDept3AndOther;
import com.h3c.platform.assetplan.entity.AssetPlanInfo;
import com.h3c.platform.assetplan.entity.AssetPlanInfoAll;
import com.h3c.platform.assetplan.entity.AssetPlanInfoDept1View;
import com.h3c.platform.assetplan.entity.AssetPlanInfoOQDeptView;
import com.h3c.platform.assetplan.entity.AssetPlanInfoPlannerView;
import com.h3c.platform.assetplan.entity.RequestsNumApproveRecord;
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
@RequestMapping("/assetplan/dept1")
@Api(value = "一级部门审核页面相关接口",tags = {"一级部门审核页面相关接口"})
@CrossOrigin
public class AssetPlanInfoDept1Controller {

	@Autowired
	private AssetPlanInfoService assetPlanInfoService;
	@Autowired
	private AssetPlanInfoMapper assetPlanInfoMapper;
	@Autowired
	private RequestsNumApproveRecordMapper recordMapper;
	@Autowired
	private MailInfoService  mailInfoService;
	@Autowired
	private UserService userService;
	@Autowired
	private SysDicInfoService sysDicInfoService;
	
	@ApiOperation(value="展示一级部门审核列表信息")
	@PostMapping("/getDept1InfoList")
   	@ResponseBody
   	@UserLoginToken
   	public ResponseResult getDept1InfoList(@RequestParam @ApiParam(name="dept1Reviewer",value="一级部门审核环节处理人",required=true)String dept1Reviewer,
   			@RequestParam @ApiParam(name="apstage",value="物品所处的一级部门审核阶段",required=true)String apstage,
   			@RequestParam @ApiParam(name="applymonth",value="申请月份",required=true)String applymonth) throws Exception{
   		//try {
   			//封装返回数据的表头信息
   			List<Map<String, Object>> columnList = sysDicInfoService.getColumn(DicConst.ASSETPLANINFODEPT1VIEW);
   			if(StringUtils.isNotBlank(dept1Reviewer)){
					JSONArray arrayData = new JSONArray();
	   				Map<String, Object> param = new HashMap<>();
	   				param.put("Dept1Reviewer",dept1Reviewer);
   					param.put("ApplyMonth",applymonth);
	   				List<Integer> flag = assetPlanInfoService.getDept1ListForFlag(param);
	   				int listSize=assetPlanInfoService.getDept1ListSize(param);
	   				for (int i = 0; i < flag.size(); i++) {
	   					JSONObject json=new JSONObject();
	   					param.put("GroupFlag",flag.get(i));
	   					List<AssetPlanInfoAll> listofDept1Detail = assetPlanInfoService.listofDept1Detail(param);
	   					if(!listofDept1Detail.isEmpty()) {
	   						String groupflagdetail = listofDept1Detail.get(0).getGroupflagdetail();
	   						Map<String,Object> groupMess = assetPlanInfoService.getDept1GroupMess(param);
	   						DecimalFormat df = new DecimalFormat("0.00");
	   						BigDecimal  requireds = (BigDecimal) groupMess.get("Requireds");
	   						BigDecimal  requiredsAudit = (BigDecimal) groupMess.get("RequiredsAudit");
	   						BigDecimal  totalmoneySum = (BigDecimal) groupMess.get("TotalmoneySum");
	   						String totalmoneySumStr = df.format(totalmoneySum);
	   						BigDecimal  actualmoneySum =(BigDecimal) groupMess.get("ActualmoneySum");
	   						String actualmoneySumStr = df.format(actualmoneySum);
	   						//groupName
	   						json.put("GroupName", groupflagdetail);
	   		   				//申报数量合计 dept2managercountSum
	   		   				json.put("Requireds",requireds);
	   		   				//评审后数量合计 plannercountSum
	   		   				json.put("RequiredsAudit", requiredsAudit);
	   		   				//申购金额合计  totalmoneySum
	   		   				json.put("TotalmoneySum",totalmoneySumStr);
	   		   				//评审后金额合计  actualmoneySum
	   		   				json.put("ActualmoneySum",actualmoneySumStr);
	   		   				//数据集
	   		   				json.put("DataSet" , listofDept1Detail);
	   		   				arrayData.add(json);				
	   					}
	   				}
					return ResponseResult.success(0, "查询成功", 0, listSize, columnList, arrayData);
			}else {
				return ResponseResult.fail(false, "查询失败，人员信息错误");
			}
   		/*} catch (Exception e) {
   			e.printStackTrace();
   			return ResponseResult.fail(false, "查询失败");
   		}*/
   	}
	
  
	@ApiOperation(value="一级部门审核页面同意后结束审批后归档")
   	@PostMapping("/agree")
   	@ResponseBody
   	@UserLoginToken(logType=LogType.MODIFY)
   	public ResponseResult agree(@RequestBody AssetInfoSubmitEntity submitEntity) throws Exception{
   		//try {
   			String applymonth = submitEntity.getApplymonth();
   			String applyuser = submitEntity.getApplyuser();
   			
   			List<Integer> newLstsubmitID =new ArrayList<>();
   			Map<String,Object> param=new HashMap<>();
   			param.put("GroupFlag",null);
			param.put("Dept1Reviewer",applyuser);
			param.put("ApplyMonth",applymonth);
			List<AssetPlanInfoAll> listofDept1Detail = assetPlanInfoService.listofDept1Detail(param);
   			//当前环节该登录人所有待提交的单子
   			for (int i = 0; i < listofDept1Detail.size(); i++) {
   				newLstsubmitID.add(listofDept1Detail.get(i).getAssetplanid());
			}
   			//把所有同意数量修改为0的单子的状态置为已结束，其他的状态为提交下一环节
   			List<AssetPlanInfo> lst=new ArrayList<>();
   			for (int j = 0; j < newLstsubmitID.size(); j++) {
   				AssetPlanInfo ap = assetPlanInfoMapper.selectByPrimaryKey(newLstsubmitID.get(j));
   				if(ap.getRequiredsaudit()==0) {
   					ap.setApstatus("07");
   					ap.setApstage("0");
   				}else {
   					ap.setApstatus("0");
   					ap.setApstage("0");
	   			}
   				ap.setModifier(applyuser);
   				ap.setModifitime(new Date());
   				ap.setDept1reviewtime(new Date());
   				lst.add(ap);
   			}
   			assetPlanInfoService.batchEditAssetPlanInfo(lst);
   			
   			for (int k = 0; k < newLstsubmitID.size(); k++) {
				AssetPlanInfo ap = assetPlanInfoMapper.selectByPrimaryKey(newLstsubmitID.get(k));
				Integer requiredsaudit = ap.getRequiredsaudit();
				RequestsNumApproveRecord numApproveRecord = recordMapper.selectByPrimaryKey(newLstsubmitID.get(k));
				numApproveRecord.setDept1reviewercount(requiredsaudit);
				recordMapper.updateByPrimaryKey(numApproveRecord);
			
				//将审批结束的信息邮件主送申请人抄送申购人，告知审批结果。
				List<String> sendToEnd =new ArrayList<>();
				List<String> ccToEnd =new ArrayList<>();
				sendToEnd.add(ap.getApplyuser());
				ccToEnd.add(ap.getRequireduser());
				//mailInfoService.sendRemindMail(sendToEnd.toString(), ccToEnd.toString(), "一级部门审核环节归档", "");
				mailInfoService.sendProcessEndMail(String.join(",", sendToEnd), String.join(",", ccToEnd), "");
				
   			}
   			return ResponseResult.success(true, "提交成功");
   		/*} catch (Exception e) {
   			e.printStackTrace();
   			return ResponseResult.fail(false, "提交失败");
   		}*/
   	}
	
	@ApiOperation(value="一级部门审核页面不同意后结束审批后归档，数量改为0")
	@PostMapping("/unagree")
   	@ResponseBody
   	@UserLoginToken(logType=LogType.MODIFY)
   	public ResponseResult unAgree(@RequestBody AssetInfoSubmitEntity submitEntity) throws Exception{
   		//try {
   			String applymonth = submitEntity.getApplymonth();
   			String applyuser = submitEntity.getApplyuser();
   			
   			List<Integer> newLstsubmitID =new ArrayList<>();
   			Map<String,Object> param=new HashMap<>();
   			param.put("GroupFlag",null);
			param.put("Dept1Reviewer",applyuser);
			param.put("ApplyMonth",applymonth);
			List<AssetPlanInfoAll> listofDept1Detail = assetPlanInfoService.listofDept1Detail(param);
   			//当前环节该登录人所有待提交的单子
   			for (int i = 0; i < listofDept1Detail.size(); i++) {
   				newLstsubmitID.add(listofDept1Detail.get(i).getAssetplanid());
			}
   			//把所有同意数量修改为0的单子的状态置为已结束，其他的状态为提交下一环节
   			List<AssetPlanInfo> lst=new ArrayList<>();
   			for (int j = 0; j < newLstsubmitID.size(); j++) {
   				AssetPlanInfo ap = assetPlanInfoMapper.selectByPrimaryKey(newLstsubmitID.get(j));
   				//同意申购数量
				ap.setRequiredsaudit(0);
				//评审后总金额
				ap.setActualmoney(new BigDecimal(0));
				ap.setApstatus("07");
				ap.setApstage("0");
   				ap.setModifier(applyuser);
   				ap.setModifitime(new Date());
   				ap.setDept1reviewtime(new Date());
   				lst.add(ap);
   			}
   			assetPlanInfoService.batchEditAssetPlanInfo(lst);
   			
   			for (int k = 0; k < newLstsubmitID.size(); k++) {
				AssetPlanInfo ap = assetPlanInfoMapper.selectByPrimaryKey(newLstsubmitID.get(k));
				Integer requiredsaudit = ap.getRequiredsaudit();
				RequestsNumApproveRecord numApproveRecord = recordMapper.selectByPrimaryKey(newLstsubmitID.get(k));
				numApproveRecord.setDept1reviewercount(requiredsaudit);
				recordMapper.updateByPrimaryKey(numApproveRecord);
			
				//将审批结束的信息邮件主送申购人抄送申请人，告知审批结果。
				List<String> sendToEnd =new ArrayList<>();
				List<String> ccToEnd =new ArrayList<>();
				sendToEnd.add(ap.getRequireduser());
				ccToEnd.add(ap.getApplyuser());
				//mailInfoService.sendRemindMail(sendToEnd.toString(), ccToEnd.toString(), "一级部门审核环节归档", "");
				mailInfoService.sendProcessEndMail(String.join(",", sendToEnd), String.join(",", ccToEnd), "");
   			}
   			return ResponseResult.success(true, "提交成功");
   		/*} catch (Exception e) {
   			e.printStackTrace();
   			return ResponseResult.fail(false, "提交失败");
   		}*/
   	}
    
	@ApiOperation(value="一级部门审核页面修改同意申购数量和审核意见")
   	@PutMapping("/updateDept1InfoList")
   	@ResponseBody
   	@UserLoginToken(logType=LogType.MODIFY)
   	public ResponseResult updateDept1InfoList(@RequestBody AssetInfoUpdateEntityForDept3AndOther updateEntity) throws Exception{
			List<Integer> assetplanidList = updateEntity.getAssetplanid();
			for (int i = 0; i < assetplanidList.size(); i++) {
				AssetPlanInfo ap = assetPlanInfoMapper.selectByPrimaryKey(assetplanidList.get(i));
				//同意申购数量
				ap.setRequiredsaudit((updateEntity.getRequiredsaudit().get(i)));
				//评审后总金额
				ap.setActualmoney(updateEntity.getActualmoney().get(i));
				//审核意见
				ap.setDept1reviewnote(updateEntity.getDept1reviewnote().get(i));
				ap.setModifier(UserUtils.getCurrentUserId());
				ap.setModifitime(new Date());
				
				//数量修改完后对相关联的表RequestsNumApproveRecord进行Dept1reviewercount字段的更新
				RequestsNumApproveRecord numApproveRecord = recordMapper.selectByPrimaryKey(assetplanidList.get(i));
				Integer requiredsaudit = updateEntity.getRequiredsaudit().get(i);
				numApproveRecord.setDept1reviewercount(requiredsaudit);
				recordMapper.updateByPrimaryKey(numApproveRecord);
				
				this.assetPlanInfoService.editAssetPlanInfo(ap);
			}
			return ResponseResult.success(true,"修改成功");
	}
    
	
}
