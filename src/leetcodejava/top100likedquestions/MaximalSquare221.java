package leetcodejava.top100likedquestions;

import org.junit.Test;

/**
 * This is the solution of No.221 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/maximal-square/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 *
 * 示例:
 * 输入:
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 *
 * 输出: 4
 *
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class MaximalSquare221 {

    @Test
    public void testMaximalSquare() {
        char[][] chs =
                {{'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
                };
        int num = maximalSquare(chs);
        System.out.println(num);
    }

    /**
     * 获取最大正方形
     *
     * @param matrix 二维数组
     * @return 正方形边个数
     */
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int max = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int temp = getMaxSquare(matrix, i, j);
                if (max < temp) {
                    max = temp;
                }
            }
        }
        return max;
    }

    /**
     * 获取最大正方形
     *
     * @param matrix   二维数组
     * @param rowIndex 行号
     * @param colIndex 列号
     * @return
     */
    int getMaxSquare(char[][] matrix, int rowIndex, int colIndex) {
        int row = matrix.length;
        int col = matrix[0].length;
        if (matrix[rowIndex][colIndex] == '0') {
            return 0;
        }
        int length = 1;
        int maxSize = Math.min(row - rowIndex, col - colIndex);
        for (int size = 1; size < maxSize; size++) {
            for (int i = rowIndex; i <= rowIndex + size; i++) {
                int newCol = colIndex + size;
                if (matrix[i][newCol] == '0') {
                    return length * length;
                }
            }
            for (int j = colIndex; j <= colIndex + size; j++) {
                int newRow = rowIndex + size;
                if (matrix[newRow][j] == '0') {
                    return length * length;
                }
            }
            length++;
        }
        return length * length;
    }
}
