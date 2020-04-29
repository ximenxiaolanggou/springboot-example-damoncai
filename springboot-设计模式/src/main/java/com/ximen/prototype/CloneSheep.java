package com.ximen.prototype;

/**
 * @author zhishun.cai
 * @date 2020/4/16 20:37
 * @note
 */
public class CloneSheep {
    public static void main(String[] args) throws CloneNotSupportedException {
        Sheep sheep = new Sheep("dmaon",12,"white");

        Sheep sheep1 =  (Sheep) sheep.clone();
        Sheep sheep2 =  (Sheep)sheep.clone();
        Sheep sheep3 =  (Sheep)sheep.clone();
        System.out.println(sheep1);
        System.out.println(sheep2);
        System.out.println(sheep3);
        System.out.println(sheep1 == sheep2);
    }
}
