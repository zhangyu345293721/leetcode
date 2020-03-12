package leetcodejava.array;

import org.junit.Test;

/**
 * 最好时机买卖股票
 *
 * @author: zhangyu
 */
public class BestTimeBuySellStock121 {

    @Test
    public void testBestTimeBuySellStock() {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int maxProfit = maxProfit3(prices);
        System.out.println(maxProfit);
    }

    /**
     * 获取最大利润
     *
     * @param prices 价格
     * @return 最大利润
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int maxProfit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                maxProfit = Math.max(maxProfit, prices[j] - prices[i]);
            }
        }
        return maxProfit;
    }


    /**
     * 获取最大利润
     *
     * @param prices 价格
     * @return 最大利润
     */
    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }
        return maxProfit;
    }

    /**
     * 获取最大利润
     *
     * @param prices 价格
     * @return 最大利润
     */
    public int maxProfit3(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int minPrice = Integer.MAX_VALUE, maxProfit = 0;
        for (int i = 0; i < prices.length; ++i) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
            if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }
}
