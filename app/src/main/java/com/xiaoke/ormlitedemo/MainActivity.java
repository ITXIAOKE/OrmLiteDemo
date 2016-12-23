package com.xiaoke.ormlitedemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void start(View view) {
        try {
            //第二个泛型参数是id类型 将来跟删除查找，更新。
            Dao<UserInfo, Integer> dao = new MyOpenHelper(this).getDao(UserInfo.class);
            //addQuery(dao);
            //updateQuery(dao);
            //dao.deleteById(1);
            List<UserInfo> userInfos = dao.queryForAll();
            System.out.println(userInfos);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void updateQuery(Dao<UserInfo, Integer> dao) throws SQLException {
        UserInfo userInfo = dao.queryForId(100);
        userInfo.setName("小可爱android");
        dao.update(userInfo);
        List<UserInfo> userInfos = dao.queryForAll();
        System.out.println(userInfos);
    }

    private void addQuery(Dao<UserInfo, Integer> dao) throws SQLException {
        UserInfo info = new UserInfo();
        info.setName("小可爱java");
        info.setAge(11);
        info.setAddress("北京");
        dao.create(info);//在表里生成一条记录
        //查找到所有记录
        List<UserInfo> list = dao.queryForAll();
        System.out.println(list);
    }
}
