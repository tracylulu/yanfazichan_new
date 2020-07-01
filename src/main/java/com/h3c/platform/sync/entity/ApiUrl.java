package com.h3c.platform.sync.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties
public class ApiUrl {
	private String loginUrl;	
	
	private String deptUrl;	
	
	private String projectUrl;
	
	private String userUrl;	
	
	private String account;	
	
	private String password;
	
	private String accountPdt;	
	
	private String passwordPdt;
	
	public String getLoginUrl() {
        return loginUrl;
    }

    public void setLoginUrl(String loginUrl) {
        this.loginUrl = loginUrl == null ? null : loginUrl.trim();
    }
    
    public String getDeptUrl() {
        return deptUrl;
    }

    public void setDeptUrl(String deptUrl) {
        this.deptUrl = deptUrl == null ? null : deptUrl.trim();
    }
    
    public String getProjectUrl() {
        return projectUrl;
    }

    public void setProjectUrl(String projectUrl) {
        this.projectUrl = projectUrl == null ? null : projectUrl.trim();
    }
    
    public String getUserUrl() {
        return userUrl;
    }

    public void setUserUrl(String userUrl) {
        this.userUrl = userUrl == null ? null : userUrl.trim();
    }
    
    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }
    
    
    public String getAccountPdt() {
        return accountPdt;
    }

    public void setAccountPdt(String accountPdt) {
        this.accountPdt = accountPdt == null ? null : accountPdt.trim();
    }

    public String getPasswordpdt() {
        return passwordPdt;
    }

    public void setPasswordPdt(String passwordPdt) {
        this.passwordPdt = passwordPdt == null ? null : passwordPdt.trim();
    }
}
