package com.ximen._2.strategy;

/**
 * @author zhishun.cai
 * @date 2020/6/14 10:43
 * @note
 */
public class Cat implements Comparable<Cat> {

    private Integer age;


    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Cat(){}
    public Cat(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "age=" + age +
                '}';
    }

    public int compareTo(Cat cat) {
        if(this.age == cat.age){
            return 0;
        }else if (this.age > cat.age){
            return 1;
        }else{
            return -1;
        }
    }
}
