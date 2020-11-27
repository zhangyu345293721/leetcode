package leetcodejava.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * This is the solution of No. 832 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/flipping-an-image
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个二进制矩阵 A，我们想先水平翻转图像，然后反转图像并返回结果。
 * 水平翻转图片就是将图片的每一行都进行翻转，即逆序。例如，水平翻转 [1, 1, 0] 的结果是 [0, 1, 1]。
 * 反转图片的意思是图片中的 0 全部被 1 替换， 1 全部被 0 替换。例如，反转 [0, 1, 1] 的结果是 [1, 0, 0]。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [[1,1,0],[1,0,1],[0,0,0]]
 * 输出: [[1,0,0],[0,1,0],[1,1,1]]
 * 解释: 首先翻转每一行: [[0,1,1],[1,0,1],[0,0,0]]；
 * 然后反转图片: [[1,0,0],[0,1,0],[1,1,1]]
 * 示例 2:
 * <p>
 * 输入: [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
 * 输出: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 * 解释: 首先翻转每一行: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]]；
 * 然后反转图片: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 * 说明:
 * <p>
 * 1 <= A.length = A[0].length <= 20
 * 0 <= A[i][j] <= 1
 * <p>
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class FlippingImage832 {
    @Test
    public void flippingImageTest() {
        int[][] arr = {{1, 1, 0}, {1, 0, 1}, {0, 0, 0}};
        int[][] result = flipAndInvertImage(arr);
        Assert.assertEquals(result.length, 3);
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
