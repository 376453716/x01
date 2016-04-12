package com.xh.web;

import com.xh.Entity.User;
import com.xh.service.MessageService;
import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
@Controller
@RequestMapping("/base")
public class BaseController {

    private static final Logger logger = LoggerFactory.getLogger(BaseController.class);

    @Autowired(required = true)
    private MessageService messageServiceH;

    @RequestMapping("/test")
    public ModelAndView test(HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.info("" + messageServiceH.getAll());
        logger.info(request.getParameter("name"));
        return new ModelAndView("test");
    }

    @RequestMapping("/test2")
    public ModelAndView test2(HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.info(request.getParameter("name"));
        return new ModelAndView("demo");
    }

    @RequestMapping("/test3")
    public ModelAndView test3(HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.info(request.getParameter("name"));
        //number
        int a = 11;
        float b = 5.555f;
        double c = 22.5555;
        boolean flg = true;
        //object
        User user = messageServiceH.getUser(1l);
        //map
        Map<String, String> map = BeanUtils.describe(user);
        //list
        List<User> userLst = messageServiceH.getAll();
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
