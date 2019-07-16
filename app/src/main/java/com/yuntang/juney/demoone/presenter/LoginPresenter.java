package com.yuntang.juney.demoone.presenter;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;

import com.yuntang.juney.demoone.bean.User;
import com.yuntang.juney.demoone.model.ILoginModel;
import com.yuntang.juney.demoone.model.LoginModel;
import com.yuntang.juney.demoone.view.LoginView;
import com.yuntang.juney.demoone.view.RegisterActivity;

import static android.content.Context.MODE_PRIVATE;

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
        user = new User();
        user.setUid(loginView.getUid());
        user.setPassword(loginView.getPassword());
        System.out.println(user.getUid());

        loginModel.doLogin(user, new ILoginModel.onLoginListener() {
            @Override
            public void loginSuccess() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        loginView.showSuccessMsg();
                    }
                });
            }

            @Override
            public void loginFail() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        loginView.showFailMsg();     //显示失败信息
                    }
                });
            }
        });
    }

}
