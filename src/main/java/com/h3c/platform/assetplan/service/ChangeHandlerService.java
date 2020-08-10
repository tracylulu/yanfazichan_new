package com.h3c.platform.assetplan.service;

import com.h3c.platform.response.ResponseResult;


public interface ChangeHandlerService {
	
	ResponseResult changeHandler(String handler,String apstage,String applymonth,String newHandler,boolean isAdmin) throws Exception;
	
	ResponseResult list(String userCode,int pageSize,int pageNum)throws Exception;
}
