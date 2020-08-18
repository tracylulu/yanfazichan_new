package com.h3c.platform.assetplan.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.h3c.platform.assetplan.entity.AssetPlanGlobalInfo;
import com.h3c.platform.assetplan.entity.AssetPlanGlobalInfoAll;
import com.h3c.platform.assetplan.entity.AssetPlanInfo;
import com.h3c.platform.assetplan.entity.AssetPlanInfoAll;
import com.h3c.platform.assetplan.entity.AssetPlanInfoApplyView;
import com.h3c.platform.assetplan.entity.AssetPlanInfoDept1View;
import com.h3c.platform.assetplan.entity.AssetPlanInfoDept2View;
import com.h3c.platform.assetplan.entity.AssetPlanInfoDept3View;
import com.h3c.platform.assetplan.entity.AssetPlanInfoDetailView;
import com.h3c.platform.assetplan.entity.AssetPlanInfoExample;
import com.h3c.platform.assetplan.entity.AssetPlanInfoHomePageView;
import com.h3c.platform.assetplan.entity.AssetPlanInfoMenuView;
import com.h3c.platform.assetplan.entity.AssetPlanInfoOQDeptView;
import com.h3c.platform.assetplan.entity.AssetPlanInfoPlannerView;
import com.h3c.platform.assetplan.entity.AssetPlanInfoReviewView;
import com.h3c.platform.assetplan.entity.AssetPlanInfoSearchExportView;
import com.h3c.platform.assetplan.entity.AssetPlanInfoSearchView;
import com.h3c.platform.assetplan.entity.DeptInfo;
import com.h3c.platform.assetplan.entity.DeptTreeInfo;
import com.h3c.platform.assetplan.entity.ProjectInfo;
import com.h3c.platform.assetplan.entity.PurchaseReportInfo;
import com.h3c.platform.assetplan.entity.SpecifyManufacturerInfo;
import com.h3c.platform.response.ResponseResult;

public interface AssetPlanInfoService {
	
	//int addAssetPlanInfo(AssetPlanInfo ap);
	
	//int batchAddAssetPlanInfo(List<AssetPlanInfo> lst);
	
	int editAssetPlanInfo(AssetPlanInfo assetPlanInfo);
	
	/**
	 * 更新规范性审核流程状态，回写使用率
	 * @param lst
	 * @return
	 */
	int batchEditAssetPlanAndRate(List<AssetPlanInfo> lst,List<Integer> lstID) throws Exception;
	
	int batchEditAssetPlanInfo(List<AssetPlanInfo> lst);
	
	void syncUsageRateTask() throws Exception ;
	
	/**
	 * 添加打包
	 * @param lst
	 * @param smf
	 * @param pri
	 */
	void addAssetPlanInfo(AssetPlanGlobalInfo assetPlanGlobalInfo);
	
	/**
	 * 修改打包
	 * @param lst
	 * @param smf
	 * @param pri
	 * @return
	 */
	void editAssetPlanInfo(AssetPlanGlobalInfo assetPlanGlobalInfo);
	
	/**
	 * 根据ID状态失效
	 * @param id
	 * @return
	 */
	int delAssetPlanInfo(List<Integer> lstDelID);
	
	/**
	 * 修改数量
	 * @param assetPlanlInfo
	 * @return
	 */
	//int editQuantity(AssetPlanInfo assetPlanlInfo);
	
	AssetPlanInfoDetailView getByAssetId(Integer assetplanid);
	
	
	//查询成套设备
	List<AssetPlanInfo> selectCompleteSet(String planCode,Integer completeSetCode);
	
	//查询成套设备
	List<AssetPlanInfoDetailView> selectCompleteSetAll(String planCode,Integer completeSetCode);
		
	int submitAssetPlanInfoByIds(Map<String, Object> param);
	
	//根据申请人code查询申请人资源列表信息
	//List<AssetPlanInfoApplyView> getAssetPlanInfoList(String applyUser);

	
	List<AssetPlanInfoMenuView> listofTodoInfo(Map<String, Object> param);            
    
	List<AssetPlanInfoMenuView> listofTodoInfoForRequiredUser(Map<String, Object> param);
	
    int countTodoInfo(Map<String, Object> param);
    
    List<AssetPlanInfo> listofTodoInfoDetail(Map<String, Object> param);   
    
    int countTodoInfoDetail(Map<String, Object> param);
    
    //根据申请人code查询申请人资源列表草稿信息
  	//List<AssetPlanInfoApplyView> getDraftInfoList(String applyUser,String apstage,String applymonth);
  	
  	//根据申请人code和状态查询规范审核列表信息
  	//List<AssetPlanInfoReviewView> getReviewInfoList(String reviewer,String applymonth);
  	
  	//根据申请人code和状态查询三级部门审核列表信息
  	//List<AssetPlanInfoDept3View> getDept3InfoList(String dept3Manager,String apstage);
    
  	//根据申请人code和状态查询二级部门审核列表信息
  	//List<AssetPlanInfoDept2View> getDept2InfoList(String dept2Manager,String apstage);
  	
  	int submitInfoFromReviewToDept3(Map<String, Object> param);
  	
  	int submitInfoFromDept3ToDept2(Map<String, Object> param);
  	
  	int submitInfoFromDept2ToPlanner(Map<String, Object> param);
  	
