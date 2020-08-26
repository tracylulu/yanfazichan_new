package com.h3c.platform.assetplan.dao;

import com.h3c.platform.assetplan.entity.AssetPlanInfoAll;
import com.h3c.platform.assetplan.entity.AssetPlanInfoDept3View;
import com.h3c.platform.assetplan.entity.AssetPlanInfoDept3ViewExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface AssetPlanInfoDept3ViewMapper {
    long countByExample(AssetPlanInfoDept3ViewExample example);

    int deleteByExample(AssetPlanInfoDept3ViewExample example);

    int insert(AssetPlanInfoDept3View record);

    int insertSelective(AssetPlanInfoDept3View record);

    List<AssetPlanInfoDept3View> selectByExample(AssetPlanInfoDept3ViewExample example);

    int updateByExampleSelective(@Param("record") AssetPlanInfoDept3View record, @Param("example") AssetPlanInfoDept3ViewExample example);

    int updateByExample(@Param("record") AssetPlanInfoDept3View record, @Param("example") AssetPlanInfoDept3ViewExample example);

    String getSumTotalMoneyForDept3(@Param("param") Map<String, Object> param);
    
    //String getBudgetTotalMoneyForDept3(@Param("param") Map<String, Object> param);
  
    String getSumActualMoneySumForDept3(@Param("param") Map<String, Object> param);
  
    List<AssetPlanInfoAll> listofDept3Detail(@Param("param") Map<String, Object> param);	
}