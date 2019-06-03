package com.ximen.springbootquartz.autostart;

import java.util.List;

import com.ximen.springbootquartz.task.ScheduledService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 继承 ApplicationRunner 接口后项目启动时会按照执行顺序执行 run 方法
 * @version:
 * @Description:
 * @author fxg
 * @date: 2018年9月17日 下午5:21:06
 *
 */
@Component
@Order(value = 1)
public class AutoStart implements ApplicationRunner {

    private static Logger logger = LoggerFactory.getLogger(AutoStart.class);

    @Override
    public void run(ApplicationArguments args) throws Exception {
        logger.info("=========== 项目启动后，初始化 Redis =============");
//        new ScheduledService().scheduled();
    }

}
