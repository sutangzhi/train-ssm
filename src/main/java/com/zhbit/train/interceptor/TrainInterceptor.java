package com.zhbit.train.interceptor;

import com.zhbit.train.pojo.Train;
import com.zhbit.train.service.TrainService;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;


//当修改车次列表的操作时拦截
@Component
public class TrainInterceptor implements HandlerInterceptor {

    @Resource
    TrainService trainService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        Object admin = session.getAttribute("admin");
        if (admin==null){
            response.sendRedirect(request.getContextPath()+"/adminLogin");
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HttpSession session = request.getSession();
        ArrayList<Train> allTrainList = trainService.getAllTrainList();
        session.setAttribute("allTrain",allTrainList);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
