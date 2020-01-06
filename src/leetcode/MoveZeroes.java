package leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * 循环这个方式没有很好的去控制，不能使用(没有想到更好的方法)
 *
 * @author zhangyu
 **/

public class MoveZeroes {
    @Test
    public void testMoveZeroes() {
        int[] nums = {0, 0, 1};
        moveZeroes2(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 移动数组这种效率比较低，不应该去使用，而且循环也不好去控制
     *
     * @param nums 数组
     */
    private void moveZeroes2(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                for (int j = i; j < nums.length - 1; j++) {
                    nums[j] = nums[j + 1];
                }
                nums[nums.length - 1] = 0;
            } else {
                i++;
            }
        }
    }

    /**
     * 移动数组这种效率比较低，不应该去使用，而且循环也不好去控制
     *
     * @param nums 数组
     */
    private void moveZeroes(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }
        for (int j = index; j < nums.length; j++) {
            nums[j] = 0;
        }
    }

    /**
     * 交换位置
     *
     * @param nums 数组
     */
    private void moveZeroes3(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            if (nums[i] != 0) {
                i++;
            } else if (nums[j] == 0) {
                j--;
            } else {
                swap(nums, i, j);
                i++;
                j--;
            }
        }
    }

    /**
     * 移动数组这种效率比较低，不应该去使用，而且循环也不好去控制
     *
     * @param nums
     */
    private void moveZeroes4(int[] nums) {
        int i = 0, j = 0;
        int n = nums.length;
        while (i < n && j < n) {
            while (i < n && nums[i] == 0) {
                i++;
            }
            if (i < n && j < n) {
                if (i != j) {
                    swap(nums, i, j);
                }
                i++;
                j++;
            }
        }
    }

    /**
     * 交换数组两个数字的位置
     *
     * @param nums 数组
     * @param i    位置1
     * @param j    位置2
     */
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
