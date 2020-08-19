package com.h3c.platform.sysmgr.service;

import com.h3c.platform.sysmgr.entity.OperationLog;

public interface OperationLogService {
	
	void saveLog(OperationLog operationLog);
	
}
