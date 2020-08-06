package com.h3c.platform.assetplan.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.h3c.platform.api.ibpm.entity.IBPMEntity;
import com.h3c.platform.assetplan.dao.BPMRelationInfoMapper;
import com.h3c.platform.assetplan.entity.BPMRelationInfo;
import com.h3c.platform.assetplan.service.BPMRelationInfoService;

@Service
public class BPMRelationInfoServiceImpl implements BPMRelationInfoService {
	@Autowired
	private BPMRelationInfoMapper bmpRelationInfoMapper;
	@Override
	public List<BPMRelationInfo> getByIDList(List<Integer> lst) throws Exception{		
		
		return bmpRelationInfoMapper.getByIDList(lst);
	}
	
	@Override
	@Transactional
	public boolean writeBpmCode(IBPMEntity entity) throws Exception{
		
		for(String id:entity.getIamplanID().split(",")) {
			if(StringUtils.isBlank(id)) continue;
			
			BPMRelationInfo info=new BPMRelationInfo();
			info.setAsstplanid(Integer.parseInt(id));
			info.setBpmcode(entity.getBpmCode());
			info.setCreatetime(new Date());
			info.setCreator(entity.getUserCode());
			
			bmpRelationInfoMapper.deleteByPrimaryKey(Integer.parseInt(id));
			bmpRelationInfoMapper.insertSelective(info);
		}
		
		return true;
	}
}
