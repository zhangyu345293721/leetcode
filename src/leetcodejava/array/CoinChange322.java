package leetcodejava.array;

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
        int sum = coinChange(coins, amount);
        System.out.println(sum);
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
                break;//剪枝1
            }
            // 如果大于最小minCount就直接退出
            if (newCount >= minCount) {
                break; //剪枝2
            }
            searchHelper(coins, index - 1, amount - c * coins[index], newCount);
        }
    }
}
