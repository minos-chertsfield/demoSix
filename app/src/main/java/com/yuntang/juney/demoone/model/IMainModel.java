package com.yuntang.juney.demoone.model;

import android.content.DialogInterface;

import com.yuntang.juney.demoone.bean.User;

/**
 * Created by admini
 * on 2019/7/15
 */
public interface IMainModel {

    void doShow(User user, OnShowListener onShowListener);

    interface OnShowListener {

        void showSuccess();
        void showFail();
    }
}
