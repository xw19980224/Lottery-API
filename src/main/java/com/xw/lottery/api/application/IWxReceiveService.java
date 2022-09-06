package com.xw.lottery.api.application;

import com.xw.lottery.api.domain.receive.model.BehaviorMatter;

/**
 * @ClassName: IWxReceiveService
 * @Author: MaxWell
 * @Description: 处理接收信息
 * @Date: 2022/9/6 23:24
 * @Version: 1.0
 */
public interface IWxReceiveService {
    /**
     * 接收信息
     *
     * @param behaviorMatter    入参
     * @return                  出惨
     * @throws Exception        异常
     */
    String doReceive(BehaviorMatter behaviorMatter) throws Exception;

}
