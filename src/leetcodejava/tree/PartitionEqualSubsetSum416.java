package leetcodejava.tree;

import org.junit.Test;

import java.util.Arrays;

/**
 * This is the solution of No.938 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/partition-equal-subset-sum
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 *
 * 注意:
 *
 * 每个数组中的元素不会超过 100
 * 数组的大小不会超过 200
 * 示例 1:
 *
 * 输入: [1, 5, 11, 5]
 *
 * 输出: true
 *
 * 解释: 数组可以分割成 [1, 5, 5] 和 [11].
 *  
 * 示例 2:
 *
 * 输入: [1, 2, 3, 5]
 *
 * 输出: false
 *
 * 解释: 数组不能分割成两个元素和相等的子集.
 *  
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-equal-subset-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class PartitionEqualSubsetSum416 {
    @Test
    public void testCapPartition() {
        int[] nums = {1, 5, 11, 5};
        boolean b = canPartition(nums);
        System.out.println(b);
    }

    /**
     * 判断数组是否能分成一半
     *
     * @param nums 数组
     * @return 布尔值
     */
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum & 1) == 1) {   //sum % 2 == 1
            return false;
        }
        sum /= 2; // sum=sum>>1;
        boolean[] dp = new boolean[sum + 1];
        Arrays.fill(dp, false);
        dp[0] = true;
        for (int num : nums) {
            for (int i = sum; i >= num; i--) {
                dp[i] = dp[i] || dp[i - num];
            }
        }
        return dp[sum];
    }
}