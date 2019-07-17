package com.yuntang.juney.demoone.model;

import com.yuntang.juney.demoone.bean.User;

/**
 * Created by admini
 * on 2019/7/12
 */
public interface ILoginModel {     //登录模型接口

    void doLogin(User user, onLoginListener onLoginListener);

    interface onLoginListener {

        void loginSuccess(String feedback);        //登录成功
        void loginFail();          //登录失败
    }


}
