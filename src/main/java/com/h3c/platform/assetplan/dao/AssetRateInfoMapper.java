package com.h3c.platform.assetplan.dao;

import com.h3c.platform.assetplan.entity.AssetRateInfo;
import com.h3c.platform.assetplan.entity.AssetRateInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AssetRateInfoMapper {
    long countByExample(AssetRateInfoExample example);

    int deleteByExample(AssetRateInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AssetRateInfo record);

    int insertSelective(AssetRateInfo record);

    List<AssetRateInfo> selectByExample(AssetRateInfoExample example);

    AssetRateInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AssetRateInfo record, @Param("example") AssetRateInfoExample example);

    int updateByExample(@Param("record") AssetRateInfo record, @Param("example") AssetRateInfoExample example);

    int updateByPrimaryKeySelective(AssetRateInfo record);

    int updateByPrimaryKey(AssetRateInfo record);
}