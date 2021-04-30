package com.guigu.service.impl;

import com.guigu.bean.Book;
import com.guigu.dao.BookDao;
import com.guigu.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Transactional
    @Override
    public Integer insertBook(Book record) {
        Integer i = bookDao.insert(record);
        return i;
    }

    @Transactional
    @Override
    public Integer insertExceptionBefore(Book record) {
        if (10 > -1) {
            throw new RuntimeException("throw runtime exception in outter transaction");
        }
        Integer i = bookDao.insert(record);
        return i;
    }

    @Transactional
    @Override
    public Integer insertExceptionAfter(Book record) {
        Integer i = bookDao.insert(record);
        if (i > -1) {
            throw new RuntimeException("throw runtime exception in outter transaction");
        }
        return i;
    }

    @Override
    public Integer insertSelective(Book record) {
        Integer i = bookDao.insertSelective(record);
        return i;
    }

    @Override
    public Integer updateById(Book record) {
        Integer i = bookDao.insertSelective(record);
        return i;
    }

    @Override
    public Book selectById(Integer id) {
        Book book = bookDao.selectById(id);
        return book;
    }
}