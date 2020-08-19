package com.h3c.platform.assetplan.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.h3c.platform.assetplan.dao.AssetPlanInfoMapper;
import com.h3c.platform.assetplan.entity.AssetPlanInfo;
import com.h3c.platform.assetplan.service.AssetPlanTaskService;
import com.h3c.platform.common.entity.Calendar;
import com.h3c.platform.common.service.CalendarService;
import com.h3c.platform.common.service.SysDicInfoService;

@Service
public class AssetPlanTaskServiceImpl implements AssetPlanTaskService {

	@Autowired
	private AssetPlanInfoMapper  assetPlanInfoMapper;
	@Autowired
	private CalendarService calendarService;
	@Autowired
	private SysDicInfoService dicService;
	@Override
	public void submitAllForDept3() throws Exception {
		Integer day=getStartDay();
		if(day==0) {
			throw new Exception("未配置任务启动时间");
		}
		java.util.Calendar cale=null;
		cale = java.util.Calendar.getInstance(); 
		int year=cale.get(java.util.Calendar.YEAR);
		int month=cale.get(java.util.Calendar.MONTH)+1;
		
		Map<String, Object> param=new HashMap<>();
		param.put("year", year);
		param.put("month", month);
		
		assetPlanInfoMapper.updateSubmitDept2Data(param);
	}
	
	private Integer getStartDay() {
		Integer day=0;
		java.util.Calendar cale=null;
		cale = java.util.Calendar.getInstance(); 
		int month=cale.get(java.util.Calendar.MONTH)+1;
		try {
			JSONArray dicArr= dicService.getJSONArrayDicsByType("R_StartDate","1");
			for(int i=0;i<dicArr.size();i++) {
				JSONObject obj=dicArr.getJSONObject(i);
				if(obj.getInteger("dic_code").equals(month)) {
					day=obj.getInteger("dic_value");
				}
				
			}
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		
		return day;
	}
	
	/**
	 * 申请环节超期
	 * @throws Exception
	 */
	@Override
	public void applyOutTime() throws Exception{
		java.util.Calendar cale=null;
		cale = java.util.Calendar.getInstance(); 
		int year=cale.get(java.util.Calendar.YEAR);
		int month=cale.get(java.util.Calendar.MONTH)+1;
		Map<String, Object> param=new HashMap<>();
		param.put("year", year);
		param.put("month", month);
		param.put("outTimeStatus", "1");
		param.put("abnormalPlanEnum", 0);
		param.put("status", "10");
		param.put("stage", "1");
		assetPlanInfoMapper.eidtAssetOutTimeStatus(param);
	}
	
	/**
	 * 规范审核超期
	 * @throws Exception
	 */
	@Override
	public void reviewerOutTime() throws Exception{
		java.util.Calendar cale=null;
		cale = java.util.Calendar.getInstance(); 
		int year=cale.get(java.util.Calendar.YEAR);
		int month=cale.get(java.util.Calendar.MONTH)+1;
		Map<String, Object> param=new HashMap<>();
		param.put("year", year);
		param.put("month", month);
		param.put("outTimeStatus", "2");
		param.put("abnormalPlanEnum", 0);
		param.put("status", "11");
		param.put("stage", "1");
		assetPlanInfoMapper.eidtAssetOutTimeStatus(param);
	}
	
	/**
	 * 3级部门主管超期
	 * @throws Exception
	 */
	@Override
	public void dept3OutTime() throws Exception{
		java.util.Calendar cale=null;
		cale = java.util.Calendar.getInstance(); 
		int year=cale.get(java.util.Calendar.YEAR);
		int month=cale.get(java.util.Calendar.MONTH)+1;
		Map<String, Object> param=new HashMap<>();
		param.put("year", year);
		param.put("month", month);
		param.put("outTimeStatus", "3");
		param.put("abnormalPlanEnum", 0);
		param.put("status", "30");
		param.put("stage", "3");
		assetPlanInfoMapper.eidtAssetOutTimeStatus(param);
	}
	
	/**
	 * 二级部门主管超期
	 * @throws Exception
	 */
	@Override
	public void dept2OutTime() throws Exception{
		java.util.Calendar cale=null;
		cale = java.util.Calendar.getInstance(); 
		int year=cale.get(java.util.Calendar.YEAR);
		int month=cale.get(java.util.Calendar.MONTH)+1;
		Map<String, Object> param=new HashMap<>();
		param.put("year", year);
		param.put("month", month);
		param.put("outTimeStatus", "4");
		param.put("abnormalPlanEnum", 0);
		param.put("status", "40");
		param.put("stage", "4");
		assetPlanInfoMapper.eidtAssetOutTimeStatus(param);
	}
	
	/**
	 * 月末超期
	 * @throws Exception
	 */
	@Override
	public void monthOutTime() throws Exception{
		java.util.Calendar cale=null;
		cale = java.util.Calendar.getInstance(); 
		int year=cale.get(java.util.Calendar.YEAR);
		int month=cale.get(java.util.Calendar.MONTH);
		Map<String, Object> param=new HashMap<>();
		param.put("year", year);
		param.put("month", month);
		assetPlanInfoMapper.eidtMonthOutTimeStatus(param);
		
	}
	
	@Override
	public List<AssetPlanInfo> getAssetPlanEmailByMap(Map<String, Object> param){
		return assetPlanInfoMapper.getAssetPlanEmailByMap(param);
	}
}
