package leetcodejava.string;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * This is the solution of No.3 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class LongestSubstringWithoutRepeatingCharacters3 {

    @Test
    public void pairsOfParenthesesTest() {
        String s = "abba";
        int length = lengthOfLongestSubstring2(s);
        System.out.println(length);
        Assert.assertEquals(length, 2);
    }

    /**
     * 最长无重复字符串
     *
     * @param s 字符串
     * @return 长度
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }
        int length = s.length();
        int maxLength = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length + 1; j++) {
                String sub = s.substring(i, j);
                boolean flag = judgeNoRepeat(sub);
                if (flag) {
                    maxLength = Math.max(maxLength, sub.length());
                }
            }
        }
        return maxLength;
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
     * 最长子字符串
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
