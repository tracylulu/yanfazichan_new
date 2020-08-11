package com.h3c.platform.assetplan.dao;

import com.h3c.platform.assetplan.entity.ProcessRecordInfo;
import com.h3c.platform.assetplan.entity.ProcessRecordInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProcessRecordInfoMapper {
    long countByExample(ProcessRecordInfoExample example);

    int deleteByExample(ProcessRecordInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProcessRecordInfo record);

    int insertSelective(ProcessRecordInfo record);

    List<ProcessRecordInfo> selectByExample(ProcessRecordInfoExample example);

    ProcessRecordInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProcessRecordInfo record, @Param("example") ProcessRecordInfoExample example);

    int updateByExample(@Param("record") ProcessRecordInfo record, @Param("example") ProcessRecordInfoExample example);

    int updateByPrimaryKeySelective(ProcessRecordInfo record);

    int updateByPrimaryKey(ProcessRecordInfo record);
    
    int batchInsert(@Param("lst") List<ProcessRecordInfo> lst);
}