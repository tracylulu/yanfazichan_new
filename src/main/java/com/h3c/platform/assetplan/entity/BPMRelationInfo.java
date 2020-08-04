package com.h3c.platform.assetplan.entity;

import java.util.Date;

public class BPMRelationInfo {
    private Integer asstplanid;

    private String bpmcode;

    private String creator;

    private Date createtime;

    public Integer getAsstplanid() {
        return asstplanid;
    }

    public void setAsstplanid(Integer asstplanid) {
        this.asstplanid = asstplanid;
    }

    public String getBpmcode() {
        return bpmcode;
    }

    public void setBpmcode(String bpmcode) {
        this.bpmcode = bpmcode == null ? null : bpmcode.trim();
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