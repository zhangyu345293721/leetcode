import org.junit.Test;

/**
 * @author zhangyu
 * @version V1.0
 * @ClassName: BestTimetoBuyandSellStock
 * @Description: TOTO
 * @date 2018/12/6 15:28
 **/


public class BestTimetoBuyandSellStock2 {
    @Test
    public void fun() {
        int[] nums = {7, 1, 5, 3, 6, 4};
        int maxProfit = maxProfit(nums);
        System.out.println(maxProfit);
    }

    // 找出最大的profit
    private int maxProfit(int[] prices) {
        // 如果数组的长度为0就直接返回
        if (prices.length == 0) {
            return 0;
        }

        // 定义一个非变量,数组的下标
        final int pricesIndex = prices.length - 1;
        // 记录一个标记位，把最后一个数设置为最大值
        int maxPrice = prices[pricesIndex];
        // 把最大收益设置为0
        int maxProfit = 0;
        for (int i = pricesIndex - 1; i >= 0; i--) {
            if (prices[i] > maxPrice) {
                // 更新maxPrice的值，把它更新
                maxPrice = prices[i];
            }
            // 更新最大收益值
            maxProfit = Math.max(maxProfit, maxPrice - prices[i]);
           // maxProfit=maxProfit>(maxPrice-prices[i])?maxProfit:(maxPrice-prices[i]);
        }
        return maxProfit;
    }
}
