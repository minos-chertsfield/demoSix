package com.yuntang.juney.demoone.bean;

/**
 * Created by admini
 * on 2019/7/12
 */
public class MusicInfo {    //音乐信息类

    private String title;     //音乐名
    private String artist;    //艺术家
    private String url;     //音乐文件的地址
    private long size;    //音乐文件大小
    private long duration;    //音乐时长
    private long id;     //音乐文件的唯一标识符
    private String album;    //音乐专辑

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }
}
