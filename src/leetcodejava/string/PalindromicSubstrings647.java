package leetcodejava.string;

import org.junit.Assert;
import org.junit.Test;

/**
 * This is the solution of No. 647 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/palindromic-substrings
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 * <p>
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 * <p>
 * 示例 1：
 * <p>
 * 输入："abc"
 * 输出：3
 * 解释：三个回文子串: "a", "b", "c"
 * 示例 2：
 * <p>
 * 输入："aaa"
 * 输出：6
 * 解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindromic-substrings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class PalindromicSubstrings647 {
    @Test
    public void palindromicSubstringsTest() {
        String s = "abc";
        int result = countSubstrings(s);
        System.out.println(result);
        Assert.assertEquals(result, 3);
    }

    int num = 0;

    /**
     * 统一个字符串的子字符串有多少回文串
     *
     * @param s 字符串
     * @return 回文串个数
     */
    public int countSubstrings(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }
        for (int i = 0; i < s.length(); i++) {
            count(s, i, i);            // 回文串长度为奇数
            count(s, i, i + 1);   // 回文串长度为偶数
        }
        return num;
    }

    /**
     * 子字符串判断是否是回文串
     *
     * @param s     子字符串
     * @param start 开始
     * @param end   结束
     */
    public void count(String s, int start, int end) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            num++;
            start--;
            end++;
        }
    }
}
