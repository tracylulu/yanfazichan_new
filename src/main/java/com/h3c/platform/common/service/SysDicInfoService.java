package com.h3c.platform.common.service;


import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.h3c.platform.response.ResponseResult;

public interface SysDicInfoService {

	/**
	 * 根据类型获取字典
	 * @param type
	 * @return
	 */
	ResponseResult getDicsByType(String type)throws Exception;
    
	/**
	 * 根据编码或名称获取字典
	 * @param value
	 * @return
	 */
	ResponseResult getDicsBycode(String code) throws Exception;
	
	List<Map<String,Object>> getColumn(String viewName) throws Exception;
	
	JSONArray getJsonArrayDicsByType(String type, String isDelete) throws Exception;
	
	List<JSONObject> getManuAndModel(String name) throws Exception;
	
	List<JSONObject> getManuAndModelForSearch(String name) throws Exception;
    
	JSONObject getDicByTypeAndCode(String type,String code) throws Exception;
	
	/**
	 * 获取计划员
	 * @return
	 */
	String getPlanner() throws Exception;
	
	/**
	 * 获取专家团审核人员
	 * @return
	 */
	String getOq() throws Exception;
	
	/**
	 * 获取一级部门主管
	 * @return
	 */
	String getFirstDeptMgn() throws Exception;
	
	ResponseResult add(JSONObject model) throws Exception;
	
	ResponseResult edit(JSONObject model) throws Exception;
	
	ResponseResult del(String ids) throws Exception;
	
	JSONObject getById(Integer id) throws Exception;
	
	void batchInsert(List<JSONObject> lst) throws Exception;
	
	void batchEdit(List<JSONObject> lst) throws Exception;
}
