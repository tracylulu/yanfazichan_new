package com.h3c.platform.assetplan.service;

import java.util.Date;
import java.util.Map;

import com.h3c.platform.response.ResponseResult;

public interface AssetRateInfoService {
	
	Map<String,Object> getRate(String type,String deptCode, Date date) throws Exception;
}
