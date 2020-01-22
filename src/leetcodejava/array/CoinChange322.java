package leetcodejava.array;

import org.junit.Test;

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
        int sum = CoinChange(arr, amount);
        System.out.println(sum);
    }

    /**
     * 动态规划的方法
     *
     * @param coins  硬币兑换
     * @param amount 数量
     * @return
     */
    private int CoinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (coins == null || coins.length == 0) {
            return -1;
        }
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            int res = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] > i) {
                    continue;
                }
                if (dp[i - coins[j]] == -1) {
                    continue;
                }
                dp[i] = 1 + dp[i - coins[j]];
                res = Math.min(res, dp[i]);
            }
            dp[i] = res;
        }
        return dp[amount];
    }

}
