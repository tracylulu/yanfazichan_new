package com.h3c.platform.assetplan.entity;

import java.util.Date;

public class AssetRateInfo {
    private Integer id;

    private Date collectTime;

    private String assertNumber;

    private String deptCode;

    private String deptName;

    private String assertClass;

    private String assetCategory;

    private String area;

    private String provider;

    private String runFunction;

    private String portNum;

    private String ownerName;

    private String ownerCode;

    private String assetDesc;

    private String usageRate;

    private String dataType;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCollectTime() {
        return collectTime;
    }

    public void setCollectTime(Date collectTime) {
        this.collectTime = collectTime;
    }

    public String getAssertNumber() {
        return assertNumber;
    }

    public void setAssertNumber(String assertNumber) {
        this.assertNumber = assertNumber == null ? null : assertNumber.trim();
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode == null ? null : deptCode.trim();
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName == null ? null : deptName.trim();
    }

    public String getAssertClass() {
        return assertClass;
    }

    public void setAssertClass(String assertClass) {
        this.assertClass = assertClass == null ? null : assertClass.trim();
    }

    public String getAssetCategory() {
        return assetCategory;
    }

    public void setAssetCategory(String assetCategory) {
        this.assetCategory = assetCategory == null ? null : assetCategory.trim();
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider == null ? null : provider.trim();
    }

    public String getRunFunction() {
        return runFunction;
    }

    public void setRunFunction(String runFunction) {
        this.runFunction = runFunction == null ? null : runFunction.trim();
    }

    public String getPortNum() {
        return portNum;
    }

    public void setPortNum(String portNum) {
        this.portNum = portNum == null ? null : portNum.trim();
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName == null ? null : ownerName.trim();
    }

    public String getOwnerCode() {
        return ownerCode;
    }

    public void setOwnerCode(String ownerCode) {
        this.ownerCode = ownerCode == null ? null : ownerCode.trim();
    }

    public String getAssetDesc() {
        return assetDesc;
    }

    public void setAssetDesc(String assetDesc) {
        this.assetDesc = assetDesc == null ? null : assetDesc.trim();
    }

    public String getUsageRate() {
        return usageRate;
    }

    public void setUsageRate(String usageRate) {
        this.usageRate = usageRate == null ? null : usageRate.trim();
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType == null ? null : dataType.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}