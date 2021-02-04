package leetcodejava.math;

import org.junit.Assert;
import org.junit.Test;

/**
 * This is the solution of No. 445 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/powx-n
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 137. 只出现一次的数字 II
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。
 * <p>
 * 说明：
 * <p>
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,2,3,2]
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: [0,1,0,1,0,1,99]
 * 输出: 99
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class SingleNumber137 {

    @Test
    public void singleNumberTest() {
        int[] arr = {2, 2, 3, 2};
        int result = singleNumber(arr);
        System.out.println(result);
        Assert.assertEquals(result, 3);
    }

    /**
     * 找出单一出现的元素
     *
     * @param nums 数组nums
     * @return 单一出现的元素
     */
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                count += (nums[j] >> i) & 1;
            }
            result |= ((count % 3) << i);
        }
        return result;
    }

    /**
     * 找出单一出现的元素
     *
     * @param nums 数组nums
     * @return 单一出现的元素
     */
    public int singleNumber2(int[] nums) {
        int a = 0, b = 0;
        for (int x : nums) {
            b = (b ^ x) & ~a;
            a = (a ^ x) & ~b;
        }
        return b;
    }

    /**
     * 找出单一出现的元素
     *
     * @param nums 数组nums
     * @return 单一出现的元素
     */
    public int singleNumber3(int[] nums) {
        int a = 0, b = 0;
        for (int x : nums) {
            b = (b ^ x) & ~a;
            a = (a ^ x) & ~b;
        }
        return b;
    }
}
