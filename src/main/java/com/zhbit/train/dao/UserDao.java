package com.zhbit.train.dao;

import com.zhbit.train.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserDao {

    User selectUserByAccount(@Param("account") String account);

    User selectByActAndPwd(@Param("account") String account,@Param("password") String password);

    User selectUserByPhone(@Param("phone") String phone);

    int addUser (User user);

    int updateUser(User user);



}
