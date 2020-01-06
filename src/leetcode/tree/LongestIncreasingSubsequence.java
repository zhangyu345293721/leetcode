package leetcode.tree;

import org.junit.Test;

import java.util.Arrays;

/**
 * 最大最小问题，想到动态规划
 *
 * @author zhangyu
 **/

public class LongestIncreasingSubsequence {
    @Test
    public void testLongestIncreasingSubsequence() {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        int length = longestIncreasingSubsequence(nums);
        System.out.println(length);
    }

    /**
     * 获取最大增加字符串
     *
     * @param nums 最长增加字符串
     * @return 最大联系长度
     */
    private int longestIncreasingSubsequence(int[] nums) {
        int maxLength = 0;
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            int temp = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > temp) {
                    count++;
                    temp = nums[j];
                } else {
                    temp = nums[i];
                }
            }
            if (maxLength < count) {
                maxLength = count + 1;
            }
        }
        return maxLength;
    }

    /**
     * 获取最大增加字符串
     *
     * @param nums 最长增加字符串
     * @return 最大联系长度
     */
    private int longestIncreasingSubsequence2(int[] nums) {
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
}
