package leetcodejava.math;

import org.junit.Assert;
import org.junit.Test;

/**
 * This is the solution of No.494 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/target-sum
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。
 * <p>
 * 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums: [1, 1, 1, 1, 1], S: 3
 * 输出: 5
 * 解释:
 * <p>
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/target-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class TargetSum494 {
    @Test
    public void targetSumTest() {
        int[] nums = {1, 8, 9, 3, 4, 5, 7};
        int target = 20;
        int result = findTargetSumWays(nums, target);
        Assert.assertEquals(result, 0);
    }

    int count = 0;

    /**
     * @param nums 数组
     * @param S    数字
     * @return 目标值
     */
    public int findTargetSumWays(int[] nums, int S) {
        dfs(nums, 0, 0, S);
        return count;
    }

    /**
     * 深度优先遍历
     *
     * @param nums   数组
     * @param sum    数值和
     * @param index  下标
     * @param target 目标值
     */
    private void dfs(int[] nums, int sum, int index, int target) {
        if (index == nums.length) {
            if (sum == target) {
                count++;
            }
        } else {
            dfs(nums, sum + nums[index], index + 1, target);
            dfs(nums, sum - nums[index], index + 1, target);
        }
    }
}
