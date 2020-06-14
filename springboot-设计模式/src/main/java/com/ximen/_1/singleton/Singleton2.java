package com.ximen._1.singleton;

/**
 * @author zhishun.cai
 * @date 2020/6/13 16:50
 * @note
 */
public class Singleton2 {

    //双重校验需要添加 volatile
    //https://blog.csdn.net/jm_heiyeqishi/article/details/51052889
    private static volatile Singleton2 INSTANCE;


    //防止创建对象
    private Singleton2(){
    }

    //懒汉式 存在线程问题
    public static Singleton2 getInstance1(){
        if( null == INSTANCE){
            INSTANCE = new Singleton2();
        }
        return INSTANCE;
    }

    //懒汉式 加锁确保线程安全
    public static synchronized Singleton2 getInstance2(){
        if( null == INSTANCE){
            INSTANCE = new Singleton2();
        }
        return INSTANCE;
    }

    //懒汉式 双重校验
    public static synchronized Singleton2 getInstance3(){
        if( null == INSTANCE){
            synchronized (Singleton2.class){
                if(null == INSTANCE){
                    INSTANCE = new Singleton2();
                }
            }

        }
        return INSTANCE;
    }
}
