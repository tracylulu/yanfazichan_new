package com.h3c.platform.assetplan.dao;

import com.h3c.platform.assetplan.entity.AssetInfoReportEntity;
import com.h3c.platform.assetplan.entity.AssetPlanInfoReportView;
import com.h3c.platform.assetplan.entity.AssetPlanInfoReportViewExample;
import com.h3c.platform.assetplan.entity.AssetPlanInfoSearchView;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface AssetPlanInfoReportViewMapper {
    long countByExample(AssetPlanInfoReportViewExample example);

    int deleteByExample(AssetPlanInfoReportViewExample example);

    int insert(AssetPlanInfoReportView record);

    int insertSelective(AssetPlanInfoReportView record);

    List<AssetPlanInfoReportView> selectByExample(AssetPlanInfoReportViewExample example);

    int updateByExampleSelective(@Param("record") AssetPlanInfoReportView record, @Param("example") AssetPlanInfoReportViewExample example);

    int updateByExample(@Param("record") AssetPlanInfoReportView record, @Param("example") AssetPlanInfoReportViewExample example);

    List<AssetPlanInfoReportView> listofAssetPlanInfoForReport(@Param("param") Map<String, Object> param);

    List<AssetInfoReportEntity> getDataForPieChart(@Param("param") Map<String, Object> param);
    
    List<AssetInfoReportEntity> getDataForDept3BarChart(@Param("param") Map<String, Object> param);
    
    List<AssetInfoReportEntity> getDataForDept2BarChart(@Param("param") Map<String, Object> param);
    
    List<AssetInfoReportEntity> getDataForLineChart(@Param("param") Map<String, Object> param);

}