package com.yuntang.juney.demoone.utils;

import android.content.SharedPreferences;

/**
 * Created by admini
 * on 2019/7/12
 */
public class Mac {   //硬件地址类
    public String GenerateRandom(SharedPreferences preferences) {   //生成随机数

        String name = preferences.getString("demoOne", "");
        if(name.equals("")) {
            int random_num = (int)((Math.random() * 9 + 1) * 100000);    //产生随机数
            //实例化SharedPreferences.Editor对象
            SharedPreferences.Editor editor = preferences.edit();

            //用putString的方法保存数据
            editor.putString("demoOne", random_num + "");

            //提交数据
            editor.commit();
            return random_num + "";
        }
        return name;
    }

}
