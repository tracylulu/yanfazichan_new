package com.h3c.platform.assetplan.dao;

import com.h3c.platform.assetplan.entity.BPMRelationInfo;
import com.h3c.platform.assetplan.entity.BPMRelationInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BPMRelationInfoMapper {
    long countByExample(BPMRelationInfoExample example);

    int deleteByExample(BPMRelationInfoExample example);

    int deleteByPrimaryKey(Integer asstplanid);

    int insert(BPMRelationInfo record);

    int insertSelective(BPMRelationInfo record);

    List<BPMRelationInfo> selectByExample(BPMRelationInfoExample example);

    BPMRelationInfo selectByPrimaryKey(Integer asstplanid);

    int updateByExampleSelective(@Param("record") BPMRelationInfo record, @Param("example") BPMRelationInfoExample example);

    int updateByExample(@Param("record") BPMRelationInfo record, @Param("example") BPMRelationInfoExample example);

    int updateByPrimaryKeySelective(BPMRelationInfo record);

    int updateByPrimaryKey(BPMRelationInfo record);
    
    List<BPMRelationInfo> getByIDList(@Param("lst")List<Integer> lst);
}