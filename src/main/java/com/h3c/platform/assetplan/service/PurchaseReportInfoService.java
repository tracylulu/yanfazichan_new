package com.h3c.platform.assetplan.service;

import java.util.List;

import com.h3c.platform.assetplan.entity.PurchaseReportInfo;
import com.h3c.platform.assetplan.entity.PurchaseReportInfoExt;

public interface PurchaseReportInfoService  {
	List<PurchaseReportInfoExt> getByPurchaseReportId(String purchaseReportId) throws Exception;
	
	List<PurchaseReportInfoExt> getEmptyFiled() throws Exception;
	
	public List<PurchaseReportInfo> getById(String purchaseReportId);
}
