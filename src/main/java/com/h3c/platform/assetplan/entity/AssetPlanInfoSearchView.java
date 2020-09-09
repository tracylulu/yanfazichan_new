package com.h3c.platform.assetplan.entity;

import java.math.BigDecimal;
import java.util.Date;

public class AssetPlanInfoSearchView {
    private Integer assetplanid;

    private String plancode;

    private Date planmonth;

    private String applymonth;

    private String assetname;

    private String expensetype;

    private String assetmanufacturer;

    private String assetmodel;

    private String assetcategory;

    private String goodstime;

    private String purpose;

    private Integer requireds;

    private Integer requiredsaudit;

    private BigDecimal pprice;

    private BigDecimal totalmoney;

    private BigDecimal actualmoney;

    private Integer reviewercount;

    private Integer dept3managercount;

    private Integer dept2managercount;

    private BigDecimal revieweragreemoney;

    private BigDecimal dept3agreemoney;

    private BigDecimal dept2agreemoney;

    private String requireduser;

    private String requiredusername;

    private String reviewperson;

    private String reviewer;

    private String dept3manager;

    private String dept2manager;

    private String planner;

    private String oqdeptreviewer;

    private String dept1reviewer;

    private String deptcode;

    private String dept3code;

    private String dept3name;

    private String dept2code;

    private String dept2name;

    private String dept1code;

    private String dept1name;

    private String itemcode;

    private String receiverplace;

    private Integer abnormalplanenum;

    private Integer outtimeplanenum;

    private String assetnote;

    private String applyuser;

    private String applyusername;

    private Date applytime;

    private String iscompleteset;

    private Integer completesetcode;

    private String apstatus;

    private String apstatusdetail;

    private String apstage;

    private String approvalperson;

    private String approvalnote;

    private String approvalresult;

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

    public Date getPlanmonth() {
        return planmonth;
    }

    public void setPlanmonth(Date planmonth) {
        this.planmonth = planmonth;
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

    public String getExpensetype() {
        return expensetype;
    }

    public void setExpensetype(String expensetype) {
        this.expensetype = expensetype == null ? null : expensetype.trim();
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

    public String getGoodstime() {
        return goodstime;
    }

    public void setGoodstime(String goodstime) {
        this.goodstime = goodstime == null ? null : goodstime.trim();
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose == null ? null : purpose.trim();
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

    public Integer getReviewercount() {
        return reviewercount;
    }

    public void setReviewercount(Integer reviewercount) {
        this.reviewercount = reviewercount;
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

    public BigDecimal getRevieweragreemoney() {
        return revieweragreemoney;
    }

    public void setRevieweragreemoney(BigDecimal revieweragreemoney) {
        this.revieweragreemoney = revieweragreemoney;
    }

    public BigDecimal getDept3agreemoney() {
        return dept3agreemoney;
    }

    public void setDept3agreemoney(BigDecimal dept3agreemoney) {
        this.dept3agreemoney = dept3agreemoney;
    }

    public BigDecimal getDept2agreemoney() {
        return dept2agreemoney;
    }

    public void setDept2agreemoney(BigDecimal dept2agreemoney) {
        this.dept2agreemoney = dept2agreemoney;
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

    public String getReviewperson() {
        return reviewperson;
    }

    public void setReviewperson(String reviewperson) {
        this.reviewperson = reviewperson == null ? null : reviewperson.trim();
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer == null ? null : reviewer.trim();
    }

    public String getDept3manager() {
        return dept3manager;
    }

    public void setDept3manager(String dept3manager) {
        this.dept3manager = dept3manager == null ? null : dept3manager.trim();
    }

    public String getDept2manager() {
        return dept2manager;
    }

    public void setDept2manager(String dept2manager) {
        this.dept2manager = dept2manager == null ? null : dept2manager.trim();
    }

    public String getPlanner() {
        return planner;
    }

    public void setPlanner(String planner) {
        this.planner = planner == null ? null : planner.trim();
    }

    public String getOqdeptreviewer() {
        return oqdeptreviewer;
    }

    public void setOqdeptreviewer(String oqdeptreviewer) {
        this.oqdeptreviewer = oqdeptreviewer == null ? null : oqdeptreviewer.trim();
    }

    public String getDept1reviewer() {
        return dept1reviewer;
    }

    public void setDept1reviewer(String dept1reviewer) {
        this.dept1reviewer = dept1reviewer == null ? null : dept1reviewer.trim();
    }

    public String getDeptcode() {
        return deptcode;
    }

    public void setDeptcode(String deptcode) {
        this.deptcode = deptcode == null ? null : deptcode.trim();
    }

    public String getDept3code() {
        return dept3code;
    }

    public void setDept3code(String dept3code) {
        this.dept3code = dept3code == null ? null : dept3code.trim();
    }

    public String getDept3name() {
        return dept3name;
    }

    public void setDept3name(String dept3name) {
        this.dept3name = dept3name == null ? null : dept3name.trim();
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

    public String getDept1code() {
        return dept1code;
    }

    public void setDept1code(String dept1code) {
        this.dept1code = dept1code == null ? null : dept1code.trim();
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

    public String getApplyusername() {
        return applyusername;
    }

    public void setApplyusername(String applyusername) {
        this.applyusername = applyusername == null ? null : applyusername.trim();
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

    public String getApprovalnote() {
        return approvalnote;
    }

    public void setApprovalnote(String approvalnote) {
        this.approvalnote = approvalnote == null ? null : approvalnote.trim();
    }

    public String getApprovalresult() {
        return approvalresult;
    }

    public void setApprovalresult(String approvalresult) {
        this.approvalresult = approvalresult == null ? null : approvalresult.trim();
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