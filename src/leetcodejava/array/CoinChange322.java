package leetcodejava.array;

import org.junit.Test;

import java.util.Arrays;

/**
 * This is the solution of No. 322 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/coin-change/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 * 示例 1:
 *
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * 示例 2:
 *
 * 输入: coins = [2], amount = 3
 * 输出: -1
 * 说明:
 * 你可以认为每种硬币的数量是无限的。
 *
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class CoinChange322 {
    @Test
    public void testCoinChange() {
        int[] arr = {1, 2, 5};
        int amount = 11;
        int sum = coinChange(arr, amount);
        System.out.println(sum);
    }
    /**
     * 硬币兑换
     *
     * @param coins  硬币兑换
     * @param amount 数量
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int[] minCount = {amount + 1};
        helper(coins, amount, 0, coins.length - 1, minCount);
        return minCount[0] == amount + 1 ? -1 : minCount[0];
    }

    /**
     * 1、按金额从大到小，从多到少
     * 2、预判低于最优解，终止递归
     * 3、能整除即可返回
     *
     * @param coins  钱币数组
     * @param amount 兑换数量
     * @param count  种数
     * @param index  记录下标
     */
    public void helper(int[] coins, int amount, int count, int index, int[] minCount) {
        if (index < 0 || count + amount / coins[index] >= minCount[0]) {
            return;
        }
        if (amount % coins[index] == 0) {
            minCount[0] = Math.min(minCount[0], count + amount / coins[index]);
            return;
        }
        // 要找多种组合可能
        for (int i = amount / coins[index]; i >= 0; i--) {
            helper(coins, amount - i * coins[index], count + i, index - 1, minCount);
        }
    }
}
