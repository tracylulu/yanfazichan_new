package com.h3c.platform.sync.entity;

import java.util.Date;

public class DeptInfo_EOS {
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

    private Date updateTime;

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

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}