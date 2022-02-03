package leetcodejava.string;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

/**
 * This is the solution of No.32 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/longest-valid-parentheses
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 * 示例 2:
 * <p>
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class LongestValidParentheses32 {

    @Test
    public void longestValidParenthesesTest() {
        String s = "(())";
        int result = longestValidParentheses1(s);
        System.out.println(result);
        Assert.assertEquals(result, 2);
    }

    /**
     * 最长有效括号
     *
     * @param s 输入字符串
     * @return 最长数
     */
    public int longestValidParentheses1(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                // 出栈
                stack.pop();
                // 看栈顶是否为空，为空的话就不能作差了
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    // i - 栈顶，获得档期有效括号长度
                    max = Math.max(max, i - stack.peek());
                }
            }
        }
        return max;
    }

    /**
     * 最长有效括号
     *
     * @param s 输入字符串
     * @return 最长数
     */
    public int longestValidParentheses2(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }
        int n = s.length();
        // 定义dp数组
        int[] dp = new int[n];
        int maxLen = 0;
        // 初始化
        for (int i = 0; i < n; i++) {
            dp[i] = 0;
        }
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i - 2 >= 0 ? dp[i - 2] : 0) + 2;
                } else {  // ')'
                    if (i - dp[i - 1] - 1 >= 0 && dp[i - dp[i - 1] - 1] == '(') {
                        dp[i] = 2 + dp[i - 1] + (i - dp[i - 1] - 2 >= 0 ? dp[i - dp[i - 1] - 2] : 0);
                    }
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }

    /**
     * 最长有效括号
     *
     * @param s 输入字符串
     * @return 最长数
     */
    public int longestValidParentheses3(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }
        int left = 0, right = 0, maxlen = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlen = Math.max(maxlen, 2 * right);
            } else if (right > left) {
                left = right = 0;
            }
        }
        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlen = Math.max(maxlen, 2 * left);
            } else if (left > right) {
                left = right = 0;
            }
        }
        return maxlen;
    }
}