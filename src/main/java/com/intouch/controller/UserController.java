package com.intouch.controller;

import com.intouch.domain.User;
import com.intouch.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
    //定义依赖属性，实施自动装配（按类型）
    @Autowired
    private UserService service;
    //显示表单
    @GetMapping("/form")
    public String  LoginForm(Model model){
        User user=new User();
        model.addAttribute("user",user);
        return "LoginForm";
    }
    @PostMapping("/login")
    public  String handleLogin (@ModelAttribute("user")User user, BindingResult bindingResult,
                                HttpServletRequest request,Model model){
        //如果表单提交数据不规范
        if (bindingResult.hasErrors()){
            return "LoginForm";
        }
        //如果表单数据规范，则进行登录处理
        User validUser=service.login(user.getEmail());
        //登录业务逻辑的判断
        if (validUser==null||(!user.getPassword().equals(validUser.getPassword()))){
            //设置错误信息
            model.addAttribute("erroMessage","用户名或密码错误");
            return "LoginForm";
        }
        //针对有效用户
        validUser.setLastLoginTime(System.currentTimeMillis());//记录用户登录的最新时间
        validUser.setLastLoginIp(request.getRemoteAddr());//记录用户的ip地址
        //将用户的最新信息同步到数据库中去
        service.modifyInfo(validUser);
        //需要将登录的用户存入到session域中
        HttpSession session=request.getSession();
        session.setAttribute("validUser",validUser);
        return "UserInfo";
    }
}

