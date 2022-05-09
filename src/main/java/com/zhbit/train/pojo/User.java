package com.zhbit.train.pojo;

public class User {
    private int uid;
    private String account;
    private String password;
    private int age;
    private String sex;
    private String phone;
    private String userType;
    private String trueName;

    public User() {
        uid = 0;
        account = "";
        password = "";
        age = 0;
        sex = "";
        phone = "";
        userType = "";
        trueName = "";
    }

    public User(int uid, String account, String password, int age, String sex, String phone, String userType, String trueName) {
        this.uid = uid;
        this.account = account;
        this.password = password;
        this.age = age;
        this.sex = sex;
        this.phone = phone;
        this.userType = userType;
        this.trueName = trueName;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", phone='" + phone + '\'' +
                ", userType='" + userType + '\'' +
                ", trueName='" + trueName + '\'' +
                '}';
    }
}
