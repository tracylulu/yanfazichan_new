package com.h3c.platform.assetplan.dao;

import com.h3c.platform.assetplan.entity.AssetPlanInfoAll;
import com.h3c.platform.assetplan.entity.AssetPlanInfoOQDeptView;
import com.h3c.platform.assetplan.entity.AssetPlanInfoOQDeptViewExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface AssetPlanInfoOQDeptViewMapper {
    long countByExample(AssetPlanInfoOQDeptViewExample example);

    int deleteByExample(AssetPlanInfoOQDeptViewExample example);

    int insert(AssetPlanInfoOQDeptView record);

    int insertSelective(AssetPlanInfoOQDeptView record);

    List<AssetPlanInfoOQDeptView> selectByExample(AssetPlanInfoOQDeptViewExample example);

    int updateByExampleSelective(@Param("record") AssetPlanInfoOQDeptView record, @Param("example") AssetPlanInfoOQDeptViewExample example);

    int updateByExample(@Param("record") AssetPlanInfoOQDeptView record, @Param("example") AssetPlanInfoOQDeptViewExample example);

    List<AssetPlanInfoAll> listofOQDeptDetail(@Param("param") Map<String, Object> param);
    
    //List<AssetPlanInfoAll> listofOQDeptDetailAfter(@Param("param") Map<String, Object> param);
  	
  	//String getSumCountBeforeForOQDept(@Param("param") Map<String, Object> param); 
    
  	//String getSumCountAfterForOQDept(@Param("param") Map<String, Object> param); 
    
  	//String getSumMoneyBeforeForOQDept(@Param("param") Map<String, Object> param); 
    
  	//String getSumMoneyAfterForOQDept(@Param("param") Map<String, Object> param);
  	
  	List<Integer> getListForFlag(@Param("param") Map<String, Object> param); 
  	
  	Map<String,Object>getGroupMess(@Param("param") Map<String, Object> param); 
  	
  	Integer getListSize(@Param("param") Map<String, Object> param);
}