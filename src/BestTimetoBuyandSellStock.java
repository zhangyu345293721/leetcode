import org.junit.Test;

/**
 * @author zhangyu
 * @version V1.0
 * @ClassName: BestTimetoBuyandSellStock
 * @Description: TOTO
 * @date 2018/12/6 15:28
 **/
/*
   做这种题目时候，要先进行判断，然后再动手写算法，防止边界问题的出现
 */

public class BestTimetoBuyandSellStock {
    @Test
    public void fun() {
        int[] nums = {7, 1, 5, 3, 6, 4};
        int maxProfit = maxProfit(nums);
        System.out.println(maxProfit);
    }

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
}
