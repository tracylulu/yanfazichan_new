package com.h3c.platform.common.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;

import com.h3c.platform.assetplan.dao.AssetPlanInfoMapper;
import com.h3c.platform.assetplan.entity.AssetPlanInfo;

public class MailSendToAndCcToUtils {
	@Autowired
	private AssetPlanInfoMapper assetPlanInfoMapper;
	
	//获取发送人id的list
    public List getsendToList(List<Integer> lstsubmitID,String apstage) {
    	List<String> sendTo=new ArrayList<>();
    	//规范审核人id的list
		List<String> newLstReviewerID =new ArrayList<>();
		
    	for (int i = 0; i < lstsubmitID.size(); i++) {
    		Integer assetplanid = lstsubmitID.get(i);
    		AssetPlanInfo ap = assetPlanInfoMapper.selectByPrimaryKey(assetplanid);
    		newLstReviewerID.add(ap.getReviewer());
    		List rdReviewerList = removeDuplicate(newLstReviewerID);
    		for (int j = 0; j < rdReviewerList.size(); j++) {
				sendTo.add(rdReviewerList.get(j).toString());
			}
    	}
		return sendTo;   
    } 
    
    //通过HashSet踢除重复元素
    public static List removeDuplicate(List list) {   
        HashSet h = new HashSet(list);   
        list.clear();   
        list.addAll(h);   
        return list;   
    } 

}
