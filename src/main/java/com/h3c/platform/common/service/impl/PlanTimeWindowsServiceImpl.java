package com.h3c.platform.common.service.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.h3c.platform.common.commonconst.DicConst;
import com.h3c.platform.common.service.CalendarService;
import com.h3c.platform.common.service.PlanTimeWindowsService;
import com.h3c.platform.common.service.SysDicInfoService;
import com.h3c.platform.common.util.ObjToStrUtil;

@Service
public class PlanTimeWindowsServiceImpl implements  PlanTimeWindowsService{
	@Autowired
	private CalendarService calendarService;
	@Autowired
	private SysDicInfoService sysDicInfoService;
	
	@Override
	public boolean valitSubmitTimeWiondow()  throws Exception{
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		int interval=0;
		Date now=new Date();
		Calendar cal= null;
		cal=Calendar.getInstance();
		Integer month=cal.get(Calendar.MONTH)+1;
		
		JSONArray approveDate=sysDicInfoService.getJSONArrayDicsByType(DicConst.R_APPROVEDATE);
		JSONObject objStartDay= sysDicInfoService.getDicByTypeAndCode(DicConst.R_STARTDATE,month.toString());
		int startDay =objStartDay.getIntValue("dic_name");
		Calendar startCal=null;
		startCal = Calendar.getInstance();
		startCal.set(Calendar.DAY_OF_MONTH, startDay);	
		startCal.set(Calendar.HOUR_OF_DAY, 0);
		// 分
		startCal.set(Calendar.MINUTE, 0);
		// 秒
		startCal.set(Calendar.SECOND, 0);
		// 毫秒
		startCal.set(Calendar.MILLISECOND, 0);

		Date workSartDate=calendarService.getStartDay(startCal.getTime());
		
		if(workSartDate==null) {
			throw new Exception("未查询到启动工作日");
		}
		
		for(int i=0;i<approveDate.size();i++) {
			JSONObject obj=approveDate.getJSONObject(i);
			if("1".equals(ObjToStrUtil.ReplaceNullValue(obj.get("dic_code")))){
				interval=obj.getInteger("dic_name");				
			}		
		}	
		
		Date workEndDate=calendarService.getEndNextDay(workSartDate,interval);
		if(workSartDate==null) {
			throw new Exception("未查询到结束工作日");
		}
		Calendar calEnd=Calendar.getInstance();
		calEnd.setTime(workEndDate);
		calEnd.set(Calendar.HOUR_OF_DAY, 0);
		calEnd.set(Calendar.MINUTE, 0);
		calEnd.set(Calendar.SECOND, 0);
		calEnd.set(Calendar.MILLISECOND, 0);
		
		
		// start    now   end
		if(!calEnd.getTime().before(now)&&!workSartDate.after(now)) {
			return true;
		}
		return false;
	}
}