  	int submitInfoFromPlannerToOqDept(Map<String, Object> param); 
  	
  	int submitInfoFromOqDeptToDept1(Map<String, Object> param); 
  	
  	int submitInfoFromDept1ToEnd(Map<String, Object> param); 
  	
  	List<AssetPlanInfoAll> listofPlannerDetail(Map<String, Object> param);
  	
  	//String getSumCountBeforeForPlanner(Map<String, Object> param); 
    
  	//String getSumCountAfterForPlanner(Map<String, Object> param); 
    
  	//String getSumMoneyBeforeForPlanner(Map<String, Object> param); 
    
  	//String getSumMoneyAfterForPlanner(Map<String, Object> param); 
  	
  	List<AssetPlanInfoAll> listofOqDeptDetail(Map<String, Object> param);
  	
  	//String getSumCountBeforeForOQDept(Map<String, Object> param); 
    
  	//String getSumCountAfterForOQDept(Map<String, Object> param); 
    
  	//String getSumMoneyBeforeForOQDept(Map<String, Object> param); 
    
  	//String getSumMoneyAfterForOQDept(Map<String, Object> param); 
  	
  	List<Integer> getOQDeptListForFlag(Map<String, Object> param) ;
    
    Map<String,Object>getOQDeptGroupMess(Map<String, Object> param);
    
    Integer getOQDeptListSize(Map<String, Object> param);
  	
  	List<AssetPlanInfoAll> listofDept1Detail(Map<String, Object> param);
  	
  	List<AssetPlanInfoAll> listofDept2Detail(Map<String, Object> param);
  	
  	List<AssetPlanInfoAll> listofDept3Detail(Map<String, Object> param);
  	
  	List<AssetPlanInfoAll> listofReviewDetail(Map<String, Object> param);
  	
  	List<AssetPlanInfoAll> listofDraftDetail(Map<String, Object> param);
  	
  	//String getSumCountBeforeForDept1(Map<String, Object> param); 
    
  	//String getSumCountAfterForDept1(Map<String, Object> param); 
    
  	//String getSumMoneyBeforeForDept1(Map<String, Object> param); 
    
  	//String getSumMoneyAfterForDept1(Map<String, Object> param);
  	
  	List<Integer> getDept1ListForFlag(Map<String, Object> param);
	
	Map<String,Object>getDept1GroupMess( Map<String, Object> param);
	
	Integer getDept1ListSize( Map<String, Object> param);
  	
  	String getSumTotalMoneyForReview(Map<String, Object> param);
  	
  	String getSumTotalMoneyForDraft(Map<String, Object> param);
  	
  	List<AssetPlanInfoAll> getReviewResult(Map<String, Object> param);
  	
  	 String getSumTotalMoneyForDept3(Map<String, Object> param);
     
     String getSumActualMoneySumForDept3(Map<String, Object> param);
  	
     String getSumTotalMoneyForDept2(Map<String, Object> param);
     
      String getSumMoneyWithThirdDept(Map<String, Object> param);
     
     String getSumActualMoneySumForDept2(Map<String, Object> param);

     List<Integer> getPlannerListForFlag(Map<String, Object> param) ;
     
     Map<String,Object>getPlannerGroupMess(Map<String, Object> param);
     
     Integer getPlannerListSize(Map<String, Object> param);
  	
     int activateAssetPlanInfoByIds(Map<String,Object> param);   
  	
     List<AssetPlanInfoSearchExportView> exportAssetPlanInfoByIds(Map<String, Object> param); 
  	
     List<DeptInfo> getDeptInfoList();
     
     List<DeptInfo> getDeptInfoListValid();
  	
     List<AssetPlanInfo> getNotReviewList(Map<String, Object> param);
     
     List<String> getNotReviewApplyUserList(Map<String, Object> param);
     
     List<Integer> getAllReviewList(Map<String, Object> param);
     
     List<AssetPlanInfoReviewView> getNotReviewListByApplyUser(Map<String, Object> param);
  	
     List<ProjectInfo> getItemCodeTop20(Map<String,Object> param);
     
     List<String> getItemNameByItemCode(Map<String,Object> param);
     
     List<AssetPlanInfo> getInfoListByReviewer(Map<String, Object> param);
     
     String getBudgetSum(Map<String, Object> param);
     
     String getBudgetTotalMoneyForDept3(@Param("param") Map<String, Object> param);
     
     ResponseResult updateReviewResult(List<Integer> ids,Integer result,String reviewNote) throws Exception;
     
     //List<AssetPlanInfoAll> listofPlannerDetailAfter(Map<String, Object> param);
     
     //List<AssetPlanInfoAll> listofOQDeptDetailAfter(Map<String, Object> param);
     
     String getSumTotalMoneyForTodo(Map<String, Object> param);
     
     List<AssetPlanInfoAll> listofTodoDetail(Map<String, Object> param);
     
     List<AssetPlanInfoPlannerView> exportAssetPlanInfoForPlanner(Map<String, Object> param);
     
     List<Integer> getAllReviewListForGuiFan(Map<String, Object> param);
     
     List<AssetPlanInfoAll> getSearchResultForReview(Map<String, Object> param);
     
     /**
      * 根据ID集合获取数据
      * @param lst
      * @return
      */
     List<AssetPlanInfo> selectByIds(List<String> lst);
}
