package com.h3c.platform.assetplan.dao;

import com.h3c.platform.assetplan.entity.AssetPlanInfoAll;
import com.h3c.platform.assetplan.entity.AssetPlanInfoPlannerView;
import com.h3c.platform.assetplan.entity.AssetPlanInfoPlannerViewExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface AssetPlanInfoPlannerViewMapper {
    long countByExample(AssetPlanInfoPlannerViewExample example);

    int deleteByExample(AssetPlanInfoPlannerViewExample example);

    int insert(AssetPlanInfoPlannerView record);

    int insertSelective(AssetPlanInfoPlannerView record);

    List<AssetPlanInfoPlannerView> selectByExample(AssetPlanInfoPlannerViewExample example);

    int updateByExampleSelective(@Param("record") AssetPlanInfoPlannerView record, @Param("example") AssetPlanInfoPlannerViewExample example);

    int updateByExample(@Param("record") AssetPlanInfoPlannerView record, @Param("example") AssetPlanInfoPlannerViewExample example);

    List<AssetPlanInfoAll> listofPlannerDetail(@Param("param") Map<String, Object> param);
  	
    //List<AssetPlanInfoAll> listofPlannerDetailAfter(@Param("param") Map<String, Object> param);
    
  	//String getSumCountBeforeForPlanner(@Param("param") Map<String, Object> param); 
    
  	//String getSumCountAfterForPlanner(@Param("param") Map<String, Object> param); 
    
  	//String getSumMoneyBeforeForPlanner(@Param("param") Map<String, Object> param); 
    
  	//String getSumMoneyAfterForPlanner(@Param("param") Map<String, Object> param); 
  	
  	List<Integer> getListForFlag(@Param("param") Map<String, Object> param); 
  	
  	Map<String,Object>getGroupMess(@Param("param") Map<String, Object> param); 
  	
  	Integer getListSize(@Param("param") Map<String, Object> param);
  	
  	List<AssetPlanInfoPlannerView> exportAssetPlanInfoForPlanner(@Param("param") Map<String, Object> param);
}