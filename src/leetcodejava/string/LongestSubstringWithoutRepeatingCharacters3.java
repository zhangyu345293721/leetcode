package leetcodejava.string;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 最长无重复的字符串
 *
 * @author: zhangyu
 */
public class LongestSubstringWithoutRepeatingCharacters3 {

    @Test
    public void testPairsOfParentheses() {
        String s = "abba";
        int length = lengthOfLongestSubstring2(s);
        System.out.println(length);
    }

    /**
     * 最长字符串
     *
     * @param s 字符串
     * @return 长度
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }
        int length = s.length();
        int max_length = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length + 1; j++) {
                String sub = s.substring(i, j);
                boolean flag = judgeNoRepeat(sub);
                if (flag) {
                    max_length = Math.max(max_length, sub.length());
                }
            }
        }
        return max_length;
    }

    /**
     * 判断字符串有没有重复字符串
     *
     * @param sub 子字符串
     * @return 布尔值
     */
    private boolean judgeNoRepeat(String sub) {
        Set<Character> set = new HashSet<>();
        for (char ch : sub.toCharArray()) {
            set.add(ch);
        }
        return set.size() == sub.length();
    }

    /**
     * 最长字符串
     *
     * @param s 字符串
     * @return 长度S
     */
    public int lengthOfLongestSubstring2(String s) {
        if (s.length() == 0) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int length = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            length = Math.max(length, i - left + 1);
        }
        return length;
    }
}
