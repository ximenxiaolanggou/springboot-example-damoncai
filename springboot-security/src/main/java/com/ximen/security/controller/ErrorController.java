package com.ximen.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ZhiShun.Cai
 * @date 2019/10/30 21:01
 * @note
 */
@Controller
@RequestMapping("errorpage")
public class ErrorController {

    @RequestMapping("403")
    public String forbidden(){
        return "errorpage/403";
    }
}
