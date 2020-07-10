package com.h3c.platform.assetplan.entity;

import java.util.Date;

public class RateTotalInfo {
    private Integer id;

    private String deptCode;

    private String deptName;

    private String model;

    private String rate;

    private Integer number;

    private String distribution;

    private String detail;

    private String rdRate;

    private Integer rdNumber;

    private String ratedetail;

    private Date createtime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model == null ? null : model.trim();
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate == null ? null : rate.trim();
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getDistribution() {
        return distribution;
    }

    public void setDistribution(String distribution) {
        this.distribution = distribution == null ? null : distribution.trim();
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }

    public String getRdRate() {
        return rdRate;
    }

    public void setRdRate(String rdRate) {
        this.rdRate = rdRate == null ? null : rdRate.trim();
    }

    public Integer getRdNumber() {
        return rdNumber;
    }

    public void setRdNumber(Integer rdNumber) {
        this.rdNumber = rdNumber;
    }

    public String getRatedetail() {
        return ratedetail;
    }

    public void setRatedetail(String ratedetail) {
        this.ratedetail = ratedetail == null ? null : ratedetail.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}