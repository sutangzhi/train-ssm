package com.zhbit.train.dao;

import com.zhbit.train.pojo.Admin;
import org.apache.ibatis.annotations.Param;

public interface AdminDao {

//    通过用户名密码获得管理员
    Admin getAdminByAccAndPwd(@Param("account") String account,@Param("password") String password);

//    通过用户名获取管理员
    Admin getAdminByAcc(@Param("account") String account);
}
