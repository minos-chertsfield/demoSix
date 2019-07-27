package com.yuntang.juney.demoone.service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;


import com.yuntang.juney.demoone.R;

import java.io.IOException;

public class MusicService extends Service {      //音乐播放服务

    String url;
    private NotificationManager notificationManager;
//    String path = "http://116.62.23.56/slaver_demo2/music/a.mp3";


    public MediaPlayer player = new MediaPlayer();      //实例化媒体播放器

    @Override
    public void onCreate() {
        super.onCreate();
        notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

    }

    public MusicService() {

    }

    @Override
    public IBinder onBind(Intent intent) {     //绑定事件

        MusicBinder binder = new MusicBinder();
        url = intent.getStringExtra("url");
        System.out.println("url:" + url);
        initData(url);
        return binder;
    }


    private Notification getNotification() {    //通知

        Notification.Builder builder = new Notification.Builder(this)
                .setSmallIcon(R.drawable.default_head)
                .setContentTitle("音乐播放器")
                .setContentText("正在运行……");

        Notification notification = builder.build();
        return notification;
    }


    public class MusicBinder extends Binder {    //服务绑定


        public void playMusic() {      //播放音乐
            player.start();
            startForeground(1, getNotification());     //发出通知
        }

        public void pauseMusic() {      //暂停音乐
            player.pause();
            stopForeground(true);        //清除通知
        }

        public void previousMusic() {     //上一首音乐
            //TODO
        }

        public void nextMusic() {      //下一首音乐
            //TODO
        }

        public void closeMedia() {       //关闭并释放资源
            if (player != null) {
                player.stop();
                player.release();
            }
        }


        public int getProgress() {        //获取当前进度
            return player.getDuration();
        }

        public int getPlayPosition() {      //获取当前播放位置
            return player.getCurrentPosition();
        }

        public void seekProgress(int sec) {       //跟踪当前播放位置
           player.seekTo(sec);
        }



    }


    private void initData(String url) {      //初始化数据
        try {
            player.setDataSource(url);     //设置数据源
            player.prepare();
        } catch (IOException e) {
            System.out.println("未找到资源!");
            e.printStackTrace();
        }
    }


}
