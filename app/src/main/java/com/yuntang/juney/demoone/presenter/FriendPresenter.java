package com.yuntang.juney.demoone.presenter;

import android.os.Handler;

import com.yuntang.juney.demoone.bean.Friend;
import com.yuntang.juney.demoone.bean.User;
import com.yuntang.juney.demoone.model.FriendModel;
import com.yuntang.juney.demoone.model.IFriendModel;
import com.yuntang.juney.demoone.view.FriendView;

import java.util.List;

/**
 * Created by admini
 * on 2019/8/1
 */
public class FriendPresenter {    //好友相关业务逻辑

    String json;    //当前用户的好友列表数据
    private Handler handler;
    private FriendModel friendModel;
    private FriendView friendView;

    public FriendPresenter(FriendView friendView) {

        this.friendView = friendView;
        this.handler = new Handler();
        this.friendModel = new FriendModel();
    }

    public void doFind() {        //显示好友

        json = friendView.getMac();

        friendModel.doFind(json, new IFriendModel.onFindListener() {

            @Override
            public void findSuccess() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        friendView.showSuccessMsg();
                    }
                });
            }

            @Override
            public void findFail() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        friendView.showFailMsg();
                    }
                });
            }
        });
    }

}
