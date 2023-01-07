package leetcodejava.dp;

import org.junit.Assert;
import org.junit.Test;

/**
 * This is the solution of No.416 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/partition-equal-subset-sum
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * <p>
 * 注意:
 * 每个数组中的元素不会超过 100
 * 数组的大小不会超过 200
 * 示例 1:
 * <p>
 * 输入: [1, 5, 11, 5]
 * 输出: true
 * 解释: 数组可以分割成 [1, 5, 5] 和 [11].
 *  
 * 示例 2:
 * 输入: [1, 2, 3, 5]
 * <p>
 * 输出: false
 * 解释: 数组不能分割成两个元素和相等的子集.
 * <p>
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class PartitionEqualSubsetSum416 {
    @Test
    public void partitionEqualSubsetSumTest() {
        int[] nums = {1, 5, 11, 5};
        boolean result = canPartition(nums);
        System.out.println(result);
        Assert.assertEquals(result, true);
    }

    /**
     * 集合是否能分成相等两部分(找到和为整个数组和的一半)
     *
     * @param nums 数组
     * @return 布尔值
     */
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length < 1) {
            return true;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) {
            return false;
        }
        int target = sum / 2;
        int[] dp = new int[target + 1];
        for (int num : nums) {
            for (int i = target; i >= num; i--) {
                dp[i] = Math.max(dp[i], dp[i - num] + num);
                if (dp[i] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 集合是否能分成相等两部分
     *
     * @param nums 数组
     * @return 布尔值
     */
    public boolean canPartition2(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) {
            return false;
        }
        int target = sum / 2;
        return helper(nums, 0, target);
    }

    /**
     * 划分数组帮助类
     *
     * @param nums   数组
     * @param index  下标
     * @param target 目标值
     * @return 布尔值
     */
    private boolean helper(int[] nums, int index, int target) {
        if (target == 0) {
            return true;
        }
        if (index == nums.length || target < 0) {
            return false;
        }
        if (helper(nums, index + 1, target - nums[index])) {
            return true;
        }
        int j = index + 1;
        while (j < nums.length && nums[index] == nums[j]) {
            j++;
        }
        return helper(nums, j, target);
    }
    
    
    /**
     * 看一个数组是否能够拆分成相等的两半    
     */
    public boolean canPartition3(int[] nums) {
        if( nums == null || nums.length < 1) {
            return false;
        }
        int sum = 0;
        for(int num : nums) {
            sum += num;
        }
        if(sum % 2 == 1) {
            return false;
        }
        sum = sum / 2;
        int len = nums.length;
        boolean [][] dp = new boolean[len][sum + 1];
        // 初始化动态规划数组
        dp[0][0] = true;
        if(nums[0] <= sum) {
            dp[0][nums[0]] = true; 
        }
        for(int i = 1; i < len; i++) {
            for(int j = 0; j <= sum; j++) {
                int w = nums[i];
                if( j >= w) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1] [j - w];
                } else {
                    dp[i][j] = dp[i - 1][j]; 
                }
            }
        }
        return dp[len - 1][sum];
    }
    
    
    /**
     * 集合是否能分成相等两部分
     *
     * @param nums 数组
     * @return 布尔值
     */
    public boolean canPartition4(int[] nums) {
        if (nums == null || nums.length < 1) {
            return true;
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        // 如果不能被2整除，则直接返回false
        if (sum % 2 != 0) {
            return false;
        }
        int N = nums.length;
        int W = sum / 2;
        // 定义dp数组
        int[][] dp = new int[N + 1][W + 1];
        // 初始化数组
        for (int i = 0; i <= N; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j <= W; j++) {
            dp[0][j] = 0;
        }
        // 状态转移方程
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= W; j++) {
                int w = nums[i - 1];
                if (j < w) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w] + w);
                }
                if (dp[i][j] == W) {
                    return true;
                }
            }
        }
        return false;
    }
}
