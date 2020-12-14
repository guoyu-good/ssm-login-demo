package com.intouch.service;

import com.intouch.domain.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.print.DocFlavor;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class UserServiceTest {

    @Autowired
    private  UserService service;

    @Before
    public  void setup(){
        System.out.println(service.getClass().getName());
    }

    @Test
    public void login() {
        String email="wangda@126.com";
        User user=service.login(email);
        if (user==null){
            System.out.println("没有查到该用户");
        }else{
            System.out.println(user.getId()+" "+user.getEmail()+" "+user.getNickname()+""+user.getPassword()+" "+user.getUserIntegeral()+" "+user.getIsEmailVerify()+" "+user.getEmailVerifyCode()+" "+user.getLastLoginTime()+" "+user.getLastLoginIp());
        }
    }

    @Test
    public void modifyInfo() {
       /* User user=new User();
        user.setId(1);
        user.setUserIntegeral(10000);
        service.modifyInfo(user);*/

       String email="wangda1@126.com";
       User user=service.login(email);
       user.setUserIntegeral(1000);
//       try{//编程式事务
           service.modifyInfo(user);

//       }catch (Exception exe){

//       }finally {

 //      }


    }
}