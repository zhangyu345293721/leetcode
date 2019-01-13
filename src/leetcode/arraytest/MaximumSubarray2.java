package leetcode.arraytest;

import org.junit.Test;

/**
 * @author zhangyu
 * @version V1.0
 * @ClassName: MaximumSubarray
 * @Description:
 * @date 2018/11/7 9:41
 **/


public class MaximumSubarray2 {
    @Test
    public void fun() {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int maxNum = maximumSubarray(nums);
        System.out.println(maxNum);
    }

    //这种比较直接，又通俗易懂的方式
    private int maximumSubarray(int[] nums) {
        int max = nums[0], sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum < 0) {
                sum = nums[i];
            } else {
                sum += nums[i];
            }
            if (sum > max) {
                max = sum;
            }
        }
        return max;
    }
}
