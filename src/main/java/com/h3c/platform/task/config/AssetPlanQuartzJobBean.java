package com.h3c.platform.task.config;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.PersistJobDataAfterExecution;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.h3c.platform.assetplan.service.AssetPlanTaskService;
import com.h3c.platform.common.commonconst.DicConst;
import com.h3c.platform.common.commonconst.LogType;
import com.h3c.platform.common.service.CalendarService;
import com.h3c.platform.common.service.SysDicInfoService;
import com.h3c.platform.common.util.ObjToStrUtil;
import com.h3c.platform.common.util.SpringContextUtils;
import com.h3c.platform.sysmgr.entity.OperationLog;
import com.h3c.platform.sysmgr.service.OperationLogService;
import com.h3c.platform.util.UserUtils;

@PersistJobDataAfterExecution//持久化
@DisallowConcurrentExecution//禁止并发执行(Quartz不要并发地执行同一个job定义（这里指一个job类的多个实例）)
public class AssetPlanQuartzJobBean extends QuartzJobBean{
	
	private Logger logger = LoggerFactory.getLogger(AssetPlanQuartzJobBean.class);
	
	//@Override
	protected void executeInternal(JobExecutionContext context)
			throws JobExecutionException {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		SysDicInfoService sysDicInfoService=(SysDicInfoService)SpringContextUtils.getBean(SysDicInfoService.class);
		CalendarService calendarService =(CalendarService)SpringContextUtils.getBean(CalendarService.class);
		AssetPlanTaskService assetPlanTaskService = (AssetPlanTaskService)SpringContextUtils.getBean(AssetPlanTaskService.class);
		
		logger.info("AssetPlanQuartzJobBean job start");
		Calendar cal= null;
		cal=Calendar.getInstance();
		Integer month=cal.get(Calendar.MONTH)+1;
		int startDay=0,firstLen=0,secondLen=0,thirdLen=0,fourthLen=0;
		
		try {
			JSONArray approveDate=sysDicInfoService.getJSONArrayDicsByType(DicConst.R_APPROVEDATE,"1");
			JSONObject objStartDay= sysDicInfoService.getDicByTypeAndCode(DicConst.R_STARTDATE,month.toString());
			startDay =objStartDay.getIntValue("dic_value");
			Calendar startCal=null;
			startCal = Calendar.getInstance();
			startCal.set(Calendar.DAY_OF_MONTH, startDay);
		
			
			Date workDate=calendarService.getStartDay(startCal.getTime());
			
			if(workDate==null) {
				throw new Exception("未查询到启动工作日");
			}
			if(new Date().after(df.parse(df.format(workDate)))) {
				for(int i=0;i<approveDate.size();i++) {
					JSONObject obj=approveDate.getJSONObject(i);
					if("1".equals(ObjToStrUtil.replaceNullValue(obj.get("dic_code")))){
						firstLen=obj.getInteger("dic_value");
					}
					
					if("2".equals(ObjToStrUtil.replaceNullValue(obj.get("dic_code")))){
						secondLen=obj.getInteger("dic_value");
					}
					
					if("3".equals(ObjToStrUtil.replaceNullValue(obj.get("dic_code")))){
						thirdLen=obj.getInteger("dic_value");
					}
					
					if("4".equals(ObjToStrUtil.replaceNullValue(obj.get("dic_code")))){
						fourthLen=obj.getInteger("dic_value");
					}
				}
				
				Date workEndFirst=calendarService.getEndNextDay(workDate,firstLen);
				if(workEndFirst==null) {
					throw new Exception("未查询到结束工作日");
				}
				logger.info(df.format(workEndFirst.getTime()));
				if(df.format(workEndFirst).equals(df.format(new Date()))) {
					assetPlanTaskService.applyOutTime();
					logger.info("first  out time");
				}				
			
				Date workEndSecond=calendarService.getEndNextDay(workEndFirst,secondLen);
				if(workEndFirst==null) {
					throw new Exception("未查询到结束工作日");
				}				
				logger.info(df.format(workEndSecond));
				if(df.format(workEndSecond).equals(df.format(new Date()))) {
					assetPlanTaskService.reviewerOutTime();
					logger.info("second  out time");
				}
				
				Date workEndThird=calendarService.getEndNextDay(workEndSecond,thirdLen);
				if(workEndFirst==null) {
					throw new Exception("未查询到结束工作日");
				}
				logger.info(df.format(workEndThird));
				if(df.format(workEndThird).equals(df.format(new Date()))) {
					assetPlanTaskService.dept3OutTime();
					assetPlanTaskService.submitAllForDept3();
					logger.info("third  out time");
				}
				
				Date workEndFourth=calendarService.getEndNextDay(workEndThird,fourthLen);
				if(workEndFirst==null) {
					throw new Exception("未查询到结束工作日");
				}
				logger.info(df.format(workEndFourth));
				if(df.format(workEndFourth).equals(df.format(new Date()))) {
					assetPlanTaskService.dept2OutTime();
					logger.info("fourth  out time");
				}				
			}
			
			//月超时  下月第一天0点
			Calendar calMon = Calendar.getInstance();

			//下月第一天0点执行任务
			if(1==calMon.get(Calendar.DAY_OF_MONTH)) {
				assetPlanTaskService.monthOutTime();
			}
		} catch (Exception e) {
			OperationLogService operationLogService=(OperationLogService)SpringContextUtils.getBean(OperationLogService.class);;
			OperationLog log=new OperationLog();
			log.setModelcode("com.h3c.platform.task.config.AssetPlanQuartzJobBean");
			log.setModelname("流程定时任务");
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
		

		logger.info("AssetPlanQuartzJobBean job end");
		
	}
	
}
