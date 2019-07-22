package com.yuntang.juney.demoone.fragment;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.FrameMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.gson.Gson;
import com.yuntang.juney.demoone.R;
import com.yuntang.juney.demoone.adapter.MusicAdapter;
import com.yuntang.juney.demoone.bean.User;

/**
 * Created by admini
 * on 2019/7/17
 */
public class MineFragment extends Fragment implements AdapterView.OnItemClickListener {    //我的碎片

    private ListView listView;      //列表
    private String[] info;       //列表项

    FragmentTransaction ft;    //碎片事务


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.minefragment, container, false);
        return  view;
    }

    @Override
    public void onStart() {

        super.onStart();
        initViews();
    }

    public void initViews() {     //初始化组件
        initData();
        listView = (ListView) getView().findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.support_simple_spinner_dropdown_item, info);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    public void initData() {     //初始化数据
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("user", getActivity().MODE_PRIVATE);

        Gson gson = new Gson();
        User user = gson.fromJson(sharedPreferences.getString("User",""), User.class);
        info = new String[]{
            "用户名    " + user.getUid(),
            "手机号码    " + user.getMobile(),
            "电子邮箱    " + user.getEmail(),
            "出生日期    " + user.getBirth(),
            "",
            "本地音乐"  ,
            "我的收藏"
        };

    }



    @SuppressLint("ResourceType")
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {    //条目点击事件
        switch (position) {
            case 0:
                break;
            case 5:
                System.out.println("本地音乐");
                replaceFragment(new LocalFragment());
                break;
            case 6:
                System.out.println("我的收藏");
                replaceFragment(new FavoriteFragment());
                break;
        }

    }


    public void replaceFragment(Fragment fragment) {     //替换当前碎片
        ft = getChildFragmentManager().beginTransaction();     //开始事务
        ft.replace(R.id.mine, fragment);    //替换碎片
        ft.commit();    //事务提交
    }
}
