package leetcode;

import org.junit.Test;

/**
 * @author zhangyu
 * @version V1.0
 * @ClassName: TrappingRainWater1
 * @Description: 找到凹槽能装多少水问题！（brute force）暴力算法
 * @date 2019/1/18
 **/


public class TrappingRainWater1 {
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
        int size = arr.length;
        for (int i = 0; i < size - 1; i++) {
            int maxLeft = 0;
            int maxRight = 0;
            // 找出i前面的最大的一个数
            for (int j = i; j >= 0; j--) {
                maxLeft = Math.max(maxLeft, arr[j]);
            }
            // 找出i后面最大那个数
            for (int j = i; j < arr.length; j++) {
                maxRight = Math.max(maxRight, arr[j]);
            }
            // tarp就是他们直接的最小数和i的差
            result += Math.min(maxLeft, maxRight) - arr[i];
        }
        return result;
    }
}
