package com.controller.demo;

import com.model.demo.Demo;
import com.service.demo.DemoService;
import com.untils.framework.LoggerInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by hefule on 2016/7/31.
 */
@Controller
@RequestMapping("/")
public class HomeAction extends LoggerInfo<HomeAction>{

    @Autowired
    private DemoService demoService;

    /**
     *   启动页
     *@author hefule
     *@date 2016/8/1 20:15
     *
     */
    @RequestMapping("/index")
    //@ResponseBody  如果需要返回json则添加
    public String index(Model model) {
        try {
            model.addAttribute("name","dddd");
            model.addAttribute("demo",demoService.getUserInfo());
            Demo demo3 = (Demo) redisUtil.loadObject("getUserInfo");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "index";
    }

    /**
     *  自定义错误页面
     *  @author hefule
     *  @date 2016/8/3 0:48
     *
     */
    @Bean
    public EmbeddedServletContainerCustomizer containerCustomizer() {

        return (container -> {
          /*  ErrorPage error401Page = new ErrorPage(HttpStatus.UNAUTHORIZED, "/401.html");
            ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/404.html");
            ErrorPage error500Page = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/500.html");

            container.addErrorPages(error401Page, error404Page, error500Page);*/
        });
    }
}
