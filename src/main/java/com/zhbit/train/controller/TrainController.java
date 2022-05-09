package com.zhbit.train.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.zhbit.train.pojo.Train;
import com.zhbit.train.service.TrainService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

@Controller
@RequestMapping("/train")
public class TrainController {

    @Resource
    TrainService trainService;

//    显示所有车次列表
    @RequestMapping("/showTrain")
    public String showTrain(Model model, HttpSession session){
        ArrayList<Train> allTrain = (ArrayList<Train>) session.getAttribute("allTrain");
        if (allTrain!=null){
            model.addAttribute("trains",allTrain);
        }else{
            allTrain = trainService.getAllTrainList();
            session.setAttribute("allTrain",allTrain);
            model.addAttribute("trains",allTrain);
        }
        return "/TrainPage/showTrain";
    }

//    通过条件查询车次
    @RequestMapping("/stationQuery")
    public String stationQuery(Model model,String firstStation,String finallyStation,String dateValue){
        ArrayList<Train> trains = trainService.getQuertTrainList(firstStation, finallyStation, dateValue);
        model.addAttribute("trains",trains);
        return "/TrainPage/showTrain";
    }

//    管理员首页车次列表
    @RequestMapping("/mgfind")
    public String mgfind(HttpSession session,Model model){
        ArrayList<Train> trains = (ArrayList<Train>) session.getAttribute("allTrain");
        model.addAttribute("trains",trains);
        return "/TrainPage/mgfind";
    }

//    跳转指定车次详情页面
    @RequestMapping("/updateTrain")
    public String updateTrain(Model model,String trainNum){
        Train train = trainService.getTrainByNum(trainNum);
//        转换日期格式(因为datetime-local类型的输入框只能支持yyyy-MM-ddThh:mm:ss格式
        String date = train.getArrivalTime();
        train.setArrivalTime(date.replace(' ','T'));

        model.addAttribute("train",train);
        return "/TrainPage/updateTrain";
    }

//    更新车次信息
    @RequestMapping("/updateTrainInfo")
    public String updateTrainInfo(HttpSession session,Train train){
        trainService.updateTrain(train);
        return  "redirect:/train/mgfind";
    }

//    删除车次
    @RequestMapping("/deleteTrain")
    public String deleteTrain(HttpSession session,String trainNum){
        trainService.deleteTrain(trainNum);
        return "redirect:/train/mgfind";
    }

//    添加车次
    @RequestMapping("/addTrain")
    public String addTrain(HttpSession session,Model model,Train train){
        String err = trainService.addTrain(train);
        if (err!=null){
            model.addAttribute("errMsg",err);
            return "/TrainPage/addTrain";
        }
        return "redirect:/train/mgfind";
    }

//    更换首页图片
    @RequestMapping("/uploadImg")
    public String uploadImg(HttpSession session,MultipartFile indexImg) throws IOException {
        String oldFileName = indexImg.getOriginalFilename();
        ServletContext servletContext = session.getServletContext();
        String realPath = servletContext.getRealPath("/upload");
        File file = new File(realPath);
        if (!file.exists()){
            file.mkdir();
        }
        String newFileName = UUID.randomUUID() + oldFileName.substring(oldFileName.lastIndexOf('.'));
        indexImg.transferTo(new File(realPath+File.separator+newFileName));
        session.setAttribute("imgName",newFileName);
        trainService.updateImgName(newFileName);
        return "/TrainPage/uploadImg";
    }


}
