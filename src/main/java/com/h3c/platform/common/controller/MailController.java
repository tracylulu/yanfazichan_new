package com.h3c.platform.common.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.h3c.platform.annotation.UserLoginToken;
import com.h3c.platform.common.service.MailInfoService;

import io.swagger.annotations.Api;

//@Controller
@RequestMapping("/mail")
@CrossOrigin
@Api(value = "邮件测试接口",tags = {"邮件测试接口"})
public class MailController {
	
	@Value("${defaultMail}")
	private String defaultMail;
	@Autowired
	private MailInfoService  mailInfoService;
	
	@PostMapping("/sendDefaultMail")
	@UserLoginToken	
	public String sendDefaultMail() {
		if("open".equals(defaultMail)) {
			return "测试邮件开关没开";
		}
		//mailInfoService.sendMailAndRecord("", "", "this is  test", "this is test");
		
		return "ok";
	}

}
