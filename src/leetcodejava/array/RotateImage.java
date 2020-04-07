package leetcodejava.array;

import org.junit.Test;

/**
 * @author: zhangyu
 */
public class RotateImage {
    @Test
    public void testRotateImage() {
        int[][] matrix =
                {
                        {1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}
                };
        rotate(matrix);
        System.out.println(matrix);
    }

    /**
     * 按照要求旋转二维数组
     *
     * @param matrix 二维数组
     */
    public void rotate(int[][] matrix) {
        int r = matrix.length;
        // 上下翻转
        for (int i = 0; i < r / 2; i++) {
            for (int j = 0; j < r; j++) {
                int temp = matrix[r - 1 - i][j];
                matrix[r - 1 - i][j] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
        // 对角线翻转
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < i; j++) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
            }
        }
    }
}
