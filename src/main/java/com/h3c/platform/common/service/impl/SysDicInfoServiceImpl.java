package com.h3c.platform.common.service.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.xmlbeans.impl.jam.mutable.MField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
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
import com.h3c.platform.util.UserUtils;

@Service
public class SysDicInfoServiceImpl implements SysDicInfoService {

	@Value("${afsp.dic.url}")
	private String eosUrl;
	@Value("${afsp.applicationId}")
	private String applicationId;
	@Value("${afsp.dic.url.Type}")
	private String url_ByType;
	@Value("${afsp.dic.url.codeOrName}")
	private String url_codeOrName;
	@Value("${afsp.dic.url.add}")
	private String url_Add;
	@Value("${afsp.dic.url.edit}")
	private String url_edit;
	@Value("${afsp.dic.url.del}")
	private String url_del;
	@Value("${afsp.dic.url.getById}")
	private String url_getById;
	@Value("${afsp.dic.url.batchAdd}")
	private String url_BatchAdd;
	@Value("${afsp.dic.url.batchEdit}")
	private String url_BatchEdit;

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
	public ResponseResult getDicsByType(String type) throws Exception {
		EosSearchParamEntity eosSearchParamEntity = new EosSearchParamEntity();
		eosSearchParamEntity.setApplicationId(applicationId);
		eosSearchParamEntity.setSearchParam("1");
		eosSearchParamEntity.setDicType(type);

		//JSONObject json = new JSONObject();

		String result = sendHttp(eosUrl + url_ByType, JSON.toJSONString(eosSearchParamEntity));

		JSONObject jsonResult = JSON.parseObject(result);
		JSONArray jsonArray = jsonResult.getJSONArray("data");

		return ResponseResult.success(jsonArray);
	}

	@Override
	public ResponseResult getDicsBycode(String code) throws Exception {
		EosSearchParamEntity eosSearchParamEntity = new EosSearchParamEntity();
		eosSearchParamEntity.setApplicationId(applicationId);
		eosSearchParamEntity.setSearchParam("1");
		eosSearchParamEntity.setDicType(code);

		//JSONObject json = new JSONObject();

		String result = sendHttp(eosUrl + url_ByType, JSON.toJSONString(eosSearchParamEntity));

		JSONObject jsonResult = JSON.parseObject(result);
		JSONArray jsonArray = jsonResult.getJSONArray("data");

		return ResponseResult.success(jsonArray);
	}

	/**
	 * 获取表头
	 */
	@Override
	public List<Map<String, Object>> getColumn(String viewName) throws Exception {
		List<Map<String, Object>> lstColumns = new ArrayList<>();
		JSONArray arrName = getJsonArrayDicsByType("R_" + viewName + "_CNName", "1");
		JSONArray arrLength = getJsonArrayDicsByType("R_" + viewName + "_Length", "1");
		JSONArray arrisEdit = getJsonArrayDicsByType("R_" + viewName + "_isEdit", "1");

		if (arrName != null && arrName.size() > 0) {
			for (int i = 0; i < arrName.size(); i++) {
				Map<String, Object> column = new HashMap<>();

				JSONObject obj = arrName.getJSONObject(i);

				column.put("prop", obj.get("dic_code"));
				column.put("label", obj.get("dic_value"));

				for (int j = 0; j < arrLength.size(); j++) {
					JSONObject objLength = arrLength.getJSONObject(j);
					if (obj.get("dic_code").toString().equals(objLength.get("dic_code").toString())) {
						column.put("maxlen", objLength.get("dic_value"));
					}
				}
				if (!column.containsKey("maxlen")) {
					column.put("maxlen", "-1");
				}

				for (int k = 0; k < arrisEdit.size(); k++) {
					JSONObject objEdit = arrisEdit.getJSONObject(k);
					if (obj.get("dic_code").toString().equals(objEdit.get("dic_code").toString())) {
						column.put("isEdit", objEdit.get("dic_value"));
					}
				}

				lstColumns.add(column);
			}
		}

		return lstColumns;
	}

