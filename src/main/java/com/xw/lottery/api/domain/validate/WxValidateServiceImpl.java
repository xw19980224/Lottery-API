package com.xw.lottery.api.domain.validate;

import com.xw.lottery.api.application.IWxValidateService;
import com.xw.lottery.api.infrastructure.utils.sdk.SignatureUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @ClassName: WxValidateServiceImpl
 * @Author: MaxWell
 * @Description: 消息验证
 * @Date: 2022/9/6 23:30
 * @Version: 1.0
 */
@Service
public class WxValidateServiceImpl implements IWxValidateService {

    @Value("${wx.config.token}")
    private String token;

    @Override
    public boolean checkSign(String signature, String timestamp, String nonce) {
        return SignatureUtil.check(token, signature, timestamp, nonce);
    }

}
