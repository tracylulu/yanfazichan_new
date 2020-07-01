package com.h3c.platform.sysmgr.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.h3c.platform.annotation.PassToken;
import com.h3c.platform.common.commonconst.LogType;
import com.h3c.platform.response.ResponseResult;
import com.h3c.platform.sysmgr.entity.UserInfo;
import com.h3c.platform.sysmgr.service.UserService;
import com.h3c.platform.util.TokenUtil;
import com.h3c.sso.entity.RequestTicket;
import com.h3c.sso.entity.ResponseTicket;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RequestMapping("/")
@RestController
@Api(value="SSO登录相关",tags="SSO登录相关")
public class SSOLoginController {

	@Value("${sso.main.logout.url}")
	private String ssoMainLogout;
	@Value("${sso.main.auth.key}")
	private String key;
	@Value("${sso.main.login.url}")
	private String ssoMainLogin;
	@Value("${sso.main.login.request.param}")
	private String requestParam;
	@Value("${sso.main.login.response.param}")
	private String responseParam;
	@Value("${sso.main.logout.url}")
	private String ssoMainlogout;
	@Value("${sso.main.siteid}")
	private String siteId;
	@Value("${sso.main.url}")
	private String siteMainUrl;

	private static final Logger logger = LoggerFactory.getLogger(SSOLoginController.class);
	

	@Autowired
	private UserService userService;

	/*
	 * 登录sso
	 * 
	 * @param responseTicket
	 * 
	 * @return
	 */
	@PassToken(logType=LogType.LOGIN)
	@ApiOperation(value = "UI登录", notes = "UI登录")
	@PostMapping(value = "/ssoLogin")
	@ResponseBody
	public ResponseResult ssoLogin(@RequestBody JSONObject obj, HttpServletRequest request) {

		String data = obj.toJSONString();
		// 解析json数据
		JSONObject json = JSON.parseObject(data);
		String responseTicket = json.getString("responseTicket");
		String url = json.getString("url");

		if (StringUtils.isNotBlank(responseTicket)) {
			ResponseTicket repTicket = null;
			try {
				repTicket = ResponseTicket.deserialize(responseTicket, key);
				logger.info("repTicket ====" + repTicket);
				logger.info("repTicket ====" + repTicket.getUserIdentity());
				String userCode = repTicket.getUserIdentity();
				logger.info(repTicket.getExpireTime().toString());
				//校验系统用户存不存在
				UserInfo user = userService.getUserByAccount(userCode);
				if(user==null) {
					return ResponseResult.fail("用户不存在！");
				}

				logger.info(TokenUtil.createToken(userCode)); 
				Map<String,String> map= new HashMap<String, String>();
				map.put("token", TokenUtil.createToken(userCode));
				map.put("code", user.getEmpCode());
				map.put("domainAccount", user.getDomainAccount());
				map.put("name", user.getEmpName());
				return ResponseResult.success(map);
			} catch (Exception e) {
				e.printStackTrace();
				logger.error("sso解析票据错误", e);
				return ResponseResult.fail("登录失败");
			}

		} else {
			String requestTicket = null;

			try {
				RequestTicket ticket = RequestTicket.getInstance();
				ticket.setSiteId(siteId);
				ticket.setReturnUrl(url);
				requestTicket = ticket.serialize(key);
				String loginUrl = ssoMainLogin + "?" + requestParam + "=" + requestTicket;

				return ResponseResult.success(loginUrl);

			} catch (Exception e) {
				e.printStackTrace();
				logger.error("sso序列化失败", e);
				return ResponseResult.fail("登录失败");
			}

		}
	}
	
	/**
	 * 登出之后重定向返回登录URL
	 * @return
	 */
	@PassToken(logType=LogType.LOGOUT)
	@ApiOperation(value = "UI登出", notes = "UI登出")
	@PostMapping(value = "/ssoLoginOut")
	public ResponseResult ssoLoginOut(@RequestBody JSONObject obj) {
		String requestTicket = null;
		String data = obj.toJSONString();
		// 解析json数据
		JSONObject json = JSON.parseObject(data);	
		String url = json.getString("url");

		try {
			RequestTicket ticket = RequestTicket.getInstance();
			ticket.setSiteId(siteId);
			ticket.setReturnUrl(url);
			requestTicket = ticket.serialize(key);			

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("sso序列化失败", e);
			return ResponseResult.fail("登录失败");
		}
		String loginUrl = ssoMainLogin + "?" + requestParam + "=" + requestTicket;
		
		String loginOutUrl = ssoMainLogout+"?siteId="+siteId+"&RequestUrl="+loginUrl;
		return ResponseResult.success(loginOutUrl);
	}

}
