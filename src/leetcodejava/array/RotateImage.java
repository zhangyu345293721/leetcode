package leetcodejava.array;

import org.junit.Test;

/**
 * This is the solution of No. 01.07 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/rotate-matrix-lcci
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给你一幅由 N × N 矩阵表示的图像，其中每个像素的大小为 4 字节。请你设计一种算法，将图像旋转 90 度。
 *
 * 不占用额外内存空间能否做到？
 * 示例 1:
 *
 * 给定 matrix =
 * [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
 *
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
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
