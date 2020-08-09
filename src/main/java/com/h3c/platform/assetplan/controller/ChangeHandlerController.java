package com.h3c.platform.assetplan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.h3c.platform.annotation.UserLoginToken;
import com.h3c.platform.assetplan.entity.SearchAssetParamEntity;
import com.h3c.platform.assetplan.service.ChangeHandlerService;
import com.h3c.platform.response.ResponseResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/process")
@Api(value="转单相关", tags="转单相关")
public class ChangeHandlerController {

	@Autowired
	private ChangeHandlerService changeHandlerService;
	
	@UserLoginToken
	@PostMapping("/changeHandler")
	@ApiOperation("当前处理人转单")
	public ResponseResult changeHandler(@RequestParam String handler,@RequestParam String apstage,@RequestParam String applymonth,@RequestParam String newHandler)throws Exception {
		
		return changeHandlerService.changeHandler(handler, apstage, applymonth, newHandler);
	}
	
	@UserLoginToken
	@PostMapping("/list")
	@ApiOperation("系统管理员转单列表")
	public  ResponseResult list(String userCode,Integer pageSize,Integer pageNum) throws Exception{
		return changeHandlerService.list(userCode, pageSize, pageNum);
	}
	
	@UserLoginToken
	@PostMapping("/adminChangeHandler")
	@ApiOperation("系统管理员转单")
	public ResponseResult changeHandlerByAdmin(@RequestParam String handler,@RequestParam String apstage,@RequestParam String newHandler)throws Exception{
		
		return changeHandlerService.changeHandler(handler, apstage, "", newHandler);
	}
}
