package leetcode.testlist;

import org.junit.Test;

import java.util.Stack;

/**
 * 按照要求分割字符串
 *
 * @author: zhangyu
 * @date: 2019/11/10 11:03
 */
public class SplitString1221 {

    @Test
    public void splitStringTestDemo() {
        String str = "RLRRRLLRLL";
        int num = balanceStringSplit(str);
        System.out.println("num = " + num);
    }

    public int balanceStringSplit(String s) {
        Stack<Character> stack = new Stack<>();
        int count = 0;
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

                // 如果栈为空，计数器加1
                if (stack.empty()) {
                    count++;
                }
            }

        }
        return count;
    }
}
