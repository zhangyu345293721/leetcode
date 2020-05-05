package leetcodejava.array;

import org.junit.Test;

import java.util.HashMap;

/**
 * @author: zhangyu
 */
public class LongestSubstringWithoutRepeatingCharacters3 {


    @Test
    public void LongestSubstringWithoutRepeatingCharactersTest() {
        String s = "abcabcbb";
        int i = lengthOfLongestSubstring(s);
        System.out.println(i);
    }

    /**
     * 字符串长度
     * @param s 字符串
     * @return 长度
     */
    public int lengthOfLongestSubstring(String s) {
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
