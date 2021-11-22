package leetcodejava.string;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

/**
 * This is the solution of No. 12.26 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/calculator-lcci
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个包含正整数、加(+)、减(-)、乘(*)、除(/)的算数表达式(括号除外)，计算其结果。
 * <p>
 * 表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格  。 整数除法仅保留整数部分。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "3+2*2"
 * 输出: 7
 * 示例 2:
 * <p>
 * 输入: " 3/2 "
 * 输出: 1
 * 示例 3:
 * <p>
 * 输入: " 3+5 / 2 "
 * 输出: 5
 * 说明：
 * <p>
 * 你可以假设所给定的表达式都是有效的。
 * 请不要使用内置的库函数 eval。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/calculator-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class Calculator26 {

    @Test
    public void calculatorTest() {
        String s = " 3/ 2*3+1 ";
        int result = calculate(s);
        System.out.println(result);
        Assert.assertEquals(result, 4);
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
