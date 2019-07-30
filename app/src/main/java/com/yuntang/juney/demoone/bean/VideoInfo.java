package com.yuntang.juney.demoone.bean;

/**
 * Created by admini
 * on 2019/7/12
 */
public class VideoInfo {   //视频信息类

    private long id;    //唯一标识
    private long duration;   //视频时长
    private long size;    //视频文件大小
    private String url;   //视频文件的url
    private String artist;   //艺术家名称
    private String title;    //视频名称
    private int hot;    //视频热度
    private String time;   //视频上交时间
    private String preview;   //视频预览图

    public VideoInfo() {
    }

    public VideoInfo(long id, long duration, long size, String url, String artist, String title, int hot, String time, String preview) {
        this.id = id;
        this.duration = duration;
        this.size = size;
        this.url = url;
        this.artist = artist;
        this.title = title;
        this.hot = hot;
        this.time = time;
        this.preview = preview;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getHot() {
        return hot;
    }

    public void setHot(int hot) {
        this.hot = hot;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPreview() {
        return preview;
    }

    public void setPreview(String preview) {
        this.preview = preview;
    }
}
