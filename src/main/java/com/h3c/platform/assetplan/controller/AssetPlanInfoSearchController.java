
package com.h3c.platform.assetplan.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.net.InetAddress;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eos.common.util.Result;
import com.h3c.platform.annotation.UserLoginToken;
import com.h3c.platform.assetplan.dao.AssetPlanInfoHomePageViewMapper;
import com.h3c.platform.assetplan.dao.AssetPlanInfoMapper;
import com.h3c.platform.assetplan.dao.DeptInfoMapper;
import com.h3c.platform.assetplan.dao.RequestsNumApproveRecordMapper;
import com.h3c.platform.assetplan.entity.AssetPlanGlobalInfo;
import com.h3c.platform.assetplan.entity.AssetPlanInfo;
import com.h3c.platform.assetplan.entity.AssetPlanInfoApplyView;
import com.h3c.platform.assetplan.entity.AssetPlanInfoHomePageView;
import com.h3c.platform.assetplan.entity.AssetPlanInfoSearchExportView;
import com.h3c.platform.assetplan.entity.AssetPlanInfoSearchView;
import com.h3c.platform.assetplan.entity.BPMRelationInfo;
import com.h3c.platform.assetplan.entity.DeptInfo;
import com.h3c.platform.assetplan.entity.DeptTreeInfo;
import com.h3c.platform.assetplan.entity.RequestsNumApproveRecord;
import com.h3c.platform.assetplan.entity.SearchAssetParamEntity;
import com.h3c.platform.assetplan.entity.SysDicCategoryEntity;
import com.h3c.platform.assetplan.entity.SysDicReceiverPlaceEntity;
import com.h3c.platform.assetplan.service.AssetPlanInfoSearchService;
import com.h3c.platform.assetplan.service.AssetPlanInfoService;
import com.h3c.platform.assetplan.service.BPMRelationInfoService;
import com.h3c.platform.assetplan.service.DeptInfoService;
import com.h3c.platform.common.commonconst.DicConst;
import com.h3c.platform.common.commonconst.LogType;
import com.h3c.platform.common.entity.SearchParamEntity;
import com.h3c.platform.common.entity.SysDicInfo;
import com.h3c.platform.common.service.MailInfoService;
import com.h3c.platform.common.service.SysDicInfoService;
import com.h3c.platform.common.util.IPUtils;
import com.h3c.platform.response.ResponseResult;
import com.h3c.platform.sysmgr.entity.OperationLog;
import com.h3c.platform.sysmgr.entity.UserInfo;
import com.h3c.platform.sysmgr.service.OperationLogService;
import com.h3c.platform.sysmgr.service.RoleService;
import com.h3c.platform.sysmgr.service.UserService;
import com.h3c.platform.util.ExportExcelWrapper;
import com.h3c.platform.util.SysDicInfoUtil;
import com.h3c.platform.util.TreeUtil;
import com.h3c.platform.util.UserUtils;

@Controller
@RequestMapping("/assetplan/search")
@CrossOrigin
@Api(value = "资产查询列表相关接口",tags = {"资产查询列表相关接口"})
public class AssetPlanInfoSearchController {

    @Autowired
    private AssetPlanInfoSearchService assetPlanInfoSearchService;
    @Autowired
	private AssetPlanInfoService assetPlanInfoService;
    @Autowired
	private AssetPlanInfoMapper assetPlanInfoMapper;
    @Autowired
    private AssetPlanInfoHomePageViewMapper homePageViewMapper; 
    @Autowired
	private RequestsNumApproveRecordMapper recordMapper;
    @Autowired
	private MailInfoService  mailInfoService;
	@Autowired
	private UserService userService;
	@Autowired
	private SysDicInfoService sysDicInfoService;
	@Autowired
	private DeptInfoMapper deptInfoMapper;
	@Autowired
	private SysDicInfoUtil sysDicInfoUtil;
	@Autowired
	private  OperationLogService operationLogService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private DeptInfoService deptInfoService;
	@Autowired
	private BPMRelationInfoService bpmRelationInfoService;
	
