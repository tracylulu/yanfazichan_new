package com.h3c.platform.sync.dao;

import com.h3c.platform.sync.entity.DeptInfo_EOS;
import com.h3c.platform.sync.entity.DeptInfo_EOSExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface DeptInfo_EOSMapper {
    long countByExample(DeptInfo_EOSExample example);

    int deleteByExample(DeptInfo_EOSExample example);

    int deleteByPrimaryKey(Integer deptCode);

    int insert(DeptInfo_EOS record);

    int insertSelective(DeptInfo_EOS record);

    List<DeptInfo_EOS> selectByExample(DeptInfo_EOSExample example);

    DeptInfo_EOS selectByPrimaryKey(Integer deptCode);

    int updateByExampleSelective(@Param("record") DeptInfo_EOS record, @Param("example") DeptInfo_EOSExample example);

    int updateByExample(@Param("record") DeptInfo_EOS record, @Param("example") DeptInfo_EOSExample example);

    int updateByPrimaryKeySelective(DeptInfo_EOS record);

    int updateByPrimaryKey(DeptInfo_EOS record);
    
    int insertDeptEos(List<Map<String, Object>>  list);
    
	int deleteDeptEos();
}