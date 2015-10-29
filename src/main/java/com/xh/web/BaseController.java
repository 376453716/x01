package com.xh.web;

import com.xh.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by xionghao on 29/10/2015.
 */
public class BaseController extends MultiActionController {

    @Autowired
    private MessageService messageService;

    public ModelAndView test(HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.info(messageService);
        return new ModelAndView("test");
    }

    public ModelAndView test2(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return new ModelAndView("test");
    }
}
