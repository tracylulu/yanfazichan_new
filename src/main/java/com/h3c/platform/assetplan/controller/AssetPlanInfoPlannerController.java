package com.h3c.platform.assetplan.controller;

import java.math.BigDecimal;
import java.net.InetAddress;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
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
import com.h3c.platform.assetplan.dao.RequestsNumApproveRecordMapper;
import com.h3c.platform.assetplan.entity.AssetInfoPlannerExportEntity;
import com.h3c.platform.assetplan.entity.AssetInfoReviewEntity;
import com.h3c.platform.assetplan.entity.AssetInfoSubmitEntity;
import com.h3c.platform.assetplan.entity.AssetInfoUpdateEntity;
import com.h3c.platform.assetplan.entity.AssetInfoUpdateEntityForDept3AndOther;
import com.h3c.platform.assetplan.entity.AssetPlanInfo;
import com.h3c.platform.assetplan.entity.AssetPlanInfoAll;
import com.h3c.platform.assetplan.entity.AssetPlanInfoPlannerView;
import com.h3c.platform.assetplan.entity.AssetPlanInfoSearchExportView;
import com.h3c.platform.assetplan.entity.AssetRateInfo;
import com.h3c.platform.assetplan.entity.DeptInfo;
import com.h3c.platform.assetplan.entity.RequestsNumApproveRecord;
import com.h3c.platform.assetplan.entity.SearchAssetParamEntity;
import com.h3c.platform.assetplan.entity.SysDicCategoryEntity;
import com.h3c.platform.assetplan.entity.SysDicReceiverPlaceEntity;
import com.h3c.platform.assetplan.service.AssetPlanInfoService;
import com.h3c.platform.common.commonconst.DicConst;
import com.h3c.platform.common.commonconst.LogType;
import com.h3c.platform.common.service.MailInfoService;
import com.h3c.platform.common.service.SysDicInfoService;
import com.h3c.platform.common.util.IPUtils;
import com.h3c.platform.response.ResponseResult;
import com.h3c.platform.sysmgr.entity.OperationLog;
import com.h3c.platform.sysmgr.entity.UserInfo;
import com.h3c.platform.sysmgr.service.OperationLogService;
import com.h3c.platform.sysmgr.service.UserService;
import com.h3c.platform.util.ExportExcelWrapper;
import com.h3c.platform.util.SysDicInfoUtil;
import com.h3c.platform.util.UserUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

@Controller
@RequestMapping("/assetplan/planner")
@Api(value = "计划员审核页面相关接口",tags = {"计划员审核页面相关接口"})
@CrossOrigin
public class AssetPlanInfoPlannerController {

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
	private  OperationLogService operationLogService;
	@Autowired
	private SysDicInfoUtil sysDicInfoUtil;
	
	@Value("${spring.remindEmailForOQ.url}")
    private  String remindEmailForOQ ;
	
