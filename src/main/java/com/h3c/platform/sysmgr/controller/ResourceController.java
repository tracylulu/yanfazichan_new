package com.h3c.platform.sysmgr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.h3c.platform.annotation.UserLoginToken;
import com.h3c.platform.response.ResponseResult;
import com.h3c.platform.sysmgr.service.ResourceService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/resource")
@ApiOperation("资源相关")
@Api(value = "资源相关接口",tags = {"资源相关接口"})
public class ResourceController {

	@Autowired
	private ResourceService resourceService;
	
	@UserLoginToken
	@PostMapping("/getCurrentResourceTree")
	@ApiOperation("获取当前用户登录菜单")
	public ResponseResult getCurrentResourceTree() throws Exception{
		return resourceService.getCurrentResourceTree();
	}
}
