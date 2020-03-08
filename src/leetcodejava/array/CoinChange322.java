package leetcodejava.array;

import org.junit.Test;

import java.util.Arrays;

/**
 * 硬币兑换问题
 *
 * @author: zhangyu
 */
public class CoinChange322 {

    private int minCount = Integer.MAX_VALUE;

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
        helper(coins, amount, 0, coins.length - 1);
        return minCount == Integer.MAX_VALUE ? -1 : minCount;
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
    public void helper(int[] coins, int amount, int count, int index) {
        if (index < 0 || count + amount / coins[index] >= minCount) {
            return;
        }
        if (amount % coins[index] == 0) {
            minCount = Math.min(minCount, count + amount / coins[index]);
            return;
        }
        for (int i = amount / coins[index]; i >= 0; i--) {
            helper(coins, amount - i * coins[index], count + i, index - 1);
        }
    }
}
