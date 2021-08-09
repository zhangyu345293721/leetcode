package leetcodejava.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * This is the solution of No. 977 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/squares-of-a-sorted-array
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 * <p>
 * 示例 1：
 * <p>
 * 输入：[-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 示例 2：
 * <p>
 * 输入：[-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 *  
 * 提示：
 * <p>
 * 1 <= A.length <= 10000
 * -10000 <= A[i] <= 10000
 * A 已按非递减顺序排序。
 * <p>
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class SquaresSortedArray977 {
    @Test
    public void squaresSortedArrayTest() {
        int[] nums = {-4, -1, 0, 3, 10};
        int[] sortedArray = sortedSquares2(nums);
        Assert.assertEquals(sortedArray.length, 5);
    }

    /**
     * 一个数组返回新数组
     *
     * @param nums 输入数组
     * @return 新数组
     */
    public int[] sortedSquares(int[] nums) {
        if (nums == null || nums.length < 1) {
            return null;
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }

    /**
     * 一个数组返回新数组(每次都找到一个最大值)
     *
     * @param nums 输入数组
     * @return 新数组
     */
    public int[] sortedSquares2(int[] nums) {
        if (nums == null || nums.length < 1) {
            return null;
        }
        int i = 0;
        int j = nums.length - 1;
        int[] result = new int[nums.length];
        int index = nums.length - 1;
        while (i <= j) {
            int left = nums[i] * nums[i];
            int right = nums[j] * nums[j];
            if (left > right) {
                result[index--] = left;
                i++;
            } else {
                result[index--] = right;
                j--;
            }
        }
        return result;
    }
}
