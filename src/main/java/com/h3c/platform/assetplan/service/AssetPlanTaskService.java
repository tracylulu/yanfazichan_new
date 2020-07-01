package com.h3c.platform.assetplan.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.h3c.platform.assetplan.entity.AssetPlanInfo;

public interface AssetPlanTaskService {

	/**
	 * 第二环节统一提价第三环节
	 */
	void SubmitAllForDept3()  throws Exception;
	
	/**
	 * 申请环节超期
	 * @throws Exception
	 */
	void applyOutTime() throws Exception;
	
	/**
	 * 规范审核超期
	 * @throws Exception
	 */
	void reviewerOutTime() throws Exception;
	
	/**
	 * 3级部门主管超期
	 * @throws Exception
	 */
	void dept3OutTime() throws Exception;
	
	/**
	 * 二级部门主管超期
	 * @throws Exception
	 */
	void dept2OutTime() throws Exception;
	
	/**
	 * 月末超期
	 * @throws Exception
	 */
	void monthOutTime() throws Exception;
	
	List<AssetPlanInfo> getAssetPlanEmailByMap(Map<String, Object> param);
}
