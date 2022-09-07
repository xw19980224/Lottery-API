package com.xw.lottery.api.domain.receive.service.logic.impl;

import com.xw.lottery.api.domain.receive.model.BehaviorMatter;
import com.xw.lottery.api.domain.receive.service.logic.LogicFilter;
import org.springframework.stereotype.Service;

/**
 * @ClassName: SubscribeFilter
 * @Author: MaxWell
 * @Description: 关注微信公众号
 * @Date: 2022/9/6 23:43
 * @Version: 1.0
 */
@Service("subscribe")
public class SubscribeFilter implements LogicFilter {

    @Override
    public String filter(BehaviorMatter request) {
        return "感谢关注，快来回复抽奖，参与小王的活动吧！";
    }

}

