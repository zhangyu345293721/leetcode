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
    }

    /**
     * 按照要求旋转二维数组
     *
     * @param matrix 二维数组
     */
    public void rotate(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        for (int i = 0; i < r / 2; i++) {
            for (int j = 0; j < c; j++) {
                int temp = matrix[r - 1 - i][j];
                matrix[r - 1 - i][j] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (i > j) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }
    }
}
