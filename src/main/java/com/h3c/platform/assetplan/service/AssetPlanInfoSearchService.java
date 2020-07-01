package com.h3c.platform.assetplan.service;

import java.util.List;
import java.util.Map;

import com.h3c.platform.assetplan.entity.AssetPlanInfoHomePageView;
import com.h3c.platform.assetplan.entity.AssetPlanInfoSearchView;

public interface AssetPlanInfoSearchService {
	
	
	List<AssetPlanInfoSearchView> listofAssetPlanInfo(Map<String, Object> param);            
    
    int countAssetPlanInfo(Map<String, Object> param);
    
    AssetPlanInfoHomePageView getApprovalRecordById(Integer assetplanid);

}
