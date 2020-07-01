package com.h3c.platform.assetplan.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AssetPlanPlannerInfo   {	
    //AssetPlanInfoPlannerView  实体集合
	public List<AssetPlanInfoPlannerView> lst ;

    public int groupFlag;

    public String groupFlagDetail;

    
    
	public List<AssetPlanInfoPlannerView> getLst() {
		return lst;
	}

	public void setLst(List<AssetPlanInfoPlannerView> lst) {
		this.lst = lst;
	}

	public int getGroupFlag() {
		return groupFlag;
	}

	public void setGroupFlag(int groupFlag) {
		this.groupFlag = groupFlag;
	}

	public String getGroupFlagDetail() {
		return groupFlagDetail;
	}

	public void setGroupFlagDetail(String groupFlagDetail) {
		this.groupFlagDetail = groupFlagDetail;
	}
    

	
    
    
    
    
}
