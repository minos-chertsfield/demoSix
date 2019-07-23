package com.yuntang.juney.demoone.presenter;

import android.os.Handler;

import com.yuntang.juney.demoone.adapter.MusicAdapter;
import com.yuntang.juney.demoone.bean.MusicInfo;
import com.yuntang.juney.demoone.model.DiscoverModel;
import com.yuntang.juney.demoone.model.IDiscoverModel;
import com.yuntang.juney.demoone.view.DiscoverView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admini
 * on 2019/7/23
 */
public class DiscoverPresenter {


    private Handler handler;
    private DiscoverModel discoverModel;
    private DiscoverView discoverView;

    MusicInfo[] musicInfos;      //声明音乐的数组
    List<MusicInfo> musicInfoList = new ArrayList<MusicInfo>();     //音乐类型的集合类

    public DiscoverPresenter(DiscoverView discoverView) {
        this.discoverView = discoverView;
        handler = new Handler();
        discoverModel = new DiscoverModel();
    }


    public void doDiscover() {

        discoverModel.doDiscover(new IDiscoverModel.onDiscoverListener() {

            @Override
            public void discoverSuccess(final String feedback) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("成功");
                        discoverView.onSuccess(feedback);
//                        musicInfos = list.toArray(new MusicInfo[list.size()]);
//                        musicInfoList.clear();
//
//                        for (int i=0;i<list.size();i++) {
//                            int index = i;
//
//                            musicInfoList.add(musicInfos[index]);
//                            System.out.println("i:" + i + "," + "index:" + index );
//                        }
//                        System.out.println(musicInfoList.get(1).getTitle());
//                        System.out.println("大小1：" + musicInfoList.size());
                    }
                });
            }


            @Override
            public void discoverFail() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {

                    }
                });
            }
        });
        System.out.println("大小2：" + musicInfoList.size());
    }



}
