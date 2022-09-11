package com.xw.lottery.api.infrastructure.common;

/**
 * @ClassName: XwResponse
 * @Author: MaxWell
 * @Description: 微信响应结果
 * @Date: 2022/9/11 0:53
 * @Version: 1.0
 */
public class XwResponse {
    /**
     * 相应状态码
     */
    private String errcode;
    /**
     * 相应描述
     */
    private String errmsg;

    public XwResponse() {
    }

    public XwResponse(String errcode, String errmsg) {
        this.errcode = errcode;
        this.errmsg = errmsg;
    }

    public String getErrcode() {
        return errcode;
    }

    public void setErrcode(String errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }
}
