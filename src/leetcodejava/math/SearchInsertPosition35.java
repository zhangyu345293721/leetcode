package leetcodejava.math;

import org.junit.Test;

/**
 * This is the solution of No.35 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/search-insert-position
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 你可以假设数组中无重复元素。
 *
 * 示例 1:
 *
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 *
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 *
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 *
 * 输入: [1,3,5,6], 0
 * 输出: 0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-insert-position
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class SearchInsertPosition35 {
    @Test
    public void searchIndexTest() {
        int[] arr = {1, 2, 4, 6, 7, 8, 10};
        int key = 9;
        int index = searchIndex1(arr, key);
        System.out.println(index);
    }


    /**
     * 二分查找的变种形式，插着一个数在数组中的位置
     *
     * @param nums   数组
     * @param target 目标
     * @return 返回下标
     */
    private static int searchIndex1(int[] nums, int target) {
        if (nums == null) {
            return 0;
        }
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            int middle = i + (j - i) / 2;
            if (nums[middle] > target) {
                j = middle - 1;
            } else if (nums[middle] < target) {
                if (nums[middle + 1] >= target) {
                    return middle + 1;
                } else {
                    i = middle + 1;
                }
            } else {
                return middle;
            }
        }
        if (nums[j] < target) {
            return j + 1;
        }
        return -1;
    }

    /**
     * 寻找下标
     *
     * @param nums   数组
     * @param target 目标
     * @return 返回下标
     */
    private static int searchIndex2(int[] nums, int target) {
        if (nums == null) {
            return 0;
        }
        if (nums[nums.length - 1] < target) {
            return nums.length;
        }
        if (nums[0] >= target) {
            return 0;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < target && nums[i + 1] >= target) {
                return i + 1;
            }
        }
        return -1;
    }
}
