package leetcode.arraytest;

import org.junit.Test;

/**
 * @author zhangyu
 * @version V1.0
 * @ClassName: MaximumSubarray
 * @Description: 这种是采用动态规划的方式进行求解
 * @date 2018/12/6 9:41
 **/


public class MaximumSubarray3 {
    @Test
    public void fun() {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int maxNum = maximumSubarray(nums);
        System.out.println(maxNum);
    }

    private int maximumSubarray(int[] nums) {
        // 如果数组为空或者长度为0，直接返回0
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // 定义最大值为数组开始的数
        int result = nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            // 主要是要想明白这个动态规划的状态转换方程
            sum = Math.max(sum + nums[i], nums[i]);
            result = Math.max(result, sum);
        }
        // 最后返回最大的那个数
        return result;
    }
}
