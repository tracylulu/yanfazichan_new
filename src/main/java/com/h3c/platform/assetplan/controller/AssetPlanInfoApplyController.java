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

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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
import com.h3c.platform.assetplan.entity.AssetPlanInfoDetailView;
import com.h3c.platform.assetplan.entity.AssetPlanInfoPlannerView;
import com.h3c.platform.assetplan.entity.AssetPlanInfoReviewView;
import com.h3c.platform.assetplan.entity.DeptInfo;
import com.h3c.platform.assetplan.entity.ProjectInfo;
import com.h3c.platform.assetplan.entity.PurchaseReportInfo;
import com.h3c.platform.assetplan.entity.PurchaseReportInfoExt;
import com.h3c.platform.assetplan.entity.RequestsNumApproveRecord;
import com.h3c.platform.assetplan.entity.SpecifyManufacturerInfo;
import com.h3c.platform.assetplan.entity.SpecifyManufacturerInfoExt;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
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
import com.h3c.platform.assetplan.entity.AssetInfoSubmitEntity;
import com.h3c.platform.assetplan.entity.AssetPlanGlobalInfo;
import com.h3c.platform.assetplan.entity.AssetPlanGlobalInfoAll;
import com.h3c.platform.assetplan.service.AssetPlanInfoService;
import com.h3c.platform.assetplan.service.DeptInfoService;
import com.h3c.platform.assetplan.service.PurchaseReportInfoService;
import com.h3c.platform.assetplan.service.SpecifyManufacturerInfoService;
import com.h3c.platform.common.commonconst.DicConst;
import com.h3c.platform.common.commonconst.LogType;
import com.h3c.platform.common.service.MailInfoService;
import com.h3c.platform.common.service.PlanTimeWindowsService;
import com.h3c.platform.common.util.MailSendToAndCcToUtils;
import com.h3c.platform.common.util.UUIDUtil;
import com.h3c.platform.common.service.SysDicInfoService;
import com.h3c.platform.response.ResponseResult;
import com.h3c.platform.sysmgr.entity.UserInfo;
import com.h3c.platform.sysmgr.service.UserService;
import com.h3c.platform.util.UserUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Controller
@RequestMapping("/assetplan/apply")
@Api(value = "资源申请页面相关接口",tags = {"资源申请页面相关接口"})
@CrossOrigin
public class AssetPlanInfoApplyController {

	@Autowired
	private AssetPlanInfoService assetPlanInfoService;
	@Autowired
	private AssetPlanInfoMapper assetPlanInfoMapper;
	@Autowired
	private UserService userService;
	@Autowired
	private MailInfoService  mailInfoService;
	@Autowired
	private DeptInfoMapper deptInfoMapper;
	@Autowired
	private PurchaseReportInfoMapper priMapper;
	@Autowired
	private SpecifyManufacturerInfoMapper smiMapper;
	@Autowired
	private SysDicInfoService dicService;
	@Autowired
	private SysDicInfoService sysDicInfoService;
	@Autowired
	private RequestsNumApproveRecordMapper recordMapper;
	@Autowired
	private DeptInfoService deptInfoService;
	@Autowired
	private PurchaseReportInfoService purchaseReportInfoService;
	@Autowired
	private SpecifyManufacturerInfoService  specifyManufacturerInfoService;
	
