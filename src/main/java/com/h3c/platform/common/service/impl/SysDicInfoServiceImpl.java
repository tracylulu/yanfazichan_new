package com.h3c.platform.common.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.xmlbeans.impl.jam.mutable.MField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.h3c.platform.common.commonconst.DicConst;
import com.h3c.platform.common.entity.EosSearchParamEntity;
import com.h3c.platform.common.entity.ManufacturerInfo;
import com.h3c.platform.common.entity.ModelInfo;
import com.h3c.platform.common.service.AfspTokenService;
import com.h3c.platform.common.service.ManufacturerInfoService;
import com.h3c.platform.common.service.ModelInfoService;
import com.h3c.platform.common.service.SysDicInfoService;
import com.h3c.platform.common.util.HttpClientUtil;
import com.h3c.platform.common.util.ObjToStrUtil;
import com.h3c.platform.response.ResponseResult;

@Service
public class SysDicInfoServiceImpl implements SysDicInfoService {

	@Value("${afsp.dic.url}")
	private String eosUrl;
	@Value("${afsp.applicationId}")
	private String  applicationId;
	@Value("${afsp.dic.url.Type}")
	private String url_ByType;
	@Value("${afsp.dic.url.codeOrName}")
	private String url_codeOrName;
	
	@Autowired
	private AfspTokenService afspTokenService;
	@Autowired
	private ManufacturerInfoService manufacturerInfoService;
	@Autowired
	private ModelInfoService modelInfoService;

	/**
	 * 根据类型获取字典
	 */
    @Override
    public  ResponseResult getDicsByType(String type) throws Exception{
    	EosSearchParamEntity eosSearchParamEntity = new EosSearchParamEntity();
		eosSearchParamEntity.setApplicationId(applicationId);
		eosSearchParamEntity.setSearchParam(type);
		
		JSONObject json = new JSONObject();
		
		String token=afspTokenService.getEosToken();
		
		Map<String,String> headers = new HashMap<String, String>();
		headers.put("token", token);
		
		String result= HttpClientUtil.sendHttpPostJsonWithHeader(eosUrl+url_ByType, json.toJSONString(eosSearchParamEntity),headers);
		
		JSONObject jsonResult = json.parseObject(result);
		JSONArray jsonArray =jsonResult.getJSONArray("data");
		
    	return ResponseResult.success(jsonArray); 
    }
    
    @Override
    public ResponseResult getDicsBycode(String code) throws Exception{
    	EosSearchParamEntity eosSearchParamEntity = new EosSearchParamEntity();
		eosSearchParamEntity.setApplicationId(applicationId);
		eosSearchParamEntity.setSearchParam(code);
		
		JSONObject json = new JSONObject();
		
		String token=afspTokenService.getEosToken();
		
		Map<String,String> headers = new HashMap<String, String>();
		headers.put("token", token);
		
		String result= HttpClientUtil.sendHttpPostJsonWithHeader(eosUrl+url_ByType, json.toJSONString(eosSearchParamEntity),headers);
		
		JSONObject jsonResult = json.parseObject(result);
		JSONArray jsonArray =jsonResult.getJSONArray("data");
		
    	return ResponseResult.success(jsonArray); 
    }
    
