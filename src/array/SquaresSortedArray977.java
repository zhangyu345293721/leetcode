package array;

import org.junit.Test;

import java.util.Arrays;

/**
 * 顺序的排序
 *
 * @author: zhangyu
 */
public class SquaresSortedArray977 {
    @Test
    public void fun() {
        int[] arr = {-4, -1, 0, 3, 10};
        int[] sortedArray = sortedSquares(arr);
        for (int i : sortedArray) {
            System.out.print(i + " ");
        }
    }

    /**
     * 一个数组返回新数组
     *
     * @param arr 输入数组
     * @return 新数组
     */
    public int[] sortedSquares(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] * arr[i];
        }
        Arrays.sort(arr);
        return arr;
    }
}
