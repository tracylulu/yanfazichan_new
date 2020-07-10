package com.h3c.platform.assetplan.dao;

import com.h3c.platform.assetplan.entity.AssetPlanInfoSearchExportView;
import com.h3c.platform.assetplan.entity.AssetPlanInfoSearchExportViewExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface AssetPlanInfoSearchExportViewMapper {
    long countByExample(AssetPlanInfoSearchExportViewExample example);

    int deleteByExample(AssetPlanInfoSearchExportViewExample example);

    int insert(AssetPlanInfoSearchExportView record);

    int insertSelective(AssetPlanInfoSearchExportView record);

    List<AssetPlanInfoSearchExportView> selectByExample(AssetPlanInfoSearchExportViewExample example);

    int updateByExampleSelective(@Param("record") AssetPlanInfoSearchExportView record, @Param("example") AssetPlanInfoSearchExportViewExample example);

    int updateByExample(@Param("record") AssetPlanInfoSearchExportView record, @Param("example") AssetPlanInfoSearchExportViewExample example);
    
    List<AssetPlanInfoSearchExportView> exportAssetPlanInfoByIds(@Param("param") Map<String, Object> param);
}