package java.math;

import org.junit.Test;

/**
 * 对矩阵进行旋转
 *
 * @author zhangyu
 **/


public class RotateImage48 {
    @Test
    public void testRotateImage() {
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

    /**
     * 矩阵位置交换
     *
     * @param matrix 矩阵
     */
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length < 1) {
            return;
        }
        // 先进行对称交换
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                swap(matrix, i, j, j, i);
            }
        }
        // 再中间进行变换
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length / 2; j++) {
                swap(matrix, i, j, i, matrix[0].length - j - 1);
            }
        }
    }

    /**
     * 数组位置进行交换
     *
     * @param nums 数组
     * @param x1   位置x1
     * @param y1   位置y1
     * @param x2   位置x2
     * @param y2   位置y2
     */
    private void swap(int[][] nums, int x1, int y1, int x2, int y2) {
        int temp = nums[x1][y1];
        nums[x1][y1] = nums[x2][y2];
        nums[x2][y2] = temp;
    }
}
