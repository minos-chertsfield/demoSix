package com.yuntang.juney.demoone;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.BufferedSink;

/**
 * Created by admini
 * on 2019/7/11
 */
public class RequestOkhttp {

    public static MediaType JSON = MediaType.parse("application/json;charset=utf-8");    //确定请求使用的媒体格式以及编码格式

    OkHttpClient client = new OkHttpClient();   //创建实例

    /**
     *
     * @param url 请求的url
     * @param json 将对应的类转换为json字符串
     * @return 返回应答字符串
     */
    String post(String url, String json) throws IOException{    //post提交数据的方法
        RequestBody requestBody = RequestBody.create(JSON, json);   //请求体 媒体类型为Json
        Request request = new Request.Builder()     //创建Request的对象
                .url(url)      //连接url
                .post(requestBody)    //传输请求体
                .build();

        Response response = client.newCall(request).execute(); //执行连接并获取服务器应答
        return response.body().string();
    }

}
