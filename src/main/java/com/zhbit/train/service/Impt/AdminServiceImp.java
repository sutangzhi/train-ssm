package com.zhbit.train.service.Impt;

import com.zhbit.train.dao.AdminDao;
import com.zhbit.train.pojo.Admin;
import com.zhbit.train.service.AdminService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class AdminServiceImp implements AdminService {

    @Resource
    AdminDao adminDao;

    @Override
    public String doLogin(String account, String password) {
        Admin admin = adminDao.getAdminByAccAndPwd(account, password);
        if (admin==null){
            return "用户名或密码错误!";
        }
        return null;
    }

    @Override
    public Admin getAdminByAcc(String account) {
        return adminDao.getAdminByAcc(account);
    }
}
