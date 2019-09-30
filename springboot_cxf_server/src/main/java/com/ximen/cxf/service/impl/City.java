package com.ximen.cxf.service.impl;

import com.ximen.cxf.entity.Student;
import com.ximen.cxf.service.CityInterface;

/**
 * @author ZhiShun.Cai
 * @Date 2019/9/7 14:16
 */
public class City implements CityInterface {
    @Override
    public Student getWeather(String cityID) {
        Student student = new Student();
        if("1".equals(cityID)){
            System.out.println("北京");
            student.setName("张三");
            student.setAge(1);
            return student;
        }
        student.setName("李四");
        student.setAge(2);
        System.out.println("河北");
        return student;
    }
}
