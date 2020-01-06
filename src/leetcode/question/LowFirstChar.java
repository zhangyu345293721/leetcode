package leetcode.question;

import org.junit.Test;

/**
 * @author zhangyu
 **/


public class LowFirstChar {
    @Test
    public void testLowFirstChar() {
        String s = "ABC";
        String lowS = lowFirstChar(s);
        System.out.println(lowS);
        int a = 'A';
        System.out.println(a);
    }

    /**
     * 将字符串变成大写开头
     *
     * @param s 字符串
     * @return 字符串
     */
    private String lowFirstChar(String s) {
        char[] chs = s.toCharArray();
        chs[0] = (char) (chs[0] + 32);
        return String.valueOf(chs);
    }
}
