package com.h3c.platform.common.dao;

import java.util.List;
import java.util.Map;

import com.h3c.platform.common.entity.SysDicInfo;

public interface SysDicInfoMapper {
    
    int insertSysDicInfo(SysDicInfo record);
    
    int updateSysDicInfo(SysDicInfo record);
    
    
    List<SysDicInfo> selectByColumn(SysDicInfo sysDicInfo);
    
    List<SysDicInfo> listofSysDicInfo(Map<String, Object> param);
    int countSysDicInfo(Map<String, Object> param);
}