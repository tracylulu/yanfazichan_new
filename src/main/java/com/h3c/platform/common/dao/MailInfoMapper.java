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

    List<MailInfo> selectByExampleWithBLOBs(MailInfoExample example);

    List<MailInfo> selectByExample(MailInfoExample example);

    MailInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MailInfo record, @Param("example") MailInfoExample example);

    int updateByExampleWithBLOBs(@Param("record") MailInfo record, @Param("example") MailInfoExample example);

    int updateByExample(@Param("record") MailInfo record, @Param("example") MailInfoExample example);

    int updateByPrimaryKeySelective(MailInfo record);

    int updateByPrimaryKeyWithBLOBs(MailInfo record);

    int updateByPrimaryKey(MailInfo record);
}