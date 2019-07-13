package com.yuntang.juney.demoone.presenter;

import android.os.Handler;

import com.google.gson.Gson;
import com.yuntang.juney.demoone.bean.User;
import com.yuntang.juney.demoone.model.RegisterModel;
import com.yuntang.juney.demoone.utils.RegisterApiService;
import com.yuntang.juney.demoone.view.RegisterView;

import java.io.IOException;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


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
        user.setUid(registerView.getUid());   //从视图层获取用户名
        user.setPassword(registerView.getPassword());   //从视图层获取密码


        registerModel.doRegister(user, new RegisterModel.onRegisterListener() {
            @Override
            public void regiterSuccess(final String feedback) {   //注册成功
            handler.post(new Runnable() {
                @Override
                public void run() {     //注册成功后进行处理
                    registerView.showSuccessMsg(user);
                }
            });
            }

            @Override
            public void registerFail(final String feedback) {    //注册失败
            handler.post(new Runnable() {
                @Override
                public void run() {        //注册失败后进行处理
                    registerView.showFailMsg(feedback);
                }
            });
            }
        });
    }
}
