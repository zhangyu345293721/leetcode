package java.array;

import org.junit.Test;

/**
 * 翻转图片
 *
 * @author: zhangyu
 */
public class FlippingImage832 {
    @Test
    public void testFlippingImage() {
        int[][] arr = {{1, 1, 0}, {1, 0, 1}, {0, 0, 0}};
        flipAndInvertImage(arr);
        System.out.println();
    }

    /**
     * @param A 二维数组
     * @return 左右翻转，再求异或
     */
    public int[][] flipAndInvertImage(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            reverseArr(A[i]);
        }
        return A;
    }

    /**
     * 一个数组翻转
     *
     * @param arr 数组
     */
    private void reverseArr(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] ^= 1;
        }
    }

    /**
     * 交换两个元素的位置
     *
     * @param arr   数组
     * @param start 开始位置
     * @param end   结束位置
     */
    private void swap(int[] arr, int start, int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }
}
