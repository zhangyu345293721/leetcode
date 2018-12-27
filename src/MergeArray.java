//package leetcode;

import org.junit.Test;
import java.util.Arrays;

/**
 * @author zhangyu
 * @version V1.0
 * @ClassName: MergeArray
 * @Description: TOTO
 * @date 2018/11/21 20:08
 **/

public class MergeArray {
    @Test
    public void fun() {
        int[] arr1 = {1, 3, 5, 7};
        int[] arr2 = {2, 4, 6, 8};
        int[] newArr = merge(arr1, arr2);
        for (int number : newArr) {
            System.out.print(number + " ");
        }
    }

    private int[] merge(int[] arr1, int[] arr2) {
        // 考虑临界值，当时题目不为空数组，所以不需要考虑这种情况
        if (arr1 == null || arr1.length == 0) {
            return arr2;
        }
        if (arr2 == null || arr2.length == 0) {
            return arr1;
        }
        int i = 0;
        int j = 0;
        int[] newArr = new int[arr1.length + arr2.length];
        int count = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                newArr[count] = arr1[i];
                if(i+1!=arr1.length){}
                i++;
                count++;
            }else if (arr1[i] == arr2[j]) {
                newArr[count] = arr1[i];
                i++;
                j++;
                count++;
            }else{
                newArr[count] = arr2[j];
                j++;
                count++;
            }
            // 当arr1的指针已经到了末尾,直接把arr2后面的数组添加到数组中
            if (i  == arr1.length) {
                for (int index = j; index < arr2.length; index++) {
                    newArr[count] = arr2[index];
                    count++;
                }
            }

            // 当arr2的指针已经为到末尾，直接将arr1中的数组添加到数组当中
            if (j == arr2.length) {
                for (int index = i; index < arr1.length; index++) {
                    newArr[count] = arr1[index];
                    count++;
                }
            }
        }
        return Arrays.copyOfRange(newArr, 0, count);
    }
}