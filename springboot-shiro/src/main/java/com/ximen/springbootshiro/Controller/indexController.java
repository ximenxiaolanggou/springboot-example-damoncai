package com.ximen.springbootshiro.Controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: 西门小狼狗
 * @Date: 2019/5/14 15:36
 */
@Controller
@RequestMapping("/user")
public class indexController {

    @RequestMapping("/thymeleaf")
    public String thymeleaf(Model model){
        model.addAttribute("name","damon");
        return "index";
    }

    @RequestMapping("/edit")
    public String edit(){
        return "user/edit";
    }

    @RequestMapping("/add")
//    @RequiresPermissions("user:add") 如果没有"user:add""字符串权限会跳转到设置的权限不足页面
    public String add(){
        return "user/add";
    }

    @RequestMapping("/toLogin")
    public String toLogin(){
        return "user/login";
    }

    @RequestMapping("/doLogin")
    public String doLogin(String username,String password,Model model){
        /**
         * 使用Shiro编写认证操作
         */
        //1.获取Subject
        Subject subject = SecurityUtils.getSubject();

        //2.封装用户数据
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);

        //3.执行登录方法
        try {
            subject.login(token);
            return "index";
        }catch (UnknownAccountException e){
            model.addAttribute("msg","账户不存在");
        }catch (IncorrectCredentialsException e){
            model.addAttribute("msg","密码不正确");
        }catch (Exception e){
            model.addAttribute("msg","位置异常");
        }
        return "user/login";
    }

    //跳转到未授权页面
    @RequestMapping("/noAuth")
    public String noAuth(){
        return "/noAuth";
    }

}
