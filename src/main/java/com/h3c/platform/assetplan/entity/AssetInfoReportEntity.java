package com.h3c.platform.assetplan.entity;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class AssetInfoReportEntity {
	//饼状图
    private String assetmodel;

    private String pieChartMoney;

    //柱状图
    private String deptCode;

    private String barChartMoney;
    
    //折线图
    private String applymonth;

    private String lineChartMoney;
    

    
	public String getAssetmodel() {
		return assetmodel;
	}

	public void setAssetmodel(String assetmodel) {
		this.assetmodel = assetmodel;
	}

	public String getPieChartMoney() {
		return pieChartMoney;
	}

	public void setPieChartMoney(String pieChartMoney) {
		this.pieChartMoney = pieChartMoney;
	}

	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	public String getBarChartMoney() {
		return barChartMoney;
	}

	public void setBarChartMoney(String barChartMoney) {
		this.barChartMoney = barChartMoney;
	}

	public String getApplymonth() {
		return applymonth;
	}

	public void setApplymonth(String applymonth) {
		this.applymonth = applymonth;
	}

	public String getLineChartMoney() {
		return lineChartMoney;
	}

	public void setLineChartMoney(String lineChartMoney) {
		this.lineChartMoney = lineChartMoney;
	}

    
   

	
}