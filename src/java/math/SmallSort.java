package java.math;

import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author zhangyu
 **/


public class SmallSort {
    @Test
    public void fun() {
        int[] nums = {0, 1, 7, 1, 1, 2, 2, 1, 2, 1, 3, 3, 5, 3, 2, 3, 4, 5, 1, 0, 5, 3, 2, 3, 4};
        arraySort5(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 数组自然排序
     *
     * @param nums 数组
     * @return 排序数组
     */
    private int[] arraySort1(int[] nums) {
        Arrays.sort(nums);
        return nums;
    }

    /**
     * 数组自然排序
     *
     * @param nums 数组
     * @return 排序数组
     */
    private int[] arraySort2(int[] nums) {
        PriorityQueue<Integer> priorityQueues = new PriorityQueue();
        for (int num : nums) {
            priorityQueues.add(num);
        }
        int[] arrNums = new int[nums.length];
        int index = 0;
        while (index < nums.length) {
            arrNums[index] = priorityQueues.poll();
            index++;
        }
        return arrNums;
    }

    /**
     * 数组冒泡排序
     *
     * @param nums 数组
     * @return 排序数组
     */
    private int[] arraySort3(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                }
            }
        }
        return nums;
    }

    /**
     * 简单选择排序
     *
     * @param nums 数组
     * @return 排序数组
     */
    private int[] arraySort4(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    swap(nums, i, j);
                }
            }
        }
        return nums;
    }

    /**
     * 交换字符串的位置
     *
     * @param nums 数组
     * @param i    位置i
     * @param j    位置j
     */
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * 数组排序
     *
     * @param nums 数组
     */
    private void arraySort5(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int left = 0, right = nums.length - 1;
        int i = 0;
        while (i <= right) {
            if (nums[i] == 0) {
                swap(nums, left, i);
                left++;
                i++;
            } else if (nums[i] == 1) {
                i++;
            } else {
                swap(nums, right, i);
                right--;
            }
            PriorityQueue priorityQueue = new PriorityQueue();
        }
    }
}
