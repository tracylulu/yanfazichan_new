package com.h3c.platform.sysmgr.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.h3c.platform.common.service.AfspTokenService;
import com.h3c.platform.common.util.HttpClientUtil;
import com.h3c.platform.response.ResponseResult;
import com.h3c.platform.sysmgr.entity.UserInfo;
import com.h3c.platform.sysmgr.service.ResourceService;
import com.h3c.platform.sysmgr.service.UserService;
import com.h3c.platform.util.UserUtils;

@Service
public class ResourceServiceImpl implements ResourceService {
	
	@Value("${afsp.dic.url}")
	private String eosUrl;
	@Value("${afsp.applicationId}")
	private String  applicationId;
	@Value("${afsp.dic.url.resource}")
	private String url_Resource;

	@Autowired
	private AfspTokenService  afspTokenService;
	@Autowired
	private UserService userService;
	
	@Override
	public ResponseResult getCurrentResourceTree() throws Exception{
		UserInfo user= userService.getUserByEmpCode(UserUtils.getCurrentUserId());
		//JSONObject json = new JSONObject();
		
		String token=afspTokenService.getEosToken();
		
		Map<String,String> headers = new HashMap<String, String>();
		headers.put("token", token);
		String params="{\"applicationId\":\""+applicationId+"\",\"userId\":\""+(user!=null?user.getDomainAccount():"")+"\"}";	
		String result= HttpClientUtil.sendHttpPostJsonWithHeader(eosUrl+url_Resource, params,headers);
		
		JSONObject jsonResult = JSON.parseObject(result);
		JSONArray jsonArray =jsonResult.getJSONArray("data");
		
    	return ResponseResult.success(jsonArray);
	}

}
