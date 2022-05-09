package com.zhbit.train;

import com.zhbit.train.pojo.Admin;
import com.zhbit.train.pojo.Train;
import com.zhbit.train.service.AdminService;
import com.zhbit.train.service.TrainService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestService {

    @Autowired
    TrainService trainService;

    @Autowired
    AdminService adminService;

    @Test
    public void testTrain(){
        trainService.deleteTrain("t007");
    }

    @Test
    public void testAdmin(){
        Admin adminByAcc = adminService.getAdminByAcc("123");
        System.out.println(adminByAcc);
    }
}
