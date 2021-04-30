package com.guigu.dao;

import com.guigu.bean.Book;

public interface BookDao {
    Integer insert(Book record);

    Integer insertSelective(Book record);

    Integer updateById(Book record);

    Book selectById(Integer id);
}