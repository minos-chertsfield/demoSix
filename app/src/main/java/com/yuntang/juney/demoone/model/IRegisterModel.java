package com.yuntang.juney.demoone.model;

import com.yuntang.juney.demoone.bean.User;

/**
 * Created by admini
 * on 2019/7/12
 */
public interface IRegisterModel {    //注册模型接口

    /**
     *
     * @param user 用户对象
     * @param onRegisterListener 注册监听器
     */
    void doRegister(User user, onRegisterListener onRegisterListener);

    interface onRegisterListener {      //监听注册反馈

        void regiterSuccess(String feedback);     //注册成功
        void registerFail(String feedback);       //注册失败
    }

}
