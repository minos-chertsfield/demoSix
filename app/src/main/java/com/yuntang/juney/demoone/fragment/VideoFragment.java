package com.yuntang.juney.demoone.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;
import android.widget.VideoView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yuntang.juney.demoone.R;
import com.yuntang.juney.demoone.adapter.MusicAdapter;
import com.yuntang.juney.demoone.adapter.VideoAdapter;
import com.yuntang.juney.demoone.bean.MusicInfo;
import com.yuntang.juney.demoone.bean.VideoInfo;
import com.yuntang.juney.demoone.presenter.VideoPresenter;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by admini
 * on 2019/7/17
 */
public class VideoFragment extends Fragment implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, com.yuntang.juney.demoone.view.VideoView {     //视频碎片

    private VideoView videoView;
    private Button stop;
    private ToggleButton turn;
    private Button share;
    private RecyclerView recyclerView;
    List<VideoInfo> list = new ArrayList<>();
    List<VideoInfo> videoInfoList;
    VideoPresenter videoPresenter;
    VideoInfo[] videoInfos;

    @Override
    public void onResume() {
        super.onResume();
        initData();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.videofragment, container, false);
        initViews();
        return  view;
    }


    @Override
    public void onStart() {

        super.onStart();


        videoPresenter.doLoad();
    }


    public void initViews() {

        videoPresenter = new VideoPresenter(this);
        videoView = (VideoView) getView().findViewById(R.id.videoView);
        stop = (Button) getView().findViewById(R.id.stop);
        turn = (ToggleButton) getView().findViewById(R.id.turn);
        share = (Button) getView().findViewById(R.id.share);

        GridLayoutManager layoutManager = new GridLayoutManager(getContext(),1);   //网格布局管理器，设置为两列并排
        recyclerView = (RecyclerView) getView().findViewById(R.id.videoList);
        recyclerView.setLayoutManager(layoutManager);
        VideoAdapter adapter = new VideoAdapter(R.layout.video_item, videoInfoList);      //为适配器填充数据
        recyclerView.setAdapter(adapter);        //为控件绑定适配器


        stop.setOnClickListener(this);
        share.setOnClickListener(this);

        turn.setOnCheckedChangeListener(this);

    }

    public void initData() {     //初始化诗数据


        videoView.setVideoURI(Uri.parse("http://116.62.23.56/video/sj.mp4"));
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.stop:

                break;
            case R.id.share:
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                // 比如发送文本形式的数据内容
                // 指定发送的内容
                sendIntent.putExtra(Intent.EXTRA_TEXT, "http://116.62.23.56/video/sj.mp4");
                // 指定发送内容的类型
                sendIntent.setType("text/plain");
                startActivity(Intent.createChooser(sendIntent, "分享至"));
                break;
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

        if (b) {
            videoView.start();
            System.out.println("播放");
        } else {
            videoView.pause();
            System.out.println("暂停");
        }
    }

    @Override
    public void onSuccess(String json) {

        Type type = new TypeToken<List<VideoInfo>>(){}.getType();
        list = new Gson().fromJson(json,type);
        videoInfoList = new ArrayList<>();
        videoInfos = list.toArray(new VideoInfo[list.size()]);
        videoInfoList.clear();

        for (int i=0;i<list.size();i++) {
            int index = i;

            videoInfoList.add(videoInfos[index]);
        }
        System.out.println(videoInfoList.get(0).getTitle());
//        videos = videoInfoList.toArray(new VideoInfo[videoInfoList.size()]);
//        videoInfoList.clear();
//        for (int i=0;i<50;i++) {
//            int index = i;
//
//            videoInfoList.add(videos[index]);
//        }
        System.out.println(videoInfoList.get(0).getArtist());
        Toast.makeText(getContext(), "加载成功！", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFail() {

        Toast.makeText(getContext(), "加载失败！", Toast.LENGTH_SHORT).show();
    }


}
