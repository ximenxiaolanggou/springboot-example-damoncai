package com.ximen.security.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author ZhiShun.Cai
 * @date 2019/10/30 19:58
 * @note
 */
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/login").permitAll()
                .antMatchers("/product/add").hasAnyAuthority("ADD")
                .antMatchers("/product/delete").hasAnyAuthority("DELETE")
                .antMatchers("/product/list").hasAnyAuthority("LIST")
                .antMatchers("/product/update").hasAnyAuthority("UPDATE")
                .antMatchers("/**")
                .fullyAuthenticated()
                .and()
                .formLogin().loginPage("/login")    // 默认的认证方式  表单认证
                .and()
                .csrf().disable();
//                .httpBasic();     // http basic 使用浏览器提供的表单

    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
