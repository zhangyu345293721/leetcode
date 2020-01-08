package leetcode.java.math;// package leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * 加1操作
 *
 * @author zhangyu
 **/


public class PlusOne {

    @Test
    public void testPlusOne() {
        int[] digits = {3, 2, 1, 4};
        int[] newArr = getPlusOne(digits);
        System.out.println(Arrays.toString(newArr));
    }


    /**
     * 把数组变成数字
     *
     * @param digits 数字数组
     * @return 数组
     */
    private int[] getPlusOne(int[] digits) {
        Arrays.sort(digits);
        int sum = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            sum = sum * 10 + digits[i];
        }
        sum = sum + 1;
        int length = getNumberLength(sum);
        int[] newArr = new int[length];
        int index = 0;
        while (sum != 0) {
            newArr[index] = sum % 10;
            sum = sum / 10;
            index++;
        }
        reverseArray(newArr);
        return newArr;
    }


    /**
     * 获取数字的长度
     *
     * @param num 数字
     * @return 数字长度
     */
    private int getNumberLength(int num) {
        int length = 0;
        while (num != 0) {
            num = num / 10;
            length++;
        }
        return length;
    }

    /**
     * 翻转数组
     *
     * @param arr 数组
     */
    private void reverseArray(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
    }
}
