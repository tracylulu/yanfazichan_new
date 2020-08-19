package com.h3c.platform.common.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.h3c.platform.common.service.AfspTokenService;
import com.h3c.platform.common.util.HttpClientUtil;

@Service
public class AfspTokenServiceImpl implements AfspTokenService{

	@Value("${afsp.dic.url}")
	private String eosUrl;
	@Value("${afsp.applicationId}")
	private String  applicationId;
	@Value("${afsp.dic.url.token}")
	private String urlToken;
	@Value("${afsp.password}")
	private String password;
	
	public  String getEosToken() throws Exception{
    	String params="{\"account\":\""+applicationId+"\",\"password\":\""+password+"\"}";			
		String result= HttpClientUtil.sendHttpPostJson(eosUrl+urlToken, params);
		
		//JSONObject json = new JSONObject();
		JSONObject jsonResult = JSON.parseObject(result);
		if(!jsonResult.getBoolean("flag")) {
			throw new Exception(jsonResult.getString("message"));
		}		
    	return jsonResult.getJSONObject("data").get("token").toString();
    }
}
