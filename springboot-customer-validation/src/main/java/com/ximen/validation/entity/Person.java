package com.ximen.validation.entity;

import com.ximen.validation.annotation.Age;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Size;

/**
 * @author zhishun.cai
 * @date 2021/2/4 10:12
 */

@Getter
@Setter
public class Person {

    @Age(min = 90)
    private String name;

    private Integer age;
}
