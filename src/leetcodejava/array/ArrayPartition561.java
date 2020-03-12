package leetcodejava.array;

import org.junit.Test;

import java.util.Arrays;

/**
 * This is the solution of No. 561 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/array-partition-i/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 *给定长度为 2n 的数组, 你的任务是将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得从1 到 n 的 min(ai, bi) 总和最大。
 *
 * 示例 1:
 * 输入: [1,4,3,2]
 *
 * 输出: 4
 * 解释: n 等于 2, 最大总和为 4 = min(1, 2) + min(3, 4).
 *
 * 来源：力扣（LeetCode）
 ** ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class ArrayPartition561 {

    @Test
    public void testArrayPartion() {
        int nums[] = {1, 2, 3, 4};
        int sum = arrayPairSum(nums);
        System.out.println(sum);
    }

    /**
     * 计算数组中一部分的和
     *
     * @param nums 数组
     * @return 计算和
     */
    public int arrayPairSum(int[] nums) {
        int sum = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i += 2) {
            int min = Math.min(nums[i], nums[i + 1]);
            sum += min;
        }
        return sum;
    }
}
