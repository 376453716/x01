package com.xh.web;

import com.xh.Entity.User;
import com.xh.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by xionghao on 29/10/2015.
 */
public class BaseController extends MultiActionController {

    @Autowired
    private MessageService messageService;

    public ModelAndView test(HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.info(messageService.getAll());
        logger.info(request.getParameter("name"));
        return new ModelAndView("test");
    }

    public ModelAndView test2(HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.info(request.getParameter("name"));
        return new ModelAndView("test");
    }

    public ModelAndView test3(HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.info(request.getParameter("name"));
        Map<String, Object> root = new HashMap<String, Object>();
        root.put("data", "simple data model");
        User user = new User(1l, "user 2", new Date());
        root.put("user", user);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject(root);
        modelAndView.setViewName("f01");
        return modelAndView;
    }
}
