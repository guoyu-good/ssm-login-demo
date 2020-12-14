package com.intouch.service;

import com.intouch.dao.UserMapper;
import com.intouch.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements  UserService {

    @Autowired
   private UserMapper mapper;
    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public User login(String email) {
        User user=mapper.selectByEmilField(email);
        return user;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void modifyInfo(User user) {
        //mapper.updateByPrimaryKey(user);
        mapper.updateByPrimaryKeySelective(user);

      /*  User user2=new User();
        user2.setId(3);
        user2.setEmail("wangda1@126.com");
        user2.setUserIntegeral(30000);
        mapper.updateByPrimaryKeySelective(user2);*/
    }

    public  void  method3(int id){

    }
}
