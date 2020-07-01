package com.h3c.platform.assetplan.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Administrator
 *
 */
public class AssetInfoUpdateEntity   {	
	
	public List<Integer> assetplanid;

	//规范审核(厂家/型号/预计单价/类别/规范审核状态/审核意见)
    public  String assetmanufacturer;

    public List<String> assetmodel;
    
    private List<BigDecimal> pprice;
    
    private List<BigDecimal> totalmoney;
    
    private String assetcategory;
    
    public String goodstime;
    
    private Integer reviewresult;
    
    private String reviewnote;
    
    //计划员页面
    //同意申购数量
    private List<Integer> requiredsaudit;
    //评审后金额
    private List<BigDecimal> actualmoney;
    
    private String plannernote;

    //三级部门页面
    //同意申购数量   //评审后金额
    
    private String dept3checknote;
    
    //二级部门页面
    //同意申购数量   //评审后金额
    
    private String dept2checknote;
    
    private String oqdeptreviewnote;

    private String dept1reviewnote;
    
	public List<Integer> getAssetplanid() {
		return assetplanid;
	}

	public void setAssetplanid(List<Integer> assetplanid) {
		this.assetplanid = assetplanid;
	}

	public String getAssetmanufacturer() {
		return assetmanufacturer;
	}

	public void setAssetmanufacturer(String assetmanufacturer) {
		this.assetmanufacturer = assetmanufacturer;
	}

	public List<String> getAssetmodel() {
		return assetmodel;
	}

	public void setAssetmodel(List<String> assetmodel) {
		this.assetmodel = assetmodel;
	}

	public List<BigDecimal> getPprice() {
		return pprice;
	}

	public void setPprice(List<BigDecimal> pprice) {
		this.pprice = pprice;
	}

	public List<BigDecimal> getTotalmoney() {
		return totalmoney;
	}

	public void setTotalmoney(List<BigDecimal> totalmoney) {
		this.totalmoney = totalmoney;
	}

	

	public String getAssetcategory() {
		return assetcategory;
	}

	public void setAssetcategory(String assetcategory) {
		this.assetcategory = assetcategory;
	}

	public String getGoodstime() {
		return goodstime;
	}

	public void setGoodstime(String goodstime) {
		this.goodstime = goodstime;
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

	

	public List<Integer> getRequiredsaudit() {
		return requiredsaudit;
	}

	public void setRequiredsaudit(List<Integer> requiredsaudit) {
		this.requiredsaudit = requiredsaudit;
	}

	public List<BigDecimal> getActualmoney() {
		return actualmoney;
	}

	public void setActualmoney(List<BigDecimal> actualmoney) {
		this.actualmoney = actualmoney;
	}

	public String getPlannernote() {
		return plannernote;
	}

	public void setPlannernote(String plannernote) {
		this.plannernote = plannernote;
	}

	public String getDept3checknote() {
		return dept3checknote;
	}

	public void setDept3checknote(String dept3checknote) {
		this.dept3checknote = dept3checknote;
	}

	public String getDept2checknote() {
		return dept2checknote;
	}

	public void setDept2checknote(String dept2checknote) {
		this.dept2checknote = dept2checknote;
	}

	public String getOqdeptreviewnote() {
		return oqdeptreviewnote;
	}

	public void setOqdeptreviewnote(String oqdeptreviewnote) {
		this.oqdeptreviewnote = oqdeptreviewnote;
	}

	public String getDept1reviewnote() {
		return dept1reviewnote;
	}

	public void setDept1reviewnote(String dept1reviewnote) {
		this.dept1reviewnote = dept1reviewnote;
	}
 
    
    
    
}
