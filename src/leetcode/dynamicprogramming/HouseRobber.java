package leetcode.dynamicprogramming;

import org.junit.Test;

import java.util.*;

/**
 * @author zhangyu
 */

public class HouseRobber {
    @Test
    public void fun() {
        int[] nums = {1, 1, 1};
        int totalMoney = houseRobber(nums);
        System.out.println(totalMoney);
    }

    /**
     * 求总共钱数
     *
     * @param nums 数组
     * @return 钱数
     */
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

    /**
     * 找出最大值的下标
     *
     * @param nums 数组
     * @param max  最大值
     * @return 下标位置
     */
    private int getMaxValueFirstIndex(int[] nums, int max) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == max) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 求总共钱数
     *
     * @param nums 数组
     * @return 钱数
     */
    private int houseRobber2(int[] nums) {
        // 当数组长度为0,直接返回0
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // 定义一个数组的大小
        int len = nums.length;
        int i = 2;
        if (len == 1) {
            return nums[0];
        }
        int[] f = new int[len];
        f[0] = nums[0];
        f[1] = Math.max(f[0], nums[1]);
        for (; i < len; i++) {
            f[i] = Math.max(f[i - 1], f[i - 2] + nums[i]);
        }
        return f[i - 1];
    }

    /**
     * 求总共钱数
     *
     * @param nums 数组
     * @return 钱数
     */
    private int houseRobber3(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }
        if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int dp[] = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[n - 1];
    }

    /**
     * 求总共钱数
     *
     * @param nums 数组
     * @return 钱数
     */
    private int houseRobber4(int[] nums) {
        int preMax = 0, max = 0;
        for (int num : nums) {
            int temp = Math.max(preMax + num, max);
            preMax = max;
            max = temp;
        }
        return max;
    }
}
