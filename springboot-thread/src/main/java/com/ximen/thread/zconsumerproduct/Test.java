package com.ximen.thread.zconsumerproduct;

import com.ximen.thread.waitnotify.PrintA;
import com.ximen.thread.waitnotify.PrintB;

/**
 * @author zhishun.cai
 * @date 2020/4/1 19:46
 * @note
 */
public class Test {
    public static void main(String[] args) {
        //AB交替输出
        Consumer consumer = new Consumer();
        Producer producer = new Producer();

        Thread threadA = new Thread(consumer);
        Thread threadB = new Thread(producer);

        threadA.start();
        threadB.start();
    }
}
