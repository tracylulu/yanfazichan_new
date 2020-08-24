package com.h3c.platform.assetplan.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Administrator
 *3级审批环节及以后的环节修改通用实体类
 */
public class AssetInfoUpdateEntityForDept3AndOther   {	
	
	public List<Integer> assetplanid;
    //同意申购数量
    private List<Integer> requiredsaudit;
    //评审后金额
    private List<BigDecimal> actualmoney;
    //三级部门页面
    private List<String> dept3checknote;
    //二级部门页面
    private List<String> dept2checknote;
    //计划员页面
    private List<String> plannernote;
    //专家团页面
    private List<String> oqdeptreviewnote;
    //一级部门页面
    private List<String> dept1reviewnote;
	public List<Integer> getAssetplanid() {
		return assetplanid;
	}
	public void setAssetplanid(List<Integer> assetplanid) {
		this.assetplanid = assetplanid;
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
	public List<String> getDept3checknote() {
		return dept3checknote;
	}
	public void setDept3checknote(List<String> dept3checknote) {
		this.dept3checknote = dept3checknote;
	}
	public List<String> getDept2checknote() {
		return dept2checknote;
	}
	public void setDept2checknote(List<String> dept2checknote) {
		this.dept2checknote = dept2checknote;
	}
	public List<String> getPlannernote() {
		return plannernote;
	}
	public void setPlannernote(List<String> plannernote) {
		this.plannernote = plannernote;
	}
	public List<String> getOqdeptreviewnote() {
		return oqdeptreviewnote;
	}
	public void setOqdeptreviewnote(List<String> oqdeptreviewnote) {
		this.oqdeptreviewnote = oqdeptreviewnote;
	}
	public List<String> getDept1reviewnote() {
		return dept1reviewnote;
	}
	public void setDept1reviewnote(List<String> dept1reviewnote) {
		this.dept1reviewnote = dept1reviewnote;
	}
    
	
    
    
    
}
