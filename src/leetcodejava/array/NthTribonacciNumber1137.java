package leetcodejava.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * This is the solution of No.1137 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/n-th-tribonacci-number
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 泰波那契序列 Tn 定义如下： 
 * <p>
 * T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2
 * <p>
 * 给你整数 n，请返回第 n 个泰波那契数 Tn 的值。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 4
 * 输出：4
 * 解释：
 * T_3 = 0 + 1 + 1 = 2
 * T_4 = 1 + 1 + 2 = 4
 * 示例 2：
 * <p>
 * 输入：n = 25
 * 输出：1389537
 * <p>
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class NthTribonacciNumber1137 {
    @Test
    public void nthTribonacciNumberTest() {
        int result = tribonacci(37);
        System.out.println(result);
        Assert.assertEquals(result,2082876103);
    }

    /**
     * 计算斐波那契数
     *
     * @param n 数n
     * @return 数字
     */
    public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 1;
        } else {
            return tribonacci(n - 2) + tribonacci(n - 1) + tribonacci(n - 3);
        }
    }


    /**
     * 斐波那契数动态规划
     *
     * @param n 数字n
     * @return 最后值
     */
    public int tribonacci2(int n) {
        int[] array = new int[38];
        array[0] = 0;
        array[1] = 1;
        array[2] = 1;
        for (int i = 3; i <= n; i++) {
            array[i] = array[i - 1] + array[i - 2] + array[i - 3];
        }
        return array[n];
    }
}
