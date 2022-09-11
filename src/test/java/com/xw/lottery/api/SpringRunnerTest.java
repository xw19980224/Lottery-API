package com.xw.lottery.api;

import com.xw.lottery.api.application.IWxMenuService;
import com.xw.lottery.api.application.IWxTokenService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @ClassName: SpringRunnerTest
 * @Author: MaxWell
 * @Description:
 * @Date: 2022/9/7 21:06
 * @Version: 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = LotteryApiApplication.class)
public class SpringRunnerTest {

    private Logger logger = LoggerFactory.getLogger(SpringRunnerTest.class);

    @Resource
    private IWxMenuService wxMenuService;

    @Resource
    private IWxTokenService wxTokenService;

    @Test
    public void test_drawExec() {
        wxMenuService.createMenu();
    }

    @Test
    public void test_token() throws Exception {
        String accessToken = wxTokenService.getAccessToken();
        System.out.println(accessToken);
    }
}
