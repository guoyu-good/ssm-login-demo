package com.intouch.service;

import com.intouch.domain.User;

public interface UserService {
    //需求1 登录功能
    public User login(String email);

    //需求2 修改用户信息
    public void modifyInfo(User user);
}
