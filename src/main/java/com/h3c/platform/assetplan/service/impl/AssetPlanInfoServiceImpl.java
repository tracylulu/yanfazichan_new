
package com.h3c.platform.assetplan.service.impl;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.h3c.platform.assetplan.dao.AssetPlanInfoApplyViewMapper;
import com.h3c.platform.assetplan.dao.AssetPlanInfoDept1ViewMapper;
import com.h3c.platform.assetplan.dao.AssetPlanInfoDept2ViewMapper;
import com.h3c.platform.assetplan.dao.AssetPlanInfoDept3ViewMapper;
import com.h3c.platform.assetplan.dao.AssetPlanInfoDetailViewMapper;
import com.h3c.platform.assetplan.dao.AssetPlanInfoHomePageViewMapper;
import com.h3c.platform.assetplan.dao.AssetPlanInfoMapper;
import com.h3c.platform.assetplan.dao.AssetPlanInfoMenuViewMapper;
import com.h3c.platform.assetplan.dao.AssetPlanInfoOQDeptViewMapper;
import com.h3c.platform.assetplan.dao.AssetPlanInfoPlannerViewMapper;
import com.h3c.platform.assetplan.dao.AssetPlanInfoReviewViewMapper;
import com.h3c.platform.assetplan.dao.AssetPlanInfoSearchExportViewMapper;
import com.h3c.platform.assetplan.dao.AssetPlanInfoSearchViewMapper;
import com.h3c.platform.assetplan.dao.AssetPlanInfoTodoViewMapper;
import com.h3c.platform.assetplan.dao.DeptInfoMapper;
import com.h3c.platform.assetplan.dao.ProjectInfoMapper;
import com.h3c.platform.assetplan.dao.PurchaseReportInfoMapper;
import com.h3c.platform.assetplan.dao.RequestsNumApproveRecordMapper;
import com.h3c.platform.assetplan.dao.SpecifyManufacturerInfoMapper;
import com.h3c.platform.assetplan.entity.AssetPlanGlobalInfo;
import com.h3c.platform.assetplan.entity.AssetPlanGlobalInfoAll;
import com.h3c.platform.assetplan.entity.AssetPlanInfo;
import com.h3c.platform.assetplan.entity.AssetPlanInfoAll;
import com.h3c.platform.assetplan.entity.AssetPlanInfoApplyView;
import com.h3c.platform.assetplan.entity.AssetPlanInfoApplyViewExample;
import com.h3c.platform.assetplan.entity.AssetPlanInfoDept1View;
import com.h3c.platform.assetplan.entity.AssetPlanInfoDept2View;
import com.h3c.platform.assetplan.entity.AssetPlanInfoDept2ViewExample;
import com.h3c.platform.assetplan.entity.AssetPlanInfoDept3View;
import com.h3c.platform.assetplan.entity.AssetPlanInfoDept3ViewExample;
import com.h3c.platform.assetplan.entity.AssetPlanInfoDetailView;
import com.h3c.platform.assetplan.entity.AssetPlanInfoDetailViewExample;
import com.h3c.platform.assetplan.entity.AssetPlanInfoExample;
import com.h3c.platform.assetplan.entity.AssetPlanInfoHomePageView;
import com.h3c.platform.assetplan.entity.AssetPlanInfoMenuView;
import com.h3c.platform.assetplan.entity.AssetPlanInfoOQDeptView;
import com.h3c.platform.assetplan.entity.AssetPlanInfoPlannerView;
import com.h3c.platform.assetplan.entity.AssetPlanInfoPlannerViewExample;
import com.h3c.platform.assetplan.entity.AssetPlanInfoReviewView;
import com.h3c.platform.assetplan.entity.AssetPlanInfoReviewViewExample;
import com.h3c.platform.assetplan.entity.AssetPlanInfoSearchExportView;
import com.h3c.platform.assetplan.entity.AssetPlanInfoSearchView;
import com.h3c.platform.assetplan.entity.DeptInfo;
import com.h3c.platform.assetplan.entity.DeptTreeInfo;
import com.h3c.platform.assetplan.entity.ProjectInfo;
import com.h3c.platform.assetplan.entity.PurchaseReportInfo;
import com.h3c.platform.assetplan.entity.RateTotalInfo;
import com.h3c.platform.assetplan.entity.RequestsNumApproveRecord;
import com.h3c.platform.assetplan.entity.SpecifyManufacturerInfo;
import com.h3c.platform.assetplan.service.AssetPlanInfoService;
import com.h3c.platform.assetplan.service.AssetRateInfoService;
import com.h3c.platform.assetplan.service.RateTotalInfoService;
import com.h3c.platform.common.service.PlanTimeWindowsService;
import com.h3c.platform.common.util.UUIDUtil;
import com.h3c.platform.response.ResponseResult;
import com.h3c.platform.util.UserUtils;

