package leetcodejava.top100likedquestions;

import org.junit.Assert;
import org.junit.Test;

/**
 * This is the solution of No.64 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/minimum-path-sum/
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步。
 * <p>
 * 示例:
 * 输入:
 * [
 * [1,3,1],
 * [1,5,1],
 * [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 * <p>
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class MinimumPathSum64 {

    @Test
    public void minimumPathSumTest() {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        int result = minPathSum3(grid);
        Assert.assertEquals(result, 7);
    }

    /**
     * 最小路径和
     *
     * @param grid 二维数组
     * @return 最小路径和
     */
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if (i == 0) {
                    grid[0][j] += grid[0][j - 1];
                } else if (j == 0) {
                    grid[i][0] += grid[i - 1][0];
                } else {
                    grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
                }
            }
        }
        return grid[m - 1][n - 1];
    }

    /**
     * 最小路径和
     *
     * @param grid 二维数组
     * @return 最小路径和
     */
    public int minPathSum2(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int i = 1; i < m; i++) {
            grid[i][0] += grid[i - 1][0];
        }
        for (int j = 1; j < n; j++) {
            grid[0][j] += grid[0][j - 1];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        return grid[m - 1][n - 1];
    }


    /**
     * 最小路径和
     *
     * @param grid 二维数组
     * @return 最小路径和
     */
    public int minPathSum3(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int rows = grid.length, cols = grid[0].length;
        return minPathSumDfs(rows - 1, cols - 1, new Integer[rows][cols], grid);
    }

    /**
     * 最小路径dfs操作
     *
     * @param i      行
     * @param j      列
     * @param result 缓存数组
     * @param grid   二维数组
     * @return 最小值
     */
    private int minPathSumDfs(int i, int j, Integer[][] result, int[][] grid) {
        if (i < 0 || j < 0) {
            return Integer.MAX_VALUE;
        }
        if (i == 0 && j == 0) {
            return grid[i][j];
        }
        if (result[i][j] != null) {
            return result[i][j];
        }
        int sum = Math.min(minPathSumDfs(i - 1, j, result, grid), minPathSumDfs(i, j - 1, result, grid));
        result[i][j] = sum + grid[i][j];
        return result[i][j];
    }
}
