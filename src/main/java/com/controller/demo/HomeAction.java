package com.controller.demo;

import com.service.demo.DemoService;
import com.untils.framework.LoggerInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by hefule on 2016/7/31.
 */
@Controller
@RequestMapping("/")
public class HomeAction extends LoggerInfo<HomeAction>{
    //日志文件
    private static Logger logger = LogManager.getLogger(HomeAction.class);

    @Autowired
    private DemoService demoService;

    /**
     *   启动页
     *@author hefule
     *@date 2016/8/1 20:15
     *
     */
    @RequestMapping("/index")
    public String index(Model model) {
        try {
            model.addAttribute("name","dddd");
            model.addAttribute("demo",demoService.getUserInfo());
            Object lin = redisUtil.loadObject("userCache");
            List<Object> rr = redisUtil.loadAllKey();
            System.out.println(rr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "index";
    }


}
