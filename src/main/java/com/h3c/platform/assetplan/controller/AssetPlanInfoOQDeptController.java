package com.h3c.platform.assetplan.controller;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

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

import com.h3c.platform.annotation.UserLoginToken;
import com.h3c.platform.assetplan.dao.AssetPlanInfoMapper;
import com.h3c.platform.assetplan.dao.DeptInfoMapper;
import com.h3c.platform.assetplan.dao.RequestsNumApproveRecordMapper;
import com.h3c.platform.assetplan.entity.AssetInfoSubmitEntity;
import com.h3c.platform.assetplan.entity.AssetInfoUpdateEntity;
import com.h3c.platform.assetplan.entity.AssetPlanInfo;
import com.h3c.platform.assetplan.entity.AssetPlanInfoAll;
import com.h3c.platform.assetplan.entity.AssetPlanInfoOQDeptView;
import com.h3c.platform.assetplan.entity.AssetPlanInfoPlannerView;
import com.h3c.platform.assetplan.entity.DeptInfo;
import com.h3c.platform.assetplan.entity.RequestsNumApproveRecord;
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
@RequestMapping("/assetplan/OQDept")
@Api(value = "专家团审核页面相关接口",tags = {"专家团审核页面相关接口"})
@CrossOrigin
public class AssetPlanInfoOQDeptController {

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
	@Autowired
	private DeptInfoMapper deptInfoMapper;
	
	@Value("${spring.remindEmailForDept1.url}")
    private  String remindEmailForDept1 ;
	
