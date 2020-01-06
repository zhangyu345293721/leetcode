package leetcode.select;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 活动窗口
 *
 * @author zhangyu
 **/


public class SlidingWindowMaximum {

    @Test
    public void testSlidingWindowMaximum() {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int key = 3;
        List<Integer> arr = slidingWindowMaximum(nums, key);
        System.out.println(arr);
    }

    /**
     * 最大活动窗口
     *
     * @param nums 数组
     * @param key  关键字
     * @return list
     */
    private List<Integer> slidingWindowMaximum(int[] nums, int key) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length - key + 1; i++) {
            int temp = i + key;
            int j = i;
            int max = Integer.MIN_VALUE;
            while (j < temp && temp <= nums.length) {
                if (nums[j] > max) {
                    max = nums[j];
                }
                j++;
            }
            list.add(max);
        }
        return list;
    }


    /**
     * @param nums 数组
     * @param key  关键字
     * @return list
     */
    private int[] slidingWindowMaximum2(int[] nums, int key) {
        if (nums.length < 1) {
            return new int[0];
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length - key + 1; i++) {
            int temp = i + key;
            int j = i;
            int max = Integer.MIN_VALUE;
            while (j < temp && temp <= nums.length) {
                if (nums[j] > max) {
                    max = nums[j];
                }
                j++;
            }
            list.add(max);
        }
        // 把链表变成数组
        int[] arr = new int[list.size()];
        int index = 0;
        for (int num : list) {
            arr[index] = num;
            index++;
        }
        return arr;
    }
}
