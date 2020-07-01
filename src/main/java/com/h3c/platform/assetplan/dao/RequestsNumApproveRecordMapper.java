package com.h3c.platform.assetplan.dao;

import com.h3c.platform.assetplan.entity.RequestsNumApproveRecord;
import com.h3c.platform.assetplan.entity.RequestsNumApproveRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RequestsNumApproveRecordMapper {
    long countByExample(RequestsNumApproveRecordExample example);

    int deleteByExample(RequestsNumApproveRecordExample example);

    int deleteByPrimaryKey(Integer assetplanid);

    int insert(RequestsNumApproveRecord record);

    int insertSelective(RequestsNumApproveRecord record);

    List<RequestsNumApproveRecord> selectByExample(RequestsNumApproveRecordExample example);

    RequestsNumApproveRecord selectByPrimaryKey(Integer assetplanid);

    int updateByExampleSelective(@Param("record") RequestsNumApproveRecord record, @Param("example") RequestsNumApproveRecordExample example);

    int updateByExample(@Param("record") RequestsNumApproveRecord record, @Param("example") RequestsNumApproveRecordExample example);

    int updateByPrimaryKeySelective(RequestsNumApproveRecord record);

    int updateByPrimaryKey(RequestsNumApproveRecord record);
}