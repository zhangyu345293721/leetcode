package leetcode.math;

import org.junit.Test;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

/**
 * 利用treeset进行存储，不用直接去重
 *
 * @author zhangyu
 **/

public class MergeArray {
    @Test
    public void fun() {
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {-1, 2, 3, 4, 5, 6, 7};
        int[] newArr = merge(arr1, arr2);
        for (int number : newArr) {
            System.out.print(number + " ");
        }
    }

    /**
     * 计算机数组合并之后的新数组
     *
     * @param arr1 数组1
     * @param arr2 数组2
     * @return 合并后的数组
     */
    private int[] merge(int[] arr1, int[] arr2) {
        if (arr1 == null || arr1.length == 0) {
            return arr2;
        }
        if (arr2 == null || arr2.length == 0) {
            return arr1;
        }
        Set<Integer> set = new TreeSet();
        for (int arrNnum1 : arr1) {
            set.add(arrNnum1);
        }
        for (int arrNum2 : arr2) {
            set.add(arrNum2);
        }
        int[] newArr = new int[set.size()];
        int count = 0;
        for (int number : set) {
            newArr[count] = number;
            count++;
        }
        return newArr;
    }

    /**
     * 合并数组
     *
     * @param arr1 数组1
     * @param arr2 数组2
     * @return 数组
     */
    private int[] merge2(int[] arr1, int[] arr2) {

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
                i++;
                count++;
            } else if (arr1[i] == arr2[j]) {
                newArr[count] = arr1[i];
                i++;
                j++;
                count++;
            } else {
                newArr[count] = arr2[j];
                j++;
                count++;
            }
            // 当arr1的指针已经到了末尾,直接把arr2后面的数组添加到数组中
            if (i == arr1.length) {
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
