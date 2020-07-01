/**
 *
 */
package com.eos.common.constant;

/**
 * @author s17742
 *
 */
public enum AssetTableHeaderEnum {
	AssetPlanID("assetplanid", "主键 自增","11"),
	PlanCode("plancode", "申购序号 格式YYYY-00001，年月－工号","32"),
	PPrice("pprice", "预计单价","32"),
	
	
	TotalMoney("totalmoney", "申购金额","32"),
	ActualMoney("actualmoney", "同意申购金额","32"),
	AssetName("assetname", "物品名称","128"),
	AssetManufacturer("assetmanufacturer", "厂家","128"),
	AssetModel("assetmodel", "型号","32"),
	AssetCategory("assetcategory", "类别","32"),
	
	NoPassCount("noPassCount", "未通过数量","11"),
	
	Requireds("requireds", "申报数量","11"),
	RequiredsAudit("requiredsaudit", "同意申购数量","11"),
	
	Purpose("purpose", "申请用途","512"),
	DeptCode("deptcode", "三级部门","32"),
	Dept2Code("dept2code", "二级部门","32"),
	Dept3Name("dept3name", "三级部门","32"),
	Dept2Name("dept2name", "二级部门","32"),
	ItemCode("itemcode", "项目编码","32"),
	
	RequiredUser("requireduser", "申购人姓名/工号","32"),
	RequiredUserName("requiredusername", "申购人姓名/工号","32"),
	receiverplace("receiverplace", "到货地点","32"),
	AssetNote("assetnote", "备注","512"),
	ApplyUser("applyuser", "申请人 ","32"),
	ApplyTime("applytime", "申请时间","0"),
	CompleteSetCode("completesetcode", "成套设备编码","11"),
	ManufacturerTypeEnum("manufacturertypeenum", "供应商类别-事实上独家供应","11"),
	APStatus("apstatus", "物品审批状态Code","32"),
	APStage("apstage", "物品所处的审批阶段","32"),
	UsageRate("usagerate", "使用率","4"),
	ReviewResult("reviewresult", "规范审核状态","11"),
	
	APStatusDetail("apstatusdetail", "当前环节","32"),
	ApplyMonth("applymonth", "申请月份","32"),
	
	Action("action", "操作","0"),
	ActionNot("actionNot", "操作","0"),
	Num("num", "序号","0"),

	//一级部门主管页面显示的评审意见
	Dept1ReviewNote("dept1reviewnote", "评审意见","128"),
	Dept1ReviewTime("dept1reviewtime", "审批时间","0"),
	Dept1Reviewer("dept1reviewer", "审批人","32"),
	Dept1ReviewerCount("dept1managercount", "同意申购数量","11"),
	//专家团页面显示的评审意见
	OQDeptReviewNote("oqdeptreviewnote", "评审意见","128"),
	OQDeptReviewTime("oqdeptreviewtime", "审批时间","0"),
	OQDeptReviewer("oqdeptreviewer", "审批人","32"),
	OQDeptReviewerCount("oqdeptreviewercount", "同意申购数量","11"),
	//计划员页面显示的评审意见
	PlannerNote("plannernote", "评审意见","128"),
	PlannerTime("plannertime", "审批时间","0"),
	Planner("planner", "审批人","32"),
	PlannerCount("plannercount", "同意申购数量","11"),
	//二级部门主管页面显示的评审意见
	Dept2CheckNote("dept2checknote", "评审意见","128"),
	Dept2CheckTime("dept2checktime", "审批时间","0"),
	Dept2Manager("dept2manager", "审批人","32"),
	Dept2ManagerCount("dept2managercount", "同意申购数量","11"),
	//三级部门主管页面显示的评审意见
	Dept3CheckNote("dept3checknote", "评审意见","128"),
	Dept3CheckTime("dept3checktime", "审批时间","0"),
	Dept3Manager("dept3manager", "审批人","32"),
	Dept3ManagerCount("dept3managercount", "同意申购数量","11"),
	
	//规范审核页面显示的评审意见
	ReviewNote("reviewnote", "评审意见","128"),
	ReviewTime("reviewtime", "审批时间","0"),
	Reviewer("reviewer", "审批人","32");
	
	
	
	
	
	
    private String code;

    private String massage;
    
    private String len;

    AssetTableHeaderEnum(String code, String massage,String len) {
        this.code = code;
        this.massage = massage;
        this.len = len;
    }

    public String getCode() {
        return code;
    }

    public String getMassage() {
        return massage;
    }
    public String getLen() {
        return len;
    }
    
}
