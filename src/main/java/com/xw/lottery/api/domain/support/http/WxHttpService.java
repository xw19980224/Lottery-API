package com.xw.lottery.api.domain.support.http;

import com.google.common.base.Strings;
import com.xw.lottery.api.application.IWxTokenService;
import com.xw.lottery.api.domain.exception.LotteryException;
import com.xw.lottery.api.domain.validate.service.token.ITokenService;
import com.xw.lottery.api.infrastructure.utils.HttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName: WxHttpService
 * @Author: MaxWell
 * @Description:
 * @Date: 2022/9/11 0:28
 * @Version: 1.0
 */
@Service
public class WxHttpService {

    private final Logger logger = LoggerFactory.getLogger(WxHttpService.class);

    @Value("${wx.config.url.domain}")
    private String domain;


    /**
     * 微信HTTP Post调用封装
     */
    public String sendPostRequest(String url, String params) {
        return HttpClient.sendPostRequest(domain + url, params);
    }

    /**
     * 微信HTTP Get调用封装
     */
    public String sendGetRequest(String url, String params) {
        return HttpClient.sendGetRequest(domain + url, params);
    }
}