	@ApiOperation(value="展示计划员审核列表信息")
   	@PostMapping("/getPlannerInfoList")
   	@ResponseBody
   	@UserLoginToken
   	public ResponseResult getPlannerInfoList(@RequestParam @ApiParam(name="planner",value="计划员审核环节处理人(当前登录人)",required=true)String planner,
   			@RequestParam @ApiParam(name="apstage",value="物品所处的计划员审核阶段",required=true)String apstage,
   			@RequestParam @ApiParam(name="applymonth",value="申请月份",required=true)String applymonth) throws Exception{
   		//try {
   			//封装返回数据的表头信息
   			List<Map<String, Object>> columnList = sysDicInfoService.getColumn(DicConst.ASSETPLANINFOPLANNERVIEW);
   			if(StringUtils.isNotBlank(planner)){
					JSONArray arrayData = new JSONArray();
					Map<String, Object> param = new HashMap<>();
   					param.put("Planner",planner);
   					param.put("ApplyMonth",applymonth);
	   				List<Integer> flag= assetPlanInfoService.getPlannerListForFlag(param);
	   				int listSize=assetPlanInfoService.getPlannerListSize(param);
	   				for (int i = 0; i < flag.size(); i++) {
	   					JSONObject json=new JSONObject();
	   					param.put("GroupFlag",flag.get(i));
	   					List<AssetPlanInfoAll> listofPlannerDetail = assetPlanInfoService.listofPlannerDetail(param);
	   					if(!listofPlannerDetail.isEmpty()) {
	   						String groupflagdetail = listofPlannerDetail.get(0).getGroupflagdetail();
	   						Map<String,Object> groupMess = assetPlanInfoService.getPlannerGroupMess(param);
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
	   		   				json.put("RequiredsAudit", requiredsAudit);
	   		   				//申购金额合计  totalmoneySum
	   		   				json.put("TotalmoneySum",totalmoneySumStr);
	   		   				//评审后金额合计  actualmoneySum
	   		   				json.put("ActualmoneySum",actualmoneySumStr);
	   		   				//数据集
	   		   				json.put("DataSet" , listofPlannerDetail);
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
	
  
	@ApiOperation(value="计划员审核页面提交至专家团审核或归档")
   	@PostMapping("/submitInfoFromPlannerToOQDept")
   	@ResponseBody
   	@UserLoginToken(logType=LogType.MODIFY)
   	public ResponseResult submitInfoFromPlannerToOQDept(@RequestBody AssetInfoSubmitEntity submitEntity) throws Exception{
			String nextHandlePerson="";		
			String applymonth = submitEntity.getApplymonth();
   			String applyuser = submitEntity.getApplyuser();
   			boolean toNext=false;
   			Map<String,Object> param=new HashMap<>();
   			Map<String,Object> param1=new HashMap<>();
   			param1.put("GroupFlag",null);
			param1.put("Planner",applyuser);
			param1.put("ApplyMonth",applymonth);
   			//提交至6环节专家团审核或结束（前4中情况提交至专家团继续审核，后四种情况得看这个条件：含《指定供应商申购报告》且非事实上独家供应，满足的话继续提交下一步审核，不满足则结束审批）
   				List<Integer> newLstsubmitID =new ArrayList<>();
   				List<Integer> newLstEndID =new ArrayList<>();
   				//使用修改完数量后重新建得视图查询----还是使用之前的
   				List<AssetPlanInfoAll> listofPlannerDetail = assetPlanInfoService.listofPlannerDetail(param1);
   				for (int i = 0; i < listofPlannerDetail.size(); i++) {
   					Long groupflag = listofPlannerDetail.get(i).getGroupflag();
   					if("1".equals(groupflag.toString()) || "2".equals(groupflag.toString()) || 
   							"3".equals(groupflag.toString()) || "4".equals(groupflag.toString())) {
   						newLstsubmitID.add(listofPlannerDetail.get(i).getAssetplanid());
   					}else {
   						//另4种，还需判断这个条件：非事实上独家供应
   						if("是".equals(listofPlannerDetail.get(i).getManufacturertypeenum())) {
   							newLstsubmitID.add(listofPlannerDetail.get(i).getAssetplanid());
   						}else {
   							newLstEndID.add(listofPlannerDetail.get(i).getAssetplanid());
   						}
   					}
				}
   				//提交下一步审批
   				if(newLstsubmitID.size()>0) {
   					
	   				//把所有同意数量修改为0的单子的状态置为已结束，其他的状态为提交下一环节
		   			List<AssetPlanInfo> lst=new ArrayList<>();
		   			List<String> sendToOQ =new ArrayList<>();
		   			List<AssetPlanInfo> newLstByZeroAssetPlanInfo = new ArrayList<>();
		   			for (int j = 0; j < newLstsubmitID.size(); j++) {
		   				AssetPlanInfo ap = assetPlanInfoMapper.selectByPrimaryKey(newLstsubmitID.get(j));
		   				//下一环节审批人
		   				String oq = sysDicInfoService.getOq();
		   				if(StringUtils.isNotBlank(oq)) {
		   					ap.setOqdeptreviewer(oq);
		   					UserInfo userByEmpCode = userService.getUserByEmpCode(oq);
			   				nextHandlePerson=userByEmpCode.getEmpName()+" "+userByEmpCode.getEmpCode();
		   				}else {
		   					return ResponseResult.fail(false, "无审批人信息，请联系系统管理员！");
		   				}
		   				if(ap.getRequiredsaudit()==0) {
		   					//同意数量改成0的单子,标记状态为051
		   					ap.setApstatus("051");
		   					ap.setApstage("0");
		   					newLstByZeroAssetPlanInfo.add(ap);
		   					/*List<String> sendTo =new ArrayList<>();
		   					List<String> ccTo =new ArrayList<>();
		   					String url="";
		   					//若有申请人的统一申购数量修改成0，邮件主送申请人抄送申购人，告知信息和审批意见。
		   					sendTo.add(ap.getApplyuser());
		   					ccTo.add(ap.getRequireduser());
		   					//mailInfoService.sendRemindMail(sendTo.toString(), ccTo.toString(), "计划员审核", url);
		   					mailInfoService.sendProcessEndMail(String.join(",", sendTo), String.join(",", ccTo), url);*/
		   				}else {
		   					ap.setApstatus("60");
		   					ap.setApstage("6");
		   					sendToOQ.add(oq);
		   					toNext=true;
			   			}
		   				ap.setModifier(applyuser);
		   				ap.setModifitime(new Date());
		   				
		   				ap.setPlannertime(new Date());
		   				//设置专家团审批页面默认的评审意见为同意，前台展示使用（同意，不同意）
			   			ap.setOqdeptreviewnote("同意");
		   				lst.add(ap);
		   			}
		   			assetPlanInfoService.batchEditAssetPlanInfo(lst);
	   		   			
	   	   			//提交之前对表RequestsNumApproveRecord字段进行更新
	   				for (int k = 0; k < newLstsubmitID.size(); k++) {
	   					AssetPlanInfo ap = assetPlanInfoMapper.selectByPrimaryKey(newLstsubmitID.get(k));
	   					Integer requiredsaudit = ap.getRequiredsaudit();
	   					RequestsNumApproveRecord numApproveRecord = recordMapper.selectByPrimaryKey(newLstsubmitID.get(k));
	   					numApproveRecord.setPlannercount(requiredsaudit);
	   					//默认下一环节同意申购数量和本环节一样
	   					numApproveRecord.setOqdeptreviewercount(requiredsaudit);
	   					recordMapper.updateByPrimaryKey(numApproveRecord);
	   				}
	   				
	   				//计划员提交后，邮件通知专家团审核，告知截止时间（标准时间/本月末）。
	   				String url=remindEmailForOQ+applymonth;
	   				//去重后的专家团code
	   				sendToOQ = removeDuplicate(sendToOQ);
	   				for (int j = 0; j < sendToOQ.size(); j++) {
	   					mailInfoService.sendRemindMail(String.join(",", sendToOQ.get(j)), "", "专家团审核", url);
	   				}
	   				
	   				//数量改为0的按照申请人和申购人分组发送邮件（相同的申购人和申请人，发送一封邮件就可以了）
	   	   			Map<String, List<AssetPlanInfo>> collect = newLstByZeroAssetPlanInfo.stream().collect(Collectors.groupingBy(e->fetchGroupKey(e)));
	   	   			for(String key:collect.keySet()) {
	   	   				List<AssetPlanInfo> lstTemp=collect.get(key);
	   	   				List<String> sendToEnd =new ArrayList<>();
	   	   				List<String> ccToEnd =new ArrayList<>();
	   	   				sendToEnd.add(lstTemp.get(0).getApplyuser());
	   	   				ccToEnd.add(lstTemp.get(0).getRequireduser());
	   	   				mailInfoService.sendProcessEndMail(String.join(",", sendToEnd), String.join(",", ccToEnd), "");
	   	   			}
	   				
   				}
   				//结束归档
   				if(newLstEndID.size()>0) {
   					param.put("id", newLstEndID);
   					param.put("Modifier", applyuser);
   					//在此环节结束审批的单子,标记状态为05
   	   				param.put("APStatus", "05");
   	   				param.put("APStage", "0");
   	   				param.put("OQDeptReviewer", "");
   	   				this.assetPlanInfoService.submitInfoFromPlannerToOqDept(param);
   	   				//结束归档的单子也记录下
   	   				List<AssetPlanInfo> newLstEndAssetPlanInfo = new ArrayList<>();
	   	   			for (int k = 0; k < newLstEndID.size(); k++) {
	   					AssetPlanInfo ap = assetPlanInfoMapper.selectByPrimaryKey(newLstEndID.get(k));
	   					newLstEndAssetPlanInfo.add(ap);
	   					Integer requiredsaudit = ap.getRequiredsaudit();
	   					RequestsNumApproveRecord numApproveRecord = recordMapper.selectByPrimaryKey(newLstEndID.get(k));
	   					numApproveRecord.setPlannercount(requiredsaudit);
	   					//默认下一环节同意申购数量和本环节一样
	   					numApproveRecord.setOqdeptreviewercount(requiredsaudit);
	   					recordMapper.updateByPrimaryKey(numApproveRecord);
	   					
	   					/*//将审批结束的信息邮件主送申请人抄送申购人，告知审批结果。
	   					List<String> sendToEnd =new ArrayList<>();
	   					List<String> ccToEnd =new ArrayList<>();
	   					sendToEnd.add(ap.getApplyuser());
	   					ccToEnd.add(ap.getRequireduser());
	   					//mailInfoService.sendRemindMail(sendToEnd.toString(), ccToEnd.toString(), "计划员审核环节归档", "");
	   					mailInfoService.sendProcessEndMail(String.join(",", sendToEnd), String.join(",", ccToEnd), "");*/
	   	   			}
	   	   			//按照申请人和申购人分组发送邮件（相同的申购人和申请人，发送一封邮件就可以了）
	   	   			Map<String, List<AssetPlanInfo>> collect = newLstEndAssetPlanInfo.stream().collect(Collectors.groupingBy(e->fetchGroupKey(e)));
	   	   			for(String key:collect.keySet()) {
	   	   				List<AssetPlanInfo> lstTemp=collect.get(key);
	   	   				List<String> sendToEnd =new ArrayList<>();
	   	   				List<String> ccToEnd =new ArrayList<>();
	   	   				sendToEnd.add(lstTemp.get(0).getApplyuser());
	   	   				ccToEnd.add(lstTemp.get(0).getRequireduser());
	   	   				mailInfoService.sendProcessEndMail(String.join(",", sendToEnd), String.join(",", ccToEnd), "");
	   	   			}
   				}
   				if(newLstsubmitID.isEmpty() && !newLstEndID.isEmpty()) {
   					return ResponseResult.success(true, "归档成功");
   				}else {
   					if(toNext) {
   						return ResponseResult.success(true, "已成功提交至"+nextHandlePerson+"审批");
   	   				}else {
   	   					return ResponseResult.success(true, "审批完成");
   	   				}
   				}
   	}
    
    
	private static String fetchGroupKey(AssetPlanInfo e) {
		return e.getApplyuser() +"#"+ e.getRequireduser();
	}


	@ApiOperation(value="计划员审核页面修改同意申购数量和审核意见")
   	@PutMapping("/updatePlannerInfoList")
   	@ResponseBody
   	@UserLoginToken(logType=LogType.MODIFY)
   	public ResponseResult updatePlannerInfoList(@RequestBody AssetInfoUpdateEntityForDept3AndOther updateEntity) throws Exception{
			List<Integer> assetplanidList = updateEntity.getAssetplanid();
			for (int i = 0; i < assetplanidList.size(); i++) {
				AssetPlanInfo ap = assetPlanInfoMapper.selectByPrimaryKey(assetplanidList.get(i));
				//同意申购数量
				ap.setRequiredsaudit((updateEntity.getRequiredsaudit().get(i)));
				//评审后总金额
				ap.setActualmoney(updateEntity.getActualmoney().get(i));
				//审核意见
				ap.setPlannernote(updateEntity.getPlannernote().get(i));
				ap.setModifier(UserUtils.getCurrentUserId());
				ap.setModifitime(new Date());
				
				//数量修改完后对相关联的表RequestsNumApproveRecord进行PlannerCount字段的更新
				RequestsNumApproveRecord numApproveRecord = recordMapper.selectByPrimaryKey(updateEntity.getAssetplanid().get(i));
				Integer requiredsaudit = updateEntity.getRequiredsaudit().get(i);
				numApproveRecord.setPlannercount(requiredsaudit);
				recordMapper.updateByPrimaryKey(numApproveRecord);
				
				this.assetPlanInfoService.editAssetPlanInfo(ap);
			}
			return ResponseResult.success(true,"修改成功");
	}
	
	
	@ApiOperation(value="导出到Excel")
   	@PostMapping("/exportAssetPlanInfoForPlanner")
   	@ResponseBody
   	@UserLoginToken(logType=LogType.EXPORT)
   	public void exportAssetPlanInfoForPlanner(HttpServletRequest request,HttpServletResponse response,
   			@RequestBody @ApiParam(name="计划员环节导出入参",value="传入json格式",required=true) AssetInfoPlannerExportEntity assetInfoPlannerExportEntity)throws Exception {
		
		String planner = assetInfoPlannerExportEntity.getPlanner();
		String applymonth = assetInfoPlannerExportEntity.getApplymonth();
		/*String[] header = new String[] { "物品名称", "厂家", "型号", "申报数量","同意数量", "预计单价", "同意金额","申购人", "二级部门",
    									"用途", "使用率（部门/研发总体）", "供应商类别-事实上独家供应","预计总价", "项目编码", "评审意见"};
		String[] column = new String[] { "Assetname", "Assetmanufacturer", "Assetmodel", "Requireds","Requiredsaudit", 
										"Pprice","Actualmoney", "Requiredusername","Dept2name","Purpose", "Usagerate", 
										"Manufacturertypeenum","Totalmoney","Itemcode","Plannernote"};*/
		String[] header = new String[] { "评审结果","物品名称", "厂家", "型号", "申报数量","同意数量", "预计单价","申购金额", "同意金额",
				"申购人", "二级部门", "三级部门", "项目编码", "类别", "货期（天）", "用途", "到货地点", "备注", "审批状态","评审意见",
				"使用率","数量","设备分布","使用率明细","研发总体","研发总体数量"};
		String[] column = new String[] { "Approvalresult","Assetname", "Assetmanufacturer", "Assetmodel", "Requireds","Requiredsaudit", 
				"Pprice","Totalmoney", "Actualmoney","Requiredusername","Dept2name","Dept3name", "Itemcode", 
				"Assetcategory","Goodstime","Purpose","Receiverplace","Assetnote","Apstatusdetail","Plannernote","Rate","Number",
				"Distribution","Detail","RdRate","RdNumber"};
		
		
		//String currentUserId = UserUtils.getCurrentUserId();
		List<String> lstHeader = Arrays.asList(header);
		List<String> lsth = new ArrayList<>(lstHeader);
		header = (String[]) lsth.toArray(new String[lsth.size()]);
		
		List<String> lstcolumn = Arrays.asList(column);
		List lstc = new ArrayList(lstcolumn);
		column = (String[]) lstc.toArray(new String[lstc.size()]);
		
		Map<String, Object> param = new HashMap<>();
		param.put("Planner",planner);
		param.put("ApplyMonth",applymonth);
		List<AssetPlanInfoPlannerView> lst = assetPlanInfoService.exportAssetPlanInfoForPlanner(param);
		//类别，货期，到货地点转换成汉字重新赋值导出
		/*for (int i = 0; i < lst.size(); i++) {
			SysDicCategoryEntity sysDicCategory = sysDicInfoUtil.getSysDicCategory(lst.get(i).getAssetcategory());
			lst.get(i).setAssetcategory(sysDicCategory.getAssetCategory());
			lst.get(i).setGoodstime(sysDicCategory.getGoodstime());
			SysDicReceiverPlaceEntity sysDicReceiverPlace = sysDicInfoUtil.getSysDicReceiverPlace(lst.get(i).getReceiverplace());
			lst.get(i).setReceiverplace(sysDicReceiverPlace.getReceiverPlace());
		}*/
		lst = sysDicInfoUtil.replaceDicForPlannerExport(lst);
		
		ExportExcelWrapper<AssetPlanInfoPlannerView> excelWrapper = new ExportExcelWrapper<>();

		StringBuffer buffer=excelWrapper.exportExcel("AssetInfoExportForPlanner", "计划员环节资产数据导出", header, column, lst, response, "2007",true, "Assetplanid");
		OperationLog log=new OperationLog();
		log.setModelcode("com.h3c.platform.assetplan.controller.exportAssetPlanInfoForPlanner");
		log.setModelname("导出到Excel");
		log.setSummary(request.getRequestURL().toString());
		log.setContent(buffer.toString());
		log.setUserid(UserUtils.getCurrentUserId());
		log.setLogtype(LogType.EXPORT);		
		log.setIp("IP:"+IPUtils.getIpAddr(request)+";service:"+InetAddress.getLocalHost().getHostAddress());			
			
		operationLogService.saveLog(log);
    }
	
	//通过HashSet踢除重复元素
    public static List removeDuplicate(List list) {   
        HashSet h = new HashSet(list);   
        list.clear();   
        list.addAll(h);   
        return list;   
    } 
    
}
