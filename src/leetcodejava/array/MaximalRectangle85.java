package leetcodejava.array;

import org.junit.Test;

import java.util.Arrays;

/**
 * This is the solution of No. 85 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/maximal-rectangle
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 *
 * 示例:
 *
 * 输入:
 * [
 *   ["1","0","1","0","0"],
 *   ["1","0","1","1","1"],
 *   ["1","1","1","1","1"],
 *   ["1","0","0","1","0"]
 * ]
 * 输出: 6
 *
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class MaximalRectangle85 {

    @Test
    public void testMaximalRectangle() {

        char[][] chs = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        int sum = maximalRectangle(chs);
        System.out.println(sum);
    }

    /**
     * 计算最大矩形
     *
     * @param matrix 二维数组
     * @return 矩形
     */
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int result = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] height = new int[n];
        Arrays.fill(right, n);
        for (int i = 0; i < m; i++) {
            int curLeft = 0, curRight = n;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    height[j]++;
                } else {
                    height[j] = 0;
                }
            }
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    left[j] = Math.max(left[j], curLeft);
                } else {
                    left[j] = 0;
                    curLeft = j + 1;
                }
            }
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    right[j] = Math.min(right[j], curRight);
                } else {
                    right[j] = n;
                    curRight = j;
                }
            }
            for (int j = 0; j < n; j++) {
                result = Math.max(result, (right[j] - left[j]) * height[j]);
            }
        }
        return result;
    }
}
