package com.h3c.platform.interceptor;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.h3c.platform.annotation.PassToken;
import com.h3c.platform.annotation.UserLoginToken;
import com.h3c.platform.common.config.UserCache;
import com.h3c.platform.sysmgr.entity.UserInfo;
import com.h3c.platform.sysmgr.service.UserService;
import com.h3c.platform.util.TokenUtil;

@Component
public class AuthenticationInterceptor implements HandlerInterceptor {
	private static final Logger logger = LoggerFactory.getLogger(AuthenticationInterceptor.class);
	@Value("${checkToken}")
	private String checkToken;
	
    @Autowired
    UserService userService;
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler ) throws Exception {
//    	httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
//    	httpServletResponse.setHeader("Access-Control-Allow-Credentials", "true");
//    	httpServletResponse.setHeader("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, PATCH, DELETE, OPTIONS");
//    	httpServletResponse.setHeader("Access-Control-Max-Age", "86400");
//    	httpServletResponse.setHeader("Access-Control-Allow-Headers", "Authorization");
        String token = httpServletRequest.getHeader("Authorization");// 从 http 请求头中取出 token
        // 如果不是映射到方法直接通过
        if(!(handler  instanceof HandlerMethod)){
            return true;
        }
        HandlerMethod handlerMethod=(HandlerMethod)handler;
        Method method=handlerMethod.getMethod();
        //检查是否有passtoken注释，有则跳过认证
        if (method.isAnnotationPresent(PassToken.class)) {
            PassToken passToken = method.getAnnotation(PassToken.class);
            if (passToken.required()) {
                return true;
            }
        }
        
        if (method.isAnnotationPresent(UserLoginToken.class)) {
        	 UserLoginToken userLoginToken = method.getAnnotation(UserLoginToken.class);
             if (userLoginToken.required()&&"true".equals(checkToken)) {
                 // 执行认证
                 if (token == null) {
                     throw new RuntimeException("无token，请重新登录");
                 }
                 // 验证 token
                 JWTVerifier jwtVerifier = JWT.require(TokenUtil.getJWTAlgorithm()).build();
                 try {
                     jwtVerifier.verify(token);
                 } catch (JWTVerificationException e) {
                	 //httpServletResponse.sendError(200);
                	 
                	 e.printStackTrace();
                     throw new JWTVerificationException("验证token失败，请重新登录");
                 }
                 
                 // 获取 token 中的 user id
                 String userId;
                 try {
                     userId = TokenUtil.getUser(token);
                 } catch (JWTDecodeException j) {
                	 j.printStackTrace();
                     throw new JWTVerificationException("401");
                 }
                 UserInfo user = userService.getUserByAccount(userId);
                 if (user == null) {
                	 httpServletResponse.sendError(200);
                     throw new JWTVerificationException("用户不存在，请重新登录");
                 }
                 if(!TokenUtil.checkExpireTime(token)) {
                	 httpServletResponse.sendError(200);
                	 throw new JWTVerificationException("登录已过期，请重新登录");
                 }
                 UserCache.setCurrentHandler(user.getEmpCode());
                 return true;
             }
        }
        
        
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, 
                                  HttpServletResponse httpServletResponse, 
                            Object o, ModelAndView modelAndView) throws Exception {

    }
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, 
                                          HttpServletResponse httpServletResponse, 
                                          Object o, Exception e) throws Exception {
    }
}
