package com.xw.lottery.api.domain.validate;

import com.xw.lottery.api.application.IWxTokenService;
import com.xw.lottery.api.domain.validate.service.token.ITokenService;
import com.xw.lottery.api.infrastructure.utils.HttpClient;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

import static com.xw.lottery.api.infrastructure.common.Constants.*;

/**
 * @ClassName: WxTokenSerivceImpl
 * @Author: MaxWell
 * @Description: 获取Access_Token
 * @Date: 2022/9/7 20:41
 * @Version: 1.0
 */
@Service
public class WxTokenServiceImpl implements IWxTokenService {

    @Resource
    ITokenService tokenService;

    @Override
    public String getAccessToken() throws Exception {
        return tokenService.getAccessToken();
    }
}
