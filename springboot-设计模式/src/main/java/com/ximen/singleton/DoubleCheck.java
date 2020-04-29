package com.ximen.singleton;

/**
 * @author zhishun.cai
 * @date 2020/4/15 19:49
 * @note
 */
public class DoubleCheck {
    public static void main(String[] args) {
        System.out.println(Singleton.getInstance());
    }

}

class Singleton{
    private static volatile Singleton instance;

    private Singleton(){}

    // 解决线程安全问题。同时解决懒加载问题
    public static Singleton getInstance(){
        if(instance == null){ // 主要解决效率问题
            synchronized (Singleton.class){
                if(instance == null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
