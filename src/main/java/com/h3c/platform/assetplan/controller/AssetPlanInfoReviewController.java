package com.h3c.platform.assetplan.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
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
import com.h3c.platform.assetplan.entity.AssetPlanInfoHomePageView;
import com.h3c.platform.assetplan.entity.AssetPlanInfoReviewView;
import com.h3c.platform.assetplan.entity.DeptInfo;
import com.h3c.platform.assetplan.entity.PurchaseReportInfo;
import com.h3c.platform.assetplan.entity.RequestsNumApproveRecord;
import com.h3c.platform.assetplan.entity.SearchAssetParamEntity;
import com.h3c.platform.assetplan.entity.SpecifyManufacturerInfo;
import com.h3c.platform.assetplan.entity.SysDicCategoryEntity;
import com.h3c.platform.assetplan.entity.SysDicReceiverPlaceEntity;
import com.eos.common.constant.AssetTableHeaderEnum;
import com.eos.common.constant.StatusCodeEnum;
import com.eos.common.util.Result;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.h3c.platform.annotation.UserLoginToken;
import com.h3c.platform.assetplan.dao.AssetPlanInfoMapper;
import com.h3c.platform.assetplan.dao.DeptInfoMapper;
import com.h3c.platform.assetplan.dao.PurchaseReportInfoMapper;
import com.h3c.platform.assetplan.dao.RequestsNumApproveRecordMapper;
import com.h3c.platform.assetplan.dao.SpecifyManufacturerInfoMapper;
import com.h3c.platform.assetplan.entity.AssetInfoReviewEntity;
import com.h3c.platform.assetplan.entity.AssetInfoSubmitEntity;
import com.h3c.platform.assetplan.entity.AssetInfoUpdateEntity;
import com.h3c.platform.assetplan.entity.AssetPlanGlobalInfo;
import com.h3c.platform.assetplan.service.AssetPlanInfoService;
import com.h3c.platform.assetplan.service.AssetRateInfoService;
import com.h3c.platform.common.commonconst.DicConst;
import com.h3c.platform.common.commonconst.LogType;
import com.h3c.platform.common.service.MailInfoService;
import com.h3c.platform.common.service.SysDicInfoService;
import com.h3c.platform.common.util.UUIDUtil;
import com.h3c.platform.response.ResponseResult;
import com.h3c.platform.sysmgr.entity.UserInfo;
import com.h3c.platform.sysmgr.service.UserService;
import com.h3c.platform.util.SysDicInfoUtil;
import com.h3c.platform.util.UserUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

@Controller
@RequestMapping("/assetplan/review")
@Api(value = "规范审核页面相关接口",tags = {"规范审核页面相关接口"})
@CrossOrigin
public class AssetPlanInfoReviewController {

	@Autowired
	private AssetPlanInfoService assetPlanInfoService;
	@Autowired
	private AssetPlanInfoMapper assetPlanInfoMapper;
	@Autowired
	private MailInfoService  mailInfoService;
	@Autowired
	private UserService userService;
	@Autowired
	private SysDicInfoService sysDicInfoService;
	@Autowired
	private DeptInfoMapper deptInfoMapper;
	@Autowired
	private RequestsNumApproveRecordMapper recordMapper;
	@Autowired
	private AssetRateInfoService rateInfoService;
	@Autowired
	private SysDicInfoUtil sysDicInfoUtil;
	@Autowired
	private PurchaseReportInfoMapper priMapper;
	@Autowired
	private SpecifyManufacturerInfoMapper smiMapper;
	
	@Value("${spring.remindEmailForNotReview.url}")
    private  String remindEmailForNotReview ;
	
	@Value("${spring.remindEmailForDept3.url}")
    private  String remindEmailForDept3 ;
	
	@Value("${spring.remindEmailForDept2.url}")
    private  String remindEmailForDept2 ;
	
	@Value("${spring.remindEmailForPlanner.url}")
    private  String remindEmailForPlanner ;
	
