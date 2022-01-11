package leetcodejava.dp;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * This is the solution of No.279 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/perfect-squares/
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 * <p>
 * 示例 1:
 * <p>
 * 输入: n = 12
 * 输出: 3
 * 解释: 12 = 4 + 4 + 4.
 * 示例 2:
 * <p>
 * 输入: n = 13
 * 输出: 2
 * 解释: 13 = 4 + 9.
 * <p>
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class PerfectSquares279 {
    @Test
    public void perfectSquaresTest() {
        int num = 13;
        int result = numSquares(num);
        System.out.println(result);
        Assert.assertEquals(result, 2);
    }

    /**
     * 最少完全平方组成
     *
     * @param n 输入数字
     * @return 多少数组成
     */
    public int numSquares(int n) {
        // 定义数组，并初始化数组
        int[] dp = new int[n + 1];
        // 初始化数组
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i = 0; i * i <= n; i++) {
            dp[i * i] = 1;
        }
        // 动态规划
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], 1 + dp[i - j * j]);
            }
        }
        return dp[n];
    }

    /**
     * 这个数由几个完全平方组成
     *
     * @param n 输入数字
     * @return 多少数组成
     */
    public int numSquares2(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int k = 1; k * k <= i; k++) {
                min = Math.min(min, 1 + dp[i - k * k]);
            }
            dp[i] = min;
        }
        return dp[n];
    }
}
