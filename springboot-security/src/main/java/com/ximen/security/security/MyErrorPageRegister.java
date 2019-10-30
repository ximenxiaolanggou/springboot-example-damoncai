package com.ximen.security.security;

import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

/**
 * @author ZhiShun.Cai
 * @date 2019/10/30 20:56
 * @note
 */
@Configuration
public class MyErrorPageRegister implements ErrorPageRegistrar {
    @Override
    public void registerErrorPages(ErrorPageRegistry registry) {
        //构造方法： 类型 状态码
        ErrorPage errorPage_403 = new ErrorPage(HttpStatus.FORBIDDEN,"/errorpage/403");
        registry.addErrorPages(errorPage_403);
    }
}
