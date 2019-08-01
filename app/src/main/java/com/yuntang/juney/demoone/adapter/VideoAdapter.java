package com.yuntang.juney.demoone.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yuntang.juney.demoone.R;
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

//        Glide.with(mContext).load(item.getPreview()).into((ImageView) helper.getView(R.id.preview));
        helper.setText(R.id.videoTitle, item.getTitle())
            .setText(R.id.videoArtist, item.getArtist())
            .setText(R.id.videoHot, item.getHot());
    }
}
