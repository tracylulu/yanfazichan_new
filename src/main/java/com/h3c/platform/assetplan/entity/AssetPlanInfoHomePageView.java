package com.h3c.platform.assetplan.entity;

import java.math.BigDecimal;
import java.util.Date;

public class AssetPlanInfoHomePageView {
    private Integer assetplanid;

    private String plancode;

    private String assetname;

    private String assetmanufacturer;

    private String assetmodel;

    private String assetcategory;

    private BigDecimal pprice;

    private Date planmonth;

    private String applyuser;

    private Date applytime;

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

    private String apstatus;

    private String apstage;

    private String apstatusdetail;

    private String applymonth;

    private Integer dept3managercount;

    private Integer dept2managercount;

    private Integer plannercount;

    private Integer oqdeptreviewercount;

    private Integer dept1reviewercount;

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

    public BigDecimal getPprice() {
        return pprice;
    }

    public void setPprice(BigDecimal pprice) {
        this.pprice = pprice;
    }

    public Date getPlanmonth() {
        return planmonth;
    }

    public void setPlanmonth(Date planmonth) {
        this.planmonth = planmonth;
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

    public String getApstatusdetail() {
        return apstatusdetail;
    }

    public void setApstatusdetail(String apstatusdetail) {
        this.apstatusdetail = apstatusdetail == null ? null : apstatusdetail.trim();
    }

    public String getApplymonth() {
        return applymonth;
    }

    public void setApplymonth(String applymonth) {
        this.applymonth = applymonth == null ? null : applymonth.trim();
    }

    public Integer getDept3managercount() {
        return dept3managercount;
    }

    public void setDept3managercount(Integer dept3managercount) {
        this.dept3managercount = dept3managercount;
    }

    public Integer getDept2managercount() {
        return dept2managercount;
    }

    public void setDept2managercount(Integer dept2managercount) {
        this.dept2managercount = dept2managercount;
    }

    public Integer getPlannercount() {
        return plannercount;
    }

    public void setPlannercount(Integer plannercount) {
        this.plannercount = plannercount;
    }

    public Integer getOqdeptreviewercount() {
        return oqdeptreviewercount;
    }

    public void setOqdeptreviewercount(Integer oqdeptreviewercount) {
        this.oqdeptreviewercount = oqdeptreviewercount;
    }

    public Integer getDept1reviewercount() {
        return dept1reviewercount;
    }

    public void setDept1reviewercount(Integer dept1reviewercount) {
        this.dept1reviewercount = dept1reviewercount;
    }

    public String getDeleteflag() {
        return deleteflag;
    }

    public void setDeleteflag(String deleteflag) {
        this.deleteflag = deleteflag == null ? null : deleteflag.trim();
    }
}