package com.ximen;

import java.lang.reflect.Method;

/**
 * @author zhishun.cai
 * @date 2020/8/5 11:55
 * @note
 */
public class B {
    public static void main(String[] args) {
        Person zhangsan = Person.ZHANGSAN;
        getName(zhangsan);
    }

    public static void getName(Object object){
        Class zClass = object.getClass();
        try {
            Method getNameMethod = zClass.getMethod("getName");
            Object res = getNameMethod.invoke(object);
            System.out.println(res);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
enum Person{
    ZHANGSAN("张三",10),
    LISI("李四",12),
    ;
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
