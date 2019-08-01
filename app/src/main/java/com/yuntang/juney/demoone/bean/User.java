package com.yuntang.juney.demoone.bean;

import java.util.List;

/**
 * Created by admini
 * on 2019/7/12
 */
public class User {    //用户类

    private String mac;    //用户设备硬件地址
    private String uid;    //用户用户名
    private String realName;    //用户真实姓名
    private String password;    //用户密码
    private int grade;    //用户等级
    private String address;    //用户地址
    private String birth;    //用户生日
    private String email;    //用户电子邮箱
    private String headLink;    //用户头像链接
    private String mobile;      //用户手机号码
    private String friends;

    public String getFriends() {
        return friends;
    }

    public void setFriends(String friends) {
        this.friends = friends;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getMac() {
        return mac;
    }
    public void setMac(String mac) {
        this.mac = mac;
    }
    public String getUid() {
        return uid;
    }
    public void setUid(String uid) {
        this.uid = uid;
    }
    public String getRealName() {
        return realName;
    }
    public void setRealName(String realName) {
        this.realName = realName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public int getGrade() {
        return grade;
    }
    public void setGrade(int grade) {
        this.grade = grade;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getBirth() {
        return birth;
    }
    public void setBirth(String birth) {
        this.birth = birth;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getHeadLink() {
        return headLink;
    }
    public void setHeadLink(String headLink) {
        this.headLink = headLink;
    }
}
