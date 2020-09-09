package com.h3c.platform.common.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.h3c.platform.annotation.UserLoginToken;
import com.h3c.platform.assetplan.service.DeptInfoService;
import com.h3c.platform.common.commonconst.DicConst;
import com.h3c.platform.common.commonconst.LogType;
import com.h3c.platform.common.entity.CategoryEntity;
import com.h3c.platform.common.entity.SearchParamEntity;
import com.h3c.platform.common.service.SysDicInfoService;
import com.h3c.platform.common.util.ObjToStrUtil;
import com.h3c.platform.response.ResponseResult;
import com.h3c.platform.sysmgr.entity.UserInfo;
import com.h3c.platform.sysmgr.service.UserService;
import com.h3c.platform.util.UserUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@CrossOrigin
@RestController
@RequestMapping("/category")
@Api(value="物品类别和货期配置",tags="物品类别和货期配置")
public class CategoryController {
	@Value("${afsp.applicationId}")
	private String  applicationId;
	@Autowired
	private SysDicInfoService dicServer;
	
	@UserLoginToken
	@PostMapping("/list")
	@ApiOperation(value="获取列表")
	public ResponseResult list(@RequestBody SearchParamEntity param ) throws Exception {
		List<JSONObject> lstResultAll=new ArrayList<>();
		JSONArray lst= dicServer.getJsonArrayDicsByType(DicConst.R_CATEGORY,"");
		lst.sort(Comparator.comparing(obj -> ((JSONObject) obj).getBigInteger("is_able")).reversed().
				thenComparing(Comparator.comparing(obj1 -> ((JSONObject) obj1).getBigInteger("sort_order")).reversed()));
		//lst.sort(Comparator.comparing(obj1 -> ((JSONObject) obj1).getBigInteger("sort_order")).reversed());
		for(int i=0;i<lst.size();i++) {
			JSONObject obj=lst.getJSONObject(i);
		
			String[] dicNameArr=ObjToStrUtil.replaceNullValue(obj.get("dic_value")).split("_");
			obj.put("certifier", dicNameArr[0]);
			obj.put("name", dicNameArr[1]);
			obj.put("category", dicNameArr[2]);
			obj.put("deliveryTime", dicNameArr[3]);
			obj.put("expenseType", dicNameArr[4]);
			obj.put("sort_order",StringUtils.isBlank(ObjToStrUtil.replaceNullValue(obj.get("sort_order")))?"": obj.get("sort_order"));
			obj.put("creater",  ObjToStrUtil.replaceNullValue(obj.get("creatername"))+" "+ObjToStrUtil.replaceNullValue(obj.get("createrempcode")));
			obj.put("last_modifier", ObjToStrUtil.replaceNullValue(obj.get("modifiername"))+" "+ObjToStrUtil.replaceNullValue(obj.get("modifierempcode")));
			obj.put("create_time",StringUtils.isBlank(ObjToStrUtil.replaceNullValue(obj.getString("create_time")))?"": obj.getDate("create_time"));
			obj.put("last_modify_time", StringUtils.isBlank(ObjToStrUtil.replaceNullValue(obj.getString("last_modify_time")))?"": obj.getDate("last_modify_time"));
			lstResultAll.add(obj);
		}
		//lstResultAll.stream().sorted(Comparator.comparing(get("sort_order")).collect(Collectors.toList());
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
        if(fromIndex >= count || count==0) {
        	return ResponseResult.success(0, "查询成功", param.getNum(), count, null, new ArrayList<>());
        }
		List<JSONObject> lstResult= lstResultAll.subList(fromIndex, toIndex);
		return ResponseResult.success(0, "查询成功", param.getNum(), count, null, lstResult);
	}
	
	@UserLoginToken(logType=LogType.ADD)
	@PostMapping("/add")
	@ApiOperation(value="新增")
	public ResponseResult add(@RequestBody CategoryEntity entity) throws Exception {
		JSONArray lst= dicServer.getJsonArrayDicsByType(DicConst.R_CATEGORY,"");
		for (int i = 0; i < lst.size(); i++) {
			JSONObject obj = lst.getJSONObject(i);
			if (entity.getCategory().equals(ObjToStrUtil.replaceNullValue(obj.get("dic_value")).split("_")[2])) {
				return ResponseResult.fail("物品类别配置重复");
			}
		}
		JSONObject model= new JSONObject();
		model.put("dicCode", entity.getDicCode());
		model.put("dicValue", entity.getCertifier()+"_"+entity.getName()+"_"+entity.getCategory()+"_"+entity.getDeliveryTime()+"_"+entity.getExpenseType());
		model.put("dicName", model.get("dicValue"));
		model.put("applicationId",applicationId);
		model.put("dicTypeId", DicConst.R_CATEGORY);
		model.put("creater", UserUtils.getCurrentDominAccount());
		model.put("lastModifier", UserUtils.getCurrentDominAccount());
		model.put("isAble", entity.getIsAble());
		
		return dicServer.add(model);		
	}
	
