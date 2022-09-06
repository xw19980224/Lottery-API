package com.xw.lottery.api.domain.receive;

import com.xw.lottery.api.application.IWxReceiveService;
import com.xw.lottery.api.domain.receive.model.BehaviorMatter;
import com.xw.lottery.api.domain.receive.service.engine.Engine;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName: WxReceiveServiceImpl
 * @Author: MaxWell
 * @Description:
 * @Date: 2022/9/6 23:41
 * @Version: 1.0
 */
@Service
public class WxReceiveServiceImpl implements IWxReceiveService {

    @Resource(name = "msgEngineHandle")
    private Engine msgEngineHandle;

    @Override
    public String doReceive(BehaviorMatter behaviorMatter) throws Exception {
        return msgEngineHandle.process(behaviorMatter);
    }

}
