package com.yuntang.juney.demoone.presenter;

import android.os.Handler;

import com.yuntang.juney.demoone.bean.User;
import com.yuntang.juney.demoone.model.RegisterModel;
import com.yuntang.juney.demoone.view.RegisterView;



/**
 * Created by admini
 * on 2019/7/12
 */
public class RegisterPresenter {     //注册提供器

    private User user;
    private Handler handler;
    private RegisterView registerView;    //注册视图类对象
    private RegisterModel registerModel;    //注册模型实现类对象

    /**
     *
     * @param registerView 注册视图
     */
    public RegisterPresenter(RegisterView registerView) {     //构造方法
        this.registerView = registerView;
        handler = new Handler();
        registerModel = new RegisterModel();    //实例化注册模型实现类
    }

    public void doRegister() {    //注册
        user = new User();

        registerModel.doRegister(user, new RegisterModel.onRegisterListener() {
            @Override
            public void regiterSuccess(String feedback) {   //注册成功
            handler.post(new Runnable() {
                @Override
                public void run() {

                }
            });
            }

            @Override
            public void registerFail(String feedback) {    //注册失败
            handler.post(new Runnable() {
                @Override
                public void run() {

                }
            });
            }
        });
    }
}
