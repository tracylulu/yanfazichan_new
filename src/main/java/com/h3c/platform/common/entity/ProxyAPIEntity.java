package com.h3c.platform.common.entity;

import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProxyAPIEntity {
	
	private String url;
	
	private String[] headerKeys;
	
	private String[] headerValues;
	
	private String[] paramsKeys;
	
	private String[] paramsValues;
	
	public String getUrl() {
		return this.url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String[] getheaderKeys() {
		return this.headerKeys;
	}
	
	public void setHeaderKeys(String[] headerKeys) {
		this.headerKeys =headerKeys;		
	}
	
	public String[] getheaderValues() {
		return this.headerValues;
	}
	
	public void setHeaderValues(String[] headerValues) {
		this.headerValues =headerValues;
	}
	
	public String[] getParamsKeys() {
		return this.paramsKeys;
	}
	
	public void setParamsKeys(String[] paramsKeys) {
		this.paramsKeys =paramsKeys;
	}
	
	public String[] getParamsValues() {
		return this.paramsKeys;
	}
	
	public void setParamsValues(String[] paramsValues) {
		this.paramsValues =paramsValues;
	}
}