    @PostMapping("/listOfAssetPlanInfo")
    @ApiOperation(value = "获取所有资产查询列表信息")
    @ResponseBody
    @UserLoginToken
    public ResponseResult listOfAssetPlanInfo(@RequestBody @ApiParam(name="查询对象",value="传入json格式",required=true) SearchAssetParamEntity searchAssetParamEntity) throws Exception{
    	//try {
    	    String currentUserId = UserUtils.getCurrentUserId();
    		Map<String, Object> param = new HashMap<>();
            param.put("APStage", searchAssetParamEntity.getApStage());
            param.put("PlanCode", searchAssetParamEntity.getPlanCode());
            param.put("AssetName", searchAssetParamEntity.getAssetName());
            param.put("RequiredUser", searchAssetParamEntity.getRequiredUser());
            //param.put("StartApplyTime", searchAssetParamEntity.getStartApplyTime());
            //param.put("EndApplyTime", searchAssetParamEntity.getEndApplyTime());
            List<String> applyTimeList = searchAssetParamEntity.getApplyTime();
            if(applyTimeList.size()>0) {
            	String applyMonthDetail = applyTimeList.get(0);
            	param.put("ApplyMonthDetail", applyMonthDetail);
            	String startApplyTime = applyTimeList.get(0)+"-01 00:00:00";
            	String endApplyTime = applyTimeList.get(1)+"-31 23:59:59";
            	
            	param.put("StartApplyTime", startApplyTime);
                param.put("EndApplyTime",  endApplyTime);
            }else {
                param.put("ApplyMonthDetail", null);
            }
            param.put("AssetModel", searchAssetParamEntity.getAssetModel());
            if(searchAssetParamEntity.getDeptCode()==null) {
            	param.put("DeptCode", null);
            }else {
            	DeptInfo deptInfo = deptInfoMapper.selectByPrimaryKey(Integer.parseInt(searchAssetParamEntity.getDeptCode()));
            	String deptLevel = deptInfo.getDeptLevel();
            	if("1".equals(deptLevel)) {
            		param.put("Dept1Code", searchAssetParamEntity.getDeptCode());
            	}else if("2".equals(deptLevel)) {
            		param.put("Dept2Code", searchAssetParamEntity.getDeptCode());
            	}else {
            		param.put("DeptCode", searchAssetParamEntity.getDeptCode());
            	}
            }
            param.put("AssetManufacturer", searchAssetParamEntity.getAssetManufacturer());
            param.put("ReceiverPlace", searchAssetParamEntity.getReceiverPlace());
            param.put("AbnormalPlanEnum", searchAssetParamEntity.getAbnormalPlanEnum());
            param.put("OutTimePlanEnum", searchAssetParamEntity.getOutTimePlanEnum());
            param.put("ItemCode", searchAssetParamEntity.getItemCode());
            param.put("IsReqPurchaseReport", searchAssetParamEntity.getIsReqPurchaseReport());
            param.put("ISSpecifyManufacturer", searchAssetParamEntity.getIsSpecifyManufacturer());
            param.put("ApplyResult", searchAssetParamEntity.getApplyResult());
            //int requireds = searchAssertParamEntity.getRequireds();
            //int requiredsAudit = searchAssertParamEntity.getRequiredsAudit();
            Integer pageNum =1;
            Integer pageSize=20;
            if(searchAssetParamEntity.getPageNum()!=null){
            	pageNum = searchAssetParamEntity.getPageNum();
                if(pageNum<=0) {
                	pageNum=1;
                }
            }
            if(searchAssetParamEntity.getPageSize()!=null){
	            pageSize = searchAssetParamEntity.getPageSize();
	            if(pageSize<=0) {
	            	pageSize=20;
	            }
            }
            param.put("pageNum", (pageNum-1)*pageSize);
            param.put("pageSize", pageSize);
            
            //普通用户查看，只能查看与他有关的所有单子，申请审批的这些关系
            //系统管理员可看到全部数据
            /* Boolean isDeptManager=false;
            DeptInfo deptManagerInfo = deptInfoService.getByDeptManagerCode(currentUserId);
            if(deptManagerInfo==null) {
            }else {
            	isDeptManager=true;
            }*/
            if(roleService.checkIsAdmin()) {
            }else {
            	param.put("NotAdmin", "NotAdmin");
            	param.put("currentUserId", currentUserId);
            }
            
   			List<AssetPlanInfoSearchView> planInfoList = assetPlanInfoSearchService.listofAssetPlanInfo(param);
   			int totalCount = assetPlanInfoSearchService.countAssetPlanInfo(param);
   			//封装返回数据的表头信息
   			List<Map<String, Object>> columnList = sysDicInfoService.getColumn(DicConst.ASSETPLANINFOSEARCHVIEW);
   			
   			return ResponseResult.success(0, "查询成功", pageNum, totalCount,columnList, planInfoList);
   		/*} catch (Exception e) {
   			e.printStackTrace();
   			return ResponseResult.fail(false, "查询失败");
   		}*/
    }
    
