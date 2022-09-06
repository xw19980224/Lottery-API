package com.xw.lottery.api.domain.receive.service.engine;

import com.xw.lottery.api.domain.receive.model.BehaviorMatter;

/**
 * @ClassName: Engine
 * @Author: MaxWell
 * @Description: 消息引擎接口
 * @Date: 2022/9/6 23:45
 * @Version: 1.0
 */
public interface Engine {
    /**
     * 过滤器
     *
     * @param request 入参
     * @return 出参
     * @throws Exception 异常
     */
    String process(final BehaviorMatter request) throws Exception;
}
