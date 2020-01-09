package leetcodejava.math;

import org.junit.Test;

/**
 * 做这种题目时候，要先进行判断，然后再动手写算法，防止边界问题的出现
 *
 * @author zhangyu
 **/

public class BestTimetoBuyandSellStock {
    @Test
    public void testBestTimeSellStock() {
        int[] nums = {7, 1, 5, 3, 6, 4};
        int maxProfit = maxProfit(nums);
        System.out.println(maxProfit);
    }

    /**
     * 寻找最大利润
     *
     * @param prices 价格数组
     * @return 利润
     */
    private int maxProfit(int[] prices) {
        if (prices.length < 1) {
            return 0;
        }
        int maxProfit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                if (maxProfit < profit) {
                    maxProfit = profit;
                }
            }
        }
        return maxProfit;
    }

    /**
     * 寻找最大利润
     *
     * @param prices 价格数组
     * @return 利润
     */
    private int maxProfit2(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        final int pricesIndex = prices.length - 1;
        int maxPrice = prices[pricesIndex];
        int maxProfit = 0;
        for (int i = pricesIndex - 1; i >= 0; i--) {
            if (prices[i] > maxPrice) {
                maxPrice = prices[i];
            }
            maxProfit = Math.max(maxProfit, maxPrice - prices[i]);
        }
        return maxProfit;
    }
}
