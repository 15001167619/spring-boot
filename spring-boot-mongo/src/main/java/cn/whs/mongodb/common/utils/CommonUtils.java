package cn.whs.mongodb.common.utils;

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
}
