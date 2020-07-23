package com.h3c.platform.assetplan.dao;

import com.h3c.platform.assetplan.entity.AssetPlanInfoMenuView;
import com.h3c.platform.assetplan.entity.AssetPlanInfoMenuViewExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface AssetPlanInfoMenuViewMapper {
    long countByExample(AssetPlanInfoMenuViewExample example);

    int deleteByExample(AssetPlanInfoMenuViewExample example);

    int insert(AssetPlanInfoMenuView record);

    int insertSelective(AssetPlanInfoMenuView record);

    List<AssetPlanInfoMenuView> selectByExample(AssetPlanInfoMenuViewExample example);

    int updateByExampleSelective(@Param("record") AssetPlanInfoMenuView record, @Param("example") AssetPlanInfoMenuViewExample example);

    int updateByExample(@Param("record") AssetPlanInfoMenuView record, @Param("example") AssetPlanInfoMenuViewExample example);
    
    List<AssetPlanInfoMenuView> listofTodoInfo(@Param("param") Map<String, Object> param);            
    
    List<AssetPlanInfoMenuView> listofTodoInfoForRequiredUser(@Param("param") Map<String, Object> param);
    
    int countTodoInfo(@Param("param") Map<String, Object> param);
}