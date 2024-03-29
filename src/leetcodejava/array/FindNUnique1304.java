package leetcodejava.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * This is the solution of No. 1304 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/find-n-unique-integers-sum-up-to-zero
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给你一个整数 n，请你返回 任意 一个由 n 个 各不相同 的整数组成的数组，并且这 n 个数相加和为 0 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 5
 * 输出：[-7,-1,1,3,4]
 * 解释：这些数组也是正确的 [-5,-1,1,2,3]，[-3,-1,2,-2,4]。
 * 示例 2：
 * <p>
 * 输入：n = 3
 * 输出：[-1,0,1]
 * 示例 3：
 * <p>
 * 输入：n = 1
 * 输出：[0]
 * <p>
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class FindNUnique1304 {
    @Test
    public void findUniqueTest() {
        int nums[] = sumZero(5);
        for (int num : nums) {
            System.out.print(num);
        }
        Assert.assertEquals(nums.length, 5);
    }

    /**
     * 返回总和为0的数组
     *
     * @param n n个数字
     * @return 总和为0的数组
     */
    public int[] sumZero(int n) {
        int[] nums = new int[n];
        int j = n - 1;
        for (int i = 0; i < (n / 2); i++) {
            nums[i] = i + 1;
            nums[j] = -nums[i];
            j--;
        }
        return nums;
    }
}
