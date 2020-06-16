package com.ximen._3.factory._1.simplefactory;

/**
 * @author zhishun.cai
 * @date 2020/6/16 10:59
 * @note
 */
public class Main {
    public static void main(String[] args) {
        SimpleFactory factory = new SimpleFactory();
        Shape shape = factory.createObj("circle");
        shape.draw();
    }
}
