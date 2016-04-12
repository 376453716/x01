package com.xh.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import org.springframework.web.servlet.view.freemarker.FreeMarkerView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by xionghao on 10/12/2015.
 */
@Controller
@RequestMapping("/login")
public class LoginController extends MultiActionController {

    @RequestMapping("/loginCheck")
    public ModelAndView loginCheck(@RequestParam("inputEmail") String id, String password) throws Exception {
        logger.info(id);
        logger.info(password);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("id", id);
        modelAndView.addObject("password", password);
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping("/main")
    public String main(Model model) {
        model.addAttribute("name", "test");
        return "main";
    }

    @RequestMapping("/login")
    public String login() throws Exception {
        return "login";
    }
}
