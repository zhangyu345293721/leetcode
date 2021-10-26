package leetcodejava.string;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;


public class Calculator26 {

    @Test
    public void calculatorTest() {
        String s = " 3/2 ";
        int result = calculate(s);
        System.out.println(result);
        Assert.assertEquals(result, 1);
    }


    /**
     * 计算器
     *
     * @param s 字符串
     * @return 计算值
     */
    public int calculate(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }
        Stack<Character> ops = new Stack<>();
        Stack<Integer> nums = new Stack<>();
        int i = 0;
        int len = s.length();
        while (i < len) {
            char ch = s.charAt(i);
            if (ch == ' ') {
                i++;
                continue;
            } else {
                if (isDigit(ch)) {
                    int number = 0;
                    while (i < len && isDigit(s.charAt(i))) {
                        number = number * 10 + (s.charAt(i) - '0');
                        i++;
                    }
                    nums.push(number);
                } else {
                    // 字符操作
                    if (ops.isEmpty() || isPriority(ch, ops.peek())) {
                        ops.push(ch);
                    } else {
                        while (!ops.isEmpty() && !isPriority(ch, ops.peek())) {
                            cal(nums, ops);
                        }
                        ops.push(ch);
                    }
                    i++;
                }
            }
        }
        while (!ops.isEmpty()) {
            cal(nums, ops);
        }
        return nums.pop();
    }

    /**
     * 判断是否是数字
     *
     * @param ch 字符
     * @return 布尔值
     */
    private boolean isDigit(char ch) {
        return ch <= '9' && ch >= '0';
    }

    /**
     * 进行计算操作
     *
     * @param nums 数组
     * @param ops  操作
     */
    private void cal(Stack<Integer> nums, Stack<Character> ops) {
        int num2 = nums.pop();
        int num1 = nums.pop();
        int ch = ops.pop();
        int res = 0;
        switch (ch) {
            case '-':
                res = num1 - num2;
                break;
            case '+':
                res = num1 + num2;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num1 / num2;
                break;
        }
        nums.push(res);
    }

    /**
     * 是否是优先
     *
     * @param a 操作1
     * @param b 操作2
     * @return 布尔值
     */
    public boolean isPriority(char a, char b) {
        if ((a == '*' || a == '/') && (b == '+' || b == '-')) {
            return true;
        }
        return false;
    }
}
