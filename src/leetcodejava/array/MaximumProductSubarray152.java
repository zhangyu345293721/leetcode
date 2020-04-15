package leetcodejava.array;

import org.junit.Test;

/**
 * This is the solution of No. 152 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/maximum-product-subarray
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字）。
 *
 * 示例 1:
 *
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 示例 2:
 *
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 *
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
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
