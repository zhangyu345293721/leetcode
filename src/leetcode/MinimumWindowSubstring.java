package leetcode;

import org.junit.Test;

/**
 * @author zhangyu
 **/


public class MinimumWindowSubstring {
    @Test
    public void testMinimumWindowSubstring() {
        String S = "ADOBECODEBANC";
        String T = "ABC";
        String sub = minimumWindowSubstring(S, T);
        System.out.println(sub);
    }

    /**
     * @param s 字符串s
     * @param t 字符串t
     * @return 最小窗口字符串
     */
    private String minimumWindowSubstring(String s, String t) {
        String minString = s;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String sub = s.substring(i, j);
                if (containsString(sub, t)) {
                    if (sub.length() < minString.length()) {
                        minString = sub;
                    }
                }
            }
        }
        return minString;
    }

    /**
     * 子字符串
     *
     * @param s         字符串
     * @param subString 子字符串
     * @return 布尔值
     */
    public boolean containsString(String s, String subString) {
        char[] chs = subString.toCharArray();
        for (char ch : chs) {
            if (!s.contains(String.valueOf(ch))) {
                return false;
            }
        }
        return true;
    }
}
