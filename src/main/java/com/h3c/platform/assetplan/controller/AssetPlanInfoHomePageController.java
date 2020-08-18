package com.h3c.platform.assetplan.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.h3c.platform.assetplan.entity.AssetPlanInfo;
import com.h3c.platform.assetplan.entity.AssetPlanInfoApplyView;
import com.h3c.platform.assetplan.entity.AssetPlanInfoDept1View;
import com.h3c.platform.assetplan.entity.AssetPlanInfoDept2View;
import com.h3c.platform.assetplan.entity.AssetPlanInfoDept3View;
import com.h3c.platform.assetplan.entity.AssetPlanInfoHomePageView;
import com.h3c.platform.assetplan.entity.AssetPlanInfoMenuView;
import com.h3c.platform.assetplan.entity.AssetPlanInfoOQDeptView;
import com.h3c.platform.assetplan.entity.AssetPlanInfoPlannerView;
import com.h3c.platform.assetplan.entity.AssetPlanInfoReviewView;
import com.eos.common.constant.StatusCodeEnum;
import com.eos.common.util.Result;
import com.h3c.platform.annotation.UserLoginToken;
import com.h3c.platform.assetplan.dao.AssetPlanInfoMapper;
import com.h3c.platform.assetplan.entity.AssetPlanGlobalInfo;
import com.h3c.platform.assetplan.service.AssetPlanInfoService;
import com.h3c.platform.common.commonconst.DicConst;
import com.h3c.platform.common.commonconst.LogType;
import com.h3c.platform.common.service.SysDicInfoService;
import com.h3c.platform.response.ResponseResult;
import com.h3c.platform.sysmgr.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/assetplan/homePage")
@Api(value = "首页菜单栏相关接口",tags = {"首页菜单栏相关接口"})
@CrossOrigin
public class AssetPlanInfoHomePageController {

	@Autowired
	private AssetPlanInfoService assetPlanInfoService;
	@Autowired
	private AssetPlanInfoMapper assetPlanInfoMapper;
	@Autowired
	private UserService userService;
	@Autowired
	private SysDicInfoService sysDicInfoService;
	@Value("${file.path}")
	private String filePath;
    
    @ApiOperation(value="根据当前登录人的工号获取待处理信息")
	@GetMapping("/getTodoInfoByApplyCode")
	@ResponseBody
	@UserLoginToken
	public ResponseResult getTodoInfoByApplyCode(@RequestParam @ApiParam(name="applyuser",value="当前登录人的工号",required=true)String applyuser) throws Exception{
		//try {
			
			//封装返回数据的表头信息
			List<Map<String, Object>> columnList = sysDicInfoService.getColumn(DicConst.ASSETPLANINFOMENUVIEW);
			
			if(StringUtils.isNotBlank(applyuser)){
	  			Map<String, Object> param = new HashMap<>();
	            param.put("ApplyUser", applyuser);
	            JSONArray arrayData = new JSONArray();
	            
	            List<AssetPlanInfoMenuView> todoList = assetPlanInfoService.listofTodoInfo(param);
	            
	            for (int i = 0; i < todoList.size(); i++) {
	            	
	            	JSONObject json=new JSONObject();
	            	json.put("apstage", todoList.get(i).getApstage());
	            	json.put("apstatusdetail", todoList.get(i).getApstatusdetail());
	            	json.put("applymonth", todoList.get(i).getApplymonth());
	            	arrayData.add(json);
				}
				return ResponseResult.success(0, "查询成功", 0, todoList.size(), columnList, arrayData);
	  		}else {
	  			return ResponseResult.fail("查询失败，人员不匹配");
	  		}
			
		/*} catch (Exception e) {
			e.printStackTrace();
			return ResponseResult.fail("查询失败");
		}*/
	}
	
