package com.h3c.platform.assetplan.service.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.h3c.platform.assetplan.dao.ProcessRecordInfoMapper;
import com.h3c.platform.assetplan.entity.AssetPlanInfo;
import com.h3c.platform.assetplan.entity.ProcessRecordInfo;
import com.h3c.platform.assetplan.service.ProcessRecordInfoService;

@Service
public class ProcessRecordInfoServiceImpl implements ProcessRecordInfoService {

	@Autowired
	private ProcessRecordInfoMapper  processRecordInfoMapper;
	
	@Override
	@Transactional
	public void saveRecord(List<ProcessRecordInfo> lst) throws Exception {	
		
		int count = lst.size();
		int groupSize = 500;
		int groupNo = count / groupSize;
		if (lst.size() <= groupSize) {
			processRecordInfoMapper.batchInsert(lst);
		} else {
			List<ProcessRecordInfo> subList=null;
			for (int i = 1; i <= groupNo; i++) {
				int begin =(i-1)*groupSize;
				int end= 0;
				if(i==groupNo) {
					end = lst.size()-1;
				}else {
					end=i*groupSize;
				}
				
				subList = lst.subList(begin, end);
				processRecordInfoMapper.batchInsert(subList);
			}
			//sub 不包含最后一条 单独处理  数据不够 groupSize
			if (CollectionUtils.isNotEmpty(lst)) {
				processRecordInfoMapper.insertSelective(lst.get(lst.size()-1));
			}
		}
	}
}
