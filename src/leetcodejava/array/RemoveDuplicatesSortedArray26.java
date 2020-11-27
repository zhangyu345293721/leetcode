package leetcodejava.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * This is the solution of No. 26 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * 示例 1:
 * <p>
 * 给定数组 nums = [1,1,2],
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 * 你不需要考虑数组中超出新长度后面的元素。
 * 示例 2:
 * <p>
 * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
 * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 * 你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class RemoveDuplicatesSortedArray26 {
    @Test
    public void removeDuplicatesSortedArrayTest() {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int length = getLength(nums);
        Assert.assertEquals(length, 5);
    }

    /**
     * 获取数组的长度
     *
     * @param nums 有序数组
     * @return 长度
     */
    private int getLength(int[] nums) {
        int count = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[count] != nums[j]) {
                nums[++count] = nums[j];
            }
        }
        return count + 1;
    }
}