    @ApiOperation(value="激活按钮状态修改")
   	@PostMapping("/activateAssetPlanInfoByIds")
   	@ResponseBody
   	@UserLoginToken(logType=LogType.MODIFY)
   	public ResponseResult activateAssetPlanInfoByIds(@RequestBody List<Integer> lstsubmitID) throws Exception{
   		//try {
   			//当前登录人
   			String currentUserId = UserUtils.getCurrentUserId();
   			List<Integer> newLstsubmitID =new ArrayList<>();
   			for (int i = 0; i < lstsubmitID.size(); i++) {
   				Integer assetplanid = lstsubmitID.get(i);
   				AssetPlanInfo ap = assetPlanInfoMapper.selectByPrimaryKey(assetplanid);
   				//有成套设备的话吗，得把成套设备的也一并提交
   				if(StringUtils.isNotBlank(ap.getIscompleteset()) && "1".equals(ap.getIscompleteset())) {
   					List<AssetPlanInfo> completeSetList = assetPlanInfoService.selectCompleteSet(ap.getPlancode(), ap.getCompletesetcode());
   					for (int j = 0; j < completeSetList.size(); j++) {
   						newLstsubmitID.add(completeSetList.get(j).getAssetplanid());
   					}
   				//无成套设备	
   				}else {
   					newLstsubmitID.add(assetplanid);
   				}
   			}
   			List<String> sendToDept2 =new ArrayList<>();
   			List<String> sendToPlanner =new ArrayList<>();
   			List<Integer> newLstActivateID =new ArrayList<>();
   			for (int j = 0; j < newLstsubmitID.size(); j++) {
   				AssetPlanInfo assetPlanInfo = assetPlanInfoMapper.selectByPrimaryKey(newLstsubmitID.get(j));
   				//激活在三级部门审批那超时的单子
   				if(assetPlanInfo.getOuttimeplanenum()==3) {
   					newLstActivateID.add(newLstsubmitID.get(j));
   					//根据申购人获取待提交的二级部门主管
   		   			UserInfo user = userService.getUserByEmpCode(assetPlanInfo.getRequireduser());
   		   			DeptInfo deptInfo = deptInfoMapper.selectByPrimaryKey(Integer.parseInt(user.getDept2Code()));
	   		   		if(StringUtils.isNotBlank(deptInfo.getDeptManagerCode())) {
	   		   			sendToDept2.add(deptInfo.getDeptManagerCode());
		   			}else {
		   				return ResponseResult.fail(false, "无审批人信息，请联系系统管理员！");
		   			}
   				}
   				//激活在二级部门审批那超时的单子
   				if(assetPlanInfo.getOuttimeplanenum()==4) {
   					newLstActivateID.add(newLstsubmitID.get(j));
   					//提交到配置的计划员
   					//下一环节审批人
   	   				String planner = sysDicInfoService.getPlanner();
   	   				if(StringUtils.isNotBlank(planner)) {
   	   					sendToPlanner.add(planner);
   	   				}else {
   	   					return ResponseResult.fail(false, "无审批人信息，请联系系统管理员！");
   	   				}
   				}
			}
   			if(newLstActivateID.size()>0) {
   				//激活三级和二级主管审批已超时的记录
   	   			Map<String,Object> param=new HashMap<>();
   	   			param.put("id", newLstActivateID);
   	   			param.put("Modifier", currentUserId);
   	   			param.put("AbnormalPlanEnum", "2");
   	   			param.put("OutTimePlanEnum", "-1");
   				this.assetPlanInfoService.activateAssetPlanInfoByIds(param);
   				
   				//激活的单子得发邮件给二级主管或者是计划员
   				if(sendToDept2.size()>0) {
   					String url="";
   					sendToDept2=removeDuplicate(sendToDept2);
   					for (int j = 0; j < sendToDept2.size(); j++) {
   						mailInfoService.sendRemindMail(String.join(",", sendToDept2.get(j)), "", "激活三级主管审批超时的单子", url);
   					}
   				}
   				if(sendToPlanner.size()>0) {
   					String url="";
   					sendToPlanner=removeDuplicate(sendToPlanner);
   					for (int j = 0; j < sendToPlanner.size(); j++) {
   						mailInfoService.sendRemindMail(String.join(",", sendToPlanner.get(j)), "", "激活二级主管审批超时的单子", url);
   					}
   				}
   				
   				if(newLstActivateID.size()<newLstsubmitID.size()) {
   					return ResponseResult.success(true, "部分激活");
   				}
   				return ResponseResult.success(true, "激活成功");
   			}else {
   				return ResponseResult.fail(false, "无需激活");
   			}
   		
   		/*} catch (Exception e) {
   			e.printStackTrace();
   			return ResponseResult.fail(false, "激活失败");
   		}*/
   	}
    /**导出的最新传参，id的集合加上查询的参数。其中id的集合传的为空则导出查询条件下的所有数据，不为空，则导出查询下的选中数据
     * {
    "apstage": "",
    "planCode": "",
    "applyUser": "",
    "applyTime": [],
    "lstexportID": [],
    "assetName": "",
    "assetModel": "",
    "deptCode": null,
    "assetManufacturer": "",
    "receiverPlace": "",
    "abnormalPlanEnum": "",
    "itemCode": "",
    "isReqPurchaseReport": 1,
    "isspecifyManufacturer": 1,
    "applyResult": "",
    "pageNum": 1,
    "pageSize": 10----分页的参数可传可不传
	}
     * 
     * @param searchAssetParamEntity
     * @param response
     */
    @ApiOperation(value="导出到Excel")
   	@PostMapping("/exportAssetPlanInfoByIds")
   	@ResponseBody
   	@UserLoginToken(logType=LogType.EXPORT)
   	public void exportAssetPlanInfoByIds(HttpServletRequest request,@RequestBody SearchAssetParamEntity searchAssetParamEntity,HttpServletResponse response)throws Exception {
    	System.out.println("000-----"+new Date());
    	String[] header = new String[] { "评审结果","物品名称", "厂家", "型号", "申报数量","同意数量", "预计单价","申购金额", "同意金额",
				"申购人", "二级部门", "三级部门", "项目编码", "类别", "货期（天）", "用途", "到货地点", "备注", "审批状态","评审意见",
				"使用率","数量","设备分布","使用率明细","研发总体","研发总体数量"};
    	String[] column = new String[] { "Approvalresult","Assetname", "Assetmanufacturer", "Assetmodel", "Requireds","Requiredsaudit", 
				"Pprice","Totalmoney", "Actualmoney","Requiredusername","Dept2name","Dept3name", "Itemcode", 
				"Assetcategory","Goodstime","Purpose","Receiverplace","Assetnote","Apstatusdetail","Approvalnote","Rate","Number",
				"Distribution","Detail","RdRate","RdNumber"};
		String currentUserId = UserUtils.getCurrentUserId();
		List<String> lstHeader = Arrays.asList(header);
		List<String> lsth = new ArrayList<>(lstHeader);
		header = (String[]) lsth.toArray(new String[lsth.size()]);
		
		List<String> lstcolumn = Arrays.asList(column);
		List lstc = new ArrayList(lstcolumn);
		column = (String[]) lstc.toArray(new String[lstc.size()]);
		//try {
		
			Map<String, Object> param = new HashMap<>();
			param.put("id", searchAssetParamEntity.getLstexportId());
			param.put("APStage", searchAssetParamEntity.getApStage());
            param.put("PlanCode", searchAssetParamEntity.getPlanCode());
            param.put("AssetName", searchAssetParamEntity.getAssetName());
            param.put("RequiredUser", searchAssetParamEntity.getRequiredUser());
            //param.put("StartApplyTime", searchAssetParamEntity.getStartApplyTime());
            //param.put("EndApplyTime", searchAssetParamEntity.getEndApplyTime());
            List<String> applyTimeList = searchAssetParamEntity.getApplyTime();
            if(CollectionUtils.isNotEmpty(applyTimeList)) {
            	String applyMonthDetail = applyTimeList.get(0);
            	param.put("ApplyMonthDetail", applyMonthDetail);
            	String startApplyTime = applyTimeList.get(0)+"-01 00:00:00";
            	String endApplyTime = applyTimeList.get(1)+"-31 23:59:59";
            	
            	param.put("StartApplyTime", startApplyTime);
                param.put("EndApplyTime",  endApplyTime);
            }else {
                param.put("ApplyMonthDetail", null);
            }
            param.put("AssetModel", searchAssetParamEntity.getAssetModel());
            if(StringUtils.isBlank(searchAssetParamEntity.getDeptCode())) {
            	param.put("DeptCode", null);
            }else {
            	DeptInfo deptInfo = deptInfoMapper.selectByPrimaryKey(Integer.parseInt(searchAssetParamEntity.getDeptCode()));
            	String deptLevel = deptInfo.getDeptLevel();
            	if("1".equals(deptLevel)) {
            		param.put("Dept1Code", searchAssetParamEntity.getDeptCode());
            	}else if("2".equals(deptLevel)) {
            		param.put("Dept2Code", searchAssetParamEntity.getDeptCode());
            	}else {
            		param.put("DeptCode", searchAssetParamEntity.getDeptCode());
            	}
            }
            param.put("AssetManufacturer", searchAssetParamEntity.getAssetManufacturer());
            param.put("ReceiverPlace", searchAssetParamEntity.getReceiverPlace());
            param.put("AbnormalPlanEnum", searchAssetParamEntity.getAbnormalPlanEnum());
            param.put("OutTimePlanEnum", searchAssetParamEntity.getOutTimePlanEnum());
            param.put("ItemCode", searchAssetParamEntity.getItemCode());
            param.put("IsReqPurchaseReport", searchAssetParamEntity.getIsReqPurchaseReport());
            param.put("ISSpecifyManufacturer", searchAssetParamEntity.getIsSpecifyManufacturer());
            param.put("ApplyResult", searchAssetParamEntity.getApplyResult());
            //int requireds = searchAssertParamEntity.getRequireds();
            //int requiredsAudit = searchAssertParamEntity.getRequiredsAudit();
            Integer pageNum =1;
            Integer pageSize=20;
            if(searchAssetParamEntity.getPageNum()!=null){
            	pageNum = searchAssetParamEntity.getPageNum();
                if(pageNum<=0) {
                	pageNum=1;
                }
            }
            if(searchAssetParamEntity.getPageSize()!=null){
	            pageSize = searchAssetParamEntity.getPageSize();
	            if(pageSize<=0) {
	            	pageSize=20;
	            }
            }
            param.put("pageNum", (pageNum-1)*pageSize);
            param.put("pageSize", pageSize);
            
            //普通用户查看，只能查看与他有关的所有单子，申请审批的这些关系
            //系统管理员可看到全部数据
            /*Boolean isDeptManager=false;
            DeptInfo deptManagerInfo = deptInfoService.getByDeptManagerCode(currentUserId);
            if(deptManagerInfo==null) {
            }else {
            	isDeptManager=true;
            }*/
            if(roleService.checkIsAdmin()) {
            }else {
            	param.put("NotAdmin", "NotAdmin");
            	param.put("currentUserId", currentUserId);
            }
            
            
			List<AssetPlanInfoSearchExportView> lst = assetPlanInfoService.exportAssetPlanInfoByIds(param);
			System.out.println("111-----"+new Date());
			//类别，货期，到货地点转换成汉字重新赋值导出
			for (int i = 0; i < lst.size(); i++) {
					SysDicCategoryEntity sysDicCategory = sysDicInfoUtil.getSysDicCategory(lst.get(i).getAssetcategory());
					lst.get(i).setAssetcategory(sysDicCategory.getAssetCategory());
					lst.get(i).setGoodstime(sysDicCategory.getGoodstime());
					SysDicReceiverPlaceEntity sysDicReceiverPlace = sysDicInfoUtil.getSysDicReceiverPlace(lst.get(i).getReceiverplace());
					lst.get(i).setReceiverplace(sysDicReceiverPlace.getReceiverPlace());
			}
			System.out.println("222-----"+new Date());
			ExportExcelWrapper<AssetPlanInfoSearchExportView> excelWrapper = new ExportExcelWrapper<>();

			StringBuffer buffer=excelWrapper.exportExcel("AssetInfoExport", "资产数据导出", header, column, lst, response, "2007",true, "Assetplanid");
			System.out.println("333-----"+new Date());
			OperationLog log=new OperationLog();
			log.setModelcode("com.h3c.platform.assetplan.controller.exportAssetPlanInfoByIds");
			log.setModelname("导出到Excel");
			log.setSummary(request.getRequestURL().toString());
			log.setContent(buffer.toString());
			log.setUserid(UserUtils.getCurrentUserId());
			log.setLogtype(LogType.EXPORT);		
			log.setIp("IP:"+IPUtils.getIpAddr(request)+";service:"+InetAddress.getLocalHost().getHostAddress());			
				
			operationLogService.saveLog(log);
			System.out.println("444-----"+new Date());
    }
    
