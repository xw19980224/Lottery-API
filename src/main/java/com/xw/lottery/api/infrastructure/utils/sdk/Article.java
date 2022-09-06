package com.xw.lottery.api.infrastructure.utils.sdk;

/**
 * @ClassName: Article
 * @Author: MaxWell
 * @Description:
 * @Date: 2022/9/6 23:36
 * @Version: 1.0
 */
public class Article {
    private String title;
    private String description;
    private String picUrl;
    private String url;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
