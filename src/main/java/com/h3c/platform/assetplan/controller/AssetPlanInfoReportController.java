
package com.h3c.platform.assetplan.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.h3c.platform.annotation.UserLoginToken;
import com.h3c.platform.assetplan.entity.AssetInfoReportEntity;
import com.h3c.platform.assetplan.entity.AssetPlanInfoReportView;
import com.h3c.platform.assetplan.service.AssetPlanInfoReportService;
import com.h3c.platform.common.commonconst.DicConst;
import com.h3c.platform.common.service.SysDicInfoService;
import com.h3c.platform.response.ResponseResult;

@Controller
@RequestMapping("/assetplan/report")
@CrossOrigin
@Api(value = "资产报表信息相关接口",tags = {"资产报表信息相关接口"})
public class AssetPlanInfoReportController {

    @Autowired
    private AssetPlanInfoReportService assetPlanInfoReportService;
  
	@Autowired
	private SysDicInfoService sysDicInfoService;

	
    @GetMapping("/listOfAssetPlanInfoReport")
    @ApiOperation(value = "获取所有资产查询报表数据信息")
    @ResponseBody
    @UserLoginToken
    public ResponseResult listOfAssetPlanInfoReport(@RequestParam @ApiParam(name="pageSize",value="每页行数",required=true)int pageSize,
   					@RequestParam @ApiParam(name="pageNum",value="页码",required=true)int pageNum) throws Exception{
    	  
    		Map<String, Object> param = new HashMap<>();
    		//封装返回数据的表头信息
			List<Map<String, Object>> columnList = sysDicInfoService.getColumn(DicConst.ASSETPLANINFOSEARCHVIEW);
   			PageHelper.startPage(pageNum, pageSize);
			List<AssetPlanInfoReportView> planInfoReportList = assetPlanInfoReportService.listofAssetPlanInfoForReport(param);
			PageInfo<AssetPlanInfoReportView> pageInfo = new PageInfo<AssetPlanInfoReportView>(planInfoReportList);
   			
   			return ResponseResult.success(0, "查询成功", pageNum, pageInfo.getTotal(),columnList, pageInfo.getList());
    }
    
   
    @ApiOperation(value="饼图按类型和收益统计")
    @GetMapping("/pieChartByModel")
   	@ResponseBody
   	@UserLoginToken
   	public ResponseResult pieChartByModel() throws Exception{
   		List<AssetInfoReportEntity> dataForPieChart = assetPlanInfoReportService.getDataForPieChart();
   		JSONArray arrayData = new JSONArray();
    	for (int i = 0; i < dataForPieChart.size(); i++) {
    		if("0.00".equals(dataForPieChart.get(i).getPieChartMoney())) {
    			continue;
    		}else {
    			JSONObject json =new JSONObject();
        		json.put("x", dataForPieChart.get(i).getAssetmodel());
        		json.put("y", dataForPieChart.get(i).getPieChartMoney());
        		arrayData.add(json);
    		}
		}
    	System.out.println(arrayData);
    	return ResponseResult.success(0, "查询成功", arrayData, arrayData.size());
   	}
  
    
    @ApiOperation(value="折线图按年月和收益统计")
    @GetMapping("/lineChartByApplymonth")
   	@ResponseBody
   	@UserLoginToken
   	public ResponseResult lineChartByApplymonth() throws Exception{
   		List<AssetInfoReportEntity> dataForLineChart = assetPlanInfoReportService.getDataForLineChart();
   		JSONArray arrayData = new JSONArray();
    	for (int i = 0; i < dataForLineChart.size(); i++) {
    		if("0.00".equals(dataForLineChart.get(i).getLineChartMoney())) {
    			continue;
    		}else {
    			JSONObject json =new JSONObject();
        		String applymonth = dataForLineChart.get(i).getApplymonth();
        		json.put("x", dataForLineChart.get(i).getApplymonth());
        		json.put("y", dataForLineChart.get(i).getLineChartMoney());
        		arrayData.add(json);
    		}
    		
		}
   		/*for (int i = 1; i <= 12; i++) {
			for (int j = 0; j < dataForLineChart.size(); j++) {
				String applymonth = dataForLineChart.get(j).getApplymonth();
				if(applymonth.contains(i+"")) {
				}
			}
		}*/
    	System.out.println(arrayData);
    	return ResponseResult.success(0, "查询成功", arrayData, 0);
   	}
    
    
    @ApiOperation(value="柱状图按部门和收益统计")
    @GetMapping("/barChartByDeptCode")
   	@ResponseBody
   	@UserLoginToken
   	public ResponseResult barChartByDeptCode() throws Exception{
   		List<AssetInfoReportEntity> dataForBarChart = assetPlanInfoReportService.getDataForBarChart();
   		JSONArray arrayData = new JSONArray();
   		List<String> listCode=new ArrayList<>();
   		//获取字典表中的部门code
   		JSONArray objDicBudget=sysDicInfoService.getJSONArrayDicsByType(DicConst.R_BUDGET);
   		for (int i = 0; i < objDicBudget.size(); i++) {
				JSONObject obj= objDicBudget.getJSONObject(i);
				String code= obj.get("dic_code")==null?"":obj.get("dic_code").toString();
				listCode.add(code);
			}
   		
    	for (int i = 0; i < dataForBarChart.size(); i++) {
    		if(listCode.contains(dataForBarChart.get(i).getDeptCode())) {
    			if("0.00".equals(dataForBarChart.get(i).getBarChartMoney())) {
        			continue;
        		}else {
        			JSONObject json =new JSONObject();
            		json.put("x", dataForBarChart.get(i).getDeptCode());
            		json.put("y", dataForBarChart.get(i).getBarChartMoney());
            		arrayData.add(json);
        		}
    		}
		}
    	System.out.println(arrayData);
    	return ResponseResult.success(0, "查询成功", arrayData, 0);
   	}
    
    
    
}


