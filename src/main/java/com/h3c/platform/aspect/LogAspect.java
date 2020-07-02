package com.h3c.platform.aspect;

import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.exception.ExceptionUtils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.h3c.platform.annotation.PassToken;
import com.h3c.platform.annotation.UserLoginToken;
import com.h3c.platform.common.commonconst.LogType;
import com.h3c.platform.common.util.IPUtils;
import com.h3c.platform.sysmgr.entity.OperationLog;
import com.h3c.platform.sysmgr.service.OperationLogService;
import com.h3c.platform.util.UserUtils;

import io.swagger.annotations.ApiOperation;


@Aspect
@Component
public class LogAspect {
	
	private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);
	
	@Autowired
	private  OperationLogService operationLogService;
	
	
	@Pointcut("execution(public * com.h3c.platform.*.controller..*.*(..))")
	public void operationLog() {}

	
	@AfterThrowing(pointcut = "operationLog() ", throwing = "e")  
	public  void doAfterThrowing(JoinPoint joinPoint, Throwable e) {  
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		String modelname="";
		String url=request.getRequestURL().toString();    
		String content= ExceptionUtils.getFullStackTrace(e);
		//方法名
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		String methodName = signature.getName(); 
		Method method=signature.getMethod();
		if (method.isAnnotationPresent(ApiOperation.class)) {
			ApiOperation apiOperation=method.getAnnotation(ApiOperation.class);
			modelname = apiOperation.value();
		}		
		
		Object target = joinPoint.getTarget();
		String className = target.getClass().getName(); 
		
		saveLog(className+"."+methodName, modelname,url , content, IPUtils.getIpAddr(request), LogType.ERROR);
	}	
    
	@AfterReturning("operationLog()")	
	public void doAfterReturn(JoinPoint joinPoint) throws Throwable {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		String modelname="";
		String url=request.getRequestURL().toString();
		int logType=0;
		//方法名
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		String methodName = signature.getName(); 
		Method method=signature.getMethod();
		if (method.isAnnotationPresent(ApiOperation.class)) {
			ApiOperation apiOperation=method.getAnnotation(ApiOperation.class);
			modelname = apiOperation.value();
		}	
		if(method.isAnnotationPresent(UserLoginToken.class)) {
			UserLoginToken userLoginToken = method.getAnnotation(UserLoginToken.class);
			logType = userLoginToken.logType();
		}
		if(method.isAnnotationPresent(PassToken.class)) {
			PassToken passToken = method.getAnnotation(PassToken.class);
			logType = passToken.logType(); 
		}
		Object target = joinPoint.getTarget();
		String className = target.getClass().getName(); 
		
		saveLog(className+"."+methodName, modelname, url , modelname, IPUtils.getIpAddr(request),logType);
	}
	
	/**
	 * 
	 * @param modelCode 方法名
	 * @param modelName 名称
	 * @param url 访问url
	 * @param content 内容or 错误信息
	 * @param IPs
	 * @param type 类型 
	 */
	private void saveLog(String modelCode,String modelName,String url,String content,String IPs, Integer type) {
		OperationLog log=new OperationLog();
		log.setModelcode(modelCode);
		log.setModelname(modelName);
		log.setSummary(url);
		log.setContent(content);
		log.setUserid(UserUtils.getCurrentUserId());
		log.setLogtype(type);
		try {
			log.setIp("IP:"+IPs+";service:"+InetAddress.getLocalHost().getHostAddress());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
			
		operationLogService.SaveLog(log);
	}
	

}
