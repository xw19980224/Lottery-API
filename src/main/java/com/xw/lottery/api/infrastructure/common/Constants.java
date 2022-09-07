package com.xw.lottery.api.infrastructure.common;

/**
 * @ClassName: Constants
 * @Author: MaxWell
 * @Description: 通用类
 * @Date: 2022/9/6 23:31
 * @Version: 1.0
 */
public class Constants {

    /**
     * 获取Access_Token常量类
     */
    public static final class TokenConst {
        /**
         * 获取access_token填写client_credential
         */
        public static final String GRANT_TYPE = "grant_type";
        /**
         * 第三方用户唯一凭证
         */
        public static final String APP_ID = "appid";
        /**
         * 第三方用户唯一凭证密钥，即appsecret
         */
        public static final String SECRET = "secret";

        /**
         * 访问令牌
         */
        public static final String ACCESS_TOKEN = "access_token";
    }

    /**
     * 缓存 Key
     */
    public static final class RedisKey {
        private static final String LOTTERY_XW_TOKEN = "lottery_wx_token_";

        public static String KEY_LOTTERY_XW_TOKE(String appId) {
            return LOTTERY_XW_TOKEN + appId;
        }
    }
}