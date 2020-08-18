package com.h3c.platform.assetplan.entity;

import java.util.Date;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import springfox.documentation.annotations.ApiIgnore;

@ApiModel(value="查询对象",description="查询对象")
public class SearchAssetParamEntity {
	//当前页
    @ApiModelProperty(value="当前页",required=true)
	private Integer pageNum;
    //每页记录数
    @ApiModelProperty(value="每页显示数",required=true)
    private Integer pageSize;
    
	//物品所处的审批阶段【可以理解的流程节点】
    @ApiModelProperty(value="申请阶段")
    private String apStage;
    
    //申请单号
    private String planCode;
    
    //物品名称
    private String assetName;
     
    //申请人ID----换成申购人ID
    private String requiredUser;
    
    //超时记录,只展示三级二级两种情况
    private String outTimePlanEnum;
    
    //申请时间
    private List<String> applyTime;
    
    //申请开始时间
    //private String StartApplyTime;
    
    //申请截止时间
    //private String EndApplyTime;
    
    //物品型号
    private String assetModel;
    
    //申请部门
    private String deptCode;
    
    //申请部门编码
    //private String DeptCode;
    
    //厂家
    private String assetManufacturer;
    
    //到货地点
    private String receiverPlace;
    
    //申请类别(计划内，计划外)（正常计划外的状态 0正常计划，1计划员激活，2管理员激活）
    private String abnormalPlanEnum;
    
    //项目编码
    private String itemCode;
    
    //是否含有申购报告   是否含有申购报告：  PurchaseReportID  只需判断这个值是否为-1，指定供应商  SpecifyManufacturerID -1
    //初始默认为0，表示不含申购报告，含有为1？
    //这个标识前端根据业务逻辑，判断值是1是0，后面的申购报告ID，根据该值，业务逻辑实现是否更新
    private String isReqPurchaseReport;
    
    //是否指定供应商
    ////初始默认为0，表示不指定供应商，指定为1？
    private String isSpecifyManufacturer;
    
    //需求数
    //private int Requireds;
    
    //审核数
    //根据  Requireds  RequiredsAudit  这个差比对，Requireds  ==  RequiredsAudit  全部
    //Requireds  ！=0 and   RequiredsAudit   = 0 , 全部否，
    //Requireds   ！=0，Requireds   >  RequiredsAudit    部分
    //private int RequiredsAudit;

    //审批结果(1:全部通过，2部分通过，3：未通过)
    private String applyResult;
    
    //选择导出的条目
    private List<String> lstexportId;
	

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

	public String getApStage() {
		return apStage;
	}

	public void setApStage(String apStage) {
		this.apStage = apStage;
	}

	public String getPlanCode() {
		return planCode;
	}

	public void setPlanCode(String planCode) {
		this.planCode = planCode;
	}

	public String getAssetName() {
		return assetName;
	}

	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}

	public String getRequiredUser() {
		return requiredUser;
	}

	public void setRequiredUser(String requiredUser) {
		this.requiredUser = requiredUser;
	}

	public String getOutTimePlanEnum() {
		return outTimePlanEnum;
	}

	public void setOutTimePlanEnum(String outTimePlanEnum) {
		this.outTimePlanEnum = outTimePlanEnum;
	}

	public List<String> getApplyTime() {
		return applyTime;
	}

	public void setApplyTime(List<String> applyTime) {
		this.applyTime = applyTime;
	}

	public String getAssetModel() {
		return assetModel;
	}

	public void setAssetModel(String assetModel) {
		this.assetModel = assetModel;
	}

	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	public String getAssetManufacturer() {
		return assetManufacturer;
	}

	public void setAssetManufacturer(String assetManufacturer) {
		this.assetManufacturer = assetManufacturer;
	}

	public String getReceiverPlace() {
		return receiverPlace;
	}

	public void setReceiverPlace(String receiverPlace) {
		this.receiverPlace = receiverPlace;
	}

	public String getAbnormalPlanEnum() {
		return abnormalPlanEnum;
	}

	public void setAbnormalPlanEnum(String abnormalPlanEnum) {
		this.abnormalPlanEnum = abnormalPlanEnum;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getIsReqPurchaseReport() {
		return isReqPurchaseReport;
	}

	public void setIsReqPurchaseReport(String isReqPurchaseReport) {
		this.isReqPurchaseReport = isReqPurchaseReport;
	}

	public String getIsSpecifyManufacturer() {
		return isSpecifyManufacturer;
	}

	public void setIsSpecifyManufacturer(String isSpecifyManufacturer) {
		this.isSpecifyManufacturer = isSpecifyManufacturer;
	}

	public String getApplyResult() {
		return applyResult;
	}

	public void setApplyResult(String applyResult) {
		this.applyResult = applyResult;
	}

	public List<String> getLstexportId() {
		return lstexportId;
	}

	public void setLstexportId(List<String> lstexportId) {
		this.lstexportId = lstexportId;
	}

	



    
}
