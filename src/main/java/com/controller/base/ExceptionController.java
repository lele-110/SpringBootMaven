package com.controller.base;

import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 重写BasicErrorController,主要负责系统的异常页面的处理以及错误信息的显示
 * Created by hefule on 2016/9/2 14:48.
 */
@Controller
@RequestMapping(value = "/error")
public class ExceptionController {
    /**
     *  自定义错误页面
     *  @author hefule
     *  @date 2016/8/3 0:48
     *
     */
    @Bean
    public EmbeddedServletContainerCustomizer containerCustomizer() {

        return (container -> {
            ErrorPage error401Page = new ErrorPage(HttpStatus.UNAUTHORIZED, "/common/401.html");
            ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/common/404.html");
            ErrorPage error500Page = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/common/500.html");

            container.addErrorPages(error401Page, error404Page, error500Page);
        });
    }
}
