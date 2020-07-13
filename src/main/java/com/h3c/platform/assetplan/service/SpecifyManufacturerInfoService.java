package com.h3c.platform.assetplan.service;

import java.util.List;

import com.h3c.platform.assetplan.entity.SpecifyManufacturerInfoExt;

public interface SpecifyManufacturerInfoService {
	List<SpecifyManufacturerInfoExt> getBySpecifyManufacturerID(String SpecifyManufacturerID)throws Exception;
	
	List<SpecifyManufacturerInfoExt> getEmptyFiled() throws Exception;
}
