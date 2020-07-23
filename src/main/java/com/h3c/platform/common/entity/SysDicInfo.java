package com.h3c.platform.common.entity;

import java.util.Date;

public class SysDicInfo {
    private String id;

    private String dicCode;

    private String dicName;

    private String dicTypeId;

    private String sortOrder;

    private String remark;

    private Date createTime;

    private Date lastModifyTime;

    private String creater;

    private String lastModifier;
    
    private Byte isDeleted;

    private Byte isAble;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getDicCode() {
        return dicCode;
    }

    public void setDicCode(String dicCode) {
        this.dicCode = dicCode == null ? null : dicCode.trim();
    }

    public String getDicName() {
        return dicName;
    }

    public void setDicName(String dicName) {
        this.dicName = dicName == null ? null : dicName.trim();
    }

    public String getDicTypeId() {
        return dicTypeId;
    }

    public void setDicTypeId(String dicTypeId) {
        this.dicTypeId = dicTypeId == null ? null : dicTypeId.trim();
    }

    public String getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder == null ? null : sortOrder.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastModifyTime() {
        return lastModifyTime;
    }

    public void setLastModifyTime(Date lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater == null ? null : creater.trim();
    }

    public String getLastModifier() {
        return lastModifier;
    }

    public void setLastModifier(String lastModifier) {
        this.lastModifier = lastModifier == null ? null : lastModifier.trim();
    }
    
    public Byte getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }
    
    public Byte getIsAble() {
        return isAble;
    }

    public void setIsAble(Byte isAble) {
        this.isAble = isAble;
    }
}