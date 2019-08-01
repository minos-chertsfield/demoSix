package com.yuntang.juney.demoone.model;

/**
 * Created by admini
 * on 2019/8/1
 */
public interface IVideoModel {

    void doLoad(onLoadListener onLoadListener);

    interface onLoadListener {

        void loadSuccess(String feedback);    //加载成功
        void loadFail();    //加载失败
    }
}
