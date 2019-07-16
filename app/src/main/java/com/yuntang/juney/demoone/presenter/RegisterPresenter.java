package com.yuntang.juney.demoone.presenter;

import android.content.SharedPreferences;
import android.os.Handler;
import android.preference.PreferenceManager;

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
        user.setMac(registerView.getMac());     //从视图层获取硬件地址
        user.setUid(registerView.getUid());   //从视图层获取用户名
        user.setPassword(registerView.getPassword());   //从视图层获取密码
        user.setRealName(registerView.getRealName());   //从视图层获取真实姓名
        user.setBirth(registerView.getBirth());      //从视图层获取出生日期
        user.setEmail(registerView.getEmail());     //从视图层获取电子邮箱
        user.setMobile(registerView.getMobile());    //从视图层获取电话号码
        user.setAddress(registerView.getAddress());     //从视图层获取地址
        user.setHeadLink(registerView.getHeadLink());    //从视图层获取图像数据


        registerModel.doRegister(user, new RegisterModel.onRegisterListener() {
            @Override
            public void registerSuccess() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        registerView.showSuccessMsg();    //显示注册成功的信息
                    }
                });
            }

            @Override
            public void registerFail() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        registerView.showFailMsg();     //显示注册失败的信息
                    }
                });
            }
        });
    }
}
