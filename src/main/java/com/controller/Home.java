package com.controller;

import com.service.user.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by hefule on 2016/7/31.
 */
@Controller
@RequestMapping("/")
public class Home {
    //日志文件
    private static Logger logger = LogManager.getLogger(Home.class);

    @Autowired
    private UserService userService;

    /**
     *   启动页
     *@author hefule
     *@date 2016/8/1 20:15
     *
     */
    @RequestMapping("/index")
    public String index(Model model) {
        model.addAttribute("name","dddd");
        try {
            model.addAttribute("user",userService.findUserInfo());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "index";
    }

}
