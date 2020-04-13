package com.ximen.thread.zconsumerproduct;

/**
 * @author zhishun.cai
 * @date 2020/4/1 19:57
 * @note
 */
public class Consumer implements Runnable {
    public void run() {
        while (true) {
            synchronized (Container.container) {
                if (Container.container.size() <= 0) {
                    Container.container.notifyAll();
                    try {
                        Container.container.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Container.container.remove("apple");
                    System.out.println("减少一个一共:" + Container.container.size());
                    Container.container.notifyAll();
                }
            }
        }
    }
}
