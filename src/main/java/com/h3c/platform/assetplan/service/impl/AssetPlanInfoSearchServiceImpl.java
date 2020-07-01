package com.h3c.platform.assetplan.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.h3c.platform.assetplan.dao.AssetPlanInfoHomePageViewMapper;
import com.h3c.platform.assetplan.dao.AssetPlanInfoSearchViewMapper;
import com.h3c.platform.assetplan.entity.AssetPlanInfoHomePageView;
import com.h3c.platform.assetplan.entity.AssetPlanInfoSearchView;
import com.h3c.platform.assetplan.service.AssetPlanInfoSearchService;

@Service
public class AssetPlanInfoSearchServiceImpl implements AssetPlanInfoSearchService {

	@Autowired
    private AssetPlanInfoSearchViewMapper searchViewMapper;
	@Autowired
	private AssetPlanInfoHomePageViewMapper homePageViewMapper;

	@Override
	public List<AssetPlanInfoSearchView> listofAssetPlanInfo(Map<String, Object> param) {
            return searchViewMapper.listofAssetPlanInfo(param);
	}

	@Override
	public int countAssetPlanInfo(Map<String, Object> param) {
		return searchViewMapper.countAssetPlanInfo(param);
	}

	@Override
	public AssetPlanInfoHomePageView getApprovalRecordById(Integer assetplanid) {
		return homePageViewMapper.getApprovalRecordById(assetplanid);
	}

	
}
