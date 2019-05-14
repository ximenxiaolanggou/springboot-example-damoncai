package com.ximen.springbootshiro.service;

import com.ximen.springbootshiro.domain.User;

public interface UserService {
    public User findUserByUsername(String username);
}
