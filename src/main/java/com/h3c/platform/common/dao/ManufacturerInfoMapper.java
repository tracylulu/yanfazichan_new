package com.h3c.platform.common.dao;

import com.h3c.platform.common.entity.ManufacturerInfo;
import com.h3c.platform.common.entity.ManufacturerInfoExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface ManufacturerInfoMapper {
    long countByExample(ManufacturerInfoExample example);

    int deleteByExample(ManufacturerInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ManufacturerInfo record);

    int insertSelective(ManufacturerInfo record);

    List<ManufacturerInfo> selectByExample(ManufacturerInfoExample example);

    ManufacturerInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ManufacturerInfo record, @Param("example") ManufacturerInfoExample example);

    int updateByExample(@Param("record") ManufacturerInfo record, @Param("example") ManufacturerInfoExample example);

    int updateByPrimaryKeySelective(ManufacturerInfo record);

    int updateByPrimaryKey(ManufacturerInfo record);
    
    List<ManufacturerInfo> getManufacturerInfoByName(@Param("name")String name);
    
    List<ManufacturerInfo> getManufacturerInfoByNameForSearch(@Param("name")String name);
    
    List<ManufacturerInfo> getAll();
    
}