    @ApiOperation(value="审批记录查询")
	@GetMapping("/getApprovalRecordById")
	@ResponseBody
	@UserLoginToken
	public ResponseResult getApprovalRecordById(@RequestParam @ApiParam(name="assetplanid",value="资源信息主键id",required=true)Integer assetplanid) throws Exception{
		//try {
			//封装返回数据的表头信息
			List<Map<String, Object>> columnList = sysDicInfoService.getColumn(DicConst.ASSETPLANINFOHOMEPAGEVIEW);
   			
			AssetPlanInfoHomePageView record = homePageViewMapper.getApprovalRecordById(assetplanid);
			SimpleDateFormat dateformat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			JSONArray arrayData = new JSONArray();
			JSONObject json0=new JSONObject();
			json0.put("apstage", record.getApstage());
			json0.put("apstatusdetail", record.getApstatusdetail());
			UserInfo userByEmpCode = userService.getUserByEmpCode(record.getApplyuser());
			if(userByEmpCode==null) {
				json0.put("applyuser", "");
			}else {
				json0.put("applyuser", userByEmpCode.getEmpName()+""+record.getApplyuser());
			}
			
			json0.put("PlanCode", record.getPlancode());
			json0.put("applytime", dateformat.format(record.getApplytime()));
			arrayData.add(json0);
			
			if(record.getReviewtime()!=null) {
				JSONObject json=new JSONObject();
				json.put("apstage",  "2");
				json.put("apstatusdetail",  "规范审核");
				/*json.put("assetmanufacturer", record.getAssetmanufacturer());
				json.put("assetmodel", record.getAssetmodel());
				SysDicCategoryEntity sysDicCategory = sysDicInfoUtil.getSysDicCategory(record.getAssetcategory());
				json.put("assetcategory", sysDicCategory.getAssetCategory());
				json.put("pprice", record.getPprice());
				//规范审核结果 规范1/不规范2/未审核3/再审核4
				if(record.getReviewresult()==1) {
					json.put("reviewresult", "规范");
				}else if(record.getReviewresult()==2) {
					json.put("reviewresult", "不规范");	
				}else if(record.getReviewresult()==3) {
					json.put("reviewresult", "未审核");
				}else if(record.getReviewresult()==4) {
					json.put("reviewresult", "再审核");
				}else {
					json.put("reviewresult", "状态错误");
				}*/
				json.put("reviewercount", record.getReviewercount());
				json.put("reviewnote", record.getReviewnote());
				UserInfo user2 = userService.getUserByEmpCode(record.getReviewerperson());
				if(user2==null) {
					json.put("reviewer", "");
				}else {
					json.put("reviewer", user2.getDisplayName()+" "+user2.getEmpCode());
				}
				json.put("reviewtime", dateformat.format(record.getReviewtime()));
				arrayData.add(json);
			}
			if(record.getDept3checktime()!=null) {
				JSONObject json1=new JSONObject();
				json1.put("apstage",  "3");
				json1.put("apstatusdetail",  "三级部门主管审批");
				json1.put("dept3managercount", record.getDept3managercount());
				json1.put("dept3checknote", record.getDept3checknote());
				UserInfo user3 = userService.getUserByEmpCode(record.getDept3manager());
				if(user3==null) {
					json1.put("dept3manager", "");
				}else {
					json1.put("dept3manager", user3.getDisplayName()+" "+record.getDept3manager());
				}
				json1.put("dept3checktime", dateformat.format(record.getDept3checktime()));
				arrayData.add(json1);
			}
			if(record.getDept2checktime()!=null) {
				JSONObject json2=new JSONObject();
				json2.put("apstage",  "4");
				json2.put("apstatusdetail",  "二级部门主管审批");
				json2.put("dept2managercount", record.getDept2managercount());
				json2.put("dept2checknote", record.getDept2checknote());
				UserInfo user4 = userService.getUserByEmpCode(record.getDept2manager());
				if(user4==null) {
					json2.put("dept2manager", "");
				}else {
					json2.put("dept2manager", user4.getDisplayName()+" "+record.getDept2manager());
				}
				json2.put("dept2checktime", dateformat.format(record.getDept2checktime()));
				arrayData.add(json2);
			}
			if(record.getPlannertime()!=null) {
				JSONObject json3=new JSONObject();
				json3.put("apstage",  "5");
				json3.put("apstatusdetail",  "计划员审批");
				json3.put("plannercount", record.getPlannercount());
				json3.put("plannernote", record.getPlannernote());
				UserInfo user5 = userService.getUserByEmpCode(record.getPlanner());
				if(user5==null) {
					json3.put("planner", "");
				}else {
					json3.put("planner", user5.getDisplayName()+" "+record.getPlanner());
				}
				json3.put("plannertime", dateformat.format(record.getPlannertime()));
				arrayData.add(json3);
			}
			if(record.getOqdeptreviewtime()!=null) {
				JSONObject json4=new JSONObject();
				json4.put("apstage",  "6");
				json4.put("apstatusdetail",  "专家团审核");
				json4.put("oqdeptreviewercount", record.getOqdeptreviewercount());
				json4.put("oqdeptreviewnote", record.getOqdeptreviewnote());
				UserInfo user6 = userService.getUserByEmpCode(record.getOqdeptreviewer());
				if(user6==null) {
					json4.put("oqdeptreviewer", "");
				}else {
					json4.put("oqdeptreviewer", user6.getDisplayName()+" "+record.getOqdeptreviewer());
				}
				json4.put("oqdeptreviewtime", dateformat.format(record.getOqdeptreviewtime()));
				arrayData.add(json4);
			}
			if(record.getDept1reviewtime()!=null) {
				JSONObject json5=new JSONObject();
				json5.put("apstage",  "7");
				json5.put("apstatusdetail",  "一级部门主管审批");
				json5.put("dept1reviewercount", record.getDept1reviewercount());
				json5.put("dept1reviewnote", record.getDept1reviewnote());
				UserInfo user7 = userService.getUserByEmpCode(record.getDept1reviewer());
				if(user7==null) {
					json5.put("dept1reviewer", "");
				}else {
					json5.put("dept1reviewer", user7.getDisplayName()+" "+record.getDept1reviewer());
				}
				json5.put("dept1reviewtime", dateformat.format(record.getDept1reviewtime()));
				arrayData.add(json5);
			}
			
			return ResponseResult.success(0, "查询成功", 0, 0, columnList, arrayData);
			
		/*} catch (Exception e) {
			e.printStackTrace();
			return ResponseResult.fail(false,"查询失败");
		}*/
	}
    
    
    @ApiOperation(value="详情页面的审批记录信息")
   	@GetMapping("/getApprovalRecordByIdForDetail")
   	@ResponseBody
   	@UserLoginToken
   	public ResponseResult getApprovalRecordByIdForDetail(@RequestParam @ApiParam(name="assetplanid",value="资源信息主键id",required=true)Integer assetplanid) throws Exception{
   			//封装返回数据的表头信息
   			List<Map<String, Object>> columnList = sysDicInfoService.getColumn(DicConst.ASSETPLANINFOHOMEPAGEVIEW);
      			
   			AssetPlanInfoHomePageView record = homePageViewMapper.getApprovalRecordById(assetplanid);
   			SimpleDateFormat dateformat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
   			JSONArray arrayData = new JSONArray();
   			JSONObject json0=new JSONObject();
   			json0.put("apstage", record.getApstage());
   			json0.put("apstatusdetail", record.getApstatusdetail());
   			UserInfo userByEmpCode = userService.getUserByEmpCode(record.getApplyuser());
   			if(userByEmpCode==null) {
   				json0.put("applyuser", "");
   			}else {
   				json0.put("applyuser", userByEmpCode.getEmpName()+""+record.getApplyuser());
   			}
   			
   			json0.put("PlanCode", record.getPlancode());
   			json0.put("applytime", dateformat.format(record.getApplytime()));
   			arrayData.add(json0);
   			
   			//三级主管审核页面看见规范审核的和三级待审核的记录
   			if("3".equals(record.getApstage())) {
   				JSONObject recordReview = this.getRecordReview(record);
   				arrayData.add(recordReview);
   				JSONObject recordDept3 = this.getRecordDept3(record);
   				arrayData.add(recordDept3);
   			}
   			//二级
   			if("4".equals(record.getApstage())) {
   				JSONObject recordReview = this.getRecordReview(record);
   				arrayData.add(recordReview);
   				JSONObject recordDept3 = this.getRecordDept3(record);
   				arrayData.add(recordDept3);
   				JSONObject recordDept2 = this.getRecordDept2(record);
   				arrayData.add(recordDept2);
   			}
   			//计划员
   			if("5".equals(record.getApstage())) {
   				JSONObject recordReview = this.getRecordReview(record);
   				arrayData.add(recordReview);
   				JSONObject recordDept3 = this.getRecordDept3(record);
   				arrayData.add(recordDept3);
   				JSONObject recordDept2 = this.getRecordDept2(record);
   				arrayData.add(recordDept2);
   				JSONObject recordPlanner = this.getRecordPlanner(record);
   				arrayData.add(recordPlanner);
   			}
   			//专家团
   			if("6".equals(record.getApstage())) {
   				JSONObject recordReview = this.getRecordReview(record);
   				arrayData.add(recordReview);
   				JSONObject recordDept3 = this.getRecordDept3(record);
   				arrayData.add(recordDept3);
   				JSONObject recordDept2 = this.getRecordDept2(record);
   				arrayData.add(recordDept2);
   				JSONObject recordPlanner = this.getRecordPlanner(record);
   				arrayData.add(recordPlanner);
   				JSONObject recordOq = this.getRecordOq(record);
   				arrayData.add(recordOq);
   			}
   			//一级
   			if("7".equals(record.getApstage())) {
   				JSONObject recordReview = this.getRecordReview(record);
   				arrayData.add(recordReview);
   				JSONObject recordDept3 = this.getRecordDept3(record);
   				arrayData.add(recordDept3);
   				JSONObject recordDept2 = this.getRecordDept2(record);
   				arrayData.add(recordDept2);
   				JSONObject recordPlanner = this.getRecordPlanner(record);
   				arrayData.add(recordPlanner);
   				JSONObject recordOq = this.getRecordOq(record);
   				arrayData.add(recordOq);
   				JSONObject recordDept1 = this.getRecordDept1(record);
   				arrayData.add(recordDept1);
   			}
   			return ResponseResult.success(0, "查询成功", 0, 0, columnList, arrayData);
   	}
    
