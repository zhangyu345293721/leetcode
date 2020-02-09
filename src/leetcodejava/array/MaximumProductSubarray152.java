package leetcodejava.array;

import org.junit.Test;

/**
 * 最大产品下标
 *
 * @author: zhangyu
 */
public class MaximumProductSubarray152 {


    @Test
    public void testMaximumProductSubarray() {
        int[] nums = {2, 3, -2, 4};
        int maxProfit = maxProduct(nums);
        System.out.println(maxProfit);
    }

    /**
     * 最大商品
     *
     * @param nums 数组
     * @return 最大商品
     */
    private int maxProduct(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int max = nums[0];
        int min = nums[0];
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int temp = max;
            max = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]);
            min = Math.min(Math.min(temp * nums[i], min * nums[i]), nums[i]);
            if (max > result) {
                result = max;
            }
        }
        return result;
    }
}
