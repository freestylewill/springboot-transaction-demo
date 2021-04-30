package com.guigu.service.impl;

import com.guigu.bean.User;
import com.guigu.dao.UserDao;
import com.guigu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

//    @Autowired
//    private BookService bookService;

    @Transactional
    @Override
    public Integer insertUser(User record) {
        Integer i = userDao.insert(record);
        return i;
    }

    @Transactional
    @Override
    public Integer insertUserException(User record) {
        Integer i = userDao.insert(record);
        if (10 > -1) {
            throw new RuntimeException("throw runtime exception in outter transaction");
        }
        return i;
    }

    @Override
    public Integer insertSelective(User record) {
        Integer i = userDao.insertSelective(record);
        return i;
    }

    @Override
    public Integer updateById(User record) {
        Integer i = userDao.insertSelective(record);
        return i;
    }

    @Override
    public User selectById(Integer id) {
        User tBook = userDao.selectById(id);
        return tBook;
    }

    //    @Override
//    public Integer insertUserAndBookService(User record) {
//        Book book = new Book(66, "java语言精通");
//        Integer i = userDao.insert(record);
//        try {
//            Integer integer = bookService.insertBook(book);
//        } catch (Exception e){
//            e.printStackTrace();
//        }
//        Integer integer = bookService.insertBook(book);
//        Integer integer = bookService.insertException(book);
//        Integer i = userDao.insert(record);
//        return i;
//    }

}  