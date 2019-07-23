package com.yuntang.juney.demoone.model;

import com.yuntang.juney.demoone.bean.MusicInfo;

import java.util.List;

/**
 * Created by admini
 * on 2019/7/23
 */
public interface IDiscoverModel {

    void doDiscover(onDiscoverListener onDiscoverListener);

    interface onDiscoverListener {

        void discoverSuccess(String json);        //发现成功
        void discoverFail();         //发现失败
    }

}
