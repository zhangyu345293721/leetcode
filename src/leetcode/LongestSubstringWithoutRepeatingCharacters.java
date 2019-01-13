package leetcode;

import org.junit.Test;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author zhangyu
 * @version V1.0
 * @ClassName: LongestSubstringWithoutRepeatingCharacters
 * @Description: 找出一个字符串中最大的无重复子字符串
 * @date 2018/11/30 10:57
 **/


public class LongestSubstringWithoutRepeatingCharacters {
    @Test
    public void fun() {
        // String s = "abcdabcbb";
        String s = "pwwkew";
        int num = longestSubstringWithoutRepeatingCharacters(s);
        System.out.println(num);
    }

    // 找出最大没有重复的子字符串
    private int longestSubstringWithoutRepeatingCharacters(String s) {
        char[] chs = s.toCharArray();
        int index = 0;
        int maxLength = 0;
        for (int i = index; i <= chs.length; i++) {
            String subString = s.substring(index, i);
            if (isAppearsOnce2(subString)) {
                if (maxLength < subString.length()) {
                    maxLength = subString.length();
                }
            } else {
                // 如果出现了重复的子字符串，就index加1,加上下一个
                index = index + 1;
            }
        }
        return maxLength;
    }

    // 利用map的方式，判断有没有重复的字符
    private boolean isAppearsOnce(String subString) {
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

    // 利用set集合的方式判断是否有重复的字符
    private boolean isAppearsOnce2(String subString) {
        char[] chs = subString.toCharArray();
        Set<Character> set = new HashSet<>();
        for (char ch : chs) {
            if(set.contains(ch)){
                return false;
            }else{
                set.add(ch);
            }
        }
        return true;
     }
}
