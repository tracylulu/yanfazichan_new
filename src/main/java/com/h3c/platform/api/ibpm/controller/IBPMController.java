package com.h3c.platform.api.ibpm.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
import com.h3c.platform.sysmgr.entity.UserInfo;
import com.h3c.platform.sysmgr.service.RoleService;
import com.h3c.platform.sysmgr.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
@RequestMapping("/api/ibmp")
@Api(value = "ibmp相关接口", tags = "ibmp相关接口")
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
	public Map<String, Object> unSoft(@RequestBody IBPMEntity entity) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();

		// 验证管理员
		if (!roleService.checkIsAdmin(entity.getUserCode())) {
			throw new Exception("当前人员没有权限处理此单据！");
		}
		// 查询数据
		List<AssetPlanInfo> lst = assetPlanService.selectByIDs(Arrays.asList(entity.getIamplanID().split(",")));
		
		JSONArray lstAddr= dicServer.getJSONArrayDicsByType(DicConst.R_ADDRESS,"");
		JSONArray lstCategory= dicServer.getJSONArrayDicsByType(DicConst.R_CATEGORY,"");

		List<ProjectInfo> lstPro = projectInfoService.getAll();
		// 拼接数据
		List<Map<String, Object>> lstDetails = new ArrayList<Map<String, Object>>();
		for (AssetPlanInfo info : lst) {
			Map<String, Object> detail = new HashMap<String, Object>();
			detail.put("assetName", info.getAssetname());
			detail.put("manufacturerModel", info.getAssetmanufacturer() + info.getAssetmodel());
			detail.put("requireds", info.getRequireds());
			detail.put("itemCode", info.getItemcode());
			Optional<ProjectInfo> tempPro = lstPro.stream().filter(o -> info.getItemcode().equals(o.getProjectNo()))
					.findAny();
			detail.put("itemName", tempPro.isPresent() ? tempPro.get().getProjectName() : "");
			detail.put("requiredUser", info.getRequireduser());
			detail.put("category",  getCategory(lstCategory, info.getAssetcategory()));
			detail.put("reqArrivalDate", info.getReqarrivaldate());
			detail.put("receiverPlace", getAddr(lstAddr, info.getReceiverplace()));
			detail.put("note", info.getAssetnote());

			lstDetails.add(detail);
		}

		if (CollectionUtils.isNotEmpty(lst)) {
			Map<String, Object> title = new HashMap<String, Object>();
			title.put("applyUser", lst.get(0).getApplyuser());
			title.put("deptCode", getCoaCode(entity.getUserCode()));
			title.put("planner", lst.get(0).getPlanner());
			result.put("title", title);
		}

		result.put("detail", lstDetails);
		return result;
	}

	@PostMapping("/soft")
	@ApiOperation("软件类")
	public Map<String, Object> soft(@RequestBody IBPMEntity entity) throws Exception {
		// 验证管理员
		if (!roleService.checkIsAdmin(entity.getUserCode())) {
			throw new Exception("当前登录人没有权限处理此单据！");
		}
		Map<String, Object> result = new HashMap<String, Object>();
		// 查询数据
		List<AssetPlanInfo> lst = assetPlanService.selectByIDs(Arrays.asList(entity.getIamplanID().split(",")));
		JSONArray lstAddr= dicServer.getJSONArrayDicsByType(DicConst.R_ADDRESS,"");

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
			detail.put("requireds", info.getRequireds());
			detail.put("reqArrivalDate", info.getReqarrivaldate());
			detail.put("startTime", info.getReqarrivaldate());
			Calendar cal = Calendar.getInstance();

			cal.setTime(info.getReqarrivaldate());
			cal.add(Calendar.YEAR, 1);
			detail.put("endTime", cal.getTime());
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
			title.put("planner", lst.get(0).getPlanner());
			result.put("title", title);
		}

		result.put("detail", lstDetails);
		return result;
	}

	private String getCoaCode(String userCode) throws Exception {
		String coa = "";
		UserInfo user = userService.getUserByEmpCode(userCode);
		if (user == null) {
			throw new Exception("未找到当前人员");
		}
		DeptInfo dept = deptService.getByCode(user.getDeptCode());

		if (dept == null) {
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
		String place="";
		for(int i=0;i<lst.size();i++) {
			JSONObject obj = lst.getJSONObject(i);
			
			if(code.equals(ObjToStrUtil.ReplaceNullValue(obj.get("dic_code"))) ) {
				String[] addrArr= obj.getString("dic_value").split("_");
				place=addrArr[2];
				
				break;
			}
		}
		
		return "W10_XZ"+place;
	}

	@PostMapping("/writeBpmCode")
	@ApiOperation("写入bpm编码")
	public Map<String, Object> writeBmpCode(@RequestBody IBPMEntity entity) {
		boolean isSuccess = false;
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			isSuccess = bpmRelationInfoService.writeBpmCode(entity);
		} catch (Exception e) {
			result.put("code", 500);
			result.put("message", e.getMessage());
		}
		if (isSuccess) {
			result.put("code", 200);
			result.put("message", "成功");
		}
		return result;
	}

}
