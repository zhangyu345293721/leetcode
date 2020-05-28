package leetcodejava.tree;

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
        String subString = longestPalindromicSubstring3(s);
        System.out.println(subString);
    }

    /**
     * 找出最大字符串
     *
     * @param s 最大字符串
     * @return 最大字符串
     */
    private static String longestPalindromicSubstring(String s) {
        String s1 = "";
        String s2 = "";
        for (int i = 0; i < s.length(); i++) {
            s1 = s1.length() >= maxSubStr(s, i, i).length() ? s1 : maxSubStr(s, i, i);
            s2 = s2.length() >= maxSubStr(s, i, i + 1).length() ? s2 : maxSubStr(s, i, i + 1);
        }
        return s1.length() >= s2.length() ? s1 : s2;
    }

    /**
     * @param s 字符串
     * @param i 位置i
     * @param j 位置j
     * @return 最大回文串
     */
    private static String maxSubStr(String s, int i, int j) {
        String maxString = "";
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            String sub = s.substring(i, j + 1);
            if (sub.length() > maxString.length()) {
                maxString = sub;
            }
            i--;
            j++;
        }
        return maxString;
    }


    /**
     * 找出最大字符串
     *
     * @param s 最大字符串
     * @return 最大字符串
     */
    private static String longestPalindromicSubstring2(String s) {
        if (s.length() <= 1) {
            return s;
        }
        String s1 = "";
        String s2 = "";
        for (int i = 0; i < s.length() - 1; i++) {
            s1 = s1.length() >= maxS(s, i, i).length() ? s1 : maxS(s, i, i);
            s2 = s2.length() >= maxS(s, i, i + 1).length() ? s2 : maxS(s, i, i + 1);
        }
        return s1.length() >= s2.length() ? s1 : s2;
    }

    /**
     * 子字符串
     *
     * @param s 字符串
     * @param i 下标i
     * @param j 下标j
     * @return 最大子字符串
     */
    private static String maxS(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return s.substring(i + 1, j);
    }

    /**
     * brute force
     *
     * @param s 最大字符串
     * @return 最大字符串
     */
    private static String longestPalindromicSubstring3(String s) {
        String maxStr = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length() + 1; j++) {
                String sub = s.substring(i, j);
                boolean flag = isPalindromicSubstring(sub);
                if (flag) {
                    if (maxStr.length() < sub.length()) {
                        maxStr = sub;
                    }
                }
            }
        }
        return maxStr;
    }

    /**
     * 判断一个字符串是回文串
     *
     * @param sub 字符串
     * @return 布尔值
     */
    private static boolean isPalindromicSubstring(String sub) {
        if (sub == null || sub.length() < 1) {
            return true;
        }
        int i = 0;
        int j = sub.length() - 1;
        while (i < j) {
            if (sub.charAt(i) == sub.charAt(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }
}
