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
    private String dept3code;
    
    private String dept3name;
    
    private String dept2code;

    private String dept2name;
    
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


	public String getDept3code() {
		return dept3code;
	}

	public void setDept3code(String dept3code) {
		this.dept3code = dept3code;
	}

	public String getDept2code() {
		return dept2code;
	}

	public void setDept2code(String dept2code) {
		this.dept2code = dept2code;
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

	public String getDept3name() {
		return dept3name;
	}

	public void setDept3name(String dept3name) {
		this.dept3name = dept3name;
	}

	public String getDept2name() {
		return dept2name;
	}

	public void setDept2name(String dept2name) {
		this.dept2name = dept2name;
	}

    
   

	
}