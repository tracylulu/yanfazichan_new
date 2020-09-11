package com.h3c.platform.common.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.h3c.platform.common.dao.CalendarMapper;
import com.h3c.platform.common.entity.Calendar;
import com.h3c.platform.common.service.CalendarService;

@Service
public class CalendarServiceImpl implements CalendarService{
	@Autowired
	private CalendarMapper calendarMapper;
	
	@Override
	public Date getStartDay(Date startDate) {
		List<Calendar> lst = calendarMapper.getStartDate(startDate);
		
		if(CollectionUtils.isNotEmpty(lst)) {
			return lst.get(0).getTheDate();
		}
		return null;
	}

	/**
	 * 默认查出截止工作日的下一个工作日
	 */
	@Override
	public Date getEndNextDay(Date startDate,int len) {
		Map<String,Object> param= new HashMap<>();
		param.put("startDate", startDate);
		param.put("limit", len+1);
		List<Calendar> lst = calendarMapper.getEndDate(param);
		
		if(CollectionUtils.isNotEmpty(lst)) {
			return lst.get(lst.size()-1).getTheDate();
		}
		return null;
	}
	
	/**
	 * 默认查出截止工作日
	 */
	@Override
	public Date getEndDay(Date startDate,int len) {
		Map<String,Object> param= new HashMap<>();
		param.put("startDate", startDate);
		param.put("limit", len);
		List<Calendar> lst = calendarMapper.getEndDate(param);
		
		if(CollectionUtils.isNotEmpty(lst)) {
			return lst.get(lst.size()-1).getTheDate();
		}
		return null;
	}

	@Override
	public Date getBeforeDay(Date startDate, int len) {
		Map<String,Object> param= new HashMap<>();
		param.put("startDate", startDate);
		param.put("limit", len+1);
		List<Calendar> lst = calendarMapper.getBeforeDate(param);
		
		if(CollectionUtils.isNotEmpty(lst)) {
			return lst.get(lst.size()-1).getTheDate();
		}
		return null;
	}
	
}
