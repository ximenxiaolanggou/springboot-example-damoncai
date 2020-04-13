package com.ximen.thread.waitnotify;

/**
 * @author zhishun.cai
 * @date 2020/4/1 19:45
 * @note
 */
public class PrintB implements Runnable {
    public void run() {
        for (int i = 0 ; i < 10 ; i++){
            synchronized (Lock.o){
                if(i == 0){
                    //让A先执行
                    try {
                        Lock.o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("B");
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
