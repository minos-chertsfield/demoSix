package com.yuntang.juney.demoone.service;

import android.os.Binder;

/**
 * Created by admini
 * on 2019/7/17
 */
public class MusicBinder extends Binder {    //服务绑定

    MusicService service = new MusicService();

    public void playMusic() {      //播放音乐
        service.player.start();
    }

    public void pauseMusic() {      //暂停音乐
        service.player.pause();
    }

    public void previousMusic() {     //上一首音乐

    }

    public void nextMusic() {      //下一首音乐

    }

    public int getProgress() {
        return service.player.getDuration();
    }

    public int getPlayPosition() {
        return service.player.getCurrentPosition();
    }

    public void seekProgress(int sec) {
        service.player.seekTo(sec);
    }



}
