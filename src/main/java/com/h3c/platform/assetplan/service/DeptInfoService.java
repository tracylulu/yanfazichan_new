package com.h3c.platform.assetplan.service;

import java.util.List;

import com.h3c.platform.assetplan.entity.DeptInfo;
import com.h3c.platform.assetplan.entity.DeptInfoExample;

public interface DeptInfoService {

	DeptInfo getByCode(String deptCode);

	/**
	 * 中台同步数据用
	 * @return
	 */
	int syncByEosData();	
	
	List<DeptInfo> getAllChildDept(String supDeptCode);
	
	boolean checkIsPlanner();
	
	//根据传入的deptManagerCode。判断是不是123级部门主管
	DeptInfo getByDeptManagerCode(String deptManagerCode);
	
	List<DeptInfo> getAll();
	
	/**
	 * 获取流程部门Coa编码
	 * @param lst
	 * @return
	 */
	List<DeptInfo> getCoaByAssetPlanID(List<Integer> lst);
	
	/**
	 * 获取流程部门Coa编码（三级未查到查询2级）
	 * @param lst
	 * @return
	 */
	List<DeptInfo> getTwoLevelCoaByAssetPlanID(List<Integer> lst);
}
