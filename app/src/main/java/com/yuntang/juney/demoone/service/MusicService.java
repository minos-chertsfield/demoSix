package com.yuntang.juney.demoone.service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import java.io.IOException;

public class MusicService extends Service {      //音乐播放服务


    String path = "";
    private MusicBinder binder = new MusicBinder();
    public MediaPlayer player = new MediaPlayer();      //实例化媒体播放器

    public MusicService() {
        initDatas(path);
    }

    @Override
    public IBinder onBind(Intent intent) {     //绑定事件
        // TODO: Return the communication channel to the service.
        return binder;
    }


    private void initDatas(String url) {
        try {
            player.setDataSource(url);
        } catch (IOException e) {
            System.out.println("未找到资源!");
            e.printStackTrace();
        }
    }


}