	/**
	 * 根据类型获取字典， isDelete (0:失效，1：有效，空：所有)
	 * 
	 * @return JSONArray
	 */
	@Override
	public JSONArray getJsonArrayDicsByType(String type, String isDelete) throws Exception {
		EosSearchParamEntity eosSearchParamEntity = new EosSearchParamEntity();
		eosSearchParamEntity.setApplicationId(applicationId);
		if (StringUtils.isNotBlank(isDelete)) {
			eosSearchParamEntity.setSearchParam(isDelete);
		}
		eosSearchParamEntity.setDicType(type);

		//JSONObject json = new JSONObject(true);

		String result = sendHttp(eosUrl + url_ByType, JSON.toJSONString(eosSearchParamEntity));

		JSONObject jsonResult = JSON.parseObject(result);
		JSONArray jsonArray = jsonResult.getJSONArray("data");

		return jsonArray;
	}

	/**
	 * 获取厂家型号
	 */
	@Override
	public List<JSONObject> getManuAndModel(String name) throws Exception {
		List<JSONObject> lst = new ArrayList<>();

		List<ManufacturerInfo> lstmf = manufacturerInfoService.getManufacturerInfoByName(name);
		List<ModelInfo> lstmi = modelInfoService.getAll();

		for (ManufacturerInfo mfInfo : lstmf) {
			JSONObject obj = new JSONObject();
			List<String> lstModelName = new ArrayList<>();
			lstmi.stream().filter(o -> mfInfo.getId().equals(o.getManufacturerId())).sorted(Comparator.comparing(ModelInfo::getName)).forEach(a -> {
				lstModelName.add(a.getName());
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
	public JSONObject getDicByTypeAndCode(String type, String code) throws Exception {
		JSONObject result = new JSONObject();
		JSONArray arr = getJsonArrayDicsByType(type, "1");

		for (int i = 0; i < arr.size(); i++) {
			JSONObject obj = arr.getJSONObject(i);
			if (code.equals(ObjToStrUtil.replaceNullValue(obj.get("dic_code")))) {
				result = obj;
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
	public String getOq() throws Exception {
		return getDicCode(DicConst.R_OQ);
	}

	@Override
	public String getFirstDeptMgn() throws Exception {
		return getDicCode(DicConst.R_FISRTDEPTMGN);
	}

	private String getDicCode(String type) throws Exception {
		JSONArray jsonArray = getJsonArrayDicsByType(type, "1");
		if (jsonArray.size() == 0) {
			return "";
		}
		JSONObject obj = jsonArray.getJSONObject(0);

		return ObjToStrUtil.replaceNullValue(obj.get("dic_code"));
	}

	@Override
	public ResponseResult add(JSONObject model) throws Exception {
		//JSONObject json = new JSONObject();

		String token = afspTokenService.getEosToken();

		Map<String, String> headers = new HashMap<>();
		headers.put("token", token);

		String result = HttpClientUtil.sendHttpPostJsonWithHeader(eosUrl + url_Add, JSON.toJSONString(model), headers);

		JSONObject jsonResult = JSON.parseObject(result);
		if (!jsonResult.getBoolean("flag")) {
			return ResponseResult.fail(jsonResult.getString("message"));
		}
		return ResponseResult.success("添加成功！");
	}

	@Override
	public ResponseResult edit(JSONObject model) throws Exception {
		//JSONObject json = new JSONObject();

		String result = sendHttp(eosUrl + url_edit, JSON.toJSONString(model));

		JSONObject jsonResult = JSON.parseObject(result);
		if (!jsonResult.getBoolean("flag")) {
			return ResponseResult.fail(jsonResult.getString("message"));
		}
		return ResponseResult.success("修改成功！");
	}

	@Override
	public ResponseResult del(String ids) throws Exception {
		EosSearchParamEntity eosSearchParamEntity = new EosSearchParamEntity();
		eosSearchParamEntity.setApplicationId(applicationId);
		eosSearchParamEntity.setSearchParam(ids);
		eosSearchParamEntity.setLastModifier(UserUtils.getCurrentDominAccount());

		//JSONObject json = new JSONObject();

		String result = sendHttp(eosUrl + url_del, JSON.toJSONString(eosSearchParamEntity));

		JSONObject jsonResult = JSON.parseObject(result);
		if (!jsonResult.getBoolean("flag")) {
			return ResponseResult.fail(jsonResult.getString("message"));
		}
		return ResponseResult.success("删除成功！");
	}

	@Override
	public JSONObject getById(Integer id) throws Exception {
		JSONObject obj = new JSONObject();
		obj.put("applicationId", applicationId);
		obj.put("id", id);
		//JSONObject json = new JSONObject();

		String result = sendHttp(eosUrl + url_getById, JSON.toJSONString(obj));

		JSONObject jsonResult = JSON.parseObject(result);
		JSONArray resultArr = jsonResult.getJSONArray("data");
		if (jsonResult.getBoolean("flag") && resultArr.size() > 0) {
			return resultArr.getJSONObject(0);
		}
		String errMsg = jsonResult.getString("message");
		throw new Exception(jsonResult.getBoolean("flag") ? "未查询到数据" : errMsg);
	}

	/**
	 * 批量新增
	 */
	@Override
	public void batchInsert(List<JSONObject> lst) throws Exception {
		//JSONObject json = new JSONObject();

		String result = sendHttp(eosUrl + url_BatchAdd, JSON.toJSONString(lst));
		JSONObject jsonResult = JSON.parseObject(result);
		//JSONArray resultArr = jsonResult.getJSONArray("data");
		if (!jsonResult.getBoolean("flag") ) {
			StringBuffer errMsg= new StringBuffer();
			JSONArray data= jsonResult.getJSONArray("data");
			for(int i=0;i<data.size();i++) {
				JSONObject obj= data.getJSONObject(i);
				if(StringUtils.isNotBlank(ObjToStrUtil.replaceNullValue(obj.get("errorMsg")))) {
					errMsg.append("部门编码【"+ObjToStrUtil.replaceNullValue(obj.get("dicCode"))+"】"+ObjToStrUtil.replaceNullValue(obj.get("errorMsg"))+" \n");
				}				
			}
			throw new Exception( StringUtils.isNotBlank(errMsg.toString())?errMsg.toString():jsonResult.getString("message"));
		}
	}

	/**
	 * 批量修改
	 */	
	@Override
	public void batchEdit(List<JSONObject> lst) throws Exception {
		//JSONObject json = new JSONObject();

		String result = sendHttp(eosUrl + url_BatchEdit, JSON.toJSONString(lst));
		JSONObject jsonResult = JSON.parseObject(result);
		//JSONArray resultArr = jsonResult.getJSONArray("data");
		if (!jsonResult.getBoolean("flag") ) {
			StringBuffer errMsg= new StringBuffer();
			JSONArray data= jsonResult.getJSONArray("data");
			for(int i=0;i<data.size();i++) {
				JSONObject obj= data.getJSONObject(i);
				if(StringUtils.isNotBlank(ObjToStrUtil.replaceNullValue(obj.get("errorMsg")))) {
					errMsg.append("部门编码【"+ObjToStrUtil.replaceNullValue(obj.get("dicCode"))+"】"+ObjToStrUtil.replaceNullValue(obj.get("errorMsg"))+" \n");
				}				
			}
			throw new Exception( StringUtils.isNotBlank(errMsg.toString())?errMsg.toString():jsonResult.getString("message"));
		}
	}

	/**
	 * 发送http请求至afsp
	 * @param url url
	 * @param param 参数
	 * @return
	 * @throws Exception
	 */
	private String sendHttp(String url, String param) throws Exception {
		String token = afspTokenService.getEosToken();
		Map<String, String> headers = new HashMap<>();
		headers.put("token", token);

		String result = HttpClientUtil.sendHttpPostJsonWithHeader(url, param, headers);

		return result;
	}

	@Override
	public List<JSONObject> getManuAndModelForSearch(String name) throws Exception {
		List<JSONObject> lst = new ArrayList<>();

		List<ManufacturerInfo> lstmf = manufacturerInfoService.getManufacturerInfoByNameForSearch(name);
		List<ModelInfo> lstmi = modelInfoService.getAll();

		for (ManufacturerInfo mfInfo : lstmf) {
			JSONObject obj = new JSONObject();
			List<String> lstModelName = new ArrayList<>();
			lstmi.stream().filter(o -> mfInfo.getId().equals(o.getManufacturerId())).sorted(Comparator.comparing(ModelInfo::getName)).forEach(a -> {
				lstModelName.add(a.getName());
			});
			obj.put("assetmanufacturer", mfInfo.getManufacturerName());
			obj.put("assetmodel", lstModelName);

			lst.add(obj);
		}

		return lst;
	}

}
