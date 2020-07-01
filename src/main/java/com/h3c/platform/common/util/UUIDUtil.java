package com.h3c.platform.common.util;

public class UUIDUtil {
    
    private UUIDUtil(){
        
    }

    public static String UUID() {
        return java.util.UUID.randomUUID().toString();
    }
}
