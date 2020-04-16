package leetcodejava.array;

import org.junit.Test;

/**
 * This is the solution of No. 27 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/remove-element
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 *
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * 示例 1:
 *
 * 给定 nums = [3,2,2,3], val = 3,
 * 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
 * 你不需要考虑数组中超出新长度后面的元素。
 * 示例 2:
 *
 * 给定 nums = [0,1,2,2,3,0,4,2], val = 2,
 * 函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
 * 注意这五个元素可为任意顺序。
 * 你不需要考虑数组中超出新长度后面的元素。
 *
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class RemoveElement27 {
    @Test
    public void testRemoveElement() {
        int[] arr = {0, 1, 2, 2, 3, 0, 4, 2};
        int val = 2;
        int leftNumber = removeElement2(arr, val);

        System.out.println(leftNumber);
    }

    /**
     * 删除数组后的数量
     *
     * @param nums 数组
     * @param val  元素
     * @return 最后数量
     */
    public int removeElement(int[] nums, int val) {
        int count = 0;
        for (int num : nums) {
            if (val == num) {
                count++;
            }
        }
        return nums.length - count;
    }

    /**
     * 删除数组后的数量
     *
     * @param nums 数组
     * @param val  元素
     * @return 最后数量
     */
    public int removeElement2(int[] nums, int val) {
        int index = 0;
        for (int num : nums) {
            if (val != num) {
                nums[index++] = num;
            }
        }
        return index;
    }
}

