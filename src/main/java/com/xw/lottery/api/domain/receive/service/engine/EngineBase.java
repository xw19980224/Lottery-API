package com.xw.lottery.api.domain.receive.service.engine;

import com.google.common.base.Strings;
import com.xw.lottery.api.domain.receive.model.BehaviorMatter;
import com.xw.lottery.api.domain.receive.service.logic.LogicFilter;
import com.xw.lottery.api.infrastructure.common.Constants;

import java.util.Map;

import static com.xw.lottery.api.infrastructure.utils.sdk.WeChatConstant.*;

/**
 * @ClassName: EngineBase
 * @Author: MaxWell
 * @Description: 引擎基类
 * @Date: 2022/9/6 23:48
 * @Version: 1.0
 */
public class EngineBase extends EngineConfig implements Engine {

    @Override
    public String process(BehaviorMatter request) throws Exception {
        throw new RuntimeException("未实现消息引擎服务");
    }

    /**
     * 消息类型&业务内容路由器
     *
     * @param request 消息内容
     * @return 返回消息处理器
     */
    protected LogicFilter router(BehaviorMatter request) {

        Map<String, LogicFilter> logicGroup = logicFilterMap.get(request.getMsgType());

        // 事件处理
        if (REQ_MESSAGE_TYPE_EVENT.equals(request.getMsgType())) {
            return logicGroup.get(request.getEvent());
        }

        // 内容处理
        if (REQ_MESSAGE_TYPE_TEXT.equals(request.getMsgType())) {
            String key = Constants.MsgActionEnum.getKey(request.getContent());
            return logicGroup.get(key);
        }

        return null;
    }

}

