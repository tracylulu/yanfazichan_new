package com.h3c.platform.common.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.catalina.User;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.h3c.platform.common.dao.ManufacturerInfoMapper;
import com.h3c.platform.common.entity.ManufacturerInfo;
import com.h3c.platform.common.entity.ManufacturerInfoExample;
import com.h3c.platform.common.entity.ModelInfo;
import com.h3c.platform.common.service.ManufacturerInfoService;
import com.h3c.platform.common.service.ModelInfoService;
import com.h3c.platform.response.ResponseResult;
import com.h3c.platform.sysmgr.service.UserService;
import com.h3c.platform.util.UserUtils;

@Service
public class ManufacturerInfoServiceImpl implements ManufacturerInfoService {

	@Autowired
	private ManufacturerInfoMapper manufacturerInfoMapper;
	@Autowired
	private UserService userService;
	@Autowired
	private ModelInfoService modelInfoService;
	
	@Override
	public 	List<ManufacturerInfo> getManufacturerInfoByName(String name) {
		return manufacturerInfoMapper.getManufacturerInfoByName(name);
	}
	
	@Override
	public 	List<ManufacturerInfo> getAll() throws Exception {
		return manufacturerInfoMapper.getAll();
	}
	
	@Override
	@Transactional
    public ResponseResult add(ManufacturerInfo info)throws Exception{	
		ManufacturerInfo mfCheck=getByName(info.getManufacturerName());
		if(mfCheck!=null) {
			return ResponseResult.fail("厂商名称配置重复！");
		}
		info.setCreateTime(new Date());
		info.setCreator(UserUtils.getCurrentUserId());
		info.setModifier(UserUtils.getCurrentUserId());
		info.setModifiTime(new Date());
		manufacturerInfoMapper.insertSelective(info);
		
		return ResponseResult.success("添加成功！");
	}
	
	@Override
	@Transactional
	public ResponseResult edit(ManufacturerInfo info) throws Exception{
		ManufacturerInfo mfCheck=getByName(info.getManufacturerName());
		if(mfCheck!=null&&!info.getId().equals(mfCheck.getId())) {
			return ResponseResult.fail("厂商名称配置重复！");
		}
		
		info.setModifier(UserUtils.getCurrentUserId());
		info.setModifiTime(new Date());
		manufacturerInfoMapper.updateByPrimaryKeySelective(info);
		
		if("0".equals(info.getDeleteFlag())) {
			modelInfoService.delByManufacturerId(info.getId());
		}
		
		return ResponseResult.success("修改成功！");
	}
	
	@Override
	public ManufacturerInfo getByPrimaryKey(Integer id)throws Exception{
		return manufacturerInfoMapper.selectByPrimaryKey(id);
	}
	
	private ManufacturerInfo getByName(String name) {
		ManufacturerInfoExample example = new ManufacturerInfoExample();
		ManufacturerInfoExample.Criteria cri= example.createCriteria();
		cri.andManufacturerNameEqualTo(name);
		List<ManufacturerInfo> lst = manufacturerInfoMapper.selectByExample(example);
		if(CollectionUtils.isNotEmpty(lst)) {
			return lst.get(0);
		}
		return null;
	}

	@Override
	public List<ManufacturerInfo> getManufacturerInfoByNameForSearch(String name) {
		return manufacturerInfoMapper.getManufacturerInfoByNameForSearch(name);
	}
}
