package com.yuntang.juney.demoone.utils;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by admini
 * on 2019/7/20
 */
public class DBHelper extends SQLiteOpenHelper {
    /**
     * 构造方法
     * @param context   上下文对象
     * @param name   数据库名称
     * @param factory
     * @param version   版本号
     */
    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }





}