    @ApiOperation(value="新增资源信息（点击新增按钮）")
	@PostMapping("/addAssetPlanInfo")
	@ResponseBody
	@UserLoginToken(logType=LogType.ADD)
	public ResponseResult addAssetPlanInfo(@RequestBody AssetPlanGlobalInfo assetPlanGlobalInfo) throws Exception {
		//try {
			//String currentUserId = UserUtils.getCurrentUserId();
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
				if(ap.getGoodstime()==null){
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
			
			this.assetPlanInfoService.addAssetPlanInfo(assetPlanGlobalInfo);
			return ResponseResult.success(true,"新增成功");
		/*} catch (Exception e) {
			e.printStackTrace();
			return ResponseResult.fail(false,"新增失败");
		}*/
	}
    
    @ApiOperation(value="修改资源信息（在详情页面点击保存按钮）")
	@PutMapping("/editAssetPlanInfo")
	@ResponseBody
	@UserLoginToken(logType=LogType.MODIFY)
	public ResponseResult editAssetPlanInfo(@RequestBody AssetPlanGlobalInfo assetPlanGlobalInfo) throws Exception{
		//try {
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
				if(ap.getGoodstime()==null){
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
			
			//数据库中原来的成套id集合
			List<Integer> oldLstsubmitID =new ArrayList<>();
			List<AssetPlanInfo> oldCompleteSetList = assetPlanInfoService.selectCompleteSet(plancode, completesetcode);
   			for (int i = 0; i < oldCompleteSetList.size(); i++) {
   				oldLstsubmitID.add(oldCompleteSetList.get(i).getAssetplanid());
   			}
			
   			//初始化成套设备的code--只初始化一次
			Integer completesetcodeNew = this.initApplyCode();
			
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
				
				//是否成套
				//现在非成套0，历史成套id为0  非到非，不做处理，直接update
				if("0".equals(iscompleteset) && completesetcode==0) {
				
				//现在非成套0，历史成套id不为0  成到非，把缺少的那条软删除
				}else if("0".equals(iscompleteset) && completesetcode!=0) {
					List<AssetPlanInfo> completeSetList = assetPlanInfoService.selectCompleteSet(plancode, completesetcode);
					for (int j = 0; j < completeSetList.size(); j++) {
						if(completeSetList.get(j).getAssetplanid().equals(lst.get(i).getAssetplanid())) {
							//改成非成套的把以前的成套编码去掉
							lst.get(i).setCompletesetcode(0);	
						}else {
							List<Integer> lstDelID=new ArrayList<>();
							lstDelID.add(completeSetList.get(j).getAssetplanid());
							assetPlanInfoService.delAssetPlanInfo(lstDelID);
						}
					}
				//现在是成套，历史成套id为0  非到成，先生成成套id
				}else if("1".equals(iscompleteset) && completesetcode==0) {
					AssetPlanInfo assetPlanInfo = assetPlanInfoMapper.selectByPrimaryKey(lst.get(i).getAssetplanid());
					//去数据库中查询有没有这条记录，判断是原来有的还是新增的
					if(assetPlanInfo==null) {
						lst.get(i).setCompletesetcode(completesetcodeNew);
						assetPlanInfoMapper.insert(lst.get(i));
					}else {
						lst.get(i).setCompletesetcode(completesetcodeNew);
					}
				//成套到成套
				}else if("1".equals(iscompleteset) && completesetcode!=0) {
					AssetPlanInfo assetPlanInfo = assetPlanInfoMapper.selectByPrimaryKey(lst.get(i).getAssetplanid());
					if(assetPlanInfo==null) {
						assetPlanInfoMapper.insert(lst.get(i));
					}else {
						oldLstsubmitID.remove(lst.get(i).getAssetplanid());
					}
				}
			}
			
			//成到成，软删除，把数据库中有的，传过来没有的进行软删除
			if("1".equals(iscompleteset) && completesetcode!=0) {
				if(oldLstsubmitID.size()>0) {
					assetPlanInfoService.delAssetPlanInfo(oldLstsubmitID);
				}
			}
			
			this.assetPlanInfoService.editAssetPlanInfo(assetPlanGlobalInfo);
			
			return ResponseResult.success(true,"修改成功");
		/*} catch (Exception e) {
			e.printStackTrace();
			return ResponseResult.fail(false,"修改失败");
		}*/
	}
    
    @ApiOperation(value="查看单条资源信息（点击详情按钮各环节页面通用）")
	@GetMapping("/getAssetPlanInfoById")
	@ResponseBody
	@UserLoginToken
	public ResponseResult getAssetPlanInfoById(@RequestParam @ApiParam(name="assetplanid",value="资源信息主键id",required=true)Integer assetplanid) throws Exception {
		//try {
			
			AssetPlanGlobalInfoAll assetPlanGlobalInfoAll = new AssetPlanGlobalInfoAll();
			List<AssetPlanInfoDetailView> lst =new ArrayList<>();
			assetPlanGlobalInfoAll.setLst(lst);
		
			AssetPlanInfoDetailView ap = assetPlanInfoService.getByAssetID(assetplanid);
		
			if(StringUtils.isNotBlank(ap.getDeleteflag()) && !"0".equals(ap.getDeleteflag()) ) {
				//有成套设备
				if(StringUtils.isNotBlank(ap.getIscompleteset()) && "1".equals(ap.getIscompleteset())) {
					List<AssetPlanInfoDetailView> completeSetList = assetPlanInfoService.selectCompleteSetAll(ap.getPlancode(), ap.getCompletesetcode());
					for (int i = 0; i < completeSetList.size(); i++) {
						//成套审批修改的数量为0就不展示了
						if(completeSetList.get(i).getRequiredsaudit()!=0) {
							assetPlanGlobalInfoAll.getLst().add(completeSetList.get(i));
						}
					}
				//无成套设备	
				}else {
					assetPlanGlobalInfoAll.getLst().add(ap);
				}
				//System.out.println("333-----"+System.currentTimeMillis());
				//有申购报告
				if(StringUtils.isNotBlank(ap.getIsreqpurchasereport()) && "1".equals(ap.getIsreqpurchasereport())) {
					String purchasereportid = ap.getPurchasereportid();
					List<PurchaseReportInfoExt> lstPur= purchaseReportInfoService.getByPurchaseReportID(purchasereportid);
					assetPlanGlobalInfoAll.setPurchaseReportInfo(lstPur);
				}else {
					assetPlanGlobalInfoAll.setPurchaseReportInfo(null);
				}
				//System.out.println("444-----"+System.currentTimeMillis());
				//有指定供应商
				if(StringUtils.isNotBlank(ap.getIsspecifymanufacturer()) && "1".equals(ap.getIsspecifymanufacturer())) {
					String specifymanufacturerid = ap.getSpecifymanufacturerid();
					List<SpecifyManufacturerInfoExt> lstSpec=specifyManufacturerInfoService.getBySpecifyManufacturerID(specifymanufacturerid);
					
					assetPlanGlobalInfoAll.setSpecifyManufacturerInfo(lstSpec);
				}else {
					assetPlanGlobalInfoAll.setSpecifyManufacturerInfo(null);
				}
				//System.out.println("555-----"+System.currentTimeMillis());
				for (int i = 0; i < assetPlanGlobalInfoAll.getLst().size(); i++) {
					String requireduser = assetPlanGlobalInfoAll.getLst().get(i).getRequireduser();
					UserInfo user = userService.getUserByEmpCode(requireduser);
					String requireduserNew=user.getEmpName()+"/"+requireduser;
					assetPlanGlobalInfoAll.getLst().get(i).setRequireduser(requireduserNew);
				}
			}
			
			if(assetPlanGlobalInfoAll.getLst().size()>0) {
				return ResponseResult.success(0, "查询成功", assetPlanGlobalInfoAll, assetPlanGlobalInfoAll.getLst().size());
			}else {
				return ResponseResult.fail(false,"查询失败，该条数据已删除");
			}
			
		/*} catch (Exception e) {
			e.printStackTrace();
			return ResponseResult.fail(false,"查询失败");
		}*/
	}
	
    @ApiOperation(value="查看单条资源信息（点击详情按钮查询页面专用）")
   	@GetMapping("/getAssetPlanInfoByIdForSearch")
   	@ResponseBody
   	@UserLoginToken
   	public ResponseResult getAssetPlanInfoByIdForSearch(@RequestParam @ApiParam(name="assetplanid",value="资源信息主键id",required=true)Integer assetplanid) throws Exception{
   		//try {
   			AssetPlanGlobalInfoAll assetPlanGlobalInfoAll = new AssetPlanGlobalInfoAll();
   			List<AssetPlanInfoDetailView> lst =new ArrayList<>();
   			assetPlanGlobalInfoAll.setLst(lst);
   			AssetPlanInfoDetailView ap = assetPlanInfoService.getByAssetID(assetplanid);
   			if(StringUtils.isNotBlank(ap.getDeleteflag()) && !"0".equals(ap.getDeleteflag()) ) {
   				//有成套设备
   				if(StringUtils.isNotBlank(ap.getIscompleteset()) && "1".equals(ap.getIscompleteset())) {
   					List<AssetPlanInfoDetailView> completeSetList = assetPlanInfoService.selectCompleteSetAll(ap.getPlancode(), ap.getCompletesetcode());
   					for (int i = 0; i < completeSetList.size(); i++) {
   						assetPlanGlobalInfoAll.getLst().add(completeSetList.get(i));
   					}
   				//无成套设备	
   				}else {
   					assetPlanGlobalInfoAll.getLst().add(ap);
   				}
   				//有申购报告
   				if(StringUtils.isNotBlank(ap.getIsreqpurchasereport()) && "1".equals(ap.getIsreqpurchasereport())) {
   					String purchasereportid = ap.getPurchasereportid();
   					List<PurchaseReportInfoExt> lstPur= purchaseReportInfoService.getByPurchaseReportID(purchasereportid);
   					assetPlanGlobalInfoAll.setPurchaseReportInfo(lstPur);   					
   				}else {
   					assetPlanGlobalInfoAll.setPurchaseReportInfo(null);
   				}
   				
   				//有指定供应商
   				if(StringUtils.isNotBlank(ap.getIsspecifymanufacturer()) && "1".equals(ap.getIsspecifymanufacturer())) {
   					String specifymanufacturerid = ap.getSpecifymanufacturerid();
   					List<SpecifyManufacturerInfoExt> lstSpec=specifyManufacturerInfoService.getBySpecifyManufacturerID(specifymanufacturerid);
   					assetPlanGlobalInfoAll.setSpecifyManufacturerInfo(lstSpec);
   				}else {
   					assetPlanGlobalInfoAll.setSpecifyManufacturerInfo(null);
   				}
   				for (int i = 0; i < assetPlanGlobalInfoAll.getLst().size(); i++) {
					String requireduser = assetPlanGlobalInfoAll.getLst().get(i).getRequireduser();
					UserInfo user = userService.getUserByEmpCode(requireduser);
					String requireduserNew=user.getEmpName()+"/"+requireduser;
					assetPlanGlobalInfoAll.getLst().get(i).setRequireduser(requireduserNew);
				}
   			}
   			
   			if(assetPlanGlobalInfoAll.getLst().size()>0) {
   				return ResponseResult.success(0, "查询成功", assetPlanGlobalInfoAll, assetPlanGlobalInfoAll.getLst().size());
   			}else {
   				return ResponseResult.fail(false,"查询失败，该条数据已删除");
   			}
   			
   		/*} catch (Exception e) {
   			e.printStackTrace();
   			return ResponseResult.fail(false,"查询失败");
   		}*/
   	}
    
    @ApiOperation(value="删除资源信息")
	@DeleteMapping("/delAssetPlanInfo")
	@ResponseBody
	@UserLoginToken(logType=LogType.DELETE)
	public ResponseResult delAssetPlanInfo(@RequestParam List<Integer> lstDelID) throws Exception{
		//try {
			List<Integer> newLstsubmitID =new ArrayList<>();
   			for (int i = 0; i < lstDelID.size(); i++) {
   				Integer assetplanid = lstDelID.get(i);
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
   			
			//根据主键删除，逻辑删，更新deleteflag这个标记（0无效,1有效）
			this.assetPlanInfoService.delAssetPlanInfo(newLstsubmitID);
			return ResponseResult.success(true, "删除成功");
		/*} catch (Exception e) {
			e.printStackTrace();
			return ResponseResult.fail(false,"删除失败");
		}*/
	}
	
    @ApiOperation(value="勾选提交指定资源信息(提交至规范审核)")
   	@PostMapping("/submitAssetPlanInfoByIds")
   	@ResponseBody
   	@UserLoginToken(logType=LogType.MODIFY)
   	public ResponseResult submitAssetPlanInfoByIds(@RequestBody AssetInfoSubmitEntity submitEntity) throws Exception{
   		//try {
   			//不选中的时候提示：请确认是否全部提交，选中提交的时候提示：请确认是否将所选物品及成套设备全部提交 
   			List<Integer> lstsubmitID = submitEntity.getLstsubmitID();
   			String applymonth = submitEntity.getApplymonth();
   			String applyuser = submitEntity.getApplyuser();
   			//申请人和申购人id的list,规范审核人code的list(后续邮件使用)
	   		List<String> newLstApplyRequiredUserID =new ArrayList<>();
	   		List<String> getsendToList =new ArrayList<>();
	   		List<Integer> newLstsubmitID =new ArrayList<>();
   			if(lstsubmitID.isEmpty()) {
   				//传过来的集合为空，说明全部提交
   				Map<String, Object> param = new HashMap<>();
   	   			param.put("ApplyUser",applyuser);
   				param.put("APStage","1");
   				param.put("ApplyMonth",applymonth);
   				//申请的单子
   				List<AssetPlanInfoAll> draftInfoList = assetPlanInfoService.listofDraftDetail(param);
   				//打回的单子
   				Map<String, Object> param1 = new HashMap<>();
   	   			param1.put("RequiredUser",applyuser);
   				param1.put("APStage","1");
   				param1.put("ApplyMonth",applymonth);
   				List<AssetPlanInfoAll> todoList = assetPlanInfoService.listofTodoDetail(param1);
   				//当前环节该登录人所有待提交的单子
   	   			for (int i = 0; i < draftInfoList.size(); i++) {
   	   				newLstsubmitID.add(draftInfoList.get(i).getAssetplanid());
   	   				newLstApplyRequiredUserID.add(draftInfoList.get(i).getApplyuser());
	   				newLstApplyRequiredUserID.add(draftInfoList.get(i).getRequireduser());
	   				getsendToList.add(draftInfoList.get(i).getReviewer());
   				}
   	   			for (int j = 0; j < todoList.size(); j++) {
	   				newLstsubmitID.add(todoList.get(j).getAssetplanid());
	   				newLstApplyRequiredUserID.add(todoList.get(j).getApplyuser());
	   				newLstApplyRequiredUserID.add(todoList.get(j).getRequireduser());
	   				getsendToList.add(todoList.get(j).getReviewer());
				}
   			}else {
   				//选中的部分提交
   	   			for (int i = 0; i < lstsubmitID.size(); i++) {
   	   				Integer assetplanid = lstsubmitID.get(i);
   	   				AssetPlanInfo ap = assetPlanInfoMapper.selectByPrimaryKey(assetplanid);
   	   				//有成套设备的话吗，得把成套设备的也一并提交
   	   				if(StringUtils.isNotBlank(ap.getIscompleteset()) && "1".equals(ap.getIscompleteset())) {
   	   					List<AssetPlanInfo> completeSetList = assetPlanInfoService.selectCompleteSet(ap.getPlancode(), ap.getCompletesetcode());
   	   					for (int j = 0; j < completeSetList.size(); j++) {
   	   						newLstsubmitID.add(completeSetList.get(j).getAssetplanid());
   	   						newLstApplyRequiredUserID.add(completeSetList.get(j).getApplyuser());
   	   						newLstApplyRequiredUserID.add(completeSetList.get(j).getRequireduser());
   	   						getsendToList.add(completeSetList.get(j).getReviewer());
   	   					}
   	   				//无成套设备	
   	   				}else {
   	   					newLstsubmitID.add(assetplanid);
   	   					newLstApplyRequiredUserID.add(ap.getApplyuser());
  						newLstApplyRequiredUserID.add(ap.getRequireduser());
  						getsendToList.add(ap.getReviewer());
   	   				}
   	   			}
   	   			newLstsubmitID=removeDuplicate(newLstsubmitID);
   			}
   			
   			List<AssetPlanInfo> lst=new ArrayList<>();
   			for (int j = 0; j < newLstsubmitID.size(); j++) {
   				AssetPlanInfo ap = assetPlanInfoMapper.selectByPrimaryKey(newLstsubmitID.get(j));
   				if("10".equals(ap.getApstatus())) {
   					ap.setApstatus("20");
   				}else if("11".equals(ap.getApstatus())) {
   					ap.setApstatus("21");
	   			}
   				ap.setApstage("2");
   				//规范审核标识统一改成未审核
   				ap.setReviewresult(3);
   				if(StringUtils.isNotBlank(ap.getReviewer())) {
	   			}else {
	   				return ResponseResult.fail(false, "无审批人信息，请联系系统管理员！");
	   			}
   				ap.setModifier(ap.getApplyuser());
   				ap.setModifitime(new Date());
   				lst.add(ap);
			}
   			assetPlanInfoService.batchEditAssetPlanInfo(lst);
   		
   			//提交之前对表RequestsNumApproveRecord创建记录数据，与主表对应
			for (int k = 0; k < newLstsubmitID.size(); k++) {
				RequestsNumApproveRecord record = recordMapper.selectByPrimaryKey(newLstsubmitID.get(k));
				if(record==null) {
					AssetPlanInfo ap = assetPlanInfoMapper.selectByPrimaryKey(newLstsubmitID.get(k));
   					Integer requiredsaudit = ap.getRequiredsaudit();
   					RequestsNumApproveRecord numApproveRecord = new RequestsNumApproveRecord();
   					numApproveRecord.setAssetplanid(newLstsubmitID.get(k));
   					numApproveRecord.setReviewercount(requiredsaudit);
   					recordMapper.insert(numApproveRecord);
				}
			}
   			
			//提交资源计划申请后，发送邮件给规范审核环节计划员，抄送申购人和申请人。
			//这个参数得先写死，到时候我这边写一个接口前台把这个url给我传过来
			String url="";
			List<String> ccTo =new ArrayList<>();
			List<String> sendTo =new ArrayList<>();
			getsendToList=removeDuplicate(getsendToList);
			for (int j = 0; j < getsendToList.size(); j++) {
				if(getsendToList.size()==1) {
					//发送给一个规范审核人得取所有的申请人和申购人去重一起抄送
					ccTo = removeDuplicate(newLstApplyRequiredUserID);
					//功能已实现，先注释，以免误发邮件
					mailInfoService.sendRemindMail(getsendToList.get(j).toString(), ccTo.toString(), "规范审核", url);
				}else {
					//发送给多个规范审核人得根据发送人查询申请人和申购人逐条发送
					Map<String,Object> param1=new HashMap<>();
		   			param1.put("id", newLstsubmitID);
		   			param1.put("Reviewer", getsendToList.get(j));
					List<AssetPlanInfo> infoListByReviewer = assetPlanInfoService.getInfoListByReviewer(param1);
					for(int k = 0; k < infoListByReviewer.size(); k++) {
						ccTo.add(infoListByReviewer.get(k).getApplyuser());
						ccTo.add(infoListByReviewer.get(k).getRequireduser());
					}
					ccTo = removeDuplicate(ccTo);
					sendTo.add(getsendToList.get(j));
					//功能已实现，先注释，以免误发邮件
					mailInfoService.sendRemindMail(getsendToList.get(j).toString(), ccTo.toString(), "规范审核", url);
					sendTo.clear();
					ccTo.clear();
				}
			}
			return ResponseResult.success(true, "提交成功");
   		/*} catch (Exception e) {
   			e.printStackTrace();
   			return ResponseResult.fail(false, "提交失败");
   		}*/
   	}
    
    @ApiOperation(value="返回厂家和对应的型号集合")
   	@GetMapping("/getAssetManufacturerList")
   	@ResponseBody
   	@UserLoginToken
   	public ResponseResult getAssetManufacturerList(String name) throws Exception{

   		//try {
   			
   			return ResponseResult.success(0, "查询成功", 0, 0, null, sysDicInfoService.getManuAndModel(name));
   		/*} catch (Exception e) {
   			e.printStackTrace();
   			return ResponseResult.fail(false, "查询失败");
   		}*/
   	}
   
    @ApiOperation(value="返回物品类别和相应的货期")
   	@GetMapping("/getAssetCategoryAndGoodstime")
   	@ResponseBody
   	@UserLoginToken
   	public ResponseResult getAssetCategoryAndGoodstime() throws Exception{
   		//try {
   			JSONArray arrayData = new JSONArray();
   			com.alibaba.fastjson.JSONArray objDic=dicService.getJSONArrayDicsByType(DicConst.R_CATEGORY);
   			
   			for (int i = 0; i < objDic.size(); i++) {
   				com.alibaba.fastjson.JSONObject obj= objDic.getJSONObject(i);
   				String value= obj.get("dic_name")==null?"":obj.get("dic_name").toString();
   				String[] arrvalue =value.split("_");
   				JSONObject json=new JSONObject();
   				json.put("id", obj.get("dic_code"));
   				json.put("assetcategory", arrvalue[2]);
   				json.put("goodstime", arrvalue[3]);
   				arrayData.add(json);
   			}
   			return ResponseResult.success(0, "查询成功", 0, 0, null, arrayData);
   		/*} catch (Exception e) {
   			e.printStackTrace();
   			return ResponseResult.fail(false, "查询失败");
   		}*/
   	}
    
    @ApiOperation(value="到货地点的下拉选择")
   	@GetMapping("/getReceiverPlaceList")
   	@ResponseBody
   	@UserLoginToken
   	public ResponseResult getReceiverPlaceList() throws Exception{
   		//try {
   			JSONArray arrayData = new JSONArray();
   			com.alibaba.fastjson.JSONArray objDic=dicService.getJSONArrayDicsByType(DicConst.R_ADDRESS);
   			
   			for (int i = 0; i < objDic.size(); i++) {
   				com.alibaba.fastjson.JSONObject obj= objDic.getJSONObject(i);
   				String value= obj.get("dic_name")==null?"":obj.get("dic_name").toString();
   				String[] arrvalue =value.split("_");
   				JSONObject json=new JSONObject();
   				
   				json.put("id", obj.get("dic_code"));
				json.put("receiverperson",  arrvalue[0]);
				json.put("receiverplace",  arrvalue[1]);
				json.put("receiverplacedetail",  arrvalue[2]);

   				arrayData.add(json);
   			}

   			return ResponseResult.success(0, "查询成功", 0, 0, null, arrayData);
   		/*} catch (Exception e) {
   			e.printStackTrace();
   			return ResponseResult.fail(false, "查询失败");
   		}*/
   	}
    
    @ApiOperation(value="根据申购人查询123级部门和计划员")
   	@GetMapping("/getInfoListByRequiredUser")
   	@ResponseBody
   	@UserLoginToken
   	public ResponseResult getInfoListByRequiredUser(@RequestParam @ApiParam(name="empCode",value="当前申购人工号",required=true)String empCode) throws Exception{
    	//try {
	    	UserInfo user = userService.getUserByEmpCode(empCode);
			if(user==null) {
				return ResponseResult.fail(false, "查询失败，该用户不存在");
			}else {
				String deptCode = user.getDeptCode();
				String dept1Code = user.getDept1Code();
				String dept2Code = user.getDept2Code();
				String dept3Code = user.getDept3Code();
				//三级部门名称
				String dept1Name="";
				String dept2Name="";
				String dept3Name = "";
				String dept3PlannerCode="";
				String dept3PlannerName="";
				//申购人的角色（1,2,3,0 分别表示：一级主管、二级主管、三级主管、普通用户）
				String requiredUserType="";
				
				if(StringUtils.isNotBlank(dept1Code)) {
					DeptInfo deptInfo1 = deptInfoMapper.selectByPrimaryKey(Integer.parseInt(dept1Code));
					//一级部门名称
					dept1Name = deptInfo1.getDeptName();
				}
				if(StringUtils.isNotBlank(dept2Code)) {
					DeptInfo deptInfo2 = deptInfoMapper.selectByPrimaryKey(Integer.parseInt(dept2Code));
					//二级部门名称
					dept2Name = deptInfo2.getDeptName();
				}
				if(StringUtils.isNotBlank(dept3Code)) {
					DeptInfo deptInfo3 = deptInfoMapper.selectByPrimaryKey(Integer.parseInt(dept3Code));
					//三级部门名称
					dept3Name = deptInfo3.getDeptName();
				}
				if(StringUtils.isBlank(dept3Code)) {
					if(StringUtils.isBlank(dept2Code)) {
						DeptInfo deptInfo1 = deptInfoMapper.selectByPrimaryKey(Integer.parseInt(dept1Code));
						//计划员工号
					    dept3PlannerCode = deptInfo1.getDeptPlannerCode();
						if(StringUtils.isNotBlank(dept3PlannerCode)) {
							UserInfo userByEmpCode = userService.getUserByEmpCode(dept3PlannerCode);
							if(userByEmpCode!=null) {
								//计划员姓名
								dept3PlannerName = userByEmpCode.getEmpName();
							}
						}
						//一级部门主管
						requiredUserType="1";
					}else {
						DeptInfo deptInfo2 = deptInfoMapper.selectByPrimaryKey(Integer.parseInt(dept2Code));
						//计划员工号
					    dept3PlannerCode = deptInfo2.getDeptPlannerCode();
						if(StringUtils.isNotBlank(dept3PlannerCode)) {
							UserInfo userByEmpCode = userService.getUserByEmpCode(dept3PlannerCode);
							if(userByEmpCode!=null) {
								//计划员姓名
								dept3PlannerName = userByEmpCode.getEmpName();
							}
						}
						//二级部门主管
						requiredUserType="2";
					}
				}else {
					//三级部门的人员或者四级部门的统一取三级部门的计划员
					DeptInfo deptInfo3 = deptInfoMapper.selectByPrimaryKey(Integer.parseInt(dept3Code));
					//计划员工号
				    dept3PlannerCode = deptInfo3.getDeptPlannerCode();
					if(StringUtils.isNotBlank(dept3PlannerCode)) {
						UserInfo userByEmpCode = userService.getUserByEmpCode(dept3PlannerCode);
						if(userByEmpCode!=null) {
							//计划员姓名
							dept3PlannerName = userByEmpCode.getEmpName();
						}
					}
		            DeptInfo deptManagerInfo = deptInfoService.getByDeptManagerCode(empCode);
		            if(deptManagerInfo==null) {
		            	//普通用户
		            	requiredUserType="0";
		            }else {
		            	//三级部门主管
		            	requiredUserType="3";
		            }
					
				}
					
					
				
				JSONObject json=new JSONObject();
				json.put("requireduser", empCode);
				json.put("dept1code", dept1Code);
				json.put("dept1name", dept1Name);
				json.put("dept2code", dept2Code);
				json.put("dept2name", dept2Name);
				json.put("dept3code", dept3Code);
				json.put("dept3name", dept3Name);
				json.put("dept3plannercode", dept3PlannerCode);
				json.put("dept3plannername", dept3PlannerName);
				json.put("requiredUserType", requiredUserType);
				
				return ResponseResult.success(0, "查询成功", json, 0);
			}
    	/*} catch (Exception e) {
   			e.printStackTrace();
   			return ResponseResult.fail(false, "查询失败");
   		}*/
    } 
    
    @ApiOperation(value="项目编码联想返回top20项目编码和项目名称")
   	@GetMapping("/getItemCodeTop20")
   	@ResponseBody
   	@UserLoginToken
   	public ResponseResult getItemCodeTop20(@RequestParam @ApiParam(name="itemCode",value="传过来的4位编码联想",required=true)String itemCode) throws Exception{
    	//try {
    		JSONArray arrayData = new JSONArray();
    		Map<String, Object> param = new HashMap<>();
			param.put("projectNo",itemCode);
			List<ProjectInfo> listofItemCode = assetPlanInfoService.getItemCodeTop20(param);
			for (int i = 0; i < listofItemCode.size(); i++) {
				JSONObject json=new JSONObject();
				json.put("itemcode", listofItemCode.get(i).getProjectNo());
				json.put("itemname", listofItemCode.get(i).getProjectName());
				arrayData.add(json);
			}
			
    		return ResponseResult.success(0, "查询成功", arrayData, 20);
    	/*} catch (Exception e) {
   			e.printStackTrace();
   			return ResponseResult.fail(false, "查询失败");
   		}*/
    }  
    
    
    @ApiOperation(value="展示待办列表信息")
   	@GetMapping("/getTodoInfoList")
   	@ResponseBody
   	@UserLoginToken
   	public ResponseResult getTodoInfoList(@RequestParam @ApiParam(name="applyUser",value="当前环节处理人（登录人）",required=true)String applyUser,
   			@RequestParam @ApiParam(name="apstage",value="物品所处的草稿阶段",required=true)String apstage,
   			@RequestParam @ApiParam(name="applymonth",value="申请月份",required=true)String applymonth,
   			@RequestParam @ApiParam(name="pageSize",value="每页行数",required=true)int pageSize,
   			@RequestParam @ApiParam(name="pageNum",value="页码",required=true)int pageNum) throws Exception{
    	//try {
   			//封装返回数据的表头信息
    		List<Map<String, Object>> columnList = sysDicInfoService.getColumn(DicConst.ASSETPLANINFOAPPLYVIEW);
    		
   			Map<String, Object> param = new HashMap<>();
   			JSONArray arrayData = new JSONArray();
   			JSONObject json=new JSONObject();
   			param.put("RequiredUser",applyUser);
			param.put("APStage",apstage);
			param.put("ApplyMonth",applymonth);
				
   			if(StringUtils.isNotBlank(applyUser)){
				if(StringUtils.isNotBlank(apstage) && apstage.contains("1")) {
					PageHelper.startPage(pageNum, pageSize);
					List<AssetPlanInfoAll> todoInfoList = assetPlanInfoService.listofTodoDetail(param);
					PageInfo<AssetPlanInfoAll> pageInfo = new PageInfo<AssetPlanInfoAll>(todoInfoList);
					if(todoInfoList.size()>0) {
		   				String totalmoneySum = assetPlanInfoService.getSumTotalMoneyForTodo(param);
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
    
    
    @ApiOperation(value="展示草稿列表信息")
   	@GetMapping("/getDraftInfoList")
   	@ResponseBody
   	@UserLoginToken
   	public ResponseResult getDraftInfoList(@RequestParam @ApiParam(name="applyUser",value="当前环节处理人（登录人）",required=true)String applyUser,
   			@RequestParam @ApiParam(name="apstage",value="物品所处的草稿阶段",required=true)String apstage,
   			@RequestParam @ApiParam(name="applymonth",value="申请月份",required=true)String applymonth,
   			@RequestParam @ApiParam(name="pageSize",value="每页行数",required=true)int pageSize,
   			@RequestParam @ApiParam(name="pageNum",value="页码",required=true)int pageNum) throws Exception{
    	//try {
   			//封装返回数据的表头信息
    		List<Map<String, Object>> columnList = sysDicInfoService.getColumn(DicConst.ASSETPLANINFOAPPLYVIEW);
    		
   			Map<String, Object> param = new HashMap<>();
   			JSONArray arrayData = new JSONArray();
   			JSONObject json=new JSONObject();
   			param.put("ApplyUser",applyUser);
			param.put("APStage",apstage);
			param.put("ApplyMonth",applymonth);
				
   			if(StringUtils.isNotBlank(applyUser)){
				if(StringUtils.isNotBlank(apstage) && apstage.contains("1")) {
					PageHelper.startPage(pageNum, pageSize);
					List<AssetPlanInfoAll> draftInfoList = assetPlanInfoService.listofDraftDetail(param);
					PageInfo<AssetPlanInfoAll> pageInfo = new PageInfo<AssetPlanInfoAll>(draftInfoList);
					if(draftInfoList.size()>0) {
		   				String totalmoneySum = assetPlanInfoService.getSumTotalMoneyForDraft(param);
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

    @ApiOperation(value="获取申购报告及指定供应商信息")
   	@GetMapping("/getTitleAndField")
   	@ResponseBody
   	@UserLoginToken
	public ResponseResult getTitleAndField() throws Exception {
    	AssetPlanGlobalInfoAll assetPlanGlobalInfoAll=new AssetPlanGlobalInfoAll();
    	assetPlanGlobalInfoAll.setPurchaseReportInfo(purchaseReportInfoService.getEmptyFiled());
    	assetPlanGlobalInfoAll.setSpecifyManufacturerInfo(specifyManufacturerInfoService.getEmptyFiled());	
		return ResponseResult.success(assetPlanGlobalInfoAll);
	}

}
