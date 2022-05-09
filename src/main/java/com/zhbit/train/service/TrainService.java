package com.zhbit.train.service;

import com.zhbit.train.pojo.Train;

import java.util.ArrayList;

public interface TrainService {

//    获取所有车次列表
    ArrayList<Train> getAllTrainList();

//    通过查询条件获得车次列表
    ArrayList<Train> getQuertTrainList(String firstStation,String finallyStation,String dateValue);

//    通过车次编号获取车次
    Train getTrainByNum(String trainNum);

//    添加车次
    String addTrain(Train train);

//    更新车次
    void updateTrain(Train newTrain);

//    删除车次
    void deleteTrain(String trainNum);

//    获得首页图片名称
    String getImgName();

//    更换图片名称
    void updateImgName(String imgName);
}
