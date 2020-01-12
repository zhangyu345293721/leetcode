package leetcodejava.string;

import org.junit.Test;
import java.util.Stack;

/**
 * 移除最外面的括号
 *
 * @author: zhangyu
 */
public class RemoveOutermostParentheses1021 {
    @Test
    public void testRemoveOutermostParentheses() {
        String s = "(()())(())";
        String innerString=removeOuterParentheses(s);
        System.out.println(innerString);
    }

    /**
     * 去除最外层的括号
     *
     * @param S 括号字符串
     * @return 字符串
     */
    public String removeOuterParentheses(String S) {
        if (S.length() < 1) {
            return "";
        }
        Stack<Character> stack = new Stack<>();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            if (ch == '(') {
                if (!stack.isEmpty()) {
                    sb.append(ch);
                }
                stack.push(ch);
            }
            if (ch == ')') {
                stack.pop();
                if (!stack.isEmpty()) {
                    sb.append(ch);
                }
            }
        }
        return sb.toString();
    }
}
