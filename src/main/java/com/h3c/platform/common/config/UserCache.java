package com.h3c.platform.common.config;

public class UserCache {



    //当前处理人
    private static final ThreadLocal<String> CURRENT_HANDLER = new ThreadLocal<>();

    public static void setCurrentHandler(String currentHandler){
        CURRENT_HANDLER.set(currentHandler);
    }

    public static String getCurrentHandler(){
        return CURRENT_HANDLER.get();
    }

    public static void removeCurrentHandler(){
        CURRENT_HANDLER.remove();
    }

    public static void removeAll(){
        CURRENT_HANDLER.remove();
       
    }

}
