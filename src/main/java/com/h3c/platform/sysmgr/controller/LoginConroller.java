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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.h3c.platform.annotation.PassToken;
import com.h3c.platform.annotation.UserLoginToken;
import com.h3c.platform.common.commonconst.LogType;
import com.h3c.platform.common.service.MailInfoService;
import com.h3c.platform.common.util.HttpClientUtil;
import com.h3c.platform.response.ResponseResult;
import com.h3c.platform.sysmgr.entity.UserInfo;
import com.h3c.platform.sysmgr.service.UserService;
import com.h3c.platform.util.TokenUtil;
import com.h3c.sso.entity.ResponseTicket;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RequestMapping("/")
@RestController
@Api(value="免密登录",tags="免密登录")
public class LoginConroller {

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
	@Value("${onlySsoLogin}")
    private String onlySsoLogin;

	private static final Logger logger = LoggerFactory.getLogger(LoginConroller.class);
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private MailInfoService  mailInfoService;

	/*
	 * 登录sso
	 * 
	 * @param responseTicket
	 * 
	 * @return
	 */
	@PassToken(logType=LogType.LOGIN)
	@ApiOperation(value = "UI登录", notes = "UI登录")
	@GetMapping(value = "/login")
	@ApiImplicitParams({ @ApiImplicitParam(name = "userCode", value = "用户域账号") })
	@ResponseBody
	public ResponseResult Login(String userCode, HttpServletRequest request) {
		if(!"close".equals(onlySsoLogin)) throw new RuntimeException("非法请求");
		if (StringUtils.isNotBlank(userCode)) {
			ResponseTicket repTicket = null;
			try {

				//校验系统用户存不存在
				UserInfo user = userService.getUserByAccount(userCode);
				if(user==null) {
					return ResponseResult.fail("用户不存在！");
				}

				// 添加登录日志
				// loginLogService.create(userCode, IPUtils.getIpAddr(request));
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
				String loginUrl = ssoMainLogin ;

				return ResponseResult.success(loginUrl);

			} catch (Exception e) {
				e.printStackTrace();
				logger.error("sso序列化失败", e);
				return ResponseResult.fail("登录失败");
			}

		}
	}
}
