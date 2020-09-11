package com.h3c.platform.task.config;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.PersistJobDataAfterExecution;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.h3c.platform.assetplan.entity.AssetPlanInfo;
import com.h3c.platform.assetplan.service.AssetPlanTaskService;
import com.h3c.platform.assetplan.service.ProjectInfoService;
import com.h3c.platform.common.commonconst.DicConst;
import com.h3c.platform.common.commonconst.LogType;
import com.h3c.platform.common.service.CalendarService;
import com.h3c.platform.common.service.MailInfoService;
import com.h3c.platform.common.service.SysDicInfoService;
import com.h3c.platform.common.util.ObjToStrUtil;
import com.h3c.platform.common.util.SpringContextUtils;
import com.h3c.platform.sync.entity.ApiUrl;
import com.h3c.platform.sync.service.EosApiUrlService;
import com.h3c.platform.sysmgr.entity.OperationLog;
import com.h3c.platform.sysmgr.service.OperationLogService;
import com.h3c.platform.util.UserUtils;

@PersistJobDataAfterExecution // 持久化
@DisallowConcurrentExecution // 禁止并发执行(Quartz不要并发地执行同一个job定义（这里指一个job类的多个实例）)
public class MailRemindQuartzJobBean extends QuartzJobBean {

	@Value("${spring.remindEmailForBudget.url}")
    private String EmailForBudget;
	
	@Value("${spring.remindEmailForPlan.url}")
    private String EmailForPlan;
	
	
	private Logger logger = LoggerFactory.getLogger(MailRemindQuartzJobBean.class);
	
	// @Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException  {

		try {
			logger.info("MailQuartzJobBean job start");
			// 标记是否包含计划外 true不包含
			MailInfoService mailInfoService = (MailInfoService) SpringContextUtils.getBean(MailInfoService.class);
			//定时任务  不是spring管理的   取不到配置文件 ,得从方法中取
			EosApiUrlService eosApiUrlService = (EosApiUrlService) SpringContextUtils.getBean(EosApiUrlService.class);
			String getbugdetUrl = eosApiUrlService.getbugdetUrl();
			String planRemindUrl = eosApiUrlService.getPlanRemindUrl();
			SysDicInfoService sysDicInfoService = (SysDicInfoService) SpringContextUtils.getBean(SysDicInfoService.class);
			CalendarService calendarService = (CalendarService) SpringContextUtils.getBean(CalendarService.class);

			Calendar cal = null;
			cal = Calendar.getInstance();
			Integer month = cal.get(Calendar.MONTH) + 1;
			int startDay = 0, budgetLen=0,planLen=0;

			JSONArray approveDate = sysDicInfoService.getJsonArrayDicsByType(DicConst.R_APPROVEDATE,"1");              //获取配置预算和计划启动提醒邮件的有效时间
			JSONObject objStartDay = sysDicInfoService.getDicByTypeAndCode(DicConst.R_STARTDATE, month.toString());    //本月计划启动时间
			startDay = objStartDay.getIntValue("dic_value");
			Calendar startCal = null;
			startCal = Calendar.getInstance();
			startCal.set(Calendar.DAY_OF_MONTH, startDay);

			Date workDate = calendarService.getStartDay(startCal.getTime());

			if (workDate == null) {
				throw new Exception("未查询到启动工作日");
			}
			for (int i = 0; i < approveDate.size(); i++) {
				JSONObject obj = approveDate.getJSONObject(i);
				if ("5".equals(ObjToStrUtil.replaceNullValue(obj.get("dic_code")))) {
					budgetLen = obj.getInteger("dic_value");
				}

				if ("6".equals(ObjToStrUtil.replaceNullValue(obj.get("dic_code")))) {
					planLen = obj.getInteger("dic_value");
				}
			}

			// 在每月计划开始前，提示配置预算的邮催时间
			Date budgetDate=calendarService.getBeforeDay(workDate,budgetLen);
			if(budgetDate==null) {
				throw new Exception("未查询到开始邮催的工作日");
			}
			// 提前告知相关人员，本月计划即将开启的邮催时间
			Date planDate=calendarService.getBeforeDay(workDate,planLen);
			if(planDate==null) {
				throw new Exception("未查询到开始邮催的工作日");
			}
			//获取邮催的发送人和抄送人
			//计划开启的提醒人员
			JSONArray planRemindPerson = sysDicInfoService.getJsonArrayDicsByType(DicConst.M_PLANREMINDER,"1");
			List<String> sendToPlanRemind =new ArrayList<>();
			List<String> ccToPlanRemind =new ArrayList<>();
			for (int  j= 0; j < planRemindPerson.size(); j++) {
				JSONObject obj = planRemindPerson.getJSONObject(j);
				String dicValue = ObjToStrUtil.replaceNullValue(obj.get("dic_value"));
				if (dicValue.contains("to")) {
					//截取_之前的字符串
					sendToPlanRemind.add(dicValue.substring(0, dicValue.indexOf("_")));
				}
				if (dicValue.contains("cc")) {
					//截取_之前的字符串
					ccToPlanRemind.add(dicValue.substring(0, dicValue.indexOf("_")));
				}
			}
			//邮催的预算配置人员
			JSONArray buegetPerson = sysDicInfoService.getJsonArrayDicsByType(DicConst.M_BUDGETMANAGER,"1");
			List<String> sendToBueget =new ArrayList<>();
			List<String> ccToBueget =new ArrayList<>();
			for (int  k= 0; k < buegetPerson.size(); k++) {
				JSONObject obj = buegetPerson.getJSONObject(k);
				String dicValue = ObjToStrUtil.replaceNullValue(obj.get("dic_value"));
				if (dicValue.contains("to")) {
					//截取_之前的字符串
					sendToBueget.add(dicValue.substring(0, dicValue.indexOf("_")));
				}
				if (dicValue.contains("cc")) {
					//截取_之前的字符串
					ccToBueget.add(dicValue.substring(0, dicValue.indexOf("_")));
				}
			}
			//当前时间与发邮件的时间吻合，则开始发邮件
			Date d = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String dateNowStr = sdf.format(d);
			System.out.println("格式化后的日期：" + dateNowStr);
			String planDateStr = sdf.format(planDate);
			String budgetDateStr = sdf.format(budgetDate);
			
			if(dateNowStr.equals(planDateStr)) {
				mailInfoService.sendPlanRemindMail(String.join(",", sendToPlanRemind), String.join(",", ccToPlanRemind), planRemindUrl);
			}	
			
			if(dateNowStr.equals(budgetDateStr)) {
				mailInfoService.sendBudgetRemindMail(String.join(",", sendToBueget), String.join(",", ccToBueget), getbugdetUrl);
			}
			
			
		} catch (Exception ex) {
			OperationLogService operationLogService=(OperationLogService)SpringContextUtils.getBean(OperationLogService.class);;
			OperationLog log=new OperationLog();
			log.setModelcode("com.h3c.platform.task.config.MailQuartzJobBean");
			log.setModelname("邮件定时任务");
			log.setSummary("");
			log.setContent(ExceptionUtils.getFullStackTrace(ex));
			log.setUserid(UserUtils.getCurrentUserId());
			log.setLogtype(LogType.Task);
			try {
				log.setIp("service:"+InetAddress.getLocalHost().getHostAddress());
			} catch (UnknownHostException e) {
				e.printStackTrace();
			}
				
			operationLogService.saveLog(log);
			ex.printStackTrace();
			throw new  JobExecutionException(ex.getMessage());
		}
		logger.info("MailQuartzJobBean job end");

	}

}
