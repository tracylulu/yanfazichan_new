package com.h3c.platform.sysmgr.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.h3c.platform.sysmgr.dao.OperationLogMapper;
import com.h3c.platform.sysmgr.entity.OperationLog;
import com.h3c.platform.sysmgr.service.OperationLogService;
import com.h3c.platform.util.UserUtils;

@Service
public class OperationLogServiceImpl implements OperationLogService {
	
	@Autowired
	private OperationLogMapper  optLogMapper;
	
	public void SaveLog(OperationLog operationLog) {
		operationLog.setLogtime(new Date());
		operationLog.setUserid(UserUtils.getCurrentUserId());
		optLogMapper.insert(operationLog);		
	}
}
