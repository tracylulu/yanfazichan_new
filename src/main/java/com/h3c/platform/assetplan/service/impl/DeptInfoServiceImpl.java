 package com.h3c.platform.assetplan.service.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.h3c.platform.assetplan.dao.DeptInfoMapper;
import com.h3c.platform.assetplan.entity.DeptInfo;
import com.h3c.platform.assetplan.entity.DeptInfoExample;
import com.h3c.platform.assetplan.service.DeptInfoService;
import com.h3c.platform.util.UserUtils;

@Service
public class DeptInfoServiceImpl implements DeptInfoService {
	@Autowired
	private DeptInfoMapper deptInfoMapper;
	
	@Override
	public DeptInfo getByCode(String deptCode) {
		DeptInfoExample example= new DeptInfoExample();
		DeptInfoExample.Criteria cri = example.createCriteria();
		cri.andDeptCodeEqualTo(Integer.parseInt(deptCode) );
		
		List<DeptInfo> lst = deptInfoMapper.selectByExample(example);
		
		if(CollectionUtils.isNotEmpty(lst)) {
			return lst.get(0);
		}
		return new DeptInfo();
	}
	
	@Override
	@Transactional
	public int syncByEosData() {
		deptInfoMapper.insertByEosData();
		deptInfoMapper.deleteInvalidData();
		deptInfoMapper.updateByEosData();		
		return 1;
	}

	@Override
	public List<DeptInfo> getAllChildDept(String supDeptCode) {
		DeptInfoExample example= new DeptInfoExample();
		DeptInfoExample.Criteria cri = example.createCriteria();
		cri.andSupDeptCodeEqualTo(supDeptCode);
		List<DeptInfo> lst = deptInfoMapper.selectByExample(example);
		return lst;
	}
	
	@Override
	public boolean checkIsPlanner() {
		DeptInfoExample example= new DeptInfoExample();
		DeptInfoExample.Criteria cri = example.createCriteria();
		cri.andDeptPlannerCodeEqualTo(UserUtils.getCurrentUserId());
		List<DeptInfo> lst = deptInfoMapper.selectByExample(example);
		if(CollectionUtils.isNotEmpty(lst)) {
			return true;
		}
		return false;
	}

	@Override
	public DeptInfo getByDeptManagerCode(String deptManagerCode) {
		DeptInfoExample example= new DeptInfoExample();
		DeptInfoExample.Criteria cri = example.createCriteria();
		cri.andDeptManagerCodeEqualTo(deptManagerCode);
		List<DeptInfo> lst = deptInfoMapper.selectByExample(example);
		if(CollectionUtils.isNotEmpty(lst)) {
			return lst.get(0);
		}
		return null;
	}
	
	@Override
	public List<DeptInfo> getAll(){
		DeptInfoExample example= new DeptInfoExample();		
		List<DeptInfo> lst = deptInfoMapper.selectByExample(example);
		
		return lst;
	}
	
	@Override
	public List<DeptInfo> getCoaByAssetPlanId(List<Integer> lst){
		return deptInfoMapper.getCoaByAssetPlanId(lst);
	}
	
	@Override
	public List<DeptInfo> getTwoLevelCoaByAssetPlanId(List<Integer> lst){
		return deptInfoMapper.getTwoLevelCoaByAssetPlanId(lst);
	}
}
