package com.h3c.platform.error;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.h3c.platform.common.commonconst.LogType;
import com.h3c.platform.common.util.IPUtils;
import com.h3c.platform.response.ResponseResult;
import com.h3c.platform.sysmgr.entity.OperationLog;
import com.h3c.platform.sysmgr.service.OperationLogService;
import com.h3c.platform.util.UserUtils;
import com.h3c.sso.entity.RequestTicket;

@RestControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
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
	
	@Autowired
	private  OperationLogService operationLogService;

	/**
	 * 拦截Exception类的异常
	 *
	 * @param e
	 * @return
	 */
	@ExceptionHandler(Exception.class)
	public ResponseResult exceptionHandler(HttpServletRequest req,Exception ex) {
		ex.printStackTrace();
		if(StringUtils.isNotBlank(ex.getMessage())&& ex.getMessage().contains("登录")) {
	        	String requestTicket = null;
	        	String url=req.getRequestURL().toString();	        	
				try {
					RequestTicket ticket = RequestTicket.getInstance();
					ticket.setSiteId(siteId);
					ticket.setReturnUrl(siteMainUrl);
					requestTicket = ticket.serialize(key);
					String loginUrl = ssoMainLogin + "?" + requestParam + "=" + requestTicket;
					return ResponseResult.success(loginUrl);
				}catch(Exception e) {
					return ResponseResult.fail(e.getMessage());
				}
	        }
		return ResponseResult.fail("操作失败");
	}

	@ExceptionHandler(RuntimeException.class)
    public ResponseResult exceptionHandler(HttpServletRequest req,RuntimeException ex) {
		ex.printStackTrace();
        //判断是否包含登录错误
		if(StringUtils.isNotBlank(ex.getMessage())&& ex.getMessage().contains("登录")) {
        	String requestTicket = null;
        	String url=req.getRequestURL().toString();
        	OperationLog log=new OperationLog();
    		log.setModelcode("com.h3c.platform.interceptor.preHandle");
    		log.setModelname("拦截器");
    		log.setSummary(url);
    		log.setContent(ex.getMessage());
    		//log.setUserid(UserUtils.getCurrentUserId());
    		log.setLogtype(LogType.LOGIN);
    		try {
    			log.setIp("IP:"+IPUtils.getIpAddr(req)+";service:"+InetAddress.getLocalHost().getHostAddress());
    		} catch (UnknownHostException e) {
    			e.printStackTrace();
    		}
    		operationLogService.SaveLog(log);        	
			try {
				RequestTicket ticket = RequestTicket.getInstance();
				ticket.setSiteId(siteId);
				ticket.setReturnUrl(siteMainUrl);
				requestTicket = ticket.serialize(key);
				String loginUrl = ssoMainLogin + "?" + requestParam + "=" + requestTicket;
				return ResponseResult.loginOut(loginUrl);
			}catch(Exception e) {
				return ResponseResult.fail(e.getMessage());
			}
        }
        return ResponseResult.fail("操作失败");
    }
}
