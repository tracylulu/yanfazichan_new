package com.h3c.platform.assetplan.entity;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class AssetPlanInfoAll {
	//完整的实体类
    private Integer assetplanid;

    private String plancode;

    private String pprice;

    private String totalmoney;

    private String actualmoney;

    private String assetname;

    private String assetmanufacturer;

    private String assetmodel;

    private String assetcategory;
    
    private String assetcategoryId;

    private String planmonth;

    private Integer requireds;

    private Integer requiredsaudit;

    private String purpose;

    private String deptcode;

    private String itemcode;

    private String requireduser;

    private String receiverplaceId;
    
    private String receiverplace;

    private String assetnote;

    private String applyuser;

    private String applytime;

    private String modifier;

    private String modifitime;

    private String goodstime;

    private String reqarrivaldate;

    private String iscompleteset;

    private Integer completesetcode;

    private String isreqpurchasereport;

    private String purchasereportid;

    private String isspecifymanufacturer;

    private String manufacturertypeenum;

    private String specifymanufacturerid;

    private Integer abnormalplanenum;

    private String apstatus;

    private String apstage;

    private String deleteflag;

    private Integer outtimeplanenum;

    private String usagerate;

    private String reviewer;
    
    private String reviewtime;

    private Integer reviewresult;

    private String reviewnote;

    private String dept3manager;

    private String dept3checktime;

    private String dept3checknote;

    private String dept2manager;

    private String dept2checktime;

    private String dept2checknote;

    private String planner;

    private String plannertime;

    private String plannernote;

    private String oqdeptreviewer;

    private String oqdeptreviewtime;

    private String oqdeptreviewnote;

    private String dept1reviewer;

    private String dept1reviewtime;

    private String dept1reviewnote;
	
    private String reviewperson;
    
    private String expensetype;
    
	//菜单页面视图多加的字段
	private String apstatusdetail;

    private String applymonth;
	
	//申请页面
	
	private String requiredusername;
	
	private String dept3name;
	
	//计划员
	private Long nopasscount;
	
	private Long groupflag;

    private String groupflagdetail;

    private String isspecify;
	
	private String dept2code;

    private String dept2name;

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
		this.plancode = plancode;
	}

	public String getPprice() {
		return pprice;
	}

	public void setPprice(String pprice) {
		this.pprice = pprice;
	}

	public String getTotalmoney() {
		return totalmoney;
	}

	public void setTotalmoney(String totalmoney) {
		this.totalmoney = totalmoney;
	}

	public String getActualmoney() {
		return actualmoney;
	}

	public void setActualmoney(String actualmoney) {
		this.actualmoney = actualmoney;
	}

	public String getAssetname() {
		return assetname;
	}

	public void setAssetname(String assetname) {
		this.assetname = assetname;
	}

	public String getAssetmanufacturer() {
		return assetmanufacturer;
	}

	public void setAssetmanufacturer(String assetmanufacturer) {
		this.assetmanufacturer = assetmanufacturer;
	}

	public String getAssetmodel() {
		return assetmodel;
	}

	public void setAssetmodel(String assetmodel) {
		this.assetmodel = assetmodel;
	}

	public String getAssetcategory() {
		return assetcategory;
	}

	public void setAssetcategory(String assetcategory) {
		this.assetcategory = assetcategory;
	}

	public String getPlanmonth() {
		return planmonth;
	}

	public void setPlanmonth(String planmonth) {
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
		this.purpose = purpose;
	}

	public String getDeptcode() {
		return deptcode;
	}

	public void setDeptcode(String deptcode) {
		this.deptcode = deptcode;
	}

	public String getItemcode() {
		return itemcode;
	}

	public void setItemcode(String itemcode) {
		this.itemcode = itemcode;
	}

	public String getRequireduser() {
		return requireduser;
	}

	public void setRequireduser(String requireduser) {
		this.requireduser = requireduser;
	}

	public String getReceiverplace() {
		return receiverplace;
	}

	public void setReceiverplace(String receiverplace) {
		this.receiverplace = receiverplace;
	}

	public String getAssetnote() {
		return assetnote;
	}

	public void setAssetnote(String assetnote) {
		this.assetnote = assetnote;
	}

	public String getApplyuser() {
		return applyuser;
	}

	public void setApplyuser(String applyuser) {
		this.applyuser = applyuser;
	}

	public String getApplytime() {
		return applytime;
	}

	public void setApplytime(String applytime) {
		this.applytime = applytime;
	}

	public String getModifier() {
		return modifier;
	}

	public void setModifier(String modifier) {
		this.modifier = modifier;
	}

	public String getModifitime() {
		return modifitime;
	}

	public void setModifitime(String modifitime) {
		this.modifitime = modifitime;
	}

	public String getGoodstime() {
		return goodstime;
	}

	public void setGoodstime(String goodstime) {
		this.goodstime = goodstime;
	}

	public String getReqarrivaldate() {
		return reqarrivaldate;
	}

	public void setReqarrivaldate(String reqarrivaldate) {
		this.reqarrivaldate = reqarrivaldate;
	}

	public String getIscompleteset() {
		return iscompleteset;
	}

	public void setIscompleteset(String iscompleteset) {
		this.iscompleteset = iscompleteset;
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
		this.isreqpurchasereport = isreqpurchasereport;
	}

	public String getPurchasereportid() {
		return purchasereportid;
	}

	public void setPurchasereportid(String purchasereportid) {
		this.purchasereportid = purchasereportid;
	}

	public String getIsspecifymanufacturer() {
		return isspecifymanufacturer;
	}

	public void setIsspecifymanufacturer(String isspecifymanufacturer) {
		this.isspecifymanufacturer = isspecifymanufacturer;
	}

	public String getManufacturertypeenum() {
		return manufacturertypeenum;
	}

	public void setManufacturertypeenum(String manufacturertypeenum) {
		this.manufacturertypeenum = manufacturertypeenum;
	}

	public String getSpecifymanufacturerid() {
		return specifymanufacturerid;
	}

	public void setSpecifymanufacturerid(String specifymanufacturerid) {
		this.specifymanufacturerid = specifymanufacturerid;
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
		this.apstatus = apstatus;
	}

	public String getApstage() {
		return apstage;
	}

	public void setApstage(String apstage) {
		this.apstage = apstage;
	}

	public String getDeleteflag() {
		return deleteflag;
	}

	public void setDeleteflag(String deleteflag) {
		this.deleteflag = deleteflag;
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
		this.usagerate = usagerate;
	}

	public String getReviewer() {
		return reviewer;
	}

	public void setReviewer(String reviewer) {
		this.reviewer = reviewer;
	}

	public String getReviewtime() {
		return reviewtime;
	}

	public void setReviewtime(String reviewtime) {
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
		this.reviewnote = reviewnote;
	}

	public String getDept3manager() {
		return dept3manager;
	}

	public void setDept3manager(String dept3manager) {
		this.dept3manager = dept3manager;
	}

	public String getDept3checktime() {
		return dept3checktime;
	}

	public void setDept3checktime(String dept3checktime) {
		this.dept3checktime = dept3checktime;
	}

	public String getDept3checknote() {
		return dept3checknote;
	}

	public void setDept3checknote(String dept3checknote) {
		this.dept3checknote = dept3checknote;
	}

	public String getDept2manager() {
		return dept2manager;
	}

	public void setDept2manager(String dept2manager) {
		this.dept2manager = dept2manager;
	}

	public String getDept2checktime() {
		return dept2checktime;
	}

	public void setDept2checktime(String dept2checktime) {
		this.dept2checktime = dept2checktime;
	}

	public String getDept2checknote() {
		return dept2checknote;
	}

	public void setDept2checknote(String dept2checknote) {
		this.dept2checknote = dept2checknote;
	}

	public String getPlanner() {
		return planner;
	}

	public void setPlanner(String planner) {
		this.planner = planner;
	}

	public String getPlannertime() {
		return plannertime;
	}

	public void setPlannertime(String plannertime) {
		this.plannertime = plannertime;
	}

	public String getPlannernote() {
		return plannernote;
	}

	public void setPlannernote(String plannernote) {
		this.plannernote = plannernote;
	}

	public String getOqdeptreviewer() {
		return oqdeptreviewer;
	}

	public void setOqdeptreviewer(String oqdeptreviewer) {
		this.oqdeptreviewer = oqdeptreviewer;
	}

	public String getOqdeptreviewtime() {
		return oqdeptreviewtime;
	}

	public void setOqdeptreviewtime(String oqdeptreviewtime) {
		this.oqdeptreviewtime = oqdeptreviewtime;
	}

	public String getOqdeptreviewnote() {
		return oqdeptreviewnote;
	}

	public void setOqdeptreviewnote(String oqdeptreviewnote) {
		this.oqdeptreviewnote = oqdeptreviewnote;
	}

	public String getDept1reviewer() {
		return dept1reviewer;
	}

	public void setDept1reviewer(String dept1reviewer) {
		this.dept1reviewer = dept1reviewer;
	}

	public String getDept1reviewtime() {
		return dept1reviewtime;
	}

	public void setDept1reviewtime(String dept1reviewtime) {
		this.dept1reviewtime = dept1reviewtime;
	}

	public String getDept1reviewnote() {
		return dept1reviewnote;
	}

	public void setDept1reviewnote(String dept1reviewnote) {
		this.dept1reviewnote = dept1reviewnote;
	}

	public String getApstatusdetail() {
		return apstatusdetail;
	}

	public void setApstatusdetail(String apstatusdetail) {
		this.apstatusdetail = apstatusdetail;
	}

	public String getApplymonth() {
		return applymonth;
	}

	public void setApplymonth(String applymonth) {
		this.applymonth = applymonth;
	}

	public String getRequiredusername() {
		return requiredusername;
	}

	public void setRequiredusername(String requiredusername) {
		this.requiredusername = requiredusername;
	}

	public String getDept3name() {
		return dept3name;
	}

	public void setDept3name(String dept3name) {
		this.dept3name = dept3name;
	}

	public Long getNopasscount() {
		return nopasscount;
	}

	public void setNopasscount(Long nopasscount) {
		this.nopasscount = nopasscount;
	}

	public Long getGroupflag() {
		return groupflag;
	}

	public void setGroupflag(Long groupflag) {
		this.groupflag = groupflag;
	}

	public String getGroupflagdetail() {
		return groupflagdetail;
	}

	public void setGroupflagdetail(String groupflagdetail) {
		this.groupflagdetail = groupflagdetail;
	}

	public String getIsspecify() {
		return isspecify;
	}

	public void setIsspecify(String isspecify) {
		this.isspecify = isspecify;
	}

	public String getDept2code() {
		return dept2code;
	}

	public void setDept2code(String dept2code) {
		this.dept2code = dept2code;
	}

	public String getDept2name() {
		return dept2name;
	}

	public void setDept2name(String dept2name) {
		this.dept2name = dept2name;
	}

	public String getAssetcategoryId() {
		return assetcategoryId;
	}

	public void setAssetcategoryId(String assetcategoryId) {
		this.assetcategoryId = assetcategoryId;
	}

	public String getReceiverplaceId() {
		return receiverplaceId;
	}

	public void setReceiverplaceId(String receiverplaceId) {
		this.receiverplaceId = receiverplaceId;
	}

	public String getReviewperson() {
		return reviewperson;
	}

	public void setReviewperson(String reviewperson) {
		this.reviewperson = reviewperson;
	}

	public String getExpensetype() {
		return expensetype;
	}

	public void setExpensetype(String expensetype) {
		this.expensetype = expensetype;
	}

	
}