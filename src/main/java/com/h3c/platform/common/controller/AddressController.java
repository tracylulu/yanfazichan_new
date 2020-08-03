package com.h3c.platform.common.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.PropertyFilter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.h3c.platform.annotation.UserLoginToken;
import com.h3c.platform.assetplan.entity.DeptInfo;
import com.h3c.platform.assetplan.service.DeptInfoService;
import com.h3c.platform.common.commonconst.DicConst;
import com.h3c.platform.common.commonconst.LogType;
import com.h3c.platform.common.entity.AddressEntity;
import com.h3c.platform.common.entity.SearchParamEntity;
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
@RequestMapping("/addr")
@Api(value="到货地点相关配置",tags="到货地点相关配置")
public class AddressController {
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
		JSONArray lst= dicServer.getJSONArrayDicsByType(DicConst.R_ADDRESS,"");
	
		for(int i=0;i<lst.size();i++) {
			JSONObject obj=lst.getJSONObject(i);
			obj.put("dicCode", ObjToStrUtil.ReplaceNullValue(obj.get("dic_code")));			
			
			String[] dicNameArr=ObjToStrUtil.ReplaceNullValue(obj.get("dic_value")).split("_");
			obj.put("consignee", dicNameArr[0]);
			obj.put("place", dicNameArr[1]);
			obj.put("detail", dicNameArr[2]);
			if(dicNameArr.length==4) {
				obj.put("approver", dicNameArr[3]);
			}else {
				obj.put("approver", "");
			}
			
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
	
	@UserLoginToken(logType=LogType.ADD)
	@PostMapping("/add")
	@ApiOperation(value="新增")
	public ResponseResult add(@RequestBody AddressEntity entity) throws Exception {	
		JSONObject model=new JSONObject();
		model.put("dicCode", entity.getDicCode());
		model.put("dicValue", entity.getConsignee()+"_"+entity.getPlace()+"_"+entity.getDetail()+"_"+entity.getApprover());
		model.put("dicName", entity.getDicCode());
		model.put("applicationId",applicationId);
		model.put("dicTypeId", DicConst.R_ADDRESS);
		model.put("creater", UserUtils.getCurrentDominAccount());
		model.put("lastModifier", UserUtils.getCurrentDominAccount());
		model.put("isAble", entity.getIsAble());
		
		return dicServer.add(model);		
	}
	
	@UserLoginToken(logType=LogType.MODIFY)
	@PutMapping("/edit")
	@ApiOperation(value="修改")
	public ResponseResult edit(@RequestBody AddressEntity entity) throws Exception {		
		JSONObject model=new JSONObject();
		model.put("id",  entity.getId());
		model.put("dicCode", entity.getDicCode());
		model.put("dicValue", entity.getConsignee()+"_"+entity.getPlace()+"_"+entity.getDetail()+"_"+entity.getApprover());
		model.put("dicName", entity.getDicCode());
		model.put("applicationId",applicationId);
		model.put("dicTypeId", DicConst.R_ADDRESS);		
		model.put("lastModifier", UserUtils.getCurrentDominAccount());
		model.put("isAble", entity.getIsAble());
		model.put("sortOrder", entity.getSortOrder());
		return dicServer.edit(model);
	}

	@UserLoginToken(logType=LogType.DELETE)
	@PostMapping("/del")
	@ApiOperation(value="删除")
	public ResponseResult delete(String ids) throws Exception {
		return dicServer.del(ids);
	}
	
	@UserLoginToken()
	@PostMapping("/getByID")
	@ApiOperation(value="根据主键获取数据")
	public ResponseResult getByID(Integer id) throws Exception {
		JSONObject model=dicServer.getByID(id);
	
		String[] dicNameArr=ObjToStrUtil.ReplaceNullValue(model.get("dicValue")).split("_");
		model.put("consignee", dicNameArr[0]);
		model.put("place", dicNameArr[1]);
		model.put("detail", dicNameArr[2]);
		if(dicNameArr.length==4) {
			model.put("approver", dicNameArr[3]);
		}else {
			model.put("approver", "");
		}
		model.put("createTime",StringUtils.isBlank(ObjToStrUtil.ReplaceNullValue(model.getString("createTime")))?"": model.getDate("createTime"));
		model.put("lastModifyTime", StringUtils.isBlank(ObjToStrUtil.ReplaceNullValue(model.getString("lastModifyTime")))?"": model.getDate("lastModifyTime"));
		return ResponseResult.success(model);
	}
}
