package leetcode.question;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author zhangyu
 * @version V1.0
 * @ClassName: LongestIncreasingSubsequence
 * @Description: TOTO
 * @date 2018/11/28 21:04
 **/

// 凡是最小最大问题，最先考虑动态规划
public class LongestIncreasingSubsequence2 {
    @Test
    public void fun() {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        int length = lengthOfLIS(nums);
        System.out.println(length);
    }

    private int lengthOfLIS(int[] nums) {
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
