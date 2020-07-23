package com.h3c.platform.assetplan.entity;

import java.util.Date;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import springfox.documentation.annotations.ApiIgnore;

@ApiModel(value="计划员环节导出入参",description="计划员环节导出入参")
public class AssetInfoPlannerExportEntity {
    
    //计划员环节处理人(当前登录人)
    private String planner;
    
    //申请月份
    private String applymonth;

	public String getPlanner() {
		return planner;
	}

	public void setPlanner(String planner) {
		this.planner = planner;
	}

	public String getApplymonth() {
		return applymonth;
	}

	public void setApplymonth(String applymonth) {
		this.applymonth = applymonth;
	}
     
   
	




    
}
