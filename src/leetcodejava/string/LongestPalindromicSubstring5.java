package leetcodejava.string;

import org.junit.Assert;
import org.junit.Test;

/**
 * This is the solution of No. 5 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/longest-palindromic-substring
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * <p>
 * 示例 2：
 * 输入: "cbbd"
 * 输出: "bb"
 * <p>
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class LongestPalindromicSubstring5 {
    @Test
    public void longestPalindromicSubstringTest() {
        String s = "aba";
        String result = longestPalindromicSubstring1(s);
        System.out.println(result);
        Assert.assertEquals(result, "aba");
    }

    /**
     * 找出最大子回文串
     *
     * @param s 主符串
     * @return 最大字回文串
     */
    private String longestPalindromicSubstring1(String s) {
        if (s.length() <= 1) {
            return s;
        }
        String s1 = "";
        String s2 = "";
        for (int i = 0; i < s.length() - 1; i++) {
            String maxS1 = maxStr(s, i, i);
            String maxS2 = maxStr(s, i, i + 1);
            s1 = s1.length() >= maxS1.length() ? s1 : maxS1;
            s2 = s2.length() >= maxS2.length() ? s2 : maxS2;
        }
        return s1.length() >= s2.length() ? s1 : s2;
    }

    /**
     * 每次都会找到最大子回文串
     *
     * @param s 字符串
     * @param i 下标i
     * @param j 下标j
     * @return 最大子回文串
     */
    private String maxStr(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return s.substring(i + 1, j);
    }
}
