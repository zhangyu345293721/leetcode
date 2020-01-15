package leetcodejava.math;

import org.junit.Test;

public class TrapWater42 {

    @Test
    public void testTrapWater() {
        int[] nums = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int containsWater = trappingRainWater2(nums);
        System.out.println(containsWater);
    }

    /**
     * 找能装的水
     *
     * @param nums 数组
     * @return 容量水
     */
    private int trappingRainWater(int[] nums) {
        int lmax = 0;
        int rmax = 0;
        int left = 0;
        int right = nums.length - 1;
        int totalWater = 0;
        while (left < right) {
            if (nums[left] < nums[right]) {
                lmax = Math.max(lmax, nums[left]);
                totalWater += (lmax - nums[left]);
                left++;
            } else {
                // 找出右边最大的一个数
                rmax = Math.max(rmax, nums[right]);
                totalWater += (rmax - nums[right]);
                right--;
            }
        }
        return totalWater;
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

}
