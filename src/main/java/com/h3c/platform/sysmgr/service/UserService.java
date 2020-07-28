package com.h3c.platform.sysmgr.service;

import java.util.List;

import com.h3c.platform.sysmgr.entity.UserInfo;

public interface UserService {

	UserInfo getUserByAccount(String domainAccount);
	
	UserInfo getUserByEmpCode(String empCode);
	
	UserInfo getUserByDeptCode(String deptCode);
	/**
	 * 中台同步数据用
	 * @return
	 */
	int syncByEosData();	
	
	List<UserInfo> getAll();
}
