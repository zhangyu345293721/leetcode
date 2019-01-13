package leetcode.dynamicprogramming;

import org.junit.Test;

import java.util.*;

/*
 * @author zhangyu
 * @version V1.0
 * @ClassName: HouseRobber1
 * @Description: 这是一个动态规划的考题，这种方式只是做出来其中的一种，里面还有别的做法
 * @date 2018/11/4 17:11
 */

public class HouseRobber1 {
    @Test
    public void fun() {
        //int[] nums = {1, 2, 3, 1};
        // int[] nums = {2, 7, 9, 3, 1};
        int[] nums = {1, 1, 1};
        int totalMoney = houseRobber(nums);
        System.out.println(totalMoney);
    }

    private int houseRobber(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int maxMoney = 0;
        int[] newArr = Arrays.copyOf(nums, nums.length);
        Arrays.sort(newArr);
        for (int i = nums.length - 1; i >= 0; i--) {
            int index = getMaxValueFirstIndex(nums, newArr[i]);
            if (index == 0) {
                if (nums[index + 1] != -1) {
                    maxMoney += nums[index];
                    nums[index] = -1;
                } else {
                    nums[index] = 0;
                }
            } else if (index == nums.length - 1) {
                if (nums[index - 1] != -1) {
                    maxMoney += nums[index];
                    nums[index] = -1;
                } else {
                    nums[index] = 0;
                }
            } else {
                if (nums[index - 1] != -1 && nums[index + 1] != -1) {
                    maxMoney += nums[index];
                    nums[index] = -1;
                } else {
                    nums[index] = 0;
                }
            }
        }
        return maxMoney;
    }

    // 找出最大值的下标
    private int getMaxValueFirstIndex(int[] nums, int max) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == max) {
                return i;
            }
        }
        return -1;
    }
}
