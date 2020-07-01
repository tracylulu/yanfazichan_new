//package com.h3c.platform.sysmgr.filter;
//
//import java.io.IOException;
//
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.FilterConfig;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import javax.servlet.http.Cookie;
//import org.springframework.stereotype.Component;
//
//import com.h3c.platform.util.TokenUtil;
//import com.h3c.sso.entity.RequestTicket;
//import com.h3c.sso.entity.ResponseTicket;
//
//@Component
//public class SSOFilter implements Filter {
//
//	private static final Logger logger = LoggerFactory.getLogger(SSOFilter.class);
//
//	@Value("${sso.main.auth.key}")
//	private String key;
//	@Value("${sso.main.login.url}")
//	private String ssoMainLogin;
//	@Value("${sso.main.login.request.param}")
//	private String requestParam;
//	@Value("${sso.main.login.response.param}")
//	private String responseParam;
//	@Value("${sso.main.logout.url}")
//	private String ssoMainlogout;
//	@Value("${sso.main.siteid}")
//	private String siteId;
//	@Value("${sso.main.url}")
//	private String siteMainUrl;
//
//	@Override
//	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//			throws IOException, ServletException {
//
//		HttpServletRequest req = (HttpServletRequest) request;
//		HttpServletResponse rep = (HttpServletResponse) response;
//		logger.info("web过滤器执行,uri:" + req.getRequestURI() + ",url:" + req.getRequestURL());
//		String uri = req.getRequestURI();
//		if (req.getRequestURI().indexOf("/user/login") > -1 || req.getRequestURI().indexOf("/sso") > -1
//				|| req.getRequestURI().indexOf("/login") > -1 || req.getRequestURI().indexOf("/test/login") > -1
//				|| req.getRequestURI().indexOf("/swagger") > -1 || req.getRequestURI().indexOf("/api/") > -1 ) {
//			chain.doFilter(request, response);
//			return;
//		}else {
//			chain.doFilter(request, response);
//			return;
//		}
//		
////		// 检查session
////		if (req.getSession().getAttribute("UserIdentity") == null) {
////			// session中无认证信息检查请求参数中有没有SSO响应的票据
////			String responseTicket = req.getParameter(responseParam);
////			if (responseTicket != null) {
////				ResponseTicket repTicket = null;
////				try {
////					repTicket = ResponseTicket.deserialize(responseTicket, key);
////				} catch (Exception e) {
////					e.printStackTrace();
////					logger.error("sso解析票据错误", e);
////				}
////				if (repTicket != null && repTicket.getUserIdentity() != null
////						&& !"".equals(repTicket.getUserIdentity())) {
////					// 取出UserIdentity放入session
////					String userAcc = repTicket.getUserIdentity();
////					req.getSession(false).setAttribute("UserIdentity", userAcc);
////					
////					//TokenUtil.writeCookie(rep);				
////				}
////
////				String newURI = removeResponseTicketFormURI(req.getRequestURI());
////				if (uri.indexOf("/mailLogin") > -1) {
////					String mailid = uri.substring(uri.lastIndexOf("/") + 1);
////					rep.sendRedirect("/mailLogin?mailid=" + mailid);
////					return;
////				} else if (uri.indexOf("/copyLink") > -1) {
////					String param = uri.substring(uri.lastIndexOf("/") + 1);
////					rep.sendRedirect("/copyLink?param=" + param.replace("$", "/"));
////					// logger.debug(uri);
////					return;
////				} else if (uri.indexOf("/eipLogin") > -1) {
////					String eipId = uri.substring(uri.lastIndexOf("/") + 1);
////					rep.sendRedirect("/eipLogin?docuId=" + eipId);
////					return;
////				}
////
////				rep.sendRedirect(newURI);
////				return;
////			} else {
////				String requestTicket = null;
////
////				try {
////					RequestTicket ticket = RequestTicket.getInstance();
////					ticket.setSiteId(siteId);
////					if ("/mailLogin".equals(uri)) {
////						String mailid = req.getParameter("mailid");
////						ticket.setReturnUrl(siteMainUrl + "/mailLogin/" + mailid);
////					} else if ("/copyLink".equals(uri)) {
////						String param = req.getParameter("param").replace("/", "$");
////						ticket.setReturnUrl(siteMainUrl + "/copyLink/" + param);
////						logger.debug(uri);
////					} else if ("/eipLogin".equals(uri)) {
////						String eipId = req.getParameter("docuId");
////						ticket.setReturnUrl(siteMainUrl + "/eipLogin/" + eipId);
////					} else {
////						ticket.setReturnUrl(siteMainUrl);
////					}
////
////					/*
////					 * if("/eipLogin".equals(uri)){ String eipId = req.getParameter("docuId");
////					 * ticket.setReturnUrl(siteMainUrl+"/eipLogin/"+eipId); }else{
////					 * ticket.setReturnUrl(siteMainUrl); }
////					 */
////
////					requestTicket = ticket.serialize(key);
////					rep.sendRedirect(ssoMainLogin + "?" + requestParam + "=" + requestTicket);
////				} catch (Exception e) {
////					e.printStackTrace();
////					logger.error("sso序列化失败", e);
////				}
////
////			}
////		} else {
////			chain.doFilter(request, response);
////			return;
////		}
//	
//	}
//
//	/**
//	 * 去除URL中的responseticket防止登出后退浏览器重新解析到上次的认证信息存入session导致子站点脱离SSO登出状态独立
//	 */
//	private String removeResponseTicketFormURI(String uri) {
//		int length = uri.length();
//		int begin = uri.indexOf(responseParam);
//		int end = uri.indexOf("&", begin);
//		if (begin < 0) {
//			return uri;
//		} else {
//			if (end < 0) {
//				if (uri.charAt(begin - 1) != '?') {
//					return uri.substring(0, begin - 1);
//				} else {
//					return uri.substring(0, begin - 1);
//				}
//			} else {
//				if (uri.charAt(begin - 1) != '?') {
//					String part1 = uri.substring(0, begin - 1);
//					String part2 = uri.substring(end, length);
//					return part1 + part2;
//				} else {
//					String part1 = uri.substring(0, begin);
//					String part2 = uri.substring(end + 1, length);
//					return part1 + part2;
//				}
//			}
//		}
//	}
//
//	@Override
//	public void destroy() {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void init(FilterConfig arg0) throws ServletException {
//		// TODO Auto-generated method stub
//
//	}
//
//}
