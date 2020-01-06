package leetcode.select;

import org.junit.Test;

import java.util.Arrays;

/**
 * 最短无序连续字子字符串
 *
 * @author zhangyu
 **/


public class ShortestUnsortedContinuousSubarray {
    @Test
    public void fun() {
        int[] nums = {1, 3, 2, 4, 5};
        int number = shortestUnsortedContinuousSubarray(nums);
        System.out.println(number);
    }

    /**
     * 最短无序连续子数组
     *
     * @param nums 数组
     * @return 数字
     */
    private int shortestUnsortedContinuousSubarray(int[] nums) {
        int[] newNums = nums.clone();
        Arrays.sort(newNums);
        int number = 0;
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            if (nums[i] == newNums[i]) {
                i++;
            } else if (nums[j] == newNums[j]) {
                j--;
            } else if (i == j) {
                return 0;
            } else {
                return j - i + 1;
            }
        }
        return number;
    }
}
