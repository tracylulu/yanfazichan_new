package com.h3c.platform.sync.entity;

import java.util.Date;

public class ProjectInfo_EOS {
    private Integer id;

    private String typeId;

    private String typeName;

    private String projectNo;

    private String projectName;

    private String projectCode;

    private String releaseNo;

    private String buildNo;

    private String telecomPercent;

    private String nonTelecomPercent;

    private Date effectiveDate;

    private Date projectStartDate;

    private String assignPointDesc;

    private String status;

    private String mark;

    private Date createDate;

    private Date loadedTime;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId == null ? null : typeId.trim();
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }

    public String getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(String projectNo) {
        this.projectNo = projectNo == null ? null : projectNo.trim();
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName == null ? null : projectName.trim();
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode == null ? null : projectCode.trim();
    }

    public String getReleaseNo() {
        return releaseNo;
    }

    public void setReleaseNo(String releaseNo) {
        this.releaseNo = releaseNo == null ? null : releaseNo.trim();
    }

    public String getBuildNo() {
        return buildNo;
    }

    public void setBuildNo(String buildNo) {
        this.buildNo = buildNo == null ? null : buildNo.trim();
    }

    public String getTelecomPercent() {
        return telecomPercent;
    }

    public void setTelecomPercent(String telecomPercent) {
        this.telecomPercent = telecomPercent == null ? null : telecomPercent.trim();
    }

    public String getNonTelecomPercent() {
        return nonTelecomPercent;
    }

    public void setNonTelecomPercent(String nonTelecomPercent) {
        this.nonTelecomPercent = nonTelecomPercent == null ? null : nonTelecomPercent.trim();
    }

    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public Date getProjectStartDate() {
        return projectStartDate;
    }

    public void setProjectStartDate(Date projectStartDate) {
        this.projectStartDate = projectStartDate;
    }

    public String getAssignPointDesc() {
        return assignPointDesc;
    }

    public void setAssignPointDesc(String assignPointDesc) {
        this.assignPointDesc = assignPointDesc == null ? null : assignPointDesc.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark == null ? null : mark.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getLoadedTime() {
        return loadedTime;
    }

    public void setLoadedTime(Date loadedTime) {
        this.loadedTime = loadedTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}