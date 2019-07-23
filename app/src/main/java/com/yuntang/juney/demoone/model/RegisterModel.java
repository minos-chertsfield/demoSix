package com.yuntang.juney.demoone.model;

import com.google.gson.Gson;
import com.yuntang.juney.demoone.bean.User;
import com.yuntang.juney.demoone.utils.RegisterApiService;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by admini
 * on 2019/7/12
 */
public class RegisterModel implements IRegisterModel{    //注册模型接口实现类

    public static String BASE_URL = "http://116.62.23.56/";    //服务器地址
    Retrofit retrofit;
    private String feedback;    //获取服务器的反馈

    @Override
    public void doRegister(final User user, final onRegisterListener onRegisterListener) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Gson gson = new Gson();
                String obj = gson.toJson(user);     //转换成Json格式
                System.out.println(obj);
                retrofit = new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), obj);   //统一编码
                RegisterApiService registerApiService = retrofit.create(RegisterApiService.class);    //调用注册的请求api
                Call<ResponseBody> data = registerApiService.getMessage(body);
                data.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        try {
                                feedback = response.body().string();
                                System.out.println("返回值：" + feedback + "\n响应码：" + response.code());    //输出服务器返回信息
                                if (feedback.equals("success")) {
                                    onRegisterListener.registerSuccess();
                                    System.out.println("成功");
                                } else if (feedback.equals("fail")) {
                                    onRegisterListener.registerFail();
                                    System.out.println("失败");
                                }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable throwable) {
                        System.out.println("请求失败！");
                    }
                });
            }
        }).start();
    }




}
