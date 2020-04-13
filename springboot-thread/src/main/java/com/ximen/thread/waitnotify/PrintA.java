package com.ximen.thread.waitnotify;

/**
 * @author zhishun.cai
 * @date 2020/4/1 19:45
 * @note
 */
public class PrintA implements Runnable {
    public void run() {
        for (int i = 0 ; i < 10 ; i++){
            synchronized (Lock.o){
                System.out.println("A");
                Lock.o.notifyAll();
                try {
                    Lock.o.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
