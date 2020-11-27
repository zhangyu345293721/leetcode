package leetcodejava.array;

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
        boolean b = canPartition2(nums);
        System.out.println(b);
    }

    /**
     * 集合是否能分成相等两部分
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
        dp[0] = true;
        for (int num : nums) {
            for (int i = sum; i >= num; i--) {
                if (i >= num) {
                    dp[i] = dp[i] || dp[i - num];
                }
            }
        }
        return dp[sum];
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
        sum /= 2; // sum=sum>>1;
        return helper(nums, 0, sum);
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
        // 1,1，1，100
        int j = index + 1;
        while (j < nums.length && nums[index] == nums[j]) {
            j++;
        }
        return helper(nums, j, target);
    }
}