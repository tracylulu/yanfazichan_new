package com.h3c.platform.common.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.eos.common.util.Result;
import com.google.gson.JsonParser;
import com.h3c.platform.annotation.UserLoginToken;
import com.h3c.platform.common.entity.EosSearchParamEntity;
import com.h3c.platform.common.entity.SearchParamEntity;
import com.h3c.platform.common.entity.SysDicInfo;
import com.h3c.platform.common.service.SysDicInfoService;
import com.h3c.platform.common.util.HttpClientUtil;
import com.h3c.platform.response.ResponseResult;
import com.h3c.platform.util.UserUtils;

@Controller
@RequestMapping("/dic")
@CrossOrigin
@Api(value = "数据字典相关接口", tags = { "数据字典相关接口" })
public class SysDicInfoController {

	private static final Logger logger = LoggerFactory.getLogger(SysDicInfoController.class);

	@Autowired
	private SysDicInfoService sysDicInfoService;

	@UserLoginToken
	@ApiOperation(value = "根据类型从afsp获取字典集合")
	@GetMapping("/getDicsByType")
	@ResponseBody
	public ResponseResult getDicsByType(String type) throws Exception {
		return sysDicInfoService.getDicsByType(type);
	}

	@UserLoginToken
	@ApiOperation(value = "根据编码获取单个字典")
	@GetMapping("/getDicsBycode")
	@ResponseBody
	public ResponseResult getDicsBycode(String code) throws Exception {
		return sysDicInfoService.getDicsBycode(code);
	}


//	@UserLoginToken
//	@ApiOperation(value = "根据类型从afsp获取字典集合")
//	@GetMapping("/getColumn")
//	@ResponseBody
//	public List<Map<String, Object>> getColumn() throws Exception {
//		return sysDicInfoService.getColumn("AssetPlanInfoApplyView");
//	}
//	
//	@UserLoginToken
//	@GetMapping("/getManuAndModel")
//	@ResponseBody
//	public List<JSONObject> getManuAndModel(String name) throws Exception {
//		return sysDicInfoService.getManuAndModel(name);
//	}
}
