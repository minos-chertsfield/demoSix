package com.yuntang.juney.demoone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.yuntang.juney.demoone.bean.User;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.FieldMap;

public class GetRequest extends AppCompatActivity {    //获取请求

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_request);
        request();     //调用请求
    }


    public void request() {

        //创建Retrofit对象
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://116.62.23.56")    //设置网络请求的Url
                .addConverterFactory(GsonConverterFactory.create())     //设置使用Gson的解析器（需要添加相应的依赖）
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())   //添加RxJava的支持
                .build();

        //创建网络接口的实例
        IGetRequest request = retrofit.create(IGetRequest.class);

        //对发送请求进行封装，调用接口方法返回User类
        Call<User> call = request.getCall();

        //发送网络请求（异步）
        call.enqueue(new Callback<User>() {

            //请求成功时回调
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                //处理返回的数据结果
                response.body().getRealName();    //获取到用户的姓名
                System.out.println("获取到的用户姓名为：" + response.body().getRealName());   //输出结果
            }


            //请求失败时回调
            @Override
            public void onFailure(Call<User> call, Throwable throwable) {
                System.out.println("请求连接失败！");
            }
        });

    }
}
