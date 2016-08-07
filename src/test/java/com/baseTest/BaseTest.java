package com.baseTest;

import com.ApplicationMain;
import com.untils.framework.LoggerInfo;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * 测试代码基本类
 *@author hefule
 *@date 2016/8/2 13:17
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ApplicationMain.class)
@WebAppConfiguration
public class BaseTest extends LoggerInfo<BaseTest>{}
