package com.guigu.service.impl;

import com.guigu.bean.Book;
import com.guigu.bean.User;
import com.guigu.service.BookService;
import com.guigu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ServiceFacade {

    @Autowired
    private BookService bookService;

    @Autowired
    private UserService userService;

    public BookService getBookService() {
        return bookService;
    }

    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void insertUserBook() {
        Book book = new Book(1, "java编程思想");
        User user = new User(1, "mayun马军");
        bookService.insertBook(book);
        userService.insertUser(user);
    }

    //加入事务全部回滚
    @Transactional
    public void insertUserBookExceptionBefore() {
        Book book = new Book(1, "java编程思想");
        User user = new User(1, "mayun马军");
        bookService.insertExceptionBefore(book);
        userService.insertUser(user);
    }

    //加入事务全部回滚
    @Transactional
    public void insertUserBookExceptionAfter() {
        Book book = new Book(1, "java编程思想");
        User user = new User(1, "mayun马军");
        bookService.insertBook(book);
        userService.insertUserException(user);
    }

} 