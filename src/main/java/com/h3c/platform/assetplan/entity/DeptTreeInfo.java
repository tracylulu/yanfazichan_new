package com.h3c.platform.assetplan.entity;

import java.util.List;



public class DeptTreeInfo {
    private Integer deptCode;

    private String deptName;

    private String supDeptDode;
    
    private String deptLevel;
    
    private String typeId;

	private String deptPlannerCode;

    private String deptPlannerName;
    
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
    
    public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public String getDeptPlannerCode() {
		return deptPlannerCode;
	}

	public void setDeptPlannerCode(String deptPlannerCode) {
		this.deptPlannerCode = deptPlannerCode;
	}

	public String getDeptPlannerName() {
		return deptPlannerName;
	}

	public void setDeptPlannerName(String deptPlannerName) {
		this.deptPlannerName = deptPlannerName;
	}
    
    
    

    
    
}