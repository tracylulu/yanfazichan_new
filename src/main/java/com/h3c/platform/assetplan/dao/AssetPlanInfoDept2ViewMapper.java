package com.h3c.platform.assetplan.dao;

import com.h3c.platform.assetplan.entity.AssetPlanInfoAll;
import com.h3c.platform.assetplan.entity.AssetPlanInfoDept2View;
import com.h3c.platform.assetplan.entity.AssetPlanInfoDept2ViewExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface AssetPlanInfoDept2ViewMapper {
    long countByExample(AssetPlanInfoDept2ViewExample example);

    int deleteByExample(AssetPlanInfoDept2ViewExample example);

    int insert(AssetPlanInfoDept2View record);

    int insertSelective(AssetPlanInfoDept2View record);

    List<AssetPlanInfoDept2View> selectByExample(AssetPlanInfoDept2ViewExample example);

    int updateByExampleSelective(@Param("record") AssetPlanInfoDept2View record, @Param("example") AssetPlanInfoDept2ViewExample example);

    int updateByExample(@Param("record") AssetPlanInfoDept2View record, @Param("example") AssetPlanInfoDept2ViewExample example);

    String getSumTotalMoneyForDept2(@Param("param") Map<String, Object> param);
    
    String getSumActualMoneySumForDept2(@Param("param") Map<String, Object> param);
    
    String getSumMoneyWithThirdDept(@Param("param") Map<String, Object> param);
    
    List<AssetPlanInfoAll> listofDept2Detail(@Param("param") Map<String, Object> param);
}