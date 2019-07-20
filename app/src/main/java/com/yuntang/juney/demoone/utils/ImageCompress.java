package com.yuntang.juney.demoone.utils;

import android.content.Context;
import android.graphics.Bitmap;

import java.io.File;
import java.util.List;

import top.zibin.luban.CompressionPredicate;
import top.zibin.luban.Luban;
import top.zibin.luban.OnCompressListener;

/**
 * Created by admini
 * on 2019/7/18
 */
public class ImageCompress {      //图片压缩工具类


    /**
     *
     * @param images  压缩的图片列表
     * @param context  上下文对象
     * @param path  目标路径
     */
    public void Compress(List<Bitmap> images, Context context, String path) {

        Luban.with(context)         //传入上下文对象
                .ignoreBy(100)      //100K以下不进行压缩
                .load(images)       //加载图片列表
                .setTargetDir(path)      //目标路径
                .setCompressListener(new OnCompressListener() {
                    @Override
                    public void onStart() {
                        System.out.println("图片开始压缩");
                    }

                    @Override
                    public void onSuccess(File file) {
                        System.out.println("图片压缩成功");
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println("图片压缩异常");
                    }
                }).launch();    //启动压缩
    }
}
