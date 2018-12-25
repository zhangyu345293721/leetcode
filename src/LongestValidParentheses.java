import org.junit.Test;

import java.util.Stack;

/**
 * @author zhangyu
 * @version V1.0
 * @ClassName: LongestValidParentheses
 * @Description: TOTO
 * @date 2018/12/17 19:29
 **/


public class LongestValidParentheses {
    @Test
    public void fun() {
        String s = ")()())";
        int length = longestValidParentheses(s);
        System.out.println(length);
    }

    private int longestValidParentheses(String s) {
        Stack<Character> stack = new Stack<>();
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
