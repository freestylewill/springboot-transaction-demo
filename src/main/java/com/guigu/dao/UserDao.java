package com.guigu.dao;

import com.guigu.bean.User;

public interface UserDao {
    Integer insert(User record);

    Integer insertSelective(User record);

    Integer updateById(User record);

    User selectById(Integer id);
}