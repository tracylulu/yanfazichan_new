package com.h3c.platform.common.service;

import java.util.List;

import com.h3c.platform.common.entity.ManufacturerInfo;

public interface ManufacturerInfoService {

	List<ManufacturerInfo> getManufacturerInfoByName(String name);
}
