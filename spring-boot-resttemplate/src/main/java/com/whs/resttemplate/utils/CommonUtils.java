package com.whs.resttemplate.utils;

import java.util.Random;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-03-16 16:43
 */
public class CommonUtils{

    /**
     * 非空判断
     */
    public static boolean isNotBlank(CharSequence cs) {
        return !isBlank(cs);
    }
    public static boolean isBlank(CharSequence cs) {
        int strLen;
        if(cs != null && (strLen = cs.length()) != 0) {
            for(int i = 0; i < strLen; ++i) {
                if(!Character.isWhitespace(cs.charAt(i))) {
                    return false;
                }
            }

            return true;
        } else {
            return true;
        }
    }



    /**
     * 获取随机位数的字符串
     */
    public static String getRandomString(int length) {
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }


}