    @ApiOperation(value="根据当前登录人的工号获取申购人的待处理信息")
	@GetMapping("/getTodoInfoByRequiredUser")
	@ResponseBody
	@UserLoginToken
	public ResponseResult getTodoInfoByRequiredUser(@RequestParam @ApiParam(name="applyuser",value="当前登录人的工号",required=true)String applyuser) throws Exception{
		//try {
			
			//封装返回数据的表头信息
			List<Map<String, Object>> columnList = sysDicInfoService.getColumn(DicConst.ASSETPLANINFOMENUVIEW);
			
			if(StringUtils.isNotBlank(applyuser)){
	  			Map<String, Object> param = new HashMap<>();
	            param.put("RequiredUser", applyuser);
	            JSONArray arrayData = new JSONArray();
	            
	            List<AssetPlanInfoMenuView> todoList = assetPlanInfoService.listofTodoInfoForRequiredUser(param);
	            
	            for (int i = 0; i < todoList.size(); i++) {
	            	
	            	JSONObject json=new JSONObject();
	            	json.put("apstage", todoList.get(i).getApstage());
	            	json.put("apstatusdetail", todoList.get(i).getApstatusdetail());
	            	json.put("applymonth", todoList.get(i).getApplymonth());
	            	arrayData.add(json);
				}
				return ResponseResult.success(0, "查询成功", 0, todoList.size(), columnList, arrayData);
	  		}else {
	  			return ResponseResult.fail("查询失败，人员不匹配");
	  		}
			
		/*} catch (Exception e) {
			e.printStackTrace();
			return ResponseResult.fail("查询失败");
		}*/
	}
    
