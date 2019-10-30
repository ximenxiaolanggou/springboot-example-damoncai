package com.ximen.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ZhiShun.Cai
 * @date 2019/10/30 19:07
 * @note
 */
@Controller
public class MainController {
    @RequestMapping("index")
    public String indexPage(){
        return "index";
    }

    @RequestMapping("login")
    public String login(){
        return "login";
    }
}
