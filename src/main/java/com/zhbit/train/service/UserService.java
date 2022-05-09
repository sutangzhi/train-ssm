package com.zhbit.train.service;

import com.zhbit.train.pojo.User;


public interface UserService {

//    登陆
    String doLogin(String account, String password);

//    注册
    String doRego(User user);

//    修改用户信息
    String doUpdateUserInfo(User newUser,User oldUser);

//    获取当前用户
    User getUserByAccount(String account);



}
