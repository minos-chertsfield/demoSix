package com.yuntang.juney.demoone.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yuntang.juney.demoone.R;
import com.yuntang.juney.demoone.bean.Friend;

import java.util.List;

/**
 * Created by admini
 * on 2019/7/31
 */
public class FriendAdapter extends BaseQuickAdapter<Friend, BaseViewHolder> {

    public FriendAdapter(int layoutResId, @Nullable List<Friend> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Friend item) {

        helper.setText(R.id.friendUid, item.getUid());
        helper.setText(R.id.friendGrade, item.getGrade());
        Glide.with(mContext).load(item.getHeadLink()).into((ImageView) helper.getView(R.id.friendHead));
    }
}
