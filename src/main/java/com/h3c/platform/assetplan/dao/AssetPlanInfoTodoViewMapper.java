package com.h3c.platform.assetplan.dao;

import com.h3c.platform.assetplan.entity.AssetPlanInfoAll;
import com.h3c.platform.assetplan.entity.AssetPlanInfoTodoView;
import com.h3c.platform.assetplan.entity.AssetPlanInfoTodoViewExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface AssetPlanInfoTodoViewMapper {
    long countByExample(AssetPlanInfoTodoViewExample example);

    int deleteByExample(AssetPlanInfoTodoViewExample example);

    int insert(AssetPlanInfoTodoView record);

    int insertSelective(AssetPlanInfoTodoView record);

    List<AssetPlanInfoTodoView> selectByExample(AssetPlanInfoTodoViewExample example);

    int updateByExampleSelective(@Param("record") AssetPlanInfoTodoView record, @Param("example") AssetPlanInfoTodoViewExample example);

    int updateByExample(@Param("record") AssetPlanInfoTodoView record, @Param("example") AssetPlanInfoTodoViewExample example);

    String getSumTotalMoneyForTodo(@Param("param") Map<String, Object> param);
    
    List<AssetPlanInfoAll> listofTodoDetail(@Param("param") Map<String, Object> param);
}