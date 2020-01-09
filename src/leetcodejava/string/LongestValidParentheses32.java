package leetcodejava.string;

import org.junit.Test;

import java.util.Stack;

/**
 * 最长的有效匹配串
 *
 * @author: zhangyu
 */
public class LongestValidParentheses32 {

    @Test
    public void testLongestValidParentheses() {
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
