package com.h3c.platform.sync.dao;

import com.h3c.platform.sync.entity.ProjectInfo_EOS;
import com.h3c.platform.sync.entity.ProjectInfo_EOSExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface ProjectInfo_EOSMapper {
    long countByExample(ProjectInfo_EOSExample example);

    int deleteByExample(ProjectInfo_EOSExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProjectInfo_EOS record);

    int insertSelective(ProjectInfo_EOS record);

    List<ProjectInfo_EOS> selectByExample(ProjectInfo_EOSExample example);

    ProjectInfo_EOS selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProjectInfo_EOS record, @Param("example") ProjectInfo_EOSExample example);

    int updateByExample(@Param("record") ProjectInfo_EOS record, @Param("example") ProjectInfo_EOSExample example);

    int updateByPrimaryKeySelective(ProjectInfo_EOS record);

    int updateByPrimaryKey(ProjectInfo_EOS record);
    
    int insertProjectInfoEos(List<Map> list);
    
   	int deleteProjectInfoEos();
}