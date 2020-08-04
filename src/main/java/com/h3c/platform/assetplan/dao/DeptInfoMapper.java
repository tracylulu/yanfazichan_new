package com.h3c.platform.assetplan.dao;

import com.h3c.platform.assetplan.entity.DeptInfo;
import com.h3c.platform.assetplan.entity.DeptInfoExample;
import com.h3c.platform.assetplan.entity.DeptTreeInfo;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface DeptInfoMapper {
    long countByExample(DeptInfoExample example);

    int deleteByExample(DeptInfoExample example);

    int deleteByPrimaryKey(Integer deptCode);

    int insert(DeptInfo record);

    int insertSelective(DeptInfo record);

    List<DeptInfo> selectByExample(DeptInfoExample example);

    DeptInfo selectByPrimaryKey(Integer deptCode);

    int updateByExampleSelective(@Param("record") DeptInfo record, @Param("example") DeptInfoExample example);

    int updateByExample(@Param("record") DeptInfo record, @Param("example") DeptInfoExample example);

    int updateByPrimaryKeySelective(DeptInfo record);

    int updateByPrimaryKey(DeptInfo record);
    
    List<DeptInfo> getDeptInfoList();
    
    List<DeptInfo> getDeptInfoListValid();
    
    int insertByEosData();
    
    int deleteInvalidData();
    
    int updateByEosData();
    
    List<DeptInfo> getCoaByAssetPlanID(@Param("lst") List<Integer> lst);
    
    List<DeptInfo> getTwoLevelCoaByAssetPlanID(@Param("lst") List<Integer> lst);
    
}