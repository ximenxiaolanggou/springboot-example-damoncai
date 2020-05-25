package com.ximen.controller;

import com.ximen.entity.InputMDC;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhishun.cai
 * @date 2020/5/9 14:04
 * @note
 */
@RestController
@RequestMapping("/main")
@Slf4j
public class MainController {

    @GetMapping("test")
    public Object test(){
        InputMDC.putMDC();
        log.info("this is info");
        log.warn("this is warn");
        log.error("this is error");
        return "test";
    }

    @GetMapping("test2")
    public Object test2(){
        int i = 1/0;
        return "test2";
    }
}
