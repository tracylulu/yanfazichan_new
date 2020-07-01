package com.h3c.platform.assetplan.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AssetInfoSubmitEntity   {	
	
	public List<Integer> lstsubmitID;

    public  String apStatus;

    public  String apstage;
    
    public String nextApstage;
    
    //申请月份
    public String applymonth;
    //
    public String applyuser;

	public List<Integer> getLstsubmitID() {
		return lstsubmitID;
	}

	public void setLstsubmitID(List<Integer> lstsubmitID) {
		this.lstsubmitID = lstsubmitID;
	}

	public String getApStatus() {
		return apStatus;
	}

	public void setApStatus(String apStatus) {
		this.apStatus = apStatus;
	}

	

	public String getApstage() {
		return apstage;
	}

	public void setApstage(String apstage) {
		this.apstage = apstage;
	}

	public String getNextApstage() {
		return nextApstage;
	}

	public void setNextApstage(String nextApstage) {
		this.nextApstage = nextApstage;
	}

	public String getApplymonth() {
		return applymonth;
	}

	public void setApplymonth(String applymonth) {
		this.applymonth = applymonth;
	}

	public String getApplyuser() {
		return applyuser;
	}

	public void setApplyuser(String applyuser) {
		this.applyuser = applyuser;
	}

	
    
    
    
    
}