    public JSONObject getRecordReview(AssetPlanInfoHomePageView record) {   
    	SimpleDateFormat dateformat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	JSONObject json=new JSONObject();
		json.put("apstage",  "2");
		json.put("apstatusdetail",  "规范审核");
		json.put("pprice", record.getPprice());
		json.put("reviewercount", record.getReviewercount());
		json.put("reviewnote", record.getReviewnote());
		UserInfo user2 = userService.getUserByEmpCode(record.getReviewerperson());
		if(user2==null) {
			json.put("reviewer", "");
		}else {
			json.put("reviewer", user2.getDisplayName()+" "+user2.getEmpCode());
		}
		if(record.getReviewtime()==null) {
			json.put("reviewtime", "");
		}else {
			json.put("reviewtime", dateformat.format(record.getReviewtime()));
		}
        return json;   
    }
    
    public JSONObject getRecordDept3(AssetPlanInfoHomePageView record) {  
    	SimpleDateFormat dateformat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	JSONObject json1=new JSONObject();
		json1.put("apstage",  "3");
		json1.put("apstatusdetail",  "三级部门主管审批");
		json1.put("pprice", record.getPprice());
		json1.put("dept3managercount", record.getDept3managercount());
		json1.put("dept3checknote", record.getDept3checknote());
		UserInfo user3 = userService.getUserByEmpCode(record.getDept3manager());
		if(user3==null) {
			json1.put("dept3manager", "");
		}else {
			json1.put("dept3manager", user3.getDisplayName()+" "+record.getDept3manager());
		}
		if(record.getDept3checktime()==null) {
			json1.put("dept3checktime", "");
		}else {
			json1.put("dept3checktime", dateformat.format(record.getDept3checktime()));
		}
        return json1;   
    }
    
