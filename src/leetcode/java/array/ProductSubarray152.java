package leetcode.java.array;

import org.junit.Test;

/**
 * @author: zhangyu
 */
public class ProductSubarray152 {
    @Test
    public void testProductSubarray() {
        int nums[] = {2, 3, -2, 4};
        int product = maxProduct(nums);
        System.out.println(product);
    }

    /**
     * 最大商品
     *
     * @param nums 数组
     * @return 最大商品
     */
    private int maxProduct(int[] nums) {
        // 定义最大值，最小值和结果等于第一个数
        int max = nums[0];
        int min = nums[0];
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // 定义一个临时节点存储max
            int temp = max;
            // 更新max，min的值
            max = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]);
            min = Math.min(Math.min(temp * nums[i], min * nums[i]), nums[i]);
            if (max > result) {
                result = max;
            }
        }
        return result;
    }
}
