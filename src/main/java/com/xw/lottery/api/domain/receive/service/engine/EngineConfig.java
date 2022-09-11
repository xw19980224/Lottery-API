package com.xw.lottery.api.domain.receive.service.engine;

import com.xw.lottery.api.domain.receive.service.logic.LogicFilter;
import com.xw.lottery.api.domain.receive.service.logic.impl.ClickLogicFilter;
import com.xw.lottery.api.domain.receive.service.logic.impl.SubscribeFilter;
import com.xw.lottery.api.domain.receive.service.logic.impl.UnsubscribeFilter;
import com.xw.lottery.api.infrastructure.common.Constants;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

import static com.xw.lottery.api.infrastructure.utils.sdk.WeChatConstant.REQ_MESSAGE_TYPE_EVENT;
import static com.xw.lottery.api.infrastructure.utils.sdk.WeChatConstant.REQ_MESSAGE_TYPE_TEXT;

/**
 * @ClassName: EngineConfig
 * @Author: MaxWell
 * @Description: 消息配置
 * @Date: 2022/9/6 23:47
 * @Version: 1.0
 */
public class EngineConfig {
    @Resource
    private LogicFilter lotteryLogicFilter;

    @Resource
    private SubscribeFilter subscribeFilter;

    @Resource
    private UnsubscribeFilter unsubscribeFilter;

    @Resource
    private ClickLogicFilter clickLogicFilter;

    protected static Map<String, Map<String, LogicFilter>> logicFilterMap = new HashMap<>();

    @PostConstruct
    public void init() {

        logicFilterMap.put(REQ_MESSAGE_TYPE_TEXT, new HashMap<String, LogicFilter>() {{
            put(Constants.MsgActionEnum.LUCKY_DRAW.getKey(), lotteryLogicFilter);
        }});

        logicFilterMap.put(REQ_MESSAGE_TYPE_EVENT, new HashMap<String, LogicFilter>() {
            {
                put("CLICK", clickLogicFilter);
                put("subscribe", subscribeFilter);
                put("unsubscribe", unsubscribeFilter);
            }
        });
    }
}
