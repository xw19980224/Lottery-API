package com.xw.lottery.api.domain.receive.service.logic.impl;

import com.xw.lottery.api.domain.receive.model.BehaviorMatter;
import com.xw.lottery.api.domain.receive.service.logic.LogicFilter;
import com.xw.lottery.rpc.activity.booth.ILotteryActivityBooth;
import com.xw.lottery.rpc.activity.booth.dto.AwardDTO;
import com.xw.lottery.rpc.activity.booth.req.DrawReq;
import com.xw.lottery.rpc.activity.booth.res.DrawRes;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;

/**
 * @ClassName: LotteryLogicFilter
 * @Author: MaxWell
 * @Description:
 * @Date: 2022/9/6 23:03
 * @Version: 1.0
 */
@Service
public class LotteryLogicFilter implements LogicFilter {

    @DubboReference
    private ILotteryActivityBooth lotteryActivityBooth;

    @Override
    public String filter(BehaviorMatter request) {

        DrawReq drawReq = new DrawReq();
        drawReq.setuId(request.getOpenId().substring(1, 11));
        drawReq.setActivityId(100001L);

        DrawRes drawRes = lotteryActivityBooth.doDraw(drawReq);
        AwardDTO awardDTO = drawRes.getAwardDTO();

        if (!"0000".equals(drawRes.getCode())) {
            return "抽奖💐 提示：" + drawRes.getInfo();
        }

        return "恭喜💐 您已中奖：" + awardDTO.getAwardName() + " - Lottery 抽奖系统";
    }


}
