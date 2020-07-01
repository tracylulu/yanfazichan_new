package com.h3c.platform.common.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.h3c.platform.common.dao.ManufacturerInfoMapper;
import com.h3c.platform.common.entity.ManufacturerInfo;
import com.h3c.platform.common.service.ManufacturerInfoService;

@Service
public class ManufacturerInfoServiceImpl implements ManufacturerInfoService {

	@Autowired
	private ManufacturerInfoMapper manufacturerInfoMapper;
	
	@Override
	public 	List<ManufacturerInfo> getManufacturerInfoByName(String name) {
		return manufacturerInfoMapper.getManufacturerInfoByName(name);
	}
}
