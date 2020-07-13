package com.h3c.platform.assetplan.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AssetPlanGlobalInfoAll   {	
    //AssetPlanInfo  实体集合
	public List<AssetPlanInfoDetailView> lst ;

    public  List<SpecifyManufacturerInfoExt> specifyManufacturerInfo;

    public List<PurchaseReportInfoExt> purchaseReportInfo;

	public List<AssetPlanInfoDetailView> getLst() {
		return lst;
	}

	public void setLst(List<AssetPlanInfoDetailView> lst) {
		this.lst = lst;
	}

	public List<SpecifyManufacturerInfoExt> getSpecifyManufacturerInfo() {
		return specifyManufacturerInfo;
	}

	public void setSpecifyManufacturerInfo(List<SpecifyManufacturerInfoExt> specifyManufacturerInfo) {
		this.specifyManufacturerInfo = specifyManufacturerInfo;
	}

	public List<PurchaseReportInfoExt> getPurchaseReportInfo() {
		return purchaseReportInfo;
	}

	public void setPurchaseReportInfo(List<PurchaseReportInfoExt> purchaseReportInfo) {
		this.purchaseReportInfo = purchaseReportInfo;
	}
    
    
    
    
}
