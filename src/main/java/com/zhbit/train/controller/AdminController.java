package com.zhbit.train.controller;

import com.zhbit.train.pojo.Admin;
import com.zhbit.train.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    @RequestMapping("/adminLogin")
    public String adminLogin(HttpSession session, Model model,String account,String password){
        String err = adminService.doLogin(account, password);
        if (err!=null){
            model.addAttribute("errMsg",err);
            return "/AdminPage/adminLogin";
        }
        Admin admin = adminService.getAdminByAcc(account);
        session.setAttribute("admin",admin);
        return "/TrainPage/m_index";
    }
}
