package leetcodejava.dp;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

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
        int result = minPathSum2(grid);
        System.out.println(result);
        Assert.assertEquals(result, 7);
    }

    /**
     * 最小路径和
     *
     * @param grid 二维数组
     * @return 最小路径和
     */
    public int minPathSum1(int[][] grid) {
        if (grid == null || grid.length < 1) {
            return 0;
        }
        int m = grid.length, n = grid[0].length;
        // 初始化数组
        for (int i = 1; i < m; i++) {
            grid[i][0] += grid[i - 1][0];
        }
        for (int j = 1; j < n; j++) {
            grid[0][j] += grid[0][j - 1];
        }
        // 状态转移方程
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
    public int minPathSum2(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int rows = grid.length, cols = grid[0].length;
        return minPathSumDfs(rows - 1, cols - 1, grid);
    }

    /**
     * 最小路径和
     *
     * @param grid 二维数组
     * @return 最小路径和
     */
    public int minPathSum3(int[][] grid) {
        if (grid == null || grid.length < 1) {
            return 0;
        }
        // 定义数组
        int[] dp = new int[grid[0].length];
        // 初始化数组
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        // 状态转移
        for (int i = 0; i < grid.length; i++) {
            dp[0] = dp[0] + grid[i][0];
            for (int j = 1; j < grid[i].length; j++) {
                dp[j] = Math.min(dp[j - 1], dp[j]) + grid[i][j];
            }
        }
        return dp[grid[0].length - 1];
    }

    private int minValue = Integer.MAX_VALUE;

    /**
     * 最小路径和
     *
     * @param grid 二维数组
     * @return 最小路径和
     */
    public int minPathSum4(int[][] grid) {
        if (grid == null || grid.length < 1) {
            return 0;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        searchHelper(visited, grid, 0, 0, 0);
        return minValue;
    }

    /**
     * 深度优先遍历
     *
     * @param visited 是否访问
     * @param grid    二维数组
     * @param i       位置i
     * @param j       位置j
     * @param sum     值sum
     */
    public void searchHelper(boolean[][] visited, int[][] grid, int i, int j, int sum) {
        int rows = grid.length;
        int cols = grid[0].length;
        // 递归结束条件1、到达右下角的位置
        if (i == rows - 1 && j == cols - 1) {
            minValue = Math.min(minValue, sum + grid[i][j]);
            return;
        }
        // 递归结束条件2、数组越界或者到达已经遍历过的数组位置
        if (i < 0 || i > rows - 1 || j < 0 || j > cols - 1 || visited[i][j] == true) {
            return;
        }
        visited[i][j] = true;
        sum += grid[i][j];
        searchHelper(visited, grid, i + 1, j, sum);// 向下递归
        searchHelper(visited, grid, i, j + 1, sum);// 向右递归
        // 进行回退
        sum -= grid[i][j];
        visited[i][j] = false;
    }

    /**
     * 最小路径dfs操作
     *
     * @param i    行i
     * @param j    列j
     * @param grid 二维数组
     * @return 最小值
     */
    private int minPathSumDfs(int i, int j, int[][] grid) {
        if (i < 0 || j < 0) {
            return Integer.MAX_VALUE;
        }
        if (i == 0 && j == 0) {
            return grid[i][j];
        }
        return grid[i][j] + Math.min(minPathSumDfs(i - 1, j, grid), minPathSumDfs(i, j - 1, grid));
    }
}
