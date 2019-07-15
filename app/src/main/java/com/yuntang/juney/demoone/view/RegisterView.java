package com.yuntang.juney.demoone.view;

import com.yuntang.juney.demoone.bean.User;

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

    void showSuccessMsg(User user);     //显示注册成功信息
    void showFailMsg(String feedback);      //显示注册失败信息






}
