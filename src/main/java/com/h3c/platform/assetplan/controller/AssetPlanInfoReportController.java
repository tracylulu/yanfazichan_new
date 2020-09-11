
package com.h3c.platform.assetplan.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.h3c.platform.annotation.UserLoginToken;
import com.h3c.platform.assetplan.entity.AssetInfoReportEntity;
import com.h3c.platform.assetplan.entity.AssetInfoReportSearchEntity;
import com.h3c.platform.assetplan.entity.AssetPlanInfoReportView;
import com.h3c.platform.assetplan.entity.DeptInfo;
import com.h3c.platform.assetplan.entity.SearchAssetParamEntity;
import com.h3c.platform.assetplan.service.AssetPlanInfoReportService;
import com.h3c.platform.assetplan.service.DeptInfoService;
import com.h3c.platform.common.commonconst.DicConst;
import com.h3c.platform.common.service.SysDicInfoService;
import com.h3c.platform.response.ResponseResult;
import com.h3c.platform.util.SysDicInfoUtil;

@Controller
@RequestMapping("/assetplan/report")
@CrossOrigin
@Api(value = "资产报表信息相关接口",tags = {"资产报表信息相关接口"})
public class AssetPlanInfoReportController {

    @Autowired
    private AssetPlanInfoReportService assetPlanInfoReportService;
	@Autowired
	private SysDicInfoService sysDicInfoService;
	@Autowired
	private SysDicInfoService dicService;
	@Autowired
	private SysDicInfoUtil sysDicInfoUtil;
	@Autowired
	private DeptInfoService deptService;
	
