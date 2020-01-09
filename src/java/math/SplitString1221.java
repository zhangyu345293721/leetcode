package java.math;


import org.junit.Test;

import java.util.Stack;

/**
 * 测试分割字符串
 *
 * @author: zhangyu
 */
public class SplitString1221 {

    @Test
    public void splitStringTestDemo() {
        String s = "RLRRRLLRLL";
        int count = balancedStringSplit(s);
        System.out.println("count = " + count);
    }

    /**
     * 找出可以分成几个L和R的字符串
     *
     * @param s 输入字符串
     * @return 返回数量
     */
    public int balancedStringSplit(String s) {
        int count = 0;
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (stack.empty()) {
                stack.push(ch);
            } else {
                if (ch == 'L') {
                    if (stack.peek() == 'R') {
                        stack.pop();
                    } else {
                        stack.push(ch);
                    }
                }
                if (ch == 'R') {
                    if (stack.peek() == 'L') {
                        stack.pop();
                    } else {
                        stack.push(ch);
                    }
                }
                if (stack.isEmpty()) {
                    count++;
                }
            }
        }
        return count;
    }
}
