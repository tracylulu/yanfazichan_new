package com.h3c.platform.util;

import com.h3c.platform.common.config.UserCache;

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
}
