package com.yuntang.juney.demoone.fragment;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.yuntang.juney.demoone.R;
import com.yuntang.juney.demoone.adapter.FriendAdapter;
import com.yuntang.juney.demoone.bean.Friend;
import com.yuntang.juney.demoone.bean.User;
import com.yuntang.juney.demoone.presenter.FriendPresenter;
import com.yuntang.juney.demoone.view.FriendView;

import java.util.List;

/**
 * 好友碎片
 */
public class FriendFragment extends Fragment implements View.OnClickListener, BaseQuickAdapter.OnItemChildClickListener, BaseQuickAdapter.OnItemClickListener, FriendView {

    private ImageButton addFriend;
    private ListView listFriend;
    private List<Friend> friends;    //朋友信息集合
    FriendPresenter friendPresenter;



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

    @Override
    public void onResume() {
        super.onResume();
        friendPresenter.doFind();
    }

    public void initViews() {   //初始化组件

        addFriend = (ImageButton) getView().findViewById(R.id.addFriend);
        listFriend = (ListView) getView().findViewById(R.id.listFriend);

        FriendAdapter adapter = new FriendAdapter(R.layout.listview_layout, friends);
        adapter.setOnItemClickListener(this);
        adapter.setOnItemChildClickListener(this);        //子控件点击事件
        addFriend.setOnClickListener(this);
        friendPresenter = new FriendPresenter(this);
    }

    @Override
    public void onClick(View view) {
        //TODO 添加好友
    }

    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {    //点击子控件
        switch (position) {

        }
    }


    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {    //点击条目进入详情

    }

    @Override
    public void searchFriend() {

    }

    @Override
    public void addFriend() {

    }

    @Override
    public String getMac() {    //返回当前用户设备用户硬件地址

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("user", getActivity().MODE_PRIVATE);
        Gson gson = new Gson();
        User user = gson.fromJson(sharedPreferences.getString("User",""), User.class);
        return user.getMac();
    }

    @Override
    public void showSuccessMsg() {
        Toast.makeText(getContext(), "加载成功！", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showFailMsg() {
        Toast.makeText(getContext(), "加载失败！", Toast.LENGTH_SHORT).show();
    }
}
