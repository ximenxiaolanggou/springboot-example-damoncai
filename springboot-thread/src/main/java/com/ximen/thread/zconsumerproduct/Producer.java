package com.ximen.thread.zconsumerproduct;

/**
 * @author zhishun.cai
 * @date 2020/4/1 19:57
 * @note
 */
public class Producer implements Runnable {
    public void run() {
        while (true){
            synchronized (Container.container){
            if(Container.container.size() >=10){
                    Container.container.notifyAll();
                    try {
                        Container.container.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
            }else {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Container.container.add("apple");
                System.out.println("添加一个一共:" + Container.container.size());
                Container.container.notifyAll();
            }
        }
    }
    }
}
