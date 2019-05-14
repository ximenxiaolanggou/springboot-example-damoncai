package com.ximen.springbootshiro.service.impl;

import com.ximen.springbootshiro.domain.User;
import com.ximen.springbootshiro.mapper.UserMapper;
import com.ximen.springbootshiro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public User findUserByUsername(String username) {
        return userMapper.findByUsername(username);
    }
}
