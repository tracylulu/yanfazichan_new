package com.h3c.platform.sync.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.h3c.platform.common.util.ObjToStrUtil;
import com.h3c.platform.sync.dao.UserInfo_EOSMapper;
import com.h3c.platform.sync.entity.DeptInfo_EOS;
import com.h3c.platform.sync.entity.UserInfo_EOS;
import com.h3c.platform.sync.service.UserInfoEosService;

@Service
public class UserInfoEosServiceImpl implements UserInfoEosService {

	@Autowired
	private UserInfo_EOSMapper userInfoEosMapper;
	
	@Override
	@Transactional
	public int syncUserInfoEos(List<Map<String, Object>> lst) {
		userInfoEosMapper.deleteUserInfoEos();
		insertDeptEos(lst);
		return 1;
	}
	
	@Transactional
	private void insertDeptEos(List<Map<String, Object>> lst) {
		//List<Map> addList=new ArrayList<>();
		for(Map<String, Object> map :lst) {
			UserInfo_EOS user= new UserInfo_EOS();
			user.setNotesId(ObjToStrUtil.replaceNullValue(map.get("notesId")));
			user.setEmpCode(ObjToStrUtil.replaceNullValue(map.get("empCode")));
			user.setDomainAccount(ObjToStrUtil.replaceNullValue(map.get("domainAccount")));
			user.setDisplayName(ObjToStrUtil.replaceNullValue(map.get("display_name")));
			user.setEmpName(ObjToStrUtil.replaceNullValue(map.get("empName")));
			user.setCoaCode(ObjToStrUtil.replaceNullValue(map.get("coa_code")));
			user.setDept1Code(ObjToStrUtil.replaceNullValue(map.get("firstDeptCode")));
			user.setDept2Code(ObjToStrUtil.replaceNullValue(map.get("secondDeptCode")));
			user.setDept3Code(ObjToStrUtil.replaceNullValue(map.get("thirdDeptCode")));
			//user.setDept4Code(ObjToStrUtil.replaceNullValue(map.get("dept4_code")));
			user.setDeptCode(ObjToStrUtil.replaceNullValue(map.get("deptCode")));
			user.setDeptName(ObjToStrUtil.replaceNullValue(map.get("deptName")));
			user.setEmail(ObjToStrUtil.replaceNullValue(map.get("email")));
			user.setUpdateTime(new Date());
			userInfoEosMapper.insertSelective(user);
		}
	} 
}
