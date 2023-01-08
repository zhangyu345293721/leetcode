package leetcodejava.dp;

import org.junit.Assert;
import org.junit.Test;

/**
 * This is the solution of No.309 problem in the LeetCode,
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
public class BestTimeBuy309 {

    @Test
    public void bestTimeBuyTest() {
        int[] prices = {1, 3, 2, 8, 4, 9};
        int result = maxProfit(prices);
        System.out.println(result);
        Assert.assertEquals(result, 8);
    }

    /**
     * 最大利润
     *
     * @param prices 最大利润
     * @return 利润
     */
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int n = prices.length;
        int[][] dp = new int[n][4];
        // dp[i][0]表示第i天持有股票时的利润
        // dp[i][1]表示第i天不持有股票时的利润（当天刚卖掉）
        // dp[i][2]表示第i天不持有股票时的利润（冷冻期），昨天刚卖了股票
        // dp[i][3]表示第i天不持有股票时的利润（⾮冷冻期），昨天也没持有
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        dp[0][2] = 0;
        dp[0][3] = 0;
        for (int i = 1; i < n; ++i) {
            dp[i][0] = max3(dp[i - 1][0], dp[i - 1][2] - prices[i], dp[i - 1][3] - prices[i]);
            dp[i][1] = dp[i - 1][0] + prices[i];
            dp[i][2] = dp[i - 1][1];
            dp[i][3] = Math.max(dp[i - 1][2], dp[i - 1][3]);
        }
        return max4(dp[n - 1][0], dp[n - 1][1], dp[n - 1][2], dp[n - 1][3]);
    }

    /**
     * 获取三个值中最大值
     *
     * @param a 数值a
     * @param b 数值b
     * @param c 数值c
     * @return 最值
     */
    private int max3(int a, int b, int c) {
        return Math.max(Math.max(a, b), c);
    }


    /**
     * 获取四个值中最大值
     *
     * @param a 数值a
     * @param b 数值b
     * @param c 数值c
     * @param d 数值d
     * @return 最值
     */
    private int max4(int a, int b, int c, int d) {
        return Math.max(max3(a, b, c), d);
    }

    /**
     * 最大利润
     *
     * @param prices 最大利润
     * @return 利润
     */
    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length < 1) {
            return 0;
        }
        int n = prices.length;
        // 定义动态规划数组
        int[][] dp = new int[2][n];
        //第一天没有股票利润
        dp[0][0] = 0;
        // 第一天有股票利润
        dp[1][0] = -prices[0];
        // 状态转移方程
        for (int i = 1; i < n; i++) {
            // 没有股票：前一天也没有持有，今天刚卖
            dp[0][i] = Math.max(dp[0][i - 1], dp[1][i - 1] + prices[i]);
            // 有股票：前一天有股票，今天刚买，前两天的最大利润(冷冻期有一天)
            dp[1][i] = Math.max(dp[1][i - 1], (i - 2 >= 0 ? dp[0][i - 2] : 0) - prices[i]);
        }
        return Math.max(dp[0][n - 1], dp[1][n - 1]);
    }

}
