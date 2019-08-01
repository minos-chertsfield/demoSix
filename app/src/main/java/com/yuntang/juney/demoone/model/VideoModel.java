package com.yuntang.juney.demoone.model;

import com.yuntang.juney.demoone.utils.VideoApiService;

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
 * on 2019/8/1
 */
public class VideoModel implements IVideoModel {    //

    public static String BASE_URL = "http://192.168.180.120:8080/";    //服务器地址
    Retrofit retrofit;
    private String feedback;    //获取服务器的反馈

    @Override
    public void doLoad(final onLoadListener onLoadListener) {        //视频模型接口

        new Thread(new Runnable() {
            @Override
            public void run() {
                retrofit = new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), "video");
                VideoApiService service = retrofit.create(VideoApiService.class);    //调用登录的请求api
                Call<ResponseBody> data = service.getMessage(body);
                data.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        try {
                            feedback = response.body().string();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        if (feedback != null) {

                            onLoadListener.loadSuccess(feedback);
                        } else {

                            onLoadListener.loadFail();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {

                    }
                });
            }
        }).start();
    }
}
