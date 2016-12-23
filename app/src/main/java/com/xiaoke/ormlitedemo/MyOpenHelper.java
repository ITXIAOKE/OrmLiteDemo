package com.xiaoke.ormlitedemo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

/**
 * Created by Administrator on 2016/12/12.
 */

public class MyOpenHelper extends OrmLiteSqliteOpenHelper {
    private static final String databaseName="xiaokeuser.db";
    //OrmLiteSqliteOpenHelper:是SqliteOpenHelper子类。
    private  static final SQLiteDatabase.CursorFactory factory=null;
    private static final int databaseVersion=1;

    public MyOpenHelper(Context context) {
        super(context, databaseName, factory, databaseVersion);
    }

    //TableUtils:表工具 管理表，创建表与删除表
    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        //ConnectionSource:优化为SqliteDatabase
        //javaBean的字节文件
        //创建表.
        try {
            TableUtils.createTable(connectionSource,UserInfo.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource,
                          int oldVersion, int newVersion) {
    }
}
