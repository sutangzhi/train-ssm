package com.zhbit.train.service.Impt;

import com.zhbit.train.dao.TrainDao;
import com.zhbit.train.pojo.Train;
import com.zhbit.train.service.TrainService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;

@Service
@Transactional
public class TrainServiceImp implements TrainService {

    @Resource
    TrainDao trainDao;

    @Override
    public ArrayList<Train> getAllTrainList() {
        ArrayList<Train> allTrainList = trainDao.getAllTrainList();
        return allTrainList;
    }

    @Override
    public ArrayList<Train> getQuertTrainList(String firstStation, String finallyStation, String dateValue) {
        ArrayList<Train> trains = trainDao.stationQuery(firstStation, finallyStation, dateValue);
        return trains;
    }

    @Override
    public Train getTrainByNum(String trainNum) {
        return trainDao.getTrainByNum(trainNum);
    }


    @Override
    public String addTrain(Train train) {
        Train tmp = trainDao.getTrainByNum(train.getTrainNum());
        if (tmp!=null)
            return "该车次已存在";
        trainDao.addTrain(train);
        return null;
    }

    @Override
    public void updateTrain(Train newTrain) {
        trainDao.updateTrain(newTrain);
    }

    @Override
    public void deleteTrain(String trainNum) {
        trainDao.deleteTrain(trainNum);
    }

    @Override
    public String getImgName() {
        return trainDao.getImgName();
    }

    @Override
    public void updateImgName(String imgName) {
        trainDao.updateImgName(imgName);
    }
}
