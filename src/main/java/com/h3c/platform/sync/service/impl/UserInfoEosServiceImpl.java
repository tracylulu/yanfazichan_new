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
			user.setNotesId(ObjToStrUtil.ReplaceNullValue(map.get("notesId")));
			user.setEmpCode(ObjToStrUtil.ReplaceNullValue(map.get("empCode")));
			user.setDomainAccount(ObjToStrUtil.ReplaceNullValue(map.get("domainAccount")));
			user.setDisplayName(ObjToStrUtil.ReplaceNullValue(map.get("display_name")));
			user.setEmpName(ObjToStrUtil.ReplaceNullValue(map.get("empName")));
			user.setCoaCode(ObjToStrUtil.ReplaceNullValue(map.get("coa_code")));
			user.setDept1Code(ObjToStrUtil.ReplaceNullValue(map.get("firstDeptCode")));
			user.setDept2Code(ObjToStrUtil.ReplaceNullValue(map.get("secondDeptCode")));
			user.setDept3Code(ObjToStrUtil.ReplaceNullValue(map.get("thirdDeptCode")));
			//user.setDept4Code(ObjToStrUtil.ReplaceNullValue(map.get("dept4_code")));
			user.setDeptCode(ObjToStrUtil.ReplaceNullValue(map.get("deptCode")));
			user.setDeptName(ObjToStrUtil.ReplaceNullValue(map.get("deptName")));
			user.setEmail(ObjToStrUtil.ReplaceNullValue(map.get("email")));
			user.setUpdateTime(new Date());
			userInfoEosMapper.insertSelective(user);
		}
	} 
}
