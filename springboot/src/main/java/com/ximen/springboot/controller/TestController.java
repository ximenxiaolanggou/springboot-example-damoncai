package com.ximen.springboot.controller;

import com.ximen.springboot.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhishun.cai
 * @date 2020/4/6 11:13
 * @note
 */
@RestController
public class TestController {

    @Autowired
    private Person person;

    @GetMapping("get")
    public Person get(){
        return person;
    }
}
