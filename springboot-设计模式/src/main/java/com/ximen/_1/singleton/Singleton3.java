package com.ximen._1.singleton;

/**
 * @author zhishun.cai
 * @date 2020/6/13 16:50
 * @note
 */
public class Singleton3 {

    //防止创建对象
    private Singleton3(){
    }

    private static class Singleton {
        private final static Singleton3 INSTANCE = new Singleton3();
    }

    /**
     * 静态内部类方式
     * JVM保证单例: 类只会被加载一次
     * 加载外部类时不会加载内部类，这样可以实现懒加载
     * @return
     */
    public static Singleton3 getInstance(){
        return Singleton.INSTANCE;
    }
}
