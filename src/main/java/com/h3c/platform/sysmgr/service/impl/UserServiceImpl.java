package com.h3c.platform.sysmgr.service.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.h3c.platform.sysmgr.dao.UserInfoMapper;
import com.h3c.platform.sysmgr.entity.UserInfo;
import com.h3c.platform.sysmgr.entity.UserInfoExample;
import com.h3c.platform.sysmgr.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserInfoMapper userMapper;

	@Override
	public UserInfo getUserByAccount(String domainAccount) {
		UserInfoExample example = new UserInfoExample();
		UserInfoExample.Criteria cir = example.createCriteria();
		cir.andDomainAccountEqualTo(domainAccount);
		cir.andDeleteFlagEqualTo("1");

		List<UserInfo> lst = userMapper.selectByExample(example);

		if (CollectionUtils.isEmpty(lst)) {
			return null;
		} else {
			return lst.get(0);
		}
	}

	@Override
	public UserInfo getUserByEmpCode(String empCode) {
		UserInfoExample example = new UserInfoExample();
		UserInfoExample.Criteria cir = example.createCriteria();
		cir.andEmpCodeEqualTo(empCode);

		List<UserInfo> lst = userMapper.selectByExample(example);

		if (CollectionUtils.isEmpty(lst)) {
			return null;
		} else {
			return lst.get(0);
		}
	}

	@Override
	@Transactional
	public int syncByEosData() {
		userMapper.insertByEosData();
		userMapper.deleteInvalidData();
		userMapper.updateByEosData();
		return 1;
	}

	@Override
	public UserInfo getUserByDeptCode(String deptCode) {
		UserInfoExample example = new UserInfoExample();
		UserInfoExample.Criteria cir = example.createCriteria();
		cir.andDeptCodeEqualTo(deptCode);

		List<UserInfo> lst = userMapper.selectByExample(example);

		if (CollectionUtils.isEmpty(lst)) {
			return null;
		} else {
			return lst.get(0);
		}
	}
	
	@Override
	public List<UserInfo> getAll(){
		UserInfoExample example = new UserInfoExample();
		List<UserInfo> lst = userMapper.selectByExample(example);
		
		return lst;
	}

}
