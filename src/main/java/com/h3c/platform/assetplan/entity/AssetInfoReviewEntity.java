package com.h3c.platform.assetplan.entity;

import java.util.Date;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import springfox.documentation.annotations.ApiIgnore;

@ApiModel(value="查询规范审核列表",description="查询规范审核列表")
public class AssetInfoReviewEntity {
	//当前页
    @ApiModelProperty(value="当前页",required=true)
	private Integer pageNum;
    
    //每页记录数
    @ApiModelProperty(value="每页显示数",required=true)
    private Integer pageSize;
    
    //规范审核环节处理人(当前登录人)
    private String reviewer;
    
    //物品所处的规范审核状态
    private String reviewResult;
    
    //申请月份
    private String applymonth;
     
    //申请部门
    private String deptCode;
    
    //金额范围
    private String startPrice;
    
    
    private String endPrice;


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


	public String getReviewer() {
		return reviewer;
	}


	public void setReviewer(String reviewer) {
		this.reviewer = reviewer;
	}


	public String getReviewResult() {
		return reviewResult;
	}


	public void setReviewResult(String reviewResult) {
		this.reviewResult = reviewResult;
	}


	public String getApplymonth() {
		return applymonth;
	}


	public void setApplymonth(String applymonth) {
		this.applymonth = applymonth;
	}


	


	public String getDeptCode() {
		return deptCode;
	}


	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}


	public String getStartPrice() {
		return startPrice;
	}


	public void setStartPrice(String startPrice) {
		this.startPrice = startPrice;
	}


	public String getEndPrice() {
		return endPrice;
	}


	public void setEndPrice(String endPrice) {
		this.endPrice = endPrice;
	}
    
   
   
	




    
}
