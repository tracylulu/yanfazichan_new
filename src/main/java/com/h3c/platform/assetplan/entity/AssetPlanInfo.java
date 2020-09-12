package com.h3c.platform.assetplan.entity;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class AssetPlanInfo {
    private Integer assetplanid;

    private String plancode;

    private BigDecimal pprice;

    private BigDecimal totalmoney;

    private BigDecimal actualmoney;

    private String assetname;

    private String assetmanufacturer;

    private String assetmodel;

    private String assetcategory;

    private Date planmonth;

    private Integer requireds;

    private Integer requiredsaudit;

    private String purpose;

    private String deptcode;

    private String itemcode;

    private String requireduser;

    private String receiverplace;

    private String assetnote;

    private String applyuser;

    private Date applytime;

    private String modifier;

    private Date modifitime;

    private String goodstime;
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
    private Date reqarrivaldate;

    private String iscompleteset;

    private Integer completesetcode;

    private String isreqpurchasereport;

    private String purchasereportid;

    private String isspecifymanufacturer;

    private Integer manufacturertypeenum;

    private String specifymanufacturerid;

    private Integer abnormalplanenum;

    private String apstatus;

    private String apstage;

    private String deleteflag;

    private Integer outtimeplanenum;

    private String usagerate;

    private String reviewer;

    private Date reviewtime;

    private Integer reviewresult;

    private String reviewnote;

    private String dept3manager;

    private Date dept3checktime;

    private String dept3checknote;

    private String dept2manager;

    private Date dept2checktime;

    private String dept2checknote;

    private String planner;

    private Date plannertime;

    private String plannernote;

    private String oqdeptreviewer;

    private Date oqdeptreviewtime;

    private String oqdeptreviewnote;

    private String dept1reviewer;

    private Date dept1reviewtime;

    private String dept1reviewnote;

    private String reviewperson;

    private String expensetype;

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

    public Date getPlanmonth() {
        return planmonth;
    }

    public void setPlanmonth(Date planmonth) {
        this.planmonth = planmonth;
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

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose == null ? null : purpose.trim();
    }

    public String getDeptcode() {
        return deptcode;
    }

    public void setDeptcode(String deptcode) {
        this.deptcode = deptcode == null ? null : deptcode.trim();
    }

    public String getItemcode() {
        return itemcode;
    }

    public void setItemcode(String itemcode) {
        this.itemcode = itemcode == null ? null : itemcode.trim();
    }

    public String getRequireduser() {
        return requireduser;
    }

    public void setRequireduser(String requireduser) {
        this.requireduser = requireduser == null ? null : requireduser.trim();
    }

    public String getReceiverplace() {
        return receiverplace;
    }

    public void setReceiverplace(String receiverplace) {
        this.receiverplace = receiverplace == null ? null : receiverplace.trim();
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

    public String getGoodstime() {
        return goodstime;
    }

    public void setGoodstime(String goodstime) {
        this.goodstime = goodstime == null ? null : goodstime.trim();
    }

    public Date getReqarrivaldate() {
        return reqarrivaldate;
    }

    public void setReqarrivaldate(Date reqarrivaldate) {
        this.reqarrivaldate = reqarrivaldate;
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

    public String getIsreqpurchasereport() {
        return isreqpurchasereport;
    }

    public void setIsreqpurchasereport(String isreqpurchasereport) {
        this.isreqpurchasereport = isreqpurchasereport == null ? null : isreqpurchasereport.trim();
    }

    public String getPurchasereportid() {
        return purchasereportid;
    }

    public void setPurchasereportid(String purchasereportid) {
        this.purchasereportid = purchasereportid == null ? null : purchasereportid.trim();
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

    public String getSpecifymanufacturerid() {
        return specifymanufacturerid;
    }

    public void setSpecifymanufacturerid(String specifymanufacturerid) {
        this.specifymanufacturerid = specifymanufacturerid == null ? null : specifymanufacturerid.trim();
    }

    public Integer getAbnormalplanenum() {
        return abnormalplanenum;
    }

    public void setAbnormalplanenum(Integer abnormalplanenum) {
        this.abnormalplanenum = abnormalplanenum;
    }

    public String getApstatus() {
        return apstatus;
    }

    public void setApstatus(String apstatus) {
        this.apstatus = apstatus == null ? null : apstatus.trim();
    }

    public String getApstage() {
        return apstage;
    }

    public void setApstage(String apstage) {
        this.apstage = apstage == null ? null : apstage.trim();
    }

    public String getDeleteflag() {
        return deleteflag;
    }

    public void setDeleteflag(String deleteflag) {
        this.deleteflag = deleteflag == null ? null : deleteflag.trim();
    }

    public Integer getOuttimeplanenum() {
        return outtimeplanenum;
    }

    public void setOuttimeplanenum(Integer outtimeplanenum) {
        this.outtimeplanenum = outtimeplanenum;
    }

    public String getUsagerate() {
        return usagerate;
    }

    public void setUsagerate(String usagerate) {
        this.usagerate = usagerate == null ? null : usagerate.trim();
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer == null ? null : reviewer.trim();
    }

    public Date getReviewtime() {
        return reviewtime;
    }

    public void setReviewtime(Date reviewtime) {
        this.reviewtime = reviewtime;
    }

    public Integer getReviewresult() {
        return reviewresult;
    }

    public void setReviewresult(Integer reviewresult) {
        this.reviewresult = reviewresult;
    }

    public String getReviewnote() {
        return reviewnote;
    }

    public void setReviewnote(String reviewnote) {
        this.reviewnote = reviewnote == null ? null : reviewnote.trim();
    }

    public String getDept3manager() {
        return dept3manager;
    }

    public void setDept3manager(String dept3manager) {
        this.dept3manager = dept3manager == null ? null : dept3manager.trim();
    }

    public Date getDept3checktime() {
        return dept3checktime;
    }

    public void setDept3checktime(Date dept3checktime) {
        this.dept3checktime = dept3checktime;
    }

    public String getDept3checknote() {
        return dept3checknote;
    }

    public void setDept3checknote(String dept3checknote) {
        this.dept3checknote = dept3checknote == null ? null : dept3checknote.trim();
    }

    public String getDept2manager() {
        return dept2manager;
    }

    public void setDept2manager(String dept2manager) {
        this.dept2manager = dept2manager == null ? null : dept2manager.trim();
    }

    public Date getDept2checktime() {
        return dept2checktime;
    }

    public void setDept2checktime(Date dept2checktime) {
        this.dept2checktime = dept2checktime;
    }

    public String getDept2checknote() {
        return dept2checknote;
    }

    public void setDept2checknote(String dept2checknote) {
        this.dept2checknote = dept2checknote == null ? null : dept2checknote.trim();
    }

    public String getPlanner() {
        return planner;
    }

    public void setPlanner(String planner) {
        this.planner = planner == null ? null : planner.trim();
    }

    public Date getPlannertime() {
        return plannertime;
    }

    public void setPlannertime(Date plannertime) {
        this.plannertime = plannertime;
    }

    public String getPlannernote() {
        return plannernote;
    }

    public void setPlannernote(String plannernote) {
        this.plannernote = plannernote == null ? null : plannernote.trim();
    }

    public String getOqdeptreviewer() {
        return oqdeptreviewer;
    }

    public void setOqdeptreviewer(String oqdeptreviewer) {
        this.oqdeptreviewer = oqdeptreviewer == null ? null : oqdeptreviewer.trim();
    }

    public Date getOqdeptreviewtime() {
        return oqdeptreviewtime;
    }

    public void setOqdeptreviewtime(Date oqdeptreviewtime) {
        this.oqdeptreviewtime = oqdeptreviewtime;
    }

    public String getOqdeptreviewnote() {
        return oqdeptreviewnote;
    }

    public void setOqdeptreviewnote(String oqdeptreviewnote) {
        this.oqdeptreviewnote = oqdeptreviewnote == null ? null : oqdeptreviewnote.trim();
    }

    public String getDept1reviewer() {
        return dept1reviewer;
    }

    public void setDept1reviewer(String dept1reviewer) {
        this.dept1reviewer = dept1reviewer == null ? null : dept1reviewer.trim();
    }

    public Date getDept1reviewtime() {
        return dept1reviewtime;
    }

    public void setDept1reviewtime(Date dept1reviewtime) {
        this.dept1reviewtime = dept1reviewtime;
    }

    public String getDept1reviewnote() {
        return dept1reviewnote;
    }

    public void setDept1reviewnote(String dept1reviewnote) {
        this.dept1reviewnote = dept1reviewnote == null ? null : dept1reviewnote.trim();
    }

    public String getReviewperson() {
        return reviewperson;
    }

    public void setReviewperson(String reviewperson) {
        this.reviewperson = reviewperson == null ? null : reviewperson.trim();
    }

    public String getExpensetype() {
        return expensetype;
    }

    public void setExpensetype(String expensetype) {
        this.expensetype = expensetype == null ? null : expensetype.trim();
    }
}