package com.yuntang.juney.demoone.presenter;

import android.os.Handler;
import com.yuntang.juney.demoone.model.IVideoModel;
import com.yuntang.juney.demoone.model.VideoModel;
import com.yuntang.juney.demoone.view.VideoView;

/**
 * Created by admini
 * on 2019/8/1
 */
public class VideoPresenter {    //视频加载逻辑

    private Handler handler;
    private VideoModel videoModel;
    private VideoView videoView;

    public VideoPresenter(VideoView videoView) {

        this.videoView = videoView;
        this.handler = new Handler();
        this.videoModel = new VideoModel();
    }

    public void doLoad() {

        videoModel.doLoad(new IVideoModel.onLoadListener() {

            @Override
            public void loadSuccess(final String feedback) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        videoView.onSuccess(feedback);
                    }
                });
            }

            @Override
            public void loadFail() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        videoView.onFail();
                    }
                });
            }
        });
    }
}
