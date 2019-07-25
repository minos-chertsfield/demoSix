package com.yuntang.juney.demoone.fragment;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.gson.Gson;
import com.yuntang.juney.demoone.R;
import com.yuntang.juney.demoone.bean.MusicInfo;
import com.yuntang.juney.demoone.utils.FileManager;

import java.util.ArrayList;
import java.util.List;

/**
 * 本地音乐碎片
 */
public class LocalFragment extends Fragment {

    private static ContentResolver mContentResolver;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_local, container, false);
    }


    @Override
    public void onStart() {
        super.onStart();
        show();
    }


    public void show() {
        FileManager manager = new FileManager();
        List<MusicInfo> list = new ArrayList<>();
        list = manager.getMusics();
        System.out.println("本地音乐列表："  + new Gson().toJson(list));
        Toast.makeText(getContext(),"本地音乐列表："  + new Gson().toJson(list), Toast.LENGTH_SHORT ).show();
    }
}
