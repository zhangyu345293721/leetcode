package leetcode.java.tree;

import org.junit.Test;

import java.util.Arrays;

/**
 * 动态规划，计算该数组是不是可以分成平等的两部分
 *
 * @author zhangyu
 **/

public class CapPartition {
    @Test
    public void testCapPartition() {
        int[] nums = {1, 5, 11, 5};
        boolean b = canPartition(nums);
        System.out.println(b);
    }

    /**
     * 判断数组是否能分成一半
     *
     * @param nums 数组
     * @return 布尔值
     */
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum & 1) == 1) {   //sum % 2 == 1
            return false;
        }
        sum /= 2; // sum=sum>>1;
        boolean[] dp = new boolean[sum + 1];
        // 数组中填空false
        Arrays.fill(dp, false);
        dp[0] = true;
        // 动态规划找出，是否满足这个数的和
        for (int num : nums) {
            for (int i = sum; i >= num; i--) {
                dp[i] = dp[i] || dp[i - num];
            }
        }
        return dp[sum];
    }
}