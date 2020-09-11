package com.h3c.platform.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.h3c.platform.assetplan.entity.AssetPlanInfoAll;
import com.h3c.platform.assetplan.entity.AssetPlanInfoPlannerView;
import com.h3c.platform.assetplan.entity.AssetPlanInfoReportView;
import com.h3c.platform.assetplan.entity.AssetPlanInfoSearchExportView;
import com.h3c.platform.assetplan.entity.AssetPlanInfoSearchView;
import com.h3c.platform.assetplan.entity.DeptTreeInfo;
import com.h3c.platform.assetplan.entity.SysDicCategoryEntity;
import com.h3c.platform.assetplan.entity.SysDicReceiverPlaceEntity;
import com.h3c.platform.common.commonconst.DicConst;
import com.h3c.platform.common.config.UserCache;
import com.h3c.platform.common.service.SysDicInfoService;
import com.h3c.platform.common.util.ObjToStrUtil;
@Component
public class SysDicInfoUtil {
	
	@Autowired
	private SysDicInfoService dicService;
	
	
	public SysDicCategoryEntity getSysDicCategory(String assetCategoryId) throws Exception{
		SysDicCategoryEntity categoryEntity =new SysDicCategoryEntity();
		JSONArray objDic=dicService.getJsonArrayDicsByType(DicConst.R_CATEGORY,"1");
			for (int i = 0; i < objDic.size(); i++) {
				JSONObject obj= objDic.getJSONObject(i);
				String dicCode = ObjToStrUtil.replaceNullValue(obj.get("dic_code"));
				if(dicCode.equals(assetCategoryId)) {
					String value= obj.get("dic_value")==null?"":obj.get("dic_value").toString();
					String[] arrvalue =value.split("_");
					categoryEntity.setAssetCategoryId(dicCode);
					categoryEntity.setAssetCategory(arrvalue[2]);
					categoryEntity.setGoodstime(arrvalue[3]);
					break;
				}
			}
			return categoryEntity; 
	}
		 
	public SysDicReceiverPlaceEntity getSysDicReceiverPlace(String receiverPlaceId) throws Exception{
		SysDicReceiverPlaceEntity receiverPlaceEntity =new SysDicReceiverPlaceEntity();
		JSONArray objDic=dicService.getJsonArrayDicsByType(DicConst.R_ADDRESS,"1");
			for (int i = 0; i < objDic.size(); i++) {
				JSONObject obj= objDic.getJSONObject(i);
				String dicCode = ObjToStrUtil.replaceNullValue(obj.get("dic_code"));
				if(dicCode.equals(receiverPlaceId)) {
					String value= obj.get("dic_value")==null?"":obj.get("dic_value").toString();
					String[] arrvalue =value.split("_");
					receiverPlaceEntity.setReceiverPlaceId(dicCode);
					receiverPlaceEntity.setReceiverPlace(arrvalue[1]);
					break;
		   			}
				}
			return receiverPlaceEntity; 
	}
	
	
	public List<AssetPlanInfoAll> replaceDicCategory(List<AssetPlanInfoAll> list) throws Exception{
			JSONArray arrayData = new JSONArray();
			com.alibaba.fastjson.JSONArray objDic=dicService.getJsonArrayDicsByType(DicConst.R_CATEGORY,"1");
			for (int i = 0; i < objDic.size(); i++) {
				com.alibaba.fastjson.JSONObject obj= objDic.getJSONObject(i);
				String value= obj.get("dic_value")==null?"":obj.get("dic_value").toString();
				String[] arrvalue =value.split("_");
				for (int j = 0; j < list.size(); j++) {
					if(list.get(j).getAssetcategory().equals(obj.get("dic_code").toString())) {
						list.get(j).setAssetcategoryId(obj.get("dic_code").toString());
						list.get(j).setAssetcategory(arrvalue[2]);
						list.get(j).setGoodstime(arrvalue[3]);
					}
				}
			}
		return list;
	}
	
	public List<AssetPlanInfoSearchView> replaceDicCategoryForSearch(List<AssetPlanInfoSearchView> list) throws Exception{
		JSONArray arrayData = new JSONArray();
		com.alibaba.fastjson.JSONArray objDic=dicService.getJsonArrayDicsByType(DicConst.R_CATEGORY,"1");
		for (int i = 0; i < objDic.size(); i++) {
			com.alibaba.fastjson.JSONObject obj= objDic.getJSONObject(i);
			String value= obj.get("dic_value")==null?"":obj.get("dic_value").toString();
			String[] arrvalue =value.split("_");
			for (int j = 0; j < list.size(); j++) {
				if(list.get(j).getAssetcategory().equals(obj.get("dic_code").toString())) {
					list.get(j).setAssetcategory(arrvalue[2]);
				}
			}
		}
		return list;
	}
    
