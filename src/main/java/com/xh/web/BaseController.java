package com.xh.web;

import com.xh.authentic.entity.User;
import com.xh.service.MessageService;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by xionghao on 29/10/2015.
 */
public class BaseController extends MultiActionController {

    @Autowired(required = true)
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
        //number
        int a = 11;
        float b = 5.555f;
        double c = 22.5555;
        boolean flg = true;
        //object
        User user = messageService.getUser(1l);
        //map
        Map<String, String> map = BeanUtils.describe(user);
        //list
        List<User> userLst = messageService.getAll();
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("a", a);
        modelAndView.addObject("b", b);
        modelAndView.addObject("c", c);
        modelAndView.addObject("flg", flg);
        modelAndView.addObject("user", user);
        modelAndView.addObject("map", map);
        modelAndView.addObject("userLst", userLst);
        modelAndView.addObject("sysdate", new Date());
        modelAndView.setViewName("f01");
        return modelAndView;
    }
}
