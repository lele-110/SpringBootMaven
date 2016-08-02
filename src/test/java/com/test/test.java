package com.test;

import com.ApplicationMain;
import com.service.demo.DemoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * 测试代码
 *@author hefule
 *@date 2016/8/2 13:17
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ApplicationMain.class)
@WebAppConfiguration
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
