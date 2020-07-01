/**
 * 
 */
package com.h3c.platform.common.commonconst;

/**
 * @author s21046 sunliguo
 * @创建日期 2020年2月13日 下午6:03:00
 */
public class ResponseResultConst {
	public static int STATUS_SUCCESS = 0;
	public static int STATUS_FAIL = 1;
	public static String MSG_SUCCESS = "查询成功";
	public static String MSG_FAIL = "查询失败";	
	public static String MSG_SUCCESS_INSERT = "添加成功";
	public static String MSG_FAIL_INSERT = "添加失败";
	public static String MSG_SUCCESS_DELETE = "删除成功";
	public static String MSG_FAIL_DELETE = "删除失败";
	public static String MSG_SUCCESS_UPDATE = "更新成功";
	public static String MSG_FAIL_UPDATE = "更新失败";
	public static String MSG_EXIST_RECORD = "数据库中存在相似的一条记录:相同的秘钥名称和秘钥标识";
	
	public static String MSG_EXIST_SECRET_NAME = "数据库中存在相同的秘钥名称";
	
	public static String MSG_EXIST_SECRET_LOGID = "数据库中存在相同的秘钥标识";
	
	public static String MSG_KECRET_NAME_ERROR = "秘钥文件名称有误";
	
	
	public static String MSG_SYS_CONFIG_ERROR = "配置表已经存在，不允许插入";
	
}
