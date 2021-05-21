package leetcodejava.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * This is the solution of No.209 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/minimum-size-subarray-sum
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * <p>
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 * 示例 2：
 * <p>
 * 输入：target = 4, nums = [1,4,4]
 * 输出：1
 * 示例 3：
 * <p>
 * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 * 输出：0
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-size-subarray-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class MinimumSizeSubarraySum209 {

    @Test
    public void minimumSizeSubarraySumTest() {
        int target = 7;
        int[] nums = {2, 3, 1, 2, 4, 3};
        int result = minSubArrayLen(target, nums);
        System.out.println(result);
        Assert.assertEquals(result, 2);
    }

    /**
     * 最小和数组长度
     *
     * @param target 目标值
     * @param nums   数组
     * @return 长度
     */
    public int minSubArrayLen(int target, int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int total = 0;
        int res = Integer.MAX_VALUE;
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            total += nums[j];
            while (total >= target) {
                res = Math.min(j - i + 1, res);
                total -= nums[i++];
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
