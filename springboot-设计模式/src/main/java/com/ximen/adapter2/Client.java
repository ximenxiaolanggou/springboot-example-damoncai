package com.ximen.adapter2;

/**
 * @author zhishun.cai
 * @date 2020/4/20 16:09
 * @note
 */
public class Client {
    public static void main(String[] args) {
        Adapter adapter = new Adapter(new Voltage220V());
        Phone phone = new Phone();
        phone.charing(adapter);
    }
}
