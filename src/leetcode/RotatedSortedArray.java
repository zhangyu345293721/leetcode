package leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author zhangyu
 * @version V1.0
 * @ClassName: RotatedSortedArray
 * @Description: TOTO
 * @date 2018/12/17 19:00
 **/


public class RotatedSortedArray {
    @Test
    public void fun() {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int index = rotatedSortedArray2(nums, 0);
        System.out.println(index);
    }

    private int rotatedSortedArray(int[] nums, int key) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == key) {
                return key;
            }
        }
        return -1;
    }

    private int rotatedSortedArray2(int[] nums,int target){
        int left = 0, right = nums.length-1;
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
