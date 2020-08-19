package com.h3c.platform.assetplan.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.h3c.platform.annotation.UserLoginToken;
import com.h3c.platform.assetplan.entity.AssetRateInfo;
import com.h3c.platform.assetplan.entity.RateTotalInfo;
import com.h3c.platform.assetplan.entity.SearchRateParamEntity;
import com.h3c.platform.assetplan.service.AssetRateInfoService;
import com.h3c.platform.assetplan.service.RateTotalInfoService;
import com.h3c.platform.response.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/usageRate")
@Api(value="使用率相关接口",tags="使用率相关接口")
public class UsageRateContorller {
	
	@Autowired
	private AssetRateInfoService rateInfoService; 
	@Autowired
	private RateTotalInfoService rateTotalInfoService;
	
	@UserLoginToken
	@GetMapping("/getRate")
	@ApiOperation("获取使用率统计信息")	
	public ResponseResult getRate(SearchRateParamEntity param) throws Exception{
		RateTotalInfo total= rateTotalInfoService.getRateTotalInfoById(param.getId());
		if(total==null||total.getId()==null||total.getId()==0) {
			total =rateInfoService.getRate(param.getAssetCategory(), param.getDeptCode(), param.getCollectTime());
		}
		return ResponseResult.success(total);		
	} 
	
	@UserLoginToken
	@PostMapping("/getRateList")
	@ApiOperation("获取使用率列表详情")		
	public ResponseResult getRateList(@RequestBody SearchRateParamEntity param) throws Exception{
		return rateInfoService.getList(param);
	} 

}
