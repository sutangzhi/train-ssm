package com.zhbit.train.service;

import com.zhbit.train.dao.AdminDao;
import com.zhbit.train.pojo.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

public interface AdminService {

//    登陆
    String doLogin(String account,String password);

//    获取管理员
    Admin getAdminByAcc(String account);
}
