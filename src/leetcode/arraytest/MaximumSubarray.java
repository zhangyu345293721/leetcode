package leetcode.arraytest;

import org.junit.Test;

/**
 * @author zhangyu
 **/


public class MaximumSubarray {
    @Test
    public void testMaximumSubarray() {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int maxNum = maximumSubarray(nums);
        System.out.println(maxNum);
    }


    /**
     * 这种比较直接，又通俗易懂的方式
     *
     * @param nums 数组
     * @return 最大值
     */
    private int maximumSubarray(int[] nums) {
        int max = nums[0], sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum < 0) {
                sum = nums[i];
            } else {
                sum += nums[i];
            }
            if (sum > max) {
                max = sum;
            }
        }
        return max;
    }

    /**
     * 这种是采用动态规划的方式进行求解
     *
     * @param nums 数组
     * @return 最大
     */
    private int maximumSubarray2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int result = nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            // 主要是要想明白这个动态规划的状态转换方程
            sum = Math.max(sum + nums[i], nums[i]);
            result = Math.max(result, sum);
        }
        return result;
    }
}
