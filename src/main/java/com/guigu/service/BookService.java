package com.guigu.service;

import com.guigu.bean.Book;

public interface BookService {

    Integer insertBook(Book record);

    Integer insertExceptionBefore(Book record);

    Integer insertExceptionAfter(Book record);

    Integer insertSelective(Book record);

    Integer updateById(Book record);

    Book selectById(Integer id);
}