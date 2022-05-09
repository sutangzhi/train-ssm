package com.zhbit.train.service.Impt;

import com.zhbit.train.dao.UserDao;
import com.zhbit.train.pojo.User;
import com.zhbit.train.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class UserServiceImp implements UserService {

    @Resource
    private UserDao userDao;

    public UserServiceImp() {

    }

    @Override
    public String doLogin(String account, String password) {
        User user = userDao.selectUserByAccount(account);
        if (user==null)
            return "该用户不存在";

        user = userDao.selectByActAndPwd(account,password);
        if (user==null)
            return "用户名密码不匹配";

        return null;
    }

    @Override
    public String doRego(User user) {
        User tmp = userDao.selectUserByAccount(user.getAccount());
        if (tmp!=null)
            return "该用户名已存在";

        tmp = userDao.selectUserByPhone(user.getPhone());
        if (tmp!=null)
            return "该手机号码已绑定";

        userDao.addUser(user);
        return null;
    }

    @Override
    public String doUpdateUserInfo(User newUser,User oldUser) {
        String newPhone = newUser.getPhone();
        String oldPhone = oldUser.getPhone();
        if (userDao.selectUserByPhone(newPhone)!=null&&!newPhone.equals(oldPhone))
//            该手机号码已被绑定
            return "该手机号码已被绑定";
        userDao.updateUser(newUser);
        return  null;
    }

    @Override
    public User getUserByAccount(String account) {
        return userDao.selectUserByAccount(account);
    }



}
