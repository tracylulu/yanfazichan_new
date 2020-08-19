package com.h3c.platform.common.util;

import org.apache.commons.lang.ObjectUtils;

public class ObjToStrUtil {
	/**
	 * 处理object类型字符串，替换null值
	 * @param val
	 * @return
	 */
	public static String replaceNullValue(Object val) {
		String value=ObjectUtils.toString(val, "");	
		if("null".equalsIgnoreCase(value)) {
			return "";
		}
		return value;				
	}

}