	public List<AssetPlanInfoReportView> replaceDicCategoryForReport(List<AssetPlanInfoReportView> list) throws Exception{
		JSONArray arrayData = new JSONArray();
		com.alibaba.fastjson.JSONArray objDic=dicService.getJsonArrayDicsByType(DicConst.R_CATEGORY,"1");
		for (int i = 0; i < objDic.size(); i++) {
			com.alibaba.fastjson.JSONObject obj= objDic.getJSONObject(i);
			String value= obj.get("dic_value")==null?"":obj.get("dic_value").toString();
			String[] arrvalue =value.split("_");
			for (int j = 0; j < list.size(); j++) {
				if(list.get(j).getAssetcategory().equals(obj.get("dic_code").toString())) {
					list.get(j).setAssetcategory(arrvalue[2]);
				}
			}
		}
		return list;
	}
	
	public List<AssetPlanInfoSearchExportView> replaceDicForSearchExport(List<AssetPlanInfoSearchExportView> list) throws Exception{
		com.alibaba.fastjson.JSONArray objDic=dicService.getJsonArrayDicsByType(DicConst.R_CATEGORY,"1");
		com.alibaba.fastjson.JSONArray objDic1=dicService.getJsonArrayDicsByType(DicConst.R_ADDRESS,"1");
		for (int i = 0; i < objDic.size(); i++) {
			com.alibaba.fastjson.JSONObject obj= objDic.getJSONObject(i);
			String value= obj.get("dic_value")==null?"":obj.get("dic_value").toString();
			String[] arrvalue =value.split("_");
			for (int j = 0; j < list.size(); j++) {
				if(list.get(j).getAssetcategory().equals(obj.get("dic_code").toString())) {
					list.get(j).setAssetcategory(arrvalue[2]);
					list.get(j).setGoodstime(arrvalue[3]);
				}
				if(!"0".equals(list.get(j).getApstage())) {
					list.get(j).setApprovalnote("");
				}
			}
		}
		for (int i = 0; i < objDic1.size(); i++) {
			com.alibaba.fastjson.JSONObject obj= objDic1.getJSONObject(i);
			String value= obj.get("dic_value")==null?"":obj.get("dic_value").toString();
			String[] arrvalue =value.split("_");
			for (int j = 0; j < list.size(); j++) {
				if(list.get(j).getReceiverplace().equals(obj.get("dic_code").toString())) {
					list.get(j).setReceiverplace(arrvalue[1]);
				}
			}
		}
		return list;
	}
	
	public List<AssetPlanInfoPlannerView> replaceDicForPlannerExport(List<AssetPlanInfoPlannerView> list) throws Exception{
		com.alibaba.fastjson.JSONArray objDic=dicService.getJsonArrayDicsByType(DicConst.R_CATEGORY,"1");
		com.alibaba.fastjson.JSONArray objDic1=dicService.getJsonArrayDicsByType(DicConst.R_ADDRESS,"1");
		for (int i = 0; i < objDic.size(); i++) {
			com.alibaba.fastjson.JSONObject obj= objDic.getJSONObject(i);
			String value= obj.get("dic_value")==null?"":obj.get("dic_value").toString();
			String[] arrvalue =value.split("_");
			for (int j = 0; j < list.size(); j++) {
				if(list.get(j).getAssetcategory().equals(obj.get("dic_code").toString())) {
					list.get(j).setAssetcategory(arrvalue[2]);
					list.get(j).setGoodstime(arrvalue[3]);
				}
				if(!"0".equals(list.get(j).getApstatus()) || !"02".equals(list.get(j).getApstatus()) ||
						!"03".equals(list.get(j).getApstatus()) || !"04".equals(list.get(j).getApstatus()) ||
						!"05".equals(list.get(j).getApstatus()) || !"051".equals(list.get(j).getApstatus()) ||
						!"06".equals(list.get(j).getApstatus()) || !"07".equals(list.get(j).getApstatus())
						) {
					list.get(j).setPlannernote("");
				}
			}
		}
		for (int i = 0; i < objDic1.size(); i++) {
			com.alibaba.fastjson.JSONObject obj= objDic1.getJSONObject(i);
			String value= obj.get("dic_value")==null?"":obj.get("dic_value").toString();
			String[] arrvalue =value.split("_");
			for (int j = 0; j < list.size(); j++) {
				if(list.get(j).getReceiverplace().equals(obj.get("dic_code").toString())) {
					list.get(j).setReceiverplace(arrvalue[1]);
				}
			}
		}
		return list;
	}
	
	
}
