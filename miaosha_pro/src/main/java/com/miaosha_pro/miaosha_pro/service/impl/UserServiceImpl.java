package com.miaosha_pro.miaosha_pro.service.impl;

import com.miaosha_pro.miaosha_pro.dao.UserDOMapper;
import com.miaosha_pro.miaosha_pro.dao.UserPasswordDOMapper;
import com.miaosha_pro.miaosha_pro.dataobject.UserDO;
import com.miaosha_pro.miaosha_pro.dataobject.UserPasswordDO;
import com.miaosha_pro.miaosha_pro.service.UserService;
import com.miaosha_pro.miaosha_pro.service.model.UserModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDOMapper userDOMapper;

    @Autowired
    private UserPasswordDOMapper userPasswordDOMapper;

    //调用uerdomapper获取到对应的用户dataobject
    @Override
    public UserModel getUserById(Integer id) {
        /*得到一个userdo对象，里面有user的所有信息*/
        UserDO userDO = userDOMapper.selectByPrimaryKey(id);
        if(userDO==null){
            return null;
        }
        /*得到user的password那个对象*/
        /*通过用户id获取对应的用户加密密码信息*/
        UserPasswordDO userPasswordDO=userPasswordDOMapper.selectByUserId(userDO.getId());
        return convertFromDataObject(userDO,userPasswordDO);
    }

    private UserModel convertFromDataObject(UserDO userDO, UserPasswordDO userPasswordDO) {
        if (userDO == null) {
            return null;
        }
        UserModel userModel = new UserModel();
        /*复制userdo，即user_info里面的数据给Usermodel*/
        BeanUtils.copyProperties(userDO, userModel);
        if (userPasswordDO != null) {
            /*user_password里的不能直接复制，因为还有id重合的属性*/
            userModel.setEncrptPassWord(userPasswordDO.getEncrptPassword());
        }

        return userModel;
    }
}
