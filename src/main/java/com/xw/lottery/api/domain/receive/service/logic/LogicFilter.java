package com.xw.lottery.api.domain.receive.service.logic;

import com.xw.lottery.api.domain.receive.model.BehaviorMatter;

/**
 * @ClassName: LogicFilter
 * @Author: MaxWell
 * @Description: 逻辑接口
 * @Date: 2022/9/6 23:41
 * @Version: 1.0
 */
public interface LogicFilter {

    String filter(BehaviorMatter request);

}

