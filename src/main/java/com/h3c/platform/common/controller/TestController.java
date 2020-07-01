package com.h3c.platform.common.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.h3c.platform.common.executor.MailThreadExecutor;

//@Controller
@RequestMapping("/test")
@CrossOrigin
@RestController
public class TestController {

	@Autowired
	private MailThreadExecutor mailThreadExecutor;
	
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
}
