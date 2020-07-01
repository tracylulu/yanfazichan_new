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
///**
// * 解决session失效后ajax请求不能跨域重新验证问题的过滤器
// */
//public class FirstFilter implements Filter {
//
//	@Override
//	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//			throws IOException, ServletException {
//		HttpServletRequest req = (HttpServletRequest) request;
//		HttpServletResponse rep = (HttpServletResponse) response;
//		// 如果请求为根路径或sso不处理交由下游过滤器处理
//		if ("/".equals(req.getRequestURI()) || req.getRequestURI().indexOf("/sso") > -1
//				|| req.getRequestURI().indexOf("/login") > -1 || req.getRequestURI().indexOf("/test/login") > -1
//				|| req.getRequestURI().indexOf("/mailLogin") > -1 || req.getRequestURI().indexOf("/copyLink") > -1
//				|| req.getRequestURI().indexOf("/eipLogin") > -1
//				|| req.getRequestURI().indexOf("/api/") > -1) {
//			chain.doFilter(request, response);
//			return;
//		} else {
//			// 如果session为空，重定向的sso页面把复杂请求转为简单请求进行跨域请求
//			if (req.getSession().getAttribute("UserIdentity") == null) {
//
//				rep.sendRedirect("/");
//			} else {
//				chain.doFilter(request, response);
//			}
//
//		}
//	}
//
//	@Override
//	public void init(FilterConfig filterConfig) throws ServletException {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void destroy() {
//		// TODO Auto-generated method stub
//
//	}
//
//}
