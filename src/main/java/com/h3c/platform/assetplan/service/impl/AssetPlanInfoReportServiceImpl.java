package com.h3c.platform.assetplan.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.h3c.platform.assetplan.dao.AssetPlanInfoHomePageViewMapper;
import com.h3c.platform.assetplan.dao.AssetPlanInfoReportViewMapper;
import com.h3c.platform.assetplan.dao.AssetPlanInfoSearchViewMapper;
import com.h3c.platform.assetplan.entity.AssetInfoReportEntity;
import com.h3c.platform.assetplan.entity.AssetPlanInfoHomePageView;
import com.h3c.platform.assetplan.entity.AssetPlanInfoReportView;
import com.h3c.platform.assetplan.entity.AssetPlanInfoSearchView;
import com.h3c.platform.assetplan.service.AssetPlanInfoReportService;
import com.h3c.platform.assetplan.service.AssetPlanInfoSearchService;

@Service
public class AssetPlanInfoReportServiceImpl implements AssetPlanInfoReportService {

	@Autowired
    private AssetPlanInfoReportViewMapper reportViewMapper;

	@Override
	public List<AssetPlanInfoReportView> listofAssetPlanInfoForReport(Map<String, Object> param) {
		return reportViewMapper.listofAssetPlanInfoForReport(param);
	}

	@Override
	public List<AssetInfoReportEntity> getDataForPieChart(Map<String, Object> param) {
		return reportViewMapper.getDataForPieChart(param);
	}

	@Override
	public List<AssetInfoReportEntity> getDataForLineChart(Map<String, Object> param) {
		return reportViewMapper.getDataForLineChart(param);
	}

	@Override
	public List<AssetInfoReportEntity> getDataForDept3BarChart(Map<String, Object> param) {
		return reportViewMapper.getDataForDept3BarChart(param);
	}

	@Override
	public List<AssetInfoReportEntity> getDataForDept2BarChart(Map<String, Object> param) {
		return reportViewMapper.getDataForDept2BarChart(param);
	}

	
	

	

	
}
