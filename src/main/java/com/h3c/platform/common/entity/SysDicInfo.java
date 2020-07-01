package com.h3c.platform.common.entity;

import java.util.Date;

public class SysDicInfo {
    private String id;

    private String dicCode;

    private String dicName;

    private String dicTypeCode;

    private String dicTypeName;

    private String remark;

    private Byte isAble;

    private Date createTime;

    private Date lastModifyTime;

    private String creater;

    private String lastModifier;

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

    public String getDicTypeCode() {
        return dicTypeCode;
    }

    public void setDicTypeCode(String dicTypeCode) {
        this.dicTypeCode = dicTypeCode == null ? null : dicTypeCode.trim();
    }

    public String getDicTypeName() {
        return dicTypeName;
    }

    public void setDicTypeName(String dicTypeName) {
        this.dicTypeName = dicTypeName == null ? null : dicTypeName.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Byte getIsAble() {
        return isAble;
    }

    public void setIsAble(Byte isAble) {
        this.isAble = isAble;
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
}