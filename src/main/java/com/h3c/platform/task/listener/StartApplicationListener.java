package com.h3c.platform.task.listener;

import java.util.concurrent.atomic.AtomicInteger;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.h3c.platform.task.config.AssetPlanQuartzJobBean;
import com.h3c.platform.task.config.DeptInfoQuartzJobBean;
import com.h3c.platform.task.config.MailQuartzJobBean;
import com.h3c.platform.task.config.MailRemindQuartzJobBean;
import com.h3c.platform.task.config.ProjectInfoQuartzJobBean;
import com.h3c.platform.task.config.SchedulerConfig;
import com.h3c.platform.task.config.UseRateQuartzJobBean;
import com.h3c.platform.task.config.UserInfoQuartzJobBean;


/**
 * @Description:利用Quartz定时任务，可以在初始化上实现，
 */
@Component
public class StartApplicationListener implements ApplicationListener<ContextRefreshedEvent> {
	
	@Autowired
	private SchedulerConfig schedulerConfig;
	
	@Value("${eos.dept.cron}")
	private String deptCron;
	@Value("${eos.user.cron}")
	private String userCron;
	@Value("${eos.pro.cron}")
	private String protCron;
	@Value("${eos.asset.cron}")
	private String assetCron;
	@Value("${eos.mail.cron}")
	private String mailCron;
	@Value("${eos.rate.cron}")
	private String rateCron;
	@Value("${eos.remindMail.cron}")
	private String remindMailCron;
	
	public static AtomicInteger count = new AtomicInteger(0);
	
	protected Logger log = LoggerFactory.getLogger(StartApplicationListener.class);
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		// 防止重复执行
		if (event.getApplicationContext().getParent() == null && count.incrementAndGet() <= 1) {
			initMyJob();
		}
	}
	public void initMyJob()  {
		//调度器
		Scheduler scheduler = null;
		try {
			//创建scheduler
			scheduler = schedulerConfig.scheduler();
			
			
			//从数据中台获取部门组织架构信息 定时任务
			buildJob(scheduler, "jobdept", "dept_job",  "triggerdept", "dept_trigger", DeptInfoQuartzJobBean.class, deptCron);
			
			buildJob(scheduler, "jobuser", "user_job",  "triggeruser", "user_trigger", UserInfoQuartzJobBean.class, userCron);
			
			buildJob(scheduler, "jobpro", "pro_job",  "triggerpro", "pro_trigger", ProjectInfoQuartzJobBean.class, protCron);
			
			buildJob(scheduler, "jobasset", "asset_job",  "triggerasset", "asset_trigger", AssetPlanQuartzJobBean.class, assetCron);
			
			buildJob(scheduler, "jobmail", "mail_job",  "triggermail", "mail_trigger", MailQuartzJobBean.class, mailCron);
			
			buildJob(scheduler, "jobremindMail", "remindMail_job",  "triggerremindMail", "remindMail_trigger", MailRemindQuartzJobBean.class, remindMailCron);
			
			buildJob(scheduler, "jobrate", "mail_rate",  "triggerrate", "rate_trigger", UseRateQuartzJobBean.class, rateCron);
			
			scheduler.start();
		} catch (Exception e) {
			log.info(ExceptionUtils.getFullStackTrace(e));
		}
	}
	
	
	public void buildJob(Scheduler scheduler,String jobKeyStr, String jobGroupName,  String triggerKeyStr, String triggerGroupName, Class job, String cronStr){
		try {
			TriggerKey triggerKey = TriggerKey.triggerKey(triggerKeyStr, triggerGroupName);
			CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
			JobDetail jobDetail = JobBuilder.newJob(job).withIdentity(jobKeyStr, jobGroupName).build();
			if (null == trigger) {
				//定义一个JobDetail,其中的定义Job类，是真正的执行逻辑所在
				CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cronStr);
				//定义一个Trigger
				trigger = TriggerBuilder.newTrigger().withIdentity(triggerKeyStr, triggerGroupName)
						.withSchedule(scheduleBuilder).build();
					scheduler.scheduleJob(jobDetail, trigger);
				log.info("Quartz 创建了job:...:{}",jobDetail.getKey());
			} else {
//				if(!cronStr.equals(trigger.getCronExpression())){
					log.info("job已存在:{}",trigger.getKey());					
					//定义一个JobDetail,其中的定义Job类，是真正的执行逻辑所在
					scheduler.deleteJob(jobDetail.getKey());
					CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cronStr);
					//定义一个Trigger
					trigger = TriggerBuilder.newTrigger().withIdentity(triggerKeyStr, triggerGroupName)
							.withSchedule(scheduleBuilder).build();
					scheduler.scheduleJob(jobDetail, trigger);
					log.info("Quartz 重新创建了job:...:{}",jobDetail.getKey());
//				}
			}
		} catch (Exception e) {
			log.info(ExceptionUtils.getFullStackTrace(e));
		}
	}
}
