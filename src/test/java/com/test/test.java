package com.test;

import com.service.demo.DemoService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 测试代码
 *@author hefule
 *@date 2016/8/2 13:17
 *
 */

public class test {

    @Autowired
    private DemoService userService;

    @Test
    public void first(){

        try {
            System.out.println(userService.getUserInfo());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