	@UserLoginToken(logType=LogType.MODIFY)
	@PutMapping("/edit")
	@ApiOperation(value="修改")
	public ResponseResult edit(@RequestBody CategoryEntity entity) throws Exception {
		JSONArray lst= dicServer.getJsonArrayDicsByType(DicConst.R_CATEGORY,"");
		for (int i = 0; i < lst.size(); i++) {
			JSONObject obj = lst.getJSONObject(i);
			if (entity.getCategory().equals(ObjToStrUtil.replaceNullValue(obj.get("dic_value")).split("_")[2])&&!entity.getId().equals(obj.getInteger("id"))) {
				return ResponseResult.fail("物品类别配置重复");
			}
		}
		JSONObject model= new JSONObject();		
		model.put("id",  entity.getId());
		model.put("dicCode", entity.getDicCode());
		model.put("dicValue", entity.getCertifier()+"_"+entity.getName()+"_"+entity.getCategory()+"_"+entity.getDeliveryTime()+"_"+entity.getExpenseType());
		model.put("dicName", model.get("dicValue"));
		model.put("applicationId",applicationId);
		model.put("dicTypeId", DicConst.R_CATEGORY);
		model.put("lastModifier", UserUtils.getCurrentDominAccount());
		model.put("isAble", entity.getIsAble());
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
		JSONObject model=dicServer.getById(id);
		model.put("deptCode", ObjToStrUtil.replaceNullValue(model.get("dicCode")));
		String[] dicNameArr=ObjToStrUtil.replaceNullValue(model.get("dicValue")).split("_");
		model.put("certifier", dicNameArr[0]);
		model.put("name", dicNameArr[1]);
		model.put("category", dicNameArr[2]);
		model.put("deliveryTime", dicNameArr[3]);
		model.put("expenseType", dicNameArr[4]);
		model.put("createTime",StringUtils.isBlank(ObjToStrUtil.replaceNullValue(model.getString("createTime")))?"": model.getDate("createTime"));
		model.put("lastModifyTime", StringUtils.isBlank(ObjToStrUtil.replaceNullValue(model.getString("lastModifyTime")))?"": model.getDate("lastModifyTime"));
		return ResponseResult.success(model);
	}
	
	
	@UserLoginToken()
	@PostMapping("/moveUpOrDown")
	@ApiOperation(value="上移下移功能")
	public ResponseResult moveUpOrDown(@RequestParam @ApiParam(name="id",value="条目id",required=true)Integer id,
			@RequestParam @ApiParam(name="moveId",value="上移1下移2",required=true)Integer moveId) throws Exception {
		JSONObject model=dicServer.getById(id);
		String sort_order = ObjToStrUtil.replaceNullValue(model.get("sortOrder"));
		JSONArray lst= dicServer.getJsonArrayDicsByType(DicConst.R_CATEGORY,"");
		lst.sort(Comparator.comparing(obj -> ((JSONObject) obj).getBigInteger("is_able")).reversed().
				thenComparing(Comparator.comparing(obj1 -> ((JSONObject) obj1).getBigInteger("sort_order")).reversed()));
		Integer flagid=0;
		for(int i=0;i<lst.size();i++) {
			JSONObject obj=lst.getJSONObject(i);
			if(Integer.parseInt(obj.getString("id"))==id) {
				flagid=i;
				break;
			}
		}
		//上移，找到该条的上一个，
		if(moveId==1) {
			if(flagid-1>=0) {
				JSONObject obj=lst.getJSONObject(flagid-1);
				String sort_order_1 = ObjToStrUtil.replaceNullValue(obj.get("sort_order"));
				JSONObject model1= new JSONObject();		
				model1.put("id",  obj.get("id"));
				model1.put("sortOrder", Integer.parseInt(sort_order));
				model1.put("applicationId",applicationId);
				model1.put("dicValue", obj.get("dic_value"));
				model1.put("dicName", obj.get("dic_name"));
				model1.put("lastModifier", UserUtils.getCurrentDominAccount());
				dicServer.edit(model1);
				
				//换下排序字段然后调用修改方法保存原来的对象
				JSONObject model2= new JSONObject();		
				model2.put("id", id);
				model2.put("sortOrder", Integer.parseInt(sort_order_1));
				model2.put("applicationId",applicationId);
				model2.put("dicValue", model.get("dicValue"));
				model2.put("dicName", model.get("dicName"));
				model2.put("lastModifier", UserUtils.getCurrentDominAccount());
				dicServer.edit(model2);
			}else {
				return ResponseResult.success("无法上移");
			}
			
		}else {
			if(flagid+1<lst.size()) {
				//下移，找到该条的下一个,换下排序字段然后调用修改方法
				JSONObject obj2=lst.getJSONObject(flagid+1);
				String sort_order_2 = ObjToStrUtil.replaceNullValue(obj2.get("sort_order"));
				JSONObject model1= new JSONObject();		
				model1.put("id",  obj2.get("id"));
				model1.put("sortOrder", Integer.parseInt(sort_order));
				model1.put("applicationId",applicationId);
				model1.put("dicValue", obj2.get("dic_value"));
				model1.put("dicName", obj2.get("dic_name"));
				model1.put("lastModifier", UserUtils.getCurrentDominAccount());
				dicServer.edit(model1);
				
				//换下排序字段然后调用修改方法保存原来的对象
				JSONObject model2= new JSONObject();		
				model2.put("id", id);
				model2.put("sortOrder", Integer.parseInt(sort_order_2));
				model2.put("applicationId",applicationId);
				model2.put("dicValue", model.get("dicValue"));
				model2.put("dicName", model.get("dicName"));
				model2.put("lastModifier", UserUtils.getCurrentDominAccount());
				dicServer.edit(model2);
			}else {
				return ResponseResult.success("无法下移");
			}
			
		}
		return ResponseResult.success();
	}
}
