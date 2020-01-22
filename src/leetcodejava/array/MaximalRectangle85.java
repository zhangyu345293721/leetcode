package leetcodejava.array;

import org.junit.Test;

import java.util.Arrays;

/**
 * 最大长方形
 *
 * @author: zhangyu
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
        if (matrix == null || matrix.length == 0)
            return 0;
        int res = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] height = new int[n];
        Arrays.fill(right, n);
        for (int i = 0; i < m; i++) {
            int curleft = 0, curright = n;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1')
                    height[j]++;
                else
                    height[j] = 0;
            }
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    left[j] = Math.max(left[j], curleft);
                } else {
                    left[j] = 0;
                    curleft = j + 1;
                }
            }
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    right[j] = Math.min(right[j], curright);
                } else {
                    right[j] = n;
                    curright = j;
                }
            }
            for (int j = 0; j < n; j++) {
                res = Math.max(res, (right[j] - left[j]) * height[j]);
            }
        }
        return res;
    }
}
