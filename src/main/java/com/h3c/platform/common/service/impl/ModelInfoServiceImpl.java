package com.h3c.platform.common.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.h3c.platform.common.dao.ModelInfoMapper;
import com.h3c.platform.common.entity.ModelInfo;
import com.h3c.platform.common.entity.ModelInfoExample;
import com.h3c.platform.common.service.ModelInfoService;

@Service
public class ModelInfoServiceImpl implements ModelInfoService{

	@Autowired
	private ModelInfoMapper modelInfoMapper;
	
	@Override
	public List<ModelInfo> getAll(){
		ModelInfoExample example = new ModelInfoExample();
		
		List<ModelInfo> lst= modelInfoMapper.selectByExample(example);
		
		return lst;
	} 
}
