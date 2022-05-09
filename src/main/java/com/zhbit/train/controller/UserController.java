package com.zhbit.train.controller;

import com.zhbit.train.pojo.User;
import com.zhbit.train.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("userLogin")
    public String userLogin(HttpSession session, Model model,String account,String password){
        String err = userService.doLogin(account, password);
        if (err!=null){
            model.addAttribute("errMsg",err);
            return "/UserPage/userLogin";
        }
        User user = userService.getUserByAccount(account);
        session.setAttribute("user",user);
        return "index";
    }

    @RequestMapping("/userRegister")
    public String userRegister(Model model,User user){
        System.out.println(user);
        String err = userService.doRego(user);
        if (err!=null){
            model.addAttribute("errMsg",err);
            return "/UserPage/userRegister";
        }
        return "forward:/user/userLogin";
    }

    @RequestMapping("/updateUserInfo")
    public String updateUserInfo(HttpSession session,Model model,User user){
        User oldUser = (User)  session.getAttribute("user");
        String err = userService.doUpdateUserInfo(user,oldUser);
        if (err!=null){
            model.addAttribute("errMsg",err);
            return "/UserPage/updateUser";
        }
        session.setAttribute("user",user);
        return "/UserPage/updateUser";
    }

    @RequestMapping("/userQuit")
    public String userQuit(HttpSession session){
        session.removeAttribute("admin");
        session.removeAttribute("user");
        session.invalidate();
        return "redirect:/";
    }


}
