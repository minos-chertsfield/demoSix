package com.yuntang.juney.demoone.model;

import android.widget.Toast;

import com.google.gson.Gson;
import com.yuntang.juney.demoone.bean.User;
import com.yuntang.juney.demoone.utils.MusicApi;

import java.io.IOException;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by admini
 * on 2019/7/15
 */
public class MainModel implements IMainModel{

    public static String BASE_URL = "http://116.62.23.56/";    //服务器地址
    Retrofit retrofit;

    @Override
    public void doShow(final User user, OnShowListener onShowListener) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                user.setUid("o154672");
                user.setPassword("123321");
                final Gson gson = new Gson();
                String obj = gson.toJson(user);     //转换成Json格式
                System.out.println(obj);
                retrofit = new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                        .build();
                RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), obj);
                MusicApi api = retrofit.create(MusicApi.class);
                api.getMessage(body)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<ResponseBody>() {
                            @Override
                            public void onSubscribe(Disposable d) {

                            }

                            @Override
                            public void onNext(ResponseBody responseBody) {
                                try {
                                   System.out.println("Rxjava:" + responseBody.string());
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }

                            @Override
                            public void onError(Throwable e) {

                            }

                            @Override
                            public void onComplete() {

                            }
                        });
            }
        }).start();
    }
}
