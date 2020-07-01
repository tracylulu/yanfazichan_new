package com.h3c.platform.sync.dao;

import com.h3c.platform.sync.entity.UserInfo_EOS;
import com.h3c.platform.sync.entity.UserInfo_EOSExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface UserInfo_EOSMapper {
    long countByExample(UserInfo_EOSExample example);

    int deleteByExample(UserInfo_EOSExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserInfo_EOS record);

    int insertSelective(UserInfo_EOS record);

    List<UserInfo_EOS> selectByExample(UserInfo_EOSExample example);

    UserInfo_EOS selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserInfo_EOS record, @Param("example") UserInfo_EOSExample example);

    int updateByExample(@Param("record") UserInfo_EOS record, @Param("example") UserInfo_EOSExample example);

    int updateByPrimaryKeySelective(UserInfo_EOS record);

    int updateByPrimaryKey(UserInfo_EOS record);
    
    int insertUserInfoEos(List<Map> list);
    
   	int deleteUserInfoEos();
}