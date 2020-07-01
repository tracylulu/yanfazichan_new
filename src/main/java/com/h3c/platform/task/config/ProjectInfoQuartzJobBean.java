package com.h3c.platform.task.config;

import java.util.List;
import java.util.Map;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.PersistJobDataAfterExecution;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.h3c.platform.assetplan.service.ProjectInfoService;
import com.h3c.platform.common.util.HttpClientUtil;
import com.h3c.platform.common.util.SpringContextUtils;
import com.h3c.platform.sync.entity.ApiUrl;
import com.h3c.platform.sync.service.EosApiUrlService;
import com.h3c.platform.sync.service.ProjectInfoEosService;

import net.sf.json.JSONObject;

@PersistJobDataAfterExecution//持久化
@DisallowConcurrentExecution//禁止并发执行(Quartz不要并发地执行同一个job定义（这里指一个job类的多个实例）)
public class ProjectInfoQuartzJobBean extends QuartzJobBean{
	
	@Value("${eos.url.login}")
	private String eosAPI_loginUrl;
	
	@Value("${eos.url.project}")
	private String projectAPI_httpUrl;
	
	@Value("${eos.account}")
	private String eosAPI_account;
	
	@Value("${eos.password}")
	private String eosAPI_password;
	
	private Logger logger = LoggerFactory.getLogger(ProjectInfoQuartzJobBean.class);
	
	protected void executeInternal(JobExecutionContext context)
			throws JobExecutionException {
		ProjectInfoEosService projectInfoEosService=(ProjectInfoEosService)SpringContextUtils.getBean(ProjectInfoEosService.class);
		EosApiUrlService eosApiUrlService = (EosApiUrlService) SpringContextUtils.getBean(EosApiUrlService.class);
		ProjectInfoService projectInfoService =(ProjectInfoService)SpringContextUtils.getBean(ProjectInfoService.class);
		ApiUrl apiUrl=eosApiUrlService.getEosUrl();
		logger.info("ProjectInfoEosService job start");
		String deptData =null;
		try {
			deptData = new HttpClientUtil().getDataPost(apiUrl.getLoginUrl(),apiUrl.getAccountPdt(),apiUrl.getPasswordpdt(), apiUrl.getProjectUrl());
 		} catch (Exception e) {			
			e.printStackTrace();
		}
		if(deptData!=null && deptData.length()!=0) {
			JSONObject result=JSONObject.fromObject(deptData);
 			int code = Integer.parseInt(result.get("code").toString());
			
			if(code==20216) {
		        List<Map<String, Object>> lst = (List) result.getJSONArray("data");
		        try {
					projectInfoEosService.syncProjectInfoEos(lst);		
					projectInfoService.syncByEosData();					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			else {
				logger.info("接口："+apiUrl.getProjectUrl()+"连接失败");
			}
		}
		else {
			logger.info("接口：:"+apiUrl.getProjectUrl()+"异常，无数据");	
		}

		logger.info("ProjectInfoEosService job end");
		
	}
}
