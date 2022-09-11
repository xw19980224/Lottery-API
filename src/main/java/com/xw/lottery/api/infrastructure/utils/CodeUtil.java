package com.xw.lottery.api.infrastructure.utils;

import java.util.Random;

/**
 * @ClassName: CodeUtil
 * @Author: MaxWell
 * @Description:
 * @Date: 2022/9/12 0:55
 * @Version: 1.0
 */
public class CodeUtil {

    public static final String NUMBER = "0123456789";
    public static final String LOWER_CASE = "abcdefghijklmnopqrstuvwxyz";
    public static final String CAPITAL_LETTER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static String GetRandomCode(int intLength) {

        String chars = NUMBER + LOWER_CASE + CAPITAL_LETTER;
        char[] rands = new char[intLength];
        for (int i = 0; i < intLength; i++) {
            int rand = (int) (Math.random() * (10 + 26 * 2));
            rands[i] = chars.charAt(rand);
        }
        return String.valueOf(rands);

    }
}
