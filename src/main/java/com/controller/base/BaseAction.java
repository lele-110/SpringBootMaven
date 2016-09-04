package com.controller.base;

import com.untils.framework.LoggerInfo;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.Serializable;

/**
 * 基础action公用类
 * Created by hefule on 2016/9/2 14:33.
 */
@Configuration
@Controller
public class BaseAction extends LoggerInfo<BaseAction,Serializable> {

    @RequestMapping("/")
    public String index(){
       return "forward:/admin/index.html";
    }
}
