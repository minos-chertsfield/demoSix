package com.yuntang.juney.demoone.view;

/**
 * Created by admini
 * on 2019/8/1
 */
public interface FriendView {

    void searchFriend();   //查询好友
    void addFriend();    //添加好友

    String getMac();   //获取当前设备硬件地址

    void showSuccessMsg();    //显示成功的信息
    void showFailMsg();    //显示失败的信息
}
