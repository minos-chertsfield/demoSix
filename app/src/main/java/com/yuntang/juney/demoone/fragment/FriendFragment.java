package com.yuntang.juney.demoone.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ListView;

import com.yuntang.juney.demoone.R;

/**
 * 好友碎片
 */
public class FriendFragment extends Fragment implements View.OnClickListener{

    private ImageButton addFriend;
    private ListView listFriend;




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

        addFriend.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        //TODO 添加好友
    }
}
