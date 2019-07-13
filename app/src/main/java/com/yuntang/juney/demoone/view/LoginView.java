package com.yuntang.juney.demoone.view;

import com.yuntang.juney.demoone.bean.User;

/**
 * Created by admini
 * on 2019/7/12
 */
public interface LoginView {   //登录功能接口

    String getUid();
    String getPassword();

    void showSuccessMsg(User user);
    void showFailMsg(String feedback);

}
