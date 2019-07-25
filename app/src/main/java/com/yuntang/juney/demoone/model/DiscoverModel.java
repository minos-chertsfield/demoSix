package com.yuntang.juney.demoone.model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yuntang.juney.demoone.bean.MusicInfo;
import com.yuntang.juney.demoone.utils.DiscoverApiService;
import com.yuntang.juney.demoone.utils.LoginApiService;
import com.yuntang.juney.demoone.utils.MusicApi;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
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
 * on 2019/7/23
 */
public class DiscoverModel implements IDiscoverModel {


    public static String BASE_URL = "http://192.168.180.120:8080/";    //服务器地址
    Retrofit retrofit;
    private String feedback;    //获取服务器的反馈

    @Override
    public void doDiscover(final onDiscoverListener onDiscoverListener) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                retrofit = new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), "discover");
                DiscoverApiService service = retrofit.create(DiscoverApiService.class);    //调用登录的请求api
                Call<ResponseBody> data = service.getMessage(body);
                data.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        try {
                            feedback = response.body().string();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
//                        System.out.println("发现响应：" + feedback);
//                        Type type = new TypeToken<List<MusicInfo>>(){}.getType();
//                        List<MusicInfo> list = new ArrayList<MusicInfo>();
//                        list = new Gson().fromJson(feedback,type);
//                        System.out.println("list:" + list.getClass());
                        if (feedback != null) {
                            onDiscoverListener.discoverSuccess(feedback);
                        } else {
                            onDiscoverListener.discoverFail();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable throwable) {

                    }
                });
            }
        }).start();
    }
}

