package com.h3c.platform.common.service.impl;

import java.util.Date;
import java.util.List;

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
		info.setModifier(UserUtils.getCurrentUserId());
		info.setModifiTime(new Date());
		
		modelInfoMapper.updateByPrimaryKey(info);
		return ResponseResult.success("修改成功！");
	}
	
	@Override
	public ModelInfo getByPrimaryKey(Integer id) throws Exception{
		return modelInfoMapper.selectByPrimaryKey(id);
	}
}
