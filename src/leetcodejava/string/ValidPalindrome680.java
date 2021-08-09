package leetcodejava.string;

import org.junit.Assert;
import org.junit.Test;

/**
 * This is the solution of No.680 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/valid-palindrome-ii
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "aba"
 * 输出: True
 * 示例 2:
 * <p>
 * 输入: "abca"
 * 输出: True
 * 解释: 你可以删除c字符。
 * 注意:
 * <p>
 * 字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。
 * <p>
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class ValidPalindrome680 {

    @Test
    public void validPalindromeTest() {
        String str = "aba";
        boolean result = validPalindrome(str);
        System.out.println(result);
        Assert.assertEquals(result, true);
    }

    /**
     * 判断一个字符串是不是回文串
     *
     * @param s 字符串
     * @return 布尔值
     */
    public boolean validPalindrome(String s) {
        for (int i = 0; i < s.length(); i++) {
            String str = s.substring(0, i) + s.substring(i + 1);
            boolean b = judgePalindrome(str);
            if (b == true) {
                return true;
            }
        }
        return judgePalindrome(s);
    }

    /**
     * 判断某个字符是否是回文串
     *
     * @param s 字符串s
     * @return 布尔值
     */
    public boolean judgePalindrome(String s) {
        if (s == null) {
            return true;
        }
        return new StringBuilder(s).reverse().toString().equals(s);
    }

    /**
     * 判断某个字符是否是回文串
     *
     * @param s 字符串
     * @return 布尔值
     */
    public boolean validPalindrome2(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return isValid(s, i + 1, j) || isValid(s, i, j - 1);
            }
            i++;
            j--;
        }
        return true;
    }

    /**
     * 判断是不是回文串
     *
     * @param s 字符串
     * @param i 字符串i
     * @param j 字符串j
     * @return
     */
    public boolean isValid(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
