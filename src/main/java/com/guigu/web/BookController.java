package com.guigu.web;

import com.guigu.bean.Book;
import com.guigu.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/book") // url:/模块/资源/{id}/细分 /seckill/list
public class BookController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BookService bookService;

    @ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    private Book list(Model model) {
//        List<Book> list = bookService.getList();
        Book book = bookService.selectById(1);
        model.addAttribute("book", book);
        // list.jsp + model = ModelAndView
//        return "list";// WEB-INF/jsp/"list".jsp
        return book;// WEB-INF/jsp/"list".jsp
    }


    @ResponseBody
    @RequestMapping(value = "/detail/{bookId}", method = RequestMethod.GET)
    public String detail(@PathVariable("bookId") Integer bookId, Model model) {
        if (bookId == null) {
            return "redirect:/book/list";
        }
        Book book = bookService.selectById(bookId);
        if (book == null) {
            return "forward:/book/list";
        }
        model.addAttribute("book", book);
        return "detail";
    }

    @ResponseBody
    @RequestMapping(value = "/insert/{bookId}", method = RequestMethod.GET)
    public String insert(@PathVariable("bookId") Integer bookId) {
        if (bookId == null) {
            return "redirect:/book/list";
        }
        Book book = new Book(bookId, "go语言入门");
        //当addBook()方法抛出受检查的异常时，将不会回滚事务。
//        try {
//            bookService.insertException(book);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        try {
            bookService.insertBook(book);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "detail";
    }

}

