package com.h3c.platform.common.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.h3c.platform.common.dao.MailInfoMapper;
import com.h3c.platform.common.entity.MailInfo;
import com.h3c.platform.common.executor.MailThreadExecutor;
import com.h3c.platform.common.service.AfspTokenService;
import com.h3c.platform.common.service.MailInfoService;
import com.h3c.platform.common.util.HttpClientUtil;
import com.h3c.platform.util.UserUtils;

@Service
public class MailInfoServiceImpl implements MailInfoService {

	@Autowired
	private MailInfoMapper mailInfoMapper;

	@Value("${spring.main.url}")
	private String siteMainUrl;
	@Value("${defaultMail}")
	private String defaultMail;
	@Value("${defaultMailSendTo}")
	private String defaultSendTo;
	@Value("${defaultMailCCTo}")
	private String defaultCCTo;
	@Value("${spring.remindEmail.url}")
	private String defaultUrl;
	@Autowired
	private MailThreadExecutor executor;
	
	@Value("${afsp.dic.url}")
	private String afspUrl;
	@Value("${afsp.mail.sendMailInfoByTemplete}")
	private String mailTempleteUrl;
	@Value("${afsp.applicationId}")
	private String  applicationId;
	@Autowired
	private AfspTokenService afspTokenService;
	@Override
	@Transactional
	public void create(MailInfo mailInfo) {
		mailInfo.setCreator(UserUtils.getCurrentUserId());
		mailInfo.setCreatetime(new Date());
		mailInfoMapper.insert(mailInfo);
	}

	/**
	 * 发送邮件并保存记录 有抄送人
	 * 
	 * @param sendTo
	 * @param ccTo
	 * @param subject
	 * @param content
	 * @param processId
	 */
	@Override
	public void sendMailAndRecord(String sendTo, String ccTo, String subject, String content ) {
		MailInfo mailInfo = new MailInfo();		
		mailInfo.setSendto(sendTo);
		mailInfo.setCcto(ccTo);
		mailInfo.setSubject(subject);
		mailInfo.setContent(content);	
		create(mailInfo);

		String[] sendArr = sendTo.split(",");
		if (ccTo != null) {
			String[] ccArr = ccTo.split(",");

			sendMail(Arrays.asList(sendArr), Arrays.asList(ccArr), subject, content);
		} else {
			sendMail(Arrays.asList(sendArr), null, subject, content);
		}

	}

	/**
	 * 发送邮件并保存记录 无抄送人
	 * 
	 * @param sendTo
	 * @param subject
	 * @param content
	 * @param processId
	 */
	@Override
	public void sendMailAndRecord(String sendTo, String subject, String content) {
		sendMailAndRecord(sendTo, null, subject, content);
	}

	@Override
	public void sendMail(List<String> sendTo, List<String> ccTo, String subject, String content) {
		if(StringUtils.isBlank(content)) {
			content="您有采购流程需要处理！";
		}
		//content = "文档链接：<a href='" + siteMainUrl + "/mailLogin?mailid=" + id + "'>打开文档</a>";
		content += " </br><div>此邮件来自：研发资源计划管理平台" + siteMainUrl + "。</br>如有使用问题请联系管理员，请勿直接回信。 </div>";
		List<String> sendList = new ArrayList<>();
		List<String> ccList = new ArrayList<>();
		//测试邮件开关开启，重置测试人员，发送测试邮件
		if("open".equals(defaultMail)) {
			sendTo = Arrays.asList(defaultSendTo.split(",")) ;
			ccTo = Arrays.asList(defaultCCTo.split(",")) ;
		}
		
		if (!CollectionUtils.isEmpty(sendTo)) {
			for (String item : sendTo) {
				sendList.add(item);
			}
		}
		if (!CollectionUtils.isEmpty(ccTo)) {
			for (String item : ccTo) {
				ccList.add(item);
			}
		}
		if (ccTo == null) {
			send(sendList, new ArrayList<>(), subject, content);
		} else {
			send(sendList, ccList, subject, content);
		}

	}

