package leetcodejava.array;

import org.junit.Test;

import java.util.Arrays;

/**
 * 硬币兑换问题
 *
 * @author: zhangyu
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
