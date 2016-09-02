package com.controller.admin.index;

import com.service.demo.DemoService;
import com.untils.framework.LoggerInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.io.Serializable;

/**
 * Created by hefule on 2016/7/31.
 */
@Controller
@RequestMapping("/admin")
public class AdminHomeAction extends LoggerInfo<AdminHomeAction,Serializable> {

    @Resource(name = "demoService")
    private DemoService demoService;
    /**
     *后台启动页
     *@author hefule
     *@date 2016/8/1 20:15
     *
     */
    @RequestMapping("/index")
    //@ResponseBody  如果需要返回json则添加
    public String index(Model model) {
        try {
           model.addAttribute("basePath",redisUtil.loadObject("realPath"));
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
        }
        return "index";
    }
}
