package com.xw.lottery.api;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.ImmutableMap;
import com.xw.lottery.api.application.IWxTokenService;
import com.xw.lottery.api.infrastructure.utils.CodeUtil;
import com.xw.lottery.api.infrastructure.utils.HttpClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @ClassName: SendTemplateTest
 * @Author: MaxWell
 * @Description:
 * @Date: 2022/9/12 1:17
 * @Version: 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = LotteryApiApplication.class)
public class SendTemplateTest {

    public static final String templateId = "8XKz0OIjOZS1fEW2kIF1Al5eESgOvr2M8INy1ADFp7s";
    public static final String touser = "oDZO45qwR2d4KnuYgL7wNYWNL0dQ";
    public static final String address = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=";


    @Resource
    private IWxTokenService wxTokenService;

    @Test
    public void sendTest() throws Exception {
        String accessToken = wxTokenService.getAccessToken();
        System.out.println(accessToken);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("touser", touser);
        jsonObject.put("template_id", templateId);
        jsonObject.put("topcolor", "#FF0000");

        JSONObject data = new JSONObject();
        data.put("title", ImmutableMap.of("value","中秋大礼","color","#173177"));
        data.put("name", ImmutableMap.of("value","中秋大礼","color","#173177"));
        data.put("desc", ImmutableMap.of("value","中秋大礼描述","color","#173177"));
        data.put("count", ImmutableMap.of("value","10","color","#173177"));
        data.put("leftCount", ImmutableMap.of("value","10","color","#173177"));
        data.put("code", ImmutableMap.of("value", CodeUtil.GetRandomCode(6),"color","#173177"));

        jsonObject.put("data", data);


        String params = jsonObject.toJSONString();
        String response = HttpClient.sendPostRequest(address + accessToken, params);
        System.out.println(response);

    }

}
