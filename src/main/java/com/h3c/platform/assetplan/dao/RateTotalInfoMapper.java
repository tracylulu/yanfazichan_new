package com.h3c.platform.assetplan.dao;

import com.h3c.platform.assetplan.entity.RateTotalInfo;
import com.h3c.platform.assetplan.entity.RateTotalInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RateTotalInfoMapper {
    long countByExample(RateTotalInfoExample example);

    int deleteByExample(RateTotalInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RateTotalInfo record);

    int insertSelective(RateTotalInfo record);

    List<RateTotalInfo> selectByExample(RateTotalInfoExample example);

    RateTotalInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RateTotalInfo record, @Param("example") RateTotalInfoExample example);

    int updateByExample(@Param("record") RateTotalInfo record, @Param("example") RateTotalInfoExample example);

    int updateByPrimaryKeySelective(RateTotalInfo record);

    int updateByPrimaryKey(RateTotalInfo record);
    
    int insertBatch(@Param("lst")List<RateTotalInfo> lst);
    
    int deleteByID(@Param("lst")List<Integer> lst);
}