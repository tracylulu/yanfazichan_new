package com.h3c.platform.assetplan.service;

import java.util.List;

import com.h3c.platform.assetplan.entity.ProjectInfo;

public interface ProjectInfoService {
	
	/**
	 * 中台同步数据用
	 * @return
	 */
	int syncByEosData();
	
	List<ProjectInfo> getAll() throws Exception;
}
