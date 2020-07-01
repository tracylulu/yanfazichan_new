package com.h3c.platform.assetplan.service.impl;

import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.h3c.platform.assetplan.dao.AssetRateInfoMapper;
import com.h3c.platform.assetplan.entity.AssetRateInfo;
import com.h3c.platform.assetplan.entity.AssetRateInfoExample;
import com.h3c.platform.assetplan.entity.DeptInfo;
import com.h3c.platform.assetplan.service.AssetRateInfoService;
import com.h3c.platform.assetplan.service.DeptInfoService;
import com.h3c.platform.common.service.SysDicInfoService;
import com.h3c.platform.response.ResponseResult;

@Service
public class AssetRateInfoServiceImpl implements AssetRateInfoService {
	
	@Autowired
	private AssetRateInfoMapper assetRateInfoMapper;
	@Autowired
	private DeptInfoService deptInfoService;

	/**
	 *@model 型号
	 *@deptCode 三级部门编码
	 *@date 日期
	 */
	@Override
	public ResponseResult getRate(String model,String deptCode ,Date date) {
		DeptInfo deptInfo = deptInfoService.getByCode(deptCode);
		//交换机和路由器预算部门为三级，其余为二级
		if(!"50042493".contentEquals(deptInfo.getSupDeptCode())&&!"50042499".contentEquals(deptInfo.getSupDeptCode())) {
			deptCode = deptInfo.getSupDeptCode();
		}
		double rates=0 ,usageRate=0;
		Calendar calendar=Calendar.getInstance();  
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH,-62);
		AssetRateInfoExample example = new AssetRateInfoExample();
		AssetRateInfoExample.Criteria cri= example.createCriteria();
		cri.andDeptCodeEqualTo(deptCode);
		cri.andAssetCategoryEqualTo(model);
		cri.andCollectTimeBetween(calendar.getTime(), date);
		
		List<AssetRateInfo> lst = assetRateInfoMapper.selectByExample(example);
		
		for(AssetRateInfo rateInfo : lst) {
			if(StringUtils.isNotBlank(rateInfo.getUsageRate())) {
				rates += Double.parseDouble(rateInfo.getUsageRate());
			}
		}		 
		
		if(Double.NaN !=rates && CollectionUtils.isNotEmpty(lst)) {
			usageRate = rates/lst.size();
		}
		
		NumberFormat nf = NumberFormat.getNumberInstance();
		nf.setMaximumFractionDigits(0);
		
		String deptUsageRate=nf.format(usageRate*100);
		
		Map<String,Object> mapDept= new HashMap<>();	
		
		mapDept.put("deptName", deptInfo.getDeptName());
		mapDept.put("type", model);
		if(CollectionUtils.isEmpty(lst)) {
			mapDept.put("rate", "");
			mapDept.put("isEmpty", true);
		}else {
			mapDept.put("rate",deptUsageRate+"%");
			mapDept.put("isEmpty", false);
		}
		
		
		Map<String,Object> mapRD= new HashMap<>();
		
		mapRD=getRDRate( model, deptCode,calendar.getTime(),date);

		
		Map<String,Object> result= new HashMap<>();	
		result.put("dept", mapDept);
		result.put("RD", mapRD);
		result.put("detail", lst);
		
		return ResponseResult.success(result);
	}
	
	/**
	 * 获取研发整体使用率
	 * @param type
	 * @param deptCode
	 * @param bef
	 * @param end
	 * @return
	 */
	private Map<String,Object> getRDRate(String model,String deptCode,Date bef,Date end) {
		Map<String,Object> mapRD= new HashMap<>();
		mapRD.put("deptName", "研发总体");
		mapRD.put("type", model);
		double rates=0 ,usageRate=0;
		AssetRateInfoExample example = new AssetRateInfoExample();
		AssetRateInfoExample.Criteria cri= example.createCriteria();
		cri.andDeptNameEqualTo("研发总体");
		cri.andAssetCategoryEqualTo(model);
		cri.andCollectTimeBetween(bef, end);
		
		List<AssetRateInfo> lst = assetRateInfoMapper.selectByExample(example);

		
		if(CollectionUtils.isEmpty(lst)) {
			mapRD.put("rate", "");
			mapRD.put("isEmpty", true);
		}else {
			for(AssetRateInfo rateInfo : lst) {
				if(StringUtils.isNotBlank(rateInfo.getUsageRate())) {
					rates += Double.parseDouble(rateInfo.getUsageRate());
				}
			}		 
			
			if(Double.NaN !=rates && CollectionUtils.isNotEmpty(lst)) {
				usageRate = rates/lst.size();
			}
			NumberFormat nf = NumberFormat.getNumberInstance();
			nf.setMaximumFractionDigits(0);
			String RDUsageRate =nf.format(usageRate*100);
			mapRD.put("rate",RDUsageRate+"%");
			mapRD.put("isEmpty", false);
		}
	
		return mapRD ;
	}
}
