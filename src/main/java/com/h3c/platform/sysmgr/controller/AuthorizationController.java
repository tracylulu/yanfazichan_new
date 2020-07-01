package com.h3c.platform.sysmgr.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.h3c.platform.annotation.UserLoginToken;
import com.h3c.platform.assetplan.service.DeptInfoService;
import com.h3c.platform.common.commonconst.DicConst;
import com.h3c.platform.common.service.CalendarService;
import com.h3c.platform.common.service.PlanTimeWindowsService;
import com.h3c.platform.common.service.SysDicInfoService;
import com.h3c.platform.common.util.ObjToStrUtil;
import com.h3c.platform.response.ResponseResult;
import com.h3c.platform.sysmgr.service.RoleService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RequestMapping("/authorization")
@RestController
@Api(value="按钮权限控制",tags="按钮权限控制")
@CrossOrigin
public class AuthorizationController {

	@Autowired
	private CalendarService calendarService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private SysDicInfoService sysDicInfoService;
	@Autowired
	private DeptInfoService deptInfoService;
	@Autowired
	private PlanTimeWindowsService planTimeWindowsService;
	
	@GetMapping("/checkButtonIsAdd")
	@UserLoginToken
	@ApiOperation("验证是否可继续添加  true:可以；false:不可以")
	public ResponseResult checkButtonIsAdd() throws Exception{
		if(roleService.checkIsAdmin()) {
			return ResponseResult.success(true);
		}
		if(deptInfoService.checkIsPlanner()) {
			return ResponseResult.success(true);
		}
		
		return ResponseResult.success(planTimeWindowsService.valitSubmitTimeWiondow());
	}
	
}
