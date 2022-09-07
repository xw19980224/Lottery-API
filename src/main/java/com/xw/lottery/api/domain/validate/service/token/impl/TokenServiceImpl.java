package com.xw.lottery.api.domain.validate.service.token.impl;

import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Strings;
import com.xw.lottery.api.domain.validate.service.token.ITokenService;
import com.xw.lottery.api.infrastructure.utils.HttpClient;
import com.xw.lottery.api.infrastructure.utils.RedisUtil;
import org.apache.logging.log4j.LoggingException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static com.xw.lottery.api.infrastructure.common.Constants.RedisKey;
import static com.xw.lottery.api.infrastructure.common.Constants.TokenConst;

/**
 * @ClassName: TokenBase
 * @Author: MaxWell
 * @Description: 获取微信Access_Token
 * @Date: 2022/9/7 21:29
 * @Version: 1.0
 */
@Service
public class TokenServiceImpl implements ITokenService {

    @Value("${wx.config.appid}")
    private String appId;

    @Value("${wx.config.secret}")
    private String secret;

    @Value("${wx.config.url.getToken}")
    private String targetUrl;

    private static final String GRANT_TYPE_VALUE = "client_credential";

    @Resource
    private RedisUtil redisUtil;

    @Override
    public String getAccessToken() {

        String accessToken = "";

        String key = RedisKey.KEY_LOTTERY_XW_TOKE(appId);
        // 1、获取缓存中的Access_Token
        Object accessTokenCache = redisUtil.get(key);
        if (Objects.isNull(accessTokenCache)) {
            // 2、访问微信接口，获取Access_Token
            String response = doGetAccessToken();
            // 3、解析相应结果
            accessToken = analysisAccessToken(response);
            if (Strings.isNullOrEmpty(accessToken)) {
                throw new LoggingException("获取微信公众号AccessToken失败！message:" + response);
            }
            // 4、设置缓存
            redisUtil.set(key, accessToken, 600);
        } else {
            accessToken = String.valueOf(accessTokenCache);
        }

        return accessToken;
    }


    /**
     * 调用微信接口，获取Access_Token
     *
     * @return 调用结果
     */
    protected String doGetAccessToken() {
        Map<String, String> paramsMap = new HashMap<>();
        paramsMap.put(TokenConst.GRANT_TYPE, GRANT_TYPE_VALUE);
        paramsMap.put(TokenConst.APP_ID, appId);
        paramsMap.put(TokenConst.SECRET, secret);

        String params = paramsMap.toString();

        return HttpClient.sendGetRequest(targetUrl, params);
    }

    /**
     * 解析微信获取Access_Token响应结果
     *
     * @param response
     * @return
     */
    protected String analysisAccessToken(String response) {
        JSONObject jsonObject = JSONObject.parseObject(response);
        if (!jsonObject.containsKey(TokenConst.ACCESS_TOKEN)) return "";
        else return (String) jsonObject.getOrDefault(TokenConst.ACCESS_TOKEN, "");
    }
}
