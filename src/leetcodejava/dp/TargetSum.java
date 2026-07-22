package leetcodejava.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * This is the solution of No.xxx problem in the LeetCode,
 * the website of the problem is as follow:
 *
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个正整数数组 nums，请将它分割成两个子集，使得这两个子集的元素之和的差值最小。返回这两个子集的和
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class TargetSum {
    @Test
    public void targetSumTest() {
        int[] nums = {2, 3, 4, 6, 9};
        int num = targetSum(nums);
        Assert.assertEquals(num, 0);
    }
    
    public  int targetSum(int[] nums) {
        if(nums == null || nums.length < 1) {
            return 0;
        }
        int sum = 0;
        for(int num : nums) {
            sum += num;
        }
        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for(int num : nums) {
            for(int j = target; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }
        int partSum = -1;
        // find max value
        for(int j = target; j >= 0; j--) {
            if(dp[target]) {
                partSum = j;
                break;
            }
        }
        return partSum;
    }

    public  int targetSum2(int[] nums) {
        if(nums == null || nums.length < 1) {
            return 0;
        }
        int sum = 0;
        for(int num : nums) {
            sum += num;
        }
        int len = nums.length;
        int target = sum / 2;
        boolean[][] dp = new boolean[len + 1][target + 1];
        dp[0][0] = true;
        for(int i = 1; i <= len; i++) {
            int w = nums[i - 1];
            for(int j = 1; j <= target; j++) {
                if(j >= w) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - w];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        // find max value
        for(int j = target; j >= 0; j--) {
            if(dp[len][j]) {
                return j;
            }
        }
        return -1;
    }
        int gap = Integer.MAX_VALUE;

    public int targetSum3(int[] nums) {
        if(nums == null || nums.length < 1) {
            return 0;
        }
        int sum = 0;
        for(int num : nums) {
            sum += num;
        }
        searchHelper(nums, 0, 0, sum);
        return sum / 2 - gap;
    }

    public void searchHelper(int[] nums, int index, int current, int sum) {
        // 剪枝操作
        if(current > sum / 2) {
            return;
        }
        // 剪枝操作
        if(index > nums.length) {
            return;
        }
        if(index == nums.length) {
            gap = Math.min(gap, Math.abs(current - (sum - current)));
        }
        // add nums[index]，并且回退操作
        searchHelper(nums, index + 1, current + nums[index], sum);
        // no add nums[index]
        searchHelper(nums, index + 1, current, sum);
    }
}
