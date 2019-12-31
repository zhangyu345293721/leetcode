package leetcode;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 用了基本的方法没有做出来，现在就要用深度优先算法来进行计算；
 *
 * @author zhangyu
 **/


public class TargetSum {
    @Test
    public void fun() {
        int[] nums = {1, 8, 9, 3, 4, 5, 7};
        int target = 20;
        LinkedList queue = new LinkedList();
        int way = findTargetSumWays(nums, target);
        System.out.println(way);
    }

    /**
     * @param nums 数组
     * @param S    s
     * @return 目标值
     */
    public int findTargetSumWays(int[] nums, int S) {
        int max = compute(nums, "+");
        int min = compute(nums, "-");
        if (S > max || S < min) {
            return 0;
        }
        return -1;
    }

    private int compute(int[] nums, String operator) {
        int sum = 0;
        if ("+".equals(operator)) {
            for (int i : nums) {
                sum = sum + i;
            }
        }
        if ("-".equals(operator)) {
            for (int i : nums) {
                sum = sum + i;
            }
        }
        return sum;
    }

    /**
     * @param nums 数组
     * @param S    s
     * @return 目标值
     */
    public int findTargetSumWays2(int[] nums, int S) {
        int[] count = new int[1];
        dfs(nums, 0, 0, count, S);
        return count[0];
    }

    /**
     * 深度优先遍历
     */
    private void dfs(int[] nums, int sum, int index, int[] count, int target) {
        if (index == nums.length) {
            if (sum == target) {
                count[0]++;
            }
        } else {
            dfs(nums, sum + nums[index], index + 1, count, target);
            dfs(nums, sum - nums[index], index + 1, count, target);
        }
    }
}
