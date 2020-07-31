package com.h3c.platform.common.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.h3c.platform.annotation.UserLoginToken;
import com.h3c.platform.common.commonconst.LogType;
import com.h3c.platform.common.entity.ManufacturerInfo;
import com.h3c.platform.common.entity.ModelInfo;
import com.h3c.platform.common.entity.ModelInfoExt;
import com.h3c.platform.common.service.ManufacturerInfoService;
import com.h3c.platform.common.service.ModelInfoService;
import com.h3c.platform.response.ResponseResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
@RequestMapping("/manufactor")
@Api(value="厂家型号相关配置",tags="厂家型号相关配置")
public class ManufactorController {

	@Autowired
	private ManufacturerInfoService manufacturerInfoService;
	@Autowired
	private ModelInfoService modelInfoService;
	
	@UserLoginToken
	@PostMapping("/list")
	@ApiOperation(value="获取列表")
	public ResponseResult list() throws Exception {
		List<Map<String,Object>> lst=new ArrayList<Map<String,Object>>();
		List<ManufacturerInfo> lstmf = manufacturerInfoService.getManufacturerInfoByName("");
		List<ModelInfo> lstmi = modelInfoService.getAll();

		for (ManufacturerInfo mfInfo : lstmf) {
			Map<String,Object> obj=new HashMap<String, Object>();
			List<ModelInfo> lstChild=lstmi.stream().filter(o -> mfInfo.getId().equals(o.getManufacturerId())).collect(Collectors.toList());
			obj.put("assetmanufacturer", mfInfo);
			obj.put("assetmodel", lstChild);

			lst.add(obj);
		}
		return ResponseResult.success(lst);
	}
	
	@UserLoginToken(logType=LogType.ADD)
	@PostMapping("/addManufacturer")
	@ApiOperation(value="新增厂家")
	public ResponseResult addManufacturer(@RequestBody ManufacturerInfo model) throws Exception {
		
		return manufacturerInfoService.add(model);		
	}
	
	@UserLoginToken(logType=LogType.MODIFY)
	@PutMapping("/editManufacturer")
	@ApiOperation(value="修改厂家")
	public ResponseResult editManufacturer(@RequestBody ManufacturerInfo model) throws Exception {
		
		return manufacturerInfoService.edit(model);
	}
	
	@UserLoginToken()
	@PostMapping("/getByManufacturerID")
	@ApiOperation(value="根据主键获取厂商数据")
	public ResponseResult getByManufacturerID(Integer id) throws Exception {
		
		return ResponseResult.success(manufacturerInfoService.getByPrimaryKey(id));
	}
	
	@UserLoginToken(logType=LogType.ADD)
	@PostMapping("/addModel")
	@ApiOperation(value="新增型号")
	public ResponseResult addModel(@RequestBody ModelInfo model) throws Exception {		
		
		return modelInfoService.add(model);		
	}
	
	@UserLoginToken(logType=LogType.MODIFY)
	@PutMapping("/editModel")
	@ApiOperation(value="修改型号")
	public ResponseResult editModel(@RequestBody ModelInfo model) throws Exception {
		
		return modelInfoService.edit(model);		
	}
	
	@UserLoginToken()
	@PostMapping("/getByMOdelID")
	@ApiOperation(value="根据主键获取型号数据")
	public ResponseResult getByMOdelID(Integer id) throws Exception {

		ModelInfoExt modelExt=new ModelInfoExt();
		ModelInfo info =modelInfoService.getByPrimaryKey(id);
		if(info!=null) {
			ManufacturerInfo maInfo= manufacturerInfoService.getByPrimaryKey(info.getManufacturerId());
			
			modelExt.setCreateTime(info.getCreateTime());
			modelExt.setCreator(info.getCreator());
			modelExt.setDeleteFlag(info.getDeleteFlag());
			modelExt.setId(info.getId());
			modelExt.setManufacturerId(info.getManufacturerId());
			modelExt.setManufacturerName(maInfo.getManufacturerName());
			modelExt.setModifier(info.getModifier());
			modelExt.setModifiTime(info.getModifiTime());
			modelExt.setName(info.getName());
		}
		
		return ResponseResult.success(modelExt);
	}
}
