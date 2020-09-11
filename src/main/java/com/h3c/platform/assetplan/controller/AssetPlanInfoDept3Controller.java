package com.h3c.platform.assetplan.controller;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

import com.h3c.platform.assetplan.entity.AssetPlanInfo;
import com.h3c.platform.assetplan.entity.AssetPlanInfoAll;
import com.h3c.platform.assetplan.entity.AssetPlanInfoApplyView;
import com.h3c.platform.assetplan.entity.AssetPlanInfoDept3View;
import com.h3c.platform.assetplan.entity.AssetPlanInfoHomePageView;
import com.h3c.platform.assetplan.entity.AssetPlanInfoReviewView;
import com.h3c.platform.assetplan.entity.DeptInfo;
import com.h3c.platform.assetplan.entity.RequestsNumApproveRecord;
import com.eos.common.constant.StatusCodeEnum;
import com.eos.common.util.Result;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.h3c.platform.annotation.UserLoginToken;
import com.h3c.platform.assetplan.dao.AssetPlanInfoMapper;
import com.h3c.platform.assetplan.dao.DeptInfoMapper;
import com.h3c.platform.assetplan.dao.RequestsNumApproveRecordMapper;
import com.h3c.platform.assetplan.entity.AssetInfoSubmitEntity;
import com.h3c.platform.assetplan.entity.AssetInfoUpdateEntity;
import com.h3c.platform.assetplan.entity.AssetInfoUpdateEntityForDept3AndOther;
import com.h3c.platform.assetplan.entity.AssetPlanGlobalInfo;
import com.h3c.platform.assetplan.service.AssetPlanInfoService;
import com.h3c.platform.assetplan.service.DeptInfoService;
import com.h3c.platform.common.commonconst.DicConst;
import com.h3c.platform.common.commonconst.LogType;
import com.h3c.platform.common.service.MailInfoService;
import com.h3c.platform.common.service.SysDicInfoService;
import com.h3c.platform.common.util.ObjToStrUtil;
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
@RequestMapping("/assetplan/dept3")
@Api(value = "三级主管审核页面相关接口",tags = {"三级主管审核页面相关接口"})
@CrossOrigin
public class AssetPlanInfoDept3Controller {

