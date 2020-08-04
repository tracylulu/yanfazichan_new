package com.h3c.platform.assetplan.service;

import java.util.List;

import com.h3c.platform.api.ibpm.entity.IBPMEntity;
import com.h3c.platform.assetplan.entity.BPMRelationInfo;

public interface BPMRelationInfoService {
	
	List<BPMRelationInfo> getByIDList(List<String> lst)throws Exception;
	
	boolean writeBpmCode(IBPMEntity entity) throws Exception;
}
