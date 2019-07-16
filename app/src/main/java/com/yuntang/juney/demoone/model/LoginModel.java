package com.yuntang.juney.demoone.model;

import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.yuntang.juney.demoone.bean.User;
import com.yuntang.juney.demoone.utils.LoginApiService;
import com.yuntang.juney.demoone.utils.RegisterApiService;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by admini
 * on 2019/7/12
 */
public class LoginModel implements ILoginModel{     //登录模型接口实现类

    SharedPreferences preferences = null;   //本地存储先置空
    public static String BASE_URL = "http://192.168.180.247:8080/";    //服务器地址
    Retrofit retrofit;
    private String feedback;    //获取服务器的反馈

    @Override
    public void doLogin(final User user, final onLoginListener onLoginListener) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                final Gson gson = new Gson();
                String obj = gson.toJson(user);     //转换成Json格式
                System.out.println(obj);
                retrofit = new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), obj);   //统一编码
                LoginApiService loginApiService = retrofit.create(LoginApiService.class);    //调用登录的请求api
                Call<ResponseBody> data = loginApiService.getMessage(body);
                data.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        try {
                            feedback = response.body().string();
                            if (feedback != "fail") {
                                User user = gson.fromJson(feedback, User.class);    //获取用户的信息
                                onLoginListener.loginSuccess();
                            } else {
                                onLoginListener.loginFail();
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable throwable) {
                        System.out.println("连接失败！");
                    }
                });
            }
        }).start();
    }



}
