package com.h3c.platform.common.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.h3c.platform.common.commonconst.MailTempConst;
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
	public void sendMailAndRecord(String mailTemp,String sendTo, String ccTo, JSONObject content,  JSONArray templeteArr, JSONArray titleArr ) {
		MailInfo mailInfo = new MailInfo();		
		mailInfo.setSendto(sendTo);
		mailInfo.setCcto(ccTo);
		mailInfo.setSubject("mailTemp");
		mailInfo.setContent(content.toString());	
		create(mailInfo);

		String[] sendArr = sendTo.split(",");
		if (ccTo != null) {
			String[] ccArr = ccTo.split(",");

			sendMail(mailTemp ,Arrays.asList(sendArr), Arrays.asList(ccArr), content, templeteArr, titleArr);
		} else {
			sendMail(mailTemp ,Arrays.asList(sendArr), null, content, templeteArr, titleArr);
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
	public void sendMailAndRecord(String mailTemp,String sendTo, JSONObject content,  JSONArray templeteArr, JSONArray titleArr ) {
		sendMailAndRecord( mailTemp, sendTo, null,  content,   templeteArr,  titleArr );
	}

	@Override
	public void sendMail(String mailTemp,List<String> sendTo, List<String> ccTo,  JSONObject content,  JSONArray templeteArr, JSONArray titleArr) {
		
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
			send(mailTemp, null, new ArrayList<>(),sendList, content,1, templeteArr,titleArr);
		} else {
			send(mailTemp, null, ccList, sendList,  content,1, templeteArr,titleArr);
		}

	}

	public void send(String templeteCode, List<String> bccTo, List<String> ccTo, List<String> sendTo, JSONObject content,  int priority, JSONArray templeteArr, JSONArray titleArr) {
		executor.send( templeteCode,  bccTo,  ccTo,  sendTo,  content,   priority,  templeteArr,  titleArr);
	}

//	@Override
//	public void sendMail(String sendTo, String ccTo, String subject, String content) {
//		List<String> sendList = new ArrayList<>();
//		List<String> ccList = new ArrayList<>();
//		sendList.add(sendTo);
//		if (StringUtils.isNotBlank(ccTo)) {
//			ccList.add(ccTo);
//		}
//		if (ccTo == null) {
//			send(sendList, new ArrayList<>(), subject, content);
//		} else {
//			send(sendList, ccList, subject, content);
//		}
//	}
	
	@Override
	public void sendRemindMail(String sendTo, String ccTo , String process, String url) {
		
		JSONObject contentJson = new JSONObject();
		contentJson.put("$node", process);
		//contentJson.put("$url", StringUtils.isNotBlank(url)?url:defaultUrl);

		JSONArray templeteArr = new JSONArray();
		JSONObject tempTempleteJson = new JSONObject();
		tempTempleteJson.put("code", "$system");
		templeteArr.add(tempTempleteJson);
		
//		JSONArray titleArr = new JSONArray();
//		JSONObject titleJson = new JSONObject();
//		titleJson.put("code", "$title1");
//		titleArr.add(titleJson);		
		
		sendMailAndRecord(MailTempConst.APPROVALDATA, sendTo,  ccTo,  contentJson, templeteArr ,null);		
	}
	
	@Override
	public void sendProcessEndMail(String sendTo, String ccTo ,  String url) {
		JSONObject contentJson = new JSONObject();
		contentJson.put("$url", StringUtils.isNotBlank(url)?url:defaultUrl);

		JSONArray templeteArr = new JSONArray();
		JSONObject tempTempleteJson = new JSONObject();
		tempTempleteJson.put("code", "$system");
		templeteArr.add(tempTempleteJson);
		
//		JSONArray titleArr = new JSONArray();
//		JSONObject titleJson = new JSONObject();
//		titleJson.put("code", "$title1");
//		titleArr.add(titleJson);

		sendMailAndRecord(MailTempConst.APPROVALEND, sendTo,  ccTo,  contentJson, templeteArr ,null);			
	}
	
	@Override
	public void sendRemindMailWithEndTime(String sendTo, String ccTo, String process, Date endDate, boolean isAbnormalPlan, String url) {
	
		JSONObject contentJson = new JSONObject();
		contentJson.put("$url", StringUtils.isNotBlank(url)?url:defaultUrl);
		contentJson.put("$endDate", endDate);

		JSONArray templeteArr = new JSONArray();
		JSONObject tempTempleteJson = new JSONObject();
		tempTempleteJson.put("code", "$system");
		templeteArr.add(tempTempleteJson);
		
		sendMailAndRecord(MailTempConst.REGULARMAIL, sendTo,  ccTo,  contentJson, templeteArr ,null);	
	}
	
	/**
     * 不规范邮件
     * @param sendTo
     * @param ccTo
     * @param subject 邮件主题
     * @param process 流程环节名称
     * @param url 流程链接  ,为空不加超链接 
     */

	@Override
	public void  sendNonstandardMail(String sendTo, String ccTo, String process) {
		JSONObject contentJson = new JSONObject();
		contentJson.put("$url", defaultUrl);

		JSONArray templeteArr = new JSONArray();
		JSONObject tempTempleteJson = new JSONObject();
		tempTempleteJson.put("code", "$system");
		templeteArr.add(tempTempleteJson);
		
		sendMailAndRecord(MailTempConst.NONSTANDARD, sendTo,  ccTo,  contentJson, templeteArr ,null);	
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
