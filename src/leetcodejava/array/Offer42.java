package leetcodejava.array;


import org.junit.Assert;
import org.junit.Test;

/**
 * This is the solution of No. offer.42 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.cn/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 *输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 *
 *
 *要求时间复杂度为O(n)。
 *
 *示例1:
 *
 *输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 *输出: 6
 *解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class Offer42 {
    @Test
    public void offerTest() {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int result = maxSubArray(nums);
        System.out.println(result);
        Assert.assertEquals(result, 6);
    }

    /**
     * 最大连续子串和
     *
     * @param nums 数组
     * @return 最大值
     */
     public int maxSubArray(int[] nums) {
        if(nums == null || nums.length < 1) {
            return 0;
        }
        int sum = 0;
        int result = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++) {
            if(sum <= 0) {
                sum = 0;
            }
            sum += nums[i];
            result = Math.max(result, sum);
        }
        return result;
    }  
}
