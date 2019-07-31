package com.yuntang.juney.demoone.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.yuntang.juney.demoone.R;
import com.yuntang.juney.demoone.adapter.FriendAdapter;
import com.yuntang.juney.demoone.bean.Friend;

import java.util.List;

/**
 * 好友碎片
 */
public class FriendFragment extends Fragment implements View.OnClickListener, BaseQuickAdapter.OnItemChildClickListener, BaseQuickAdapter.OnItemClickListener {

    private ImageButton addFriend;
    private ListView listFriend;
    private List<Friend> friends;    //朋友信息集合




    public FriendFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_friend, container, false);
    }


    @Override
    public void onStart() {
        super.onStart();
        initViews();
    }

    public void initViews() {   //初始化组件

        addFriend = (ImageButton) getView().findViewById(R.id.addFriend);
        listFriend = (ListView) getView().findViewById(R.id.listFriend);

        FriendAdapter adapter = new FriendAdapter(R.layout.listview_layout, friends);
        adapter.setOnItemClickListener(this);
        adapter.setOnItemChildClickListener(this);        //子控件点击事件
        addFriend.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        //TODO 添加好友
    }

    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
        switch (position) {

        }
    }


    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {    //点击进入详情

    }
}
