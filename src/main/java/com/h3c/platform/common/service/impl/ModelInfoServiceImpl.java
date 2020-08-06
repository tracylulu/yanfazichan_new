package com.h3c.platform.common.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.h3c.platform.common.dao.ModelInfoMapper;
import com.h3c.platform.common.entity.ModelInfo;
import com.h3c.platform.common.entity.ModelInfoExample;
import com.h3c.platform.common.service.ModelInfoService;
import com.h3c.platform.response.ResponseResult;
import com.h3c.platform.util.UserUtils;

@Service
public class ModelInfoServiceImpl implements ModelInfoService{

	@Autowired
	private ModelInfoMapper modelInfoMapper;
	
	@Override
	public List<ModelInfo> getAll() throws Exception{
		List<ModelInfo> lst= modelInfoMapper.getAll();
		
		return lst;
	} 
	
	@Override
	@Transactional
	public ResponseResult add(ModelInfo info) throws Exception{
		ModelInfo miCheck=getByNameAndManufacturerID(info.getName(), info.getManufacturerId());
		if(miCheck!=null) {
			return ResponseResult.fail("当前厂商下【"+info.getName()+"】配置重复");
		}
		info.setCreateTime(new Date());
		info.setCreator(UserUtils.getCurrentUserId());
		info.setModifier(UserUtils.getCurrentUserId());
		info.setModifiTime(new Date());
		
		modelInfoMapper.insertSelective(info);
		return ResponseResult.success("添加成功！");
	}
	
	@Override
	@Transactional
	public ResponseResult edit(ModelInfo info) throws Exception{
		ModelInfo miCheck=getByNameAndManufacturerID(info.getName(), info.getManufacturerId());
		if(miCheck!=null&&! info.getId().equals(miCheck.getId())) {
			return ResponseResult.fail("当前厂商下【"+info.getName()+"】配置重复");
		}
		info.setModifier(UserUtils.getCurrentUserId());
		info.setModifiTime(new Date());
		
		modelInfoMapper.updateByPrimaryKeySelective(info);
		return ResponseResult.success("修改成功！");
	}
	
	@Override
	public ModelInfo getByPrimaryKey(Integer id) throws Exception{
		return modelInfoMapper.selectByPrimaryKey(id);
	}
	
	@Override
	@Transactional
	public void DelByManufacturerID(Integer id) {
		modelInfoMapper.delByManufacturerId(id);
	}
	
	private ModelInfo getByNameAndManufacturerID(String name, Integer ManufacturerID) {
		ModelInfoExample example= new ModelInfoExample();
		ModelInfoExample.Criteria cri= example.createCriteria();
		cri.andNameEqualTo(name);
		cri.andManufacturerIdEqualTo(ManufacturerID);
		List<ModelInfo> lst= modelInfoMapper.selectByExample(example);
		if(CollectionUtils.isNotEmpty(lst)) {
			return lst.get(0);
		}
		return null;
	}
}
