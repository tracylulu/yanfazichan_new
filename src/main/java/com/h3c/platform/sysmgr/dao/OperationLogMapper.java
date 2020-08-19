package com.h3c.platform.sysmgr.dao;

import com.h3c.platform.sysmgr.entity.OperationLog;
import com.h3c.platform.sysmgr.entity.OperationLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OperationLogMapper {
    long countByExample(OperationLogExample example);

    int deleteByExample(OperationLogExample example);

    int deleteByPrimaryKey(Long logid);

    int insert(OperationLog record);

    int insertSelective(OperationLog record);

    List<OperationLog> selectByExampleWithBlobs(OperationLogExample example);

    List<OperationLog> selectByExample(OperationLogExample example);

    OperationLog selectByPrimaryKey(Long logid);

    int updateByExampleSelective(@Param("record") OperationLog record, @Param("example") OperationLogExample example);

    int updateByExampleWithBlobs(@Param("record") OperationLog record, @Param("example") OperationLogExample example);

    int updateByExample(@Param("record") OperationLog record, @Param("example") OperationLogExample example);

    int updateByPrimaryKeySelective(OperationLog record);

    int updateByPrimaryKeyWithBlobs(OperationLog record);

    int updateByPrimaryKey(OperationLog record);
}