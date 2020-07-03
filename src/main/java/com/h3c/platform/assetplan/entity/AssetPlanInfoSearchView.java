package com.h3c.platform.assetplan.entity;

import java.math.BigDecimal;
import java.util.Date;

public class AssetPlanInfoSearchView {
    private Integer assetplanid;

    private String plancode;

    private String applymonth;

    private String assetname;

    private String assetmanufacturer;

    private String assetmodel;

    private String assetcategory;

    private Integer requireds;

    private Integer requiredsaudit;

    private BigDecimal pprice;

    private BigDecimal totalmoney;

    private BigDecimal actualmoney;

    private String requireduser;

    private String requiredusername;

    private String deptcode;

    private Integer dept2code;

    private String dept2name;

    private Integer dept1code;

    private String dept1name;

    private String itemcode;

    private String receiverplace;

    private Integer abnormalplanenum;

    private Integer outtimeplanenum;

    private String assetnote;

    private String applyuser;

    private Date applytime;

    private String iscompleteset;

    private Integer completesetcode;

    private String apstatus;

    private String apstatusdetail;

    private String apstage;

    private String approvalperson;

    private String isreqpurchasereport;

    private String isspecifymanufacturer;

    private Integer manufacturertypeenum;

    private Integer reviewresult;

    private String deleteflag;

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

    public String getApplymonth() {
        return applymonth;
    }

    public void setApplymonth(String applymonth) {
        this.applymonth = applymonth == null ? null : applymonth.trim();
    }

    public String getAssetname() {
        return assetname;
    }

    public void setAssetname(String assetname) {
        this.assetname = assetname == null ? null : assetname.trim();
    }

    public String getAssetmanufacturer() {
        return assetmanufacturer;
    }

    public void setAssetmanufacturer(String assetmanufacturer) {
        this.assetmanufacturer = assetmanufacturer == null ? null : assetmanufacturer.trim();
    }

    public String getAssetmodel() {
        return assetmodel;
    }

    public void setAssetmodel(String assetmodel) {
        this.assetmodel = assetmodel == null ? null : assetmodel.trim();
    }

    public String getAssetcategory() {
        return assetcategory;
    }

    public void setAssetcategory(String assetcategory) {
        this.assetcategory = assetcategory == null ? null : assetcategory.trim();
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

    public String getRequireduser() {
        return requireduser;
    }

    public void setRequireduser(String requireduser) {
        this.requireduser = requireduser == null ? null : requireduser.trim();
    }

    public String getRequiredusername() {
        return requiredusername;
    }

    public void setRequiredusername(String requiredusername) {
        this.requiredusername = requiredusername == null ? null : requiredusername.trim();
    }

    public String getDeptcode() {
        return deptcode;
    }

    public void setDeptcode(String deptcode) {
        this.deptcode = deptcode == null ? null : deptcode.trim();
    }

    public Integer getDept2code() {
        return dept2code;
    }

    public void setDept2code(Integer dept2code) {
        this.dept2code = dept2code;
    }

    public String getDept2name() {
        return dept2name;
    }

    public void setDept2name(String dept2name) {
        this.dept2name = dept2name == null ? null : dept2name.trim();
    }

    public Integer getDept1code() {
        return dept1code;
    }

    public void setDept1code(Integer dept1code) {
        this.dept1code = dept1code;
    }

    public String getDept1name() {
        return dept1name;
    }

    public void setDept1name(String dept1name) {
        this.dept1name = dept1name == null ? null : dept1name.trim();
    }

    public String getItemcode() {
        return itemcode;
    }

    public void setItemcode(String itemcode) {
        this.itemcode = itemcode == null ? null : itemcode.trim();
    }

    public String getReceiverplace() {
        return receiverplace;
    }

    public void setReceiverplace(String receiverplace) {
        this.receiverplace = receiverplace == null ? null : receiverplace.trim();
    }

    public Integer getAbnormalplanenum() {
        return abnormalplanenum;
    }

    public void setAbnormalplanenum(Integer abnormalplanenum) {
        this.abnormalplanenum = abnormalplanenum;
    }

    public Integer getOuttimeplanenum() {
        return outtimeplanenum;
    }

    public void setOuttimeplanenum(Integer outtimeplanenum) {
        this.outtimeplanenum = outtimeplanenum;
    }

    public String getAssetnote() {
        return assetnote;
    }

    public void setAssetnote(String assetnote) {
        this.assetnote = assetnote == null ? null : assetnote.trim();
    }

    public String getApplyuser() {
        return applyuser;
    }

    public void setApplyuser(String applyuser) {
        this.applyuser = applyuser == null ? null : applyuser.trim();
    }

    public Date getApplytime() {
        return applytime;
    }

    public void setApplytime(Date applytime) {
        this.applytime = applytime;
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

    public String getApstatus() {
        return apstatus;
    }

    public void setApstatus(String apstatus) {
        this.apstatus = apstatus == null ? null : apstatus.trim();
    }

    public String getApstatusdetail() {
        return apstatusdetail;
    }

    public void setApstatusdetail(String apstatusdetail) {
        this.apstatusdetail = apstatusdetail == null ? null : apstatusdetail.trim();
    }

    public String getApstage() {
        return apstage;
    }

    public void setApstage(String apstage) {
        this.apstage = apstage == null ? null : apstage.trim();
    }

    public String getApprovalperson() {
        return approvalperson;
    }

    public void setApprovalperson(String approvalperson) {
        this.approvalperson = approvalperson == null ? null : approvalperson.trim();
    }

    public String getIsreqpurchasereport() {
        return isreqpurchasereport;
    }

    public void setIsreqpurchasereport(String isreqpurchasereport) {
        this.isreqpurchasereport = isreqpurchasereport == null ? null : isreqpurchasereport.trim();
    }

    public String getIsspecifymanufacturer() {
        return isspecifymanufacturer;
    }

    public void setIsspecifymanufacturer(String isspecifymanufacturer) {
        this.isspecifymanufacturer = isspecifymanufacturer == null ? null : isspecifymanufacturer.trim();
    }

    public Integer getManufacturertypeenum() {
        return manufacturertypeenum;
    }

    public void setManufacturertypeenum(Integer manufacturertypeenum) {
        this.manufacturertypeenum = manufacturertypeenum;
    }

    public Integer getReviewresult() {
        return reviewresult;
    }

    public void setReviewresult(Integer reviewresult) {
        this.reviewresult = reviewresult;
    }

    public String getDeleteflag() {
        return deleteflag;
    }

    public void setDeleteflag(String deleteflag) {
        this.deleteflag = deleteflag == null ? null : deleteflag.trim();
    }
}