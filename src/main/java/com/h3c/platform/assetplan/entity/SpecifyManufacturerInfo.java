package com.h3c.platform.assetplan.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class SpecifyManufacturerInfo {
    private Integer specifymanufacturerid;

    private String purpose;

    private String necessityanalysis;

    private String creator;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createtime;

    private String modifier;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date modifitime;

    private String deleteflag;

    private String addthecontent;

    public Integer getSpecifymanufacturerid() {
        return specifymanufacturerid;
    }

    public void setSpecifymanufacturerid(Integer specifymanufacturerid) {
        this.specifymanufacturerid = specifymanufacturerid;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose == null ? null : purpose.trim();
    }

    public String getNecessityanalysis() {
        return necessityanalysis;
    }

    public void setNecessityanalysis(String necessityanalysis) {
        this.necessityanalysis = necessityanalysis == null ? null : necessityanalysis.trim();
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

    public String getAddthecontent() {
        return addthecontent;
    }

    public void setAddthecontent(String addthecontent) {
        this.addthecontent = addthecontent == null ? null : addthecontent.trim();
    }
}