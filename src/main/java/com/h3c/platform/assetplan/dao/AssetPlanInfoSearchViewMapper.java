package com.h3c.platform.assetplan.dao;

import com.h3c.platform.assetplan.entity.AssetPlanInfoSearchView;
import com.h3c.platform.assetplan.entity.AssetPlanInfoSearchViewExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface AssetPlanInfoSearchViewMapper {
    long countByExample(AssetPlanInfoSearchViewExample example);

    int deleteByExample(AssetPlanInfoSearchViewExample example);

    int insert(AssetPlanInfoSearchView record);

    int insertSelective(AssetPlanInfoSearchView record);

    List<AssetPlanInfoSearchView> selectByExample(AssetPlanInfoSearchViewExample example);

    int updateByExampleSelective(@Param("record") AssetPlanInfoSearchView record, @Param("example") AssetPlanInfoSearchViewExample example);

    int updateByExample(@Param("record") AssetPlanInfoSearchView record, @Param("example") AssetPlanInfoSearchViewExample example);

    List<AssetPlanInfoSearchView> listofAssetPlanInfo(@Param("param") Map<String, Object> param);            
    
    int countAssetPlanInfo(@Param("param") Map<String, Object> param);
    
    List<AssetPlanInfoSearchView> exportAssetPlanInfoByIds(@Param("param") Map<String, Object> param);
    
    String getBudgetSum(@Param("param") Map<String, Object> param);
    
    String getDept3Apply(@Param("param") Map<String, Object> param);
    
    String getDept2Apply(@Param("param") Map<String, Object> param);
    
    String getDept3Planed(@Param("param") Map<String, Object> param);
    
    String getDept2Planed(@Param("param") Map<String, Object> param);
    
    String getDept2PlanedForDept3(@Param("param") Map<String, Object> param);
}