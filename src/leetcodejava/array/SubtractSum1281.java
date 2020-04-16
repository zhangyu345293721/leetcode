package leetcodejava.array;

import org.junit.Test;

/**
 * This is the solution of No. 1281 problem in the LeetCode,
 * the website of the problem is as follow:
 *https://leetcode-cn.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给你一个整数 n，请你帮忙计算并返回该整数「各位数字之积」与「各位数字之和」的差。
 *
 * 示例 1：
 *
 * 输入：n = 234
 * 输出：15
 * 解释：
 * 各位数之积 = 2 * 3 * 4 = 24
 * 各位数之和 = 2 + 3 + 4 = 9
 * 结果 = 24 - 9 = 15
 * 示例 2：
 *
 * 输入：n = 4421
 * 输出：21
 * 解释：
 * 各位数之积 = 4 * 4 * 2 * 1 = 32
 * 各位数之和 = 4 + 4 + 2 + 1 = 11
 * 结果 = 32 - 11 = 21
 *
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class SubtractSum1281 {
    @Test
    public void testSubtractSum() {
        int n = 4421;
        int sub = subtractProductAndSum(n);
        System.out.println(sub);
    }

    /**
     * 计算差
     *
     * @param n 输入数字
     * @return 返回差
     */
    public int subtractProductAndSum(int n) {
        if (n < 0) {
            return -1;
        }
        char[] chs = String.valueOf(n).toCharArray();
        int multiply = getMultiply(chs);
        int sum = getSum(chs);
        return multiply - sum;
    }

    /**
     * 求和
     *
     * @param chs 字符数组
     * @return 求和
     */
    private int getSum(char[] chs) {
        int sum = 0;
        for (char ch : chs) {
            int num = ch - '0';
            sum += num;
        }
        return sum;
    }

    /**
     * 计算字符串的乘积
     *
     * @param chs 字符数组
     * @return 乘积
     */
    private int getMultiply(char[] chs) {
        int multiply = 1;
        for (char ch : chs) {
            int num = ch - '0';
            multiply *= num;
        }
        return multiply;
    }
}
