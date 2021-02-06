package com.ximen.validation.controller;

import com.ximen.validation.entity.Person;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhishun.cai
 * @date 2021/2/4 10:13
 */

@RequestMapping("person")
@RestController
public class PersonController {

    @GetMapping
    public String say(@Validated Person person) {
        return person.toString();
    }
}



