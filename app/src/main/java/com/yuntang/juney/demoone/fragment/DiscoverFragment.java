package com.yuntang.juney.demoone.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.yuntang.juney.demoone.R;
import com.yuntang.juney.demoone.view.PlayerMusicActivity;

/**
 * Created by admini
 * on 2019/7/17
 */
public class DiscoverFragment extends Fragment {    //发现碎片

    private Button play;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.discoverfragment, container, false);
        return  view;
    }

    @Override
    public void onStart() {


        play = (Button) getView().findViewById(R.id.play);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), PlayerMusicActivity.class);
                startActivity(intent);
            }
        });

        super.onStart();
    }
}
