package com.h3c.platform.sync.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.h3c.platform.common.util.ObjToStrUtil;
import com.h3c.platform.sync.dao.ProjectInfo_EOSMapper;
import com.h3c.platform.sync.entity.ProjectInfo_EOS;
import com.h3c.platform.sync.entity.UserInfo_EOS;
import com.h3c.platform.sync.service.ProjectInfoEosService;

@Service
public class ProjectInfoEosServiceImpl implements  ProjectInfoEosService {

	@Autowired
	private  ProjectInfo_EOSMapper projectInfoEosMapper;
	
	@Override
	@Transactional
	public int syncProjectInfoEos(List<Map<String, Object>> lst) {
		projectInfoEosMapper.deleteProjectInfoEos();
		insertDeptEos(lst);
		return 1;
	}
	
	
	@Transactional
	private void insertDeptEos(List<Map<String, Object>> lst) {
		SimpleDateFormat sdf =   new SimpleDateFormat("yyyy-MM-dd"); 
		try {
			//List<Map> addList=new ArrayList<>();
			for(Map<String, Object> map :lst) {
				ProjectInfo_EOS pro = new ProjectInfo_EOS();
				pro.setTypeId(ObjToStrUtil.ReplaceNullValue(map.get("type_id")));
				pro.setTypeName(ObjToStrUtil.ReplaceNullValue(map.get("type_name")));
				pro.setProjectNo(ObjToStrUtil.ReplaceNullValue(map.get("project_no")));
				pro.setProjectName(ObjToStrUtil.ReplaceNullValue(map.get("project_name")));
				pro.setProjectCode(ObjToStrUtil.ReplaceNullValue(map.get("project_code")));				
//				pro.setReleaseNo(ObjToStrUtil.ReplaceNullValue(map.get("release_no")));
//				pro.setBuildNo(ObjToStrUtil.ReplaceNullValue(map.get("build_no")));
//				pro.setTelecomPercent(ObjToStrUtil.ReplaceNullValue(map.get("telecom_percent")));
//				pro.setNonTelecomPercent(ObjToStrUtil.ReplaceNullValue(map.get("non_telecom_percent")));
				if(StringUtils.isNotBlank(ObjToStrUtil.ReplaceNullValue(map.get("effective_date")))) {
					pro.setEffectiveDate(sdf.parse(map.get("effective_date").toString()));
				}
				if(StringUtils.isNotBlank(ObjToStrUtil.ReplaceNullValue(map.get("project_start_date")))) {
					pro.setProjectStartDate(sdf.parse(map.get("project_start_date").toString()));
				}			
//				pro.setAssignPointDesc(ObjToStrUtil.ReplaceNullValue(map.get("assign_point_desc")));
				pro.setStatus(ObjToStrUtil.ReplaceNullValue(map.get("status")));
				pro.setMark(ObjToStrUtil.ReplaceNullValue(map.get("mark")));
				if(StringUtils.isNotBlank(ObjToStrUtil.ReplaceNullValue(map.get("create_date")))) {
					pro.setCreateDate(sdf.parse(map.get("create_date").toString()));
				}
				if(StringUtils.isNotBlank(ObjToStrUtil.ReplaceNullValue(map.get("loaded_time")))) {
					pro.setLoadedTime(sdf.parse(map.get("loaded_time").toString()));
				}
				
				pro.setUpdateTime(new Date());
				projectInfoEosMapper.insertSelective(pro);
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}
