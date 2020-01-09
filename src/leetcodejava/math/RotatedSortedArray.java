package leetcodejava.math;

import org.junit.Test;

/**
 * 旋转数组
 *
 * @author zhangyu
 **/


public class RotatedSortedArray {
    @Test
    public void testRotatedSortedArray() {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int index = rotatedSortedArray2(nums, 0);
        System.out.println(index);
    }

    /**
     * 旋转有序数组
     *
     * @param nums 数组
     * @param key  关键字
     * @return 关键字
     */
    private int rotatedSortedArray(int[] nums, int key) {
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
     * @param nums 数组
     * @param target  关键字
     * @return 关键字
     */
    private int rotatedSortedArray2(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
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
}
