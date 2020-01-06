package leetcode.dynamicprogramming;

import org.junit.Test;

/**
 * 利用动态规划来计算爬楼梯问题
 *
 * @author zhangyu
 **/


public class ClimbingStairs {
    @Test
    public void testClimbingStairs() {
        long startTime = System.currentTimeMillis();
        int n = 44;
        int num = climbingStairs(n);
        long endTime = System.currentTimeMillis();
        System.out.println(num);
        System.out.println((endTime - startTime) / 1000.0 + "s");
    }

    /**
     * 动态规划，记忆算法
     *
     * @param n 数字
     * @return int
     */
    private int climbingStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }


    /**
     * 利用递归方式，找出上楼梯的种数
     *
     * @param n 数字
     * @return int
     */
    private int climbStairs2(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else {
            return climbStairs2(n - 1) + climbStairs2(n - 2);
        }
    }
}
