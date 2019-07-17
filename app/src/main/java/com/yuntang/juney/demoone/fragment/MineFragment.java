package com.yuntang.juney.demoone.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.yuntang.juney.demoone.R;

/**
 * Created by admini
 * on 2019/7/17
 */
public class MineFragment extends Fragment {    //我的碎片

    private ListView listView;      //列表
    private String[] info;       //列表项


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.minefragment, container, false);
        return  view;
    }

    @Override
    public void onStart() {

        super.onStart();
    }

    public void initViews() {     //初始化组件

        listView = (ListView) getView().findViewById(R.id.listView);
    }

    public void initDatas() {     //初始化数据

        info = new String[]{

        };
    }

}