@Service
public class AssetPlanInfoServiceImpl implements AssetPlanInfoService {
	
	public static Logger log =LoggerFactory.getLogger(AssetPlanInfoServiceImpl.class);	
	
	@Autowired
	private AssetPlanInfoMapper assetPlanInfoMapper;
	@Autowired
	private AssetPlanInfoDetailViewMapper detailassetPlanInfoMapper;
	@Autowired
	private PurchaseReportInfoMapper priMapper;
	@Autowired
	private SpecifyManufacturerInfoMapper smiMapper;
	@Autowired
	private AssetPlanInfoApplyViewMapper applyViewMapper;
	@Autowired
	private AssetPlanInfoHomePageViewMapper homePageViewMapper;
	@Autowired
	private AssetPlanInfoReviewViewMapper reviewViewMapper;
	@Autowired
	private AssetPlanInfoDept3ViewMapper dept3ViewMapper;
	@Autowired
	private AssetPlanInfoDept2ViewMapper dept2ViewMapper;
	@Autowired
	private AssetPlanInfoPlannerViewMapper plannerViewMapper;
	@Autowired
	private AssetPlanInfoOQDeptViewMapper oqDeptViewMapper;
	@Autowired
	private AssetPlanInfoDept1ViewMapper dept1ViewMapper;
	@Autowired
	private RequestsNumApproveRecordMapper recordMapper;
	@Autowired
	private AssetPlanInfoSearchViewMapper searchViewMapper;
	@Autowired
	private DeptInfoMapper deptInfoMapper;
	@Autowired
	private ProjectInfoMapper projectInfoMapper;
	@Autowired
	private AssetPlanInfoMenuViewMapper menuViewMapper;
	@Autowired
	private PlanTimeWindowsService planTimeWindowsService;
	@Autowired
	private AssetPlanInfoTodoViewMapper todoViewMapper;
	@Autowired
	private AssetRateInfoService assetRateInfoService;
	@Autowired
	private RateTotalInfoService rateTotalInfoService;
	@Autowired
	private AssetPlanInfoSearchExportViewMapper  searchExportViewMapper;
	
	/*@Override
	public int addAssetPlanInfo(AssetPlanInfo ap) {
		ap.setPlanmonth(new Date());
		ap.setApplytime(new Date());
		ap.setApplyuser("123123sad");
		ap.setModifier("123123sad");
		ap.setModifitime(new Date());
		return assetPlanInfoMapper.insert(ap);
	}*/

	/*@Override
	@Transactional
	public int batchAddAssetPlanInfo(List<AssetPlanInfo> lst)  {
		for(AssetPlanInfo ap:lst) {
			ap.setPlanmonth(new Date());
			ap.setApplytime(new Date());
			ap.setApplyuser("123123sad");
			ap.setModifier("123123sad");
			ap.setModifitime(new Date());
			assetPlanInfoMapper.insert(ap);
		}
		return lst.size();
	}*/
	
	@Override
 	public int editAssetPlanInfo(AssetPlanInfo assetPlanInfo) {		
 		return assetPlanInfoMapper.updateByPrimaryKey(assetPlanInfo);
 	}
	
	@Override
	@Transactional
 	public int batchEditAssetPlanInfo(List<AssetPlanInfo> lst) {
 		for(AssetPlanInfo ap:lst) {
			assetPlanInfoMapper.updateByPrimaryKey(ap);
		}
		return lst.size();
 	}
	
	/**
	 * 第二环节提交至第三环节用
	 * 写入使用率
	 */
	@Override
	@Transactional
	public int batchEditAssetPlanAndRate(List<AssetPlanInfo> lst,List<Integer> lstID) throws Exception{
		//更新流程状态
		batchEdit(lst);
		//异步写入使用率
		syncEdit( lst, lstID);
		return lst.size();
	}
	
