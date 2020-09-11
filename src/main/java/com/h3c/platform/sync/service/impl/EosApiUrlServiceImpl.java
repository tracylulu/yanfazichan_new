package com.h3c.platform.sync.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.h3c.platform.sync.entity.ApiUrl;
import com.h3c.platform.sync.service.EosApiUrlService;

@Service
public class EosApiUrlServiceImpl implements EosApiUrlService {
	@Value("${eos.url.login}")
	private String eosApiLoginUrl;	
	@Value("${eos.url.dept}")
	private String deptApiHttpUrl;
	@Value("${eos.url.user}")
	private String userApiHttpUrl;
	@Value("${eos.url.project}")
	private String projectApiHttpUrl;
	@Value("${eos.account}")
	private String eosApiAccount;	
	@Value("${eos.password}")
	private String eosApiPassword;
	@Value("${eos.account.pdt}")
	private String eosApiAccountPdt;
	@Value("${eos.password.pdt}")
	private String eosApiPasswordPdt;
	
	@Value("${spring.remindEmailForBudget.url}")
    private String EmailForBudget;
	
	@Value("${spring.remindEmailForPlan.url}")
    private String EmailForPlan;
	
	@Override
	public ApiUrl getEosUrl() {
		ApiUrl apiUrl=new ApiUrl();
		apiUrl.setAccount(eosApiAccount);
		apiUrl.setPassword(eosApiPassword);
		apiUrl.setLoginUrl(eosApiLoginUrl);
		apiUrl.setDeptUrl(deptApiHttpUrl);
		apiUrl.setProjectUrl(projectApiHttpUrl);
		apiUrl.setUserUrl(userApiHttpUrl);
		apiUrl.setAccountPdt(eosApiAccountPdt);
		apiUrl.setPasswordPdt(eosApiPasswordPdt);
		
		return apiUrl;
	}

	@Override
	public String getbugdetUrl() {
		return EmailForBudget;
	}

	@Override
	public String getPlanRemindUrl() {
		return EmailForPlan;
	}
}