	public void send(List<String> sendTo, List<String> ccTo, String subject, String content) {
		executor.send(sendTo, ccTo, subject, content);
	}

	@Override
	public void sendMail(String sendTo, String ccTo, String subject, String content) {
		List<String> sendList = new ArrayList<>();
		List<String> ccList = new ArrayList<>();
		sendList.add(sendTo);
		if (StringUtils.isNotBlank(ccTo)) {
			ccList.add(ccTo);
		}
		if (ccTo == null) {
			send(sendList, new ArrayList<>(), subject, content);
		} else {
			send(sendList, ccList, subject, content);
		}
	}
	
	@Override
	public void sendRemindMail(String sendTo, String ccTo , String process, String url) {
		String subject ="【邮件提醒】：请处理资源计划审批电子流。当前状态是【"+process+"】";
		StringBuffer content=new StringBuffer();
		content.append("请点击任务链接处理</br>");

		if(StringUtils.isNotBlank(url)) {
			content.append("<a href='" + url + "'>链接</a>");
		}else {
			content.append("<a href='" + defaultUrl + "'>链接</a>");
		}
		
		sendMailAndRecord(sendTo,  ccTo,  subject,  content.toString() );		
	}
	
	@Override
	public void sendProcessEndMail(String sendTo, String ccTo ,  String url) {
		String subject ="【邮件提醒】：您申请的采购流程已结束！";
		StringBuffer content=new StringBuffer();
		if(StringUtils.isNotBlank(url)) {
			content.append("<a href='" + url + "'>链接</a>");
		}else {
			content.append("<a href='" + defaultUrl + "'>链接</a>");
		}
		
		sendMailAndRecord(sendTo,  ccTo,  subject,  content.toString() );		
	}
	
	@Override
	public void sendRemindMailWithEndTime(String sendTo, String ccTo, String process, Date endDate, boolean isAbnormalPlan, String url) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calMon = Calendar.getInstance();
		calMon.setTime(endDate);
		int maxDay = calMon.getActualMaximum(Calendar.DAY_OF_MONTH);
		calMon.set(Calendar.DAY_OF_MONTH, maxDay);			
		
		String subject ="【邮件提醒】：请处理资源计划审批电子流。当前状态是【"+process+"】";
		StringBuffer content=new StringBuffer();
//		if(isAbnormalPlan) {
//			content.append("采购计划审核截止时间：");
//			content.append(df.format(endDate)+" 24:00:00</br>");
//		}else {		
//		}
		
		content.append("采购计划内审核截止时间：");
		content.append(df.format(endDate)+" 24:00:00</br>");
		content.append("采购计划外审核截止时间：");
		content.append(df.format(calMon.getTime())+" 24:00:00</br>");
		content.append("请在审核截止时间之前处理完毕！");
		content.append("请点击任务链接处理</br>");

		if(StringUtils.isNotBlank(url)) {
			content.append("<a href='" + url + "'>链接</a>");
		}else {
			content.append("<a href='" + defaultUrl + "'>链接</a>");
		}
		
		sendMailAndRecord(sendTo,  ccTo,  subject,  content.toString() );
	}

	@Override
	public void sendMailByTemplete(String templeteCode, List<String> bccTo, List<String> ccTo, List<String> sendTo, JSONObject content,  int priority, JSONArray templeteArr, JSONArray titleArr) {
		try {
			String  token = afspTokenService.getEosToken();
			Map<String,String> headers = new HashMap<String, String>();
			headers.put("token", token);
			
			JSONObject paramJson = new JSONObject();
			paramJson.put("applicationId", applicationId);
			paramJson.put("sendTo", sendTo);
			paramJson.put("ccTo", ccTo);
			paramJson.put("templeteCode", templeteCode);
			paramJson.put("priority", priority);
			paramJson.put("templeteArr", templeteArr);
			paramJson.put("content", content);
			paramJson.put("titleArr", titleArr);
			
			
		String result= HttpClientUtil.sendHttpPostJsonWithHeader(afspUrl + mailTempleteUrl , paramJson.toString(),headers);
		System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
