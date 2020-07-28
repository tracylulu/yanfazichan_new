package com.h3c.platform.util;

import java.util.List;
import java.util.Optional;

import com.h3c.platform.common.config.UserCache;
import com.h3c.platform.common.util.ObjToStrUtil;
import com.h3c.platform.sysmgr.entity.UserInfo;

public class UserUtils {
	
    public static String getCurrentUserId(){
        //HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        //return (String) request.getSession().getAttribute("UserIdentity");
    	String userId = "";
    	try {
			 userId = UserCache.getCurrentHandler();
		} catch (Exception e) {
			e.printStackTrace();
		}
    	System.out.println("----------------" + userId);
    	return userId;
    }
    
    public static String getCurrentDominAccount(){       
    	String userId = "";
    	try {
			 userId = UserCache.getCurrentHandlerDM();
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return userId;
    }
    
    public static String getAccountByCode(List<UserInfo> lst,String code) {
    	String result="";
    	Optional<UserInfo> temp=lst.stream().filter(o->code.equals(o.getEmpCode())).findFirst();
		if(temp.isPresent()) {
			result= temp.get().getEmpName()+' '+temp.get().getEmpCode();
		}		
		return result;
    }
}
