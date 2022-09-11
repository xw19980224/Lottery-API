package com.xw.lottery.api.domain.menu.model;

import java.util.List;

/**
 * @ClassName: SubButton
 * @Author: MaxWell
 * @Description:
 * @Date: 2022/9/10 22:54
 * @Version: 1.0
 */
public class SubButton {

    /**
     * 菜单标题，不超过16个字节，子菜单不超过60个字节
     */
    private String name;
    /**
     * 二级菜单数组，个数应为1~5个
     */
    private List<Button> sub_button;
    /**
     * 菜单的响应动作类型，view表示网页类型，click表示点击类型，miniprogram表示小程序类型
     */
    private String type;
    /**
     * 菜单 KEY 值，用于消息接口推送，不超过128字节
     * click等点击类型必须
     */
    private String key;
    /**
     * 网页 链接，用户点击菜单可打开链接，不超过1024字节。 type为 miniprogram 时，不支持小程序的老版本客户端将打开本url。
     * view、miniprogram类型必须
     */
    private String url;
    /**
     * 调用新增永久素材接口返回的合法media_id
     * media_id类型和view_limited类型必须
     */
    private String media_id;
    /**
     * 小程序的appid（仅认证公众号可配置）
     * miniprogram类型必须
     */
    private String appid;
    /**
     * 小程序的页面路径
     * miniprogram类型必须
     */
    private String pagepath;
    /**
     * 发布后获得的合法 article_id
     * article_id类型和article_view_limited类型必须
     */
    private String article_id;

    public SubButton() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Button> getSub_button() {
        return sub_button;
    }

    public void setSub_button(List<Button> sub_button) {
        this.sub_button = sub_button;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMedia_id() {
        return media_id;
    }

    public void setMedia_id(String media_id) {
        this.media_id = media_id;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getPagepath() {
        return pagepath;
    }

    public void setPagepath(String pagepath) {
        this.pagepath = pagepath;
    }

    public String getArticle_id() {
        return article_id;
    }

    public void setArticle_id(String article_id) {
        this.article_id = article_id;
    }
}
