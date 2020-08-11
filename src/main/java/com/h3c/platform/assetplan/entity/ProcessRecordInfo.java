package com.h3c.platform.assetplan.entity;

import java.util.Date;

public class ProcessRecordInfo {
    private Integer id;

    private Integer assetplanid;

    private String apstage;

    private String currentperson;

    private String newperson;

    private String creator;

    private Date createtime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAssetplanid() {
        return assetplanid;
    }

    public void setAssetplanid(Integer assetplanid) {
        this.assetplanid = assetplanid;
    }

    public String getApstage() {
        return apstage;
    }

    public void setApstage(String apstage) {
        this.apstage = apstage == null ? null : apstage.trim();
    }

    public String getCurrentperson() {
        return currentperson;
    }

    public void setCurrentperson(String currentperson) {
        this.currentperson = currentperson == null ? null : currentperson.trim();
    }

    public String getNewperson() {
        return newperson;
    }

    public void setNewperson(String newperson) {
        this.newperson = newperson == null ? null : newperson.trim();
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
}