	@ApiOperation(value="展示专家团审核列表信息")
   	@PostMapping("/getOQDeptInfoList")
   	@ResponseBody
   	@UserLoginToken
   	public ResponseResult getOQDeptInfoList(@RequestParam @ApiParam(name="oqDeptReviewer",value="专家团审核环节处理人",required=true)String oqDeptReviewer,
   			@RequestParam @ApiParam(name="apstage",value="物品所处的专家团审核阶段",required=true)String apstage,
   			@RequestParam @ApiParam(name="applymonth",value="申请月份",required=true)String applymonth) throws Exception{
   		//try {
   			//封装返回数据的表头信息
   			List<Map<String, Object>> columnList = sysDicInfoService.getColumn(DicConst.ASSETPLANINFOOQDEPTVIEW);

   			if(StringUtils.isNotBlank(oqDeptReviewer)){
					JSONArray arrayData = new JSONArray();
					Map<String, Object> param = new HashMap<>();
					param.put("OQDeptReviewer",oqDeptReviewer);
   					param.put("ApplyMonth",applymonth);
   					List<Integer> flag= assetPlanInfoService.getOQDeptListForFlag(param);
	   				int listSize=assetPlanInfoService.getOQDeptListSize(param);
	   				for (int i = 0; i < flag.size(); i++) {
	   					JSONObject json=new JSONObject();
	   					param.put("GroupFlag",flag.get(i));
	   					List<AssetPlanInfoAll> listofOQDeptDetail = assetPlanInfoService.listofOqDeptDetail(param);
	   					if(!listofOQDeptDetail.isEmpty()) {
	   						String groupflagdetail = listofOQDeptDetail.get(0).getGroupflagdetail();
	   						Map<String,Object> groupMess = assetPlanInfoService.getOQDeptGroupMess(param);
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
	   		   				json.put("Requireds", requireds);
	   		   				//评审后数量合计 plannercountSum
	   		   				json.put("RequiredsAudit",requiredsAudit);
	   		   				//申购金额合计  totalmoneySum
	   		   				json.put("TotalmoneySum",totalmoneySumStr);
	   		   				//评审后金额合计  actualmoneySum
	   		   				json.put("ActualmoneySum",actualmoneySumStr);
	   		   				//数据集
	   		   				json.put("DataSet" , listofOQDeptDetail);
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
	
  
	@ApiOperation(value="专家团审核页面提交至一级部门审核")
   	@PostMapping("/submitInfoFromOQDeptToDept1")
   	@ResponseBody
   	@UserLoginToken(logType=LogType.MODIFY)
   	public ResponseResult submitInfoFromOQDeptToDept1(@RequestBody AssetInfoSubmitEntity submitEntity) throws Exception{
   		//try {
   			String applymonth = submitEntity.getApplymonth();
   			String applyuser = submitEntity.getApplyuser();
   			
   			List<String> sendToDept1 =new ArrayList<>();
   			List<Integer> newLstsubmitID =new ArrayList<>();
   			Map<String,Object> param=new HashMap<>();
   			param.put("GroupFlag",null);
			param.put("OQDeptReviewer",applyuser);
			param.put("ApplyMonth",applymonth);
			List<AssetPlanInfoAll> listofOQDeptDetail = assetPlanInfoService.listofOqDeptDetail(param);
   			//当前环节该登录人所有待提交的单子
   			for (int i = 0; i < listofOQDeptDetail.size(); i++) {
   				newLstsubmitID.add(listofOQDeptDetail.get(i).getAssetplanid());
			}
   			//把所有同意数量修改为0的单子的状态置为已结束，其他的状态为提交下一环节
   			List<AssetPlanInfo> lst=new ArrayList<>();
   			for (int j = 0; j < newLstsubmitID.size(); j++) {
   				AssetPlanInfo ap = assetPlanInfoMapper.selectByPrimaryKey(newLstsubmitID.get(j));
   				//下一环节审批人
   				String dept1 = sysDicInfoService.getFirstDeptMgn();
   				if(StringUtils.isNotBlank(dept1)) {
   					ap.setDept1reviewer(dept1);
   				}else {
   					return ResponseResult.fail(false, "无审批人信息，请联系系统管理员！");
   				}
   				
   				if(ap.getRequiredsaudit()==0) {
   					ap.setApstatus("06");
   					ap.setApstage("0");
   					
   					List<String> sendTo =new ArrayList<>();
   					List<String> ccTo =new ArrayList<>();
   					String url="";
   					//若有申请人的统一申购数量修改成0，邮件主送申请人抄送申购人，告知信息和审批意见。
   					sendTo.add(ap.getApplyuser());
   					ccTo.add(ap.getRequireduser());
   					//mailInfoService.sendRemindMail(sendTo.toString(), ccTo.toString(), "专家团审核", url);
   					mailInfoService.sendProcessEndMail(String.join(",", sendTo), String.join(",", ccTo), url);
   				}else {
   					ap.setApstatus("70");
   					ap.setApstage("7");
   					sendToDept1.add(dept1);
	   			}
   				ap.setModifier(applyuser);
   				ap.setModifitime(new Date());
   				
   				ap.setOqdeptreviewtime(new Date());
   				lst.add(ap);
   			}
   			assetPlanInfoService.batchEditAssetPlanInfo(lst);
   			
   			for (int k = 0; k < newLstsubmitID.size(); k++) {
				AssetPlanInfo ap = assetPlanInfoMapper.selectByPrimaryKey(newLstsubmitID.get(k));
				Integer requiredsaudit = ap.getRequiredsaudit();
				RequestsNumApproveRecord numApproveRecord = recordMapper.selectByPrimaryKey(newLstsubmitID.get(k));
				numApproveRecord.setOqdeptreviewercount(requiredsaudit);
				//默认下一环节同意申购数量和本环节一样
				numApproveRecord.setDept1reviewercount(requiredsaudit);
				recordMapper.updateByPrimaryKey(numApproveRecord);
			}
			//专家团提交后，邮件通知一级部门审核，告知截止时间（标准时间/本月末）。
			String url=remindEmailForDept1+applymonth;
			//去重后的一级部门主管code
			sendToDept1 = removeDuplicate(sendToDept1);
			for (int j = 0; j < sendToDept1.size(); j++) {
				mailInfoService.sendRemindMail(String.join(",", sendToDept1.get(j)), "", "一级部门审核", url);
			}
				
   			return ResponseResult.success(true, "提交成功");
   		/*} catch (Exception e) {
   			e.printStackTrace();
   			return ResponseResult.fail(false, "提交失败");
   		}*/
   	}
    
    

	@ApiOperation(value="专家团审核页面修改同意申购数量和审核意见")
   	@PutMapping("/updateOqdeptInfoList")
   	@ResponseBody
   	@UserLoginToken(logType=LogType.MODIFY)
   	public ResponseResult updateOqdeptInfoList(@RequestBody AssetInfoUpdateEntity updateEntity) throws Exception{
		//try {
			List<Integer> assetplanidList = updateEntity.getAssetplanid();
			for (int i = 0; i < assetplanidList.size(); i++) {
				AssetPlanInfo ap = assetPlanInfoMapper.selectByPrimaryKey(assetplanidList.get(i));
				//同意申购数量
				ap.setRequiredsaudit((updateEntity.getRequiredsaudit().get(i)));
				//评审后总金额
				ap.setActualmoney(updateEntity.getActualmoney().get(i));
				//审核意见不是必填
				ap.setOqdeptreviewnote((updateEntity.getOqdeptreviewnote()));
				ap.setModifier(ap.getOqdeptreviewer());
				ap.setModifitime(new Date());
				
				//数量修改完后对相关联的表RequestsNumApproveRecord进行OQDeptReviewerCount字段的更新
				RequestsNumApproveRecord numApproveRecord = recordMapper.selectByPrimaryKey(assetplanidList.get(i));
				Integer requiredsaudit = updateEntity.getRequiredsaudit().get(i);
				numApproveRecord.setOqdeptreviewercount(requiredsaudit);
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
