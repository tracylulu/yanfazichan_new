package com.h3c.platform.assetplan.service;

import java.util.List;

import com.h3c.platform.assetplan.entity.ProcessRecordInfo;

public interface ProcessRecordInfoService {

	void saveRecord(List<ProcessRecordInfo> lst)  throws Exception;
}
