package com.zhbit.train.dao;

import com.zhbit.train.pojo.Train;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

public interface TrainDao {

//    查询车次列表
    ArrayList<Train> getAllTrainList();

//    根据编号查车次
    Train getTrainByNum(@Param("trainNum") String trainNum);

//    车次动态查询
    ArrayList<Train> stationQuery(@Param("firstStation") String firstStation,
                                  @Param("finallyStation") String finallyStation,
                                  @Param("dateValue") String dateValue);

//    添加车次
    void  addTrain(Train train);

//    更新车次
    void updateTrain(Train newTrain);

//    删除车次
    void deleteTrain(@Param("trainNum") String trainNum);

//    获取图片名
    String getImgName();

//    更换图片名
    void updateImgName(@Param("imgName") String imgName);

}
