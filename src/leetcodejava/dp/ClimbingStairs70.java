package leetcodejava.dp;

import org.junit.Assert;
import org.junit.Test;

/**
 * This is the solution of No.70 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/middle-of-the-linked-list/
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 注意：给定 n 是一个正整数。
 * <p>
 * 示例 1：
 * <p>
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 * <p>
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 * <p>
 * 来源：力扣（LeetCode）
 * * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class ClimbingStairs70 {
    @Test
    public void climbingStairsTest() {
        int n = 44;
        int result = climbingStairs(n);
        Assert.assertEquals(result, 1134903170);
    }

    /**
     * 动态规划，记忆算法（利用空间换时间）
     *
     * @param n 爬楼梯数
     * @return int
     */
    private int climbingStairs(int n) {
        if (n == 1) {
            return 1;
        }
        // 定义数组
        int[] dp = new int[n + 1];
        // 初始化数组
        dp[1] = 1;
        dp[2] = 2;
        // 状态转移方程
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
