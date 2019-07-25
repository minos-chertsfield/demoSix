package com.yuntang.juney.demoone.base;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

/**
 * Created by admini
 * on 2019/7/25
 */
public class ApplicationMusic extends Application {       //进行相应的应用性能监视


    @Override
    public void onCreate() {
        super.onCreate();
        LeakCanary.install(this);
    }
}
