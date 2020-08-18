package com.h3c.platform.common.executor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.h3c.platform.common.service.AfspTokenService;
import com.h3c.platform.common.util.HttpClientUtil;


			
@Component
public class MailThreadExecutor {

	@Autowired
	private AfspTokenService afspTokenService;
	@Value("${afsp.dic.url}")
	private String afspUrl;
	@Value("${afsp.mail.sendMailInfo}")
	private String mailUrl;
	@Value("${afsp.applicationId}")
	private String  applicationId;
	@Value("${afsp.mail.sendMailInfoByTemplete}")
	private String mailTempleteUrl;
	
    @Async("mailExecutor")
    public void send(String templeteCode, List<String> bccTo, List<String> ccTo, List<String> sendTo, JSONObject content,  int priority, JSONArray templeteArr, JSONArray titleArr) {
//        MailUtils.sendMailByCloud(eosAPILoginUrl, eosAPIAccount, eosAPIPassword, sendTo,ccTo, subject, content);
    	try {
			String token = afspTokenService.getEosToken();
			Map<String,String> headers = new HashMap<>();
			headers.put("token", token);
			
			JSONObject paramJson = new JSONObject();
			paramJson.put("applicationId", applicationId);
			paramJson.put("sendTo", sendTo);
			paramJson.put("ccTo", ccTo);
			paramJson.put("templeteCode", templeteCode);
			paramJson.put("priority", priority);
			paramJson.put("templeteArr", templeteArr);
			paramJson.put("content", content);
			paramJson.put("titleArr", titleArr);
			
			String result= HttpClientUtil.sendHttpPostJsonWithHeader(afspUrl + mailTempleteUrl , paramJson.toString(),headers);
			//String result= HttpClientUtil.sendHttpPostJsonWithHeader("http://10.90.14.41:8080" + mailTempleteUrl , paramJson.toString(),headers);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
