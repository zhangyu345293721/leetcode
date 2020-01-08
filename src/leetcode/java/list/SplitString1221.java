package leetcode.java.list;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 按照要求分割字符串
 *
 * @author: zhangyu
 */
public class SplitString1221 {

    @Test
    public void splitStringTestDemo() {
        String str = "RLRRRLLRLL";
        int num = balanceStringSplit(str);
        System.out.println("num = " + num);
    }

    /**
     * 平衡分割字符串
     *
     * @param s 字符串
     * @return int类型
     */
    public int balanceStringSplit(String s) {
        Deque<Character> stack = new LinkedList<>();
        int count = 0;
        for (char ch : s.toCharArray()) {
            if (stack.isEmpty()) {
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
