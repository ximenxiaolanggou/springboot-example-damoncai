package com.ximen.thread.sellticket;

/**
 * @author zhishun.cai
 * @date 2020/4/1 19:37
 * @note
 */
public class Window implements Runnable {

    private Integer number = 10;

    public void run() {
        while (true){
            synchronized (this){
                if(number == 0){
                    break;
                }
                System.out.println(Thread.currentThread().getName() + " " + number);
                number--;
            }
        }
    }

    public synchronized void biu(){
        if(number == 0){
            return;
        }
        System.out.println(Thread.currentThread().getName() + " " + number);
        number--;
    }

}
