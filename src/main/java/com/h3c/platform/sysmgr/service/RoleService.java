package com.h3c.platform.sysmgr.service;

import com.h3c.platform.response.ResponseResult;

public interface RoleService {
	
	ResponseResult getRoleByUser(String user) throws Exception;
	
	boolean checkIsAdmin() throws Exception;

}
