package com.h3c.platform.task.config;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.PersistJobDataAfterExecution;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.transaction.annotation.Transactional;

import com.h3c.platform.assetplan.entity.AssetPlanInfo;
import com.h3c.platform.assetplan.entity.RateTotalInfo;
import com.h3c.platform.assetplan.service.AssetPlanInfoService;
import com.h3c.platform.assetplan.service.AssetRateInfoService;
import com.h3c.platform.assetplan.service.RateTotalInfoService;
import com.h3c.platform.common.commonconst.LogType;
import com.h3c.platform.common.util.SpringContextUtils;
import com.h3c.platform.sysmgr.entity.OperationLog;
import com.h3c.platform.sysmgr.service.OperationLogService;
import com.h3c.platform.util.UserUtils;

@PersistJobDataAfterExecution//持久化
@DisallowConcurrentExecution//禁止并发执行(Quartz不要并发地执行同一个job定义（这里指一个job类的多个实例）)
public class UseRateQuartzJobBean extends QuartzJobBean{
private Logger logger = LoggerFactory.getLogger(AssetPlanQuartzJobBean.class);
	
	//@Override
	protected void executeInternal(JobExecutionContext context)
			throws JobExecutionException {
		
		try {
			AssetPlanInfoService assetPlanInfoService=(AssetPlanInfoService)SpringContextUtils.getBean(AssetPlanInfoService.class);
			
			logger.info("UseRateQuartzJobBean job start");
			assetPlanInfoService.syncUsageRateTask();
			
		} catch (Exception e) {
			OperationLogService operationLogService=(OperationLogService)SpringContextUtils.getBean(OperationLogService.class);;
			OperationLog log=new OperationLog();
			log.setModelcode("com.h3c.platform.task.config.UseRateQuartzJobBean");
			log.setModelname("同步未处理使用率定时任务");
			log.setSummary("");
			log.setContent(ExceptionUtils.getFullStackTrace(e));
			log.setUserid(UserUtils.getCurrentUserId());
			log.setLogtype(LogType.Task);
			try {
				log.setIp("service:"+InetAddress.getLocalHost().getHostAddress());
			} catch (UnknownHostException ex) {
				e.printStackTrace();
			}
				
			operationLogService.SaveLog(log);
			e.printStackTrace();
		}

		logger.info("UseRateQuartzJobBean job end");
		
	}
}
