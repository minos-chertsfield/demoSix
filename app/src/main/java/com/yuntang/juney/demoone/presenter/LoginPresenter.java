package com.yuntang.juney.demoone.presenter;

import android.os.Handler;

import com.yuntang.juney.demoone.bean.User;
import com.yuntang.juney.demoone.model.LoginModel;
import com.yuntang.juney.demoone.view.LoginView;

/**
 * Created by admini
 * on 2019/7/12
 */
public class LoginPresenter {   //登录提供器

    private User user;
    private Handler handler;
    private LoginModel loginModel;
    private LoginView loginView;

    /**
     *
     * @param loginView 登录视图
     */
    public LoginPresenter(LoginView loginView) {   //构造方法
        this.loginView = loginView;
        handler = new Handler();
        loginModel = new LoginModel();    //实例化登录模型接口实现类
    }

    public void doLogin() {    //登录

    }
}
