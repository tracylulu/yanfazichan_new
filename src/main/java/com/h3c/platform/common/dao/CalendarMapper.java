package com.h3c.platform.common.dao;

import com.h3c.platform.common.entity.Calendar;
import com.h3c.platform.common.entity.CalendarExample;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface CalendarMapper {
    long countByExample(CalendarExample example);

    int deleteByExample(CalendarExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Calendar record);

    int insertSelective(Calendar record);

    List<Calendar> selectByExample(CalendarExample example);

    Calendar selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Calendar record, @Param("example") CalendarExample example);

    int updateByExample(@Param("record") Calendar record, @Param("example") CalendarExample example);

    int updateByPrimaryKeySelective(Calendar record);

    int updateByPrimaryKey(Calendar record);
    
    List<Calendar>  getStartDate(Date startDate);
    
    List<Calendar>  getEndDate(@Param("param")Map<String,Object> param);
    
    List<Calendar>  getBeforeDate(@Param("param")Map<String,Object> param);
}