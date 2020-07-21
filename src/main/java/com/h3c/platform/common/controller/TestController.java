package com.h3c.platform.common.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.h3c.platform.common.executor.MailThreadExecutor;
import com.h3c.platform.common.service.MailInfoService;

//@Controller
@RequestMapping("/test")
@CrossOrigin
@RestController
public class TestController {

	@Autowired
	private MailThreadExecutor mailThreadExecutor;
	@Autowired
	private MailInfoService mailInfoService;
	
	@PostMapping("/sentEmail")
	public String sentEmail(){
		String sendTo = "lkf7579";
		String ccTo = "";
		mailInfoService.sendProcessEndMail(sendTo, ccTo, "");
		mailInfoService.sendRemindMail(sendTo, ccTo, "三级部门主管审核", "");
		mailInfoService.sendRemindMailWithEndTime(sendTo, ccTo, "三级部门主管审核", new Date(), true, "");
		return "ok";
	}
	
	@PostMapping("/sendMailByTemplete")
	public String sendMailByTemplete(){
		List<String> sendTo = new ArrayList<String>();
		sendTo.add("lkf7579");
		List<String> ccTo = new ArrayList<String>();
		ccTo.add("lkf7579");
		JSONObject contentJson = new JSONObject();
		contentJson.put("$url", "李晟");
//		contentJson.put("${age}", "100");
		JSONArray templeteArr = new JSONArray();
		JSONObject tempTempleteJson = new JSONObject();
		tempTempleteJson.put("code", "$system");
		templeteArr.add(tempTempleteJson);
		
		JSONArray titleArr = new JSONArray();
		JSONObject titleJson = new JSONObject();
		titleJson.put("code", "$title1");
		titleArr.add(titleJson);
		JSONObject titleJson2 = new JSONObject();
		titleJson2.put("code", "$apa_common_tail");
		titleArr.add(titleJson2);
		this.mailInfoService.sendMailByTemplete("ApprovalEnd", null, ccTo, sendTo, contentJson, 1, templeteArr, titleArr);
		
		return "ok";
	}
}
