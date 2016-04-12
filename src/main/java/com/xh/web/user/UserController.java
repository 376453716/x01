package com.xh.web.user;

import com.xh.Entity.User;
import com.xh.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.Serializable;
import java.util.List;

/**
 * Created by xh on 03/04/16.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/list")
    public ModelAndView list(User user) {
        ModelAndView mv = new ModelAndView();
        user.setName("%" + user.getName() + "%");
        List<User> list = userService.queryUserList(user);
        mv.addObject("userList", list);
        mv.setViewName("user/userList");
        return mv;
    }

    @RequestMapping("/detail")
    public ModelAndView detail(@RequestParam(required = true) Long id) {
        ModelAndView mv = new ModelAndView();
        User user = userService.getUser(id);
        mv.addObject("user", user);
        mv.setViewName("user/userDetail");
        return mv;
    }

    @RequestMapping("/update")
    public String update(User user) {
        ModelAndView mv = new ModelAndView();
        userService.updateUser(user, user.getId());
        return "redirect:list";
    }

    @RequestMapping("/input")
    public String input() {
        return "user/userInput";
    }

    @RequestMapping("/add")
    public String add(User user) {
        userService.addUser(user);
        return "redirect:list";
    }
}
