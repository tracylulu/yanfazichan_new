package com.h3c.platform.assetplan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.h3c.platform.assetplan.dao.ProjectInfoMapper;
import com.h3c.platform.assetplan.entity.ProjectInfo;
import com.h3c.platform.assetplan.entity.ProjectInfoExample;
import com.h3c.platform.assetplan.service.ProjectInfoService;

@Service
public class ProjectInfoServiceImpl implements ProjectInfoService {

	@Autowired
	private ProjectInfoMapper projectInfoMapper;

	@Override
	@Transactional
	public int syncByEosData() {
		projectInfoMapper.insertByEosData();
		projectInfoMapper.deleteInvalidData();
		projectInfoMapper.updateByEosData();
		return 1;
	}
	
	@Override
	public List<ProjectInfo> getAll() throws Exception{
		ProjectInfoExample example= new ProjectInfoExample();
		
		return projectInfoMapper.selectByExample(example);
	}
}
