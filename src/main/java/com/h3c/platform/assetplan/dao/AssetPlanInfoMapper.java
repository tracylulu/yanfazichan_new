package com.h3c.platform.assetplan.dao;

import com.h3c.platform.assetplan.entity.AssetPlanInfo;
import com.h3c.platform.assetplan.entity.AssetPlanInfoExample;
import com.h3c.platform.assetplan.entity.AssetPlanInfoHomePageView;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface AssetPlanInfoMapper {
    long countByExample(AssetPlanInfoExample example);

    int deleteByExample(AssetPlanInfoExample example);

    int deleteByPrimaryKey(Integer assetplanid);

    int insert(AssetPlanInfo record);

    int insertSelective(AssetPlanInfo record);

    List<AssetPlanInfo> selectByExample(AssetPlanInfoExample example);

    AssetPlanInfo selectByPrimaryKey(Integer assetplanid);

    int updateByExampleSelective(@Param("record") AssetPlanInfo record, @Param("example") AssetPlanInfoExample example);

    int updateByExample(@Param("record") AssetPlanInfo record, @Param("example") AssetPlanInfoExample example);

    int updateByPrimaryKeySelective(AssetPlanInfo record);

    int updateByPrimaryKey(AssetPlanInfo record);
    
    
    
    int deleteByID(@Param("param") Map<String,Object> param); 
    
    int submitAssetPlanInfoByIds(@Param("param") Map<String,Object> param);    
    
    Integer getMaxCompleteSetCode(@Param("partCode")String partCode);
    
    List<AssetPlanInfo> listofTodoInfoDetail(@Param("param") Map<String, Object> param);   
    
    int countTodoInfoDetail(@Param("param") Map<String, Object> param);
    
    int submitInfoFromReviewToDept3(@Param("param") Map<String,Object> param);   
    
    int submitInfoFromDept3ToDept2(@Param("param") Map<String,Object> param);   
    
    int submitInfoFromDept2ToPlanner(@Param("param") Map<String,Object> param);   
    
    int submitInfoFromPlannerToOQDept(@Param("param") Map<String,Object> param); 
    
    int submitInfoFromOQDeptToDept1(@Param("param") Map<String,Object> param);
    
    int submitInfoFromDept1ToEnd(@Param("param") Map<String,Object> param);
    
    int activateAssetPlanInfoByIds(@Param("param") Map<String,Object> param);    
    
    List<AssetPlanInfo> getNotReviewList(@Param("param") Map<String, Object> param);
    
    List<AssetPlanInfo> getInfoListByReviewer(@Param("param") Map<String, Object> param);
    
    int updateSubmitDept2Data(@Param("param") Map<String, Object> param);
    
    List<AssetPlanInfo> getAssetPlanEmailByMap(@Param("param") Map<String, Object> param);
    
    int eidtAssetOutTimeStatus(@Param("param") Map<String, Object> param);
    
    int eidtMonthOutTimeStatus(@Param("param") Map<String, Object> param); 
    
    int updateReviewResult(@Param("param") Map<String, Object> param);
}