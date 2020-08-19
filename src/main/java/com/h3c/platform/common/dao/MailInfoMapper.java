package com.h3c.platform.common.dao;

import com.h3c.platform.common.entity.MailInfo;
import com.h3c.platform.common.entity.MailInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MailInfoMapper {
    long countByExample(MailInfoExample example);

    int deleteByExample(MailInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MailInfo record);

    int insertSelective(MailInfo record);

    List<MailInfo> selectByExampleWithBlobs(MailInfoExample example);

    List<MailInfo> selectByExample(MailInfoExample example);

    MailInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MailInfo record, @Param("example") MailInfoExample example);

    int updateByExampleWithBlobs(@Param("record") MailInfo record, @Param("example") MailInfoExample example);

    int updateByExample(@Param("record") MailInfo record, @Param("example") MailInfoExample example);

    int updateByPrimaryKeySelective(MailInfo record);

    int updateByPrimaryKeyWithBlobs(MailInfo record);

    int updateByPrimaryKey(MailInfo record);
}