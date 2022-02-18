package leetcodejava.dp;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * This is the solution of No. 322 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/coin-change/
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * 示例 2:
 * <p>
 * 输入: coins = [2], amount = 3
 * 输出: -1
 * 说明:
 * 你可以认为每种硬币的数量是无限的。
 * <p>
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class CoinChange322 {
    @Test
    public void coinChangeTest() {
        int[] coins = {1, 2, 5};
        int amount = 11;
        int result = coinChange4(coins, amount);
        System.out.println(result);
        Assert.assertEquals(result, 3);
    }

    private int minCount = Integer.MAX_VALUE;

    /**
     * 硬币兑换
     *
     * @param coins  硬币兑换
     * @param amount 数量
     * @return 最小数量
     */
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        searchHelper(coins, coins.length - 1, amount, 0);
        return minCount == Integer.MAX_VALUE ? -1 : minCount;
    }

    /**
     * 1、按金额从大到小，从多到少
     * 2、预判低于最优解，终止递归
     * 3、能整除即可返回
     *
     * @param coins  硬币数组
     * @param index  下标
     * @param amount 剩余没凑足的数量
     * @param count  已经算的数量
     */
    public void searchHelper(int[] coins, int index, int amount, int count) {
        if (index < 0) {
            return;
        }
        for (int c = amount / coins[index]; c >= 0; c--) {
            int newCount = count + c;
            if (amount - c * coins[index] == 0) {
                minCount = Math.min(minCount, newCount);
                break;  //剪枝1
            }
            // 如果大于最小minCount就直接退出
            if (newCount >= minCount) {
                break; //剪枝2
            }
            searchHelper(coins, index - 1, amount - c * coins[index], newCount);
        }
    }


    /**
     * 硬币兑换
     *
     * @param coins  硬币兑换
     * @param amount 数量
     * @return 最小数量
     */
    public int coinChange2(int[] coins, int amount) {
        if (coins == null || coins.length < 1) {
            return 0;
        }
        // 定义动态数组
        int[] dp = new int[amount + 1];
        // 初始化数组
        for (int i = 0; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                int w = coins[j];
                if (w <= i) {
                    dp[i] = Math.min(dp[i], dp[i - w] + 1);
                }
            }
        }
        return dp[amount] >= Integer.MAX_VALUE ? -1 : dp[amount];
    }

    /**
     * 每个阶段从1、2、5种选择⼀个硬币
     * int dp[amount+1] dp[i]表示凑够i元最少需要多少硬币。
     * 到达i这个状态，那上⼀步只有可能是选了1、2、5，也就是从状态i-1, i-
     * 2、i-5转化过来。dp[i]值也由 dp[i-1]、dp[i-2]、dp[i-5]推导出来。
     * dp[i] = min(dp[i-1] , dp[i-2], dp[i-5])+1
     *
     * @param coins  硬币兑换
     * @param amount 数量
     * @return 最小数量
     */
    public int coinChange3(int[] coins, int amount) {
        if (coins == null || coins.length < 1) {
            return 0;
        }
        int k = coins.length;
        int[] dp = new int[amount + 1];
        for (int i = 0; i <= amount; ++i) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;
        for (int i = 1; i <= amount; ++i) {
            for (int j = 0; j < k; ++j) {
                if (i - coins[j] >= 0 &&
                        dp[i - coins[j]] != Integer.MAX_VALUE &&
                        dp[i - coins[j]] + 1 < dp[i]) {
                    dp[i] = dp[i - coins[j]] + 1;
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    /**
     * 硬币兑换
     *
     * @param coins  硬币兑换
     * @param amount 数量
     * @return 最小数量
     */
    public int coinChange4(int[] coins, int amount) {
        if (coins == null || coins.length < 1) {
            return 0;
        }
        int n = coins.length;
        // 定义动态数组
        int[][] dp = new int[n + 1][amount + 1];
        // 初始化数dd组
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= amount; j++) {
                dp[i][j] = 10001;
            }
        }
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        // 状态转移方程
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                int w = coins[i - 1];
                if (w > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - w] + 1);
                }
            }
        }
        // 找到一个问题，发现是三元运算符用错了？？？(以后三元运算法要少用)
        if (dp[n][amount] >= 10001) {
            return -1;
        } else {
            return dp[n][amount];
        }
    }
}
