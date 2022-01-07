package leetcodejava.dp;

import org.junit.Assert;
import org.junit.Test;

/**
 * This is the solution of No.714 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；整数 fee 代表了交易股票的手续费用。
 * <p>
 * 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
 * <p>
 * 返回获得利润的最大值。
 * <p>
 * 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
 * <p>
 * 示例 1：
 * <p>
 * 输入：prices = [1, 3, 2, 8, 4, 9], fee = 2
 * 输出：8
 * 解释：能够达到的最大利润:
 * 在此处买入 prices[0] = 1
 * 在此处卖出 prices[3] = 8
 * 在此处买入 prices[4] = 4
 * 在此处卖出 prices[5] = 9
 * 总利润: ((8 - 1) - 2) + ((9 - 4) - 2) = 8
 * 示例 2：
 * <p>
 * 输入：prices = [1,3,7,5,10,3], fee = 3
 * 输出：6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class BestTimeBuy714 {

    @Test
    public void bestTimeBuyTest() {
        int[] prices = {1, 3, 2, 8, 4, 9};
        int fee = 2;
        int result = maxProfit(prices, fee);
        System.out.println(result);
        Assert.assertEquals(result, 8);
    }

    /**
     * 最大利润
     *
     * @param prices 最大利润
     * @param fee    小费
     * @return 利润
     */
    public int maxProfit(int[] prices, int fee) {
        if (prices == null || prices.length < 1) {
            return 0;
        }
        int n = prices.length;
        int[][] dp = new int[2][n];
        dp[0][0] = -prices[0];  // 第i天后持有股票，⼿⾥利润的最⼤值
        dp[0][1] = 0;           // 第i天后不持有股票，⼿⾥利润的最⼤值
        for (int i = 1; i < n; ++i) {
            dp[0][i] = Math.max(dp[0][i - 1], dp[1][i - 1] - prices[i]);
            dp[1][i] = Math.max(dp[1][i - 1], dp[0][i - 1] + prices[i] - fee);
        }
        return Math.max(dp[0][n - 1], dp[1][n - 1]);
    }
}
