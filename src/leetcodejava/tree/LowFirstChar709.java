package leetcodejava.tree;

import org.junit.Test;

/**
 * @author zhangyu
 **/


public class LowFirstChar709 {
    @Test
    public void testLowFirstChar() {
        String s = "ABC";
        String lowS = lowFirstChar(s);
        System.out.println(lowS);
    }

    /**
     * 将字符串变成大写开头
     *
     * @param s 字符串
     * @return 字符串
     */
    private String lowFirstChar(String s) {
        char[] chs = s.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            if (chs[i] >= 'A' && chs[i] <= 'Z') {
                chs[i] = (char) (chs[i] + ('a' - 'A'));
            }
        }
        return String.valueOf(chs);
    }
}
