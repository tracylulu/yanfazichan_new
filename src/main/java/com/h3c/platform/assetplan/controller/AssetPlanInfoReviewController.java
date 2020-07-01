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
import com.h3c.platform.assetplan.entity.AssetPlanInfoHomePageView;
import com.h3c.platform.assetplan.entity.AssetPlanInfoReviewView;
import com.h3c.platform.assetplan.entity.DeptInfo;
import com.h3c.platform.assetplan.entity.RequestsNumApproveRecord;
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
import com.h3c.platform.assetplan.dao.RequestsNumApproveRecordMapper;
import com.h3c.platform.assetplan.entity.AssetInfoSubmitEntity;
import com.h3c.platform.assetplan.entity.AssetInfoUpdateEntity;
import com.h3c.platform.assetplan.entity.AssetPlanGlobalInfo;
import com.h3c.platform.assetplan.service.AssetPlanInfoService;
import com.h3c.platform.assetplan.service.AssetRateInfoService;
import com.h3c.platform.common.commonconst.DicConst;
import com.h3c.platform.common.commonconst.LogType;
import com.h3c.platform.common.service.MailInfoService;
import com.h3c.platform.common.service.SysDicInfoService;
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
					PageHelper.startPage(pageNum, pageSize);
					
	   				List<AssetPlanInfoAll> reviewInfoList = assetPlanInfoService.listofReviewDetail(param);
	   				
	   				for (int i = 0; i < reviewInfoList.size(); i++) {
	   					SysDicCategoryEntity sysDicCategory = sysDicInfoUtil.getSysDicCategory(reviewInfoList.get(i).getAssetcategory());
	   					reviewInfoList.get(i).setAssetcategoryId(sysDicCategory.getAssetCategoryId());
	   					reviewInfoList.get(i).setAssetcategory(sysDicCategory.getAssetCategory());
	   					reviewInfoList.get(i).setGoodstime(Integer.parseInt(sysDicCategory.getGoodstime()));
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
	
  
	@ApiOperation(value="修改规范审核列表信息字段(厂家/型号/预计单价/类别/规范审核状态/审核意见)")
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
				ap.setActualmoney(updateEntity.getTotalmoney().get(i));
				ap.setGoodstime(Integer.parseInt(updateEntity.getGoodstime()));
				
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
   		//try {
   			String applymonth = submitEntity.getApplymonth();
   			String applyuser = submitEntity.getApplyuser();
   			
   			List<String> sendTo =new ArrayList<>();
   			Map<String,Object> param1=new HashMap<>();
   			param1.put("Reviewer", applyuser);
   			param1.put("ApplyMonth", applymonth);
   			param1.put("ReviewResult", "1");
   			param1.put("APStage", "2");
   			//当前环节该登录人所有规范审核的单子
   			List<Integer> allReviewListID = assetPlanInfoService.getAllReviewList(param1);
   			if(allReviewListID.size()>0) {
   				List<AssetPlanInfo> lst=new ArrayList<>();
   	   			for (int j = 0; j < allReviewListID.size(); j++) {
   	   				AssetPlanInfo ap = assetPlanInfoMapper.selectByPrimaryKey(allReviewListID.get(j));
   	   				ap.setApstatus("30");
   	   				ap.setApstage("3");
   	   				ap.setModifier(applyuser);
   	   				ap.setModifitime(new Date());
   	   				//根据申购人获取待提交的三级部门信息，从而获得是三级部门主管
   	   				UserInfo user = userService.getUserByEmpCode(ap.getRequireduser());
   	   				DeptInfo deptInfo = deptInfoMapper.selectByPrimaryKey(Integer.parseInt(user.getDept3Code()));
	   	   			if(StringUtils.isNotBlank(deptInfo.getDeptManagerCode())) {
	   	   				ap.setDept3manager(deptInfo.getDeptManagerCode());
	   	   				sendTo.add(deptInfo.getDeptManagerCode());
		   			}else {
		   				return ResponseResult.fail(false, "无审批人信息，请联系系统管理员！");
		   			}
   	   				ap.setReviewtime(new Date());
   	   				//得传递型号，三级部门，规范审核时间，向楠那边做后续的判断：*交换机和路由产品线，预算划分到三级，其余部门预算在二级。
   	   				ResponseResult rate = rateInfoService.getRate(ap.getAssetmodel(), ap.getDeptcode(), ap.getReviewtime());
   	   				Map data = (Map) rate.getData();
   	   				//研发总体的信息
   	   				Map RD = (Map)data.get("RD");
   	   				Boolean rdFlag = (Boolean)RD.get("isEmpty");
   	   				String rdRate = (String) RD.get("rate");
   	   				String[] rdRatesplit = rdRate.split("%");
   	   				//部门的信息
   	   				Map dept = (Map)data.get("dept");
   	   				Boolean deptFlag = (Boolean)dept.get("isEmpty");
   	   				String deptRate = (String) dept.get("rate");
   	   				String[] deptRatesplit = deptRate.split("%");
   	   				//都为true，研发总体和部门都没有使用率
   	   				if(rdFlag && deptFlag) {
   	   					ap.setUsagerate("/");
   	   				//研发总体不为true，部门为true，说明研发总体有使用率，部门没有
   	   				}else if(!rdFlag && deptFlag) {
   	   					ap.setUsagerate("-/"+rdRatesplit[0]);
   	   				//两者都不为true，说明都有使用率
   	   				}else {
   	   					ap.setUsagerate(deptRatesplit[0]+"/"+rdRatesplit[0]);
   	   				}
   	   				lst.add(ap);
   	   			}
   	   			assetPlanInfoService.batchEditAssetPlanInfo(lst);
   			}else {
   				return ResponseResult.success(true, "仅规范的条目可提交！");
   			}
   			
			//提交之前对表RequestsNumApproveRecord创建记录数据，与主表对应
			for (int k = 0; k < allReviewListID.size(); k++) {
				RequestsNumApproveRecord record = recordMapper.selectByPrimaryKey(allReviewListID.get(k));
				if(record==null) {
					AssetPlanInfo ap = assetPlanInfoMapper.selectByPrimaryKey(allReviewListID.get(k));
   					Integer requiredsaudit = ap.getRequiredsaudit();
   					RequestsNumApproveRecord numApproveRecord = new RequestsNumApproveRecord();
   					numApproveRecord.setAssetplanid(allReviewListID.get(k));
   					numApproveRecord.setDept3managercount(requiredsaudit);
   					recordMapper.insert(numApproveRecord);
				}
			}
			//计划员提交三级主管后，邮件通知三级主管审核，告知截止时间（标准时间/本月末）。
			String url="";
			//去重后的三级部门主管code
			sendTo = removeDuplicate(sendTo);
			for (int j = 0; j < sendTo.size(); j++) {
				mailInfoService.sendRemindMail(sendTo.toString(), "", "三级部门主管审核", url);
			}
			
			return ResponseResult.success(true, "提交成功");
   		/*} catch (Exception e) {
   			e.printStackTrace();
   			return ResponseResult.fail(false, "提交失败");
   		}*/
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
				mailInfoService.sendRemindMail(sendTo.toString(), ccTo.toString(), "规范审核", "");
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
   				PageHelper.startPage(pageNum, pageSize);
   				List<AssetPlanInfoAll> reviewResultList = assetPlanInfoService.getReviewResult(param);
   				for (int i = 0; i < reviewResultList.size(); i++) {
   					SysDicCategoryEntity sysDicCategory = sysDicInfoUtil.getSysDicCategory(reviewResultList.get(i).getAssetcategory());
   					reviewResultList.get(i).setAssetcategoryId(sysDicCategory.getAssetCategoryId());
   					reviewResultList.get(i).setAssetcategory(sysDicCategory.getAssetCategory());
   					reviewResultList.get(i).setGoodstime(Integer.parseInt(sysDicCategory.getGoodstime()));
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
    
	
	//通过HashSet踢除重复元素
    public static List removeDuplicate(List list) {   
        HashSet h = new HashSet(list);   
        list.clear();   
        list.addAll(h);   
        return list;   
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
	
	
}
