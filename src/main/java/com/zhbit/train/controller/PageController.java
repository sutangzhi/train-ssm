package com.zhbit.train.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.zhbit.train.service.TrainService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
public class PageController {

    @Resource
    TrainService trainService;

    @RequestMapping("/")
    public String hello(HttpSession session, Model model){
        String imgName = trainService.getImgName();
        model.addAttribute("imgName",imgName);
        session.setAttribute("imgName",imgName);
        return "hello";
    }
}
