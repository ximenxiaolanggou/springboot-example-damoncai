package com.ximen.adapter;

/**
 * @author zhishun.cai
 * @date 2020/4/20 16:09
 * @note
 */
public class Client {
    public static void main(String[] args) {
        Phone phone = new Phone();
        phone.charing(new Adapter());
    }
}
