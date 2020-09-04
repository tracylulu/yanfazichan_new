package com.h3c.platform.common.entity;

public class CategoryEntity {
	private Integer id;

	private String dicCode;

	private String certifier;

	private String name;

	private String category;

	private Integer deliveryTime;
	
	private String expenseType;

	private byte isAble;

	private Integer sortOrder;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDicCode() {
		return this.dicCode;
	}

	public void setDicCode(String dicCode) {
		this.dicCode = dicCode;
	}

	public String getCertifier() {
		return this.certifier;
	}

	public void setCertifier(String certifier) {
		this.certifier = certifier;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Integer getDeliveryTime() {
		return this.deliveryTime;
	}

	public void setDeliveryTime(Integer deliveryTime) {
		this.deliveryTime = deliveryTime;
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

	public String getExpenseType() {
		return expenseType;
	}

	public void setExpenseType(String expenseType) {
		this.expenseType = expenseType;
	}
	
}