	/**
	 * 批量更新
	 * @param lst
	 * @return
	 */
	@Transactional
	private  int batchEdit(List<AssetPlanInfo> lst) {			
		int count = lst.size();
		int groupSize = 200;
		int groupNo = count / groupSize;
		if (lst.size() <= groupSize) {
			assetPlanInfoMapper.updateBatchAssetPlanInfo(lst);
		} else {
			List<AssetPlanInfo> subList=null;
			for (int i = 1; i <= groupNo; i++) {
				int begin =(i-1)*groupSize;
				int end= 0;
				if(i==groupNo) {
					end = lst.size()-1;
				}else {
					end=i*groupSize;
				}
				
				subList = lst.subList(begin, end);
				assetPlanInfoMapper.updateBatchAssetPlanInfo(subList);
			}
			//sub 不包含最后一条 单独处理  数据不够 groupSize
			if (CollectionUtils.isNotEmpty(lst)) {
				assetPlanInfoMapper.updateByPrimaryKeySelective(lst.get(lst.size()-1));
			}
		}
		return count;
	}
	
	@Transactional
	private void syncEdit(List<AssetPlanInfo> lst, List<Integer> lstID) throws Exception {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.initialize();
		// 配置核心线程数
		executor.setCorePoolSize(1);
		// 配置最大线程数
		executor.setMaxPoolSize(1);
		executor.submit(new Runnable() {
			@Override
			public void run() {
				// 批量同步数据
				try {
					List<RateTotalInfo> lstTotal = new ArrayList<RateTotalInfo>();
					Long startForTime = System.currentTimeMillis();
					int i = 0;
					for (AssetPlanInfo info : lst) {
						RateTotalInfo rateTotalInfo  = assetRateInfoService.getRate(info.getAssetmodel(),
								info.getDeptcode(), info.getReviewtime());						
						rateTotalInfo.setId(info.getAssetplanid());
						rateTotalInfo.setCreatetime(new Date());
						lstTotal.add(rateTotalInfo);
						i++;
					}
					log.info("循环测试" + i);
					log.info("计算后的数值" + lstTotal.size());
					Long endForTime = System.currentTimeMillis();
					Long startinsertRateTime = System.currentTimeMillis();
					// 存储 使用率统计信息
					if (CollectionUtils.isNotEmpty(lstID)) {
						rateTotalInfoService.deleteByID(lstID);
					}
					if (CollectionUtils.isNotEmpty(lstTotal)) {
						rateTotalInfoService.insertBatch(lstTotal);
					}
					Long endinsertRateTime = System.currentTimeMillis();

					// 回写使用率
					Long startupdaterateTime = System.currentTimeMillis();
					if (CollectionUtils.isNotEmpty(lstID)) {
						assetPlanInfoMapper.updateUseRate(lstID);
					}
					Long endupdaterateTime = System.currentTimeMillis();

					log.info("for:" + (endForTime - startForTime) + "ms");
					log.info("insert:" + (endinsertRateTime - startinsertRateTime) + "ms");
					log.info("update:" + (endupdaterateTime - startupdaterateTime) + "ms");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

	}
	
	/**
	 * 同步前一天异步写入有问题的使用率
	 */
	@Override
	@Transactional
	public void syncUsageRateTask() throws Exception {
		List<AssetPlanInfo> lst= getUnWriteUseRate();		
		
		List<RateTotalInfo> lstTotal = new ArrayList<RateTotalInfo>();
		List<Integer> lstID=new ArrayList<Integer>();
		for (AssetPlanInfo info : lst) {
			RateTotalInfo rateTotalInfo  = assetRateInfoService.getRate(info.getAssetmodel(),
					info.getDeptcode(), info.getReviewtime());						
			rateTotalInfo.setId(info.getAssetplanid());
			rateTotalInfo.setCreatetime(new Date());
			lstTotal.add(rateTotalInfo);
			lstID.add(info.getAssetplanid());
		}
		// 存储 使用率统计信息
		if (CollectionUtils.isNotEmpty(lstID)) {
			rateTotalInfoService.deleteByID(lstID);
		}
		if (CollectionUtils.isNotEmpty(lstTotal)) {
			rateTotalInfoService.insertBatch(lstTotal);
		}

		// 回写使用率
		if (CollectionUtils.isNotEmpty(lstID)) {
			assetPlanInfoMapper.updateUseRate(lstID);
		}
	}

	
	@Override	
	@Transactional
	public void addAssetPlanInfo(AssetPlanGlobalInfo assetPlanGlobalInfo) {
		String purchasereportID = "",surchasereportid="";
		if(CollectionUtils.isNotEmpty(assetPlanGlobalInfo.purchaseReportInfo)) {
			purchasereportID = UUIDUtil.UUID();
			for(PurchaseReportInfo info : assetPlanGlobalInfo.getPurchaseReportInfo()) {
				info.setDeleteflag("1");
				info.setCreatetime(new Date());
				info.setCreator(UserUtils.getCurrentUserId());
				info.setModifier(UserUtils.getCurrentUserId());
				info.setModifitime(new Date());
				info.setPurchasereportid(purchasereportID);
				priMapper.insertSelective(info);
			}		
		}
		if(CollectionUtils.isNotEmpty(assetPlanGlobalInfo.specifyManufacturerInfo)) {
			surchasereportid = UUIDUtil.UUID();
			for(SpecifyManufacturerInfo info : assetPlanGlobalInfo.getSpecifyManufacturerInfo()) {
				info.setDeleteflag("1");
				info.setCreatetime(new Date());
				info.setCreator(UserUtils.getCurrentUserId());
				info.setModifier(UserUtils.getCurrentUserId());
				info.setModifitime(new Date());
				info.setSpecifymanufacturerid(surchasereportid);
				smiMapper.insertSelective(info);
			}		
		}
		//初始化成套设备的code
		Integer completesetcode = initApplyCode();
		for(AssetPlanInfo ap : assetPlanGlobalInfo.lst) {
			//是否需要申购报告字段为1时才会增加，set主表字段purchasereportid为关联表的id，否则设置默认值为0
			if(StringUtils.isNotBlank(ap.getIsreqpurchasereport()) && "1".equals(ap.getIsreqpurchasereport())) {
				ap.setPurchasereportid(purchasereportID);	
			}else {
				ap.setPurchasereportid("");
			}			
			//是否指定供应商字段为1时才会增加 ，set主表字段specifymanufacturerid为关联表的id，否则设置默认值为0
			if(StringUtils.isNotBlank(ap.getIsspecifymanufacturer()) && "1".equals(ap.getIsspecifymanufacturer())) {
				ap.setSpecifymanufacturerid(surchasereportid);		
			}else {
				ap.setSpecifymanufacturerid("");
			}
			//是否成套物品字段为1时说明是成套的设备,set套装编码,否则设置默认值为0
			if(StringUtils.isNotBlank(ap.getIscompleteset()) && "1".equals(ap.getIscompleteset())) {
				ap.setCompletesetcode(completesetcode);
			}else {
				ap.setCompletesetcode(0);
			}
			try {
				ap.setApplytime(new Date());
				ap.setModifitime(new Date());
				
				//正常计划外的状态 0正常计划，1计划员激活，2管理员激活
				//时间窗外创建的置为1，时间窗内置为0，得调向楠那边的时间接口
				boolean flag = planTimeWindowsService.valitSubmitTimeWiondow();
				//返回true说明在窗口内
				if(flag) {
					ap.setAbnormalplanenum(0);
				}else {
					ap.setAbnormalplanenum(1);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			//设置默认的值
			ap.setApstatus("10");
			ap.setApstage("1");
			ap.setDeleteflag("1");
			ap.setOuttimeplanenum(-1);
			//Applyuser Modifier这两个字段前端传过来了
			int insert = assetPlanInfoMapper.insert(ap);
		}
	}
	
	@Override	
	@Transactional
	public void editAssetPlanInfo(AssetPlanGlobalInfo assetPlanGlobalInfo) {
		String currentUserId = UserUtils.getCurrentUserId();
		if(CollectionUtils.isNotEmpty(assetPlanGlobalInfo.getPurchaseReportInfo())) {
			for(PurchaseReportInfo info : assetPlanGlobalInfo.getPurchaseReportInfo()) {				
				info.setModifier(UserUtils.getCurrentUserId());
				info.setModifitime(new Date());			
				priMapper.updateByPrimaryKeySelective(info);
			}	
		}
		
		if(CollectionUtils.isNotEmpty(assetPlanGlobalInfo.getSpecifyManufacturerInfo())) {
			for(SpecifyManufacturerInfo info : assetPlanGlobalInfo.getSpecifyManufacturerInfo()) {			
				info.setModifier(UserUtils.getCurrentUserId());
				info.setModifitime(new Date());			
				smiMapper.updateByPrimaryKeySelective(info);
			}
		}		
		
		for(AssetPlanInfo ap:assetPlanGlobalInfo.lst) {
			ap.setModifier(currentUserId);
			ap.setModifitime(new Date());
			assetPlanInfoMapper.updateByPrimaryKey(ap);
		}
	}
	
	@Override	
	@Transactional
	public int delAssetPlanInfo(List<Integer> lstDelID){
		Map<String,Object> param=new HashMap<>();
		param.put("id", lstDelID);
		param.put("Modifier", "delete");
		return  assetPlanInfoMapper.deleteByID(param);
	}
	
	@Transactional(readOnly = true)
	private synchronized Integer initApplyCode() {
		String partCode=new SimpleDateFormat("yyyy-MM").format(new Date()).toString()+"-"+ UserUtils.getCurrentUserId();
		Integer newCode;
		Integer maxCode = assetPlanInfoMapper.getMaxCompleteSetCode(partCode);
		if (maxCode==null ||maxCode==0) {
			newCode = 1;
		}else {
			newCode =maxCode+1;
		}
		return newCode;
	}
	
	/*@Override
	@Transactional
	public int editQuantity(AssetPlanInfo assetPlanlInfo) {				
		AssetPlanInfo old = assetPlanInfoMapper.selectByPrimaryKey(assetPlanlInfo.getAssetplanid());
		return 0;
	}*/

	@Override	
	@Transactional
	public int submitAssetPlanInfoByIds(Map<String, Object> param){
		return  assetPlanInfoMapper.submitAssetPlanInfoByIds(param);
	}
	
	
	@Override
	public List<AssetPlanInfo> selectCompleteSet(String planCode, Integer completeSetCode) {
		AssetPlanInfoExample example=new AssetPlanInfoExample();
		AssetPlanInfoExample.Criteria cia=example.createCriteria();
		cia.andPlancodeEqualTo(planCode);
		cia.andCompletesetcodeEqualTo(completeSetCode);
		cia.andDeleteflagEqualTo("1");
		return assetPlanInfoMapper.selectByExample(example);
	}

	/*@Override
	public List<AssetPlanInfoApplyView> getAssetPlanInfoList(String applyUser) {
		AssetPlanInfoApplyViewExample example=new AssetPlanInfoApplyViewExample();
		AssetPlanInfoApplyViewExample.Criteria cia=example.createCriteria();
		cia.andApplyuserEqualTo(applyUser);
		cia.andDeleteflagEqualTo("1");
		return applyViewMapper.selectByExample(example);
		
	}*/

	@Override
	public List<AssetPlanInfoMenuView> listofTodoInfo(Map<String, Object> param) {
		return menuViewMapper.listofTodoInfo(param);
	}

	@Override
	public int countTodoInfo(Map<String, Object> param) {
		return menuViewMapper.countTodoInfo(param);
	}

	@Override
	public List<AssetPlanInfo> listofTodoInfoDetail(Map<String, Object> param) {
		return assetPlanInfoMapper.listofTodoInfoDetail(param);
	}

	@Override
	public int countTodoInfoDetail(Map<String, Object> param) {
		return assetPlanInfoMapper.countTodoInfoDetail(param);
	}

	/*@Override
	public List<AssetPlanInfoApplyView> getDraftInfoList(String applyUser, String apstage,String applymonth) {
		AssetPlanInfoApplyViewExample example=new AssetPlanInfoApplyViewExample();
		AssetPlanInfoApplyViewExample.Criteria cia=example.createCriteria();
		cia.andApplyuserEqualTo(applyUser);
		cia.andApstageEqualTo(apstage);
		cia.andApplymonthEqualTo(applymonth);
		cia.andDeleteflagEqualTo("1");
		return applyViewMapper.selectByExample(example);
	}*/
	
	/*@Override
	public List<AssetPlanInfoReviewView> getReviewInfoList(String reviewer, String applymonth) {
		AssetPlanInfoReviewViewExample example=new AssetPlanInfoReviewViewExample();
		AssetPlanInfoReviewViewExample.Criteria cia=example.createCriteria();
		cia.andReviewerEqualTo(reviewer);
		cia.andApplymonthEqualTo(applymonth);
		cia.andDeleteflagEqualTo("1");
		return reviewViewMapper.selectByExample(example);
	}*/

	/*@Override
	public List<AssetPlanInfoDept3View> getDept3InfoList(String dept3Manager, String apstage) {
		AssetPlanInfoDept3ViewExample example=new AssetPlanInfoDept3ViewExample();
		AssetPlanInfoDept3ViewExample.Criteria cia=example.createCriteria();
		cia.andDept3managerEqualTo(dept3Manager);
		cia.andApstageEqualTo(apstage);
		//是未删除的
		cia.andDeleteflagEqualTo("1");
		//是规范审核状态的
		cia.andReviewresultEqualTo(1);
		return dept3ViewMapper.selectByExample(example);
	}*/

	/*@Override
	public List<AssetPlanInfoDept2View> getDept2InfoList(String dept2Manager, String apstage) {
		AssetPlanInfoDept2ViewExample example=new AssetPlanInfoDept2ViewExample();
		AssetPlanInfoDept2ViewExample.Criteria cia=example.createCriteria();
		cia.andDept2managerEqualTo(dept2Manager);
		cia.andApstageEqualTo(apstage);
		//是未删除的
		cia.andDeleteflagEqualTo("1");
		//是规范审核状态的
		cia.andReviewresultEqualTo(1);
		return dept2ViewMapper.selectByExample(example);
	}*/

	@Override
	public int submitInfoFromReviewToDept3(Map<String, Object> param) {
		return  assetPlanInfoMapper.submitInfoFromReviewToDept3(param);
	}

	@Override
	public int submitInfoFromDept3ToDept2(Map<String, Object> param) {
		return  assetPlanInfoMapper.submitInfoFromDept3ToDept2(param);
	}

	@Override
	public int submitInfoFromDept2ToPlanner(Map<String, Object> param) {
		return  assetPlanInfoMapper.submitInfoFromDept2ToPlanner(param);
	}

	@Override
	public int submitInfoFromPlannerToOQDept(Map<String, Object> param) {
		return  assetPlanInfoMapper.submitInfoFromPlannerToOQDept(param);
	}
	
	@Override
	public int submitInfoFromOQDeptToDept1(Map<String, Object> param) {
		return  assetPlanInfoMapper.submitInfoFromOQDeptToDept1(param);
	}
	
	@Override
	public int submitInfoFromDept1ToEnd(Map<String, Object> param) {
		return  assetPlanInfoMapper.submitInfoFromDept1ToEnd(param);
	}
	
	@Override
	public List<AssetPlanInfoAll> listofPlannerDetail(Map<String, Object> param) {
		return plannerViewMapper.listofPlannerDetail(param);
	}

	/*@Override
	public String getSumCountBeforeForPlanner(Map<String, Object> param) {
		return plannerViewMapper.getSumCountBeforeForPlanner(param);
	}*/

	/*@Override
	public String getSumCountAfterForPlanner(Map<String, Object> param) {
		return plannerViewMapper.getSumCountAfterForPlanner(param);
	}*/

	/*@Override
	public String getSumMoneyBeforeForPlanner(Map<String, Object> param) {
		return plannerViewMapper.getSumMoneyBeforeForPlanner(param);
	}*/

	/*@Override
	public String getSumMoneyAfterForPlanner(Map<String, Object> param) {
		return plannerViewMapper.getSumMoneyAfterForPlanner(param);
	}*/
	
	@Override
	public List<Integer> getPlannerListForFlag(Map<String, Object> param) {
		return plannerViewMapper.getListForFlag(param);
	}
	
	@Override
	public Map<String,Object>getPlannerGroupMess( Map<String, Object> param){
		return plannerViewMapper.getGroupMess(param);
	}
	
	@Override
	public Integer getPlannerListSize( Map<String, Object> param){
		return plannerViewMapper.getListSize(param);
	}

	@Override
	public List<AssetPlanInfoAll> listofOQDeptDetail(Map<String, Object> param) {
		return oqDeptViewMapper.listofOQDeptDetail(param);
	}
    
	/*@Override
	public String getSumCountBeforeForOQDept(Map<String, Object> param) {
		return oqDeptViewMapper.getSumCountBeforeForOQDept(param);
	}*/

	/*@Override
	public String getSumCountAfterForOQDept(Map<String, Object> param) {
		return oqDeptViewMapper.getSumCountAfterForOQDept(param);
	}*/

	/*@Override
	public String getSumMoneyBeforeForOQDept(Map<String, Object> param) {
		return oqDeptViewMapper.getSumMoneyBeforeForOQDept(param);
	}*/

	/*@Override
	public String getSumMoneyAfterForOQDept(Map<String, Object> param) {
		return oqDeptViewMapper.getSumMoneyAfterForOQDept(param);
	}*/
	
	@Override
	public List<Integer> getOQDeptListForFlag(Map<String, Object> param) {
		return oqDeptViewMapper.getListForFlag(param);
	}
    
	@Override
	public Map<String,Object>getOQDeptGroupMess(Map<String, Object> param){
		return oqDeptViewMapper.getGroupMess(param);
	}
    
	@Override
	public Integer getOQDeptListSize(Map<String, Object> param) {
		return oqDeptViewMapper.getListSize(param);
	}

	@Override
	public List<AssetPlanInfoAll> listofDept1Detail(Map<String, Object> param) {
		return dept1ViewMapper.listofDept1Detail(param);
	}

	/*@Override
	public String getSumCountBeforeForDept1(Map<String, Object> param) {
		return dept1ViewMapper.getSumCountBeforeForDept1(param);
	}*/

	/*@Override
	public String getSumCountAfterForDept1(Map<String, Object> param) {
		return dept1ViewMapper.getSumCountAfterForDept1(param);
	}*/

	/*@Override
	public String getSumMoneyBeforeForDept1(Map<String, Object> param) {
		return dept1ViewMapper.getSumMoneyBeforeForDept1(param);
	}*/

	/*@Override
	public String getSumMoneyAfterForDept1(Map<String, Object> param) {
		return dept1ViewMapper.getSumMoneyAfterForDept1(param);
	}*/
	
	@Override
	public List<Integer> getDept1ListForFlag(Map<String, Object> param) {
		return dept1ViewMapper.getListForFlag(param);
	}
	
	@Override
	public Map<String,Object>getDept1GroupMess( Map<String, Object> param){
		return dept1ViewMapper.getGroupMess(param);
	}
	
	@Override
	public Integer getDept1ListSize( Map<String, Object> param){
		return dept1ViewMapper.getListSize(param);
	}

	@Override
	public String getSumTotalMoneyForReview(Map<String, Object> param) {
		return reviewViewMapper.getSumTotalMoneyForReview(param);
	}

	@Override
	public List<AssetPlanInfoAll> getReviewResult(Map<String, Object> param) {
		return reviewViewMapper.getReviewResult(param);
	}

	@Override
	public String getSumTotalMoneyForDept3(Map<String, Object> param) {
		return dept3ViewMapper.getSumTotalMoneyForDept3(param);
	}

	@Override
	public String getSumActualMoneySumForDept3(Map<String, Object> param) {
		return dept3ViewMapper.getSumActualMoneySumForDept3(param);
	}

	@Override
	public String getSumTotalMoneyForDept2(Map<String, Object> param) {
		return dept2ViewMapper.getSumTotalMoneyForDept2(param);
	}
	
	@Override
	public String getSumMoneyWithThirdDept(Map<String, Object> param) {
		return dept2ViewMapper.getSumMoneyWithThirdDept(param);
	}

	@Override
	public String getSumActualMoneySumForDept2(Map<String, Object> param) {
		return dept2ViewMapper.getSumActualMoneySumForDept2(param);
	}

	@Override
	public String getSumTotalMoneyForDraft(Map<String, Object> param) {
		return applyViewMapper.getSumTotalMoneyForDraft(param);
	}

	@Override
	public int activateAssetPlanInfoByIds(Map<String, Object> param) {
		return assetPlanInfoMapper.activateAssetPlanInfoByIds(param);
	}

	@Override
	public List<AssetPlanInfoSearchExportView> exportAssetPlanInfoByIds(Map<String, Object> param) {
		return searchExportViewMapper.exportAssetPlanInfoByIds(param);
	}

	@Override
	public List<DeptInfo> getDeptInfoList() {
		return deptInfoMapper.getDeptInfoList();
	}
	
	@Override
	public List<DeptInfo> getDeptInfoListValid() {
		return deptInfoMapper.getDeptInfoListValid();
	}

	@Override
	public List<AssetPlanInfo> getNotReviewList(Map<String, Object> param) {
		return assetPlanInfoMapper.getNotReviewList(param);
	}

	@Override
	public List<String> getNotReviewApplyUserList(Map<String, Object> param) {
		return reviewViewMapper.getNotReviewApplyUserList(param);
	}

	@Override
	public List<AssetPlanInfoReviewView> getNotReviewListByApplyUser(Map<String, Object> param) {
		return reviewViewMapper.getNotReviewListByApplyUser(param);
	}

	@Override
	public List<ProjectInfo> getItemCodeTop20(Map<String,Object> param) {
		return projectInfoMapper.getItemCodeTop20(param);
	}

	@Override
	public List<String> getItemNameByItemCode(Map<String, Object> param) {
		return projectInfoMapper.getItemNameByItemCode(param);
	}

	@Override
	public List<AssetPlanInfoDetailView> selectCompleteSetAll(String planCode, Integer completeSetCode) {
		AssetPlanInfoDetailViewExample example=new AssetPlanInfoDetailViewExample();
		AssetPlanInfoDetailViewExample.Criteria cia=example.createCriteria();
		cia.andPlancodeEqualTo(planCode);
		cia.andCompletesetcodeEqualTo(completeSetCode);
		return detailassetPlanInfoMapper.selectByExample(example);
	}

	@Override
	public AssetPlanInfoDetailView getByAssetID(Integer assetplanid) {
		return detailassetPlanInfoMapper.getByAssetID(assetplanid);
	}

	@Override
	public List<AssetPlanInfo> getInfoListByReviewer(Map<String, Object> param) {
		return assetPlanInfoMapper.getInfoListByReviewer(param);
	}

	@Override
	public List<Integer> getAllReviewList(Map<String, Object> param) {
		return reviewViewMapper.getAllReviewList(param);
	}

	@Override
	public List<AssetPlanInfoAll> listofDept2Detail(Map<String, Object> param) {
		return dept2ViewMapper.listofDept2Detail(param);
	}

	@Override
	public List<AssetPlanInfoAll> listofDept3Detail(Map<String, Object> param) {
		return dept3ViewMapper.listofDept3Detail(param);
	}

	@Override
	public List<AssetPlanInfoAll> listofReviewDetail(Map<String, Object> param) {
		return reviewViewMapper.listofReviewDetail(param);
	}

	@Override
	public List<AssetPlanInfoAll> listofDraftDetail(Map<String, Object> param) {
		return applyViewMapper.listofDraftDetail(param);
	}

	@Override
	public String getBudgetSum(Map<String, Object> param) {
		return searchViewMapper.getBudgetSum(param);
	}

	@Override
	public String getBudgetTotalMoneyForDept3(Map<String, Object> param) {
		return dept3ViewMapper.getBudgetTotalMoneyForDept3(param);
	}

	@Override
	@Transactional
	public ResponseResult updateReviewResult(List<Integer> ids,Integer result,String reviewNote) throws Exception {
		Map<String,Object> param =new HashMap<String, Object>();
		param.put("result", result);
		param.put("reviewNote", reviewNote);
		param.put("modifier", UserUtils.getCurrentUserId());
		param.put("modifiTime", new Date());
		param.put("id",ids);
		if(result.equals(1)) {
			param.put("apstage", "2");
			param.put("apstatus", "20");
		}else if(result.equals(2)) {
			param.put("apstage", "1");
			param.put("apstatus", "11");
		}
		assetPlanInfoMapper.updateReviewResult(param);
		return ResponseResult.success(true,"修改成功");
	}

	@Override
	public String getSumTotalMoneyForTodo(Map<String, Object> param) {
		return todoViewMapper.getSumTotalMoneyForTodo(param);
	}

	@Override
	public List<AssetPlanInfoAll> listofTodoDetail(Map<String, Object> param) {
		return todoViewMapper.listofTodoDetail(param);
	}

	@Override
	public List<AssetPlanInfoMenuView> listofTodoInfoForRequiredUser(Map<String, Object> param) {
		return menuViewMapper.listofTodoInfoForRequiredUser(param);
	}

	/*@Override
	public List<AssetPlanInfoAll> listofPlannerDetailAfter(Map<String, Object> param) {
		return plannerViewMapper.listofPlannerDetailAfter(param);
	}*/

	/*@Override
	public List<AssetPlanInfoAll> listofOQDeptDetailAfter(Map<String, Object> param) {
		return oqDeptViewMapper.listofOQDeptDetailAfter(param);
	}*/

	
	
	/**
	 * 获取前一天使用率未计算数据
	 */
	private List<AssetPlanInfo> getUnWriteUseRate(){
		Calendar cal=Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, -1);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE,0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		Calendar cal_end=Calendar.getInstance();
		cal_end.add(Calendar.DAY_OF_MONTH, -1);
		cal_end.set(Calendar.HOUR_OF_DAY, 23);
		cal_end.set(Calendar.MINUTE,59);
		cal_end.set(Calendar.SECOND, 59);
		cal_end.set(Calendar.MILLISECOND, 0);
		
		AssetPlanInfoExample example=new AssetPlanInfoExample();
		AssetPlanInfoExample.Criteria cri= example.createCriteria();
		cri.andUsagerateIsNull();
		cri.andApstageNotEqualTo("1");
		cri.andReviewtimeBetween(cal.getTime(), cal_end.getTime());
		List<AssetPlanInfo> lst=assetPlanInfoMapper.selectByExample(example);
		
		return lst;
	}

	@Override
	public List<AssetPlanInfoPlannerView> exportAssetPlanInfoForPlanner(Map<String, Object> param) {
		return plannerViewMapper.exportAssetPlanInfoForPlanner(param);
	}

	@Override
	public List<Integer> getAllReviewListForGuiFan(Map<String, Object> param) {
		return reviewViewMapper.getAllReviewListForGuiFan(param);
	}

	@Override
	public List<AssetPlanInfoAll> getSearchResultForReview(Map<String, Object> param) {
		return reviewViewMapper.getSearchResultForReview(param);
	}
}

