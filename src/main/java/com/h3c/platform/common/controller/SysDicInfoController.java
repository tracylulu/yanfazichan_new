package com.h3c.platform.common.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.h3c.platform.annotation.UserLoginToken;
import com.h3c.platform.common.commonconst.DicConst;
import com.h3c.platform.common.commonconst.LogType;
import com.h3c.platform.common.entity.SearchParamEntity;
import com.h3c.platform.common.entity.SysDicInfo;
import com.h3c.platform.common.service.SysDicInfoService;
import com.h3c.platform.common.util.ObjToStrUtil;
import com.h3c.platform.response.ResponseResult;
import com.h3c.platform.sysmgr.entity.UserInfo;
import com.h3c.platform.sysmgr.service.UserService;
import com.h3c.platform.util.UserUtils;

@RestController
@RequestMapping("/dic")
@CrossOrigin
@Api(value = "数据字典相关接口", tags = { "数据字典相关接口" })
public class SysDicInfoController {

	private static final Logger logger = LoggerFactory.getLogger(SysDicInfoController.class);

	@Value("${afsp.applicationId}") 
	private String  applicationId;
	@Autowired
	private SysDicInfoService sysDicInfoService;
	@Autowired
	private UserService userService;

	@UserLoginToken
	@ApiOperation(value = "根据类型从afsp获取字典集合")
	@GetMapping("/getDicsByType")	
	public ResponseResult getDicsByType(String type) throws Exception {
		return sysDicInfoService.getDicsByType(type);
	}

	@UserLoginToken
	@ApiOperation(value = "根据编码获取单个字典")
	@GetMapping("/getDicsBycode")	
	public ResponseResult getDicsBycode(String code) throws Exception {
		return sysDicInfoService.getDicsBycode(code);
	}
	
	@UserLoginToken
	@ApiOperation(value = "获取首页物料信息")
	@GetMapping("/getMateriel")	
	public ResponseResult getMateriel() throws Exception {
		return sysDicInfoService.getDicsByType(DicConst.R_MATERIEL);
	}
	
	@UserLoginToken
	@PostMapping("/list")
	@ApiOperation(value="获取列表")	
	public ResponseResult list(@RequestBody SearchParamEntity param ) throws Exception {
		List<JSONObject> lstResultAll=new ArrayList<>();
		JSONArray lst= sysDicInfoService.getJSONArrayDicsByType(param.getSearchParam(),"");
		
		//List<UserInfo> lstUser=userService.getAll();
		for(int i=0;i<lst.size();i++) {
			JSONObject obj=lst.getJSONObject(i);

			obj.put("creater",  ObjToStrUtil.ReplaceNullValue(obj.get("creatername"))+" "+ObjToStrUtil.ReplaceNullValue(obj.get("createrempcode")));
			obj.put("last_modifier", ObjToStrUtil.ReplaceNullValue(obj.get("modifiername"))+" "+ObjToStrUtil.ReplaceNullValue(obj.get("modifierempcode")));
			obj.put("create_time",StringUtils.isBlank(ObjToStrUtil.ReplaceNullValue(obj.getString("create_time")))?"": obj.getDate("create_time"));
			obj.put("last_modify_time", StringUtils.isBlank(ObjToStrUtil.ReplaceNullValue(obj.getString("last_modify_time")))?"": obj.getDate("last_modify_time"));
			lstResultAll.add(obj);
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

        if (!param.getNum().equals(pageCount)) {
            fromIndex = (param.getNum() - 1) * param.getSize();
            toIndex = fromIndex + param.getSize();
        } else {
            fromIndex = (param.getNum() - 1) * param.getSize();
            toIndex = count;
        }
		if (fromIndex >= count || count == 0) {
        	return ResponseResult.success(0, "查询成功", param.getNum(), count, null, new ArrayList<>());
        }
		List<JSONObject> lstResult= lstResultAll.subList(fromIndex, toIndex);
		return ResponseResult.success(0, "查询成功", param.getNum(), count, null, lstResult);
	}
	
	@UserLoginToken(logType=LogType.ADD)
	@PostMapping("/add")
	@ApiOperation(value="新增")
	public ResponseResult add(@RequestBody SysDicInfo model) throws Exception {		
		//JSONObject json=new JSONObject();
		model.setApplicationId(applicationId);
		model.setCreater(UserUtils.getCurrentDominAccount());
		model.setLastModifier(UserUtils.getCurrentDominAccount());

		return sysDicInfoService.add(JSON.parseObject(JSON.toJSONString(model)));		
	}
	
	@UserLoginToken(logType=LogType.MODIFY)
	@PutMapping("/edit")
	@ApiOperation(value="修改")
	public ResponseResult edit(@RequestBody SysDicInfo model) throws Exception {
		//JSONObject json=new JSONObject();
		model.setApplicationId(applicationId);
		model.setLastModifier(UserUtils.getCurrentDominAccount());
		return sysDicInfoService.edit(JSON.parseObject(JSON.toJSONString(model)));
	}

	@UserLoginToken(logType=LogType.DELETE)
	@PostMapping("/del")
	@ApiOperation(value="删除")
	public ResponseResult delete(String ids) throws Exception {
		return sysDicInfoService.del(ids);
	}
	
	@UserLoginToken()
	@PostMapping("/getByID")
	@ApiOperation(value="根据主键获取数据")
	public ResponseResult getByID(Integer id) throws Exception {
		JSONObject model=sysDicInfoService.getByID(id);	
		model.put("createTime",StringUtils.isBlank(ObjToStrUtil.ReplaceNullValue(model.getString("createTime")))?"": model.getDate("createTime"));
		model.put("lastModifyTime", StringUtils.isBlank(ObjToStrUtil.ReplaceNullValue(model.getString("lastModifyTime")))?"": model.getDate("lastModifyTime"));
		return ResponseResult.success(model);
	}
}
