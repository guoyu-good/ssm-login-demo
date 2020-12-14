package com.intouch.dao;

import com.intouch.domain.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    //增加
    int insert(User record);
    int insertSelective(User record);
    //删除
    int deleteByPrimaryKey(Integer id);
    //修改
    int updateByPrimaryKeySelective(User record);
    int updateByPrimaryKey(User record);

    //按照主键字段进行查询
    User selectByPrimaryKey(Integer id);

    //登录的dao方法
    User selectByEmilField(String email);
}