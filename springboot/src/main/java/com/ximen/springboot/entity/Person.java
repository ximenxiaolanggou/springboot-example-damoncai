package com.ximen.springboot.entity;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author zhishun.cai
 * @date 2020/4/6 10:59
 * @note
 */

@Data
@ToString
@Component
@PropertySource(value="classpath:person.properties",encoding = "UTF-8")
@ConfigurationProperties(prefix = "person")
public class Person {
    private String name;
    private Integer age;
}
