package com.h3c.platform.assetplan.service;

import java.util.Date;

import com.h3c.platform.assetplan.entity.RateTotalInfo;
import com.h3c.platform.assetplan.entity.SearchRateParamEntity;
import com.h3c.platform.response.ResponseResult;

public interface AssetRateInfoService {
	
	RateTotalInfo getRate(String type,String deptCode, Date date) throws Exception;
	
	ResponseResult getList(SearchRateParamEntity param)throws Exception;
}
