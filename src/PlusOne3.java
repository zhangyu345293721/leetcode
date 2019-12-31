// package leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * 对数字进行加1操作
 *
 * @author zhangyu
 **/


public class PlusOne3 {
    @Test
    public void fun() {
        int[] digits = {8, 9, 9, 9};
        int[] newArr = getPlusOne(digits);
        System.out.println(Arrays.toString(newArr));
    }

    private int[] getPlusOne(int[] digits) {
        int flag = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
                flag = 1;
            } else {
                digits[i] = digits[i] + 1;
                flag = 0;
                break;
            }
        }
        if (flag == 1) {
            int[] newArr = new int[digits.length + 1];
            newArr[0] = 1;
            return newArr;
        }
        return digits;
    }
}
