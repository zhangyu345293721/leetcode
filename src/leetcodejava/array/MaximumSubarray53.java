package leetcodejava.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * This is the solution of No.53 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/maximum-subarray
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 示例:
 * <p>
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * <p>
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class MaximumSubarray53 {
    @Test
    public void maximumSubarrayTest() {
        int[] nums = {1};
        int result = maximumSubarray(nums);
        Assert.assertEquals(result, 1);
    }


    /**
     * 求数组的子数组和最大
     *
     * @param nums 数组
     * @return 最大值
     */
    private int maximumSubarray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int result = nums[0], sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum < 0) {
                sum = nums[i];
            } else {
                sum += nums[i];
            }
            // 记录最大值
            result = Math.max(result, sum);
        }
        return result;
    }

    /**
     * 动态规划求解
     *
     * @param nums 数组
     * @return 最大
     */
    private int maximumSubarray2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int result = nums[0], sum = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            // 主要是状态转换方程
            sum = Math.max(sum + nums[i], nums[i]);
            result = Math.max(result, sum);
        }
        return result;
    }
}
