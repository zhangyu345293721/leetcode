package leetcode.dynamicprogramming;

import org.junit.Test;

/*
 * @author zhangyu
 * @version V1.0
 * @ClassName: HouseRobber1
 * @Description: 这是一个动态规划的考题，这种方式只是做出来其中的一种，里面还有别的做法
 * @date 2018/12/4 17:11
 */

public class HouseRobber3 {
    @Test
    public void fun() {
        //int[] nums = {1, 2, 3, 1};
        // int[] nums = {2, 7, 9, 3, 1};
        int[] nums = {1, 1, 1};
        int totalMoney = houseRobber(nums);
        System.out.println(totalMoney);
    }

    private int houseRobber(int[] nums) {
        int n = nums.length;
        // 当数组长度为0，返回0
        if (n == 0) {
            return 0;
        }
        // 当数组长度为1，返回第一个数
        if (n == 1) {
            return nums[0];
        }
        // 当数组长度为2,返回
        if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }
        // 设置动态数组
        int dp[] = new int[n];
        // dp[0] 为动态数组的第一个数，为nums[0]
        dp[0] = nums[0];
        // dp[1]为max中最大的那个
        dp[1]=Math.max(nums[0],nums[1]);
        // 然后循环判断dp[i]等于dp[i-1]与dp[i-2]+nums[i]的最大值
        for(int i=2;i<n;i++){
            dp[i]=Math.max(dp[i-1], dp[i-2]+nums[i]);
        }
        //然后返回最大值，有n个数组返回n-1的值
        return dp[n-1];
    }
}
