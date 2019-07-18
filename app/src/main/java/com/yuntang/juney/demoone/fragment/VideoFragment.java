package com.yuntang.juney.demoone.fragment;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ToggleButton;
import android.widget.VideoView;

import com.yuntang.juney.demoone.R;

/**
 * Created by admini
 * on 2019/7/17
 */
public class VideoFragment extends Fragment implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {     //视频碎片

    private VideoView videoView;
    private Button stop;
    private ToggleButton turn;
    private Button share;




    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.videofragment, container, false);
        return  view;
    }


    @Override
    public void onStart() {

        super.onStart();
        initViews();

    }


    public void initViews() {
        videoView = (VideoView) getView().findViewById(R.id.videoView);
        stop = (Button) getView().findViewById(R.id.stop);
        turn = (ToggleButton) getView().findViewById(R.id.turn);
        share = (Button) getView().findViewById(R.id.share);

        stop.setOnClickListener(this);
        share.setOnClickListener(this);

        turn.setOnCheckedChangeListener(this);

    }

    public void initData() {

        videoView.setVideoURI(Uri.parse("http://116.62.23.56/slaver_demo2/video/sj.mp4"));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.stop:
                break;
            case R.id.share:
                break;
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

        if (b) {
            System.out.println("播放");
        } else {
            System.out.println("暂停");
        }
    }
}
