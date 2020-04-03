package leetcodejava.string;

import org.junit.Test;

/**
 * 字符串变成数字
 *
 * @author: zhangyu
 */
public class StringInteger8 {
    @Test
    public void testStringInteger() {
        String str = "  -0012a42";
        int i = myAtoi(str);
        System.out.println(i);
    }

    /**
     * 字符串转成数字，
     *
     * @param str 字符串
     * @return 数字
     */
    public int myAtoi(String str) {
        String strs = str.trim();
        if (strs == null || strs.length() < 1) {
            return 0;
        }
        int flag = 0;
        int i = 0;
        int result = 0;
        if (strs.charAt(i) == '-') {
            i++;
            flag = -1;
        } else if (strs.charAt(i) == '+') {
            i++;
            flag = 1;
        } else if (strs.charAt(i) < '0' || strs.charAt(i) > '9') {
            return 0;
        }
        for (; i < strs.length(); i++) {
            char ch = strs.charAt(i);
            if (ch <= '9' && ch >= '0') {
                int num = ch - '0';
                if (result > (Integer.MAX_VALUE - num) / 10) {
                    return flag < 0 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
                result = 10 * result + num;
            } else {
                return flag < 0 ? -result : result;
            }
        }
        return flag < 0 ? -result : result;
    }
}
