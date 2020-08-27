package com.h3c.platform.sysmgr.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.h3c.platform.common.service.AfspTokenService;
import com.h3c.platform.common.util.HttpClientUtil;
import com.h3c.platform.common.util.ObjToStrUtil;
import com.h3c.platform.response.ResponseResult;
import com.h3c.platform.sysmgr.entity.UserInfo;
import com.h3c.platform.sysmgr.service.RoleService;
import com.h3c.platform.sysmgr.service.UserService;
import com.h3c.platform.util.UserUtils;

@Service
public class RoleServiceImpl implements RoleService {

	@Value("${afsp.dic.url}")
	private String eosUrl;
	@Value("${afsp.applicationId}")
	private String  applicationId;
	@Value("${afsp.dic.url.userRole}")
	private String url_UserRole;
	@Autowired
	private AfspTokenService  afspTokenService;
	@Autowired
	private UserService userService;
	
	@Override
	public ResponseResult getRoleByUser(String userId) throws Exception{
		UserInfo user= userService.getUserByEmpCode(userId);
		//JSONObject json = new JSONObject();
		
		String token=afspTokenService.getEosToken();
		
		Map<String,String> headers = new HashMap<>();
		headers.put("token", token);
		String params="{\"applicationId\":\""+applicationId+"\",\"userCode\":\""+(user!=null?user.getDomainAccount():"")+"\"}";	
		String result= HttpClientUtil.sendHttpPostJsonWithHeader(eosUrl+url_UserRole, params,headers);
		
		JSONObject jsonResult = JSON.parseObject(result);
		JSONArray jsonArray =jsonResult.getJSONArray("data");
		
    	return ResponseResult.success(jsonArray);
	}
	
	@Override
	public boolean checkIsAdmin() throws Exception{
		boolean isAdmin=false;
		//JSONObject json = new JSONObject();
		
		String token=afspTokenService.getEosToken();
		
		Map<String,String> headers = new HashMap<>();
		headers.put("token", token);
		String params="{\"applicationId\":\""+applicationId+"\",\"userCode\":\""+(UserUtils.getCurrentDominAccount())+"\"}";	
		String result= HttpClientUtil.sendHttpPostJsonWithHeader(eosUrl+url_UserRole, params,headers);
		
		JSONObject jsonResult = JSON.parseObject(result);
		if(jsonResult.getBoolean("flag")) {
			JSONArray jsonArray =jsonResult.getJSONArray("data");
			
			for(int i=0;i<jsonArray.size();i++) {
				if("R_000002".equals(ObjToStrUtil.replaceNullValue(jsonArray.getString(i)))) {
					isAdmin=true;
					break;
				}
			}
		}
		
		return isAdmin;
	}
	
	@Override
	public boolean checkIsAdmin(String userCode) throws Exception{
		boolean isAdmin=false;
		//JSONObject json = new JSONObject();
		
		UserInfo user=userService.getUserByEmpCode(userCode);
		
		String token=afspTokenService.getEosToken();
		
		Map<String,String> headers = new HashMap<>();
		headers.put("token", token);
		String params="{\"applicationId\":\""+applicationId+"\",\"userCode\":\""+(user!=null?user.getDomainAccount():"")+"\"}";	
		String result= HttpClientUtil.sendHttpPostJsonWithHeader(eosUrl+url_UserRole, params,headers);
		
		JSONObject jsonResult = JSON.parseObject(result);
		if(jsonResult.getBoolean("flag")) {
			JSONArray jsonArray =jsonResult.getJSONArray("data");
			
			for(int i=0;i<jsonArray.size();i++) {
				if("R_000002".equals(ObjToStrUtil.replaceNullValue(jsonArray.getString(i)))) {
					isAdmin=true;
					break;
				}
			}
		}
		
		return isAdmin;
	}
}
