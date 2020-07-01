package com.h3c.platform.sysmgr.entity;

import java.util.Date;

public class UserInfo {
    private Integer id;

    private String notesId;

    private String empCode;

    private String domainAccount;

    private String displayName;

    private String empName;

    private String coaCode;

    private String dept1Code;

    private String dept2Code;

    private String dept3Code;

    private String dept4Code;

    private String deptCode;

    private String deptName;

    private String email;

    private Date updateTime;

    private String deleteFlag;

    private String creator;

    private Date createTime;

    private String modifier;

    private Date modifiTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNotesId() {
        return notesId;
    }

    public void setNotesId(String notesId) {
        this.notesId = notesId == null ? null : notesId.trim();
    }

    public String getEmpCode() {
        return empCode;
    }

    public void setEmpCode(String empCode) {
        this.empCode = empCode == null ? null : empCode.trim();
    }

    public String getDomainAccount() {
        return domainAccount;
    }

    public void setDomainAccount(String domainAccount) {
        this.domainAccount = domainAccount == null ? null : domainAccount.trim();
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName == null ? null : displayName.trim();
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName == null ? null : empName.trim();
    }

    public String getCoaCode() {
        return coaCode;
    }

    public void setCoaCode(String coaCode) {
        this.coaCode = coaCode == null ? null : coaCode.trim();
    }

    public String getDept1Code() {
        return dept1Code;
    }

    public void setDept1Code(String dept1Code) {
        this.dept1Code = dept1Code == null ? null : dept1Code.trim();
    }

    public String getDept2Code() {
        return dept2Code;
    }

    public void setDept2Code(String dept2Code) {
        this.dept2Code = dept2Code == null ? null : dept2Code.trim();
    }

    public String getDept3Code() {
        return dept3Code;
    }

    public void setDept3Code(String dept3Code) {
        this.dept3Code = dept3Code == null ? null : dept3Code.trim();
    }

    public String getDept4Code() {
        return dept4Code;
    }

    public void setDept4Code(String dept4Code) {
        this.dept4Code = dept4Code == null ? null : dept4Code.trim();
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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