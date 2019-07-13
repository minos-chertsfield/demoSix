package com.yuntang.juney.demoone.utils;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by admini
 * on 2019/7/13
 */
public interface RegisterApiService {   //注册服务接口

    @Headers({"Content-Type: application/json", "Accept: application/json"})    //文件头
    @POST("Music/registerService")
    Call<ResponseBody> getMessage(@Body RequestBody info);   //返回的请求体
}
