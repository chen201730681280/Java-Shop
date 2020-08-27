package com.miaosha_pro.miaosha_pro.controller;

import com.miaosha_pro.miaosha_pro.service.UserService;
import com.miaosha_pro.miaosha_pro.service.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Controller 用于标记一个类上，使用它标记的类就是一个SpringMVC controller对象
 * 分发处理器会扫描使用该注解的类的方法
 * 并检测该方法是否使用了RequestMapping注解
 *
 * @Controller 只是定义了一个控制器类，而使用@RequestMapping注解的方式才是处理请求的处理器
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/get")
    @ResponseBody
    public UserModel getUser(@RequestParam(name = "id")Integer id){
        //调用service服务器获取对应id的用户对象并返回给前端
        /*Q:为什么是调用接口，而不是userSeviceimpl,接口不是空吗*/
        UserModel userModel=userService.getUserById(id);
        return userModel;
    }
}
