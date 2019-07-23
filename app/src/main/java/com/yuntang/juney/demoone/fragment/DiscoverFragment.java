package com.yuntang.juney.demoone.fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yuntang.juney.demoone.R;
import com.yuntang.juney.demoone.adapter.MusicAdapter;
import com.yuntang.juney.demoone.bean.MusicInfo;
import com.yuntang.juney.demoone.presenter.DiscoverPresenter;
import com.yuntang.juney.demoone.view.DiscoverView;
import com.yuntang.juney.demoone.view.PlayerMusicActivity;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by admini 发现碎片
 * on 2019/7/17
 */
public class DiscoverFragment extends Fragment implements MusicAdapter.OnItemClickListener, View.OnClickListener, DiscoverView {    //发现碎片


    List<MusicInfo> list = new ArrayList<MusicInfo>();
    List<MusicInfo> musicInfoList;
    MusicInfo[] musicInfos;      //声明音乐的数组
    MusicAdapter adapter;

    SharedPreferences preferences = null;
    private Button play;
    private RecyclerView recyclerViewMusic;
    DiscoverPresenter discoverPresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.discoverfragment, container, false);
        return  view;
    }

    @Override
    public void onStart() {

        super.onStart();

        initViews();

        discoverPresenter.doDiscover();



        }

    public void initViews() {


        recyclerViewMusic = (RecyclerView) getView().findViewById(R.id.recycler_view_music);
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(),1);   //网格布局管理器，设置为两列并排
        recyclerViewMusic.setLayoutManager(layoutManager);
        discoverPresenter = new DiscoverPresenter(this);


        play = (Button) getView().findViewById(R.id.play);
        play.setOnClickListener(this);


    }

    @Override
    public void onItemClick(View view, int position) {
        String url = musicInfoList.get(position).getUrl();
        System.out.println(musicInfoList.get(position).getTitle());
        Intent intent = new Intent(getActivity(), PlayerMusicActivity.class);
        intent.putExtra("url", url);
        startActivity(intent);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(getActivity(), PlayerMusicActivity.class);
        startActivity(intent);
    }




    @Override
    public void onSuccess(String json) {
        Type type = new TypeToken<List<MusicInfo>>(){}.getType();
        list = new Gson().fromJson(json,type);
        musicInfoList = new ArrayList<MusicInfo>();     //音乐类型的集合类
        musicInfos = list.toArray(new MusicInfo[list.size()]);
        musicInfoList.clear();

        for (int i=0;i<list.size();i++) {
            int index = i;

            musicInfoList.add(musicInfos[index]);
        }
        adapter = new MusicAdapter(musicInfoList);
        list = musicInfoList;
        adapter.setOnItemClickListener(this);
        recyclerViewMusic.setAdapter(adapter);
    }
}
