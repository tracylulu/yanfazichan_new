package com.h3c.platform.assetplan.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.h3c.platform.assetplan.entity.AssetInfoReportEntity;
import com.h3c.platform.assetplan.entity.AssetPlanInfoHomePageView;
import com.h3c.platform.assetplan.entity.AssetPlanInfoReportView;
import com.h3c.platform.assetplan.entity.AssetPlanInfoSearchView;

public interface AssetPlanInfoReportService {
	
	
	List<AssetPlanInfoReportView> listofAssetPlanInfoForReport(@Param("param") Map<String, Object> param);

	List<AssetInfoReportEntity> getDataForPieChart(Map<String, Object> param);
    
	List<AssetInfoReportEntity> getDataForDept3BarChart(Map<String, Object> param);
    
    List<AssetInfoReportEntity> getDataForDept2BarChart(Map<String, Object> param);
    
    List<AssetInfoReportEntity> getDataForLineChart(Map<String, Object> param);

}
