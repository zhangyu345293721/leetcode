package leetcodejava.string;

import org.junit.Test;

import java.util.Stack;

/**
 * This is the solution of No.830 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/longest-valid-parentheses
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 *
 * 示例 1:
 *
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 * 示例 2:
 *
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 *
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
        String s = "(()";
        System.out.println(longestValidParentheses(s));
    }

    /**
     * @param s 输入字符串
     * @return 最长数
     */
    public int longestValidParentheses(String s) {
        int maxlen = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 2; j <= s.length(); j += 2) {
                if (isValid(s.substring(i, j))) {
                    maxlen = Math.max(maxlen, j - i);
                }
            }
        }
        return maxlen;
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
            } else if (!stack.empty() && stack.peek() == '(') {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.empty();
    }
}
