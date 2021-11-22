package leetcodejava.math;

import org.junit.Assert;
import org.junit.Test;

/**
 * This is the solution of No.33 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * <p>
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * <p>
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * <p>
 * 你可以假设数组中不存在重复的元素。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 示例 2:
 * <p>
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class RotatedSortedArray33 {
    @Test
    public void rotatedSortedArrayTest() {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int result = rotatedSortedArray2(nums, 0);
        System.out.println(result);
        Assert.assertEquals(result, 4);
    }

    /**
     * 旋转有序数组
     *
     * @param nums 数组
     * @param key  关键字
     * @return 关键字
     */
    private int rotatedSortedArray(int[] nums, int key) {
        if (nums == null || nums.length < 1) {
            return -1;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == key) {
                return key;
            }
        }
        return -1;
    }

    /**
     * 旋转有序数组
     *
     * @param nums   数组
     * @param target 关键字
     * @return 关键字
     */
    private int rotatedSortedArray2(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    /**
     * 旋转有序数组
     *
     * @param nums   数组
     * @param target 关键字
     * @return 关键字
     */
    private int rotatedSortedArray3(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[left] <= nums[mid]) {  //left side sorted
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
