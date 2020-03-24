package leetcodejava.dynamicprogramming;

import org.junit.Test;

import java.util.*;

/**
 * This is the solution of No.198 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/middle-of-the-linked-list/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,1]
 * 输出: 4
 * 解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 2:
 *
 * 输入: [2,7,9,3,1]
 * 输出: 12
 * 解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 *
 * 来源：力扣（LeetCode）
 ** ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class HouseRobber198 {
    @Test
    public void testHouseRobber() {
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
