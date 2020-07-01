package com.h3c.platform.sysmgr.service;

import com.h3c.platform.response.ResponseResult;

public interface ResourceService {
	///resource/getCurrentResourceTree
	ResponseResult getCurrentResourceTree() throws Exception;
}
