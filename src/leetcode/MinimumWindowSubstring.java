package leetcode;

import org.junit.Test;

/**
 * @author zhangyu
 * @version V1.0
 * @ClassName: MinimumWindowSubstring
 * @Description: TOTO
 * @date 2018/12/25 20:39
 **/


public class MinimumWindowSubstring {
    @Test
    public void fun() {
        String S = "ADOBECODEBANC";
        String T = "ABC";
        String sub = minimumWindowSubstring(S, T);
        System.out.println(sub);
    }

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
