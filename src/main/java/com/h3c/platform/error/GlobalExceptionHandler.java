package com.h3c.platform.error;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.ErrorProperties.IncludeStacktrace;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.WebRequest;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.h3c.platform.common.commonconst.LogType;
import com.h3c.platform.common.util.IPUtils;
import com.h3c.platform.common.util.ObjToStrUtil;
import com.h3c.platform.response.ResponseResult;
import com.h3c.platform.sysmgr.entity.OperationLog;
import com.h3c.platform.sysmgr.service.OperationLogService;
import com.h3c.platform.util.UserUtils;
import com.h3c.sso.entity.RequestTicket;

@ControllerAdvice
@ResponseBody
@CrossOrigin(origins = "*", maxAge = 3600, allowedHeaders = "*")
@Controller
public class GlobalExceptionHandler implements ErrorController {

	//private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

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
	private OperationLogService operationLogService;
	@Autowired
	private ErrorAttributes errorAttributes;

	private static final String ERROR_PATH = "/error";

	@Override
	public String getErrorPath() {
		return ERROR_PATH;
	}

	/**
	 * JSON格式错误信息
	 */
	@RequestMapping(value = ERROR_PATH, produces = { MediaType.APPLICATION_JSON_VALUE })
	
	// @ExceptionHandler(JWTVerificationException.class)
	public ResponseResult error(HttpServletRequest request, WebRequest webRequest) {
		
		//RequestAttributes requestAttributes = new ServletRequestAttributes(request);
		Map<String, Object> body = this.errorAttributes.getErrorAttributes(webRequest, true);
		//int status = getStatus(request);
		String errMsg = ObjToStrUtil.replaceNullValue(body.get("message"));
		if (StringUtils.isNotBlank(errMsg) && errMsg.contains("登录")) {
			String requestTicket = null;
			String url = request.getRequestURL().toString();
			OperationLog log = new OperationLog();
			log.setModelcode("com.h3c.platform.interceptor.preHandle");
			log.setModelname("拦截器");
			log.setSummary(url);
			log.setContent(errMsg);
			// log.setUserid(UserUtils.getCurrentUserId());
			log.setLogtype(LogType.LOGIN);
			try {
				log.setIp(
						"IP:" + IPUtils.getIpAddr(request) + ";service:" + InetAddress.getLocalHost().getHostAddress());
			} catch (UnknownHostException e) {
				e.printStackTrace();
			}
			operationLogService.saveLog(log);
			try {
				RequestTicket ticket = RequestTicket.getInstance();
				ticket.setSiteId(siteId);
				ticket.setReturnUrl(siteMainUrl);
				requestTicket = ticket.serialize(key);
				String loginUrl = ssoMainLogin + "?" + requestParam + "=" + requestTicket;
				return ResponseResult.loginOut(loginUrl);
			} catch (Exception e) {
				return ResponseResult.fail(e.getMessage());
			}
		}
		return ResponseResult.fail(errMsg);

	}

	/*private static int getStatus(HttpServletRequest request) {
		Integer status = (Integer) request.getAttribute("javax.servlet.error.status_code");
		if (status != null) {
			return status;
		}

		return 500;
	}*/

//	/**
//	 * 拦截Exception类的异常
//	 *
//	 * @param e
//	 * @return
//	 */
//	@ExceptionHandler(Exception.class)
//	public ResponseResult exceptionHandler(HttpServletRequest req, Exception ex) {
//		ex.printStackTrace();
//		if (StringUtils.isNotBlank(ex.getMessage()) && ex.getMessage().contains("登录")) {
//			String requestTicket = null;
//			String url = req.getRequestURL().toString();
//			try {
//				RequestTicket ticket = RequestTicket.getInstance();
//				ticket.setSiteId(siteId);
//				ticket.setReturnUrl(siteMainUrl);
//				requestTicket = ticket.serialize(key);
//				String loginUrl = ssoMainLogin + "?" + requestParam + "=" + requestTicket;
//				return ResponseResult.success(loginUrl);
//			} catch (Exception e) {
//				return ResponseResult.fail(e.getMessage());
//			}
//		}
//		return ResponseResult.fail("操作失败");
//	}
//
//	@ExceptionHandler(RuntimeException.class)
//	public ResponseResult exceptionHandler(HttpServletRequest req, RuntimeException ex) {
//		ex.printStackTrace();
//		// 判断是否包含登录错误
//		if (StringUtils.isNotBlank(ex.getMessage()) && ex.getMessage().contains("登录")) {
//			String requestTicket = null;
//			String url = req.getRequestURL().toString();
//			OperationLog log = new OperationLog();
//			log.setModelcode("com.h3c.platform.interceptor.preHandle");
//			log.setModelname("拦截器");
//			log.setSummary(url);
//			log.setContent(ex.getMessage());
//			// log.setUserid(UserUtils.getCurrentUserId());
//			log.setLogtype(LogType.LOGIN);
//			try {
//				log.setIp("IP:" + IPUtils.getIpAddr(req) + ";service:" + InetAddress.getLocalHost().getHostAddress());
//			} catch (UnknownHostException e) {
//				e.printStackTrace();
//			}
//			operationLogService.saveLog(log);
//			try {
//				RequestTicket ticket = RequestTicket.getInstance();
//				ticket.setSiteId(siteId);
//				ticket.setReturnUrl(siteMainUrl);
//				requestTicket = ticket.serialize(key);
//				String loginUrl = ssoMainLogin + "?" + requestParam + "=" + requestTicket;
//				return ResponseResult.loginOut(loginUrl);
//			} catch (Exception e) {
//				return ResponseResult.fail(e.getMessage());
//			}
//		}
//		return ResponseResult.fail(ex.getMessage());
//	}
//
//	@ExceptionHandler(JWTVerificationException.class)
//	public ResponseResult exceptionHandler1(HttpServletRequest req, RuntimeException ex) {
//		String requestTicket = null;
//		String url = req.getRequestURL().toString();
//		OperationLog log = new OperationLog();
//		log.setModelcode("com.h3c.platform.interceptor.preHandle");
//		log.setModelname("拦截器");
//		log.setSummary(url);
//		log.setContent(ex.getMessage());
//		log.setLogtype(LogType.LOGIN);
//		try {
//			log.setIp("IP:" + IPUtils.getIpAddr(req) + ";service:" + InetAddress.getLocalHost().getHostAddress());
//		} catch (UnknownHostException e) {
//			e.printStackTrace();
//		}
//		operationLogService.saveLog(log);
//		try {
//			RequestTicket ticket = RequestTicket.getInstance();
//			ticket.setSiteId(siteId);
//			ticket.setReturnUrl(siteMainUrl);
//			requestTicket = ticket.serialize(key);
//			String loginUrl = ssoMainLogin + "?" + requestParam + "=" + requestTicket;
//			return ResponseResult.loginOut(loginUrl);
//		} catch (Exception e) {
//			return ResponseResult.fail(ex.getMessage());
//		}
//	}
}
