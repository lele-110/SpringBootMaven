package com.test;

import com.baseTest.BaseTest;
import com.model.baseUser.BaseUserBean;
import com.service.baseuser.BaseUserService;
import com.service.demo.DemoService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 测试代码样例
 *@author hefule
 *@date 2016/8/2 13:17
 *
 */
public class test extends BaseTest {

    @Autowired
    private DemoService userService;

    @Autowired
    private BaseUserService baseUserService;

    @Test
    public void first(){
        try {
           // System.out.println(userService.getUserInfo());
            System.out.println(baseUserService.loadModeForAll(new BaseUserBean()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
