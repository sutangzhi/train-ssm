package com.zhbit.train.pojo;

public class Train {
    private int trId;
    private String trainNum;
    private String launchDate;
    private String launchTime;
    private String firstStation;
    private String finallyStation;
    private String arrivalTime;
    private String remainingTicket;
    private double price;

    public Train(){
        trId=0;
        trainNum="";
        launchDate="";
        launchTime="";
        firstStation="";
        finallyStation="";
        arrivalTime="";
        remainingTicket="";
        price=0;
    }

    public Train(int trId, String trainNum, String launchDate, String launchTime,
                 String firstStation, String finallyStation,
                 String arrivalTime, String remainingTicket, double price) {
        this.trId = trId;
        this.trainNum = trainNum;
        this.launchDate = launchDate;
        this.launchTime = launchTime;
        this.firstStation = firstStation;
        this.finallyStation = finallyStation;
        this.arrivalTime = arrivalTime;
        this.remainingTicket = remainingTicket;
        this.price = price;
    }

    public void output(){
        System.out.println("我是TrainBean44444");
    }

    public int getTrId() {
        return trId;
    }

    public void setTrId(int trId) {
        this.trId = trId;
    }

    public String getTrainNum() {
        return trainNum;
    }

    public void setTrainNum(String trainNum) {
        this.trainNum = trainNum;
    }

    public String getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(String launchDate) {
        this.launchDate = launchDate;
    }

    public String getLaunchTime() {
        return launchTime;
    }

    public void setLaunchTime(String launchTime) {
        this.launchTime = launchTime;
    }

    public String getFirstStation() {
        return firstStation;
    }

    public void setFirstStation(String firstStation) {
        this.firstStation = firstStation;
    }

    public String getFinallyStation() {
        return finallyStation;
    }

    public void setFinallyStation(String finallyStation) {
        this.finallyStation = finallyStation;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getRemainingTicket() {
        return remainingTicket;
    }

    public void setRemainingTicket(String remainingTicket) {
        this.remainingTicket = remainingTicket;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Train{" +
                "trId=" + trId +
                ", trainNum='" + trainNum + '\'' +
                ", launchDate='" + launchDate + '\'' +
                ", launchTime='" + launchTime + '\'' +
                ", firstStation='" + firstStation + '\'' +
                ", finallyStation='" + finallyStation + '\'' +
                ", arrivalTime='" + arrivalTime + '\'' +
                ", remainingTicket='" + remainingTicket + '\'' +
                ", price=" + price +
                '}';
    }
}
