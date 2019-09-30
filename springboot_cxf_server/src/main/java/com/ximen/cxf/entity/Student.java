package com.ximen.cxf.entity;

import com.sun.org.apache.xml.internal.serializer.utils.SerializerMessages_zh_CN;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * @author ZhiShun.Cai
 * @Date 2019/9/7 14:19
 */
@XmlRootElement(name="student")
@XmlAccessorType(XmlAccessType.FIELD)
public class Student implements Serializable {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
