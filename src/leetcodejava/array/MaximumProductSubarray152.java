package leetcodejava.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * This is the solution of No. 152 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/maximum-product-subarray
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字）。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 示例 2:
 * <p>
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 * <p>
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class MaximumProductSubarray152 {

    @Test
    public void maximumProductSubarrayTest() {
        int[] nums = {2, 3, -2, 4};
        int result = maxProduct2(nums);
        System.out.println(result);
        Assert.assertEquals(result, 6);
    }

    /**
     * 最大子数组乘积
     *
     * @param nums 数组
     * @return 最大乘积
     */
    private int maxProduct1(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int length = nums.length;
        int maxProduct = Integer.MIN_VALUE;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                int product = multiply(nums, i, j);
                maxProduct = Math.max(maxProduct, product);
            }
        }
        return maxProduct;
    }

    /**
     * 数组相乘
     *
     * @param nums 数组
     * @param i    位置i
     * @param j    位置j
     * @return 最大值
     */
    private int multiply(int[] nums, int i, int j) {
        if (nums == null && nums.length < 1) {
            return 0;
        }
        int total = 1;
        for (int k = i; k <= j; k++) {
            total *= nums[k];
        }
        return total;
    }

    /**
     * 最大连续子数组乘积
     *
     * @param nums 数组
     * @return 最大乘积
     */
    private int maxProduct2(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int max = nums[0];
        int min = nums[0];
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int temp = max;
            max = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]);
            min = Math.min(Math.min(temp * nums[i], min * nums[i]), nums[i]);
            if (max > result) {
                result = max;
            }
        }
        return result;
    }

    /**
     * 最大子数组乘积
     *
     * @param nums 数组
     * @return 最大乘积
     */
    public int maxProduct3(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int maxResult = Integer.MIN_VALUE, imax = 1, imin = 1;
        for (int num : nums) {
            if (num < 0) {
                int tmp = imax;
                imax = imin;
                imin = tmp;
            }
            imax = Math.max(imax * num, num);
            imin = Math.min(imin * num, num);
            // 记录最大值
            maxResult = Math.max(maxResult, imax);
        }
        return maxResult;
    }

    /**
     * 最大子数组乘积
     *
     * @param nums 数组
     * @return 最大乘积
     */
    public int maxProduct4(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int result = nums[0];
        //两个mDP分别定义为以i结尾的子数组的最大积与最小积
        int[] maxDP = new int[nums.length];
        int[] minDP = new int[nums.length];
        //初始化DP
        maxDP[0] = nums[0];
        minDP[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // 最大积的可能情况有：元素i自己本身，上一个最大积与i元素累乘，上一个最小积与i元素累乘；
            // 与i元素自己进行比较是为了处理i元素之前全都是0的情况
            maxDP[i] = max3(nums[i], maxDP[i - 1] * nums[i], minDP[i - 1] * nums[i]);
            minDP[i] = min3(nums[i], maxDP[i - 1] * nums[i], minDP[i - 1] * nums[i]);
            //记录result
            result = Math.max(result, maxDP[i]);
        }
        return result;
    }

    /**
     * 找出三个数的最大值
     *
     * @param a 数a
     * @param b 数b
     * @param c 数c
     * @return 最大值
     */
    private int max3(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    /**
     * 找出三个数的最小值
     *
     * @param a 数a
     * @param b 数b
     * @param c 数c
     * @return 最小值
     */
    private int min3(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}
