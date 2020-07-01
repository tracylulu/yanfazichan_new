package com.h3c.platform.assetplan.service;

import java.util.Date;

import com.h3c.platform.response.ResponseResult;

public interface AssetRateInfoService {
	
	ResponseResult getRate(String type,String deptCode, Date date);
}
