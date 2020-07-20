package com.h3c.platform.assetplan.service.impl;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.h3c.platform.assetplan.dao.AssetRateInfoMapper;
import com.h3c.platform.assetplan.entity.AssetPlanInfoAll;
import com.h3c.platform.assetplan.entity.AssetRateInfo;
import com.h3c.platform.assetplan.entity.AssetRateInfoExample;
import com.h3c.platform.assetplan.entity.DeptInfo;
import com.h3c.platform.assetplan.service.AssetRateInfoService;
import com.h3c.platform.assetplan.service.DeptInfoService;
import com.h3c.platform.response.ResponseResult;

import com.h3c.platform.assetplan.entity.RateTotalInfo;
import com.h3c.platform.assetplan.entity.SearchRateParamEntity;

@Service
public class AssetRateInfoServiceImpl implements AssetRateInfoService {
	
	@Autowired
	private AssetRateInfoMapper assetRateInfoMapper;
	@Autowired
	private DeptInfoService deptInfoService;
	
	/**
	 * 获取前60天部门及研发总体使用率数据
	 * @param model 型号
	 * @param deptCode 部门编码
	 * @param date 日期
	 * @return
	 */
	private List<AssetRateInfo> getRDRateInfoWithRD(String model ,String deptCode ,Date date)  {
		Calendar calendar=Calendar.getInstance();  
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH,-60);
		Map<String,Object> param=new HashMap<String, Object>();
		param.put("begin", calendar.getTime());
		param.put("end", date);
		param.put("model", model);
		param.put("deptCode", deptCode);
		param.put("deptName", "研发总体");
		List<AssetRateInfo> lst=assetRateInfoMapper.selectbyMap(param);
		return lst;
	}

	/**
	 *@model 型号
	 *@deptCode 三级部门编码
	 *@date 日期
	 */
	@Override
	public RateTotalInfo getRate(String model,String deptCode ,Date date)throws Exception  {
		RateTotalInfo rateTotal=new RateTotalInfo();	
		Map<String,Object> mapRD= new HashMap<>();		
		
		//存储使用路分布
		List<String> lstDis=new ArrayList<String>();
		DeptInfo deptInfo = deptInfoService.getByCode(deptCode);
		if(deptInfo.getDeptCode()==null) {
			throw new Exception("未找到当前部门");
		}
		//交换机和路由器预算部门为三级，其余为二级
		if(!"50042493".contentEquals(deptInfo.getSupDeptCode())&&!"50042499".contentEquals(deptInfo.getSupDeptCode())) {
			deptCode = deptInfo.getSupDeptCode();
		}
		rateTotal.setDeptCode(deptInfo.getDeptCode().toString());
		rateTotal.setDeptName(StringUtils.isBlank(deptInfo.getDeptName())?"":deptInfo.getDeptName());
		rateTotal.setModel(model);	
		
		//使用率数据集合
		List<AssetRateInfo> lstAll = getRDRateInfoWithRD( model, deptCode , date); 
		List<AssetRateInfo> lst = lstAll.stream().filter(o->!"研发总体".equals(o.getDeptName())).collect(Collectors.toList());
		List<AssetRateInfo> lstRD = lstAll.stream().filter(o->"研发总体".equals(o.getDeptName())).collect(Collectors.toList());
		//平均值
		String deptUsageRate=getRateAvg(lst);	

		if(CollectionUtils.isEmpty(lst)) {
			rateTotal.setRate("");
		}else {
			rateTotal.setRate(deptUsageRate+"%");
		}
		List<AssetRateInfo> lstRepeat=lst.stream().filter(distinctByKey(AssetRateInfo::getAssertNumber)).collect(Collectors.toList());
		rateTotal.setNumber(lstRepeat.size());
		rateTotal.setDistribution(getDistribution(lstRepeat));
		rateTotal.setDetail(getRateDetail(lst));

		mapRD=getRDRate( model, deptCode,date,lstRD);
		rateTotal.setRdRate((String)mapRD.get("rate"));
		rateTotal.setRdNumber((Integer)mapRD.get("number"));
		rateTotal.setRatedetail(rateTotal.getRate()+"/"+rateTotal.getRdRate());
		
		return rateTotal;
	}
	
	/**
	 * 获取使用分布
	 * @param lst
	 * @return
	 */
	private String getDistribution(List<AssetRateInfo> lst) {
		List<String> lstDis= new ArrayList<String>();
		Map<String,List<AssetRateInfo>> mapDis= lst.stream().filter(distinctByKey(AssetRateInfo::getAssertNumber)).collect(Collectors.groupingBy(AssetRateInfo::getArea));
		for(String key:mapDis.keySet()) {
			lstDis.add(key+"："+(mapDis.get(key)).size()+"pcs");
		}
		return String.join(";", lstDis);
	}
	
	/**
	 * 获取使用率明细
	 * @param lst
	 * @return
	 */
	private String getRateDetail(List<AssetRateInfo> lst) {
		int lessThirty=0,lessSixty=0,lessHundred=0;
		Map<String,List<AssetRateInfo>> mapDetail= lst.stream().collect(Collectors.groupingBy(AssetRateInfo::getAssertNumber));
		for(String key:mapDetail.keySet()) {
			List<Double> lstDetailRate=new ArrayList<Double>();
			List<AssetRateInfo> lstTemp=mapDetail.get(key);
			lstTemp.stream().forEach(o->{
				if(StringUtils.isNotBlank(o.getUsageRate())) {
					lstDetailRate.add(Double.parseDouble(o.getUsageRate()));					
				}
			});
			double avg = lstDetailRate.stream().collect(Collectors.averagingDouble(Double::doubleValue));
			
			//0-30
			if(Double.compare(avg, 0)!=-1 &&Double.compare(avg, 0.3)==-1) {
				++lessThirty;
			}
			//30-60
			if(Double.compare(avg, 0.3)!=-1 &&Double.compare(avg, 0.6)==-1) {
				++lessSixty;
			}
			//60-100
			if(Double.compare(avg, 0.6)!=-1 &&Double.compare(avg, 1)==-1) {
				++lessHundred;
			}
		}
		return "使用率0~30%: "+lessThirty+"pcs;使用率30~60%: "+lessSixty+"pcs;使用率60~100%："+lessHundred+"pcs";
	}
	
	/**
	 * 求使用率平均值 ，百分比保留整数
	 * @param lst
	 * @return
	 */
	private String getRateAvg(List<AssetRateInfo> lst) {
		double rates=0 ,usageRate=0;
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
		
		return deptUsageRate;
	}
	
	/**
	 * 获取研发整体使用率
	 * @param type
	 * @param deptCode
	 * @param bef
	 * @param end
	 * @return
	 */
	private Map<String,Object> getRDRate(String model,String deptCode,Date date,List<AssetRateInfo> lst) {
		Map<String,Object> mapRD= new HashMap<>();
		mapRD.put("deptName", "研发总体");
		mapRD.put("type", model);
		double rates=0 ,usageRate=0;
		
		//List<AssetRateInfo> lst = getRDRateInfo(model,date);

		
		if(CollectionUtils.isEmpty(lst)) {
			mapRD.put("rate", "");
			mapRD.put("isEmpty", true);			
		}else {
			
			String RDUsageRate =getRateAvg(lst);
			mapRD.put("rate",RDUsageRate+"%");
			mapRD.put("isEmpty", false);
		}
		List<AssetRateInfo> lstRepeat=lst.stream().filter(distinctByKey(AssetRateInfo::getAssertNumber)).collect(Collectors.toList());
		mapRD.put("number", lstRepeat.size());
		return mapRD ;
	}
	
	public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
		  Set<Object> seen = ConcurrentHashMap.newKeySet();
		  return t -> seen.add(keyExtractor.apply(t));
	}
	
	@Override
	public ResponseResult getList(SearchRateParamEntity search)throws Exception{		
		DeptInfo deptInfo = deptInfoService.getByCode(search.getDeptCode());
		if(deptInfo.getDeptCode()==null) {
			return ResponseResult.fail("未找到当前部门");
		}
		//交换机和路由器预算部门为三级，其余为二级
		if(!"50042493".contentEquals(deptInfo.getSupDeptCode())&&!"50042499".contentEquals(deptInfo.getSupDeptCode())) {
			search.setDeptCode(deptInfo.getSupDeptCode());
		}
		
		Calendar calendar=Calendar.getInstance();  
		calendar.setTime(search.getCollectTime());
		calendar.add(Calendar.DAY_OF_MONTH,-60);
		Map<String,Object> param=new HashMap<String, Object>();
		param.put("begin", calendar.getTime());
		param.put("end", search.getCollectTime());
		param.put("model", search.getAssetCategory());
		param.put("deptCode", search.getDeptCode());
		PageHelper.startPage(search.getPageNum(), search.getPageSize());		
		List<AssetRateInfo> lst=assetRateInfoMapper.selectbyMap(param);
		PageInfo<AssetRateInfo> pageInfo=new PageInfo<AssetRateInfo>(lst);
		
		return ResponseResult.success(0, "查询成功", search.getPageSize(), pageInfo.getTotal(),null,  pageInfo.getList());
	}
}
