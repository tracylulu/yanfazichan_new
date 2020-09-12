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
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.h3c.platform.assetplan.entity.AssetPlanInfo;
import com.h3c.platform.assetplan.service.AssetPlanTaskService;
import com.h3c.platform.common.commonconst.DicConst;
import com.h3c.platform.common.commonconst.LogType;
import com.h3c.platform.common.service.CalendarService;
import com.h3c.platform.common.service.MailInfoService;
import com.h3c.platform.common.service.SysDicInfoService;
import com.h3c.platform.common.util.ObjToStrUtil;
import com.h3c.platform.common.util.SpringContextUtils;
import com.h3c.platform.sysmgr.entity.OperationLog;
import com.h3c.platform.sysmgr.service.OperationLogService;
import com.h3c.platform.util.UserUtils;

@PersistJobDataAfterExecution // 持久化
@DisallowConcurrentExecution // 禁止并发执行(Quartz不要并发地执行同一个job定义（这里指一个job类的多个实例）)
public class MailQuartzJobBean extends QuartzJobBean {

	private Logger logger = LoggerFactory.getLogger(MailQuartzJobBean.class);

	// @Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException  {

		try {
			logger.info("MailQuartzJobBean job start");
			// 标记是否包含计划外 true不包含
			boolean[] isAbnormalPlan = { true };
			AssetPlanTaskService assetPlanTaskService = (AssetPlanTaskService) SpringContextUtils
					.getBean(AssetPlanTaskService.class);
			MailInfoService mailInfoService = (MailInfoService) SpringContextUtils.getBean(MailInfoService.class);

			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			SysDicInfoService sysDicInfoService = (SysDicInfoService) SpringContextUtils.getBean(SysDicInfoService.class);
			CalendarService calendarService = (CalendarService) SpringContextUtils.getBean(CalendarService.class);

			Calendar cal = null;
			cal = Calendar.getInstance();
			Integer month = cal.get(Calendar.MONTH) + 1;
			int startDay = 0, firstLen=0,secondLen=0,thirdLen=0,fourthLen=0;

			JSONArray approveDate = sysDicInfoService.getJsonArrayDicsByType(DicConst.R_APPROVEDATE,"1");              //获取1-4环节有效时间
			JSONObject objStartDay = sysDicInfoService.getDicByTypeAndCode(DicConst.R_STARTDATE, month.toString());    //本月计划启动时间
			startDay = objStartDay.getIntValue("dic_value");
			Calendar startCal = null;
			startCal = Calendar.getInstance();
			startCal.set(Calendar.DAY_OF_MONTH, startDay);

			Date workDate = calendarService.getStartDay(startCal.getTime());

			if (workDate == null) {
				throw new Exception("未查询到启动工作日");
			}
			//if (new Date().after(df.parse(df.format(workDate)))) {
				for (int i = 0; i < approveDate.size(); i++) {
					JSONObject obj = approveDate.getJSONObject(i);
					if ("1".equals(ObjToStrUtil.replaceNullValue(obj.get("dic_code")))) {
						firstLen = obj.getInteger("dic_value");
					}

					if ("2".equals(ObjToStrUtil.replaceNullValue(obj.get("dic_code")))) {
						secondLen = obj.getInteger("dic_value");
					}

					if ("3".equals(ObjToStrUtil.replaceNullValue(obj.get("dic_code")))) {
						thirdLen = obj.getInteger("dic_value");
					}

					if ("4".equals(ObjToStrUtil.replaceNullValue(obj.get("dic_code")))) {
						fourthLen = obj.getInteger("dic_value");
					}
				}
			//}

			// 第一环节截止时间
			Date workEndFirst=calendarService.getEndNextDay(workDate,firstLen);
			if(workEndFirst==null) {
				throw new Exception("未查询到结束工作日");
			}
			Date firstEmailDate=calendarService.getEndDay(workDate,firstLen);
			if(firstEmailDate==null) {
				throw new Exception("未查询到结束工作日");
			}
			
			// 第二环节 规范性审核截止时间
			Date workEndSecond=calendarService.getEndNextDay(workEndFirst,secondLen);
			if(workEndSecond==null) {
				throw new Exception("未查询到结束工作日");
			}
			Date secondEmailDate=calendarService.getEndDay(workEndFirst,secondLen);
			if(secondEmailDate==null) {
				throw new Exception("未查询到结束工作日");
			}

			//第三环节 三级部门截止时间
			Date workEndThird=calendarService.getEndNextDay(workEndSecond,thirdLen);
			if(workEndThird==null) {
				throw new Exception("未查询到结束工作日");
			}
			Date thirdEmailDate=calendarService.getEndDay(workEndSecond,thirdLen);
			if(thirdEmailDate==null) {
				throw new Exception("未查询到结束工作日");
			}
			
			//第四环节 二级部门截止时间
			Date workEndFourth=calendarService.getEndNextDay(workEndThird,fourthLen);
			if(workEndFourth==null) {
				throw new Exception("未查询到结束工作日");
			}
			Date fourthEmailDate=calendarService.getEndDay(workEndThird,fourthLen);
			if(fourthEmailDate==null) {
				throw new Exception("未查询到结束工作日");
			}

			Map<String, Object> param = new HashMap<>();
			List<AssetPlanInfo> lst = assetPlanTaskService.getAssetPlanEmailByMap(param);
			String type="";

			List<String> lstApplyCode = new ArrayList<>();
			lst.stream().filter(o -> "11".equals(o.getApstatus())).forEach(o -> {
				if (!lstApplyCode.contains(o.getRequireduser())&&StringUtils.isNotBlank(o.getRequireduser())) {
					lstApplyCode.add(o.getRequireduser());
				}
			});				

			for (String user : lstApplyCode) {
				type="";
				Map<Integer,List<AssetPlanInfo>> mapApplyType=lst.stream().filter(o -> "1".equals(o.getApstage()) && user.equals(o.getApplyuser())).collect(Collectors.groupingBy(AssetPlanInfo::getAbnormalplanenum));
				if(mapApplyType.get(0)!=null && !mapApplyType.get(0).isEmpty()) {
					type+="计划内申购单，";
				}
				if((mapApplyType.get(1)!=null && !mapApplyType.get(1).isEmpty())||(mapApplyType.get(2)!=null && !mapApplyType.get(2).isEmpty())) {
					type+="计划外申购单，";
				}
				mailInfoService.sendRemindMailWithEndTime(user, "", "资源计划不规范驳回修改", secondEmailDate, isAbnormalPlan[0],"",type.substring(0, type.length()-1));

			}

			List<String> lstReviewCode = new ArrayList<>();
			lst.stream().filter(o -> "2".equals(o.getApstage())).forEach(o -> {
			
						if (!lstReviewCode.contains(o.getReviewer())&&StringUtils.isNotBlank(o.getReviewer())) {
							lstReviewCode.add(o.getReviewer());
						}
					});
			for (String user : lstReviewCode) {
				type="";
				Map<Integer,List<AssetPlanInfo>> mapReviewType=lst.stream().filter(o -> "2".equals(o.getApstage()) && user.equals(o.getReviewer())).collect(Collectors.groupingBy(AssetPlanInfo::getAbnormalplanenum));
				if(mapReviewType.get(0)!=null && !mapReviewType.get(0).isEmpty()) {
					type+="计划内申购单，";
				} 
				if((mapReviewType.get(1)!=null && !mapReviewType.get(1).isEmpty())||(mapReviewType.get(2)!=null && !mapReviewType.get(2).isEmpty())) {
					type+="计划外申购单，";
				}
				mailInfoService.sendRemindMailWithEndTime(user, "", "规范性审核", secondEmailDate, isAbnormalPlan[0], "",type.substring(0, type.length()-1));
			}

			
			List<String> lstDeptTCode = new ArrayList<>();
			lst.stream().filter(o -> "3".equals(o.getApstage())).forEach(o -> {
			
				if (!lstDeptTCode.contains(o.getDept3manager())&&StringUtils.isNotBlank(o.getDept3manager())) {
					lstDeptTCode.add(o.getDept3manager());
				}
			});
			for (String user : lstDeptTCode) {
				type="";
				Map<Integer,List<AssetPlanInfo>> mapDeptTType=lst.stream().filter(o -> "3".equals(o.getApstage()) && user.equals(o.getDept3manager())).collect(Collectors.groupingBy(AssetPlanInfo::getAbnormalplanenum));
				if(mapDeptTType.get(0)!=null && !mapDeptTType.get(0).isEmpty()) {
					type+="计划内申购单，";
				} 
				if((mapDeptTType.get(1)!=null && !mapDeptTType.get(1).isEmpty())||(mapDeptTType.get(2)!=null && !mapDeptTType.get(2).isEmpty())) {
					type+="计划外申购单，";
				}
				mailInfoService.sendRemindMailWithEndTime(user, "", "三级部门主管审核", thirdEmailDate, isAbnormalPlan[0],"",type.substring(0, type.length()-1));
			}

			
			List<String> lstDeptSCode = new ArrayList<>();
			lst.stream().filter(o -> "4".equals(o.getApstage())).forEach(o -> {
			
				if (!lstDeptSCode.contains(o.getDept2manager())&&StringUtils.isNotBlank(o.getDept2manager())) {
					lstDeptSCode.add(o.getDept2manager());
				}
			});
			
			for (String user : lstDeptSCode) {
				type="";
				Map<Integer,List<AssetPlanInfo>> mapDeptSType=lst.stream().filter(o -> "4".equals(o.getApstage()) && user.equals(o.getDept2manager())).collect(Collectors.groupingBy(AssetPlanInfo::getAbnormalplanenum));
				if(mapDeptSType.get(0)!=null && !mapDeptSType.get(0).isEmpty()) {
					type+="计划内申购单，";
				}
				if((mapDeptSType.get(1)!=null && !mapDeptSType.get(1).isEmpty())||(mapDeptSType.get(2)!=null && !mapDeptSType.get(2).isEmpty())) {
					type+="计划外申购单，";
				}
				mailInfoService.sendRemindMailWithEndTime(user, "", "二级部门主管审核", fourthEmailDate, isAbnormalPlan[0],"",type.substring(0, type.length()-1));
			}

			List<String> lstPlannerCode = new ArrayList<>();
			lst.stream().filter(o -> "5".equals(o.getApstage())).forEach(o -> {

				if (!lstPlannerCode.contains(o.getPlanner())&&StringUtils.isNotBlank(o.getPlanner())) {
					lstPlannerCode.add(o.getPlanner());
				}
			});

			for (String user : lstPlannerCode) {
				mailInfoService.sendRemindMail(user, "", "计划员审核", "");
			}

			List<String> lstOQCode = new ArrayList<>();
			lst.stream().filter(o -> "6".equals(o.getApstage())).forEach(o -> {

				if (!lstOQCode.contains(o.getOqdeptreviewer())&&StringUtils.isNotBlank(o.getOqdeptreviewer())) {
					lstOQCode.add(o.getOqdeptreviewer());
				}
			});
			for (String user : lstOQCode) {
				mailInfoService.sendRemindMail(user, "", "专家团审核", "");
			}

			List<String> lstDeptFCode = new ArrayList<>();
			lst.stream().filter(o -> "7".equals(o.getApstage())).forEach(o -> {

				if (!lstDeptFCode.contains(o.getDept1reviewer())&&StringUtils.isNotBlank(o.getDept1reviewer())) {
					lstDeptFCode.add(o.getDept1reviewer());
				}
			});
			for (String user : lstDeptFCode) {
				mailInfoService.sendRemindMail(user, "", "一级部门主管审核", "");
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
