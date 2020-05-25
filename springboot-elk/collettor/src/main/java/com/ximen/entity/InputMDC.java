package com.ximen.entity;

import com.ximen.utils.NetUtil;
import org.apache.logging.log4j.core.util.NetUtils;
import org.jboss.logging.MDC;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * @author zhishun.cai
 * @date 2020/5/9 14:11
 * @note
 */

@Component
public class InputMDC implements EnvironmentAware {

    private static Environment environment;

    @Override
    public void setEnvironment(Environment environment) {
        InputMDC.environment = environment;
    }

    public static void putMDC(){
        MDC.put("hostName",NetUtil.getLocalHostName() );
        MDC.put("ip", NetUtil.getLocalIp());
        MDC.put("applicationName", environment.getProperty("spring.application.name"));
    }
}
