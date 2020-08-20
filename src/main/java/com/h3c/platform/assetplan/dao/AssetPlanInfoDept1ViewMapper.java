package com.h3c.platform.assetplan.dao;

import com.h3c.platform.assetplan.entity.AssetPlanInfoAll;
import com.h3c.platform.assetplan.entity.AssetPlanInfoDept1View;
import com.h3c.platform.assetplan.entity.AssetPlanInfoDept1ViewExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface AssetPlanInfoDept1ViewMapper {
    long countByExample(AssetPlanInfoDept1ViewExample example);

    int deleteByExample(AssetPlanInfoDept1ViewExample example);

    int insert(AssetPlanInfoDept1View record);

    int insertSelective(AssetPlanInfoDept1View record);

    List<AssetPlanInfoDept1View> selectByExample(AssetPlanInfoDept1ViewExample example);

    int updateByExampleSelective(@Param("record") AssetPlanInfoDept1View record, @Param("example") AssetPlanInfoDept1ViewExample example);

    int updateByExample(@Param("record") AssetPlanInfoDept1View record, @Param("example") AssetPlanInfoDept1ViewExample example);
    
    List<AssetPlanInfoAll> listofDept1Detail(@Param("param") Map<String, Object> param);
  	
  	//String getSumCountBeforeForDept1(@Param("param") Map<String, Object> param); 
    
  	//String getSumCountAfterForDept1(@Param("param") Map<String, Object> param); 
    
  	//String getSumMoneyBeforeForDept1(@Param("param") Map<String, Object> param); 
    
  	//String getSumMoneyAfterForDept1(@Param("param") Map<String, Object> param);
  	
  	List<Integer> getListForFlag(@Param("param") Map<String, Object> param); 
  	
  	Map<String,Object>getGroupMess(@Param("param") Map<String, Object> param); 
  	
  	Integer getListSize(@Param("param") Map<String, Object> param);
}