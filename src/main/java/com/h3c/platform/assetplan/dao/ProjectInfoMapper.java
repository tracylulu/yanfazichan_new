package com.h3c.platform.assetplan.dao;

import com.h3c.platform.assetplan.entity.ProjectInfo;
import com.h3c.platform.assetplan.entity.ProjectInfoExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface ProjectInfoMapper {
    long countByExample(ProjectInfoExample example);

    int deleteByExample(ProjectInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProjectInfo record);

    int insertSelective(ProjectInfo record);

    List<ProjectInfo> selectByExample(ProjectInfoExample example);

    ProjectInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProjectInfo record, @Param("example") ProjectInfoExample example);

    int updateByExample(@Param("record") ProjectInfo record, @Param("example") ProjectInfoExample example);

    int updateByPrimaryKeySelective(ProjectInfo record);

    int updateByPrimaryKey(ProjectInfo record);
    
    List<ProjectInfo> getItemCodeTop20(@Param("param") Map<String,Object> param);
    
    List<String> getItemNameByItemCode(@Param("param") Map<String,Object> param);
    
    int insertByEosData();
    
    int deleteInvalidData();
    
    int updateByEosData();
}