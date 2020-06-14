package com.ximen._1.singleton;

/**
 * @author zhishun.cai
 * @date 2020/6/13 16:50
 * @note
 */
public class Singleton {
    //问题:无论是不是用都会创建对象
    private static final Singleton INSTANCE;

    static {
        INSTANCE = new Singleton();
    }

    //防止创建对象
    private Singleton(){
    }

    public static Singleton getInstance(){
        return INSTANCE;
    }
}
