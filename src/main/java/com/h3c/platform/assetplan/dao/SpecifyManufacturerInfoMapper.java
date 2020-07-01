package com.h3c.platform.assetplan.dao;

import com.h3c.platform.assetplan.entity.SpecifyManufacturerInfo;
import com.h3c.platform.assetplan.entity.SpecifyManufacturerInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SpecifyManufacturerInfoMapper {
    long countByExample(SpecifyManufacturerInfoExample example);

    int deleteByExample(SpecifyManufacturerInfoExample example);

    int deleteByPrimaryKey(Integer specifymanufacturerid);

    int insert(SpecifyManufacturerInfo record);

    int insertSelective(SpecifyManufacturerInfo record);

    List<SpecifyManufacturerInfo> selectByExampleWithBLOBs(SpecifyManufacturerInfoExample example);

    List<SpecifyManufacturerInfo> selectByExample(SpecifyManufacturerInfoExample example);

    SpecifyManufacturerInfo selectByPrimaryKey(Integer specifymanufacturerid);

    int updateByExampleSelective(@Param("record") SpecifyManufacturerInfo record, @Param("example") SpecifyManufacturerInfoExample example);

    int updateByExampleWithBLOBs(@Param("record") SpecifyManufacturerInfo record, @Param("example") SpecifyManufacturerInfoExample example);

    int updateByExample(@Param("record") SpecifyManufacturerInfo record, @Param("example") SpecifyManufacturerInfoExample example);

    int updateByPrimaryKeySelective(SpecifyManufacturerInfo record);

    int updateByPrimaryKeyWithBLOBs(SpecifyManufacturerInfo record);

    int updateByPrimaryKey(SpecifyManufacturerInfo record);
    
    
    
    int insertBackID(SpecifyManufacturerInfo record);
}