package leetcodejava.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * This is the solution of No. 67 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
 * <p>
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 * <p>
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 示例:
 * <p>
 * 输入: [1,2,3,0,2]
 * 输出: 3
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class BestTimeBuySellStockCooldown309 {

    @Test
    public void bestTimeBuySellStockCooldownTest() {
        int[] prices = {1, 2, 3, 0, 2};
        int max = maxProfit(prices);
        Assert.assertEquals(max, 3);
    }

    /**
     * 获取股票的最大收益
     *
     * @param prices 股票的票价
     * @return 最大收益
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        //由于可以无限次交易，所以只定义两个维度，第一个维度是天数，第二个维度表示是否持有股票，0表示不持有，1表示持有，2表示过渡期
        int[][] dp = new int[prices.length][3];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[0][2] = 0;
        for (int i = 1; i < prices.length; i++) {
            //第i天不持有股票的情况有两种
            //a.第i-1天也不持有股票
            //b.第i-1天是过渡期
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2]);
            //第i天持有股票有两种情况
            //a.第i-1天也持有股票，第i天不操作，
            //b.第i-1天不持有股票，在第i天买入
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            //第i天是冷冻期只有一种情况，第i-1天持有股票且卖出
            dp[i][2] = dp[i - 1][1] + prices[i];
        }
        //最后最大利润为最后一天，不持有股票或者进入冷冻期的情况
        return Math.max(dp[prices.length - 1][0], dp[prices.length - 1][2]);
    }
}