    @PostMapping("/listOfAssetPlanInfoReport")
    @ApiOperation(value = "获取所有资产查询报表数据信息")
    @ResponseBody
    @UserLoginToken
    public ResponseResult listOfAssetPlanInfoReport(@RequestBody @ApiParam(name="查询对象",value="传入json格式",required=true) AssetInfoReportSearchEntity reportSearchEntity) throws Exception{
    	Map<String, Object> param = new HashMap<>();
    	Integer pageNum = reportSearchEntity.getPageNum();
    	Integer pageSize = reportSearchEntity.getPageSize();
    	param.put("AssetCategory", reportSearchEntity.getAssetcategory());
    	param.put("AssetManufacturer", reportSearchEntity.getAssetmanufacturer());
    	param.put("BudgetDeptCode", reportSearchEntity.getBudgetDeptCode());
    	if(StringUtils.isNotBlank(reportSearchEntity.getStartTime())) {
    		param.put("StartTime", reportSearchEntity.getStartTime()+" 00:00:00");
    	}else {
    		param.put("StartTime", null);
    	}
    	if(StringUtils.isNotBlank(reportSearchEntity.getEndTime())) {
    		param.put("EndTime", reportSearchEntity.getEndTime()+" 23:59:59");
    	}else {
    		param.put("EndTime", null);
    	}
    	
		//封装返回数据的表头信息
		List<Map<String, Object>> columnList = sysDicInfoService.getColumn(DicConst.ASSETPLANINFOSEARCHVIEW);
		com.github.pagehelper.page.PageMethod.startPage(pageNum,pageSize);
		List<AssetPlanInfoReportView> planInfoReportList = assetPlanInfoReportService.listofAssetPlanInfoForReport(param);
		planInfoReportList = sysDicInfoUtil.replaceDicCategoryForReport(planInfoReportList);
		PageInfo<AssetPlanInfoReportView> pageInfo = new PageInfo<>(planInfoReportList);
		
		return ResponseResult.success(0, "查询成功", pageNum, pageInfo.getTotal(),columnList, pageInfo.getList());
    }
    
   
    @ApiOperation(value="饼图按物品类别和收益统计")
    @PostMapping("/pieChartByModel")
   	@ResponseBody
   	@UserLoginToken
   	public ResponseResult pieChartByModel(@RequestBody @ApiParam(name="查询对象",value="传入json格式",required=true) AssetInfoReportSearchEntity reportSearchEntity) throws Exception{
    	Map<String, Object> param = new HashMap<>();
    	param.put("AssetCategory", reportSearchEntity.getAssetcategory());
    	param.put("AssetManufacturer", reportSearchEntity.getAssetmanufacturer());
    	param.put("BudgetDeptCode", reportSearchEntity.getBudgetDeptCode());
    	if(StringUtils.isNotBlank(reportSearchEntity.getStartTime())) {
    		param.put("StartTime", reportSearchEntity.getStartTime()+" 00:00:00");
    	}else {
    		param.put("StartTime", null);
    	}
    	if(StringUtils.isNotBlank(reportSearchEntity.getEndTime())) {
    		param.put("EndTime", reportSearchEntity.getEndTime()+" 23:59:59");
    	}else {
    		param.put("EndTime", null);
    	}
    	List<AssetInfoReportEntity> dataForPieChart = assetPlanInfoReportService.getDataForPieChart(param);
   		JSONArray arrayData = new JSONArray();
		com.alibaba.fastjson.JSONArray objDic=dicService.getJsonArrayDicsByType(DicConst.R_CATEGORY,"1");
    	for (int i = 0; i < dataForPieChart.size(); i++) {
    		if("0.00".equals(dataForPieChart.get(i).getPieChartMoney())) {
    			continue;
    		}else {
    	   		JSONObject json =new JSONObject();
       			for (int j = 0; i < objDic.size(); j++) {
       				com.alibaba.fastjson.JSONObject obj= objDic.getJSONObject(j);
       				String value= obj.get("dic_value")==null?"":obj.get("dic_value").toString();
       				String[] arrvalue =value.split("_");
       				String id= (String) obj.get("dic_code");
       				String assetcategory= arrvalue[2];
       				//String goodstime=arrvalue[3];
       				if(id.equals(dataForPieChart.get(i).getAssetCategory())) {
       					json.put("x", assetcategory);
       					break;
       				}
       			}
        		json.put("y", dataForPieChart.get(i).getPieChartMoney());
        		arrayData.add(json);
    		}
		}
    	//System.out.println(arrayData);
    	return ResponseResult.success(0, "查询成功", arrayData, arrayData.size());
   	}
  
    
    @ApiOperation(value="折线图按年月和收益统计")
    @PostMapping("/lineChartByApplymonth")
   	@ResponseBody
   	@UserLoginToken
   	public ResponseResult lineChartByApplymonth(@RequestBody @ApiParam(name="查询对象",value="传入json格式",required=true) AssetInfoReportSearchEntity reportSearchEntity) throws Exception{
    	Map<String, Object> param = new HashMap<>();
    	param.put("AssetCategory", reportSearchEntity.getAssetcategory());
    	param.put("AssetManufacturer", reportSearchEntity.getAssetmanufacturer());
    	param.put("BudgetDeptCode", reportSearchEntity.getBudgetDeptCode());
    	if(StringUtils.isNotBlank(reportSearchEntity.getStartTime())) {
    		param.put("StartTime", reportSearchEntity.getStartTime()+" 00:00:00");
    	}else {
    		param.put("StartTime", null);
    	}
    	if(StringUtils.isNotBlank(reportSearchEntity.getEndTime())) {
    		param.put("EndTime", reportSearchEntity.getEndTime()+" 23:59:59");
    	}else {
    		param.put("EndTime", null);
    	}
   		List<AssetInfoReportEntity> dataForLineChart = assetPlanInfoReportService.getDataForLineChart(param);
   		JSONArray arrayData = new JSONArray();
    	for (int i = 0; i < dataForLineChart.size(); i++) {
    		if("0.00".equals(dataForLineChart.get(i).getLineChartMoney())) {
    			continue;
    		}else {
    			JSONObject json =new JSONObject();
        		//String applymonth = dataForLineChart.get(i).getApplymonth();
        		json.put("x", dataForLineChart.get(i).getApplymonth());
        		json.put("y", dataForLineChart.get(i).getLineChartMoney());
        		arrayData.add(json);
    		}
		}
    	//System.out.println(arrayData);
    	return ResponseResult.success(0, "查询成功", arrayData, 0);
   	}
    
    
    @ApiOperation(value="柱状图按部门和收益统计")
    @PostMapping("/barChartByDeptCode")
   	@ResponseBody
   	@UserLoginToken
   	public ResponseResult barChartByDeptCode(@RequestBody @ApiParam(name="查询对象",value="传入json格式",required=true) AssetInfoReportSearchEntity reportSearchEntity) throws Exception{
    	Map<String, Object> param = new HashMap<>();
    	param.put("AssetCategory", reportSearchEntity.getAssetcategory());
    	param.put("AssetManufacturer", reportSearchEntity.getAssetmanufacturer());
    	param.put("BudgetDeptCode", reportSearchEntity.getBudgetDeptCode());
    	if(StringUtils.isNotBlank(reportSearchEntity.getStartTime())) {
    		param.put("StartTime", reportSearchEntity.getStartTime()+" 00:00:00");
    	}else {
    		param.put("StartTime", null);
    	}
    	if(StringUtils.isNotBlank(reportSearchEntity.getEndTime())) {
    		param.put("EndTime", reportSearchEntity.getEndTime()+" 23:59:59");
    	}else {
    		param.put("EndTime", null);
    	}
   		List<AssetInfoReportEntity> dataForDept3BarChart = assetPlanInfoReportService.getDataForDept3BarChart(param);
   		List<AssetInfoReportEntity> dataForDept2BarChart = assetPlanInfoReportService.getDataForDept2BarChart(param);
   		JSONArray arrayData = new JSONArray();
   		List<String> listCode=new ArrayList<>();
   		//获取字典表中的部门code
   		JSONArray objDicBudget=sysDicInfoService.getJsonArrayDicsByType(DicConst.R_BUDGET,"1");
   		for (int i = 0; i < objDicBudget.size(); i++) {
				JSONObject obj= objDicBudget.getJSONObject(i);
				String code= obj.get("dic_code")==null?"":obj.get("dic_code").toString();
				listCode.add(code);
			}
   		
    	for (int i = 0; i < dataForDept3BarChart.size(); i++) {
    		if(listCode.contains(dataForDept3BarChart.get(i).getDept3code())) {
    			if("0.00".equals(dataForDept3BarChart.get(i).getBarChartMoney())) {
        			continue;
        		}else {
        			JSONObject json =new JSONObject();
            		json.put("x", dataForDept3BarChart.get(i).getDept3name());
            		json.put("y", dataForDept3BarChart.get(i).getBarChartMoney());
            		arrayData.add(json);
        		}
    		}
		}
    	for (int i = 0; i < dataForDept2BarChart.size(); i++) {
    		if(listCode.contains(dataForDept2BarChart.get(i).getDept2code())) {
    			if("0.00".equals(dataForDept2BarChart.get(i).getBarChartMoney())) {
        			continue;
        		}else {
        			JSONObject json =new JSONObject();
            		json.put("x", dataForDept2BarChart.get(i).getDept2name());
            		json.put("y", dataForDept2BarChart.get(i).getBarChartMoney());
            		arrayData.add(json);
        		}
    		}
		}
    	//System.out.println(arrayData);
    	return ResponseResult.success(0, "查询成功", arrayData, 0);
   	}
    
    
    @ApiOperation(value="返回所有的预算部门列表")
    @GetMapping("/getBudgetDeptList")
   	@ResponseBody
   	@UserLoginToken
   	public ResponseResult getBudgetDeptList() throws Exception{
   		List<DeptInfo> budgetDeptList=new ArrayList<>();
   		//获取字典表中的部门code
   		JSONArray objDicBudget=sysDicInfoService.getJsonArrayDicsByType(DicConst.R_BUDGET,"1");
   		for (int i = 0; i < objDicBudget.size(); i++) {
				JSONObject obj= objDicBudget.getJSONObject(i);
				String code= obj.get("dic_code")==null?"":obj.get("dic_code").toString();
				DeptInfo dept = deptService.getByCode(code);
				//只把二三级部门的预算部门传给前台展示,因为报表中只展示了二三级部门的预算信息
				if("2".equals(dept.getDeptLevel()) || "3".equals(dept.getDeptLevel())) {
					budgetDeptList.add(dept);
				}
			}
   		budgetDeptList = budgetDeptList.stream().sorted(Comparator.comparing(DeptInfo::getDeptLevel)).collect(Collectors.toList());
    	System.out.println(budgetDeptList);
    	return ResponseResult.success(0, "查询成功", budgetDeptList, budgetDeptList.size());
   	}
}


