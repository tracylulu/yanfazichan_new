package com.h3c.platform.assetplan.entity;

import java.util.Date;

public class PurchaseReportInfo {
    private Integer id;

    private String purchasereportid;

    private String titlecode;

    private String info;

    private String picturepath;

    private String creator;

    private Date createtime;

    private String modifier;

    private Date modifitime;

    private String deleteflag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPurchasereportid() {
        return purchasereportid;
    }

    public void setPurchasereportid(String purchasereportid) {
        this.purchasereportid = purchasereportid == null ? null : purchasereportid.trim();
    }

    public String getTitlecode() {
        return titlecode;
    }

    public void setTitlecode(String titlecode) {
        this.titlecode = titlecode == null ? null : titlecode.trim();
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info == null ? null : info.trim();
    }

    public String getPicturepath() {
        return picturepath;
    }

    public void setPicturepath(String picturepath) {
        this.picturepath = picturepath == null ? null : picturepath.trim();
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier == null ? null : modifier.trim();
    }

    public Date getModifitime() {
        return modifitime;
    }

    public void setModifitime(Date modifitime) {
        this.modifitime = modifitime;
    }

    public String getDeleteflag() {
        return deleteflag;
    }

    public void setDeleteflag(String deleteflag) {
        this.deleteflag = deleteflag == null ? null : deleteflag.trim();
    }
}