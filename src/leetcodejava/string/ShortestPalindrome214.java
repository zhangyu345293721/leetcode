package leetcodejava.string;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * This is the solution of No.214 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/shortest-palindrome
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个字符串 s，你可以通过在字符串前面添加字符将其转换为回文串。找到并返回可以用这种方式转换的最短回文串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "aacecaaa"
 * 输出: "aaacecaaa"
 * 示例 2:
 * <p>
 * 输入: "abcd"
 * 输出: "dcbabcd"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shortest-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class ShortestPalindrome214 {

    @Test
    public void shortestPalindromeTest() {
        String str = "abcd";
        String result = shortestPalindrome2(str);
        System.out.println(result);
        Assert.assertEquals(result, "dcbabcd");
    }

    /**
     * 生成最短回文串
     *
     * @param s 输入字符串
     * @return 最短回文串
     */
    public String shortestPalindrome(String s) {
        int n = s.length();
        int[] fail = new int[n];
        Arrays.fill(fail, -1);
        for (int i = 1; i < n; ++i) {
            int j = fail[i - 1];
            while (j != -1 && s.charAt(j + 1) != s.charAt(i)) {
                j = fail[j];
            }
            if (s.charAt(j + 1) == s.charAt(i)) {
                fail[i] = j + 1;
            }
        }
        int best = -1;
        for (int i = n - 1; i >= 0; --i) {
            while (best != -1 && s.charAt(best + 1) != s.charAt(i)) {
                best = fail[best];
            }
            if (s.charAt(best + 1) == s.charAt(i)) {
                ++best;
            }
        }
        String add = (best == n - 1 ? "" : s.substring(best + 1));
        StringBuffer ans = new StringBuffer(add).reverse();
        ans.append(s);
        return ans.toString();
    }

    /**
     * 生成最短回文串
     *
     * @param s 输入字符串
     * @return 最短回文串
     */
    public String shortestPalindrome2(String s) {
        String temp = new StringBuffer(s).reverse().toString();
        int length = temp.length();
        for (int index = 0; index < length; ++index) {
            if (temp.substring(index).equals(s.substring(0, length - index))) {
                temp = temp.substring(0, index);
                break;
            }
        }
        return temp + s;
    }
}