    public JSONObject getRecordDept2(AssetPlanInfoHomePageView record) {  
    	SimpleDateFormat dateformat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	JSONObject json2=new JSONObject();
		json2.put("apstage",  "4");
		json2.put("apstatusdetail",  "二级部门主管审批");
		json2.put("pprice", record.getPprice());
		json2.put("dept2managercount", record.getDept2managercount());
		json2.put("dept2checknote", record.getDept2checknote());
		UserInfo user4 = userService.getUserByEmpCode(record.getDept2manager());
		if(user4==null) {
			json2.put("dept2manager", "");
		}else {
			json2.put("dept2manager", user4.getDisplayName()+" "+record.getDept2manager());
		}
		if(record.getDept2checktime()==null) {
			json2.put("dept2checktime", "");
		}else {
			json2.put("dept2checktime", dateformat.format(record.getDept2checktime()));
		}
        return json2;   
    }
    
    public JSONObject getRecordPlanner(AssetPlanInfoHomePageView record) {  
    	SimpleDateFormat dateformat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	JSONObject json3=new JSONObject();
		json3.put("apstage",  "5");
		json3.put("apstatusdetail",  "计划员审批");
		json3.put("pprice", record.getPprice());
		json3.put("plannercount", record.getPlannercount());
		json3.put("plannernote", record.getPlannernote());
		UserInfo user5 = userService.getUserByEmpCode(record.getPlanner());
		if(user5==null) {
			json3.put("planner", "");
		}else {
			json3.put("planner", user5.getDisplayName()+" "+record.getPlanner());
		}
		if(record.getPlannertime()==null) {
			json3.put("plannertime", "");
		}else {
			json3.put("plannertime", dateformat.format(record.getPlannertime()));
		}
        return json3;   
    }
    
