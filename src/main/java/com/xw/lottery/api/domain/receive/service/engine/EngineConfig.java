package com.xw.lottery.api.domain.receive.service.engine;

import com.xw.lottery.api.domain.receive.service.logic.LogicFilter;
import com.xw.lottery.api.domain.receive.service.logic.impl.ActiveDirectoryLogicFilter;
import com.xw.lottery.api.domain.receive.service.logic.impl.SubscribeFilter;
import com.xw.lottery.api.domain.receive.service.logic.impl.UnsubscribeFilter;
import com.xw.lottery.api.infrastructure.common.Constants;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

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
    private ActiveDirectoryLogicFilter activeDirectoryLogicFilter;

    protected static Map<String, Map<String, LogicFilter>> logicFilterMap = new HashMap<>();

    @PostConstruct
    public void init() {

        logicFilterMap.put("text", new HashMap<String, LogicFilter>() {{
            put(Constants.MsgActionEnum.LUCKY_DRAW.getKey(), lotteryLogicFilter);
            put(Constants.MsgActionEnum.ACTIVE_DIRECTORY.getKey(), activeDirectoryLogicFilter);
        }});

        logicFilterMap.put("event", new HashMap<String, LogicFilter>() {
            {
                put("subscribe", subscribeFilter);
                put("unsubscribe", unsubscribeFilter);
            }
        });
    }
}