	@Autowired
	private AssetPlanInfoService assetPlanInfoService;
	@Autowired
	private RequestsNumApproveRecordMapper recordMapper;
	@Autowired
	private AssetPlanInfoMapper assetPlanInfoMapper;
	@Autowired
	private SysDicInfoService sysDicInfoService;
	@Autowired
	private UserService userService;
	@Autowired
	private DeptInfoMapper deptInfoMapper;
	@Autowired
	private DeptInfoService deptInfoService;
	@Autowired
	private MailInfoService  mailInfoService;
	@Value("${batchToDept2}")
	private String batchToDept2;
	@Value("${spring.remindEmailForDept2.url}")
    private  String remindEmailForDept2 ;
	@Value("${spring.endEmail.url}")
    private  String endEmail ;
	@ApiOperation(value="展示三级主管审核列表信息")
   	@GetMapping("/getDept3InfoList")
   	@ResponseBody
	@UserLoginToken
   	public ResponseResult getDept3InfoList(@RequestParam @ApiParam(name="dept3Manager",value="三级主管审核环节处理人(当前登录人)",required=true)String dept3Manager,
   			@RequestParam @ApiParam(name="apstage",value="物品所处的三级主管审核阶段",required=true)String apstage,
   			@RequestParam @ApiParam(name="applymonth",value="申请月份",required=true)String applymonth) throws Exception{
   			//封装返回数据的表头信息
   			List<Map<String, Object>> columnList = sysDicInfoService.getColumn(DicConst.ASSETPLANINFODEPT3VIEW);
   			
   			Map<String, Object> param = new HashMap<>();
			JSONArray arrayData = new JSONArray();
			param.put("Dept3Manager",dept3Manager);
			param.put("APStage",apstage);
			param.put("ApplyMonth",applymonth);
			
			Map<String, Object> param1 = new HashMap<>();
			param1.put("Dept3Manager",dept3Manager);
			param1.put("DeptCode",null);
			param1.put("APStage",apstage);
			param1.put("ApplyMonth",applymonth);
			
			if(StringUtils.isNotBlank(dept3Manager)){
			if(StringUtils.isNotBlank(apstage) && apstage.contains("3")) {
   				List<AssetPlanInfoAll> dept3InfoList = assetPlanInfoService.listofDept3Detail(param);
   				Optional<AssetPlanInfoAll> optional = dept3InfoList.stream().filter(o->StringUtils.isBlank(o.getExpensetype())).findAny();
   				if(optional.isPresent()) {
   					return ResponseResult.fail(false, "有条目的预算类型为空，请检查数据");
   				}
   				Map<String, List<AssetPlanInfoAll>> collect = dept3InfoList.stream().collect(Collectors.groupingBy(AssetPlanInfoAll::getExpensetype));
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
	   				String totalmoneySum = assetPlanInfoService.getSumTotalMoneyForDept3(param1);
	   				//同意申购金额合计  ActualMoneySum
	   				String actualMoneySum = assetPlanInfoService.getSumActualMoneySumForDept3(param);
	   				if("2".equals(key)) {
	   					//groupName
   						json.put("GroupName", "CAPEX资产类计划");
	   				}else {
	   					//groupName
   						json.put("GroupName", "费用类计划");
	   				}
	   				json.put("TotalmoneySum",totalmoneySum);
	   				json.put("ActualMoneySum",actualMoneySum);
	   				//数据集list
	   				json.put("DataSet" , list);
	   				arrayData.add(json);	
   	   			}
   				return ResponseResult.success(0, "查询成功", 0, dept3InfoList.size(), columnList, arrayData);
   				/*if(dept3InfoList.size()>0) {
	   				//申购金额合计  totalmoneySum
	   				String totalmoneySum = assetPlanInfoService.getSumTotalMoneyForDept3(param1);
	   				//同意申购金额合计  ActualMoneySum
	   				String actualMoneySum = assetPlanInfoService.getSumActualMoneySumForDept3(param);
	   				json.put("TotalmoneySum",new BigDecimal(totalmoneySum));
	   				json.put("ActualMoneySum",new BigDecimal(actualMoneySum));
	   				//数据集list
	   				json.put("DataSet" , dept3InfoList);
	   				arrayData.add(json);	
	   				return ResponseResult.success(0, "查询成功", 0, dept3InfoList.size(), columnList, arrayData);
   				}else {
   					return ResponseResult.success(0, "查询成功", 0, dept3InfoList.size(), columnList, arrayData);
   				}*/
   			}else {
   				return ResponseResult.fail(false, "查询失败，审核阶段不匹配");
   			}
		}else {
			return ResponseResult.fail(false, "查询失败，人员不匹配");
		}
   	}
	
  
	@ApiOperation(value="三级部门审核页面提交至二级部门审核")
   	@PostMapping("/submitInfoFromDept3ToDept2")
   	@ResponseBody
	@UserLoginToken(logType=LogType.MODIFY)
	public ResponseResult submitInfoFromDept3ToDept2(@RequestBody AssetInfoSubmitEntity submitEntity) throws Exception{
   			String nextHandlePerson="";
			String applymonth = submitEntity.getApplymonth();
   			String applyuser = submitEntity.getApplyuser();
   			
   			List<Integer> newLstsubmitID =new ArrayList<>();
   			List<String> sendToDept2ForJHW =new ArrayList<>();
   			Map<String,Object> param=new HashMap<>();
   			param.put("Dept3Manager",applyuser);
			param.put("APStage","3");
			param.put("ApplyMonth",applymonth);
   			
   			List<AssetPlanInfoAll> dept3InfoList = assetPlanInfoService.listofDept3Detail(param);
   			//当前环节该登录人所有待提交的单子
   			for (int i = 0; i < dept3InfoList.size(); i++) {
   				newLstsubmitID.add(dept3InfoList.get(i).getAssetplanid());
			}
   			//把所有同意数量修改为0的单子的状态置为已结束，其他的状态为提交下一环节
   			List<AssetPlanInfo> lst=new ArrayList<>();
   			List<AssetPlanInfo> newLstEndAssetPlanInfo = new ArrayList<>();
   			boolean flag=false;
   			boolean notChaoShiFlag=false;
   			for (int j = 0; j < newLstsubmitID.size(); j++) {
   				AssetPlanInfo ap = assetPlanInfoMapper.selectByPrimaryKey(newLstsubmitID.get(j));
   				//超时，做下记录
   				if(ap.getOuttimeplanenum()==3) {
   					flag=true;
   					continue;
   				}
   				
   				if(ap.getRequiredsaudit()==0) {
   					ap.setApstatus("03");
   					ap.setApstage("0");
   					newLstEndAssetPlanInfo.add(ap);
   					notChaoShiFlag=true;
   					/*List<String> sendTo =new ArrayList<>();
   					List<String> ccTo =new ArrayList<>();
   					String url="";
   					//若有申请人的统一申购数量修改成0，邮件主送申请人抄送申购人，告知信息和审批意见。
   					sendTo.add(ap.getApplyuser());
   					ccTo.add(ap.getRequireduser());
   					//mailInfoService.sendRemindMail(sendTo.toString(), ccTo.toString(), "三级部门主管审核", url);
   					mailInfoService.sendProcessEndMail(String.join(",", sendTo), String.join(",", ccTo), url);*/
   				}else {
   					notChaoShiFlag=true;
	   				//获得下一步审批人	
					DeptInfo dept3Info = deptInfoMapper.selectByPrimaryKey(Integer.parseInt(ap.getDeptcode()));
		   			DeptInfo dept2Info = deptInfoMapper.selectByPrimaryKey(Integer.parseInt(dept3Info.getSupDeptCode()));
		   			if(StringUtils.isNotBlank(dept2Info.getDeptManagerCode())) {
		   				ap.setDept2manager(dept2Info.getDeptManagerCode());
		   				UserInfo userByEmpCode = userService.getUserByEmpCode(dept2Info.getDeptManagerCode());
		   				nextHandlePerson=userByEmpCode.getEmpName()+" "+userByEmpCode.getEmpCode();
		   			}else {
		   				return ResponseResult.fail(false, "无审批人信息，请联系系统管理员！");
		   			}	
					
	   				//三级提交至2级，都为41，所有的三级都提交完，后根据定时然后改成40，二级视图现在只展示的都是40状态的，测的时候先手动去数据库改成40
	   				//在配置文件增加了开关，open为直接提交到40状态
	   				//计划外单子，三级主管提交至二级，应立即到达二级主管。为0是计划内的
	   				if(ap.getAbnormalplanenum()==0) {
	   					if("close".equals(batchToDept2)) {
	   	   					ap.setApstatus("40");
	   	   				}else {
	   	   					ap.setApstatus("41");
	   	   				}
	   				//计划外
	   				}else {
	   					ap.setApstatus("40");
	   					sendToDept2ForJHW.add(dept2Info.getDeptManagerCode());
	   				}
	   				ap.setApstage("4");
	   			}
   				ap.setModifier(applyuser);
   				ap.setModifitime(new Date());
   				//根据申购人获取待提交的二级部门主管
   				//modify on 20200707.不能根据申购人取，得根据存的三级部门code取二级部门再去取
	   			//UserInfo user = userService.getUserByEmpCode(ap.getRequireduser());
   				
   				ap.setDept3checktime(new Date());
   				//设置二级审批页面默认的评审意见为同意，前台展示使用（同意，不同意）
	   			ap.setDept2checknote("同意");
   				lst.add(ap);
   			}
   			assetPlanInfoService.batchEditAssetPlanInfo(lst);
   			
   			for (int k = 0; k < newLstsubmitID.size(); k++) {
					AssetPlanInfo ap = assetPlanInfoMapper.selectByPrimaryKey(newLstsubmitID.get(k));
					Integer requiredsaudit = ap.getRequiredsaudit();
					RequestsNumApproveRecord numApproveRecord = recordMapper.selectByPrimaryKey(newLstsubmitID.get(k));
					numApproveRecord.setDept3managercount(requiredsaudit);
					//默认下一环节同意申购数量和本环节一样
					numApproveRecord.setDept2managercount(requiredsaudit);
					recordMapper.updateByPrimaryKey(numApproveRecord);
				}
   			
			//计划员外的单子，邮件通知二级部门主管审核
			String url=remindEmailForDept2+applymonth;
			//去重后的二级部门code
			sendToDept2ForJHW = removeDuplicate(sendToDept2ForJHW);
			for (int j = 0; j < sendToDept2ForJHW.size(); j++) {
				mailInfoService.sendDeptMgnMail(String.join(",", sendToDept2ForJHW.get(j)), "", "二级部门主管审核", false,4,url);
			}
				
			//数量改为0的按照申请人和申购人分组发送邮件（相同的申购人和申请人，发送一封邮件就可以了）
   			Map<String, List<AssetPlanInfo>> collect = newLstEndAssetPlanInfo.stream().collect(Collectors.groupingBy(e->fetchGroupKey(e)));
   			for(String key:collect.keySet()) {
   				StringBuffer buffer =new StringBuffer();
   				List<AssetPlanInfo> lstTemp=collect.get(key);
   				for (int i = 0; i < lstTemp.size(); i++) {
   					buffer.append("</br>");
   					buffer.append("厂家:"+lstTemp.get(i).getAssetmanufacturer());
   					buffer.append(" 物品名:"+lstTemp.get(i).getAssetname());
   					buffer.append(" 型号:"+lstTemp.get(i).getAssetmodel());
   					buffer.append(" 数量:"+lstTemp.get(i).getRequireds());
   					buffer.append(" 同意数量:"+lstTemp.get(i).getRequiredsaudit());
   					buffer.append("</br>");
   				}
   				List<String> sendToEnd =new ArrayList<>();
   				List<String> ccToEnd =new ArrayList<>();
   				sendToEnd.add(lstTemp.get(0).getApplyuser());
   				ccToEnd.add(lstTemp.get(0).getRequireduser());
   				String urlForEndEmail=endEmail+"?applymonth="+applymonth;
   				mailInfoService.sendProcessEndMail(String.join(",", sendToEnd), String.join(",", ccToEnd), urlForEndEmail,buffer.toString());
   			}
			
   			if(flag && !notChaoShiFlag) {
   				return ResponseResult.success(true, "存在审批超时记录，请联系管理员激活！");
   			}else {
   				if(StringUtils.isBlank(nextHandlePerson)) {
   					return ResponseResult.success(true, "审批完成");
   				}else {
   					return ResponseResult.success(true, "已成功提交至"+nextHandlePerson+"审批");
   				}
   			}
   	}
    
	private static String fetchGroupKey(AssetPlanInfo e) {
		return e.getApplyuser() +"#"+ e.getRequireduser();
	}
	
	@ApiOperation(value="三级部门页面修改同意申购数量和审核意见")
   	@PutMapping("/updateDept3InfoList")
   	@ResponseBody
	@UserLoginToken(logType=LogType.MODIFY)
   	public ResponseResult updateDept3InfoList(@RequestBody AssetInfoUpdateEntityForDept3AndOther updateEntity) throws Exception{
			List<Integer> assetplanidList = updateEntity.getAssetplanid();
			for (int i = 0; i < assetplanidList.size(); i++) {
				AssetPlanInfo ap = assetPlanInfoMapper.selectByPrimaryKey(assetplanidList.get(i));
				//同意申购数量
				ap.setRequiredsaudit((updateEntity.getRequiredsaudit().get(i)));
				//评审后总金额
				ap.setActualmoney(updateEntity.getActualmoney().get(i));
				//审核意见
				ap.setDept3checknote(updateEntity.getDept3checknote().get(i));
				ap.setModifier(UserUtils.getCurrentUserId());
				ap.setModifitime(new Date());
				
				//数量修改完后对相关联的表RequestsNumApproveRecord进行Dept3managercount字段的更新
				RequestsNumApproveRecord numApproveRecord = recordMapper.selectByPrimaryKey(assetplanidList.get(i));
				Integer requiredsaudit = updateEntity.getRequiredsaudit().get(i);
				numApproveRecord.setDept3managercount(requiredsaudit);
				recordMapper.updateByPrimaryKey(numApproveRecord);
				
				this.assetPlanInfoService.editAssetPlanInfo(ap);
			}
			return ResponseResult.success(true,"修改成功");
	}
    

    
	@ApiOperation(value="预算列表展示（二三级部门页面通用）")
   	@GetMapping("/getBudgetInfoList")
   	@ResponseBody
	@UserLoginToken
	public ResponseResult getBudgetInfoList(@RequestParam @ApiParam(name="applyuser",value="当前登录人",required=true)String applyuser,
			@RequestParam @ApiParam(name="apstage",value="物品所处的审核阶段",required=true)String apstage,
			@RequestParam @ApiParam(name="applymonth",value="申请月份",required=true)String applymonth) throws Exception{
		
		List<JSONObject> lstResult=new ArrayList<>();
		List<JSONObject> lstChild=new ArrayList<>();
		//实际到货_在途_预算
		double daoHuo = 0;
		double zaiTu = 0;
		double totalBudget = 0;
		double total=0;
		double totalBudgetSY=0;
		double budgetSum=0;
		double totalmoneySum=0;
		
		//java.text.DecimalFormat df = new java.text.DecimalFormat("#.00");
		
		if("3".equals(apstage)) {
			Map<String, Object> param33 = new HashMap<>();
			param33.put("Dept3Manager",applyuser);
			param33.put("APStage",apstage);
			param33.put("ApplyMonth",applymonth);
			List<AssetPlanInfoAll> dept3InfoList = assetPlanInfoService.listofDept3Detail(param33);
			List<String> newlist = dept3InfoList.stream().map(AssetPlanInfoAll::getDeptcode).collect(Collectors.toList());
			//去重后的三级部门code
			newlist = removeDuplicate(newlist);
			for (int i = 0; i < newlist.size(); i++) {
				JSONObject jsonObject1 = sysDicInfoService.getDicByTypeAndCode(DicConst.R_BUDGET, newlist.get(i));
	   			String dicName3=ObjToStrUtil.replaceNullValue(jsonObject1.getString("dic_value"));
	   			if(StringUtils.isNotBlank(dicName3)) {
	   				Map<String, Object> param1 = new HashMap<>();
   	   				param1.put("Dept3Code",newlist.get(i));
   	   				param1.put("Dept2Code",null);
   	   				param1.put("ApplyMonth",applymonth);
   	   				String budgetSum1 = assetPlanInfoService.getDept3Apply(param1);
   	   				if(StringUtils.isNotBlank(budgetSum1)) {
   	   					budgetSum=Double.parseDouble(assetPlanInfoService.getDept3Apply(param1))/10000;
   	   					//df.format(budgetSum);
   	   					BigDecimal bg = new BigDecimal(budgetSum);    
   	   					budgetSum= bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue(); 
   	   				}else {
   	   				}
   	   				
   	   				Map<String, Object> param = new HashMap<>();
   	   				param.put("Dept3Manager",applyuser);
   	   				param.put("Dept3Code",newlist.get(i));
   	   				param.put("ApplyMonth",applymonth);
   	   				//计划新增金额（万元），修改，得区分部门的
   	   				String totalmoneySum1 = assetPlanInfoService.getDept3Planed(param);
	   				if(StringUtils.isNotBlank(totalmoneySum1)) {
	   					totalmoneySum=Double.parseDouble(assetPlanInfoService.getDept3Planed(param))/10000;
	   					//df.format(totalmoneySum);
	   					BigDecimal bg = new BigDecimal(totalmoneySum);    
	   					totalmoneySum= bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
	   				}else {
	   				}
   	   				
   	   				//实际到货_在途_预算 万元   1_12_123
   	   				if(StringUtils.isNotBlank(dicName3)) {
   	   					String[] split = dicName3.split("_");
   	   	   				daoHuo = Double.parseDouble(split[0]);
   	   	   				zaiTu = Double.parseDouble(split[1]);
   	   	   				totalBudget = Double.parseDouble(split[2]);
   	   	   				total=daoHuo+zaiTu;
   	   	   				totalBudgetSY=totalBudget-budgetSum-total;
   	   	   				BigDecimal bg = new BigDecimal(totalBudgetSY);    
   	   	   				totalBudgetSY= bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();    
   	   				}else {
   	   					totalBudgetSY=totalBudget-budgetSum-total;
   	   					BigDecimal bg = new BigDecimal(totalBudgetSY);    
	   	   				totalBudgetSY= bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue(); 
   	   				}
   	   				JSONObject json2=new JSONObject();
   	   				DeptInfo deptInfo = deptInfoMapper.selectByPrimaryKey(Integer.parseInt(newlist.get(i)));
   	   				json2.put("deptCode", deptInfo.getDeptCode());
   	   				json2.put("deptName", deptInfo.getDeptName());
   	   				json2.put("deptlevel", deptInfo.getDeptLevel());
   	   				json2.put("totalmoneySum", totalmoneySum);
   	   				json2.put("budgetSum", budgetSum);
   	   				json2.put("daoHuo", daoHuo);
   	   				json2.put("zaiTu", zaiTu);
   	   				json2.put("total", total);
   	   				json2.put("totalBudget", totalBudget);
   	   				json2.put("totalBudgetSY", totalBudgetSY);
   	   				lstResult.add(json2);  
	   			}else {
	   				continue;
	   			}
			}
		}
			
		if("4".equals(apstage)) {
			Map<String, Object> param44 = new HashMap<>();
			param44.put("Dept2Manager",applyuser);
			param44.put("APStage",apstage);
			param44.put("ApplyMonth",applymonth);
			List<AssetPlanInfoAll> dept2InfoList = assetPlanInfoService.listofDept2Detail(param44);
			List<String> newlist = dept2InfoList.stream().map(AssetPlanInfoAll::getDept2code).collect(Collectors.toList());
			//去重后的二级部门code
			newlist = removeDuplicate(newlist);
			for (int k = 0; k < newlist.size(); k++) {
				JSONObject jsonObject2 = sysDicInfoService.getDicByTypeAndCode(DicConst.R_BUDGET, newlist.get(k));
				String dicName2=ObjToStrUtil.replaceNullValue(jsonObject2.getString("dic_value"));
				if(StringUtils.isNotBlank(dicName2)) {
					Map<String, Object> param1 = new HashMap<>();
   	   				param1.put("Dept3Code",null);
   	   				param1.put("Dept2Code",newlist.get(k));
   	   				param1.put("ApplyMonth",applymonth);
   	   				String budgetSum1 = assetPlanInfoService.getDept2Apply(param1);
	   				if(StringUtils.isNotBlank(budgetSum1)) {
	   					budgetSum=Double.parseDouble(assetPlanInfoService.getDept2Apply(param1))/10000;
	   					//df.format(budgetSum);
	   					BigDecimal bg = new BigDecimal(budgetSum);    
	   					budgetSum= bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
	   				}else {
	   				}
   	   				
   	   				Map<String, Object> param = new HashMap<>();
   	   				param.put("Dept2Manager",applyuser);
   	   				param.put("Dept2Code",newlist.get(k));
   	   				param.put("ApplyMonth",applymonth);
   	   				//计划新增金额（万元）
	   	   			String totalmoneySum1 = assetPlanInfoService.getDept2Planed(param);
	   				if(StringUtils.isNotBlank(totalmoneySum1)) {	   					
	   					totalmoneySum=Double.parseDouble(totalmoneySum1)/10000;
	   					//df.format(totalmoneySum);
	   					BigDecimal bg = new BigDecimal(totalmoneySum);    
	   					totalmoneySum= bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
	   				}else {
	   				}
   	   				//实际到货_在途_预算 万元   1_12_123
   	   				if(StringUtils.isNotBlank(dicName2)) {
   	   					String[] split = dicName2.split("_");
   	   	   				daoHuo = Double.parseDouble(split[0]);
   	   	   				zaiTu = Double.parseDouble(split[1]);
   	   	   				totalBudget = Double.parseDouble(split[2]);
   	   	   				total=daoHuo+zaiTu;
   	   	   				totalBudgetSY=totalBudget-budgetSum-total;
   	   	   				BigDecimal bg = new BigDecimal(totalBudgetSY);    
   	   	   				totalBudgetSY= bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue(); 
   	   				}else {
   	   					totalBudgetSY=totalBudget-budgetSum-total;
   	   					BigDecimal bg = new BigDecimal(totalBudgetSY);    
	   	   				totalBudgetSY= bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue(); 
   	   				}
   	   				JSONObject json2=new JSONObject();
   	   				DeptInfo deptInfo = deptInfoMapper.selectByPrimaryKey(Integer.parseInt(newlist.get(k)));
   	   				json2.put("deptCode", deptInfo.getDeptCode());
   	   				json2.put("deptName", deptInfo.getDeptName());
   	   				json2.put("deptlevel", deptInfo.getDeptLevel());
   	   				json2.put("totalmoneySum", totalmoneySum);
   	   				json2.put("budgetSum", budgetSum);
   	   				json2.put("daoHuo", daoHuo);
   	   				json2.put("zaiTu", zaiTu);
   	   				json2.put("total", total);
   	   				json2.put("totalBudget", totalBudget);
   	   				json2.put("totalBudgetSY", totalBudgetSY);
   	   				lstResult.add(json2);
					
				}else {
					//当前部门为2级，2级查不到，预算坐在三级，返回所有三级预算列表
					//同时加载全部三级部门的信息
					double totalmoneySum2=0;
	   	   			double budgetSum2=0;
	   	   			double daoHuo2=0;
	   	   			double zaiTu2=0;
	   	   			double total2=0;
	   	   			double totalBudget2=0;
	   				double totalBudgetSY2=0;
	   				//根据二级部门获得所有三级部门集合
	   				List<DeptInfo> allChildDept = deptInfoService.getAllChildDept(newlist.get(k));
	   				for (int i = 0; i < allChildDept.size(); i++) {
	   					//标示是否为空  true 空
	   	   				boolean isEmpty = false;
	   					//JSONObject json33=new JSONObject();
	   					Map<String, Object> param_2 = new HashMap<>();
	   					param_2.put("Dept3Code",allChildDept.get(i).getDeptCode());
	   					param_2.put("ApplyMonth",applymonth);
	   	   				//计划新增金额（万元）
		   	   			String totalmoneySum11 = assetPlanInfoService.getDept2PlanedForDept3(param_2);
		   				if(StringUtils.isNotBlank(totalmoneySum11)) {
		   					totalmoneySum=Double.parseDouble(totalmoneySum11)/10000;
		   					//df.format(totalmoneySum);
		   					BigDecimal bg = new BigDecimal(totalmoneySum);    
		   					totalmoneySum= bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue(); 
		   				}else {
		   				}
	   				
	   					//本月评审已通过（万元）
	   					Map<String, Object> param_3 = new HashMap<>();
	   					param_3.put("Dept3Code",allChildDept.get(i).getDeptCode());
	   					param_3.put("Dept2Code",null);
	   					param_3.put("ApplyMonth",applymonth);
	   					String budgetSum11 = assetPlanInfoService.getDept2Apply(param_3);
		   				if(StringUtils.isNotBlank(budgetSum11)) {
		   					budgetSum=Double.parseDouble(assetPlanInfoService.getDept2Apply(param_3))/10000;
		   					//df.format(budgetSum);
		   					BigDecimal bg = new BigDecimal(budgetSum);    
		   					budgetSum= bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue(); 
		   				}else {
		   				}
	   					
	   					JSONObject jsonObject33 = sysDicInfoService.getDicByTypeAndCode(DicConst.R_BUDGET, allChildDept.get(i).getDeptCode().toString());
	   		   			String dicNameForDept33=ObjToStrUtil.replaceNullValue(jsonObject33.getString("dic_value"));
		   		   		if(StringUtils.isNotBlank(dicNameForDept33)) {
		   					String[] split = dicNameForDept33.split("_");
		   	   				daoHuo = Double.parseDouble(split[0]);
		   	   				zaiTu = Double.parseDouble(split[1]);
		   	   				totalBudget = Double.parseDouble(split[2]);
		   	   				total=daoHuo+zaiTu;
		   	   				totalBudgetSY=totalBudget-budgetSum-total;
		   	   				BigDecimal bg = new BigDecimal(totalBudgetSY);    
		   	   				totalBudgetSY= bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue(); 
		   				}else {
		   					//不展示三级预算为空的部门
		   					isEmpty=true;
		   					daoHuo =0;
		   	   				zaiTu = 0;
		   	   				totalBudget = 0;
		   	   				total=0;
		   					totalBudgetSY=totalBudget-budgetSum-total;
		   					BigDecimal bg = new BigDecimal(totalBudgetSY);    
	   	   	   				totalBudgetSY= bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue(); 
		   				}
		   		   		JSONObject json22=new JSONObject();
			   		   	json22.put("deptCode", allChildDept.get(i).getDeptCode());
		   				json22.put("deptName", allChildDept.get(i).getDeptName());
		   				json22.put("deptlevel", allChildDept.get(i).getDeptLevel());
		   				json22.put("totalmoneySum", totalmoneySum);
		   				json22.put("budgetSum", budgetSum);
		   				json22.put("daoHuo", daoHuo);
		   				json22.put("zaiTu", zaiTu);
		   				json22.put("total", total);
		   				json22.put("totalBudget", totalBudget);
		   				json22.put("totalBudgetSY", totalBudgetSY);	   				
		   				if(!isEmpty) {
		   					lstChild.add(json22);
		   				}
		   				totalmoneySum2+=totalmoneySum;
		   				budgetSum2+=budgetSum;
		   				daoHuo2+=daoHuo;
		   				zaiTu2+=zaiTu;
		   				total2+=total;
		   				totalBudget2+=totalBudget;
		   				totalBudgetSY2+=totalBudgetSY;
		   				
		   				BigDecimal bg1 = new BigDecimal(totalmoneySum2);    
		   				totalmoneySum2= bg1.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
   	   	   				
   	   	   				BigDecimal bg2 = new BigDecimal(budgetSum2);    
   	   	   				budgetSum2= bg2.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
   	   	   				
		   				BigDecimal bg3 = new BigDecimal(totalBudgetSY2);    
		   				totalBudgetSY2= bg3.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue(); 
	   				}
	   				if(CollectionUtils.isNotEmpty(lstChild)) {
	   					JSONObject json1=new JSONObject();
	   					DeptInfo deptInfo = deptInfoMapper.selectByPrimaryKey(Integer.parseInt(newlist.get(k)));
		   				json1.put("deptCode", deptInfo.getDeptCode());
		   				json1.put("deptName", deptInfo.getDeptName());
		   				json1.put("deptlevel", deptInfo.getDeptLevel());
		   				json1.put("totalmoneySum", totalmoneySum2);
		   				json1.put("budgetSum", budgetSum2);
		   				json1.put("daoHuo", daoHuo2);
		   				json1.put("zaiTu", zaiTu2);
		   				json1.put("total", total2);
		   				json1.put("totalBudget", totalBudget2);
		   				json1.put("totalBudgetSY", totalBudgetSY2);
		   				lstResult.add(json1);
	   				}
	   				lstResult.addAll(lstChild);
				}
				
			}
			
		}
		
		return ResponseResult.success(0, "查询成功", 0, 0, null, lstResult);
	}
	
	//通过HashSet踢除重复元素
    public static List removeDuplicate(List list) {   
        HashSet h = new HashSet(list);   
        list.clear();   
        list.addAll(h);   
        return list;   
    } 
}
