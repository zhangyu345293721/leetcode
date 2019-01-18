package leetcode;

import org.junit.Test;

/**
 * @author zhangyu
 * @version V2.0
 * @ClassName: TrappingRainWater1
 * @Description: 找到凹槽能装多少水问题！采用效率非常高一种算法，双向指针！
 * @date 2019/1/18
 **/


public class TrappingRainWater2 {
    @Test
    public void fun() {
        int arr[] = {1, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int maxWater = trappingRainWater(arr);
        System.out.println(maxWater);
    }

    private int trappingRainWater(int[] arr) {
        // 如果数组长度小于3，就返回0
        if (arr == null || arr.length < 3) {
            return 0;
        }
        int result = 0;
        int left = 0;
        int right = arr.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        // 两边双指针，它们各自向中间压缩
        while (left < right) {
            // 如果左边小于右边就从左边开始
            if (arr[left] < arr[right]) {
                if (arr[left] > leftMax) {
                    leftMax = arr[left];
                } else {
                    result += leftMax - arr[left];
                }
                // 指针＋1
                left++;
            } else {
                if (arr[right] < rightMax) {
                    rightMax = arr[rightMax];
                } else {
                    result += rightMax - arr[right];
                }
                // 指针-1
                right--;
            }
        }
        return result;
    }
}

