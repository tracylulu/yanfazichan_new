package com.h3c.platform.sysmgr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.h3c.platform.annotation.UserLoginToken;
import com.h3c.platform.response.ResponseResult;
import com.h3c.platform.sysmgr.service.RoleService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/role")
@ApiOperation("角色相关")
@Api(value = "角色相关接口",tags = {"角色相关接口"})
public class RoleController {
	@Autowired
	private RoleService roleService;

	@UserLoginToken
	@GetMapping("/getRoleByUser")
	@ApiOperation(value="根据用户编码获取用户角色")
	public ResponseResult getRoleByUser(String userCode) throws Exception {
		return roleService.getRoleByUser(userCode);		
	}
	
	@GetMapping("/checkIsAdmin")
	@UserLoginToken
	@ApiOperation("验证是否管理员")
	public ResponseResult checkIsAdmin() throws Exception{
		return ResponseResult.success(roleService.checkIsAdmin());
	}
}
