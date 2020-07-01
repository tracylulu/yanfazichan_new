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
    private String APStage;
    
    //申请单号
    private String PlanCode;
    
    //物品名称
    private String AssetName;
     
    //申请人ID----换成申购人ID
    private String RequiredUser;
    
    //超时记录,只展示三级二级两种情况
    private String OutTimePlanEnum;
    
    //申请时间
    private List<String> ApplyTime;
    
    //申请开始时间
    //private String StartApplyTime;
    
    //申请截止时间
    //private String EndApplyTime;
    
    //物品型号
    private String AssetModel;
    
    //申请部门
    private String DeptCode;
    
    //申请部门编码
    //private String DeptCode;
    
    //厂家
    private String AssetManufacturer;
    
    //到货地点
    private String ReceiverPlace;
    
    //申请类别(计划内，计划外)（正常计划外的状态 0正常计划，1计划员激活，2管理员激活）
    private String AbnormalPlanEnum;
    
    //项目编码
    private String ItemCode;
    
    //是否含有申购报告   是否含有申购报告：  PurchaseReportID  只需判断这个值是否为-1，指定供应商  SpecifyManufacturerID -1
    //初始默认为0，表示不含申购报告，含有为1？
    //这个标识前端根据业务逻辑，判断值是1是0，后面的申购报告ID，根据该值，业务逻辑实现是否更新
    private String IsReqPurchaseReport;
    
    //是否指定供应商
    ////初始默认为0，表示不指定供应商，指定为1？
    private String ISSpecifyManufacturer;
    
    //需求数
    //private int Requireds;
    
    //审核数
    //根据  Requireds  RequiredsAudit  这个差比对，Requireds  ==  RequiredsAudit  全部
    //Requireds  ！=0 and   RequiredsAudit   = 0 , 全部否，
    //Requireds   ！=0，Requireds   >  RequiredsAudit    部分
    //private int RequiredsAudit;

    //审批结果(1:全部通过，2部分通过，3：未通过)
    private String ApplyResult;
    
    //选择导出的条目
    private List<String> lstexportID;
	

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

	

	public String getAPStage() {
		return APStage;
	}

	public void setAPStage(String aPStage) {
		APStage = aPStage;
	}

	public String getPlanCode() {
		return PlanCode;
	}

	public void setPlanCode(String planCode) {
		PlanCode = planCode;
	}

	public String getAssetName() {
		return AssetName;
	}

	public void setAssetName(String assetName) {
		AssetName = assetName;
	}
 
	

	/*public Date getApplyTime() {
		return ApplyTime;
	}

	public void setApplyTime(Date applyTime) {
		ApplyTime = applyTime;
	}*/

	public String getOutTimePlanEnum() {
		return OutTimePlanEnum;
	}

	public void setOutTimePlanEnum(String outTimePlanEnum) {
		OutTimePlanEnum = outTimePlanEnum;
	}

	public String getRequiredUser() {
		return RequiredUser;
	}

	public void setRequiredUser(String requiredUser) {
		RequiredUser = requiredUser;
	}

	public String getAssetModel() {
		return AssetModel;
	}

	public void setAssetModel(String assetModel) {
		AssetModel = assetModel;
	}

	public String getDeptCode() {
		return DeptCode;
	}

	public void setDeptCode(String deptCode) {
		DeptCode = deptCode;
	}

	public String getAssetManufacturer() {
		return AssetManufacturer;
	}

	public void setAssetManufacturer(String assetManufacturer) {
		AssetManufacturer = assetManufacturer;
	}

	public String getReceiverPlace() {
		return ReceiverPlace;
	}

	public void setReceiverPlace(String receiverPlace) {
		ReceiverPlace = receiverPlace;
	}



	

	public String getItemCode() {
		return ItemCode;
	}

	public void setItemCode(String itemCode) {
		ItemCode = itemCode;
	}



	/*public String getStartApplyTime() {
		return StartApplyTime;
	}

	public void setStartApplyTime(String startApplyTime) {
		StartApplyTime = startApplyTime;
	}

	public String getEndApplyTime() {
		return EndApplyTime;
	}

	public void setEndApplyTime(String endApplyTime) {
		EndApplyTime = endApplyTime;
	}*/

	public String getAbnormalPlanEnum() {
		return AbnormalPlanEnum;
	}

	

	public List<String> getApplyTime() {
		return ApplyTime;
	}

	public void setApplyTime(List<String> applyTime) {
		ApplyTime = applyTime;
	}

	public void setAbnormalPlanEnum(String abnormalPlanEnum) {
		AbnormalPlanEnum = abnormalPlanEnum;
	}

	

	public String getIsReqPurchaseReport() {
		return IsReqPurchaseReport;
	}

	public void setIsReqPurchaseReport(String isReqPurchaseReport) {
		IsReqPurchaseReport = isReqPurchaseReport;
	}

	public String getISSpecifyManufacturer() {
		return ISSpecifyManufacturer;
	}

	public void setISSpecifyManufacturer(String iSSpecifyManufacturer) {
		ISSpecifyManufacturer = iSSpecifyManufacturer;
	}

	public String getApplyResult() {
		return ApplyResult;
	}

	public void setApplyResult(String applyResult) {
		ApplyResult = applyResult;
	}

	public List<String> getLstexportID() {
		return lstexportID;
	}

	public void setLstexportID(List<String> lstexportID) {
		this.lstexportID = lstexportID;
	}



    
}
