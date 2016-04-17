package com.xh.authentic.controller;

import com.xh.authentic.entity.User;
import com.xh.authentic.service.AuthenticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by xh on 2016/4/17.
 */
@Controller
@RequestMapping("/authentic")
public class AuthenticController {

    @Autowired
    private AuthenticService authenticService;

    @RequestMapping("/main")
    public String userMain() {
        return "user/userMain";
    }

    @RequestMapping("/list")
    public ModelAndView list(User user) {
        ModelAndView mv = new ModelAndView();
        user.setName(user.getName());
        List<User> list = authenticService.queryUserList(user);
        mv.addObject("userList", list);
        mv.setViewName("user/userMain");
        return mv;
    }

    @RequestMapping("/detail")
    public ModelAndView detail(@RequestParam(required = true) Long id) {
        ModelAndView mv = new ModelAndView();
        User user = authenticService.getUser(id);
        mv.addObject("user", user);
        mv.setViewName("user/userDetail");
        return mv;
    }

    @RequestMapping("/update")
    public String update(User user) {
        ModelAndView mv = new ModelAndView();
        authenticService.updateUser(user, user.getId());
        return "redirect:list";
    }

    @RequestMapping("/input")
    public String input() {
        return "user/userInput";
    }

    @RequestMapping("/add")
    public String add(User user) {
        authenticService.addUser(user);
        return "redirect:list";
    }
}
