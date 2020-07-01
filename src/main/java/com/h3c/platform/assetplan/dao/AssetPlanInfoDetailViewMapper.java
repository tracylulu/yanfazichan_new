package com.h3c.platform.assetplan.dao;

import com.h3c.platform.assetplan.entity.AssetPlanInfoDetailView;
import com.h3c.platform.assetplan.entity.AssetPlanInfoDetailViewExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AssetPlanInfoDetailViewMapper {
    long countByExample(AssetPlanInfoDetailViewExample example);

    int deleteByExample(AssetPlanInfoDetailViewExample example);

    int insert(AssetPlanInfoDetailView record);

    int insertSelective(AssetPlanInfoDetailView record);

    List<AssetPlanInfoDetailView> selectByExample(AssetPlanInfoDetailViewExample example);

    int updateByExampleSelective(@Param("record") AssetPlanInfoDetailView record, @Param("example") AssetPlanInfoDetailViewExample example);

    int updateByExample(@Param("record") AssetPlanInfoDetailView record, @Param("example") AssetPlanInfoDetailViewExample example);

    AssetPlanInfoDetailView getByAssetID(Integer assetplanid);

}