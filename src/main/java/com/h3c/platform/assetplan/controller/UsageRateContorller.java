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
import com.h3c.platform.assetplan.service.AssetRateInfoService;
import com.h3c.platform.response.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/usageRate")
@Api(value="使用率相关接口",tags="使用率相关接口")
public class UsageRateContorller {
	
	@Autowired
	private AssetRateInfoService rateInfoService;
	
	@UserLoginToken
	@PostMapping("/getRate")
	@ApiOperation("获取使用率")	
	@DateTimeFormat(pattern ="yyyy-MM-dd HH:mm:ss")
	public ResponseResult getRate(@RequestBody AssetRateInfo assetRateInfo) throws Exception{
		return ResponseResult.success(rateInfoService.getRate(assetRateInfo.getAssetCategory(), assetRateInfo.getDeptCode(), assetRateInfo.getCollectTime()));		
	} 

}
