package com.h3c.platform.common.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.h3c.platform.annotation.UserLoginToken;
import com.h3c.platform.common.entity.ProxyAPIEntity;
import com.h3c.platform.common.util.HttpClientUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/proxyapi")
@Api(value="代理API相关",tags="代理API相关")
public class ProxyAPIController {

	@UserLoginToken
	@PostMapping("/post")
	@ApiOperation("代理APIPost方法")
	public String proxyAPIPost(@RequestBody ProxyAPIEntity entity) {		
		try {
			Map<String,String> header=new HashMap<>();
			for(int i=0;i<entity.getheaderKeys().length;i++) {
				header.put(entity.getheaderKeys()[i], entity.getheaderValues()[i]);
			}
			
			if(entity.getParamsKeys()==null||entity.getParamsKeys().length==0) {
				return HttpClientUtil.sendHttpPost(entity.getUrl(),  header);
			}else {
				JSONObject param=new JSONObject();
				for(int i=0;i<entity.getParamsKeys().length;i++) {
					param.put(entity.getParamsKeys()[i], entity.getParamsValues()[i]);
				}				
				return HttpClientUtil.sendHttpPostJsonWithHeader(entity.getUrl(), param.toString(), header);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}
	
	@UserLoginToken
	@PostMapping("/get")
	@ApiOperation("代理APIGet方法，参数请拼接在url上")
	public String proxyAPIGet(@RequestBody ProxyAPIEntity entity) {		
		try {
			Map<String,String> headr=new HashMap<>();
			for(int i=0;i<entity.getheaderValues().length;i++) {
				headr.put(entity.getheaderKeys()[i], entity.getheaderValues()[i]);
			}
			return HttpClientUtil.sendHttpGet(entity.getUrl(),  headr);
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}
}
