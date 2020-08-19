package com.h3c.platform.assetplan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.h3c.platform.assetplan.dao.RateTotalInfoMapper;
import com.h3c.platform.assetplan.entity.RateTotalInfo;
import com.h3c.platform.assetplan.service.RateTotalInfoService;

@Service
public class RateTotalInfoServiceImpl implements RateTotalInfoService{

	@Autowired
	private RateTotalInfoMapper rateTotalInfoMapper;
	
	@Override
	@Transactional
	public int insertBatch(List<RateTotalInfo> lst) {
		int count = lst.size();
		int groupSize = 1000;
		int groupNo = count / groupSize;
		if (lst.size() <= groupSize) {
			rateTotalInfoMapper.insertBatch(lst);
		} else {
			List<RateTotalInfo> subList=null;
			for (int i = 0; i < groupNo; i++) {
				subList = lst.subList(0, groupSize);
				rateTotalInfoMapper.insertBatch(subList);
				lst.subList(0, groupSize).clear();
			}
			if (lst.size() > 0) {
				rateTotalInfoMapper.insertBatch(lst);
			}
		}
		return count;
	}
	
	@Override
	@Transactional
	public int deleteById(List<Integer> lst) {
		return rateTotalInfoMapper.deleteById(lst);
	}
	
	@Override
	public RateTotalInfo getRateTotalInfoById(Integer id) {
		return rateTotalInfoMapper.selectByPrimaryKey(id);
	}
}
