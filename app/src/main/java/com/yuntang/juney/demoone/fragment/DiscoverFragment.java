package com.yuntang.juney.demoone.fragment;

import android.content.Intent;
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

import com.yuntang.juney.demoone.R;
import com.yuntang.juney.demoone.adapter.MusicAdapter;
import com.yuntang.juney.demoone.bean.MusicInfo;
import com.yuntang.juney.demoone.view.PlayerMusicActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admini
 * on 2019/7/17
 */
public class DiscoverFragment extends Fragment implements MusicAdapter.OnItemClickListener {    //发现碎片

    private Button play;
    private MusicInfo[] musicInfos;      //声明音乐的数组
    private RecyclerView recyclerViewMusic;
    private List<MusicInfo> musicInfoList= new ArrayList<MusicInfo>();     //音乐类型的集合类
    private MusicAdapter adapter;   //声明适配器

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.discoverfragment, container, false);
        return  view;
    }

    @Override
    public void onStart() {

        super.onStart();
        play = (Button) getView().findViewById(R.id.play);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), PlayerMusicActivity.class);
                startActivity(intent);
            }
        });



        }

    public void initViews() {


        recyclerViewMusic = (RecyclerView) getView().findViewById(R.id.recycler_view_music);
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(),1);   //网格布局管理器，设置为两列并排
        recyclerViewMusic.setLayoutManager(layoutManager);
        adapter = new MusicAdapter(musicInfoList);
        adapter.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(View view, int position) {

    }
}