    public JSONObject getRecordOq(AssetPlanInfoHomePageView record) {  
    	SimpleDateFormat dateformat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	JSONObject json4=new JSONObject();
		json4.put("apstage",  "6");
		json4.put("apstatusdetail",  "专家团审核");
		json4.put("pprice", record.getPprice());
		json4.put("oqdeptreviewercount", record.getOqdeptreviewercount());
		json4.put("oqdeptreviewnote", record.getOqdeptreviewnote());
		UserInfo user6 = userService.getUserByEmpCode(record.getOqdeptreviewer());
		if(user6==null) {
			json4.put("oqdeptreviewer", "");
		}else {
			json4.put("oqdeptreviewer", user6.getDisplayName()+" "+record.getOqdeptreviewer());
		}
		if(record.getOqdeptreviewtime()==null) {
			json4.put("oqdeptreviewtime", "");
		}else {
			json4.put("oqdeptreviewtime", dateformat.format(record.getOqdeptreviewtime()));
		}
        return json4;   
    }
    
    public JSONObject getRecordDept1(AssetPlanInfoHomePageView record) {  
    	SimpleDateFormat dateformat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	JSONObject json5=new JSONObject();
		json5.put("apstage",  "7");
		json5.put("apstatusdetail",  "一级部门主管审批");
		json5.put("pprice", record.getPprice());
		json5.put("dept1reviewercount", record.getDept1reviewercount());
		json5.put("dept1reviewnote", record.getDept1reviewnote());
		UserInfo user7 = userService.getUserByEmpCode(record.getDept1reviewer());
		if(user7==null) {
			json5.put("dept1reviewer", "");
		}else {
			json5.put("dept1reviewer", user7.getDisplayName()+" "+record.getDept1reviewer());
		}
		if(record.getDept1reviewtime()==null) {
			json5.put("dept1reviewtime", "");
		}else {
			json5.put("dept1reviewtime", dateformat.format(record.getDept1reviewtime()));
		}
        return json5;   
    }
    
