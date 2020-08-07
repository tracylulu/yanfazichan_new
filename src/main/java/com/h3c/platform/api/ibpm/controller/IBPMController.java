package com.h3c.platform.api.ibpm.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.h3c.platform.api.ibpm.entity.IBPMEntity;
import com.h3c.platform.assetplan.entity.AssetPlanInfo;
import com.h3c.platform.assetplan.entity.DeptInfo;
import com.h3c.platform.assetplan.entity.ProjectInfo;
import com.h3c.platform.assetplan.service.AssetPlanInfoService;
import com.h3c.platform.assetplan.service.BPMRelationInfoService;
import com.h3c.platform.assetplan.service.DeptInfoService;
import com.h3c.platform.assetplan.service.ProjectInfoService;
import com.h3c.platform.common.commonconst.DicConst;
import com.h3c.platform.common.service.SysDicInfoService;
import com.h3c.platform.common.util.ObjToStrUtil;
import com.h3c.platform.response.ResponseResult;
import com.h3c.platform.sysmgr.entity.UserInfo;
import com.h3c.platform.sysmgr.service.RoleService;
import com.h3c.platform.sysmgr.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
@RequestMapping("/api/ibpm")
@Api(value = "ibpm相关接口", tags = "ibpm相关接口")
public class IBPMController {
	@Autowired
	private DeptInfoService deptService;
	@Autowired
	private AssetPlanInfoService assetPlanService;
	@Autowired
	private ProjectInfoService projectInfoService;
	@Autowired
	private UserService userService;
	@Autowired
	private BPMRelationInfoService bpmRelationInfoService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private SysDicInfoService dicServer;

	@PostMapping("/unSoft")
	@ApiOperation("非软件类")
	public ResponseResult unSoft(@RequestBody IBPMEntity entity) throws Exception {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Map<String, Object> result = new HashMap<String, Object>();
		
		// 验证管理员
		if (!roleService.checkIsAdmin(entity.getUserCode())) {
			ResponseResult.fail("当前人员没有权限处理此单据！");
		}
		// 查询数据
		List<AssetPlanInfo> lst = assetPlanService.selectByIDs(Arrays.asList(entity.getIamplanID().split(",")));
		List<AssetPlanInfo> lstTemp= lst.stream().filter(o->!"0".equals(o.getApstage())).collect(Collectors.toList());
		if(CollectionUtils.isNotEmpty(lstTemp)) {
			ResponseResult.fail("当前勾选单据包含未结束流程！");
		}
		
		JSONArray lstAddr= dicServer.getJSONArrayDicsByType(DicConst.R_ADDRESS,"");
		JSONArray lstCategory= dicServer.getJSONArrayDicsByType(DicConst.R_CATEGORY,"");

		List<ProjectInfo> lstPro = projectInfoService.getAll();
		// 拼接数据
		List<Map<String, Object>> lstDetails = new ArrayList<Map<String, Object>>();
		for (AssetPlanInfo info : lst) {
			Map<String, Object> detail = new HashMap<String, Object>();
			detail.put("assetName", info.getAssetname());
			detail.put("manufacturerModel", info.getAssetmanufacturer() + info.getAssetmodel());
			detail.put("requireds", info.getRequiredsaudit());
			detail.put("itemCode", info.getItemcode());
			Optional<ProjectInfo> tempPro = lstPro.stream().filter(o -> info.getItemcode().equals(o.getProjectNo()))
					.findAny();
			detail.put("itemName", tempPro.isPresent() ? tempPro.get().getProjectName() : "");
			detail.put("requiredUser", info.getRequireduser());
			detail.put("category",  getCategory(lstCategory, info.getAssetcategory()));
			detail.put("reqArrivalDate", df.format(info.getReqarrivaldate()));
			detail.put("receiverPlace", getAddr(lstAddr, info.getReceiverplace()));
			detail.put("note", info.getAssetnote());

			lstDetails.add(detail);
		}

		if (CollectionUtils.isNotEmpty(lst)) {
			Map<String, Object> title = new HashMap<String, Object>();
			title.put("applyUser", lst.get(0).getApplyuser());
			title.put("deptCode", getCoaCode(entity.getUserCode()));
			title.put("planner",  getPlanner(entity.getUserCode()));
			result.put("title", title);
		}

		result.put("detail", lstDetails);
		return ResponseResult.success(result,"查询成功");
	}

