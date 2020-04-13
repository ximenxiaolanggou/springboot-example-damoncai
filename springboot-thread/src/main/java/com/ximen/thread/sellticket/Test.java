package com.ximen.thread.sellticket;

/**
 * @author zhishun.cai
 * @date 2020/4/1 19:40
 * @note
 */
public class Test {
    public static void main(String[] args) {
        Window window = new Window();

        Thread thread1 = new Thread(window);
        Thread thread2 = new Thread(window);

        thread1.setName("window_1");
        thread2.setName("window_2");

        thread1.start();
        thread2.start();
    }
}
