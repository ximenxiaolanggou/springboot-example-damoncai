package com.ximen._2.strategy;

/**
 * @author zhishun.cai
 * @date 2020/6/14 10:35
 * @note
 */
public class Dog {

    private Integer age;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Dog(){

    }


    public Dog(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "age=" + age +
                '}';
    }
}
