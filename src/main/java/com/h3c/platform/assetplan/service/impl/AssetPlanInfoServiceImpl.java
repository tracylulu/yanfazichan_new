package com.h3c.platform.assetplan.service.impl;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.h3c.platform.assetplan.dao.AssetPlanInfoApplyViewMapper;
import com.h3c.platform.assetplan.dao.AssetPlanInfoDept1ViewMapper;
import com.h3c.platform.assetplan.dao.AssetPlanInfoDept2ViewMapper;
import com.h3c.platform.assetplan.dao.AssetPlanInfoDept3ViewMapper;
import com.h3c.platform.assetplan.dao.AssetPlanInfoDetailViewMapper;
import com.h3c.platform.assetplan.dao.AssetPlanInfoHomePageViewMapper;
import com.h3c.platform.assetplan.dao.AssetPlanInfoMapper;
import com.h3c.platform.assetplan.dao.AssetPlanInfoMenuViewMapper;
import com.h3c.platform.assetplan.dao.AssetPlanInfoOQDeptViewMapper;
import com.h3c.platform.assetplan.dao.AssetPlanInfoPlannerViewMapper;
import com.h3c.platform.assetplan.dao.AssetPlanInfoReviewViewMapper;
import com.h3c.platform.assetplan.dao.AssetPlanInfoSearchViewMapper;
import com.h3c.platform.assetplan.dao.AssetPlanInfoTodoViewMapper;
import com.h3c.platform.assetplan.dao.DeptInfoMapper;
import com.h3c.platform.assetplan.dao.ProjectInfoMapper;
import com.h3c.platform.assetplan.dao.PurchaseReportInfoMapper;
import com.h3c.platform.assetplan.dao.RequestsNumApproveRecordMapper;
import com.h3c.platform.assetplan.dao.SpecifyManufacturerInfoMapper;
import com.h3c.platform.assetplan.entity.AssetPlanGlobalInfo;
import com.h3c.platform.assetplan.entity.AssetPlanGlobalInfoAll;
import com.h3c.platform.assetplan.entity.AssetPlanInfo;
import com.h3c.platform.assetplan.entity.AssetPlanInfoAll;
import com.h3c.platform.assetplan.entity.AssetPlanInfoApplyView;
import com.h3c.platform.assetplan.entity.AssetPlanInfoApplyViewExample;
import com.h3c.platform.assetplan.entity.AssetPlanInfoDept1View;
import com.h3c.platform.assetplan.entity.AssetPlanInfoDept2View;
import com.h3c.platform.assetplan.entity.AssetPlanInfoDept2ViewExample;
import com.h3c.platform.assetplan.entity.AssetPlanInfoDept3View;
import com.h3c.platform.assetplan.entity.AssetPlanInfoDept3ViewExample;
import com.h3c.platform.assetplan.entity.AssetPlanInfoDetailView;
import com.h3c.platform.assetplan.entity.AssetPlanInfoDetailViewExample;
import com.h3c.platform.assetplan.entity.AssetPlanInfoExample;
import com.h3c.platform.assetplan.entity.AssetPlanInfoHomePageView;
import com.h3c.platform.assetplan.entity.AssetPlanInfoMenuView;
import com.h3c.platform.assetplan.entity.AssetPlanInfoOQDeptView;
import com.h3c.platform.assetplan.entity.AssetPlanInfoPlannerView;
import com.h3c.platform.assetplan.entity.AssetPlanInfoPlannerViewExample;
import com.h3c.platform.assetplan.entity.AssetPlanInfoReviewView;
import com.h3c.platform.assetplan.entity.AssetPlanInfoReviewViewExample;
import com.h3c.platform.assetplan.entity.AssetPlanInfoSearchView;
import com.h3c.platform.assetplan.entity.DeptInfo;
import com.h3c.platform.assetplan.entity.DeptTreeInfo;
import com.h3c.platform.assetplan.entity.ProjectInfo;
import com.h3c.platform.assetplan.entity.PurchaseReportInfo;
import com.h3c.platform.assetplan.entity.RequestsNumApproveRecord;
import com.h3c.platform.assetplan.entity.SpecifyManufacturerInfo;
import com.h3c.platform.assetplan.service.AssetPlanInfoService;
import com.h3c.platform.common.service.PlanTimeWindowsService;
import com.h3c.platform.response.ResponseResult;
import com.h3c.platform.util.UserUtils;

