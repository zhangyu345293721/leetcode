package leetcodejava.tree;

import org.junit.Test;

/**
 * @author zhangyu
 **/


public class LongestPalindromicSubstring5 {
    @Test
    public void testLongestPalindromicSubstring() {
        String s = "aaab";
        String subString = longestPalindromicSubstring2(s);
        System.out.println(subString);
    }

    /**
     * 找出最大字符串
     *
     * @param s 最大字符串
     * @return 最大字符串
     */
    private static String longestPalindromicSubstring(String s) {
        String s1 = "";
        String s2 = "";
        for (int i = 0; i < s.length(); i++) {
            s1 = s1.length() >= maxSubStr(s, i, i).length() ? s1 : maxSubStr(s, i, i);
            s2 = s2.length() >= maxSubStr(s, i, i + 1).length() ? s2 : maxSubStr(s, i, i + 1);
        }
        return s1.length() >= s2.length() ? s1 : s2;
    }

    /**
     * @param s 字符串
     * @param i 位置i
     * @param j 位置j
     * @return 最大回文串
     */
    private static String maxSubStr(String s, int i, int j) {
        String maxString = "";
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            String sub = s.substring(i, j + 1);
            if (sub.length() > maxString.length()) {
                maxString = sub;
            }
            i--;
            j++;
        }
        return maxString;
    }


    /**
     * 找出最大字符串
     *
     * @param s 最大字符串
     * @return 最大字符串
     */
    private static String longestPalindromicSubstring2(String s) {
        if (s.length() <= 1) {
            return s;
        }
        String s1 = "";
        String s2 = "";
        for (int i = 0; i < s.length() - 1; i++) {
            s1 = s1.length() >= maxS(s, i, i).length() ? s1 : maxS(s, i, i);
            s2 = s2.length() >= maxS(s, i, i + 1).length() ? s2 : maxS(s, i, i + 1);
        }
        return s1.length() >= s2.length() ? s1 : s2;
    }

    /**
     * 子字符串
     *
     * @param s 字符串
     * @param i 下标i
     * @param j 下标j
     * @return 最大子字符串
     */
    private static String maxS(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return s.substring(i + 1, j);
    }
}
