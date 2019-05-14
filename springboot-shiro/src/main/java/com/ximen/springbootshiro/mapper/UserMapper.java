package com.ximen.springbootshiro.mapper;

import com.ximen.springbootshiro.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    User findByUsername(String username);
}
