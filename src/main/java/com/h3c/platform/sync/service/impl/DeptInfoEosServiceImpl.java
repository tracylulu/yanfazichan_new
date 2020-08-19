package com.h3c.platform.sync.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.h3c.platform.common.util.ObjToStrUtil;
import com.h3c.platform.sync.dao.DeptInfo_EOSMapper;
import com.h3c.platform.sync.entity.DeptInfo_EOS;
import com.h3c.platform.sync.service.DeptInfoEosService;

@Service
public class DeptInfoEosServiceImpl implements DeptInfoEosService{

	@Autowired
	private DeptInfo_EOSMapper  deptInfoEosMapper;
	
	@Override
	@Transactional
	public int syncDeptInfoEos( List<Map<String, Object>> lst) {
		deptInfoEosMapper.deleteDeptEos();
		insertDeptEos(lst);
		
		return 1;
	}
	
	@Transactional
	private void insertDeptEos(List<Map<String, Object>> lst) {
		//List<Map> addList=new ArrayList<>();
		for(Map<String, Object> map :lst) {
			DeptInfo_EOS dept= new DeptInfo_EOS();
			dept.setDeptCode(Integer.parseInt(map.get("dept_code").toString()));
			dept.setDeptName(ObjToStrUtil.replaceNullValue(map.get("dept_name")));
			dept.setCoa(ObjToStrUtil.replaceNullValue(map.get("coa")));
			dept.setDeptLevel(ObjToStrUtil.replaceNullValue(map.get("dept_level")));
			dept.setSupDeptCode(ObjToStrUtil.replaceNullValue(map.get("sup_dept_code")));
			dept.setTypeId(ObjToStrUtil.replaceNullValue(map.get("type_id")));
			dept.setDeptType(ObjToStrUtil.replaceNullValue(map.get("dept_type")));
			dept.setDeptManagerCode(ObjToStrUtil.replaceNullValue(map.get("director")));
			dept.setDeptPlannerCode(ObjToStrUtil.replaceNullValue(map.get("planner")));
			dept.setDeptCodeChain(ObjToStrUtil.replaceNullValue(map.get("dept_code_chain")));
			dept.setUpdateTime(new Date());
			deptInfoEosMapper.insertSelective(dept);
		}
	}
}
	