    /**
     * 获取表头
     */
    @Override
    public List<Map<String,Object>> getColumn(String viewName) throws Exception{
    	List<Map<String,Object>> lstColumns= new ArrayList<Map<String,Object>>();
    	JSONArray arrName = getJSONArrayDicsByType("R_"+viewName+"_CNName");
    	JSONArray arrLength = getJSONArrayDicsByType("R_"+viewName+"_Length");
    	JSONArray arrisEdit = getJSONArrayDicsByType("R_"+viewName+"_isEdit");
    	
    	if(arrName!=null&& arrName.size()>0) {
    		for(int i=0;i<arrName.size();i++){
    			Map<String,Object> column= new HashMap<String, Object>();
    			
    			JSONObject obj = arrName.getJSONObject(i); 
    			
    			column.put("prop", obj.get("dic_code"));
    			column.put("label", obj.get("dic_name"));
    			
    			for(int j=0;j<arrLength.size();j++){
    				JSONObject objLength = arrLength.getJSONObject(j); 
    				if(obj.get("dic_code").toString().equals(objLength.get("dic_code").toString())) {
    					column.put("maxlen", objLength.get("dic_name"));
    				}
    			}
    			if(!column.containsKey("maxlen")) {
    				column.put("maxlen", "-1");
    			}
    			
    			for(int k=0;k<arrisEdit.size();k++){
    				JSONObject objEdit = arrisEdit.getJSONObject(k); 
    				if(obj.get("dic_code").toString().equals(objEdit.get("dic_code").toString())) {
    					column.put("isEdit", objEdit.get("dic_name"));
    				}
    			} 
    			
    			lstColumns.add(column);
    		}
    	}
    	
    	
    	return lstColumns;
    }
    
    /**
     * 根据类型获取字典，
     * @return JSONArray
     */   
    @Override
    public  JSONArray getJSONArrayDicsByType(String type) throws Exception{
    	EosSearchParamEntity eosSearchParamEntity = new EosSearchParamEntity();
		eosSearchParamEntity.setApplicationId(applicationId);
		eosSearchParamEntity.setSearchParam(type);
		
		JSONObject json = new JSONObject();
		
		String token=afspTokenService.getEosToken();
		
		Map<String,String> headers = new HashMap<String, String>();
		headers.put("token", token);
		
		String result= HttpClientUtil.sendHttpPostJsonWithHeader(eosUrl+url_ByType, json.toJSONString(eosSearchParamEntity),headers);
		
		JSONObject jsonResult = json.parseObject(result);
		JSONArray jsonArray =jsonResult.getJSONArray("data");
		
    	return jsonArray; 
    }
    
    /**
     * 获取厂家型号
     */
    @Override
    public List<JSONObject> getManuAndModel(String name){
    	List<JSONObject> lst=new ArrayList<JSONObject>();
    	
    	List<ManufacturerInfo> lstmf=manufacturerInfoService.getManufacturerInfoByName(name);
    	List<ModelInfo> lstmi= modelInfoService.getAll();    	
    	
    	for(ManufacturerInfo mfInfo:lstmf) {
    		JSONObject obj=new JSONObject();
    		List<String> lstModelName = new ArrayList<String>();
    		 lstmi.stream().filter(o->mfInfo.getId().equals(o.getManufacturerId())).forEach(a->{    			
    			 lstModelName.add( a.getName());
    		 });
    		obj.put("assetmanufacturer", mfInfo.getManufacturerName());
    		obj.put("assetmodel", lstModelName);
    		
    		lst.add(obj);
    	}
    	
    	return lst;
    	
    }
    
    /**
     * 根据类型及编码获取字典
     */
    @Override
    public JSONObject getDicByTypeAndCode(String type,String code) throws Exception{
    	JSONObject result=new JSONObject();
    	JSONArray arr= getJSONArrayDicsByType(type);
    	
    	for(int i=0;i<arr.size();i++) {
    		JSONObject obj=arr.getJSONObject(i);
    		if(code.equals(ObjToStrUtil.ReplaceNullValue(obj.get("dic_code")))){
    			result=obj;
    			break;
    		}
    	}
    	
    	return result;
    }
    
    @Override
    public String getPlanner() throws Exception {
    	return getDicCode(DicConst.R_PLANNER);
    }
	
    @Override
    public String getOQ()  throws Exception{
    	return getDicCode(DicConst.R_OQ);
    }
	
    @Override
	public String getFirstDeptMgn() throws Exception {
    	return getDicCode(DicConst.R_FISRTDEPTMGN);
	}
    
    private String getDicCode(String type) throws Exception {
    	JSONArray jsonArray=getJSONArrayDicsByType(type);
    	if(jsonArray.size()==0) {
    		return "";
    	}
    	JSONObject obj=jsonArray.getJSONObject(0);
    	
    	return ObjToStrUtil.ReplaceNullValue(obj.get("dic_code"));
    }
}
