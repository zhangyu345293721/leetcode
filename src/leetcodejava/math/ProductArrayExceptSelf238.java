package leetcodejava.math;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * This is the solution of No.238 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/product-of-array-except-self
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3,4]
 * 输出: [24,12,8,6]
 *  
 * <p>
 * 提示：题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）的乘积都在 32 位整数范围内。
 * <p>
 * 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 * <p>
 * 进阶：
 * 你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/product-of-array-except-self
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class ProductArrayExceptSelf238 {
    @Test
    public void productArrayExceptSelfTest() {
        int[] nums = {1, 2, 3, 4};
        int[] result = productArrayExceptSelf2(nums);
        System.out.println(Arrays.toString(result));
        Assert.assertEquals(result[0], 24);
    }

    /**
     * @param nums 数组
     * @return 新数组
     */
    private int[] productArrayExceptSelf(int[] nums) {
        int[] newArr = new int[nums.length];
        int productNumber = 1;
        int zeroCount = 0;
        for (int num : nums) {
            if (num == 0) {
                zeroCount++;
            }
        }
        if (zeroCount == 0) {
            for (int num : nums) {
                productNumber = productNumber * num;
            }
            for (int i = 0; i < nums.length; i++) {
                newArr[i] = productNumber / nums[i];
            }
        }
        if (zeroCount == 1) {
            int index = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    productNumber = productNumber * nums[i];
                } else {
                    index = i;
                }
            }
            newArr[index] = productNumber;
        }
        return newArr;
    }

    /**
     * @param nums 数组
     * @return 新数组
     */
    private int[] productArrayExceptSelf2(int[] nums) {
        int val = 1;
        int len = nums.length;
        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            result[i] = val;
            val *= nums[i];
        }
        val = 1;
        for (int i = len - 1; i >= 0; i--) {
            result[i] *= val;
            val *= nums[i];
        }
        return result;
    }
}
