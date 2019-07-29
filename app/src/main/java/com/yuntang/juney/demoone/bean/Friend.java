package com.yuntang.juney.demoone.bean;

/**
 * Created by admini
 * on 2019/7/29
 */
public class Friend {    //好友信息

    private String uid;   //用户名
    private String address;   //地址
    private String birthday;    //生日
    private String grade;    //等级
    private String email;   //电子邮箱
    private String mobilePhone;     //手机号码
    private String remark;  //备注

    public Friend() {
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
