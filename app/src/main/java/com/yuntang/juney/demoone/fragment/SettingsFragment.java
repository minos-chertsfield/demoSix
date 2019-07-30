package com.yuntang.juney.demoone.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.yuntang.juney.demoone.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SettingsFragment extends Fragment implements AdapterView.OnItemClickListener {

    private String[] setting_items;    //设置项目
    private ListView listSettings;  //设置列表
    ArrayAdapter<String> adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_settings, container, false);
    }


    @Override
    public void onStart() {
        super.onStart();
        initViews();

    }


    public void initViews() {   //初始化组件

        setting_items = new String[]{    //设置项目列表项
                "个人设置",
                "清除缓存",
                "检查更新",
                "注销账户",
                "意见反馈",
                "关于我们"
        };   //用户的设置列表
        listSettings = (ListView) getView().findViewById(R.id.listSettings);
        adapter = new ArrayAdapter<String>(getContext(), R.layout.listview_layout, setting_items);
        listSettings.setAdapter(adapter);    //设置适配器
        listSettings.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

        switch (position) {

            case 0:
                //TODO 个人设置
                break;
            case 1:
                //TODO 清除缓存
                break;
            case 2:
                //TODO 检查更新
                break;
            case 3:
                //TODO 注销用户
                break;
            case 4:
                //TODO 意见反馈
                break;
            case 5:
                //TODO 关于我们
                break;
        }
    }
}




