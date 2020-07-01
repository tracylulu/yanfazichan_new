package com.h3c.platform.assetplan.dao;

import com.h3c.platform.assetplan.entity.PurchaseReportInfo;
import com.h3c.platform.assetplan.entity.PurchaseReportInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PurchaseReportInfoMapper {
    long countByExample(PurchaseReportInfoExample example);

    int deleteByExample(PurchaseReportInfoExample example);

    int deleteByPrimaryKey(Integer purchasereportid);

    int insert(PurchaseReportInfo record);

    int insertSelective(PurchaseReportInfo record);

    List<PurchaseReportInfo> selectByExampleWithBLOBs(PurchaseReportInfoExample example);

    List<PurchaseReportInfo> selectByExample(PurchaseReportInfoExample example);

    PurchaseReportInfo selectByPrimaryKey(Integer purchasereportid);

    int updateByExampleSelective(@Param("record") PurchaseReportInfo record, @Param("example") PurchaseReportInfoExample example);

    int updateByExampleWithBLOBs(@Param("record") PurchaseReportInfo record, @Param("example") PurchaseReportInfoExample example);

    int updateByExample(@Param("record") PurchaseReportInfo record, @Param("example") PurchaseReportInfoExample example);

    int updateByPrimaryKeySelective(PurchaseReportInfo record);

    int updateByPrimaryKeyWithBLOBs(PurchaseReportInfo record);

    int updateByPrimaryKey(PurchaseReportInfo record);
    
    int insertBackID(PurchaseReportInfo record);
}