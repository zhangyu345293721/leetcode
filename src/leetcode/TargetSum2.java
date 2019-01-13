package leetcode;

import org.junit.Test;

/**
 * 用了基本的方法没有做出来，现在就要用深度优先算法来进行计算；(找到的一种比较好的方法)
 *
 * @author zhangyu
 * @version V1.0
 * @ClassName: TargetSum
 * @Description: TOTO
 * @date 2018/12/24 20:59
 **/


public class TargetSum2 {
    @Test
    public void fun() {
        int[] nums = {1, 8, 9, 3, 4, 5, 7};
        int target = 17;
        int way = findTargetSumWays(nums, target);
        System.out.println(way);
    }

    public int findTargetSumWays(int[] nums, int S) {
        int[] count = new int[1];
        dfs(nums, 0, 0,count, S);
        return count[0];
    }

    private void dfs(int[] nums, int sum, int index,int [] count,int target) {
        if (index == nums.length) {
            if (sum == target) {
                 count[0]++;
            }
        }else {
            dfs(nums, sum + nums[index], index + 1, count, target);
            dfs(nums, sum - nums[index], index + 1, count, target);
        }
    }
}
