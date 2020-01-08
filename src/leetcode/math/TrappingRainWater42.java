package leetcode.math;

import org.junit.Test;

/**
 * 找到凹槽能装多少水问题！
 *
 * @author zhangyu
 **/


public class TrappingRainWater42 {
    @Test
    public void testTrappingRainWater() {
        int arr[] = {1, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int maxWater = trappingRainWater(arr);
        System.out.println(maxWater);
    }

    /**
     * 装多少水
     *
     * @param arr 数组
     * @return 多少水
     */
    private int trappingRainWater(int[] arr) {
        if (arr == null || arr.length < 3) {
            return 0;
        }
        int result = 0;
        int size = arr.length;
        for (int i = 0; i < size - 1; i++) {
            int maxLeft = 0;
            int maxRight = 0;
            for (int j = i; j >= 0; j--) {
                maxLeft = Math.max(maxLeft, arr[j]);
            }
            for (int j = i; j < arr.length; j++) {
                maxRight = Math.max(maxRight, arr[j]);
            }
            result += Math.min(maxLeft, maxRight) - arr[i];
        }
        return result;
    }

    /**
     * 装多少水
     *
     * @param arr 数组
     * @return 多少水
     */
    private int trappingRainWater2(int[] arr) {
        if (arr == null || arr.length < 3) {
            return 0;
        }
        int result = 0;
        int left = 0;
        int right = arr.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        while (left < right) {
            if (arr[left] < arr[right]) {
                if (arr[left] > leftMax) {
                    leftMax = arr[left];
                } else {
                    result += leftMax - arr[left];
                }
                left++;
            } else {
                if (arr[right] < rightMax) {
                    rightMax = arr[rightMax];
                } else {
                    result += rightMax - arr[right];
                }
                right--;
            }
        }
        return result;
    }
}
