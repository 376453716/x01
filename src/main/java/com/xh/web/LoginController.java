package com.xh.web;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by xionghao on 10/12/2015.
 */
public class LoginController extends MultiActionController {

    public ModelAndView loginCheck(HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.info(request.getParameter("name"));
        return new ModelAndView("index");
    }

    public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return new ModelAndView("login");
    }
}
