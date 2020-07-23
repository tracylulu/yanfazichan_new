package com.h3c.platform.assetplan.dao;

import com.h3c.platform.assetplan.entity.AssetPlanInfoAll;
import com.h3c.platform.assetplan.entity.AssetPlanInfoReviewView;
import com.h3c.platform.assetplan.entity.AssetPlanInfoReviewViewExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface AssetPlanInfoReviewViewMapper {
    long countByExample(AssetPlanInfoReviewViewExample example);

    int deleteByExample(AssetPlanInfoReviewViewExample example);

    int insert(AssetPlanInfoReviewView record);

    int insertSelective(AssetPlanInfoReviewView record);

    List<AssetPlanInfoReviewView> selectByExample(AssetPlanInfoReviewViewExample example);

    int updateByExampleSelective(@Param("record") AssetPlanInfoReviewView record, @Param("example") AssetPlanInfoReviewViewExample example);

    int updateByExample(@Param("record") AssetPlanInfoReviewView record, @Param("example") AssetPlanInfoReviewViewExample example);

    String getSumTotalMoneyForReview(@Param("param") Map<String, Object> param);
    
    List<AssetPlanInfoAll> getReviewResult(@Param("param") Map<String, Object> param);
    
    List<AssetPlanInfoAll> getSearchResultForReview(@Param("param") Map<String, Object> param);
    
    List<String> getNotReviewApplyUserList(@Param("param") Map<String, Object> param);
    
    List<Integer> getAllReviewList(@Param("param") Map<String, Object> param);
    
    List<Integer> getAllReviewListForGuiFan(@Param("param") Map<String, Object> param);
    
    List<AssetPlanInfoReviewView> getNotReviewListByApplyUser(@Param("param") Map<String, Object> param);

    List<AssetPlanInfoAll> listofReviewDetail(@Param("param") Map<String, Object> param);
}