package com.damoncai.springbootmybatisplus.controller;

import com.damoncai.springbootmybatisplus.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeMapper employeeMapper;

    @RequestMapping("/findAll2")
    public List findAll(){
        return employeeMapper.findAll();
    }
}
