package leetcode;

import org.junit.Test;

/**
 * 不用数组的方式，利用全局变量保存(找到的一种比较好的方法)
 *
 * @author zhangyu
 * @version V1.0
 * @ClassName: TargetSum
 * @Description: TOTO
 * @date 2018/11/24 20:59
 **/


public class TargetSum3 {
    int count = 0;
    @Test
    public void fun() {
        int[] nums = {1, 8, 9, 3, 4, 5, 7};
        int target = 17;
        int way = findTargetSumWays(nums, target);
        System.out.println(way);
    }

    public int findTargetSumWays(int[] nums, int S) {
        // int[] count = new int[1];
        dfs(nums, 0, 0, S);
        return count;
    }

    private void dfs(int[] nums, int sum, int index, int s) {
        if (index == nums.length) {
            if (sum == s) {
                count++;
            }
        } else {
            dfs(nums, sum + nums[index], index + 1, s);
            dfs(nums, sum - nums[index], index + 1, s);
        }
    }
}
