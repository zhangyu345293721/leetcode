package leetcode.question.traversebinarytree;

import org.junit.Test;

/**
 * @author zhangyu
 **/


public class LongestPalindromicSubstring {
    @Test
    public void testLongestPalindromicSubstring() {
        String s = "aaab";
        String subString = longestPalindromicSubstring(s);
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
}
