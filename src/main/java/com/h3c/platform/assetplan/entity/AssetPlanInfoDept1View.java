package com.h3c.platform.assetplan.entity;

import java.math.BigDecimal;
import java.util.Date;

public class AssetPlanInfoDept1View {
    private String dept1reviewer;

    private Integer assetplanid;

    private String plancode;

    private String assetname;

    private String applymonth;

    private String assetmanufacturer;

    private Integer requireds;

    private Integer requiredsaudit;

    private Long nopasscount;

    private BigDecimal pprice;

    private BigDecimal totalmoney;

    private BigDecimal actualmoney;

    private String requiredusername;

    private String requireduser;

    private String deptcode;

    private String dept2code;

    private String dept2name;

    private String iscompleteset;

    private Integer completesetcode;

    private String assetmodel;

    private String itemcode;

    private String purpose;

    private String dept1reviewnote;

    private String usagerate;

    private String manufacturertypeenum;

    private String assetcategory;

    private String groupflag;

    private Date reviewtime;

    private String groupflagdetail;

    public String getDept1reviewer() {
        return dept1reviewer;
    }

    public void setDept1reviewer(String dept1reviewer) {
        this.dept1reviewer = dept1reviewer == null ? null : dept1reviewer.trim();
    }

    public Integer getAssetplanid() {
        return assetplanid;
    }

    public void setAssetplanid(Integer assetplanid) {
        this.assetplanid = assetplanid;
    }

    public String getPlancode() {
        return plancode;
    }

    public void setPlancode(String plancode) {
        this.plancode = plancode == null ? null : plancode.trim();
    }

    public String getAssetname() {
        return assetname;
    }

    public void setAssetname(String assetname) {
        this.assetname = assetname == null ? null : assetname.trim();
    }

    public String getApplymonth() {
        return applymonth;
    }

    public void setApplymonth(String applymonth) {
        this.applymonth = applymonth == null ? null : applymonth.trim();
    }

    public String getAssetmanufacturer() {
        return assetmanufacturer;
    }

    public void setAssetmanufacturer(String assetmanufacturer) {
        this.assetmanufacturer = assetmanufacturer == null ? null : assetmanufacturer.trim();
    }

    public Integer getRequireds() {
        return requireds;
    }

    public void setRequireds(Integer requireds) {
        this.requireds = requireds;
    }

    public Integer getRequiredsaudit() {
        return requiredsaudit;
    }

    public void setRequiredsaudit(Integer requiredsaudit) {
        this.requiredsaudit = requiredsaudit;
    }

    public Long getNopasscount() {
        return nopasscount;
    }

    public void setNopasscount(Long nopasscount) {
        this.nopasscount = nopasscount;
    }

    public BigDecimal getPprice() {
        return pprice;
    }

    public void setPprice(BigDecimal pprice) {
        this.pprice = pprice;
    }

    public BigDecimal getTotalmoney() {
        return totalmoney;
    }

    public void setTotalmoney(BigDecimal totalmoney) {
        this.totalmoney = totalmoney;
    }

    public BigDecimal getActualmoney() {
        return actualmoney;
    }

    public void setActualmoney(BigDecimal actualmoney) {
        this.actualmoney = actualmoney;
    }

    public String getRequiredusername() {
        return requiredusername;
    }

    public void setRequiredusername(String requiredusername) {
        this.requiredusername = requiredusername == null ? null : requiredusername.trim();
    }

    public String getRequireduser() {
        return requireduser;
    }

    public void setRequireduser(String requireduser) {
        this.requireduser = requireduser == null ? null : requireduser.trim();
    }

    public String getDeptcode() {
        return deptcode;
    }

    public void setDeptcode(String deptcode) {
        this.deptcode = deptcode == null ? null : deptcode.trim();
    }

    public String getDept2code() {
        return dept2code;
    }

    public void setDept2code(String dept2code) {
        this.dept2code = dept2code == null ? null : dept2code.trim();
    }

    public String getDept2name() {
        return dept2name;
    }

    public void setDept2name(String dept2name) {
        this.dept2name = dept2name == null ? null : dept2name.trim();
    }

    public String getIscompleteset() {
        return iscompleteset;
    }

    public void setIscompleteset(String iscompleteset) {
        this.iscompleteset = iscompleteset == null ? null : iscompleteset.trim();
    }

    public Integer getCompletesetcode() {
        return completesetcode;
    }

    public void setCompletesetcode(Integer completesetcode) {
        this.completesetcode = completesetcode;
    }

    public String getAssetmodel() {
        return assetmodel;
    }

    public void setAssetmodel(String assetmodel) {
        this.assetmodel = assetmodel == null ? null : assetmodel.trim();
    }

    public String getItemcode() {
        return itemcode;
    }

    public void setItemcode(String itemcode) {
        this.itemcode = itemcode == null ? null : itemcode.trim();
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose == null ? null : purpose.trim();
    }

    public String getDept1reviewnote() {
        return dept1reviewnote;
    }

    public void setDept1reviewnote(String dept1reviewnote) {
        this.dept1reviewnote = dept1reviewnote == null ? null : dept1reviewnote.trim();
    }

    public String getUsagerate() {
        return usagerate;
    }

    public void setUsagerate(String usagerate) {
        this.usagerate = usagerate == null ? null : usagerate.trim();
    }

    public String getManufacturertypeenum() {
        return manufacturertypeenum;
    }

    public void setManufacturertypeenum(String manufacturertypeenum) {
        this.manufacturertypeenum = manufacturertypeenum == null ? null : manufacturertypeenum.trim();
    }

    public String getAssetcategory() {
        return assetcategory;
    }

    public void setAssetcategory(String assetcategory) {
        this.assetcategory = assetcategory == null ? null : assetcategory.trim();
    }

    public String getGroupflag() {
        return groupflag;
    }

    public void setGroupflag(String groupflag) {
        this.groupflag = groupflag == null ? null : groupflag.trim();
    }

    public Date getReviewtime() {
        return reviewtime;
    }

    public void setReviewtime(Date reviewtime) {
        this.reviewtime = reviewtime;
    }

    public String getGroupflagdetail() {
        return groupflagdetail;
    }

    public void setGroupflagdetail(String groupflagdetail) {
        this.groupflagdetail = groupflagdetail == null ? null : groupflagdetail.trim();
    }
}