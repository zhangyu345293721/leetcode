package leetcode.arraytest;

import org.junit.Test;

/**
 * @author zhangyu
 * @version V1.0
 * @ClassName: MaximumSubarray
 * @Description: 动态规划没有做出来，状态转换方程有点问题
 * @date 2018/11/7 9:41
 **/


public class MaximumSubarray {
    @Test
    public void fun() {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int maxNum = maximumSubarray(nums);
        System.out.println(maxNum);
    }

    private int maximumSubarray(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        int dp[] = new int[n];
        dp[0] = nums[0];
        if (nums[0] >= 0 && nums[1] >= 0) {
            dp[1] = nums[0] + nums[1];
        } else {
            dp[1] = Math.max(nums[0], nums[1]);
        }
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2]);
        }
        return dp[n - 1];
    }
}
