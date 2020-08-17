package com.h3c.platform.common.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.h3c.platform.util.AbstractExcelReader;
import com.h3c.platform.annotation.UserLoginToken;
import com.h3c.platform.assetplan.entity.DeptInfo;
import com.h3c.platform.assetplan.service.DeptInfoService;
import com.h3c.platform.common.commonconst.DicConst;
import com.h3c.platform.common.commonconst.LogType;
import com.h3c.platform.common.entity.BudgetEntity;
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
@RequestMapping("/budget")
@Api(value = "预算配置相关", tags = "预算配置相关")
public class BudgetController {
	@Value("${afsp.applicationId}")
	private String applicationId;
	@Autowired
	private SysDicInfoService dicServer;
	@Autowired
	private DeptInfoService deptService;

	@UserLoginToken
	@PostMapping("/list")
	@ApiOperation(value = "获取列表")
	public ResponseResult list(@RequestBody SearchParamEntity param) throws Exception {
		List<JSONObject> lstResultAll = new ArrayList<>();
		JSONArray lst = dicServer.getJSONArrayDicsByType(DicConst.R_BUDGET, "");
		List<DeptInfo> lstDept = deptService.getAll();

		for (int i = 0; i < lst.size(); i++) {
			JSONObject obj = lst.getJSONObject(i);
			obj.put("deptCode", ObjToStrUtil.ReplaceNullValue(obj.get("dic_code")));
			Optional<DeptInfo> temp = lstDept.stream()
					.filter(o -> ObjToStrUtil.ReplaceNullValue(obj.get("dic_code")).equals(o.getDeptCode().toString()))
					.findAny();
			if (temp.isPresent()) {
				obj.put("deptName", temp.get().getDeptName());
			} else {
				obj.put("deptName", "");
			}
			String[] dicNameArr = ObjToStrUtil.ReplaceNullValue(obj.get("dic_value")).split("_");
			obj.put("daoHuo", dicNameArr[0]);
			obj.put("zaiTu", dicNameArr[1]);
			obj.put("budget", dicNameArr[2]);

			obj.put("creater", ObjToStrUtil.ReplaceNullValue(obj.get("creatername")) + " "
					+ ObjToStrUtil.ReplaceNullValue(obj.get("createrempcode")));
			obj.put("last_modifier", ObjToStrUtil.ReplaceNullValue(obj.get("modifiername")) + " "
					+ ObjToStrUtil.ReplaceNullValue(obj.get("modifierempcode")));
			obj.put("create_time", StringUtils.isBlank(ObjToStrUtil.ReplaceNullValue(obj.getString("create_time"))) ? ""
					: obj.getDate("create_time"));
			obj.put("last_modify_time",
					StringUtils.isBlank(ObjToStrUtil.ReplaceNullValue(obj.getString("last_modify_time"))) ? ""
							: obj.getDate("last_modify_time"));
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
		if (fromIndex > count) {
			return ResponseResult.success(0, "查询成功", param.getNum(), count, null, new ArrayList<>());
		}
		List<JSONObject> lstResult = lstResultAll.subList(fromIndex, toIndex);
		return ResponseResult.success(0, "查询成功", param.getNum(), count, null, lstResult);
	}

	@UserLoginToken(logType = LogType.ADD)
	@PostMapping("/add")
	@ApiOperation(value = "新增")
	public ResponseResult add(@RequestBody BudgetEntity entity) throws Exception {
		// 校验部门编码是否重复
		JSONArray lst = dicServer.getJSONArrayDicsByType(DicConst.R_BUDGET, "");
		for (int i = 0; i < lst.size(); i++) {
			JSONObject obj = lst.getJSONObject(i);
			if (entity.getDeptCode().equals(ObjToStrUtil.ReplaceNullValue(obj.get("dic_code")))) {
				return ResponseResult.fail("此部门信息已配置");
			}
		}
		JSONObject model = new JSONObject();

		model.put("dicCode", entity.getDeptCode());
		model.put("dicValue", entity.getDaoHuo() + "_" + entity.getZaiTu() + "_" + entity.getBudget());
		model.put("dicName", entity.getDeptCode());
		model.put("applicationId", applicationId);
		model.put("dicTypeId", DicConst.R_BUDGET);
		model.put("creater", UserUtils.getCurrentDominAccount());
		model.put("lastModifier", UserUtils.getCurrentDominAccount());
		model.put("isAble", entity.getIsAble());

		return dicServer.add(model);
	}

	@UserLoginToken(logType = LogType.MODIFY)
	@PutMapping("/edit")
	@ApiOperation(value = "修改")
	public ResponseResult edit(@RequestBody BudgetEntity entity) throws Exception {
		// 校验部门编码是否重复
		JSONArray lst = dicServer.getJSONArrayDicsByType(DicConst.R_BUDGET, "");
		for (int i = 0; i < lst.size(); i++) {
			JSONObject obj = lst.getJSONObject(i);
			if (entity.getDeptCode().equals(ObjToStrUtil.ReplaceNullValue(obj.get("dic_value")).split("_")[1])
					&& !entity.getId().equals(obj.getInteger("id"))) {
				return ResponseResult.fail("此部门信息已配置");
			}
		}
		JSONObject model = new JSONObject();
		model.put("id", entity.getId());
		model.put("dicCode", entity.getDeptCode());
		model.put("dicValue", entity.getDaoHuo() + "_" + entity.getZaiTu() + "_" + entity.getBudget());
		model.put("dicName", entity.getDeptCode());
		model.put("applicationId", applicationId);
		model.put("dicTypeId", DicConst.R_BUDGET);
		model.put("lastModifier", UserUtils.getCurrentDominAccount());
		model.put("isAble", entity.getIsAble());
		model.put("sortOrder", entity.getSortOrder());
		return dicServer.edit(model);
	}

	@UserLoginToken(logType = LogType.DELETE)
	@PostMapping("/del")
	@ApiOperation(value = "删除")
	public ResponseResult delete(String ids) throws Exception {
		return dicServer.del(ids);
	}

	@UserLoginToken()
	@PostMapping("/getByID")
	@ApiOperation(value = "根据主键获取数据")
	public ResponseResult getByID(Integer id) throws Exception {
		JSONObject model = dicServer.getByID(id);
		model.put("deptCode", ObjToStrUtil.ReplaceNullValue(model.get("dicCode")));
		DeptInfo dept = deptService.getByCode(ObjToStrUtil.ReplaceNullValue(model.get("dicCode")));
		if (dept != null && dept.getDeptCode() != null && dept.getDeptCode() != 0) {
			model.put("deptName", dept.getDeptName());
		} else {
			model.put("deptName", "");
		}
		String[] dicNameArr = ObjToStrUtil.ReplaceNullValue(model.get("dicValue")).split("_");
		model.put("daoHuo", dicNameArr[0]);
		model.put("zaiTu", dicNameArr[1]);
		model.put("budget", dicNameArr[2]);
		model.put("createTime", StringUtils.isBlank(ObjToStrUtil.ReplaceNullValue(model.getString("createTime"))) ? ""
				: model.getDate("createTime"));
		model.put("lastModifyTime",
				StringUtils.isBlank(ObjToStrUtil.ReplaceNullValue(model.getString("lastModifyTime"))) ? ""
						: model.getDate("lastModifyTime"));
		return ResponseResult.success(model);
	}

	@UserLoginToken
	@PostMapping("/import")
	@ApiOperation(value = "导入预算")
	public ResponseResult importBudget(@RequestParam("file") MultipartFile file) throws IOException, Exception {
		StringBuffer errMsg = new StringBuffer();
		int rowIndex = 1;
		String regex = "^\\d+$";
		List<JSONObject> lstAdd = new ArrayList<>();
		List<JSONObject> lstEdit = new ArrayList<>();
		String fileName = file.getOriginalFilename();
		if (fileName.indexOf("\\") > -1) {
			fileName = fileName.substring(fileName.lastIndexOf("\\") + 1);
		}
		AbstractExcelReader excelReader = new AbstractExcelReader(file.getInputStream(), fileName);

		Row rowTitle = excelReader.firstRow();
		String deptTitle = excelReader.readCellValue(rowTitle.getCell(0));
		if (!"部门编码".equals(deptTitle)) {
			return ResponseResult.fail("导入模板不正确！");
		}

		JSONArray lstAll = dicServer.getJSONArrayDicsByType(DicConst.R_BUDGET, "");
		List<DeptInfo> lstDept = deptService.getAll();

		while (excelReader.hasNextRow()) {
			JSONObject dic = new JSONObject();
			Row row = excelReader.nextRow();
			String deptCode = excelReader.readCellValue(row.getCell(0));
			if (StringUtils.isEmpty(deptCode)) {
				errMsg.append("第" + rowIndex + "行，部门编码不能为空！\n");
				rowIndex++;
				continue;
			}

			Optional<DeptInfo> temp = lstDept.stream().filter(o -> deptCode.equals(String.valueOf(o.getDeptCode())))
					.findAny();
			if (!temp.isPresent()) {
				errMsg.append("第" + rowIndex + "行，部门编码不存在！\n");
				rowIndex++;
				continue;
			}else if(!"研发".equals(temp.get().getDeptType())) {
				errMsg.append("第" + rowIndex + "行，部门为非研发部门！\n");
				rowIndex++;
				continue;
			}
			
			String daohuo = excelReader.readCellValue(row.getCell(1));
			String ziatu = excelReader.readCellValue(row.getCell(2));
			String budget = excelReader.readCellValue(row.getCell(3));

			if (!daohuo.matches(regex)) {
				errMsg.append("第" + rowIndex + "行，到货请填写数字！\n");
			}
			if (!ziatu.matches(regex)) {
				errMsg.append("第" + rowIndex + "行，在途请填写数字！\n");
			}
			if (!budget.matches(regex)) {
				errMsg.append("第" + rowIndex + "行，预算请填写数字！\n");
			}

			for (int i = 0; i < lstAll.size(); i++) {
				JSONObject obj = lstAll.getJSONObject(i);
				if (deptCode.equals(ObjToStrUtil.ReplaceNullValue(obj.get("dic_code")))) {
					dic = obj;
					break;
				}
			}

			String dicValue = daohuo + "_" + ziatu + "_" + budget;
			
			dic.put("dicCode", deptCode);
			dic.put("dicValue", dicValue);
			dic.put("dicName", deptCode);			
			dic.put("applicationId", applicationId);
			dic.put("dicTypeId", DicConst.R_BUDGET);
			dic.put("lastModifier", UserUtils.getCurrentDominAccount());						
			dic.put("isAble", 1);
			dic.put("isDeleted", 0);
			if(StringUtils.isNotBlank(ObjToStrUtil.ReplaceNullValue(dic.get("id")))) {
				lstEdit.add(dic);				
			}else {
				dic.put("creater", UserUtils.getCurrentDominAccount());
				lstAdd.add(dic);
			}
		}

		if (StringUtils.isNotBlank(errMsg.toString())) {
			return ResponseResult.fail(errMsg.toString());
		}
		
		//保存
		if(CollectionUtils.isNotEmpty(lstAdd)) {
			dicServer.batchInsert(lstAdd);
		}
		//修改
		if(CollectionUtils.isNotEmpty(lstEdit)) {
			dicServer.batchEdit(lstEdit);
		}

		return ResponseResult.success("导入成功！");
	}
}
