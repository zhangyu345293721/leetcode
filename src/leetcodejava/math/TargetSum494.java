package leetcodejava.math;

import org.junit.Test;

import java.util.LinkedList;

/**
 * This is the solution of No.494 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/target-sum
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。
 *
 * 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
 *
 * 示例 1:
 *
 * 输入: nums: [1, 1, 1, 1, 1], S: 3
 * 输出: 5
 * 解释:
 *
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/target-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class TargetSum494 {
    @Test
    public void testTargetSum() {
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

    /**
     * 计算字符
     *
     * @param nums     数组
     * @param operator 操作符
     * @return 数字
     */
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
     * @param S    数字
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
