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
        String s = "()";
        int validLength = longestValidParentheses2(s);
        System.out.println(validLength);
        Assert.assertEquals(validLength, 2);
    }

    /**
     * 最长有效括号
     *
     * @param s 输入字符串
     * @return 最长数
     */
    public int longestValidParentheses2(String s) {
        int maxPairs = 0;
        int length = s.length();
        int[] dp = new int[length + 1];
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < length; i++) {
            int index = i + 1;
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.add(ch);
            } else {  // ch==')'
                if (!stack.isEmpty()) {
                    stack.pop();
                    int pairs = 1 + dp[i];
                    int prevIndex = index - pairs * 2;
                    if (prevIndex >= 0) {
                        pairs += dp[prevIndex];
                        dp[index] = pairs;
                    }
                }
            }
        }
        for (int num : dp) {
            if (num > maxPairs) {
                maxPairs = num;
            }
        }
        return maxPairs * 2;
    }

    /**
     * 最长有效括号
     *
     * @param s 输入字符串
     * @return 最长数
     */
    public int longestValidParentheses(String s) {
        int left = 0, right = 0, maxlength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * right);
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
                maxlength = Math.max(maxlength, 2 * left);
            } else if (left > right) {
                left = right = 0;
            }
        }
        return maxlength;
    }

    /**
     * 最长有效括号
     *
     * @param s 输入字符串
     * @return 最长数
     */
    public int longestValidParentheses3(String s) {
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 2; j <= s.length(); j += 2) {
                String sub = s.substring(i, j);
                if (isValid(sub)) {
                    maxLen = Math.max(maxLen, j - i);
                }
            }
        }
        return maxLen;
    }

    /**
     * 判断字符串是不是合法字符串
     *
     * @param subStr 子字符串
     * @return 布尔值
     */
    public boolean isValid(String subStr) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < subStr.length(); i++) {
            if (subStr.charAt(i) == '(') {
                stack.push('(');
            } else {
                if (!stack.empty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.empty();
    }
}