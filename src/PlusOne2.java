//package leetcode;
import org.junit.Test;
import java.util.Arrays;

/**
 * 数字加1
 * @author zhangyu
 **/


public class PlusOne2 {
    @Test
    public void fun() {
        int[] digits = {3, 2, 1, 4};
        int[] newArr = getPlusOne(digits);
        System.out.println(Arrays.toString(newArr));
    }

    private int[] getPlusOne(int[] digits) {
        int sum = 0;
        for (int i = 0; i <= digits.length-1; i++) {
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

    private int getNumberLength(int num) {
        int length = 0;
        while (num != 0) {
            num = num / 10;
            length++;
        }
        return length;
    }
    private void reverseArray(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
    }
}
