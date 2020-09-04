package com.h3c.platform.assetplan.entity;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;

public class AssetInfoReportSearchEntity {
	//当前页
    @ApiModelProperty(value="当前页",required=true)
	private Integer pageNum;
    
    //每页记录数
    @ApiModelProperty(value="每页显示数",required=true)
    private Integer pageSize;
    
    //预算部门
    private String budgetDeptCode;
    
    //物品类别
    private String assetcategory;
    
    //计划起始时间
    private String startTime;
    
    //计划截止时间
    private String endTime;

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public String getBudgetDeptCode() {
		return budgetDeptCode;
	}

	public void setBudgetDeptCode(String budgetDeptCode) {
		this.budgetDeptCode = budgetDeptCode;
	}

	public String getAssetcategory() {
		return assetcategory;
	}

	public void setAssetcategory(String assetcategory) {
		this.assetcategory = assetcategory;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}


	
}