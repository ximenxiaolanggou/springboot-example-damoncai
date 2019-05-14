package com.ximen.springbootshiro.config.shiroconfig;

import com.ximen.springbootshiro.domain.User;
import com.ximen.springbootshiro.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: 西门小狼狗
 * @Date: 2019/5/14 16:05
 */
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;
    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行授权");
        //添加授权字符串
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addStringPermission("user:add");
        return info;
    }

    /**
     * 认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("执行认证");
        //编写Shiro判断逻辑，判断用户名和密码
        UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;
        User user = userService.findUserByUsername(token.getUsername());
        if(user == null){
            return null;
        }
        /**
         * 1.返回给login方法的数据（就是 User user = (User)SecurityUtils.getSubject().getPrincipal();返回的对象）
         * 2.数据中查询出来的密码
         * 3.shiro的名字
         */
        return new SimpleAuthenticationInfo(user,user.getPassword(),this.getName());
    }
}
