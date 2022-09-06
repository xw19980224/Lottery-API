package com.xw.lottery.api.domain.lucky.model;

/**
 * @ClassName: Strategy
 * @Author: MaxWell
 * @Description: 策略
 * @Date: 2022/9/6 23:27
 * @Version: 1.0
 */
public class Strategy {
    private String text;
    private String top;

    public Strategy(String text, String top) {
        this.text = text;
        this.top = top;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTop() {
        return top;
    }

    public void setTop(String top) {
        this.top = top;
    }
}
