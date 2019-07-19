package com.yuntang.juney.demoone.utils;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by admini
 * on 2019/7/19
 */
public interface MusicApi {     //音乐数据接口

    @Headers({"Content-Type: application/json", "Accept: application/json"})    //文件头
    @POST("Music/registerService")
    Observable<ResponseBody> getMessage(@Body RequestBody info);

}
