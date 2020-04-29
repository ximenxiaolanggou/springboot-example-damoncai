package com.ximen.singleton;

/**
 * @author zhishun.cai
 * @date 2020/4/15 19:59
 * @note
 */
public class StaticInnerClass {
    public static void main(String[] args) {
        System.out.println(Singleton2.getInstance());
        System.out.println(Singleton2.getInstance());
    }
}

class Singleton2{
    private static volatile Singleton instance;

    //在外部类被加载时不会加载内部类就可以实现懒加载， 在调用内部类的方法时内部类加载，内部类加载处于线程安全状态
    private static class Inner{
        public static  final Singleton2  singleton2 = new Singleton2();
    }

    public static Singleton2 getInstance(){
        return Inner.singleton2;
    }

    private Singleton2(){}


}

