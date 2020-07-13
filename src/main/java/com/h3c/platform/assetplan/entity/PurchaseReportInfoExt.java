package com.h3c.platform.assetplan.entity;

import java.util.Date;

public class PurchaseReportInfoExt extends PurchaseReportInfo {
	private int order;

    private String name;

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
    	this.name = name;
    }
}