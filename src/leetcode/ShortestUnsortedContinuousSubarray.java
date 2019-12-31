package leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author zhangyu
 **/


public class ShortestUnsortedContinuousSubarray {
    @Test
    public void fun() {
        int[] nums = {1, 3, 2, 4, 5};
        int number = shortestUnsortedContinuousSubarray(nums);
        System.out.println(number);
    }

    private int shortestUnsortedContinuousSubarray(int[] nums) {
        // int[] newNums = Arrays.copyOfRange(nums, 0, nums.length);
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
