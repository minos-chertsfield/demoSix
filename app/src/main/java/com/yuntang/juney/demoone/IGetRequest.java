package com.yuntang.juney.demoone;

import com.yuntang.juney.demoone.bean.User;

import retrofit2.Call;

import retrofit2.http.POST;

/**
 * Created by admini
 * on 2019/7/11
 */
public interface IGetRequest {   //用于描述网络请求的接口

    @POST("/head")    //采用POST方式发送网络请求
    Call<User> getCall();    //接收请求数据的方法 Call返回User类




}
