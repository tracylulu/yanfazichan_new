package com.h3c.platform.assetplan.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AssetPlanGlobalInfo   {	
    //AssetPlanInfo  实体集合
	public List<AssetPlanInfo> lst ;

    public List<SpecifyManufacturerInfo> specifyManufacturerInfo;

    public List<PurchaseReportInfo> purchaseReportInfo;

	public List<AssetPlanInfo> getLst() {
		return lst;
	}

	public void setLst(List<AssetPlanInfo> lst) {
		this.lst = lst;
	}

	public List<SpecifyManufacturerInfo> getSpecifyManufacturerInfo() {
		return specifyManufacturerInfo;
	}

	public void setSpecifyManufacturerInfo(List<SpecifyManufacturerInfo> specifyManufacturerInfo) {
		this.specifyManufacturerInfo = specifyManufacturerInfo;
	}

	public List<PurchaseReportInfo> getPurchaseReportInfo() {
		return purchaseReportInfo;
	}

	public void setPurchaseReportInfo(List<PurchaseReportInfo> purchaseReportInfo) {
		this.purchaseReportInfo = purchaseReportInfo;
	}
    
    
    
    
}