    @ApiOperation(value="研发有效的部门树方法")
   	@GetMapping("/getDeptTreeInfoNormal")
   	@ResponseBody
   	@UserLoginToken
   	public ResponseResult getDeptTreeInfoNormal() throws Exception{
   			//try {
   			List<DeptInfo> list = assetPlanInfoService.getDeptInfoListValid();
   			//System.out.println(list.size());
   			List<DeptTreeInfo> address=new ArrayList<>();
   			for (int i = 0; i < list.size(); i++) {
   			//将非研发属性的三级部门移除
   				if("3".equals(list.get(i).getDeptLevel()) && !"RD".equals(list.get(i).getTypeId()))
   					continue;
   				else {
   				DeptTreeInfo  tree=new DeptTreeInfo();
   				tree.setDeptCode(list.get(i).getDeptCode());
   				tree.setDeptName(list.get(i).getDeptName());
   				tree.setDeptLevel(list.get(i).getDeptLevel());
   				tree.setSupDeptDode(list.get(i).getSupDeptCode());
   				tree.setTypeId(list.get(i).getTypeId());
   				//把计划员的信息加上
   				tree.setDeptPlannerCode(list.get(i).getDeptPlannerCode());
   				UserInfo userByEmpCode = userService.getUserByEmpCode(list.get(i).getDeptPlannerCode());
   				if(userByEmpCode!=null) {
   					//计划员姓名
   					tree.setDeptPlannerName(userByEmpCode.getEmpName());
   				}else {
   					tree.setDeptPlannerName("");
   				}
   				address.add(tree);
   				}
			}
   			List<DeptTreeInfo> recursiveAddress = TreeUtil.RecursiveAddress(address);		
   		    //二级或一级如果是最小部门且非研发,查询页面中不展示了
   			for (int i = 0; i < recursiveAddress.size(); i++) {
				if(recursiveAddress.get(i).getChildren()==null && !"RD".equals(recursiveAddress.get(i).getTypeId())) {
   					recursiveAddress.remove(i);
   					i--;
   					continue;
   				}
   				
   				List<DeptTreeInfo> children2 = recursiveAddress.get(i).getChildren();
   				int children2Size = children2.size();
   				int null2Size = 0;
   				for (int j = 0; j < children2.size(); j++) {
   					if(children2.get(j).getChildren()==null && !"RD".equals(children2.get(j).getTypeId())) {
   						children2.remove(j);
   						null2Size++;
   						j--;
   	   				}
   				}
   				//一级下面的所有二级部门都没有研发属性三级部门的话，就把一级部门也去掉。
   				if(children2Size==null2Size) {
   					recursiveAddress.remove(i);
   					i--;
   				}
   			}
   			return ResponseResult.success(0, "查询成功", 0, 0, null, recursiveAddress);
   	}
    
    
    @ApiOperation(value="查询页面的部门树的加载")
   	@GetMapping("/getDeptTreeInfo")
   	@ResponseBody
   	@UserLoginToken
   	public ResponseResult getDeptTreeInfo() throws Exception{
   			//try {
   			List<DeptInfo> list = assetPlanInfoService.getDeptInfoList();
   			//System.out.println(list.size());
   			List<DeptTreeInfo> address=new ArrayList<>();
   			for (int i = 0; i < list.size(); i++) {
   			//将非研发属性的三级部门移除
   				if("3".equals(list.get(i).getDeptLevel()) && !"RD".equals(list.get(i).getTypeId()))
   					continue;
   				else {
   				DeptTreeInfo  tree=new DeptTreeInfo();
   				tree.setDeptCode(list.get(i).getDeptCode());
   				tree.setDeptName(list.get(i).getDeptName());
   				tree.setDeptLevel(list.get(i).getDeptLevel());
   				tree.setSupDeptDode(list.get(i).getSupDeptCode());
   				tree.setTypeId(list.get(i).getTypeId());
   				//把计划员的信息加上
   				tree.setDeptPlannerCode(list.get(i).getDeptPlannerCode());
   				UserInfo userByEmpCode = userService.getUserByEmpCode(list.get(i).getDeptPlannerCode());
   				if(userByEmpCode!=null) {
   					//计划员姓名
   					tree.setDeptPlannerName(userByEmpCode.getEmpName());
   				}else {
   					tree.setDeptPlannerName("");
   				}
   				address.add(tree);
   				}
			}
   			List<DeptTreeInfo> recursiveAddress = TreeUtil.RecursiveAddress(address);		
   		    //二级或一级如果是最小部门且非研发,查询页面中不展示了
   			for (int i = 0; i < recursiveAddress.size(); i++) {
				if(recursiveAddress.get(i).getChildren()==null && !"RD".equals(recursiveAddress.get(i).getTypeId())) {
   					recursiveAddress.remove(i);
   					i--;
   					continue;
   				}
   				
   				List<DeptTreeInfo> children2 = recursiveAddress.get(i).getChildren();
   				int children2Size = children2.size();
   				int null2Size = 0;
   				for (int j = 0; j < children2.size(); j++) {
   					if(children2.get(j).getChildren()==null && !"RD".equals(children2.get(j).getTypeId())) {
   						children2.remove(j);
   						null2Size++;
   						j--;
   	   				}
   				}
   				//一级下面的所有二级部门都没有研发属性三级部门的话，就把一级部门也去掉。
   				if(children2Size==null2Size) {
   					recursiveAddress.remove(i);
   					i--;
   				}
   			}
   			return ResponseResult.success(0, "查询成功", 0, 0, null, recursiveAddress);
   		/*} catch (Exception e) {
   			e.printStackTrace();
   			return ResponseResult.fail(false,"查询失败");
   		}*/
   	}
    
    
    @ApiOperation(value="申请页面的部门树的加载")
   	@GetMapping("/getDeptTreeInfoForApply")
   	@ResponseBody
   	@UserLoginToken
   	public ResponseResult getDeptTreeInfoForApply() throws Exception{
   			List<DeptInfo> list = assetPlanInfoService.getDeptInfoListValid();
   			//System.out.println(list.size());
   			List<DeptTreeInfo> address=new ArrayList<>();
   			for (int i = 0; i < list.size(); i++) {
   				//将非研发属性的三级部门移除
   				if("3".equals(list.get(i).getDeptLevel()) && !"RD".equals(list.get(i).getTypeId()))
   					continue;
   				else {
   				DeptTreeInfo  tree=new DeptTreeInfo();
   				tree.setDeptCode(list.get(i).getDeptCode());
   				tree.setDeptName(list.get(i).getDeptName());
   				tree.setDeptLevel(list.get(i).getDeptLevel());
   				tree.setSupDeptDode(list.get(i).getSupDeptCode());
   				tree.setTypeId(list.get(i).getTypeId());
   				//把计划员的信息加上
   				tree.setDeptPlannerCode(list.get(i).getDeptPlannerCode());
   				UserInfo userByEmpCode = userService.getUserByEmpCode(list.get(i).getDeptPlannerCode());
   				if(userByEmpCode!=null) {
   					//计划员姓名
   					tree.setDeptPlannerName(userByEmpCode.getEmpName());
   				}else {
   					tree.setDeptPlannerName("");
   				}
   				address.add(tree);
   				}
			}
   			List<DeptTreeInfo> recursiveAddress = TreeUtil.RecursiveAddress(address);	
   			
   			//二级或一级如果是最小部门,申请页面中不展示了
   			for (int i = 0; i < recursiveAddress.size(); i++) {
				if(recursiveAddress.get(i).getChildren()==null) {
   					recursiveAddress.remove(i);
   					i--;
   					continue;
   				}
   				
   				List<DeptTreeInfo> children2 = recursiveAddress.get(i).getChildren();
   				int children2Size = children2.size();
   				int null2Size = 0;
   				for (int j = 0; j < children2.size(); j++) {
   					if(children2.get(j).getChildren()==null) {
   						children2.remove(j);
   						null2Size++;
   						j--;
   	   				}
   				}
   				//一级下面的所有二级部门都没有三级部门的话，就把一级部门也去掉。
   				if(children2Size==null2Size) {
   					recursiveAddress.remove(i);
   					i--;
   				}
   			}
   			return ResponseResult.success(0, "查询成功", 0, 0, null, recursiveAddress);
   	}
    
    
  //通过HashSet踢除重复元素
    public static List removeDuplicate(List list) {   
        HashSet h = new HashSet(list);   
        list.clear();   
        list.addAll(h);   
        return list;   
    } 
    
    @UserLoginToken
    @PostMapping("/checkCoa")   
    @ApiOperation("验证勾选流程coa是否同一个 true:同一个coa,false：不为同一个或没有")
    @ResponseBody
    public ResponseResult checkCoa(@RequestParam List<Integer> lstId) throws Exception{
    	List<DeptInfo> lst= deptInfoService.getCoaByAssetPlanId(lstId);
    	if(CollectionUtils.isEmpty(lst)) {
    		lst = deptInfoService.getTwoLevelCoaByAssetPlanId(lstId);
    	}
    	
    	if(CollectionUtils.isEmpty(lst)) {
    		return ResponseResult.success(false);
    	}
    	
    	if(lst.size()>1) {
    		return ResponseResult.success(false);
    	}
    	return ResponseResult.success(true);
    }
    
    @UserLoginToken
    @PostMapping("/checkIsWriteBpmCode")   
    @ApiOperation("验证勾选流程是否已回写bpm编码  true:没有回写，false已回写")
    @ResponseBody
    public ResponseResult checkIsWriteBpmCode(@RequestParam  List<Integer> lstId)throws Exception {
    	List<BPMRelationInfo> lst = bpmRelationInfoService.getByIdList(lstId);
    	if(CollectionUtils.isNotEmpty(lst)) {
    		return ResponseResult.success(false);
    	}
    	return ResponseResult.success(true);
    }
}


