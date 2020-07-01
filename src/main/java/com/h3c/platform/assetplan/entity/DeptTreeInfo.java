package com.h3c.platform.assetplan.entity;

import java.util.List;



public class DeptTreeInfo {
    private Integer deptCode;

    private String deptName;

    private String supDeptDode;
    
    private String deptLevel;

    private List<DeptTreeInfo> children;

	public Integer getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(Integer deptCode) {
		this.deptCode = deptCode;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getSupDeptDode() {
		return supDeptDode;
	}

	public void setSupDeptDode(String supDeptDode) {
		this.supDeptDode = supDeptDode;
	}

	public List<DeptTreeInfo> getChildren() {
		return children;
	}

	public void setChildren(List<DeptTreeInfo> children) {
		this.children = children;
	}

	public String getDeptLevel() {
		return deptLevel;
	}

	public void setDeptLevel(String deptLevel) {
		this.deptLevel = deptLevel;
	}
    
    
    

    
    
}