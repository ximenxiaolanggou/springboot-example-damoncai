package com.ximen.client.controller;

import com.alibaba.fastjson.JSON;
import com.ximen.client.netty.Client;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhishun.cai
 * @date 2020/4/14 16:22
 * @note
 */
@RestController
public class Send {
    @GetMapping("send")
    public Boolean send(Integer state){
        Map map = new HashMap<>();
        map.put("type",1);
        map.put("state",state);
        map.put("comoneoId","abc");
        String msg = JSON.toJSONString(map);
        Client.channel.writeAndFlush(msg);
        return true;
    }
}