@Service
public class AssetPlanInfoServiceImpl implements AssetPlanInfoService {
	
	@Autowired
	private AssetPlanInfoMapper assetPlanInfoMapper;
	@Autowired
	private AssetPlanInfoDetailViewMapper detailassetPlanInfoMapper;
	@Autowired
	private PurchaseReportInfoMapper priMapper;
	@Autowired
	private SpecifyManufacturerInfoMapper smiMapper;
	@Autowired
	private AssetPlanInfoApplyViewMapper applyViewMapper;
	@Autowired
	private AssetPlanInfoHomePageViewMapper homePageViewMapper;
	@Autowired
	private AssetPlanInfoReviewViewMapper reviewViewMapper;
	@Autowired
	private AssetPlanInfoDept3ViewMapper dept3ViewMapper;
	@Autowired
	private AssetPlanInfoDept2ViewMapper dept2ViewMapper;
	@Autowired
	private AssetPlanInfoPlannerViewMapper plannerViewMapper;
	@Autowired
	private AssetPlanInfoOQDeptViewMapper oqDeptViewMapper;
	@Autowired
	private AssetPlanInfoDept1ViewMapper dept1ViewMapper;
	@Autowired
	private RequestsNumApproveRecordMapper recordMapper;
	@Autowired
	private AssetPlanInfoSearchViewMapper searchViewMapper;
	@Autowired
	private DeptInfoMapper deptInfoMapper;
	@Autowired
	private ProjectInfoMapper projectInfoMapper;
	@Autowired
	private AssetPlanInfoMenuViewMapper menuViewMapper;
	@Autowired
	private PlanTimeWindowsService planTimeWindowsService;
	@Autowired
	private AssetPlanInfoTodoViewMapper todoViewMapper;
	
	/*@Override
	public int addAssetPlanInfo(AssetPlanInfo ap) {
		ap.setPlanmonth(new Date());
		ap.setApplytime(new Date());
		ap.setApplyuser("123123sad");
		ap.setModifier("123123sad");
		ap.setModifitime(new Date());
		return assetPlanInfoMapper.insert(ap);
	}*/

	/*@Override
	@Transactional
	public int batchAddAssetPlanInfo(List<AssetPlanInfo> lst)  {
		for(AssetPlanInfo ap:lst) {
			ap.setPlanmonth(new Date());
			ap.setApplytime(new Date());
			ap.setApplyuser("123123sad");
			ap.setModifier("123123sad");
			ap.setModifitime(new Date());
			assetPlanInfoMapper.insert(ap);
		}
		return lst.size();
	}*/
	
	@Override
 	public int editAssetPlanInfo(AssetPlanInfo assetPlanInfo) {		
 		return assetPlanInfoMapper.updateByPrimaryKey(assetPlanInfo);
 	}
	
