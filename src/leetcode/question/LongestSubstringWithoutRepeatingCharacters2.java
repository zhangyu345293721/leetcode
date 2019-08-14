package leetcode.question;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author zhangyu
 * @version V1.0
 * @ClassName: LongestSubstringWithoutRepeatingCharacters
 * @Description: 最简单，最直接的一种暴力算法
 * @date 2018/11/30 10:57
 **/


public class LongestSubstringWithoutRepeatingCharacters2 {
    @Test
    public void fun() {
        String s = "abcdabcbb";
        // String s = "pwwkew";
        int num = longestSubstringWithoutRepeatingCharacters(s);
        System.out.println(num);
    }

    // 找出最大没有重复的子字符串
    private int longestSubstringWithoutRepeatingCharacters(String s) {
        char[] chs = s.toCharArray();
        int maxLength = 0;
        // 利用暴力算法进行计算
        for (int i = 0; i < chs.length; i++) {
            for (int j = i + 1; j <= chs.length; j++) {
                String subString = s.substring(i, j);
                if (isAppearOnce(subString)) {
                    if (maxLength < subString.length()) {
                        maxLength = subString.length();
                    }
                }
            }
        }
        return maxLength;
    }

    // 利用map的方式，判断有没有重复的字符
    private boolean isAppearOnce(String subString) {
        char[] chs = subString.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : chs) {
            if (!map.containsKey(ch)) {
                map.put(ch, 1);
            } else {
                return false;
            }
        }
        return true;
    }
}
