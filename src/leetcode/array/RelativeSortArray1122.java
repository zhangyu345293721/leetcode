package leetcode.array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 相对排序位置
 *
 * @author: zhangyu
 */
public class RelativeSortArray1122 {
    @Test
    public void testRelativeSortArray() {
        int[] arr1 = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] arr2 = {2, 1, 4, 3, 9, 6};
        int[] arr = relativeSortArray(arr1, arr2);
        for (Integer num : arr) {
            System.out.print(num + " ");
        }
    }

    /**
     * 两个数组相对位置排序
     *
     * @param arr1 数组1
     * @param arr2 数组2
     * @return 排序后的位置
     */
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        if (arr1 == null || arr1.length < 1 || arr2 == null || arr2.length < 1) {
            return new int[0];
        }
        int[] arr = new int[arr1.length];
        int index = 0;
        for (int num2 : arr2) {
            for (int num1 : arr1) {
                if (num1 == num2) {
                    arr[index++] = num2;
                }
            }
        }
        List<Integer> leftList = getDifferenceSet(arr1, arr2);
        // 自然排序
        Collections.sort(leftList);
        for (Integer num : leftList) {
            arr[index++] = num;
        }
        return arr;
    }

    /**
     * 数组取差集的逻辑
     *
     * @param arr1 数组1
     * @param arr2 数组2
     * @return list
     */
    private List<Integer> getDifferenceSet(int[] arr1, int[] arr2) {
        List<Integer> leftList = new ArrayList<>();
        for (int num1 : arr1) {
            boolean flag = true;
            for (int num2 : arr2) {
                if (num1 == num2) {
                    flag = false;
                }
            }
            if (flag) {
                leftList.add(num1);
            }
        }
        return leftList;
    }
}
