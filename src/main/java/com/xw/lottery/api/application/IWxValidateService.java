package com.xw.lottery.api.application;

/**
 * @ClassName: IWxValidateService
 * @Author: MaxWell
 * @Description: 验证
 * @Date: 2022/9/6 23:25
 * @Version: 1.0
 */
public interface IWxValidateService {
    /**
     * 验签
     *
     * @param signature 签名
     * @param timestamp 时间
     * @param nonce     当前
     * @return 结果
     */
    boolean checkSign(String signature, String timestamp, String nonce);

}
