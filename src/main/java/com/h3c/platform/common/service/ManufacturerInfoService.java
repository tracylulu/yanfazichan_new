package com.h3c.platform.common.service;

import java.util.List;

import com.h3c.platform.common.entity.ManufacturerInfo;
import com.h3c.platform.response.ResponseResult;

public interface ManufacturerInfoService {

	List<ManufacturerInfo> getManufacturerInfoByName(String name);
	
	List<ManufacturerInfo> getAll() throws Exception;
	
	ResponseResult add(ManufacturerInfo info)throws Exception;
	
	ResponseResult edit(ManufacturerInfo info) throws Exception;
	
	ManufacturerInfo getByPrimaryKey(Integer id)throws Exception;
}
