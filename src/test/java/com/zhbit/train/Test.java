package com.zhbit.train;


import com.zhbit.train.dao.TrainDao;
import com.zhbit.train.dao.UserDao;
import com.zhbit.train.pojo.Train;
import com.zhbit.train.pojo.User;


import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class Test {

    @Autowired
    private UserDao userDao;
    @Autowired
    private TrainDao trainDao;

    @org.junit.Test
    public void testDemo(){
        User user = new User(0,"010","123456",23,"男","17876683231","成人","王五");
        userDao.updateUser(user);
        System.out.println(user);
    }

    @org.junit.Test
    public void testTrain(){


    }
}
