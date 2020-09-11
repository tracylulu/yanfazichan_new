package com.h3c.platform.common.service;

import java.util.Date;

import com.h3c.platform.common.entity.Calendar;

public interface CalendarService {

	Date getStartDay(Date startDate);
	
	Date getEndNextDay(Date startDate,int len);
	
	Date getEndDay(Date startDate,int len);
	
	Date getBeforeDay(Date startDate,int len);
}
