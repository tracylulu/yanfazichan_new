package com.h3c.platform.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
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
		JSONArray objDic=dicService.getJSONArrayDicsByType(DicConst.R_CATEGORY,"1");
			for (int i = 0; i < objDic.size(); i++) {
				JSONObject obj= objDic.getJSONObject(i);
				String dicCode = ObjToStrUtil.ReplaceNullValue(obj.get("dic_code"));
				if(dicCode.equals(assetCategoryId)) {
					String value= obj.get("dic_name")==null?"":obj.get("dic_name").toString();
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
		JSONArray objDic=dicService.getJSONArrayDicsByType(DicConst.R_ADDRESS,"1");
			for (int i = 0; i < objDic.size(); i++) {
				JSONObject obj= objDic.getJSONObject(i);
				String dicCode = ObjToStrUtil.ReplaceNullValue(obj.get("dic_code"));
				if(dicCode.equals(receiverPlaceId)) {
					String value= obj.get("dic_name")==null?"":obj.get("dic_name").toString();
					String[] arrvalue =value.split("_");
					receiverPlaceEntity.setReceiverPlaceId(dicCode);
					receiverPlaceEntity.setReceiverPlace(arrvalue[1]);
					break;
		   			}
				}
			return receiverPlaceEntity; 
	}
    
}
