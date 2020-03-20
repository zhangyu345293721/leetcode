package leetcodejava.string;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 可以构造最长回文串
 *
 * @author: zhangyu
 */
public class LongestPalindrome409 {

    @Test
    public void testLongestPalindrome() {
        String s = "bb";
        int num = longestPalindrome(s);
        System.out.println(num);
    }


    /**
     * 计算最长回文串
     *
     * @param s 字符串s
     * @return 回文串长度
     */
    public int longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s.length();
        }
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int length = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if ((entry.getValue() & 1) == 1) {
                length += entry.getValue() - 1;
            } else {
                length += entry.getValue();
            }
        }
        return length < s.length() ? length + 1 : length;
    }

    /**
     * 计算最长回文串
     *
     * @param s 字符串s
     * @return 回文串长度
     */
    public int longestPalindrome2(String s) {
        if (s == null) {
            return 0;
        }
        int[] counts = new int[128];
        int len = 0;
        for (char c : s.toCharArray()) {
            if ((++counts[c] & 1) == 0) {
                len += 2;
            }
        }
        return len < s.length() ? len + 1 : len;
    }
}

