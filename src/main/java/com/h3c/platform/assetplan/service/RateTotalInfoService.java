package com.h3c.platform.assetplan.service;

import java.util.List;

import com.h3c.platform.assetplan.entity.RateTotalInfo;

public interface RateTotalInfoService {

	int insertBatch(List<RateTotalInfo> lst);
	
	int deleteById(List<Integer> lst);
	
	RateTotalInfo getRateTotalInfoById(Integer id);
}
