package com.xw.lottery.api.domain.receive.service.engine.impl;

import com.xw.lottery.api.domain.receive.model.BehaviorMatter;
import com.xw.lottery.api.domain.receive.model.MessageTextEntity;
import com.xw.lottery.api.domain.receive.service.engine.EngineBase;
import com.xw.lottery.api.domain.receive.service.logic.LogicFilter;
import com.xw.lottery.api.infrastructure.utils.XmlUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @ClassName: MsgEngineHandle
 * @Author: MaxWell
 * @Description: 消息处理
 * @Date: 2022/9/6 23:48
 * @Version: 1.0
 */
@Service("msgEngineHandle")
public class MsgEngineHandle extends EngineBase {

    @Value("${wx.config.originalid:gh_95b2229b90fb}")
    private String originalId;

    @Override
    public String process(BehaviorMatter request) throws Exception {
        LogicFilter router = super.router(request);
        if (null == router) {
            return null;
        }
        String resultStr = router.filter(request);
        if (StringUtils.isBlank(resultStr)) {
            return "";
        }

        //反馈信息[文本]
        MessageTextEntity res = new MessageTextEntity();
        res.setToUserName(request.getOpenId());
        res.setFromUserName(originalId);
        res.setCreateTime(String.valueOf(System.currentTimeMillis() / 1000L));
        res.setMsgType("text");
        res.setContent(resultStr);
        return XmlUtil.beanToXml(res);
    }

}