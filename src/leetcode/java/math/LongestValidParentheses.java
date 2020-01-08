package leetcode.java.math;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 找出括号是否有效
 *
 * @author zhangyu
 **/


public class LongestValidParentheses {
    @Test
    public void testLongestValidParentheses() {
        String s = ")()())";
        int length = longestValidParentheses(s);
        System.out.println(length);
    }

    /**
     * 最长括号
     *
     * @param s 字符串
     * @return int类型
     */
    private int longestValidParentheses(String s) {
        Deque<Character> stack = new LinkedList<>();
        int count = 0;
        int max = 0;
        char chs[] = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            stack.push(chs[i]);
            if (!stack.isEmpty()) {
                char c = stack.peek();
                if (c == '(') {
                    stack.pop();
                    count++;
                }
            }
            if (stack.isEmpty()) {
                if (max < count) {
                    max = count;
                }
                count = 0;
            }
        }
        return max * 2;
    }
}
