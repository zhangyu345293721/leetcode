package leetcodejava.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * This is the solution of No. 509 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/fibonacci-number
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 斐波那契数，通常用 F(n) 表示，形成的序列称为斐波那契数列。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 * <p>
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 给定 N，计算 F(N)。
 * <p>
 * 示例 1：
 * <p>
 * 输入：2
 * 输出：1
 * 解释：F(2) = F(1) + F(0) = 1 + 0 = 1.
 * 示例 2：
 * <p>
 * 输入：3
 * 输出：2
 * 解释：F(3) = F(2) + F(1) = 1 + 1 = 2.
 * 示例 3：
 * <p>
 * 输入：4
 * 输出：3
 * 解释：F(4) = F(3) + F(2) = 2 + 1 = 3.
 * <p>
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class FibonacciNumber509 {
    @Test
    public void fibonacciNumberTest() {
        int n = 3;
        int num = fib2(n);
        Assert.assertEquals(num, 2);
    }

    /**
     * 斐波那契数(递归)
     *
     * @param N 输入数
     * @return 返回数
     */
    public int fib(int N) {
        if (N <= 0) {
            return 0;
        } else if (N == 1) {
            return 1;
        } else {
            return fib(N - 1) + fib(N - 2);
        }
    }

    /**
     * 斐波那契数(动态规划)
     *
     * @param N 输入数
     * @return 返回数
     */
    public int fib2(int N) {
        int[] arr = new int[N + 2];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i <= N; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[N];
    }

    /**
     * 斐波那契数(交换方式)
     *
     * @param N 输入数
     * @return 返回数
     */
    public int fib3(int N) {
        if (N <= 0) {
            return 0;
        }
        if (N == 1) {
            return 1;
        }
        int n1 = 0;
        int n2 = 1;
        int n3 = 0;
        for (int i = 2; i <= N; i++) {
            n3 = n1 + n2;
            n1 = n2;
            n2 = n3;
        }
        return n3;
    }
}
