package leetcodejava.math;

import org.junit.Test;

/**
 * This is the solution of No. 445 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/powx-n
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 示例 2:
 * <p>
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 示例 3:
 * <p>
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 * 说明:
 * <p>
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
 * <p>
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class Pow50 {

    @Test
    public void powTest() {
        double x = 2.00000;
        int n = -2147483648;
        double result = myPow(x, n);
        System.out.println(result);
    }

    /**
     * @param x x数
     * @param n 平方数
     * @return 返回值
     */
    public double myPow(double x, int n) {
        return Math.pow(x, n);
    }

    /**
     * @param x x数
     * @param n 平方数
     * @return 返回值
     */
    public double myPow2(double x, int n) {
        double res = 1.0;
        for (int i = n; i != 0; i /= 2) {
            if (i % 2 != 0) {
                res *= x;
            }
            x *= x;
        }
        // n<0就取倒数
        return n < 0 ? 1 / res : res;
    }

    /**
     * @param x x数
     * @param n 平方数
     * @return 返回值
     */
    public double myPow3(double x, int n) {
        if (x == 1d) {
            return x;
        }
        double res = 1.0;
        int num = Math.abs(n);
        while (num != 0) {
            res *= x;
            num--;
        }
        // n<0就取倒数
        return n < 0 ? 1 / res : res;
    }
}
