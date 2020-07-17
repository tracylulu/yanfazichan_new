package com.h3c.platform.common.controller;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	@RequestMapping("/sentEmail")
	public String sentEmail(){
		List<String> sendTo = new ArrayList<String>();
		sendTo.add("20095");
		List<String> ccTo = new ArrayList<String>();
		ccTo.add("20095");
		String subject = "ls test";
		String content = "lstest";
		mailThreadExecutor.send(sendTo, ccTo, subject, content);
		return "ok";
	}
	
	@RequestMapping("/sendMailByTemplete")
	public String sendMailByTemplete(){
		List<String> sendTo = new ArrayList<String>();
		sendTo.add("20095");
		List<String> ccTo = new ArrayList<String>();
		ccTo.add("20095");
		JSONObject contentJson = new JSONObject();
		contentJson.put("$name", "李晟");
//		contentJson.put("${age}", "100");
		JSONArray templeteArr = new JSONArray();
		JSONObject tempTempleteJson = new JSONObject();
		tempTempleteJson.put("code", "$apa_common_tail");
		templeteArr.add(tempTempleteJson);
		
		JSONArray titleArr = new JSONArray();
		JSONObject titleJson = new JSONObject();
		titleJson.put("code", "$title1");
		titleArr.add(titleJson);
		JSONObject titleJson2 = new JSONObject();
		titleJson2.put("code", "$apa_common_tail");
		titleArr.add(titleJson2);
		this.mailInfoService.sendMailByTemplete("apaEnd", null, ccTo, sendTo, contentJson, 1, templeteArr, titleArr);
		
		return "ok";
	}
}