    @ApiOperation(value="根据文件名获取系统文件")
	@GetMapping("/download")
	@ResponseBody
	@UserLoginToken
	public void download( HttpServletResponse response, HttpServletRequest request, @RequestParam @ApiParam(name="fileUrl",value="文件名",required=true)String fileUrl) {
		try {
			File file = new File(fileUrl);
			String filename = file.getName();
			// 以流的形式下载文件。
			InputStream fis = new BufferedInputStream(new FileInputStream(filePath + fileUrl));
			byte[] buffer = new byte[fis.available()];
			fis.read(buffer);
			fis.close();
			// 清空response
			response.reset();

			response.setContentType("application/octet-stream;charset=UTF-8");
			String fileName = new String(filename.getBytes("gb2312"), "ISO-8859-1");
			response.setHeader("Content-disposition", "attachment;filename=" + fileName);
			OutputStream ouputStream = response.getOutputStream();
			ouputStream.write(buffer);
			ouputStream.flush();
			ouputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
  
	//不需要此接口，调用不同的展示列表接口即可
   /* @ApiOperation(value="查看待处理的单条资源信息（返回对应审批阶段环节的页面数据）")
	@PostMapping("/getTodoInfoDetailByApplyCode")
	@ResponseBody
	public ResponseResult getTodoInfoDetailByApplyCode(@RequestParam @ApiParam(name="applyuser",value="当前登录人的工号",required=true)String applyuser,
			@RequestParam @ApiParam(name="apstage",value="物品所处的审批阶段",required=true)String apstage) {
	public ResponseResult getTodoInfoDetailByApplyCode(@RequestParam @ApiParam(name="applymonth",value="申请月份",required=true)String applymonth,
														@ApiParam(name="applyuser",value="当前登录人的工号",required=true)String applyuser,
														@ApiParam(name="apstage",value="当前审批阶段",required=true)String apstage) {	
    	try {
			//Subject subject = SecurityUtils.getSubject();
	  		//User user = (User)subject.getSession().getAttribute("current_user");
			//String userId = UserUtils.getCurrentUserId();
	  		//String userCode="cYS1425";
    			//AssetPlanInfo ap = assetPlanInfoMapper.selectByPrimaryKey(assetplanid);
    			//String apstage = ap.getApstage();
    			Map<String, Object> param = new HashMap<>();
	   			JSONArray arrayData = new JSONArray();
	   			JSONObject json=new JSONObject();
    			//根据当前的审批阶段来判断返回那个页面的数据
    			if(StringUtils.isNotBlank(apstage)){
    				//申请阶段
    				if("1".equals(apstage)) {
    					//String applyUser=ap.getApplyuser();
    					//封装返回数据的表头信息(表头的方法通过传参把不相同的摘取出来)---改成去不同的视图即可
    		   			//JSONArray arrayTableData = this.generateTableHeaderForAll(apstage);
    					List<Map<String, Object>> columnList = sysDicInfoService.getColumn("AssetPlanInfoApplyView");
    					
						List<AssetPlanInfoApplyView> draftInfoList = assetPlanInfoService.getDraftInfoListMenu(applyuser,applymonth);
		   				if(draftInfoList.size()>0) {
		   					param.put("ApplyUser",applyuser);
			   				param.put("APStage",apstage);
			   				String totalmoneySum = assetPlanInfoService.getSumTotalMoneyForDraft(param);
			   				//申购金额合计  totalmoneySum
			   				json.put("TotalmoneySum",new BigDecimal(totalmoneySum));
			   				//数据集list
			   				json.put("DataSet" , draftInfoList);
			   				arrayData.add(json);	
			   				return ResponseResult.success(0, "查询成功", 0, draftInfoList.size(), columnList, arrayData);
		   				}else {
		   					return ResponseResult.fail(false, "查询失败，没有要返回的数据");
		   				}
    				}else if("2".equals(apstage)) {
    					//规范审核阶段
    					String reviewer=applyuser;
    					//封装返回数据的表头信息
    					//JSONArray arrayTableData = this.generateTableHeaderForAll(apstage);
    					List<Map<String, Object>> columnList = sysDicInfoService.getColumn("AssetPlanInfoReviewView");
    					
		   				List<AssetPlanInfoReviewView> reviewInfoList = assetPlanInfoService.getReviewInfoListMenu(reviewer,apstage);
		   				if(reviewInfoList.size()>0) {
		   					param.put("Reviewer",reviewer);
			   				param.put("APStage",apstage);
			   				//全选0  规范1  不规范2  未审核3  在审核4   展示列表默认全选 
			   				param.put("ReviewResult","0");
			   				String totalmoneySum = assetPlanInfoService.getSumTotalMoneyForReview(param);
			   				//申购金额合计  totalmoneySum
			   				json.put("TotalmoneySum",new BigDecimal(totalmoneySum));
			   				//数据集list
			   				json.put("DataSet" , reviewInfoList);
			   				arrayData.add(json);	
			   				return ResponseResult.success(0, "查询成功", 0, reviewInfoList.size(), columnList, arrayData);
		   				}else {
		   					return ResponseResult.fail(false, "查询失败，没有要返回的数据");
		   				}
    				}else if("3".equals(apstage)) {
    					//三级部门审核阶段
    					String dept3Manager=ap.getDept3manager();
    					//封装返回数据的表头信息
    					//JSONArray arrayTableData = this.generateTableHeaderForAll(apstage);
    					List<Map<String, Object>> columnList = sysDicInfoService.getColumn("AssetPlanInfoDept3View");
    					
		   				List<AssetPlanInfoDept3View> dept3InfoList = assetPlanInfoService.getDept3InfoList(dept3Manager,apstage);
		   				if(dept3InfoList.size()>0) {
		   					param.put("Dept3Manager",dept3Manager);
			   				param.put("APStage",apstage);
			   				//申购金额合计  totalmoneySum
			   				String totalmoneySum = assetPlanInfoService.getSumTotalMoneyForDept3(param);
			   				//同意申购金额合计  ActualMoneySum
			   				String actualMoneySum = assetPlanInfoService.getSumActualMoneySumForDept3(param);
			   				json.put("TotalmoneySum",new BigDecimal(totalmoneySum));
			   				json.put("ActualMoneySum",new BigDecimal(actualMoneySum));
			   				//数据集list
			   				json.put("DataSet" , dept3InfoList);
			   				arrayData.add(json);	
			   				return ResponseResult.success(0, "查询成功", 0, dept3InfoList.size(), columnList, arrayData);
		   				}else {
		   					return ResponseResult.fail(false, "查询失败，没有要返回的数据");
		   				}
    				}else if ("4".equals(apstage)) {
    					//二级部门审核阶段
    					String dept2Manager=ap.getDept2manager();
    					//封装返回数据的表头信息
    					//JSONArray arrayTableData = this.generateTableHeaderForAll(apstage);
    					List<Map<String, Object>> columnList = sysDicInfoService.getColumn("AssetPlanInfoDept2View");
    					
						List<AssetPlanInfoDept2View> dept2InfoList = assetPlanInfoService.getDept2InfoList(dept2Manager,apstage);
						if(dept2InfoList.size()>0) {
							param.put("Dept2Manager",dept2Manager);
							param.put("APStage",apstage);
							//申购金额合计  totalmoneySum
							String totalmoneySum = assetPlanInfoService.getSumTotalMoneyForDept2(param);
		   					//同意申购金额合计  ActualMoneySum
		   					String actualMoneySum = assetPlanInfoService.getSumActualMoneySumForDept2(param);
		   					json.put("TotalmoneySum",new BigDecimal(totalmoneySum));
		   					json.put("ActualMoneySum",new BigDecimal(actualMoneySum));
		   					//数据集list
		   					json.put("DataSet" , dept2InfoList);
		   					arrayData.add(json);	
		   					return ResponseResult.success(0, "查询成功", 0, dept2InfoList.size(), columnList, arrayData);
						}else {
							return ResponseResult.fail(false, "查询失败，没有要返回的数据");
						}
    				}else if("5".equals(apstage)) {
    					//计划员审核阶段
    					String planner=ap.getPlanner();
    					//封装返回数据的表头信息
    					//JSONArray arrayTableData = this.generateTableHeaderForAll(apstage);
    					List<Map<String, Object>> columnList = sysDicInfoService.getColumn("AssetPlanInfoPlannerView");
    					
    					int listSize=0;
		   				List<Integer> flag=new ArrayList<>();
		   				flag.add(1);flag.add(2);flag.add(3);flag.add(4);flag.add(5);flag.add(6);flag.add(7);flag.add(8);
		   				for (int i = 0; i < flag.size(); i++) {
		   					param.put("GroupFlag",flag.get(i));
		   					param.put("Planner",planner);
		   					param.put("APStage",apstage);
		   					List<AssetPlanInfoPlannerView> listofPlannerDetail = assetPlanInfoService.listofPlannerDetail(param);
		   					if(listofPlannerDetail.size()>0) {
		   						String groupflagdetail = listofPlannerDetail.get(0).getGroupflagdetail();
		   						String requireds = assetPlanInfoService.getSumCountBeforeForPlanner(param);
		   						String requiredsAudit = assetPlanInfoService.getSumCountAfterForPlanner(param);
		   						String totalmoneySum = assetPlanInfoService.getSumMoneyBeforeForPlanner(param);
		   						String actualmoneySum = assetPlanInfoService.getSumMoneyAfterForPlanner(param);
		   						listSize += listofPlannerDetail.size();
		   						//groupName
		   						json.put("GroupName", groupflagdetail);
		   		   				//申报数量合计 dept2managercountSum
		   		   				json.put("Requireds", Integer.parseInt(requireds));
		   		   				//评审后数量合计 plannercountSum
		   		   				json.put("RequiredsAudit", Integer.parseInt(requiredsAudit));
		   		   				//申购金额合计  totalmoneySum
		   		   				json.put("TotalmoneySum",new BigDecimal(totalmoneySum));
		   		   				//评审后金额合计  actualmoneySum
		   		   				json.put("ActualmoneySum",new BigDecimal(actualmoneySum));
		   		   				//数据集
		   		   				json.put("DataSet" , listofPlannerDetail);
		   		   				arrayData.add(json);				
		   					}
		   				}
						return ResponseResult.success(0, "查询成功", 0, listSize, columnList, arrayData);
    				}else if("6".equals(apstage)) {
    					//专家团审核阶段
    					String oqDeptReviewer=ap.getOqdeptreviewer();
    					//封装返回数据的表头信息
    					//JSONArray arrayTableData = this.generateTableHeaderForAll(apstage);
    					List<Map<String, Object>> columnList = sysDicInfoService.getColumn("AssetPlanInfoOQDeptView");
    					
    					int listSize=0;
		   				List<Integer> flag=new ArrayList<>();
		   				//专家团展示5种状态列表
		   				flag.add(1);flag.add(2);flag.add(3);flag.add(4);flag.add(5);
		   				for (int i = 0; i < flag.size(); i++) {
		   					param.put("GroupFlag",flag.get(i));
		   					param.put("OQDeptReviewer",oqDeptReviewer);
		   					param.put("APStage",apstage);
		   					List<AssetPlanInfoOQDeptView> listofOQDeptDetail = assetPlanInfoService.listofOQDeptDetail(param);
		   					if(listofOQDeptDetail.size()>0) {
		   						String groupflagdetail = listofOQDeptDetail.get(0).getGroupflagdetail();
		   						String requireds = assetPlanInfoService.getSumCountBeforeForOQDept(param);
		   						String requiredsAudit = assetPlanInfoService.getSumCountAfterForOQDept(param);
		   						String totalmoneySum = assetPlanInfoService.getSumMoneyBeforeForOQDept(param);
		   						String actualmoneySum = assetPlanInfoService.getSumMoneyAfterForOQDept(param);
		   						listSize += listofOQDeptDetail.size();
		   						//groupName
		   						json.put("GroupName", groupflagdetail);
		   		   				//申报数量合计 dept2managercountSum
		   		   				json.put("Requireds", Integer.parseInt(requireds));
		   		   				//评审后数量合计 plannercountSum
		   		   				json.put("RequiredsAudit", Integer.parseInt(requiredsAudit));
		   		   				//申购金额合计  totalmoneySum
		   		   				json.put("TotalmoneySum",new BigDecimal(totalmoneySum));
		   		   				//评审后金额合计  actualmoneySum
		   		   				json.put("ActualmoneySum",new BigDecimal(actualmoneySum));
		   		   				//数据集
		   		   				json.put("DataSet" , listofOQDeptDetail);
		   		   				arrayData.add(json);				
		   					}
		   				}
						return ResponseResult.success(0, "查询成功", 0, listSize, columnList, arrayData);
    				}else if("7".equals(apstage)) {
    					//一级部门审核阶段
    					String dept1Reviewer=ap.getDept1reviewer();
    					//封装返回数据的表头信息
    					//JSONArray arrayTableData = this.generateTableHeaderForAll(apstage);
    					List<Map<String, Object>> columnList = sysDicInfoService.getColumn("AssetPlanInfoDept1View");
    					
    					int listSize=0;
		   				List<Integer> flag=new ArrayList<>();
		   				//一级部门展示5种状态列表
		   				flag.add(1);flag.add(2);flag.add(3);flag.add(4);flag.add(5);
		   				for (int i = 0; i < flag.size(); i++) {
		   					param.put("GroupFlag",flag.get(i));
		   					param.put("Dept1Reviewer",dept1Reviewer);
		   					param.put("APStage",apstage);
		   					List<AssetPlanInfoDept1View> listofDept1Detail = assetPlanInfoService.listofDept1Detail(param);
		   					if(listofDept1Detail.size()>0) {
		   						String groupflagdetail = listofDept1Detail.get(0).getGroupflagdetail();
		   						String requireds = assetPlanInfoService.getSumCountBeforeForDept1(param);
		   						String requiredsAudit = assetPlanInfoService.getSumCountAfterForDept1(param);
		   						String totalmoneySum = assetPlanInfoService.getSumMoneyBeforeForDept1(param);
		   						String actualmoneySum = assetPlanInfoService.getSumMoneyAfterForDept1(param);
		   						listSize += listofDept1Detail.size();
		   						//groupName
		   						json.put("GroupName", groupflagdetail);
		   		   				//申报数量合计 dept2managercountSum
		   		   				json.put("Requireds", Integer.parseInt(requireds));
		   		   				//评审后数量合计 plannercountSum
		   		   				json.put("RequiredsAudit", Integer.parseInt(requiredsAudit));
		   		   				//申购金额合计  totalmoneySum
		   		   				json.put("TotalmoneySum",new BigDecimal(totalmoneySum));
		   		   				//评审后金额合计  actualmoneySum
		   		   				json.put("ActualmoneySum",new BigDecimal(actualmoneySum));
		   		   				//数据集
		   		   				json.put("DataSet" , listofDept1Detail);
		   		   				arrayData.add(json);				
		   					}
		   				}
						return ResponseResult.success(0, "查询成功", 0, listSize, columnList, arrayData);
    				}else {
    					return ResponseResult.fail("查询失败");
    				}
    			}else {
    				return ResponseResult.fail("查询失败");
    			}
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseResult.fail("查询失败");
		}
	}*/
    
    
    
    
	
}
