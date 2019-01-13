package leetcode;

import org.junit.Test;

/**
 * @author zhangyu
 * @version V1.0
 * @ClassName: LongestPalindromicSubstring
 * @Description: TOTO
 * @date 2018/11/29 19:12
 **/


public class LongestPalindromicSubstring {
    @Test
    public void fun() {
        String s = "aaab";
        String subString = longestPalindromicSubstring(s);
        System.out.println(subString);
    }

    private static  String longestPalindromicSubstring(String s) {
        String s1 = "";
        String s2 = "";
        for (int i = 0; i < s.length(); i++) {
            s1 = s1.length() >= maxS(s, i, i).length() ? s1 : maxS(s, i, i);
            s2 = s2.length() >= maxS(s, i, i + 1).length() ? s2 : maxS(s, i, i + 1);
        }
        return s1.length() >= s2.length() ? s1 : s2;
    }

    private static String maxS(String s, int i, int j) {
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
