package com.h3c.platform.assetplan.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AssetPlanGlobalInfo   {	
    //AssetPlanInfo  实体集合
	public List<AssetPlanInfo> lst ;

    public  SpecifyManufacturerInfo specifyManufacturerInfo;

    public PurchaseReportInfo purchaseReportInfo;

	public List<AssetPlanInfo> getLst() {
		return lst;
	}

	public void setLst(List<AssetPlanInfo> lst) {
		this.lst = lst;
	}

	public SpecifyManufacturerInfo getSpecifyManufacturerInfo() {
		return specifyManufacturerInfo;
	}

	public void setSpecifyManufacturerInfo(SpecifyManufacturerInfo specifyManufacturerInfo) {
		this.specifyManufacturerInfo = specifyManufacturerInfo;
	}

	public PurchaseReportInfo getPurchaseReportInfo() {
		return purchaseReportInfo;
	}

	public void setPurchaseReportInfo(PurchaseReportInfo purchaseReportInfo) {
		this.purchaseReportInfo = purchaseReportInfo;
	}
    
    
    
    
}
