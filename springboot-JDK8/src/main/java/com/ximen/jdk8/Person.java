package com.ximen.jdk8;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.Objects;

/**
 * @author zhishun.cai
 * @date 2020/7/13 20:05
 * @note
 */
public class Person {


    private Integer age;
    private String name;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) &&
                Objects.equals(age, person.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Person(){

    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public Boolean haha(String name){
        System.out.println(this);
        return "this".equals(name);
    }

    public Boolean gg(Person p1){
        return p1.getAge() > 10;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
