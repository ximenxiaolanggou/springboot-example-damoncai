package com.ximen;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @Author: 西门小狼狗
 * @Date: 2019/5/27 11:16
 */
public class CreateDb {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");

        //一开始必须填一个已经存在的数据库
        String url = "jdbc:mysql://localhost:3306/haixin?useUnicode=true&characterEncoding=utf-8";
        Connection conn = DriverManager.getConnection(url, "root", "root");
        Statement stat = conn.createStatement();

        //创建数据库hello
        stat.executeUpdate("create database hello");

        //打开创建的数据库
        stat.close();
        conn.close();
        url = "jdbc:mysql://localhost:3306/hello?useUnicode=true&characterEncoding=utf-8";
        conn = DriverManager.getConnection(url, "root", "root");
        stat = conn.createStatement();

        //创建表test
        stat.executeUpdate("create table test(id int, name varchar(80))");

        //添加数据
        stat.executeUpdate("insert into test values(1, '张三')");
        stat.executeUpdate("insert into test values(2, '李四')");

        //查询数据
        ResultSet result = stat.executeQuery("select * from test");
        while (result.next())
        {
            System.out.println(result.getInt("id") + " " + result.getString("name"));
        }

        //关闭数据库
        result.close();
        stat.close();
        conn.close();
    }
}
