package leetcodejava.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;


/**
 * This is the solution of No.300 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/longest-increasing-subsequence
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 * <p>
 * 示例:
 * <p>
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * 说明:
 * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 * 你算法的时间复杂度应该为 O(n2) 。
 * <p>
 * 来源：力扣（LeetCode）
 * * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class LongestIncreasingSubsequence300 {
    @Test
    public void longestIncreasingSubsequenceTest() {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        int result = lengthOfLIS2(nums);
        System.out.println(result);
        Assert.assertEquals(result, 4);
    }

    /**
     * 最大增数组
     *
     * @param nums 数字
     * @return 增数组个数
     */
    private int lengthOfLIS1(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            int i = Arrays.binarySearch(dp, 0, len, num);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = num;
            if (i + 1 > len) {
                len = i + 1;
            }
        }
        return len;
    }


    /**
     * 最大增数组
     *
     * @param nums 数字
     * @return 增数组个数
     */
    private int lengthOfLIS2(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int len = nums.length;
        int[] dp = new int[len];
        for (int i = 0; i < len; i++) {
            dp[i] = 1;
        }
        int maxLen = 1;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                maxLen = Math.max(maxLen, dp[i]);
            }
        }
        return maxLen;
    }
}
