package com.miaosha_pro.miaosha_pro.service;

import com.miaosha_pro.miaosha_pro.service.model.UserModel;

public interface UserService {
    //通过用户id获取用户对象的方法
    UserModel getUserById(Integer id);
}
