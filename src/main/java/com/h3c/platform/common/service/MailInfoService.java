package com.h3c.platform.common.service;

import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.h3c.platform.common.entity.MailInfo;

public interface MailInfoService {
    void create(MailInfo mailInfo);

    /**
     * 发送邮件并记录
     * @param sendTo 发送人
     * @param ccTo	抄送人
     * @param subject 
     * @param content
     */
    void sendMailAndRecord(String mailTemp,String sendTo, String ccTo, JSONObject content,  JSONArray templeteArr, JSONArray titleArr );

    /**
     * 发送邮件并记录	无抄送人
     * @param sendTo    发送目标人
     * @param subject   主题
     * @param content    
     */
    void sendMailAndRecord(String mailTemp,String sendTo,  JSONObject content,  JSONArray templeteArr, JSONArray titleArr );

    void sendMail(String mailTemp,List<String> sendTo, List<String> ccTo,  JSONObject content,  JSONArray templeteArr, JSONArray titleArr);

//    void sendMail(String sendTo, String ccTo, String subject, String content);
    
    /**
     * 发送提醒邮件
     * @param sendTo
     * @param ccTo
     * @param subject 邮件主题
     * @param process 流程环节名称
     * @param url 流程链接  ,为空不加超链接 
     */
    void sendRemindMail(String sendTo, String ccTo,  String process,String url);
    
    /**
     * 发送流程结束提醒邮件
     * @param sendTo
     * @param ccTo
     * @param subject 邮件主题
     * @param process 流程环节名称
     * @param url 流程链接  ,为空不加超链接 
     */
    void sendProcessEndMail(String sendTo, String ccTo, String url);
    
    /**
     * 发送提醒邮件
     * @param sendTo
     * @param ccTo
     * @param subject 邮件主题
     * @param process 流程环节名称
     * @param url 流程链接  ,为空不加超链接 
     */
    void sendRemindMailWithEndTime(String sendTo, String ccTo, String process, Date endDate, boolean isAbnormalPlan, String url);
    
    
    void sendMailByTemplete(String templeteCode, List<String> bccTo, List<String> ccTo, List<String> sendTo, JSONObject content,  int priority, JSONArray templeteArr, JSONArray titleArr);
}
