package com.ximen.thread.waitnotify;

/**
 * @author zhishun.cai
 * @date 2020/4/1 19:46
 * @note
 */
public class Test {
    public static void main(String[] args) {
        //AB交替输出
        PrintA printA = new PrintA();
        PrintB printB = new PrintB();

        Thread threadA = new Thread(printA);
        Thread threadB = new Thread(printB);

        threadA.start();
        threadB.start();
    }
}
