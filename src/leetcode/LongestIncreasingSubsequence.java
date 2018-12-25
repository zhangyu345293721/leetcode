package leetcode;

import org.junit.Test;

/**
 * @author zhangyu
 * @version V1.0
 * @ClassName: LongestIncreasingSubsequence
 * @Description: TOTO
 * @date 2018/12/12 21:04
 **/

// 凡事最小最大问题，都考考虑动态规划
public class LongestIncreasingSubsequence {
    @Test
    public void fun() {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        int length = longestIncreasingSubsequence(nums);
        System.out.println(length);
    }

    private int longestIncreasingSubsequence(int[] nums) {
        int maxLength = 0;
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            int temp = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                // temp=nums[j];
                if (nums[j] > temp) {
                    count++;
                    temp = nums[j];
                }else{
                    temp=nums[i];
                }
            }
            if (maxLength < count) {
                maxLength = count+1;
            }
        }
        return maxLength;
    }
}
