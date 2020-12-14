package com.intouch.dao;

import com.intouch.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class UserMapperTest {
    @Autowired
    private UserMapper mapper;
    @Test
    public void selectByEmilField() {
        String email="wangda@126.com";
        User user=mapper.selectByEmilField(email);
        if (user==null){
            System.out.println("没有查到该用户");
        }else{
            System.out.println(user.getId()+" "+user.getEmail()+" "+user.getNickname()+""+user.getPassword()+" "+user.getUserIntegeral()+" "+user.getIsEmailVerify()+" "+user.getEmailVerifyCode()+" "+user.getLastLoginTime()+" "+user.getLastLoginIp());
        }
    }
}