	@Override
	@Transactional
 	public int batchEditAssetPlanInfo(List<AssetPlanInfo> lst) {
 		for(AssetPlanInfo ap:lst) {
			assetPlanInfoMapper.updateByPrimaryKey(ap);
		}
		return lst.size();
 	}

	
	@Override	
	@Transactional
	public void addAssetPlanInfo(AssetPlanGlobalInfo assetPlanGlobalInfo) {
		
		if(assetPlanGlobalInfo.purchaseReportInfo!=null) {
			assetPlanGlobalInfo.getPurchaseReportInfo().setDeleteflag("1");
			priMapper.insertBackID(assetPlanGlobalInfo.purchaseReportInfo);
		}
		if(assetPlanGlobalInfo.specifyManufacturerInfo!=null) {
			assetPlanGlobalInfo.getSpecifyManufacturerInfo().setDeleteflag("1");
			smiMapper.insertBackID(assetPlanGlobalInfo.specifyManufacturerInfo);
		}
		//初始化成套设备的code
		Integer completesetcode = initApplyCode();
		for(AssetPlanInfo ap : assetPlanGlobalInfo.lst) {
			//是否需要申购报告字段为1时才会增加，set主表字段purchasereportid为关联表的id，否则设置默认值为0
			if(StringUtils.isNotBlank(ap.getIsreqpurchasereport()) && "1".equals(ap.getIsreqpurchasereport())) {
				ap.setPurchasereportid(assetPlanGlobalInfo.purchaseReportInfo.getPurchasereportid());	
			}else {
				ap.setPurchasereportid(0);
			}			
			//是否指定供应商字段为1时才会增加 ，set主表字段specifymanufacturerid为关联表的id，否则设置默认值为0
			if(StringUtils.isNotBlank(ap.getIsspecifymanufacturer()) && "1".equals(ap.getIsspecifymanufacturer())) {
				ap.setSpecifymanufacturerid(assetPlanGlobalInfo.specifyManufacturerInfo.getSpecifymanufacturerid());		
			}else {
				ap.setSpecifymanufacturerid(0);
			}
			//是否成套物品字段为1时说明是成套的设备,set套装编码,否则设置默认值为0
			if(StringUtils.isNotBlank(ap.getIscompleteset()) && "1".equals(ap.getIscompleteset())) {
				ap.setCompletesetcode(completesetcode);
			}else {
				ap.setCompletesetcode(0);
			}
			try {
				ap.setApplytime(new Date());
				ap.setModifitime(new Date());
				
				//正常计划外的状态 0正常计划，1计划员激活，2管理员激活
				//时间窗外创建的置为1，时间窗内置为0，得调向楠那边的时间接口
				boolean flag = planTimeWindowsService.valitSubmitTimeWiondow();
				//返回true说明在窗口内
				if(flag) {
					ap.setAbnormalplanenum(0);
				}else {
					ap.setAbnormalplanenum(1);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			//设置默认的值
			ap.setApstatus("10");
			ap.setApstage("1");
			ap.setDeleteflag("1");
			ap.setOuttimeplanenum(-1);
			//Applyuser Modifier这两个字段前端传过来了
			int insert = assetPlanInfoMapper.insert(ap);
		}
	}
	
	@Override	
	@Transactional
	public void editAssetPlanInfo(AssetPlanGlobalInfo assetPlanGlobalInfo) {
		String currentUserId = UserUtils.getCurrentUserId();
		if(assetPlanGlobalInfo.purchaseReportInfo!=null) {
			assetPlanGlobalInfo.purchaseReportInfo.setModifier(currentUserId);
			assetPlanGlobalInfo.purchaseReportInfo.setModifitime(new Date());
			priMapper.updateByPrimaryKey(assetPlanGlobalInfo.purchaseReportInfo);
		}
		
		if(assetPlanGlobalInfo.specifyManufacturerInfo!=null) {
			assetPlanGlobalInfo.specifyManufacturerInfo.setModifier(currentUserId);
			assetPlanGlobalInfo.specifyManufacturerInfo.setModifitime(new Date());
			smiMapper.updateByPrimaryKey(assetPlanGlobalInfo.specifyManufacturerInfo);
		}		
		
		for(AssetPlanInfo ap:assetPlanGlobalInfo.lst) {
			ap.setModifier(currentUserId);
			ap.setModifitime(new Date());
			assetPlanInfoMapper.updateByPrimaryKey(ap);
		}
	}
	
	@Override	
	@Transactional
	public int delAssetPlanInfo(List<Integer> lstDelID){
		Map<String,Object> param=new HashMap<>();
		param.put("id", lstDelID);
		param.put("Modifier", "delete");
		return  assetPlanInfoMapper.deleteByID(param);
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
	
	/*@Override
	@Transactional
	public int editQuantity(AssetPlanInfo assetPlanlInfo) {				
		AssetPlanInfo old = assetPlanInfoMapper.selectByPrimaryKey(assetPlanlInfo.getAssetplanid());
		return 0;
	}*/

	@Override	
	@Transactional
	public int submitAssetPlanInfoByIds(Map<String, Object> param){
		return  assetPlanInfoMapper.submitAssetPlanInfoByIds(param);
	}
	
	
	@Override
	public List<AssetPlanInfo> selectCompleteSet(String planCode, Integer completeSetCode) {
		AssetPlanInfoExample example=new AssetPlanInfoExample();
		AssetPlanInfoExample.Criteria cia=example.createCriteria();
		cia.andPlancodeEqualTo(planCode);
		cia.andCompletesetcodeEqualTo(completeSetCode);
		cia.andDeleteflagEqualTo("1");
		return assetPlanInfoMapper.selectByExample(example);
	}

	/*@Override
	public List<AssetPlanInfoApplyView> getAssetPlanInfoList(String applyUser) {
		AssetPlanInfoApplyViewExample example=new AssetPlanInfoApplyViewExample();
		AssetPlanInfoApplyViewExample.Criteria cia=example.createCriteria();
		cia.andApplyuserEqualTo(applyUser);
		cia.andDeleteflagEqualTo("1");
		return applyViewMapper.selectByExample(example);
		
	}*/

	@Override
	public List<AssetPlanInfoMenuView> listofTodoInfo(Map<String, Object> param) {
		return menuViewMapper.listofTodoInfo(param);
	}

	@Override
	public int countTodoInfo(Map<String, Object> param) {
		return menuViewMapper.countTodoInfo(param);
	}

	@Override
	public List<AssetPlanInfo> listofTodoInfoDetail(Map<String, Object> param) {
		return assetPlanInfoMapper.listofTodoInfoDetail(param);
	}

	@Override
	public int countTodoInfoDetail(Map<String, Object> param) {
		return assetPlanInfoMapper.countTodoInfoDetail(param);
	}

	/*@Override
	public List<AssetPlanInfoApplyView> getDraftInfoList(String applyUser, String apstage,String applymonth) {
		AssetPlanInfoApplyViewExample example=new AssetPlanInfoApplyViewExample();
		AssetPlanInfoApplyViewExample.Criteria cia=example.createCriteria();
		cia.andApplyuserEqualTo(applyUser);
		cia.andApstageEqualTo(apstage);
		cia.andApplymonthEqualTo(applymonth);
		cia.andDeleteflagEqualTo("1");
		return applyViewMapper.selectByExample(example);
	}*/
	
	/*@Override
	public List<AssetPlanInfoReviewView> getReviewInfoList(String reviewer, String applymonth) {
		AssetPlanInfoReviewViewExample example=new AssetPlanInfoReviewViewExample();
		AssetPlanInfoReviewViewExample.Criteria cia=example.createCriteria();
		cia.andReviewerEqualTo(reviewer);
		cia.andApplymonthEqualTo(applymonth);
		cia.andDeleteflagEqualTo("1");
		return reviewViewMapper.selectByExample(example);
	}*/

	/*@Override
	public List<AssetPlanInfoDept3View> getDept3InfoList(String dept3Manager, String apstage) {
		AssetPlanInfoDept3ViewExample example=new AssetPlanInfoDept3ViewExample();
		AssetPlanInfoDept3ViewExample.Criteria cia=example.createCriteria();
		cia.andDept3managerEqualTo(dept3Manager);
		cia.andApstageEqualTo(apstage);
		//是未删除的
		cia.andDeleteflagEqualTo("1");
		//是规范审核状态的
		cia.andReviewresultEqualTo(1);
		return dept3ViewMapper.selectByExample(example);
	}*/

	/*@Override
	public List<AssetPlanInfoDept2View> getDept2InfoList(String dept2Manager, String apstage) {
		AssetPlanInfoDept2ViewExample example=new AssetPlanInfoDept2ViewExample();
		AssetPlanInfoDept2ViewExample.Criteria cia=example.createCriteria();
		cia.andDept2managerEqualTo(dept2Manager);
		cia.andApstageEqualTo(apstage);
		//是未删除的
		cia.andDeleteflagEqualTo("1");
		//是规范审核状态的
		cia.andReviewresultEqualTo(1);
		return dept2ViewMapper.selectByExample(example);
	}*/

	@Override
	public int submitInfoFromReviewToDept3(Map<String, Object> param) {
		return  assetPlanInfoMapper.submitInfoFromReviewToDept3(param);
	}

	@Override
	public int submitInfoFromDept3ToDept2(Map<String, Object> param) {
		return  assetPlanInfoMapper.submitInfoFromDept3ToDept2(param);
	}

	@Override
	public int submitInfoFromDept2ToPlanner(Map<String, Object> param) {
		return  assetPlanInfoMapper.submitInfoFromDept2ToPlanner(param);
	}

	@Override
	public int submitInfoFromPlannerToOQDept(Map<String, Object> param) {
		return  assetPlanInfoMapper.submitInfoFromPlannerToOQDept(param);
	}
	
	@Override
	public int submitInfoFromOQDeptToDept1(Map<String, Object> param) {
		return  assetPlanInfoMapper.submitInfoFromOQDeptToDept1(param);
	}
	
	@Override
	public int submitInfoFromDept1ToEnd(Map<String, Object> param) {
		return  assetPlanInfoMapper.submitInfoFromDept1ToEnd(param);
	}
	
	@Override
	public List<AssetPlanInfoAll> listofPlannerDetail(Map<String, Object> param) {
		return plannerViewMapper.listofPlannerDetail(param);
	}

	/*@Override
	public String getSumCountBeforeForPlanner(Map<String, Object> param) {
		return plannerViewMapper.getSumCountBeforeForPlanner(param);
	}*/

	/*@Override
	public String getSumCountAfterForPlanner(Map<String, Object> param) {
		return plannerViewMapper.getSumCountAfterForPlanner(param);
	}*/

	/*@Override
	public String getSumMoneyBeforeForPlanner(Map<String, Object> param) {
		return plannerViewMapper.getSumMoneyBeforeForPlanner(param);
	}*/

	/*@Override
	public String getSumMoneyAfterForPlanner(Map<String, Object> param) {
		return plannerViewMapper.getSumMoneyAfterForPlanner(param);
	}*/
	
	@Override
	public List<Integer> getPlannerListForFlag(Map<String, Object> param) {
		return plannerViewMapper.getListForFlag(param);
	}
	
	@Override
	public Map<String,Object>getPlannerGroupMess( Map<String, Object> param){
		return plannerViewMapper.getGroupMess(param);
	}
	
	@Override
	public Integer getPlannerListSize( Map<String, Object> param){
		return plannerViewMapper.getListSize(param);
	}

	@Override
	public List<AssetPlanInfoAll> listofOQDeptDetail(Map<String, Object> param) {
		return oqDeptViewMapper.listofOQDeptDetail(param);
	}
    
	/*@Override
	public String getSumCountBeforeForOQDept(Map<String, Object> param) {
		return oqDeptViewMapper.getSumCountBeforeForOQDept(param);
	}*/

	/*@Override
	public String getSumCountAfterForOQDept(Map<String, Object> param) {
		return oqDeptViewMapper.getSumCountAfterForOQDept(param);
	}*/

	/*@Override
	public String getSumMoneyBeforeForOQDept(Map<String, Object> param) {
		return oqDeptViewMapper.getSumMoneyBeforeForOQDept(param);
	}*/

	/*@Override
	public String getSumMoneyAfterForOQDept(Map<String, Object> param) {
		return oqDeptViewMapper.getSumMoneyAfterForOQDept(param);
	}*/
	
	@Override
	public List<Integer> getOQDeptListForFlag(Map<String, Object> param) {
		return oqDeptViewMapper.getListForFlag(param);
	}
    
	@Override
	public Map<String,Object>getOQDeptGroupMess(Map<String, Object> param){
		return oqDeptViewMapper.getGroupMess(param);
	}
    
	@Override
	public Integer getOQDeptListSize(Map<String, Object> param) {
		return oqDeptViewMapper.getListSize(param);
	}

	@Override
	public List<AssetPlanInfoAll> listofDept1Detail(Map<String, Object> param) {
		return dept1ViewMapper.listofDept1Detail(param);
	}

	/*@Override
	public String getSumCountBeforeForDept1(Map<String, Object> param) {
		return dept1ViewMapper.getSumCountBeforeForDept1(param);
	}*/

	/*@Override
	public String getSumCountAfterForDept1(Map<String, Object> param) {
		return dept1ViewMapper.getSumCountAfterForDept1(param);
	}*/

	/*@Override
	public String getSumMoneyBeforeForDept1(Map<String, Object> param) {
		return dept1ViewMapper.getSumMoneyBeforeForDept1(param);
	}*/

	/*@Override
	public String getSumMoneyAfterForDept1(Map<String, Object> param) {
		return dept1ViewMapper.getSumMoneyAfterForDept1(param);
	}*/
	
	@Override
	public List<Integer> getDept1ListForFlag(Map<String, Object> param) {
		return dept1ViewMapper.getListForFlag(param);
	}
	
	@Override
	public Map<String,Object>getDept1GroupMess( Map<String, Object> param){
		return dept1ViewMapper.getGroupMess(param);
	}
	
	@Override
	public Integer getDept1ListSize( Map<String, Object> param){
		return dept1ViewMapper.getListSize(param);
	}

	@Override
	public String getSumTotalMoneyForReview(Map<String, Object> param) {
		return reviewViewMapper.getSumTotalMoneyForReview(param);
	}

	@Override
	public List<AssetPlanInfoAll> getReviewResult(Map<String, Object> param) {
		return reviewViewMapper.getReviewResult(param);
	}

	@Override
	public String getSumTotalMoneyForDept3(Map<String, Object> param) {
		return dept3ViewMapper.getSumTotalMoneyForDept3(param);
	}

	@Override
	public String getSumActualMoneySumForDept3(Map<String, Object> param) {
		return dept3ViewMapper.getSumActualMoneySumForDept3(param);
	}

	@Override
	public String getSumTotalMoneyForDept2(Map<String, Object> param) {
		return dept2ViewMapper.getSumTotalMoneyForDept2(param);
	}
	
	@Override
	public String getSumMoneyWithThirdDept(Map<String, Object> param) {
		return dept2ViewMapper.getSumMoneyWithThirdDept(param);
	}

	@Override
	public String getSumActualMoneySumForDept2(Map<String, Object> param) {
		return dept2ViewMapper.getSumActualMoneySumForDept2(param);
	}

	@Override
	public String getSumTotalMoneyForDraft(Map<String, Object> param) {
		return applyViewMapper.getSumTotalMoneyForDraft(param);
	}

	@Override
	public int activateAssetPlanInfoByIds(Map<String, Object> param) {
		return assetPlanInfoMapper.activateAssetPlanInfoByIds(param);
	}

	@Override
	public List<AssetPlanInfoSearchView> exportAssetPlanInfoByIds(Map<String, Object> param) {
		return searchViewMapper.exportAssetPlanInfoByIds(param);
	}

	@Override
	public List<DeptInfo> getDeptInfoList() {
		return deptInfoMapper.getDeptInfoList();
	}

	@Override
	public List<AssetPlanInfo> getNotReviewList(Map<String, Object> param) {
		return assetPlanInfoMapper.getNotReviewList(param);
	}

	@Override
	public List<String> getNotReviewApplyUserList(Map<String, Object> param) {
		return reviewViewMapper.getNotReviewApplyUserList(param);
	}

	@Override
	public List<AssetPlanInfoReviewView> getNotReviewListByApplyUser(Map<String, Object> param) {
		return reviewViewMapper.getNotReviewListByApplyUser(param);
	}

	@Override
	public List<ProjectInfo> getItemCodeTop20(Map<String,Object> param) {
		return projectInfoMapper.getItemCodeTop20(param);
	}

	@Override
	public List<String> getItemNameByItemCode(Map<String, Object> param) {
		return projectInfoMapper.getItemNameByItemCode(param);
	}

	@Override
	public List<AssetPlanInfoDetailView> selectCompleteSetAll(String planCode, Integer completeSetCode) {
		AssetPlanInfoDetailViewExample example=new AssetPlanInfoDetailViewExample();
		AssetPlanInfoDetailViewExample.Criteria cia=example.createCriteria();
		cia.andPlancodeEqualTo(planCode);
		cia.andCompletesetcodeEqualTo(completeSetCode);
		return detailassetPlanInfoMapper.selectByExample(example);
	}

	@Override
	public AssetPlanInfoDetailView getByAssetID(Integer assetplanid) {
		return detailassetPlanInfoMapper.getByAssetID(assetplanid);
	}

	@Override
	public List<AssetPlanInfo> getInfoListByReviewer(Map<String, Object> param) {
		return assetPlanInfoMapper.getInfoListByReviewer(param);
	}

	@Override
	public List<Integer> getAllReviewList(Map<String, Object> param) {
		return reviewViewMapper.getAllReviewList(param);
	}

	@Override
	public List<AssetPlanInfoAll> listofDept2Detail(Map<String, Object> param) {
		return dept2ViewMapper.listofDept2Detail(param);
	}

	@Override
	public List<AssetPlanInfoAll> listofDept3Detail(Map<String, Object> param) {
		return dept3ViewMapper.listofDept3Detail(param);
	}

	@Override
	public List<AssetPlanInfoAll> listofReviewDetail(Map<String, Object> param) {
		return reviewViewMapper.listofReviewDetail(param);
	}

	@Override
	public List<AssetPlanInfoAll> listofDraftDetail(Map<String, Object> param) {
		return applyViewMapper.listofDraftDetail(param);
	}

	@Override
	public String getBudgetSum(Map<String, Object> param) {
		return searchViewMapper.getBudgetSum(param);
	}

	@Override
	public String getBudgetTotalMoneyForDept3(Map<String, Object> param) {
		return dept3ViewMapper.getBudgetTotalMoneyForDept3(param);
	}

	@Override
	@Transactional
	public ResponseResult updateReviewResult(List<Integer> ids,Integer result,String reviewNote) throws Exception {
		Map<String,Object> param =new HashMap<String, Object>();
		param.put("result", result);
		param.put("reviewNote", reviewNote);
		param.put("modifier", UserUtils.getCurrentUserId());
		param.put("modifiTime", new Date());
		param.put("id",ids);
		if(result.equals(1)) {
			param.put("apstage", "2");
			param.put("apstatus", "20");
		}else if(result.equals(2)) {
			param.put("apstage", "1");
			param.put("apstatus", "11");
		}
		assetPlanInfoMapper.updateReviewResult(param);
		return ResponseResult.success(true,"修改成功");
	}

	@Override
	public String getSumTotalMoneyForTodo(Map<String, Object> param) {
		return todoViewMapper.getSumTotalMoneyForTodo(param);
	}

	@Override
	public List<AssetPlanInfoAll> listofTodoDetail(Map<String, Object> param) {
		return todoViewMapper.listofTodoDetail(param);
	}

	@Override
	public List<AssetPlanInfoMenuView> listofTodoInfoForRequiredUser(Map<String, Object> param) {
		return menuViewMapper.listofTodoInfoForRequiredUser(param);
	}

	/*@Override
	public List<AssetPlanInfoAll> listofPlannerDetailAfter(Map<String, Object> param) {
		return plannerViewMapper.listofPlannerDetailAfter(param);
	}*/

	/*@Override
	public List<AssetPlanInfoAll> listofOQDeptDetailAfter(Map<String, Object> param) {
		return oqDeptViewMapper.listofOQDeptDetailAfter(param);
	}*/

	

	
}
