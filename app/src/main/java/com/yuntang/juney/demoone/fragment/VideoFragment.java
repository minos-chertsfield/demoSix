package com.yuntang.juney.demoone.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yuntang.juney.demoone.R;

/**
 * Created by admini
 * on 2019/7/17
 */
public class VideoFragment extends Fragment {     //视频碎片


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.videofragment, container, false);
        return  view;
    }
}
