package com.guigu.web;

import com.guigu.service.impl.ServiceFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/face") // url:/模块/资源/{id}/细分 /seckill/list
public class FaceController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ServiceFacade serviceFacade;

    @ResponseBody
    @RequestMapping(value = "/insert", method = RequestMethod.GET)
    public String insert() {
        serviceFacade.insertUserBook();
        return "detail";
    }

    @ResponseBody
    @RequestMapping(value = "/insert/exception/before", method = RequestMethod.GET)
    public String insertUserBookExceptionBefore() {
        serviceFacade.insertUserBookExceptionBefore();
        return "detail";
    }

    @ResponseBody
    @RequestMapping(value = "/insert/exception/after", method = RequestMethod.GET)
    public String insertUserBookExceptionAfter() {
        serviceFacade.insertUserBookExceptionAfter();
        return "detail";
    }

}

