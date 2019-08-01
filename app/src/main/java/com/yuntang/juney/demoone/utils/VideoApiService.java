package com.yuntang.juney.demoone.utils;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by admini
 * on 2019/8/1
 */
public interface VideoApiService {   //视频服务接口

    @Headers({"Content-Type: application/json", "Accept: application/json"})    //文件头
    @POST("Music/videoService")
    Call<ResponseBody> getMessage(@Body RequestBody info);   //返回的请求体
}
