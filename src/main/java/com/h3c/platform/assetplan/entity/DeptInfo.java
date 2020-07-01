package com.h3c.platform.assetplan.entity;

import java.util.Date;

public class DeptInfo {
    private Integer deptCode;

    private String deptName;

    private String coa;

    private String deptLevel;

    private String supDeptCode;

    private String typeId;

    private String deptType;

    private String deptManagerCode;

    private String deptPlannerCode;

    private String deptCodeChain;

    private String deleteFlag;

    private String creator;

    private Date createTime;

    private String modifier;

    private Date modifiTime;

    public Integer getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(Integer deptCode) {
        this.deptCode = deptCode;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName == null ? null : deptName.trim();
    }

    public String getCoa() {
        return coa;
    }

    public void setCoa(String coa) {
        this.coa = coa == null ? null : coa.trim();
    }

    public String getDeptLevel() {
        return deptLevel;
    }

    public void setDeptLevel(String deptLevel) {
        this.deptLevel = deptLevel == null ? null : deptLevel.trim();
    }

    public String getSupDeptCode() {
        return supDeptCode;
    }

    public void setSupDeptCode(String supDeptCode) {
        this.supDeptCode = supDeptCode == null ? null : supDeptCode.trim();
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId == null ? null : typeId.trim();
    }

    public String getDeptType() {
        return deptType;
    }

    public void setDeptType(String deptType) {
        this.deptType = deptType == null ? null : deptType.trim();
    }

    public String getDeptManagerCode() {
        return deptManagerCode;
    }

    public void setDeptManagerCode(String deptManagerCode) {
        this.deptManagerCode = deptManagerCode == null ? null : deptManagerCode.trim();
    }

    public String getDeptPlannerCode() {
        return deptPlannerCode;
    }

    public void setDeptPlannerCode(String deptPlannerCode) {
        this.deptPlannerCode = deptPlannerCode == null ? null : deptPlannerCode.trim();
    }

    public String getDeptCodeChain() {
        return deptCodeChain;
    }

    public void setDeptCodeChain(String deptCodeChain) {
        this.deptCodeChain = deptCodeChain == null ? null : deptCodeChain.trim();
    }

    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag == null ? null : deleteFlag.trim();
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier == null ? null : modifier.trim();
    }

    public Date getModifiTime() {
        return modifiTime;
    }

    public void setModifiTime(Date modifiTime) {
        this.modifiTime = modifiTime;
    }
}