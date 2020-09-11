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
import com.h3c.platform.common.commonconst.DicConst;
import com.h3c.platform.common.commonconst.MailTempConst;
import com.h3c.platform.common.dao.MailInfoMapper;
import com.h3c.platform.common.entity.MailInfo;
import com.h3c.platform.common.executor.MailThreadExecutor;
import com.h3c.platform.common.service.AfspTokenService;
import com.h3c.platform.common.service.CalendarService;
import com.h3c.platform.common.service.MailInfoService;
import com.h3c.platform.common.service.SysDicInfoService;
import com.h3c.platform.common.util.HttpClientUtil;
import com.h3c.platform.common.util.ObjToStrUtil;
import com.h3c.platform.util.UserUtils;

@Service
public class MailInfoServiceImpl implements MailInfoService {

	@Autowired
	private MailInfoMapper mailInfoMapper;

	@Value("${spring.main.url}")
	private String siteMainUrl;
	@Value("${mailToRealUser}")
	private String mailToRealUser;
	@Value("${defaultMailSendTo}")
	private String defaultSendTo;
	@Value("${defaultMailCCTo}")
	private String defaultCCTo;
	@Value("${spring.remindEmail.url}")
	private String defaultUrl;
	@Value("${spring.endEmail.url}")
	private String endUrl;
	@Autowired
	private MailThreadExecutor executor;

	@Value("${afsp.dic.url}")
	private String afspUrl;
	@Value("${afsp.mail.sendMailInfoByTemplete}")
	private String mailTempleteUrl;
	@Value("${afsp.applicationId}")
	private String applicationId;
	@Autowired
	private AfspTokenService afspTokenService;
	@Autowired
	private CalendarService calendarService;
	@Autowired
	private SysDicInfoService sysDicInfoService;

