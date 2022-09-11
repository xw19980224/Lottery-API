package com.xw.lottery.api.infrastructure.common;

/**
 * @ClassName: Constants
 * @Author: MaxWell
 * @Description: 通用类
 * @Date: 2022/9/6 23:31
 * @Version: 1.0
 */
public class Constants {

    public static final String WX_SUCCESS_CODE = "0";

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

    /**
     * 消息关键字
     */
    public enum MsgActionEnum {

        ACTIVE_DIRECTORY("活动目录", "activeDirectory"),
        LUCKY_DRAW("抽奖", "lottery");

        private final String msg;
        private final String key;

        MsgActionEnum(String msg, String key) {
            this.msg = msg;
            this.key = key;
        }

        public String getMsg() {
            return msg;
        }

        public String getKey() {
            return key;
        }

        public static String getKey(String msg) {
            for (MsgActionEnum msgActionEnum : MsgActionEnum.values()) {
                if (msgActionEnum.getMsg().equals(msg)) {
                    return msgActionEnum.getKey();
                }
            }
            return null;
        }
    }

    /**
     * 按钮类型
     */
    public static final class ButtonType{
        public static final String CLICK = "click";
        public static final String VIEW = "view";
        public static final String SCANCODE_PUSH= "scancode_push";
        public static final String SCANCODE_WAITMSG = "scancode_waitmsg";
        public static final String PIC_SYSPHOTO = "pic_sysphoto";
        public static final String PIC_PHOTO_OR_ALBUM = "pic_photo_or_album";
        public static final String PIC_WEIXIN= "pic_weixin";
        public static final String LOCATION_SELECT = "location_select";
        public static final String MEDIA_ID = "media_id";
        public static final String ARTICLE_ID = "article_id";
        public static final String ARTICLE_VIEW_LIMITED = "article_view_limited";
    }
}