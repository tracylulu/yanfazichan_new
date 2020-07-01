package com.h3c.platform.assetplan.dao;

import com.h3c.platform.assetplan.entity.AssetPlanInfoAll;
import com.h3c.platform.assetplan.entity.AssetPlanInfoApplyView;
import com.h3c.platform.assetplan.entity.AssetPlanInfoApplyViewExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface AssetPlanInfoApplyViewMapper {
    long countByExample(AssetPlanInfoApplyViewExample example);

    int deleteByExample(AssetPlanInfoApplyViewExample example);

    int insert(AssetPlanInfoApplyView record);

    int insertSelective(AssetPlanInfoApplyView record);

    List<AssetPlanInfoApplyView> selectByExample(AssetPlanInfoApplyViewExample example);

    int updateByExampleSelective(@Param("record") AssetPlanInfoApplyView record, @Param("example") AssetPlanInfoApplyViewExample example);

    int updateByExample(@Param("record") AssetPlanInfoApplyView record, @Param("example") AssetPlanInfoApplyViewExample example);

    String getSumTotalMoneyForDraft(@Param("param") Map<String, Object> param);
    
    List<AssetPlanInfoAll> listofDraftDetail(@Param("param") Map<String, Object> param);	
}