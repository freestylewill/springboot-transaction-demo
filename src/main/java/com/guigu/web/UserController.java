package com.guigu.web;

import com.guigu.bean.User;
import com.guigu.service.UserService;
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
@RequestMapping("/user") // url:/模块/资源/{id}/细分 /seckill/list
public class UserController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    private User list(Model model) {
//        List<User> list = bookService.getList();
        User user = userService.selectById(1);
        model.addAttribute("user", user);
        // list.jsp + model = ModelAndView
//        return "list";// WEB-INF/jsp/"list".jsp
        return user;// WEB-INF/jsp/"list".jsp
    }


    @ResponseBody
    @RequestMapping(value = "/detail/{bookId}", method = RequestMethod.GET)
    public String detail(@PathVariable("bookId") Integer bookId, Model model) {
        if (bookId == null) {
            return "redirect:/user/list";
        }
        User user = userService.selectById(bookId);
        if (user == null) {
            return "forward:/user/list";
        }
        model.addAttribute("user", user);
        return "detail";
    }

    @ResponseBody
    @RequestMapping(value = "/insert/{userId}", method = RequestMethod.GET)
    public String insert(@PathVariable("userId") Integer userId) {
        if (userId == null) {
            return "redirect:/user/list";
        }
        User user = new User(userId, "python");
        //当addBook()方法抛出受检查的异常时，将不会回滚事务。
//        try {
//            bookService.insertException(user);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        try {
            userService.insertUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "detail";
    }

}

