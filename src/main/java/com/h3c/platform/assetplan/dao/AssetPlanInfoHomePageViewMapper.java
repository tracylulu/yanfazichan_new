package com.h3c.platform.assetplan.dao;

import com.h3c.platform.assetplan.entity.AssetPlanInfoHomePageView;
import com.h3c.platform.assetplan.entity.AssetPlanInfoHomePageViewExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface AssetPlanInfoHomePageViewMapper {
    long countByExample(AssetPlanInfoHomePageViewExample example);

    int deleteByExample(AssetPlanInfoHomePageViewExample example);

    int insert(AssetPlanInfoHomePageView record);

    int insertSelective(AssetPlanInfoHomePageView record);

    List<AssetPlanInfoHomePageView> selectByExample(AssetPlanInfoHomePageViewExample example);

    int updateByExampleSelective(@Param("record") AssetPlanInfoHomePageView record, @Param("example") AssetPlanInfoHomePageViewExample example);

    int updateByExample(@Param("record") AssetPlanInfoHomePageView record, @Param("example") AssetPlanInfoHomePageViewExample example);

    AssetPlanInfoHomePageView getApprovalRecordById(Integer assetplanid);

}