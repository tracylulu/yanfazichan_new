package com.h3c.platform.common.config;

public class UserCache {



    //当前处理人
    private static final ThreadLocal<String> CURRENT_HANDLER = new ThreadLocal<>();
    //当前处理人域账号
    private static final ThreadLocal<String> CURRENT_HANDLER_DM = new ThreadLocal<>();

    public static void setCurrentHandler(String currentHandler){
        CURRENT_HANDLER.set(currentHandler);
    }

    public static String getCurrentHandler(){
        return CURRENT_HANDLER.get();
    }
    
    public static void setCurrentHandlerDM(String currentHandlerDM){
    	CURRENT_HANDLER_DM.set(currentHandlerDM);
    }

    public static String getCurrentHandlerDM(){
        return CURRENT_HANDLER_DM.get();
    }

    public static void removeCurrentHandler(){
        CURRENT_HANDLER.remove();
    }
    
    public static void removeCurrentHandlerDM(){
        CURRENT_HANDLER_DM.remove();
    }

    public static void removeAll(){
        CURRENT_HANDLER.remove();
        CURRENT_HANDLER_DM.remove();
       
    }

}
