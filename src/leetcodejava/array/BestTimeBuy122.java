package leetcodejava.array;

import org.junit.Test;

/**
 * 最好最坏时间买卖股票
 *
 * @author: zhangyu
 */
public class BestTimeBuy122 {

    @Test
    public void testBestTimeBuy() {
        int arr[] = {7, 1, 5, 3, 6, 4};
        int maxProfit = maxProfit(arr);
        System.out.println(maxProfit);
    }

    /**
     * 最好的时间买卖股票
     *
     * @param prices 价格
     * @return 最大利润
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 1) {
            return 0;
        }
        int curMin = prices[0];
        int ans = 0;
        for (int i = 1; i < prices.length; i++) {
            ans += Math.max(prices[i] - curMin, 0);
            curMin = prices[i];
        }
        return ans;
    }
}
