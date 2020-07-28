package com.h3c.platform.common.dao;

import com.h3c.platform.common.entity.ModelInfo;
import com.h3c.platform.common.entity.ModelInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface ModelInfoMapper {
    long countByExample(ModelInfoExample example);

    int deleteByExample(ModelInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ModelInfo record);

    int insertSelective(ModelInfo record);

    List<ModelInfo> selectByExample(ModelInfoExample example);

    ModelInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ModelInfo record, @Param("example") ModelInfoExample example);

    int updateByExample(@Param("record") ModelInfo record, @Param("example") ModelInfoExample example);

    int updateByPrimaryKeySelective(ModelInfo record);

    int updateByPrimaryKey(ModelInfo record);
    
    List<ModelInfo> getAll();
}