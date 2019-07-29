package com.yuntang.juney.demoone.view;

/**
 * Created by admini
 * on 2019/7/12
 */
public interface RegisterView {   //注册功能接口

    String getMac();
    String getUid();
    String getRealName();
    String getPassword();
    String getAddress();
    String getMobile();
    String getBirth();
    String getEmail();
    String getHeadLink();

    void showSuccessMsg();     //显示注册成功信息
    void showFailMsg();      //显示注册失败信息






}
