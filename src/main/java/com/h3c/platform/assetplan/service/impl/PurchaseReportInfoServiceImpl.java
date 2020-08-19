package com.h3c.platform.assetplan.service.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.h3c.platform.assetplan.dao.PurchaseReportInfoMapper;
import com.h3c.platform.assetplan.entity.PurchaseReportInfo;
import com.h3c.platform.assetplan.entity.PurchaseReportInfoExample;
import com.h3c.platform.assetplan.entity.PurchaseReportInfoExt;
import com.h3c.platform.assetplan.service.PurchaseReportInfoService;
import com.h3c.platform.common.commonconst.DicConst;
import com.h3c.platform.common.service.SysDicInfoService;
import com.h3c.platform.common.util.ObjToStrUtil;

@Service
public class PurchaseReportInfoServiceImpl implements PurchaseReportInfoService{

	@Autowired
	private SysDicInfoService dicService;
	@Autowired
	private PurchaseReportInfoMapper purchaseReportInfoMapper;
	
	@Override
	public List<PurchaseReportInfoExt> getByPurchaseReportId(String purchaseReportId) throws Exception{
		List<PurchaseReportInfoExt> lstResult= new ArrayList<>();
		PurchaseReportInfoExample example=new PurchaseReportInfoExample();
		PurchaseReportInfoExample.Criteria cri= example.createCriteria();
		cri.andPurchasereportidEqualTo(purchaseReportId);
		List<PurchaseReportInfo> lst=purchaseReportInfoMapper.selectByExample(example);
		
		JSONArray arr=dicService.getJSONArrayDicsByType(DicConst.REQPURCHOASEREPORT,"1");
		
		for(PurchaseReportInfo info : lst) {
			PurchaseReportInfoExt infoExt = new PurchaseReportInfoExt();
			BeanUtils.copyProperties(infoExt, info);
			for(int i =0;i<arr.size();i++) {
				JSONObject obj=arr.getJSONObject(i);
				if(ObjToStrUtil.ReplaceNullValue(obj.get("dic_code")).equals(info.getTitlecode())) {
					infoExt.setName(ObjToStrUtil.ReplaceNullValue(obj.get("dic_value")));
					String order=ObjToStrUtil.ReplaceNullValue(obj.get("sort_order"));
					infoExt.setOrder(Integer.parseInt(StringUtils.isBlank(order)?"0":order));
				}
			}
			
			lstResult.add(infoExt);
		}
		
		return lstResult.stream().sorted(Comparator.comparing(PurchaseReportInfoExt::getOrder)).collect(Collectors.toList());
	}
	
	/**
	 * 获取新增时 申购报告字段
	 */
	@Override
	public List<PurchaseReportInfoExt> getEmptyFiled() throws Exception{
		List<PurchaseReportInfoExt> lstResult= new ArrayList<>();
		JSONArray arr=dicService.getJSONArrayDicsByType(DicConst.REQPURCHOASEREPORT,"1");
		for(int i =0;i<arr.size();i++) {
			PurchaseReportInfoExt infoExt = new PurchaseReportInfoExt();
			JSONObject obj=arr.getJSONObject(i);
			infoExt.setTitlecode(ObjToStrUtil.ReplaceNullValue(obj.get("dic_code")));
			infoExt.setName(ObjToStrUtil.ReplaceNullValue(obj.get("dic_value")));
			String order=ObjToStrUtil.ReplaceNullValue(obj.get("sort_order"));
			infoExt.setOrder(Integer.parseInt(StringUtils.isBlank(order)?"0":order));
			lstResult.add(infoExt);
		}
		
		return lstResult.stream().sorted(Comparator.comparing(PurchaseReportInfoExt::getOrder)).collect(Collectors.toList());
	}

	@Override
	public List<PurchaseReportInfo> getById(String purchaseReportId) {
		PurchaseReportInfoExample example=new PurchaseReportInfoExample();
		PurchaseReportInfoExample.Criteria cri= example.createCriteria();
		cri.andPurchasereportidEqualTo(purchaseReportId);
		List<PurchaseReportInfo> lst=purchaseReportInfoMapper.selectByExample(example);
		return lst;
	}
}
