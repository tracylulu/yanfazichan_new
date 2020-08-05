package com.h3c.platform.common.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.h3c.platform.annotation.UserLoginToken;
import com.h3c.platform.common.commonconst.DicConst;
import com.h3c.platform.common.commonconst.LogType;
import com.h3c.platform.common.entity.AddressEntity;
import com.h3c.platform.common.entity.SearchParamEntity;
import com.h3c.platform.common.entity.SysDicInfo;
import com.h3c.platform.common.service.SysDicInfoService;
import com.h3c.platform.common.util.ObjToStrUtil;
import com.h3c.platform.response.ResponseResult;
import com.h3c.platform.sysmgr.entity.UserInfo;
import com.h3c.platform.sysmgr.service.UserService;
import com.h3c.platform.util.UserUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
@RequestMapping("/approver")
@Api(value="审核人相关配置",tags="审核人相关配置")
public class ApproverController {
	@Value("${afsp.applicationId}")
	private String  applicationId;
	@Autowired
	private SysDicInfoService dicServer;
	@Autowired
	private UserService userService;
	
	@UserLoginToken
	@PostMapping("/list")
	@ApiOperation(value="获取列表")
	public ResponseResult list(@RequestBody SearchParamEntity param ) throws Exception {
		List<JSONObject> lstResultAll=new ArrayList<>();
		JSONArray lstPlanner= dicServer.getJSONArrayDicsByType(DicConst.R_PLANNER,"");
		JSONArray lstOQ= dicServer.getJSONArrayDicsByType(DicConst.R_OQ,"");
		JSONArray lstDept= dicServer.getJSONArrayDicsByType(DicConst.R_FISRTDEPTMGN,"");
		List<UserInfo> lstUser=userService.getAll();
	
		for(int i=0;i<lstPlanner.size();i++) {
			JSONObject obj=lstPlanner.getJSONObject(i);				
			lstResultAll.add(getData(obj,"计划员",lstUser));
		}
		
		for(int i=0;i<lstOQ.size();i++) {
			JSONObject obj=lstOQ.getJSONObject(i);
			lstResultAll.add(getData(obj,"专家团",lstUser));
		}
		
		for(int i=0;i<lstDept.size();i++) {
			JSONObject obj=lstDept.getJSONObject(i);
			lstResultAll.add(getData(obj,"一级主管",lstUser));
		}
		
		Integer count = lstResultAll.size(); // 记录总数	
        Integer pageCount = 0; // 页数
        if (count % param.getSize() == 0) {
            pageCount = count / param.getSize();
        } else {
            pageCount = count / param.getSize() + 1;
        }

        int fromIndex = 0; // 开始索引
        int toIndex = 0; // 结束索引
 
        if (param.getNum() != pageCount) {
            fromIndex = (param.getNum() - 1) * param.getSize();
            toIndex = fromIndex + param.getSize();
        } else {
            fromIndex = (param.getNum() - 1) * param.getSize();
            toIndex = count;
        }
        if(fromIndex > count) {
        	return ResponseResult.success(0, "查询成功", param.getNum(), count, null, new ArrayList<>());
        }
		List<JSONObject> lstResult= lstResultAll.subList(fromIndex, toIndex);
		
		return ResponseResult.success(0, "查询成功", param.getNum(), count, null, lstResult);
	}
	
	private JSONObject getData(JSONObject obj,String name,List<UserInfo> lstUser) {
		obj.put("dic_code", UserUtils.getAccountByCode(lstUser,ObjToStrUtil.ReplaceNullValue(obj.get("dic_code"))));
		obj.put("dic_name", name);
		obj.put("creater",  ObjToStrUtil.ReplaceNullValue(obj.get("creatername"))+" "+ObjToStrUtil.ReplaceNullValue(obj.get("createrempcode")));
		obj.put("last_modifier", ObjToStrUtil.ReplaceNullValue(obj.get("modifiername"))+" "+ObjToStrUtil.ReplaceNullValue(obj.get("modifierempcode")));
		obj.put("create_time",StringUtils.isBlank(ObjToStrUtil.ReplaceNullValue(obj.getString("create_time")))?"": obj.getDate("create_time"));
		obj.put("last_modify_time", StringUtils.isBlank(ObjToStrUtil.ReplaceNullValue(obj.getString("last_modify_time")))?"": obj.getDate("last_modify_time"));
		return obj;
	}
	
	@UserLoginToken(logType=LogType.MODIFY)
	@PutMapping("/edit")
	@ApiOperation(value="修改")
	public ResponseResult edit(@RequestBody SysDicInfo entity) throws Exception {
		String[] nameArr=entity.getDicCode().split(" ");
		UserInfo user=userService.getUserByEmpCode(nameArr[1]);
		if(user==null) {
			return ResponseResult.fail("未找到人员"+entity.getDicCode());
		}
		JSONObject model=new JSONObject();
		model.put("id",  entity.getId());
		model.put("dicCode", user.getEmpCode());
		model.put("dicValue", user.getEmpName());
		model.put("dicName", user.getEmpCode());
		model.put("applicationId",applicationId);
		model.put("dicTypeId", entity.getDicTypeId());
		model.put("lastModifier", UserUtils.getCurrentDominAccount());
		model.put("isAble", entity.getIsAble());
		model.put("sortOrder", entity.getSortOrder());
		return dicServer.edit(model);
	}
	
	@UserLoginToken()
	@PostMapping("/getByID")
	@ApiOperation(value="根据主键获取数据")
	public ResponseResult getByID(Integer id) throws Exception {
		JSONObject model=dicServer.getByID(id);
		UserInfo user=userService.getUserByEmpCode(ObjToStrUtil.ReplaceNullValue(model.get("dicCode")));
		switch (ObjToStrUtil.ReplaceNullValue(model.get("dicTypeId"))) {
		case "R_Planner":
			model.put("dicName", "计划员");	
			break;
		case "R_OQ":
			model.put("dicName", "专家团");	
			break;
		case "R_FisrtDeptMgn":
			model.put("dicName", "一级主管");	
			break;
		}
		if(user!=null) {
			model.put("dicCode", user.getEmpName()+" "+user.getEmpCode());			
		}
		return ResponseResult.success(model);
	}
}
