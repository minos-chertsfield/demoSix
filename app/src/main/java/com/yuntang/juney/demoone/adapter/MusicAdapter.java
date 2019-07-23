package com.yuntang.juney.demoone.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.yuntang.juney.demoone.R;
import com.yuntang.juney.demoone.bean.MusicInfo;

import java.util.List;

/**
 * Created by admini
 * on 2019/7/18
 */
public class MusicAdapter extends RecyclerView.Adapter<com.yuntang.juney.demoone.adapter.MusicAdapter.ViewHolder> {      //音乐信息适配器




    /**
     * 内部接口，声明recyclerView的点击事件
     */
    public interface OnItemClickListener {      //内部接口，条目的点击事件
        void onItemClick(View view, int position);
    }

    /**
     * 设置相应点击方法的监听器和监听设置方法
     */
    private OnItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(com.yuntang.juney.demoone.adapter.MusicAdapter.OnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }


    private Context mContext;     //上下文对象

    private List<MusicInfo> mMusicList;




    static class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;     //卡片视图对象

        TextView musicName;       //菜谱名称
        TextView artist;       //作者姓名


        public ViewHolder(View view) {     //对应控件进行绑定
            super(view);
            cardView = (CardView) view;
            musicName = (TextView) view.findViewById(R.id.musicName);
            artist = (TextView) view.findViewById(R.id.artist);

//            favoriteName = (TextView) view.findViewById(R.id.favorite_name);    //实例化商品名称文本
//            ownerName = (TextView) view.findViewById(R.id.owner);    //作者用户名实例化
//            ownerHead = (ImageView) view.findViewById(R.id.owner_img);    //作者头像实例化
        }
    }


    public MusicAdapter(List<MusicInfo> musicList) {
        mMusicList = musicList;
    }

    @Override
    public com.yuntang.juney.demoone.adapter.MusicAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mContext == null) {
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.music_item, parent, false);
        return new com.yuntang.juney.demoone.adapter.MusicAdapter.ViewHolder(view);
    }


    /**
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(final com.yuntang.juney.demoone.adapter.MusicAdapter.ViewHolder holder, int position) {
        ViewGroup.LayoutParams params =  holder.itemView.getLayoutParams();//得到item的LayoutParams布局参数
        holder.itemView.setLayoutParams(params);//把params设置给itemView布局
        MusicInfo musicInfo = mMusicList.get(position);
        holder.musicName.setText(musicInfo.getTitle());
        holder.artist.setText(musicInfo.getArtist());
        System.out.println(musicInfo.getTitle());





        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {    //利用定义方法获取点击位置
                int position = holder.getLayoutPosition();
                mOnItemClickListener.onItemClick(holder.itemView, position);
                System.out.println();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mMusicList.size();
    }


}
