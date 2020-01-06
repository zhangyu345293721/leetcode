package leetcode.math;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author zhangyu
 **/


public class ProductArrayExceptSelf {
    @Test
    public void testProductArrayExceptSelf() {
        int[] nums = {1, 2, 3, 4};
        int[] newArrs = productArrayExceptSelf2(nums);
        System.out.println(Arrays.toString(newArrs));
    }

    private int[] productArrayExceptSelf(int[] nums) {
        int[] newArr = new int[nums.length];
        int productNumber = 1;
        int zeroCount = 0;
        for (int num : nums) {
            if (num == 0) {
                zeroCount++;
            }
        }
        if (zeroCount == 0) {
            for (int num : nums) {
                productNumber = productNumber * num;
            }
            for (int i = 0; i < nums.length; i++) {
                newArr[i] = productNumber / nums[i];
            }
        }
        if (zeroCount == 1) {
            int temp = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    productNumber = productNumber * nums[i];
                } else {
                    temp = i;
                }
            }
            newArr[temp] = productNumber;
        }
        return newArr;
    }

    private int[] productArrayExceptSelf2(int[] nums) {
        int val = 1;
        int len = nums.length;
        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            result[i] = val;
            val *= nums[i];
        }
        val = 1;
        for (int i = len - 1; i >= 0; i--) {
            result[i] *= val;
            val *= nums[i];
        }
        return result;
    }
}
