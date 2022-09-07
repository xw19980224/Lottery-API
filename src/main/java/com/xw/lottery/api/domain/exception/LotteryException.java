package com.xw.lottery.api.domain.exception;

/**
 * @ClassName: LotteryException
 * @Author: MaxWell
 * @Description: 通用异常
 * @Date: 2022/9/7 22:34
 * @Version: 1.0
 */
public class LotteryException extends RuntimeException {
    public LotteryException(String message) {
        super(message);
    }

    public LotteryException(String message, Throwable cause) {
        super(message, cause);
    }
}
