package com.h3c.platform.assetplan.dao;

import com.h3c.platform.assetplan.entity.PDMAN_DB_VERSION;
import com.h3c.platform.assetplan.entity.PDMAN_DB_VERSIONExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PDMAN_DB_VERSIONMapper {
    long countByExample(PDMAN_DB_VERSIONExample example);

    int deleteByExample(PDMAN_DB_VERSIONExample example);

    int insert(PDMAN_DB_VERSION record);

    int insertSelective(PDMAN_DB_VERSION record);

    List<PDMAN_DB_VERSION> selectByExample(PDMAN_DB_VERSIONExample example);

    int updateByExampleSelective(@Param("record") PDMAN_DB_VERSION record, @Param("example") PDMAN_DB_VERSIONExample example);

    int updateByExample(@Param("record") PDMAN_DB_VERSION record, @Param("example") PDMAN_DB_VERSIONExample example);
}