package com.h3c.platform.common.service;

import java.util.List;

import com.h3c.platform.common.entity.ModelInfo;
import com.h3c.platform.response.ResponseResult;

public interface ModelInfoService {
	List<ModelInfo> getAll() throws Exception;
	
	ResponseResult add(ModelInfo info) throws Exception;
	
	ResponseResult edit(ModelInfo info) throws Exception;
	
	ModelInfo getByPrimaryKey(Integer id) throws Exception;
	
	/**
	 * 根据厂家删除型号
	 * @param id
	 */
	void DelByManufacturerID(Integer id);
}
