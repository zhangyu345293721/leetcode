package leetcode;

import org.junit.Test;

/**
 * @author zhangyu
 * @version V1.0
 * @ClassName: RotateImage
 * @Description: TOTO
 * @date 2018/12/13 11:29
 **/


public class RotateImage {
    @Test
    public void fun() {
        int[][] matrix =
                {
                        {1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}
                };
        rotate(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length < 1) {
            return;
        }

        // 先进行对称交换
        for (int i = 0; i < matrix.length ; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                swap(matrix, i, j, j, i);
            }
        }
       /*
        1  4  7
        2  5  8
        3  6  9
        */

        // 再中间进行变换
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length / 2; j++) {
                swap(matrix, i, j, i, matrix[0].length - j - 1);
            }
        }
       /*
        7  4  1
        8  5  2
        9  6  3
        */
    }
    //数组进行交换
    private void swap(int[][] nums, int x1, int y1, int x2, int y2) {
        int temp = nums[x1][y1];
        nums[x1][y1] = nums[x2][y2];
        nums[x2][y2] = temp;
    }
}