	@PostMapping("/soft")
	@ApiOperation("软件类")
	public ResponseResult soft(@RequestBody IBPMEntity entity) throws Exception {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		// 验证管理员
		if (!roleService.checkIsAdmin(entity.getUserCode())) {
			ResponseResult.fail("当前人员没有权限处理此单据！");
		}
		Map<String, Object> result = new HashMap<String, Object>();
		// 查询数据
		List<AssetPlanInfo> lst = assetPlanService.selectByIDs(Arrays.asList(entity.getIamplanID().split(",")));
		JSONArray lstAddr= dicServer.getJSONArrayDicsByType(DicConst.R_ADDRESS,"");
		List<AssetPlanInfo> lstTemp= lst.stream().filter(o->!"0".equals(o.getApstage())).collect(Collectors.toList());
		if(CollectionUtils.isNotEmpty(lstTemp)) {
			ResponseResult.fail("当前勾选单据包含未结束流程！");
		}
		List<ProjectInfo> lstPro = projectInfoService.getAll();
		// 拼接数据
		List<Map<String, Object>> lstDetails = new ArrayList<Map<String, Object>>();
		for (AssetPlanInfo info : lst) {
			Map<String, Object> detail = new HashMap<String, Object>();
			detail.put("assetName", info.getAssetname());
			detail.put("itemCode", info.getItemcode());
			Optional<ProjectInfo> tempPro = lstPro.stream().filter(o -> info.getItemcode().equals(o.getProjectNo()))
					.findAny();
			detail.put("itemName", tempPro.isPresent() ? tempPro.get().getProjectName() : "");
			detail.put("manufacturer", info.getAssetmanufacturer());
			detail.put("model", info.getAssetmodel());
			detail.put("price", info.getPprice());
			detail.put("requireds", info.getRequiredsaudit());
			detail.put("reqArrivalDate", df.format(info.getReqarrivaldate()));
			detail.put("startTime", df.format(info.getReqarrivaldate()));
			Calendar cal = Calendar.getInstance();

			cal.setTime(info.getReqarrivaldate());
			cal.add(Calendar.YEAR, 1);
			detail.put("endTime", df.format(cal.getTime()));
			detail.put("receiverPlace", getAddr(lstAddr, info.getReceiverplace()));
			detail.put("requiredUser", info.getRequireduser());
			detail.put("purpose", info.getPurpose());
			detail.put("note", info.getAssetnote());

			lstDetails.add(detail);
		}

		if (CollectionUtils.isNotEmpty(lst)) {
			Map<String, Object> title = new HashMap<String, Object>();
			// title.put("applyUser", lst.get(0).getApplyuser());
			title.put("deptCode", getCoaCode(entity.getUserCode()));
			title.put("planner", getPlanner(entity.getUserCode()));
			result.put("title", title);
		}

		result.put("detail", lstDetails);
		return ResponseResult.success(result,"查询成功");
	}

	private String getCoaCode(String userCode) throws Exception {
		String coa = "";
		UserInfo user = userService.getUserByEmpCode(userCode);
		if (user == null) {
			throw new Exception("未找到当前人员");
		}
		DeptInfo dept = deptService.getByCode(user.getDeptCode());

		if (dept == null||StringUtils.isBlank(user.getDeptCode())) {
			return "";
		}

		if (StringUtils.isNotBlank(dept.getCoa())
				&& ("2".equals(dept.getDeptLevel()) || "3".equals(dept.getDeptLevel()))) {
			coa = dept.getCoa();
		} else if (StringUtils.isBlank(dept.getCoa()) && "3".equals(dept.getDeptLevel())) {
			DeptInfo deptPareat = deptService.getByCode(dept.getSupDeptCode());
			if(deptPareat!=null) {
				coa= deptPareat.getCoa();
			}
		}

		return coa;
	}
	
	private String getPlanner(String userCode) throws Exception {
		String palnner = "";
		UserInfo user = userService.getUserByEmpCode(userCode);
		if (user == null) {
			throw new Exception("未找到当前人员");
		}
		DeptInfo dept = deptService.getByCode(user.getDeptCode());

		if (dept == null||StringUtils.isBlank(user.getDeptCode())) {
			return "";
		}
		if(StringUtils.isNotBlank(dept.getDeptPlannerCode())) {
			return dept.getDeptPlannerCode(); 
		}
		
		String parentDept=dept.getSupDeptCode();
		String level=dept.getDeptLevel();
		while (StringUtils.isNotBlank(palnner)) {			
			if("1".equals(level)) break;
			DeptInfo deptPareat = deptService.getByCode(parentDept);
			if(deptPareat==null) break;
			
			parentDept=deptPareat.getSupDeptCode();
			level = deptPareat.getDeptLevel();
			if(StringUtils.isNotBlank(deptPareat.getDeptPlannerCode())) {
				palnner = deptPareat.getDeptPlannerCode(); 
				break;
			}
		}		
	
		return palnner;
	}
	
	private String getAddr(JSONArray lstAddr,String addrCode) {
		String place="";
		for(int i=0;i<lstAddr.size();i++) {
			JSONObject obj = lstAddr.getJSONObject(i);
			
			if(addrCode.equals(ObjToStrUtil.ReplaceNullValue(obj.get("dic_code"))) ) {
				String[] addrArr= obj.getString("dic_value").split("_");
				place=addrArr[1];
				
				break;
			}
		}
		
		return "W10_XZ"+place;
	}
	
	private String getCategory(JSONArray lst,String code) {
		String category="";
		for(int i=0;i<lst.size();i++) {
			JSONObject obj = lst.getJSONObject(i);
			
			if(code.equals(ObjToStrUtil.ReplaceNullValue(obj.get("dic_code"))) ) {
				String[] addrArr= obj.getString("dic_value").split("_");
				category=addrArr[2];
				
				break;
			}
		}
		
		return category;
	}

	@PostMapping("/writeBpmCode")
	@ApiOperation("写入bpm编码")
	public ResponseResult writeBmpCode(@RequestBody IBPMEntity entity)throws Exception {		
		boolean isSuccess = isSuccess = bpmRelationInfoService.writeBpmCode(entity);
		
		return ResponseResult.success("写入成功");
	}

}
