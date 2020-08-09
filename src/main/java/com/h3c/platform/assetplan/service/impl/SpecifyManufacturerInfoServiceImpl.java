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
import com.h3c.platform.assetplan.dao.SpecifyManufacturerInfoMapper;
import com.h3c.platform.assetplan.entity.SpecifyManufacturerInfo;
import com.h3c.platform.assetplan.entity.SpecifyManufacturerInfoExample;
import com.h3c.platform.assetplan.entity.SpecifyManufacturerInfoExt;
import com.h3c.platform.assetplan.service.SpecifyManufacturerInfoService;
import com.h3c.platform.common.commonconst.DicConst;
import com.h3c.platform.common.service.SysDicInfoService;
import com.h3c.platform.common.util.ObjToStrUtil;

@Service
public class SpecifyManufacturerInfoServiceImpl implements SpecifyManufacturerInfoService {
	@Autowired
	private SysDicInfoService dicService;
	@Autowired
	private SpecifyManufacturerInfoMapper specifyManufacturerInfoMapper;

	@Override
	public List<SpecifyManufacturerInfoExt> getBySpecifyManufacturerID(String SpecifyManufacturerID) throws Exception{
		List<SpecifyManufacturerInfoExt> lstResult= new ArrayList<SpecifyManufacturerInfoExt>();
		SpecifyManufacturerInfoExample example=new SpecifyManufacturerInfoExample();
		SpecifyManufacturerInfoExample.Criteria cri= example.createCriteria();
		cri.andSpecifymanufactureridEqualTo(SpecifyManufacturerID);
		List<SpecifyManufacturerInfo> lst=specifyManufacturerInfoMapper.selectByExample(example);
		
		JSONArray arr=dicService.getJSONArrayDicsByType(DicConst.SPECIFYMAUFACTURER,"1");
		
		for(SpecifyManufacturerInfo info : lst) {
			SpecifyManufacturerInfoExt infoExt = new SpecifyManufacturerInfoExt();
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
		
		return lstResult.stream().sorted(Comparator.comparing(SpecifyManufacturerInfoExt::getOrder)).collect(Collectors.toList());
	}
	
	/**
	 * 获取新增时指定供应商code及name
	 */
	@Override
	public List<SpecifyManufacturerInfoExt> getEmptyFiled() throws Exception{
		List<SpecifyManufacturerInfoExt> lstResult= new ArrayList<SpecifyManufacturerInfoExt>();
		
		JSONArray arr=dicService.getJSONArrayDicsByType(DicConst.SPECIFYMAUFACTURER,"1");
		for(int i =0;i<arr.size();i++) {
			JSONObject obj=arr.getJSONObject(i);
			SpecifyManufacturerInfoExt infoExt = new SpecifyManufacturerInfoExt();
			infoExt.setTitlecode(ObjToStrUtil.ReplaceNullValue(obj.get("dic_code")));
			infoExt.setName(ObjToStrUtil.ReplaceNullValue(obj.get("dic_value")));
			String order=ObjToStrUtil.ReplaceNullValue(obj.get("sort_order"));
			infoExt.setOrder(Integer.parseInt(StringUtils.isBlank(order)?"0":order));
			lstResult.add(infoExt);
		}
		
		return lstResult.stream().sorted(Comparator.comparing(SpecifyManufacturerInfoExt::getOrder)).collect(Collectors.toList());
	}

	@Override
	public List<SpecifyManufacturerInfo> getByID(String SpecifyManufacturerID) {
		SpecifyManufacturerInfoExample example=new SpecifyManufacturerInfoExample();
		SpecifyManufacturerInfoExample.Criteria cri= example.createCriteria();
		cri.andSpecifymanufactureridEqualTo(SpecifyManufacturerID);
		List<SpecifyManufacturerInfo> lst=specifyManufacturerInfoMapper.selectByExample(example);
		return lst;
	}
}
