package com.h3c.platform.task.config;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.PersistJobDataAfterExecution;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.h3c.platform.common.util.SpringContextUtils;
import com.h3c.platform.assetplan.service.DeptInfoService;
import com.h3c.platform.common.commonconst.LogType;
import com.h3c.platform.common.util.HttpClientUtil;
import com.h3c.platform.sync.entity.ApiUrl;
import com.h3c.platform.sync.service.DeptInfoEosService;
import com.h3c.platform.sync.service.EosApiUrlService;
import com.h3c.platform.sysmgr.entity.OperationLog;
import com.h3c.platform.sysmgr.service.OperationLogService;
import com.h3c.platform.util.UserUtils;


/**
 * 从中台同步 部门组织架构数据
 *
 */
@PersistJobDataAfterExecution//持久化
@DisallowConcurrentExecution//禁止并发执行(Quartz不要并发地执行同一个job定义（这里指一个job类的多个实例）)
public class DeptInfoQuartzJobBean  extends QuartzJobBean{	
	
	
	
	
	private Logger logger = LoggerFactory.getLogger(DeptInfoQuartzJobBean.class);
	
	@Override
	protected void executeInternal(JobExecutionContext context)
			throws JobExecutionException {
		DeptInfoEosService deptInfoEosService = (DeptInfoEosService) SpringContextUtils.getBean(DeptInfoEosService.class);	
		EosApiUrlService eosApiUrlService = (EosApiUrlService) SpringContextUtils.getBean(EosApiUrlService.class);	
		DeptInfoService deptInfoService = (DeptInfoService) SpringContextUtils.getBean(DeptInfoService.class);	
		ApiUrl apiUrl=eosApiUrlService.getEosUrl();
		logger.info("DeptQuartzJobBean job start");
		String deptData =null;
		try {
			deptData = HttpClientUtil.getDataPost(apiUrl.getLoginUrl(),apiUrl.getAccount(),apiUrl.getPassword(), apiUrl.getDeptUrl());
			if(deptData!=null && deptData.length()!=0) {
				JSONObject result=JSONObject.fromObject(deptData);
				int code = Integer.parseInt(result.get("code").toString());
				
				if(code==20216) {
			        List<Map<String, Object>> deptDataList = (List) result.getJSONArray("data");
					try {
						deptInfoEosService.syncDeptInfoEos(deptDataList);		
						deptInfoService.syncByEosData();					
					} catch (Exception e) {				
						e.printStackTrace();
					}
				}
				else {
					logger.info("接口："+apiUrl.getDeptUrl()+"连接失败");
				}
			}
			else {
				logger.info("接口：:"+apiUrl.getDeptUrl()+"异常，无数据");	
			}
		} catch (Exception e) {
			OperationLogService operationLogService=(OperationLogService)SpringContextUtils.getBean(OperationLogService.class);;
			OperationLog log=new OperationLog();
			log.setModelcode("com.h3c.platform.task.config.DeptInfoQuartzJobBean");
			log.setModelname("部门定时任务");
			log.setSummary("");
			log.setContent(ExceptionUtils.getFullStackTrace(e));
			log.setUserid(UserUtils.getCurrentUserId());
			log.setLogtype(LogType.Task);
			try {
				log.setIp("service:"+InetAddress.getLocalHost().getHostAddress());
			} catch (UnknownHostException ex) {
				e.printStackTrace();
			}
				
			operationLogService.saveLog(log);
			e.printStackTrace();
		}

		logger.info("DeptQuartzJobBean job end");
		
	}

}
