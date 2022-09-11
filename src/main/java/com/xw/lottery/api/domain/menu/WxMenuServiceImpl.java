package com.xw.lottery.api.domain.menu;

import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Strings;
import com.xw.lottery.api.application.IWxMenuService;
import com.xw.lottery.api.application.IWxTokenService;
import com.xw.lottery.api.domain.exception.LotteryException;
import com.xw.lottery.api.domain.menu.model.Button;
import com.xw.lottery.api.domain.menu.model.SubButton;
import com.xw.lottery.api.domain.support.http.WxHttpService;
import com.xw.lottery.api.infrastructure.common.Constants;
import com.xw.lottery.api.infrastructure.common.XwResponse;
import com.xw.lottery.api.infrastructure.utils.HttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import static com.xw.lottery.api.infrastructure.common.Constants.*;

/**
 * @ClassName: WxMenuServicelmpl
 * @Author: MaxWell
 * @Description: 创建菜单接口服务层
 * @Date: 2022/9/10 23:17
 * @Version: 1.0
 */
@Service
public class WxMenuServiceImpl implements IWxMenuService {

    private final Logger logger = LoggerFactory.getLogger(WxMenuServiceImpl.class);

    @Resource
    private WxHttpService wxMenuService;

    @Resource
    private IWxTokenService wxTokenService;

    @Value("${wx.config.url.address.createMenu}")
    private String targetUrl;

    @Override
    public void createMenu() {

        // 1、 构建参数
        Button button = BuildMenuParam();
        String params = JSONObject.toJSONString(button);

        // 2、发送请求
        String response = "";
        try {
            response = sentCreateMenuRequestToWx(params);
            XwResponse xwResponse = JSONObject.parseObject(response, XwResponse.class);
            if (!xwResponse.getErrcode().equals(Constants.WX_SUCCESS_CODE)) {
                logger.error("微信接口调用失败：response:{}", response);
            } else {
                logger.info("微信接口调用成功：response:{}", response);
            }

        } catch (Exception e) {
            logger.error(e.getMessage());
        }

    }

    /**
     * 请求参数
     *
     * @param params
     */
    private String sentCreateMenuRequestToWx(String params) throws Exception {
        String accessToke = wxTokenService.getAccessToken();
        if (Strings.isNullOrEmpty(accessToke))
            throw new LotteryException("sendPostRequestNeedToken 获取accessToken 获取失败");
        return wxMenuService.sendPostRequest(targetUrl + "?access_token=" + accessToke, params);
    }

    private Button BuildMenuParam() {
        Button button = new Button();
        SubButton subButton = new SubButton();
        subButton.setName(MsgActionEnum.ACTIVE_DIRECTORY.getMsg());
        subButton.setType(ButtonType.CLICK);
        subButton.setKey(MsgActionEnum.ACTIVE_DIRECTORY.getKey());
        button.add(subButton);
        return button;
    }
}
