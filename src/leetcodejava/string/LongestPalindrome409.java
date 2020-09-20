package leetcodejava.string;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * This is the solution of No.409 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/longest-palindrome
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 *
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 *
 * 注意:
 * 假设字符串的长度不会超过 1010。
 *
 * 示例 1:
 * 输入:
 * "abccccdd"
 *
 * 输出:
 * 7
 *
 * 解释:
 * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class LongestPalindrome409 {

    @Test
    public void longestPalindromeTest() {
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

