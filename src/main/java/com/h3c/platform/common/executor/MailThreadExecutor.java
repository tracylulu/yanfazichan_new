package com.h3c.platform.common.executor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

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
    @Async("mailExecutor")
    public void send(List<String> sendTo, List<String> ccTo, String subject, String content){
//        MailUtils.sendMailByCloud(eosAPILoginUrl, eosAPIAccount, eosAPIPassword, sendTo,ccTo, subject, content);
    	try {
			String token = afspTokenService.getEosToken();
			Map<String,String> headers = new HashMap<String, String>();
			headers.put("token", token);
			
			JSONObject paramJson = new JSONObject();
			paramJson.put("applicationId", applicationId);
			paramJson.put("sendTo", sendTo);
			paramJson.put("ccTo", ccTo);
			paramJson.put("subject", subject);
			paramJson.put("content", content);
			
			String result= HttpClientUtil.sendHttpPostJsonWithHeader(afspUrl + mailUrl , paramJson.toJSONString(),headers);
			
//			JSONObject jsonResult = JSONObject.parseObject(result);
//			JSONArray jsonArray =jsonResult.ge("data");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
