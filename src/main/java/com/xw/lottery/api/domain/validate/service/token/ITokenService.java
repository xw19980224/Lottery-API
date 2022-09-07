package com.xw.lottery.api.domain.validate.service.token;

/**
 * @ClassName: Token
 * @Author: MaxWell
 * @Description: 获取AccessToken
 * @Date: 2022/9/7 21:25
 * @Version: 1.0
 */
public interface ITokenService {
    String getAccessToken() throws Exception;
}
