package com.yuntang.juney.demoone.model;

/**
 * Created by admini
 * on 2019/8/1
 */
public interface IFriendModel {    //好友系统模型接口

    void doFind(String json, onFindListener onFindListener);

    interface onFindListener {

        void findSuccess();    //成功获取
        void findFail();     //获取失败
    }

}
