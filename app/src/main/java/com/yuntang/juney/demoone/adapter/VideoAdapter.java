package com.yuntang.juney.demoone.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yuntang.juney.demoone.bean.VideoInfo;

import java.util.List;

/**
 * Created by admini
 * on 2019/7/31
 */
public class VideoAdapter extends BaseQuickAdapter<VideoInfo, BaseViewHolder> {

    public VideoAdapter(int layoutResId, @Nullable List<VideoInfo> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, VideoInfo item) {

        
    }
}
