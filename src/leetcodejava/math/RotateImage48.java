package leetcodejava.math;

import org.junit.Assert;
import org.junit.Test;

/**
 * This is the solution of No.48 problem in the LeetCode,
 * the website of the problem is asm follow:
 * https://leetcode-cn.com/problems/rotate-image/
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个 n × n 的二维矩阵表示一个图像。
 * 将图像顺时针旋转 90 度。
 * 说明：
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 * <p>
 * 示例 1:
 * 给定 matrix =
 * [
 * [1,2,3],
 * [4,5,6],
 * [7,8,9]
 * ],
 * 原地旋转输入矩阵，使其变为:
 * [
 * [7,4,1],
 * [8,5,2],
 * [9,6,3]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class RotateImage48 {
    @Test
    public void rotateImageTest() {
        int[][] matrix =
                {
                        {1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}
                };
        rotate(matrix);
        Assert.assertArrayEquals(matrix[0], new int[]{7, 4, 1});
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
        int n = matrix.length;
        // 先进行对称交换   右上 - 左下
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                swap(matrix, i, j, j, i);
            }
        }
        // 再每行对列进行对称变换
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                swap(matrix, i, j, i, n - j - 1);
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
