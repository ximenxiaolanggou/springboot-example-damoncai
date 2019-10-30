package com.ximen.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ZhiShun.Cai
 * @date 2019/10/30 19:17
 * @note
 */
@Controller
@RequestMapping("product")
public class ProductController {

    @RequestMapping("add")
    public String add(){
        return "product/add";
    }

    @RequestMapping("update")
    public String update(){
        return "product/update";
    }

    @RequestMapping("delete")
    public String delete(){
        return "product/delete";
    }

    @RequestMapping("list")
    public String list(){
        return "product/list";
    }
}
