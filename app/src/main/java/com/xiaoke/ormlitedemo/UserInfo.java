package com.xiaoke.ormlitedemo;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Administrator on 2016/12/12.
 */
@DatabaseTable(tableName = "t_user")
public class UserInfo {
    @DatabaseField(columnName = "name")
    private String name;
    @DatabaseField(columnName = "address")
    private String address;
    @DatabaseField(columnName = "age")
    private int age;
    @DatabaseField(columnName = "_id",generatedId = true)
    private int id;
    //有几点要求
    //1.无参构造函数
    //2.get与set方法
    //3.配置表名 @DatabaseTable 告诉框架将来这个记录存在哪张表
    //4.配置表字段@DatabaseField配置 成员变量对应的列名
    //5.generatedId = true 主键,自增长
    public UserInfo() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
