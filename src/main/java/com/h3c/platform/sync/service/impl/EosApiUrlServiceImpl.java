package com.h3c.platform.sync.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.h3c.platform.sync.entity.ApiUrl;
import com.h3c.platform.sync.service.EosApiUrlService;

@Service
public class EosApiUrlServiceImpl implements EosApiUrlService {
	@Value("${eos.url.login}")
	private String eosAPI_loginUrl;	
	@Value("${eos.url.dept}")
	private String deptAPI_httpUrl;
	@Value("${eos.url.user}")
	private String userAPI_httpUrl;
	@Value("${eos.url.project}")
	private String projectAPI_httpUrl;
	@Value("${eos.account}")
	private String eosAPI_account;	
	@Value("${eos.password}")
	private String eosAPI_password;
	@Value("${eos.account.pdt}")
	private String eosAPI_account_pdt;
	@Value("${eos.password.pdt}")
	private String eosAPI_password_pdt;
	
	@Override
	public ApiUrl getEosUrl() {
		ApiUrl apiUrl=new ApiUrl();
		apiUrl.setAccount(eosAPI_account);
		apiUrl.setPassword(eosAPI_password);
		apiUrl.setLoginUrl(eosAPI_loginUrl);
		apiUrl.setDeptUrl(deptAPI_httpUrl);
		apiUrl.setProjectUrl(projectAPI_httpUrl);
		apiUrl.setUserUrl(userAPI_httpUrl);
		apiUrl.setAccountPdt(eosAPI_account_pdt);
		apiUrl.setPasswordPdt(eosAPI_password_pdt);
		
		return apiUrl;
	}
}
