package com.h3c.platform.common.entity;

public class BudgetEntity {

	private Integer id;

	private String deptCode;

	private String deptName;

	private String daoHuo;

	private String zaiTu;

	private String budget;

	private byte isAble;

	private Integer sortOrder;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDeptCode() {
		return this.deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	public String getDeptName() {
		return this.deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDaoHuo() {
		return this.daoHuo;
	}

	public void setDaoHuo(String daoHuo) {
		this.daoHuo = daoHuo;
	}

	public String getZaiTu() {
		return this.zaiTu;
	}

	public void setZaiTu(String zaiTu) {
		this.zaiTu = zaiTu;
	}

	public String getBudget() {
		return this.budget;
	}

	public void setBudget(String budget) {
		this.budget = budget;
	}

	public Byte getIsAble() {
		return this.isAble;
	}

	public void setIsAble(Byte isAble) {
		this.isAble = isAble;
	}

	public Integer getSortOrder() {
		return this.sortOrder;
	}

	public void setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
	}
}
