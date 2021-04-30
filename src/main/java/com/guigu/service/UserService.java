package com.guigu.service;

import com.guigu.bean.User;

public interface UserService {
    Integer insertUser(User record);

    Integer insertUserException(User record);

    Integer insertSelective(User record);

    Integer updateById(User record);

    User selectById(Integer id);
}  