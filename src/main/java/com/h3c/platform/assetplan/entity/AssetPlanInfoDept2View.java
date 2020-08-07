package com.h3c.platform.assetplan.entity;

import java.math.BigDecimal;
import java.util.Date;

public class AssetPlanInfoDept2View {
    private Integer assetplanid;

    private String plancode;

    private String assetname;

    private String assetmanufacturer;

    private String assetmodel;

    private Integer requireds;

    private Integer requiredsaudit;

    private BigDecimal pprice;

    private BigDecimal totalmoney;

    private BigDecimal actualmoney;

    private String requireduser;

    private String requiredusername;

    private String deptcode;

    private String dept3name;

    private String dept2code;

    private String dept2name;

    private String itemcode;

    private String purpose;

    private String applyuser;

    private String usagerate;

    private String dept2manager;

    private String dept2checknote;

    private Integer outtimeplanenum;

    private String iscompleteset;

    private Integer completesetcode;

    private String apstatus;

    private String apstage;

    private Integer reviewresult;

    private Date reviewtime;

    private String applymonth;

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

    public String getApplyuser() {
        return applyuser;
    }

    public void setApplyuser(String applyuser) {
        this.applyuser = applyuser == null ? null : applyuser.trim();
    }

    public String getUsagerate() {
        return usagerate;
    }

    public void setUsagerate(String usagerate) {
        this.usagerate = usagerate == null ? null : usagerate.trim();
    }

    public String getDept2manager() {
        return dept2manager;
    }

    public void setDept2manager(String dept2manager) {
        this.dept2manager = dept2manager == null ? null : dept2manager.trim();
    }

    public String getDept2checknote() {
        return dept2checknote;
    }

    public void setDept2checknote(String dept2checknote) {
        this.dept2checknote = dept2checknote == null ? null : dept2checknote.trim();
    }

    public Integer getOuttimeplanenum() {
        return outtimeplanenum;
    }

    public void setOuttimeplanenum(Integer outtimeplanenum) {
        this.outtimeplanenum = outtimeplanenum;
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

    public String getApstage() {
        return apstage;
    }

    public void setApstage(String apstage) {
        this.apstage = apstage == null ? null : apstage.trim();
    }

    public Integer getReviewresult() {
        return reviewresult;
    }

    public void setReviewresult(Integer reviewresult) {
        this.reviewresult = reviewresult;
    }

    public Date getReviewtime() {
        return reviewtime;
    }

    public void setReviewtime(Date reviewtime) {
        this.reviewtime = reviewtime;
    }

    public String getApplymonth() {
        return applymonth;
    }

    public void setApplymonth(String applymonth) {
        this.applymonth = applymonth == null ? null : applymonth.trim();
    }

    public String getDeleteflag() {
        return deleteflag;
    }

    public void setDeleteflag(String deleteflag) {
        this.deleteflag = deleteflag == null ? null : deleteflag.trim();
    }
}