	@ApiOperation(value="查看规范审核列表信息")
   	@GetMapping("/getReviewInfoList")
   	@ResponseBody
   	@UserLoginToken
   	public ResponseResult getReviewInfoList(@RequestParam @ApiParam(name="reviewer",value="规范审核环节处理人(当前登录人)",required=true)String reviewer,
   			@RequestParam @ApiParam(name="apstage",value="物品所处的规范审核阶段",required=true)String apstage,
   			@RequestParam @ApiParam(name="applymonth",value="申请月份",required=true)String applymonth,
   			@RequestParam @ApiParam(name="pageSize",value="每页行数",required=true)int pageSize,
   			@RequestParam @ApiParam(name="pageNum",value="页码",required=true)int pageNum) throws Exception{
   		//try {
   			//封装返回数据的表头信息
   			List<Map<String, Object>> columnList = sysDicInfoService.getColumn(DicConst.ASSETPLANINFOREVIEWVIEW);
   			
   			Map<String, Object> param = new HashMap<>();
   			JSONArray arrayData = new JSONArray();
   			JSONObject json=new JSONObject();
   			param.put("Reviewer",reviewer);
			//param.put("APStage",apstage);
			param.put("ApplyMonth",applymonth);
			//全选0  规范1  不规范2  未审核3  在审核4   展示列表默认全选 
			param.put("ReviewResult","0");
   			if(StringUtils.isNotBlank(reviewer)){
				if(StringUtils.isNotBlank(apstage) && apstage.contains("2")) {
					//PageHelper.startPage(pageNum,pageSize);
					com.github.pagehelper.page.PageMethod.startPage(pageNum,pageSize);
					
	   				List<AssetPlanInfoAll> reviewInfoList = assetPlanInfoService.listofReviewDetail(param);
	   				
	   				for (int i = 0; i < reviewInfoList.size(); i++) {
	   					SysDicCategoryEntity sysDicCategory = sysDicInfoUtil.getSysDicCategory(reviewInfoList.get(i).getAssetcategory());
	   					reviewInfoList.get(i).setAssetcategoryId(sysDicCategory.getAssetCategoryId());
	   					reviewInfoList.get(i).setAssetcategory(sysDicCategory.getAssetCategory());
	   					reviewInfoList.get(i).setGoodstime(sysDicCategory.getGoodstime());
	   					SysDicReceiverPlaceEntity sysDicReceiverPlace = sysDicInfoUtil.getSysDicReceiverPlace(reviewInfoList.get(i).getReceiverplace());
	   					reviewInfoList.get(i).setReceiverplaceId(sysDicReceiverPlace.getReceiverPlaceId());
	   					reviewInfoList.get(i).setReceiverplace(sysDicReceiverPlace.getReceiverPlace());
	   				}	   				
	   				PageInfo<AssetPlanInfoAll> pageInfo = new PageInfo<AssetPlanInfoAll>(reviewInfoList);
	   				if(reviewInfoList.size()>0) {
		   				String totalmoneySum = assetPlanInfoService.getSumTotalMoneyForReview(param);
		   				//申购金额合计  totalmoneySum
		   				json.put("TotalmoneySum",new BigDecimal(totalmoneySum));
		   				//数据集list
		   				json.put("DataSet" , pageInfo.getList());
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
	
  
	@ApiOperation(value="非成套的修改规范审核列表信息字段(厂家/型号/预计单价/类别/规范审核状态/审核意见，修改同意申购数量)")
   	@PutMapping("/updateReviewInfoList")
   	@ResponseBody
   	@UserLoginToken(logType=LogType.MODIFY)
   	public ResponseResult updateReviewInfoList(@RequestBody AssetInfoUpdateEntity updateEntity) throws Exception{
		//try {
			List<Integer> assetplanidList = updateEntity.getAssetplanid();
			for (int i = 0; i < assetplanidList.size(); i++) {
				AssetPlanInfo ap = assetPlanInfoMapper.selectByPrimaryKey(assetplanidList.get(i));
				if(StringUtils.isBlank(updateEntity.getAssetmanufacturer())){
					return ResponseResult.fail(false, "厂家字段必填");
				}else {
					ap.setAssetmanufacturer(updateEntity.getAssetmanufacturer());
				} 
				if(updateEntity.getAssetmodel().size()==0){
					return ResponseResult.fail(false, "型号字段必填");
				}else {
					ap.setAssetmodel(updateEntity.getAssetmodel().get(i));
				} 
				if(updateEntity.getPprice().size()==0){
					return ResponseResult.fail(false, "预计单价必填");
				}else {
					ap.setPprice(updateEntity.getPprice().get(i));
				}  
				if(StringUtils.isBlank(updateEntity.getAssetcategory())){
					return ResponseResult.fail(false, "物品类别字段必填");
				}else {
					ap.setAssetcategory(updateEntity.getAssetcategory());
				} 
				ap.setTotalmoney(updateEntity.getTotalmoney().get(i));
				//add by chenlulu on 20200706
				//同意申购数量
				ap.setRequiredsaudit((updateEntity.getRequiredsaudit().get(i)));
				//评审后总金额
				ap.setActualmoney(updateEntity.getActualmoney().get(i));
				
				ap.setGoodstime(updateEntity.getGoodstime());
				
				//规范1  不规范2  未审核3  在审核4 
				if(updateEntity.getReviewresult()==null){
					return ResponseResult.fail(false, "规范审核结果字段必填");
				}else if(updateEntity.getReviewresult()==1){
					ap.setReviewresult(updateEntity.getReviewresult());
					ap.setApstage("2");
					ap.setApstatus("20");
				}else if(updateEntity.getReviewresult()==2){
					ap.setReviewresult(updateEntity.getReviewresult());
					//不规范的改下状态
					ap.setApstage("1");
					ap.setApstatus("11");
				} 
				//审核意见不是必填
				ap.setReviewnote(updateEntity.getReviewnote());
				ap.setModifier(ap.getReviewer());
				ap.setModifitime(new Date());
			
				//数量修改完后对相关联的表RequestsNumApproveRecord进行ReviewerCount字段的更新
				RequestsNumApproveRecord numApproveRecord = recordMapper.selectByPrimaryKey(assetplanidList.get(i));
				Integer requiredsaudit = updateEntity.getRequiredsaudit().get(i);
				numApproveRecord.setReviewercount(requiredsaudit);
				recordMapper.updateByPrimaryKey(numApproveRecord);
				
				this.assetPlanInfoService.editAssetPlanInfo(ap);	
			}
			
			return ResponseResult.success(true,"修改成功");
		/*} catch (Exception e) {
			e.printStackTrace();
			return ResponseResult.fail(false,"修改失败");
		}*/
	}
    
	@ApiOperation(value="规范审核页面提交至三级部门主管审核")
   	@PostMapping("/submitInfoFromReviewToDept3")
   	@ResponseBody
   	@UserLoginToken(logType=LogType.MODIFY)
	public ResponseResult submitInfoFromReviewToDept3(@RequestBody AssetInfoSubmitEntity submitEntity) throws Exception{
   			
		//提交至三级主管按钮，支持选中提交和全部提交两种方法。两种方法均提交所选或全部的规范条目信息。
			List<Integer> lstsubmitID = submitEntity.getLstsubmitID();
			String applymonth = submitEntity.getApplymonth();
   			String applyuser = submitEntity.getApplyuser();
   			List<Integer> allReviewListID = new ArrayList<>();
   			if(lstsubmitID.isEmpty()) {
   				//传过来的集合为空，说明全部提交
   				Map<String,Object> param1=new HashMap<>();
   	   			param1.put("Reviewer", applyuser);
   	   			param1.put("ApplyMonth", applymonth);
   	   			param1.put("ReviewResult", "1");
   	   			param1.put("APStage", "2");
   	   			allReviewListID= assetPlanInfoService.getAllReviewList(param1);
   			}else {
   				List<Integer> allListID = new ArrayList<>();
   				//选中的部分先把他所有的成套的都找到
   	   			for (int i = 0; i < lstsubmitID.size(); i++) {
   	   				Integer assetplanid = lstsubmitID.get(i);
   	   				AssetPlanInfo ap = assetPlanInfoMapper.selectByPrimaryKey(assetplanid);
   	   				//有成套设备的话，得把成套设备的也一并提交
   	   				if(StringUtils.isNotBlank(ap.getIscompleteset()) && "1".equals(ap.getIscompleteset())) {
   	   					List<AssetPlanInfo> completeSetList = assetPlanInfoService.selectCompleteSet(ap.getPlancode(), ap.getCompletesetcode());
   	   					for (int j = 0; j < completeSetList.size(); j++) {
   	   						allListID.add(completeSetList.get(j).getAssetplanid());
   	   					}
   	   				//无成套设备	
   	   				}else {
   	   					allListID.add(assetplanid);
   	   				}
   	   			}
   	   			lstsubmitID=removeDuplicate(allListID);
   				
   				//选中提交，得把规范的条目找到
   				Map<String,Object> param2=new HashMap<>();
   				param2.put("id", lstsubmitID);
   	   			param2.put("Reviewer", applyuser);
   	   			param2.put("ApplyMonth", applymonth);
   	   			param2.put("ReviewResult", "1");
   	   			param2.put("APStage", "2");
   	   			allReviewListID= assetPlanInfoService.getAllReviewListForGuiFan(param2);
   			}	
   			List<String> sendTo3Dept =new ArrayList<>();
   			List<String> sendTo2Dept =new ArrayList<>();
   			List<String> sendToPlanner =new ArrayList<>();
   			//把所有同意数量修改为0的单子的状态置为已结束，其他的状态为提交下一环节
   			if(allReviewListID.size()>0) {
   				List<AssetPlanInfo> lst=new ArrayList<>();
   	   			for (int j = 0; j < allReviewListID.size(); j++) {
   	   				AssetPlanInfo ap = assetPlanInfoMapper.selectByPrimaryKey(allReviewListID.get(j));
	   	   			//申购人为二级主管，单子直接提交至二级主管审核环节，
   	   				//一级主管则直接提交至计划员审核环节（这里与前台传的deptcode有关，一级主管会给1级code，二级主管给2级code，其他三级）
   	   				DeptInfo deptInfo = deptInfoMapper.selectByPrimaryKey(Integer.parseInt(ap.getDeptcode()));
   	   				if(ap.getRequiredsaudit()==0) {
	   					ap.setApstatus("02");
	   					ap.setApstage("0");
	   					ap.setDept3manager("");
	   	   				//sendTo.add("");
	   	   				List<String> sendTo0 =new ArrayList<>();
	   					List<String> ccTo0 =new ArrayList<>();
	   					String url="";
	   					//若有申请人的统一申购数量修改成0，邮件主送申请人抄送申购人，告知信息和审批意见。
	   					sendTo0.add(ap.getApplyuser());
	   					ccTo0.add(ap.getRequireduser());
	   					//mailInfoService.sendRemindMail(sendTo0.toString(), ccTo0.toString(), "规范审核结束", url);
	   					mailInfoService.sendProcessEndMail(String.join(",", sendTo0), String.join(",", ccTo0), url);
   	   				}else {
	   					if("1".equals(deptInfo.getDeptLevel())) {
	   						ap.setApstatus("50");
		   	   				ap.setApstage("5");
		   	   				//下一环节审批人
		   	   				String planner = sysDicInfoService.getPlanner();
		   	   				if(StringUtils.isNotBlank(planner)) {
		   	   					ap.setPlanner(planner);
		   	   					sendToPlanner.add(planner);
		   	   				}else {
		   	   					return ResponseResult.fail(false, "无审批人信息，请联系系统管理员！");
		   	   				}
	   					}else if("2".equals(deptInfo.getDeptLevel())) {
	   						ap.setApstatus("40");
		   	   				ap.setApstage("4");
				   			if(StringUtils.isNotBlank(deptInfo.getDeptManagerCode())) {
				   				ap.setDept2manager(deptInfo.getDeptManagerCode());
				   				sendTo2Dept.add(deptInfo.getDeptManagerCode());
				   			}else {
				   				return ResponseResult.fail(false, "无审批人信息，请联系系统管理员！");
				   			}
	   					}else {
	   						ap.setApstatus("30");
		   	   				ap.setApstage("3");
		   	   				//根据申购人获取待提交的三级部门信息，从而获得是三级部门主管
		   	   				//modify on 20200707.不能根据申购人取，得根据存的三级部门code取
		   	   				//UserInfo user = userService.getUserByEmpCode(ap.getRequireduser());
			   	   			if(StringUtils.isNotBlank(deptInfo.getDeptManagerCode())) {
			   	   				ap.setDept3manager(deptInfo.getDeptManagerCode());
			   	   				sendTo3Dept.add(deptInfo.getDeptManagerCode());
				   			}else {
				   				return ResponseResult.fail(false, "无审批人信息，请联系系统管理员！");
				   			}
	   					}
	   				}
   	   				ap.setModifier(applyuser);
   	   				ap.setModifitime(new Date());
   	   				ap.setReviewtime(new Date());
   	   				lst.add(ap);
   	   			}
   	   			assetPlanInfoService.batchEditAssetPlanAndRate(lst, allReviewListID);
   			}else {
   				return ResponseResult.success(true, "仅规范的条目可提交！");
   			}
			
			for (int k = 0; k < allReviewListID.size(); k++) {
				
				AssetPlanInfo ap = assetPlanInfoMapper.selectByPrimaryKey(allReviewListID.get(k));
				DeptInfo deptInfo = deptInfoMapper.selectByPrimaryKey(Integer.parseInt(ap.getDeptcode()));
				Integer requiredsaudit = ap.getRequiredsaudit();
				RequestsNumApproveRecord numApproveRecord = recordMapper.selectByPrimaryKey(allReviewListID.get(k));
				numApproveRecord.setReviewercount(requiredsaudit);
				//默认下一环节同意申购数量和本环节一样
				numApproveRecord.setDept3managercount(requiredsaudit);
				//申购人是12级主管的特殊流程补下前阶段的数量
				if("1".equals(deptInfo.getDeptLevel())) {
					numApproveRecord.setDept2managercount(requiredsaudit);
					numApproveRecord.setPlannercount(requiredsaudit);
				}else if("2".equals(deptInfo.getDeptLevel())) {
					numApproveRecord.setDept2managercount(requiredsaudit);
				}
				//设置规范审核处理人
				numApproveRecord.setReviewerperson(applyuser);
				recordMapper.updateByPrimaryKey(numApproveRecord);
			}
			
			//计划员提交三级主管后，邮件通知三级主管审核，告知截止时间（标准时间/本月末）。
			String urlForDept3=remindEmailForDept3+applymonth;
			String urlForDept2=remindEmailForDept2+applymonth;
			String urlForPlanner=remindEmailForPlanner+applymonth;
			//去重后的三级部门主管code
			sendTo3Dept = removeDuplicate(sendTo3Dept);
			for (int j = 0; j < sendTo3Dept.size(); j++) {
				mailInfoService.sendRemindMail(String.join(",", sendTo3Dept.get(j)), "", "三级部门主管审核", urlForDept3);
			}
			//12级主管提单的特殊流程，发给对应的待审核人
			sendTo2Dept = removeDuplicate(sendTo2Dept);
			for (int j = 0; j < sendTo2Dept.size(); j++) {
				mailInfoService.sendRemindMail(String.join(",", sendTo2Dept.get(j)), "", "二级部门主管审核", urlForDept2);
			}
			sendToPlanner = removeDuplicate(sendToPlanner);
			for (int j = 0; j < sendToPlanner.size(); j++) {
				mailInfoService.sendRemindMail(String.join(",", sendToPlanner.get(j)), "", "计划员审核", urlForPlanner);
			}
			
			return ResponseResult.success(true, "提交成功");
   	}
	
	@ApiOperation(value="手工不规范邮件提醒")
   	@GetMapping("/emailForNotReview")
   	@ResponseBody
   	@UserLoginToken(logType=LogType.SENDMAIL)
   	public ResponseResult emailForNotReview(@RequestParam @ApiParam(name="reviewer",value="规范审核环节处理人(当前登录人)",required=true)String reviewer,
   								@RequestParam @ApiParam(name="applymonth",value="申请月份",required=true)String applymonth) throws Exception{
   		//try {
   			//modify by chenlulu on 20200630 现在的不规范的驳回给申购人，所以现在邮件得主送申购人，抄送申请人。调换一下
   			List<String> ccTo =new ArrayList<>();
			List<String> sendTo =new ArrayList<>();
			String url=remindEmailForNotReview+applymonth;
   			//String subject="您提交的资产申购物品信息里有不规范填写数据，请登录系统进行修改!";
   			//规范审核环节所有不规范的list
   			Map<String,Object> param=new HashMap<>();
   			param.put("ReviewResult", "2");
   			param.put("ApplyMonth",applymonth);
   			param.put("Reviewer",reviewer);
   			//所有不规范单子的申购人list，也就是要发邮件的收件人
   			List<String> notReviewRequiredUserList = this.assetPlanInfoService.getNotReviewApplyUserList(param);
   			for (int i = 0; i < notReviewRequiredUserList.size(); i++) {
				String requiredUser=notReviewRequiredUserList.get(i);
				//根据不规范的申购人查询出所属的单子
				param.put("RequiredUser", requiredUser);
				List<AssetPlanInfoReviewView> notReviewListByRequiredUser = this.assetPlanInfoService.getNotReviewListByApplyUser(param);
				for (int j = 0; j < notReviewListByRequiredUser.size(); j++) {
					//抄送的申请人集合
					ccTo.add(notReviewListByRequiredUser.get(j).getApplyuser());
				}
				ccTo = removeDuplicate(ccTo);
				//校验系统中该用户存不存在
				UserInfo user = userService.getUserByEmpCode(requiredUser);
				//如果收件人不合法【申购人离职】，邮件转发到 规范审核员(当前登录人)
				if(user==null) {
					sendTo.add(notReviewListByRequiredUser.get(i).getReviewer());
				}else {
					sendTo.add(requiredUser);
				}
				
				//mailInfoService.sendRemindMail(sendTo.toString(), ccTo.toString(), "规范审核", "");
				mailInfoService.sendNonstandardMail(String.join(",", sendTo), String.join(",", ccTo), "规范审核",url);
				sendTo.clear();
				ccTo.clear();
			}
   			return ResponseResult.success(true, "邮件发送成功");
   		/*} catch (Exception e) {
   			e.printStackTrace();
   			return ResponseResult.fail(false, "邮件发送失败");
   		}*/
   	}
	
    
	@ApiOperation(value="规范审核状态筛选")
   	@GetMapping("/getReviewResult")
   	@ResponseBody
   	@UserLoginToken
   	public ResponseResult getReviewResult(@RequestParam @ApiParam(name="reviewer",value="规范审核环节处理人(当前登录人)",required=true)String reviewer,
   			@RequestParam @ApiParam(name="reviewResult",value="物品所处的规范审核状态",required=true)String reviewResult,
   			@RequestParam @ApiParam(name="applymonth",value="申请月份",required=true)String applymonth,
   			@RequestParam @ApiParam(name="pageSize",value="每页行数",required=true)int pageSize,
   			@RequestParam @ApiParam(name="pageNum",value="页码",required=true)int pageNum) throws Exception{
   		//try {
   			//封装返回数据的表头信息
   			List<Map<String, Object>> columnList = sysDicInfoService.getColumn(DicConst.ASSETPLANINFOREVIEWVIEW);
   			
   			Map<String, Object> param = new HashMap<>();
   			JSONArray arrayData = new JSONArray();
   			JSONObject json=new JSONObject();
   			
   			if(StringUtils.isNotBlank(reviewer)){
				param.put("Reviewer",reviewer);
   				//param.put("APStage",apstage);
   				param.put("ApplyMonth",applymonth);
   				//全选0  规范1  不规范2  未审核3  在审核4 
   				param.put("ReviewResult",reviewResult);
   				//PageHelper.startPage(pageNum,pageSize);
   				com.github.pagehelper.page.PageMethod.startPage(pageNum,pageSize);
   				List<AssetPlanInfoAll> reviewResultList = assetPlanInfoService.getReviewResult(param);
   				for (int i = 0; i < reviewResultList.size(); i++) {
   					SysDicCategoryEntity sysDicCategory = sysDicInfoUtil.getSysDicCategory(reviewResultList.get(i).getAssetcategory());
   					reviewResultList.get(i).setAssetcategoryId(sysDicCategory.getAssetCategoryId());
   					reviewResultList.get(i).setAssetcategory(sysDicCategory.getAssetCategory());
   					reviewResultList.get(i).setGoodstime(sysDicCategory.getGoodstime());
   					SysDicReceiverPlaceEntity sysDicReceiverPlace = sysDicInfoUtil.getSysDicReceiverPlace(reviewResultList.get(i).getReceiverplace());
   					reviewResultList.get(i).setReceiverplaceId(sysDicReceiverPlace.getReceiverPlaceId());
   					reviewResultList.get(i).setReceiverplace(sysDicReceiverPlace.getReceiverPlace());
   				}
   				PageInfo<AssetPlanInfoAll> pageInfo = new PageInfo<AssetPlanInfoAll>(reviewResultList);
   				if(reviewResultList.size()>0) {
	   				String totalmoneySum = assetPlanInfoService.getSumTotalMoneyForReview(param);
	   				//审核状态
	   				json.put("ReviewResult",reviewResult);
	   				//申购金额合计  totalmoneySum
	   				json.put("TotalmoneySum",new BigDecimal(totalmoneySum));
	   				//数据集list
	   				json.put("DataSet" , pageInfo.getList());
	   				arrayData.add(json);	
	   				return ResponseResult.success(0, "查询成功", pageNum, pageInfo.getTotal(), columnList, arrayData);
   				}else {
   					return ResponseResult.success(0, "查询成功", pageNum, pageInfo.getTotal(), columnList, null);
   				}
			}else {
				return ResponseResult.fail(false, "查询失败，人员不匹配");
			}
   		/*} catch (Exception e) {
   			e.printStackTrace();
   			return ResponseResult.fail(false, "查询失败");
   		}*/
		
   	}
    
	
	
	@ApiOperation(value="规范审核页面查询筛选功能部门（支持1-3级部门），审核状态（全部、规范、不规范、未审核），金额（支持范围筛选）")
   	@PostMapping("/getSearchResultForReview")
   	@ResponseBody
   	@UserLoginToken
   	public ResponseResult getSearchResultForReview(@RequestBody @ApiParam(name="查询规范审核列表",value="传入json格式",required=true) AssetInfoReviewEntity assetInfoReviewEntity) throws Exception{
		//封装返回数据的表头信息
		List<Map<String, Object>> columnList = sysDicInfoService.getColumn(DicConst.ASSETPLANINFOREVIEWVIEW);
		
		Map<String, Object> param = new HashMap<>();
		Integer pageNum = assetInfoReviewEntity.getPageNum();
		Integer pageSize = assetInfoReviewEntity.getPageSize();
		String reviewer = assetInfoReviewEntity.getReviewer();
		String applymonth = assetInfoReviewEntity.getApplymonth();
		String reviewResult = assetInfoReviewEntity.getReviewResult();
		String deptCode = assetInfoReviewEntity.getDeptCode();
		String startPrice = assetInfoReviewEntity.getStartPrice();
		String endPrice = assetInfoReviewEntity.getEndPrice();
		
		param.put("Reviewer",reviewer);
		param.put("ApplyMonth",applymonth);
		//全选0  规范1  不规范2  未审核3  在审核4 
		param.put("ReviewResult",reviewResult);
        if(StringUtils.isBlank(deptCode)) {
        	param.put("DeptCode", null);
        }else {
        	DeptInfo deptInfo = deptInfoMapper.selectByPrimaryKey(Integer.parseInt(deptCode));
        	String deptLevel = deptInfo.getDeptLevel();
        	if("1".equals(deptLevel)) {
        		param.put("Dept1Code", deptCode);
        	}else if("2".equals(deptLevel)) {
        		param.put("Dept2Code", deptCode);
        	}else {
        		param.put("DeptCode", deptCode);
        	}
        }
        param.put("StartPrice",startPrice);
		param.put("EndPrice",endPrice);
		
		JSONArray arrayData = new JSONArray();
		JSONObject json=new JSONObject();
		//PageHelper.startPage(pageNum,pageSize);
		com.github.pagehelper.page.PageMethod.startPage(pageNum,pageSize);
		List<AssetPlanInfoAll> reviewResultList = assetPlanInfoService.getSearchResultForReview(param);
		for (int i = 0; i < reviewResultList.size(); i++) {
			SysDicCategoryEntity sysDicCategory = sysDicInfoUtil.getSysDicCategory(reviewResultList.get(i).getAssetcategory());
			reviewResultList.get(i).setAssetcategoryId(sysDicCategory.getAssetCategoryId());
			reviewResultList.get(i).setAssetcategory(sysDicCategory.getAssetCategory());
			reviewResultList.get(i).setGoodstime(sysDicCategory.getGoodstime());
			SysDicReceiverPlaceEntity sysDicReceiverPlace = sysDicInfoUtil.getSysDicReceiverPlace(reviewResultList.get(i).getReceiverplace());
			reviewResultList.get(i).setReceiverplaceId(sysDicReceiverPlace.getReceiverPlaceId());
			reviewResultList.get(i).setReceiverplace(sysDicReceiverPlace.getReceiverPlace());
		}
		PageInfo<AssetPlanInfoAll> pageInfo = new PageInfo<AssetPlanInfoAll>(reviewResultList);
		if(reviewResultList.size()>0) {
			String totalmoneySum = assetPlanInfoService.getSumTotalMoneyForReview(param);
			//审核状态
			json.put("ReviewResult",reviewResult);
			//申购金额合计  totalmoneySum
			json.put("TotalmoneySum",new BigDecimal(totalmoneySum));
			//数据集list
			json.put("DataSet" , pageInfo.getList());
			arrayData.add(json);	
			return ResponseResult.success(0, "查询成功", pageNum, pageInfo.getTotal(), columnList, arrayData);
		}else {
			return ResponseResult.success(0, "查询成功", pageNum, pageInfo.getTotal(), columnList, null);
		}
   	}
	
	//通过HashSet踢除重复元素
    public static List removeDuplicate(List list) {   
        HashSet h = new HashSet(list);   
        list.clear();   
        list.addAll(h);   
        return list;   
    } 
    
    @Transactional(readOnly = true)
   	private synchronized Integer initApplyCode() {
   		String partCode=new SimpleDateFormat("yyyy-MM").format(new Date()).toString()+"-"+ UserUtils.getCurrentUserId();
   		Integer newCode;
   		Integer maxCode = assetPlanInfoMapper.getMaxCompleteSetCode(partCode);
   		if (maxCode==null ||maxCode==0) {
   			newCode = 1;
   		}else {
   			newCode =maxCode+1;
   		}
   		return newCode;
   	}
    @UserLoginToken(logType=LogType.MODIFY)
    @PostMapping("/updateReviewResult")
    @ApiOperation(value="修改规范性审核状态")
    @ResponseBody
    public ResponseResult  updateReviewResult(@RequestParam Integer[] ids,@RequestParam Integer result,String reviewNote) throws Exception {
    		List<Integer> newLstsubmitID =new ArrayList<>();
			for (int i = 0; i < ids.length; i++) {
				Integer assetplanid = ids[i];
				AssetPlanInfo ap = assetPlanInfoMapper.selectByPrimaryKey(assetplanid);
				//有成套设备的话吗，得把成套设备的也一并提交
				if(StringUtils.isNotBlank(ap.getIscompleteset()) && "1".equals(ap.getIscompleteset())) {
					List<AssetPlanInfo> completeSetList = assetPlanInfoService.selectCompleteSet(ap.getPlancode(), ap.getCompletesetcode());
					for (int j = 0; j < completeSetList.size(); j++) {
						newLstsubmitID.add(completeSetList.get(j).getAssetplanid());
					}
				//无成套设备	
				}else {
					newLstsubmitID.add(assetplanid);
				}
			}
    	
    	
    	return assetPlanInfoService.updateReviewResult(newLstsubmitID, result,reviewNote);
    }
	
    
    @ApiOperation(value="成套的修改规范审核列表信息的所有字段")
   	@PutMapping("/updateAllReviewInfo")
   	@ResponseBody
   	@UserLoginToken(logType=LogType.MODIFY)
    public ResponseResult updateAllReviewInfo(@RequestBody AssetPlanGlobalInfo assetPlanGlobalInfo) throws Exception{
			for(AssetPlanInfo ap : assetPlanGlobalInfo.lst) {
				if(StringUtils.isBlank(ap.getAssetmanufacturer())){
					return ResponseResult.fail(false, "厂家字段必填");
				} 
				if(StringUtils.isBlank(ap.getAssetname())){
					return ResponseResult.fail(false, "物品名称字段必填");
				} 
				if(StringUtils.isBlank(ap.getAssetmodel())){
					return ResponseResult.fail(false, "型号字段必填");
				} 
				if(ap.getRequireds()==null){
					return ResponseResult.fail(false, "数量字段必填");
				} 
				if(StringUtils.isBlank(ap.getRequireduser())){
					return ResponseResult.fail(false, "申购人ID字段必填");
				} 
				if(StringUtils.isBlank(ap.getDeptcode())){
					return ResponseResult.fail(false, "部门编码字段必填");
				} 
				if(StringUtils.isBlank(ap.getItemcode())){
					return ResponseResult.fail(false, "项目编码字段必填");
				} 
				if(StringUtils.isBlank(ap.getAssetcategory())){
					return ResponseResult.fail(false, "物品类别字段必填");
				} 
				if(StringUtils.isBlank(ap.getReviewer())){
					return ResponseResult.fail(false, "计划员ID字段必填");
				} 
				if(StringUtils.isBlank(ap.getGoodstime())){
					return ResponseResult.fail(false, "货期字段必填");
				} 
				if(StringUtils.isBlank(ap.getReceiverplace())){
					return ResponseResult.fail(false, "到货地点字段必填");
				} 
				if(StringUtils.isBlank(ap.getPurpose())){
					return ResponseResult.fail(false, "用途字段必填");
				}
				if(ap.getReqarrivaldate()==null){
					return ResponseResult.fail(false, "要求到货时间字段必填");
				}
			}
			List<AssetPlanInfo> lst = assetPlanGlobalInfo.getLst();
			//是否成套物品 默认否,1是0否
			String iscompleteset = assetPlanGlobalInfo.getLst().get(0).getIscompleteset();
			//成套ID
			Integer completesetcode = assetPlanGlobalInfo.getLst().get(0).getCompletesetcode();
			//申购序号 格式YYYY-00001，年月－工号
			String plancode = assetPlanGlobalInfo.getLst().get(0).getPlancode();
			//是否需要申购报告 是否需要申购报告,1需要0不需要
			String isreqpurchasereport = assetPlanGlobalInfo.getLst().get(0).getIsreqpurchasereport();
			//申购报告 ID
			String purchasereportid = assetPlanGlobalInfo.getLst().get(0).getPurchasereportid();
			//是否指定供应商,1是0否
			String isspecifymanufacturer = assetPlanGlobalInfo.getLst().get(0).getIsspecifymanufacturer();
			//供应商 ID
			String specifymanufacturerid = assetPlanGlobalInfo.getLst().get(0).getSpecifymanufacturerid();
			
			
			for (int i = 0; i < lst.size(); i++) {
				//申购报告
				//现在没有，断关系
				if("0".equals(isreqpurchasereport)) {
					lst.get(i).setIsreqpurchasereport("0");
				//从无到有
				}else if("1".equals(isreqpurchasereport) && StringUtils.isBlank(purchasereportid) ) {
					Optional<PurchaseReportInfo> temp=assetPlanGlobalInfo.getPurchaseReportInfo().stream()
							.filter(o->StringUtils.isNotBlank(o.getPurchasereportid())).findAny();
					if(!temp.isPresent()) {
						String purchasereportID = UUIDUtil.UUID();
						String currentUserId = UserUtils.getCurrentUserId();
						//新生成申购报告，并建立与主表的关系
						for(PurchaseReportInfo info : assetPlanGlobalInfo.getPurchaseReportInfo()) {
							info.setDeleteflag("1");
							info.setCreatetime(new Date());
							info.setCreator(UserUtils.getCurrentUserId());
							info.setModifier(UserUtils.getCurrentUserId());
							info.setModifitime(new Date());
							info.setPurchasereportid(purchasereportID);
							priMapper.insertSelective(info);
						}
						lst.get(i).setPurchasereportid(assetPlanGlobalInfo.purchaseReportInfo.get(0).getPurchasereportid());	
					}else {
						lst.get(i).setPurchasereportid(assetPlanGlobalInfo.purchaseReportInfo.get(0).getPurchasereportid());	
					}
					
				//从有到有，不做处理，直接update
				}else if("1".equals(isreqpurchasereport) && StringUtils.isNotBlank(purchasereportid)) {
				}
				
				//供应商
				//现在没有，断关系
				if("0".equals(isspecifymanufacturer)) {
					lst.get(i).setIsspecifymanufacturer("0");
				//从无到有
				}else if("1".equals(isspecifymanufacturer) &&StringUtils.isBlank(specifymanufacturerid)) {
					Optional<SpecifyManufacturerInfo> temp=assetPlanGlobalInfo.getSpecifyManufacturerInfo().stream()
							.filter(o->StringUtils.isNotBlank(o.getSpecifymanufacturerid())).findAny();
					if(!temp.isPresent()) {
						//新生成供应商，并建立与主表的关系
						String surchasereportid = UUIDUtil.UUID();
						for(SpecifyManufacturerInfo info : assetPlanGlobalInfo.getSpecifyManufacturerInfo()) {
							info.setDeleteflag("1");
							info.setCreatetime(new Date());
							info.setCreator(UserUtils.getCurrentUserId());
							info.setModifier(UserUtils.getCurrentUserId());
							info.setModifitime(new Date());
							info.setSpecifymanufacturerid(surchasereportid);
							smiMapper.insertSelective(info);
						}							
						lst.get(i).setSpecifymanufacturerid(assetPlanGlobalInfo.specifyManufacturerInfo.get(0).getSpecifymanufacturerid());		
					}else {
						lst.get(i).setSpecifymanufacturerid(assetPlanGlobalInfo.specifyManufacturerInfo.get(0).getSpecifymanufacturerid());	
					}
					
				//从有到有，不做处理，直接update
				}else if("1".equals(isspecifymanufacturer) && StringUtils.isNotBlank(specifymanufacturerid)) {
				}
				
				
				
				//规范1  不规范2  未审核3  在审核4 
				if(lst.get(i).getReviewresult()==null){
					return ResponseResult.fail(false, "规范审核结果字段必填");
				}else if(lst.get(i).getReviewresult()==1){
					lst.get(i).setApstage("2");
					lst.get(i).setApstatus("20");
				}else if(lst.get(i).getReviewresult()==2){
					//不规范的改下状态
					lst.get(i).setApstage("1");
					lst.get(i).setApstatus("11");
				} 
				//审核意见前台带过来了
				//数量修改完后对相关联的表RequestsNumApproveRecord进行ReviewerCount字段的更新
				RequestsNumApproveRecord numApproveRecord = recordMapper.selectByPrimaryKey(lst.get(i).getAssetplanid());
				Integer requiredsaudit = lst.get(i).getRequiredsaudit();
				numApproveRecord.setReviewercount(requiredsaudit);
				recordMapper.updateByPrimaryKey(numApproveRecord);
				
			}
			
			this.assetPlanInfoService.editAssetPlanInfo(assetPlanGlobalInfo);
			
			return ResponseResult.success(true,"修改成功");
	}
	
}