	@Transactional
	private void create(MailInfo mailInfo) {
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
	public void sendMailAndRecord(String mailTemp, String sendTo, String ccTo, JSONObject content,
			JSONArray templeteArr, JSONArray titleArr) {
		MailInfo mailInfo = new MailInfo();
		mailInfo.setSendto(sendTo);
		mailInfo.setCcto(ccTo);
		mailInfo.setSubject("mailTemp");
		mailInfo.setContent(content.toString());
		create(mailInfo);

		String[] sendArr = sendTo.split(",");
		if (ccTo != null) {
			String[] ccArr = ccTo.split(",");

			sendMail(mailTemp, Arrays.asList(sendArr), Arrays.asList(ccArr), content, templeteArr, titleArr);
		} else {
			sendMail(mailTemp, Arrays.asList(sendArr), null, content, templeteArr, titleArr);
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
	public void sendMailAndRecord(String mailTemp, String sendTo, JSONObject content, JSONArray templeteArr,
			JSONArray titleArr) {
		sendMailAndRecord(mailTemp, sendTo, null, content, templeteArr, titleArr);
	}

	@Override
	public void sendMail(String mailTemp, List<String> sendTo, List<String> ccTo, JSONObject content,
			JSONArray templeteArr, JSONArray titleArr) {

		List<String> sendList = new ArrayList<>();
		List<String> ccList = new ArrayList<>();
		// 测试邮件开关开启，重置测试人员，发送测试邮件
		if ("close".equals(mailToRealUser)) {
			sendTo = Arrays.asList(defaultSendTo.split(","));
			ccTo = Arrays.asList(defaultCCTo.split(","));
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
			send(mailTemp, null, new ArrayList<>(), sendList, content, 1, templeteArr, titleArr);
		} else {
			send(mailTemp, null, ccList, sendList, content, 1, templeteArr, titleArr);
		}

	}

	public void send(String templeteCode, List<String> bccTo, List<String> ccTo, List<String> sendTo,
			JSONObject content, int priority, JSONArray templeteArr, JSONArray titleArr) {
		executor.send(templeteCode, bccTo, ccTo, sendTo, content, priority, templeteArr, titleArr);
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
	public void sendRemindMail(String sendTo, String ccTo, String process, String url) {

		JSONObject contentJson = new JSONObject();
		contentJson.put("$node", process);
		contentJson.put("$url", StringUtils.isNotBlank(url) ? url : defaultUrl);

		JSONArray templeteArr = new JSONArray();
		JSONObject tempTempleteJson = new JSONObject();
		tempTempleteJson.put("code", "$system");
		templeteArr.add(tempTempleteJson);

//		JSONArray titleArr = new JSONArray();
//		JSONObject titleJson = new JSONObject();
//		titleJson.put("code", "$title1");
//		titleArr.add(titleJson);		

		sendMailAndRecord(MailTempConst.APPROVALDATA, sendTo, ccTo, contentJson, templeteArr, null);
	}

	@Override
	public void sendRemindMailForWork(String sendTo, String ccTo, String beforeHandler,String process, String url) {

		JSONObject contentJson = new JSONObject();
		contentJson.put("$node", process);
		contentJson.put("$user", beforeHandler);
		contentJson.put("$url", StringUtils.isNotBlank(url) ? url : defaultUrl);

		JSONArray templeteArr = new JSONArray();
		JSONObject tempTempleteJson = new JSONObject();
		tempTempleteJson.put("code", "$system");
		templeteArr.add(tempTempleteJson);
		sendMailAndRecord(MailTempConst.AUTHORIZEWORK, sendTo, ccTo, contentJson, templeteArr, null);
	}
	
	@Override
	public void sendProcessEndMail(String sendTo, String ccTo, String url,String content) {
		JSONObject contentJson = new JSONObject();
		contentJson.put("$url", StringUtils.isNotBlank(url) ? url : endUrl);
		contentJson.put("$content", content);
		JSONArray templeteArr = new JSONArray();
		JSONObject tempTempleteJson = new JSONObject();
		tempTempleteJson.put("code", "$system");
		templeteArr.add(tempTempleteJson);

//		JSONArray titleArr = new JSONArray();
//		JSONObject titleJson = new JSONObject();
//		titleJson.put("code", "$title1");
//		titleArr.add(titleJson);

		sendMailAndRecord(MailTempConst.APPROVALEND, sendTo, ccTo, contentJson, templeteArr, null);
	}

	@Override
	public void sendRemindMailWithEndTime(String sendTo, String ccTo, String process, Date endDate,
			boolean isAbnormalPlan, String url,String type) {

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calMon = Calendar.getInstance();
		calMon.setTime(endDate);
		int maxDay = calMon.getActualMaximum(Calendar.DAY_OF_MONTH);
		calMon.set(Calendar.DAY_OF_MONTH, maxDay);

		JSONObject contentJson = new JSONObject();
		contentJson.put("$node", process);
		contentJson.put("$url", StringUtils.isNotBlank(url) ? url : defaultUrl);
		contentJson.put("$type", type);
		contentJson.put("$endDate", df.format(endDate) + " 24:00:00</br>");
		contentJson.put("$monthEndDate", df.format(calMon.getTime()) + " 24:00:00</br>");

		JSONArray templeteArr = new JSONArray();
		JSONObject tempTempleteJson = new JSONObject();
		tempTempleteJson.put("code", "$system");
		templeteArr.add(tempTempleteJson);

		sendMailAndRecord(MailTempConst.REGULARMAIL, sendTo, ccTo, contentJson, templeteArr, null);
	}

	/**
	 * 不规范邮件
	 * 
	 * @param sendTo
	 * @param ccTo
	 * @param subject 邮件主题
	 * @param process 流程环节名称
	 * @param url     流程链接 ,为空不加超链接
	 */

	@Override
	public void sendNonstandardMail(String sendTo, String ccTo, String process, String url) {
		JSONObject contentJson = new JSONObject();
		contentJson.put("$url", StringUtils.isNotBlank(url) ? url : defaultUrl);

		JSONArray templeteArr = new JSONArray();
		JSONObject tempTempleteJson = new JSONObject();
		tempTempleteJson.put("code", "$system");
		templeteArr.add(tempTempleteJson);

		sendMailAndRecord(MailTempConst.NONSTANDARD, sendTo, ccTo, contentJson, templeteArr, null);
	}

	@Override
	public void sendMailByTemplete(String templeteCode, List<String> bccTo, List<String> ccTo, List<String> sendTo,
			JSONObject content, int priority, JSONArray templeteArr, JSONArray titleArr) {
		try {
			String token = afspTokenService.getEosToken();
			Map<String, String> headers = new HashMap<>();
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

			String result = HttpClientUtil.sendHttpPostJsonWithHeader(afspUrl + mailTempleteUrl, paramJson.toString(),
					headers);
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void sendDeptMgnMail(String sendTo, String ccTo, String process, boolean isAbnormalPlan, int link,
			String url) throws Exception {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		JSONObject contentJson = new JSONObject();
		contentJson.put("$url", StringUtils.isNotBlank(url) ? url : defaultUrl);
		contentJson.put("$node", process);
		if (isAbnormalPlan) {

			contentJson.put("$endDate", df.format(getEndDate(df, link)) + " 24:00:00</br>");
		} else {
			Calendar cal = Calendar.getInstance();
			int maxDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
			cal.set(Calendar.DAY_OF_MONTH, maxDay);

			contentJson.put("$endDate", df.format(cal.getTime()) + " 24:00:00</br>");
		}

		JSONArray templeteArr = new JSONArray();
		JSONObject tempTempleteJson = new JSONObject();
		tempTempleteJson.put("code", "$system");
		templeteArr.add(tempTempleteJson);

		sendMailAndRecord(MailTempConst.DEPTAPPROVALDATA, sendTo, ccTo, contentJson, templeteArr, null);
	}

	private Date getEndDate(SimpleDateFormat df, int link) throws Exception {
		Calendar cal = null;
		cal = Calendar.getInstance();
		Integer month = cal.get(Calendar.MONTH) + 1;
		int startDay = 0, firstLen = 0, secondLen = 0, thirdLen = 0, fourthLen = 0;

		JSONArray approveDate = sysDicInfoService.getJsonArrayDicsByType(DicConst.R_APPROVEDATE, "1");
		JSONObject objStartDay = sysDicInfoService.getDicByTypeAndCode(DicConst.R_STARTDATE, month.toString());
		startDay = objStartDay.getIntValue("dic_value");
		Calendar startCal = null;
		startCal = Calendar.getInstance();
		startCal.set(Calendar.DAY_OF_MONTH, startDay);

		Date workDate = calendarService.getStartDay(startCal.getTime());

		if (workDate == null) {
			throw new Exception("未查询到启动工作日");
		}
		if (new Date().after(df.parse(df.format(workDate)))) {
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
		}

		// 第一环节截止时间
		Date workEndFirst = calendarService.getEndNextDay(workDate, firstLen);
		if (workEndFirst == null) {
			throw new Exception("未查询到结束工作日");
		}

		// 第二环节 规范性审核截止时间
		Date workEndSecond = calendarService.getEndNextDay(workEndFirst, secondLen);
		if (workEndSecond == null) {
			throw new Exception("未查询到结束工作日");
		}
		Date secondEmailDate = calendarService.getEndDay(workEndFirst, secondLen);
		if (secondEmailDate == null) {
			throw new Exception("未查询到结束工作日");
		}
		// 第三环节 三级部门截止时间
		Date workEndThird = calendarService.getEndNextDay(workEndSecond, thirdLen);
		if (workEndThird == null) {
			throw new Exception("未查询到结束工作日");
		}
		Date thirdEmailDate = calendarService.getEndDay(workEndSecond, thirdLen);
		if (thirdEmailDate == null) {
			throw new Exception("未查询到结束工作日");
		}
		// 第四环节 二级部门截止时间
		Date fourthEmailDate = calendarService.getEndDay(workEndThird, fourthLen);
		if (fourthEmailDate == null) {
			throw new Exception("未查询到结束工作日");
		}
		if (link == 2) {
			return secondEmailDate;
		}			
		if (link == 3) {
			return thirdEmailDate;
		} else {
			return fourthEmailDate;
		}
	}

	private Date getStartWorkDate(SimpleDateFormat df) throws Exception {
		Calendar cal = null;
		cal = Calendar.getInstance();
		Integer month = cal.get(Calendar.MONTH) + 1;
		int startDay = 0;

		JSONObject objStartDay = sysDicInfoService.getDicByTypeAndCode(DicConst.R_STARTDATE, month.toString());
		startDay = objStartDay.getIntValue("dic_value");
		Calendar startCal = null;
		startCal = Calendar.getInstance();
		startCal.set(Calendar.DAY_OF_MONTH, startDay);

		Date workDate = calendarService.getStartDay(startCal.getTime());

		if (workDate == null) {
			throw new Exception("未查询到启动工作日");
		}
		return workDate;
		
	}
	
	@Override
	public void sendBudgetRemindMail(String sendTo, String ccTo, String url) throws Exception {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		JSONObject contentJson = new JSONObject();
		contentJson.put("$url", StringUtils.isNotBlank(url) ? url : defaultUrl);
		contentJson.put("$time", df.format(getStartWorkDate(df)));

		JSONArray templeteArr = new JSONArray();
		JSONObject tempTempleteJson = new JSONObject();
		tempTempleteJson.put("code", "$system");
		templeteArr.add(tempTempleteJson);

		sendMailAndRecord(MailTempConst.BUDGETMANAGER, sendTo, ccTo, contentJson, templeteArr, null);
	
	}

	@Override
	public void sendPlanRemindMail(String sendTo, String ccTo, String url) throws Exception {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		JSONObject contentJson = new JSONObject();
		contentJson.put("$url", StringUtils.isNotBlank(url) ? url : defaultUrl);
		contentJson.put("$time", df.format(getStartWorkDate(df)));

		JSONArray templeteArr = new JSONArray();
		JSONObject tempTempleteJson = new JSONObject();
		tempTempleteJson.put("code", "$system");
		templeteArr.add(tempTempleteJson);

		sendMailAndRecord(MailTempConst.PLANREMINDER, sendTo, ccTo, contentJson, templeteArr, null);
	
	}
}
