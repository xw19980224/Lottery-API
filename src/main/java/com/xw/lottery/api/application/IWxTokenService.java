package com.xw.lottery.api.application;

/**
 * @ClassName: IWTokenService
 * @Author: MaxWell
 * @Description: 获取Access_Token
 * @Date: 2022/9/7 20:39
 * @Version: 1.0
 */
public interface IWxTokenService {
    /**
     * 获取Token
     *
     * @return 出惨
     * @throws Exception 异常
     */
    String getAccessToken() throws Exception;
}
