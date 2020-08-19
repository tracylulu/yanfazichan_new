package com.h3c.platform.assetplan.service;

import java.util.List;

import com.h3c.platform.assetplan.entity.PurchaseReportInfo;
import com.h3c.platform.assetplan.entity.SpecifyManufacturerInfo;
import com.h3c.platform.assetplan.entity.SpecifyManufacturerInfoExt;

public interface SpecifyManufacturerInfoService {
	List<SpecifyManufacturerInfoExt> getBySpecifyManufacturerId(String specifyManufacturerId)throws Exception;
	
	List<SpecifyManufacturerInfoExt> getEmptyFiled() throws Exception;
	
	public List<SpecifyManufacturerInfo> getById(String specifyManufacturerId);
}
